package droidsafe.analyses.attr;

import com.google.common.base.Throwables;

import droidsafe.analyses.attr.ModeledClass;
import droidsafe.analyses.GeoPTA;

import droidsafe.android.app.Harness;
import droidsafe.android.app.Project;

import droidsafe.main.Config;

import droidsafe.speclang.Method;

import droidsafe.transforms.AddAllocsForAPICalls;

import droidsafe.utils.SootUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.lang.reflect.Constructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.AssignStmt;
import soot.jimple.Constant;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.NullConstant;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;

import soot.RefType;

import soot.Scene;

import soot.SootClass;

import soot.SootMethod;

import soot.tagkit.LineNumberTag;
import soot.tagkit.SourceFileTag;

import soot.Type;

import soot.Unit;

import soot.util.Chain;

import soot.Value;

/**
 * Models certain Android objects such as Intents, Strings, and Uris so that we better understand the way they are built 
 * up and used.
 *
 * We don't want to present the analyst with the built up of each like we do now, but instead each at the time of its 
 * use with as much Context as possible (this might help shorten the spec a little bit). For example, for an Intent i, 
 * we should tell the analyst which View or Uri will be started when StartActivity(i) is called and let them decide 
 * whether its malware or not.
 *
 * We are assuming that in general, each is used simply and once.
 * 
 * @author mgordon, dpetters
 *
 */
public class AttributeModeling {

    //=================================================================================================================
    // Private Attributes
    //=================================================================================================================


    /** Singleton for analysis */
    private static AttributeModeling am;

    /** AllocNode keys are the objects that we can and want to model. The value is the Model object which simulates that 
     * object. */
    private Map<AllocNode, ModeledClass> objectToModelMap; 

    /** Map to store Values to attributes of Models */
    private Map<Value, Object> valueToModelAttrMap;

    /** Set of methods we simulated and thus don't want to step through */
    private Set<SootMethod> simulatedMethods;

    /** FileWriter used to log what we still don't model but perhaps should */
    private FileWriter attrModelingTodoLog;

    /** Source location of current statement */
    private String sourceLocation;

    /** Generic logger */
    private static final Logger logger = LoggerFactory.getLogger(AttributeModeling.class);

    /** The prefix that is prepended to fully qualified types in the src of the model */
    public static final String PACKAGE_PREFIX = "droidsafe.analyses.attr.models.";

    /** The directory relative from APAC_HOME that is the base of the modeling source code for this abstract semantics 
     * */
    public static final String MODEL_SRC_BASE_DIR = "src/main/java/droidsafe.analyses.attr.models.";

    /** The directory relative from APAC_HOME that is the base of the modeling class files for this abstract semantics 
     * */
    public static final String MODEL_CLASS_BASE_DIR = "classes/main/droidsafe.analyses.attr.models.";

    //===================================================================================================================
    // Constructors
    //===================================================================================================================

    /** Private constructor to enforce singleton pattern */
    private AttributeModeling() {
        this.objectToModelMap = new LinkedHashMap<AllocNode, ModeledClass>();
        this.valueToModelAttrMap = new HashMap<Value, Object>();
        this.simulatedMethods = new HashSet<SootMethod>();

        try {
            this.attrModelingTodoLog = new FileWriter(Project.v().getOutputDir() + File.separator + 
                    "attribute-modeling-todos.log");
        } catch (Exception e) {
            logger.warn("Unable to record attribute modeling errors.", e);
        }
    }

    //===================================================================================================================
    // Static Methods
    //===================================================================================================================

    /** access to the singleton instance */
    public static AttributeModeling v() {
        return am;
    }

    /** Calculate the caretesian product of a list of sets */
    private static Set<ArrayList<Object>> cartesianProduct(int index, ArrayList<HashSet<Object>> sets) {
        HashSet<ArrayList<Object>> ret = new HashSet<ArrayList<Object>>();
        if (index == sets.size()) {
            ret.add(new ArrayList<Object>());
        } else {
            for (Object obj : sets.get(index)) {
                for (ArrayList<Object> set : cartesianProduct(index+1, sets)) {
                    set.add(0, obj);
                    ret.add(set);
                }
            }  } return ret;
    }

    /** run the analysis to fixed point */
    public static void run() {
        // Run the analysis once to figure out which methods we are able to simulate, discarding results afterwards.
        runOnce();
        am.objectToModelMap = new LinkedHashMap<AllocNode, ModeledClass>();
        am.valueToModelAttrMap = new HashMap<Value, Object>();
        // Now run the analysis to fixed point, not stepping through the methods that we simulate.
        int oldValueToModelAttrMapSize;
        do {
            oldValueToModelAttrMapSize = am.valueToModelAttrMap.size();
            runOnce();
        } while(oldValueToModelAttrMapSize != am.valueToModelAttrMap.size());
        // Run one more time so that modeled methods get to use the right values
        runOnce();
        runOnce();
        runOnce();
        // log the results and statistics    
        am.log();
    }

    /** run the full analysis once */ 
    public static void runOnce() {
        if (GeoPTA.v() == null) {
            logger.error("The GeoPTA pass has not been run. Attribute modeling / requires it.");
            System.exit(1);
        }      if (am == null)
        am = new AttributeModeling();

        Set<SootMethod> reachableMethods = GeoPTA.v().getAllReachableMethods();

        // loop over all code, creating models and simulating whichever invokeExprs we can as we go
        for (SootClass clazz : Scene.v().getApplicationClasses()) {
            String className = clazz.getName();
            // We don't care about the harness or interfaces
            if (clazz.isInterface() || className.equals(Harness.HARNESS_CLASS_NAME))
                continue;

            // DroidSafeCalls will go away eventually and we don't want to look at it for now 
            if(className.equals("edu.mit.csail.droidsafe.DroidSafeCalls")){
                continue;
            }

            // Get source filename that contains the class 
            SourceFileTag sourceFileTag = (SourceFileTag)clazz.getTag("SourceFileTag");

            for (SootMethod meth : clazz.getMethods()) {
                if (meth.isConcrete() && reachableMethods.contains(meth) && !am.simulatedMethods.contains(meth)) {
                    StmtBody stmtBody = (StmtBody)meth.retrieveActiveBody();

                    // get body's unit as a chain
                    Chain units = stmtBody.getUnits();

                    Iterator stmtIt = units.snapshotIterator();

                    ParamAnalyzer paramAnalyzer;

                    while (stmtIt.hasNext()) {
                        Stmt stmt = (Stmt)stmtIt.next();
                        Unit unit = (Unit)stmt;

                        // Get source line number of statement
                        LineNumberTag lineNumTag = (LineNumberTag)unit.getTag("LineNumberTag");

                        // Combine the source filename and line number
                        if (sourceFileTag != null && lineNumTag != null) {
                            am.sourceLocation = " called at " + sourceFileTag + ":" + lineNumTag;
                        } else {
                            am.sourceLocation = "";
                        }

                        if (!stmt.containsInvokeExpr()) {
                            continue;
                        }
                        InvokeExpr invokeExpr = (InvokeExpr)stmt.getInvokeExpr();
                        paramAnalyzer = am.new ParamAnalyzer(invokeExpr);

                        // Compute cartesian product of params, creating models as we do so.  If we can't model 
                        // something, we
                        // invalidate any param models that we created for this method already and return null
                        Set<ArrayList<Object>> paramObjectCartesianProduct = paramAnalyzer.getParamCartesianProduct();

                        // Store the class of each param for later invoke simulation
                        ArrayList<Class> paramClasses = paramAnalyzer.getParamClasses();

                        ArrayList<Object> returnedObjects = new ArrayList<Object>();

                        if (invokeExpr instanceof InstanceInvokeExpr){
                            InstanceInvokeExpr iie = (InstanceInvokeExpr)invokeExpr;
                            // get all the receivers and the models for them if we can model a receiver and have the 
                            // cartesian product of params, simulate the call if we can model a receiver but don't have 
                            // the cartesian product, then invalidate the receiver
                            for (AllocNode node : GeoPTA.v().getPTSetContextIns(iie.getBase())) {
                                ModeledClass modeledReceiverObject = am.createAndGetModel(node);
                                if(modeledReceiverObject != null) {
                                    if(paramObjectCartesianProduct != null){
                                        // simulateInvokeExprEffects will simulate the call for each param permutation 
                                        // in paramObjectCartesianProduct
                                        returnedObjects = am.simulateInvokeExprEffects(modeledReceiverObject, 
                                                modeledReceiverObject.getClass(), invokeExpr, 
                                                paramObjectCartesianProduct, paramClasses);
                                    } else {
                                        // We couldn't model one of the arguments so we can't simulate the call and have 
                                        // to invalidate the receiver
                                        modeledReceiverObject.invalidate();
                                        am.logError("Couldn't model every parameter for " + iie + am.sourceLocation + 
                                                "\n" + "> invalidating " + modeledReceiverObject + " as a result");
                                    }
                                }
                            }
                        }
                        else if (invokeExpr instanceof StaticInvokeExpr){
                            Class<?> cls;
                            try {
                                cls = am.getDroidsafeClass(invokeExpr.getMethod().getDeclaringClass());
                            } catch(ClassNotFoundException e) {
                                am.logError("Couldn't get corresponding droidsafe.analyses.attr.models.class for static"
                                            + " method class for " + invokeExpr + ": " + e.toString());
                                continue;
                            }
                            returnedObjects = am.simulateInvokeExprEffects(null, cls, invokeExpr, 
                                    paramObjectCartesianProduct, paramClasses);
                        } else {
                            // we don't know what to do with methods that aren't static or instance invokes
                            am.logError("Not simulation expression (isn't an instance invoke or static): " + invokeExpr
                                    + am.sourceLocation + "\n");
                            // invalidate all parameter models
                            am.invalidateParamObjects(paramObjectCartesianProduct);
                        }
                        // Store the returned object if there is one for later use
                        if (returnedObjects.size() > 0 && stmt instanceof AssignStmt) {
                            for (Object returnedObject : returnedObjects) {
                                am.valueToModelAttrMap.put(((AssignStmt)stmt).getLeftOp(), returnedObject);
                            }
                        }
                    }
                }
            }
        }

        try {
            am.attrModelingTodoLog.close();
        } catch (IOException ioe){
            logger.warn("Unable to close the attribute modeling error log file.", ioe);
        }
    }

    //=================================================================================================================
    // Private Methods
    //=================================================================================================================

    /**
     * Getter for analysis result
     */
    public Map<AllocNode, ModeledClass> getResults() {
        return this.objectToModelMap;
    }


    /**
     *  Invalidate any param that we modeled and log each invalidation.
     */
    public void invalidateParamObjects(Set<ArrayList<Object>> paramObjectCartesianProduct){  
        if(paramObjectCartesianProduct != null) {
            for (ArrayList paramObjectPermutation : paramObjectCartesianProduct){
                for (Object object : paramObjectPermutation){
                    if(object instanceof ModeledClass){
                        ModeledClass modeledObject = (ModeledClass)object;
                        modeledObject.invalidate();
                        this.logError("> invalidating argument " + modeledObject + " as a result");
                    }
                }
            }
        }
    }

    /**
     * Calls the invokeExpr for every possible permutation of params.
     */
    public ArrayList<Object> simulateInvokeExprEffects(ModeledClass  modeledReceiverObject, Class invokeExprClass, 
            InvokeExpr invokeExpr, Set<ArrayList<Object>> paramObjectCartesianProduct, ArrayList<Class> 
            paramObjectClasses) { 

        ArrayList<Object> objectsToReturn = new ArrayList<Object>();
        String methodName = invokeExpr.getMethod().getName();
        if(methodName.equals("<init>")){
            methodName = "_init_";
        }
        try {
            java.lang.reflect.Method method = invokeExprClass.getDeclaredMethod(methodName, 
                    paramObjectClasses.toArray(new Class[paramObjectClasses.size()]));
            Object objectToReturn;
            for (ArrayList paramObjectPermutation : paramObjectCartesianProduct) {
                objectToReturn = method.invoke(modeledReceiverObject, paramObjectPermutation.toArray());
                if (objectToReturn != null) {
                    if(objectToReturn instanceof droidsafe.analyses.attr.models.java.lang.String){
                        if(((droidsafe.analyses.attr.models.java.lang.String)objectToReturn).getPossibleValues().size()==0)
                            continue;
                    } else if (objectToReturn instanceof droidsafe.analyses.attr.models.android.net.Uri.StringUri){
                        if(((droidsafe.analyses.attr.models.android.net.Uri.StringUri)objectToReturn).getUriString().getPossibleValues().size()==0)
                            continue;
                    }
                    objectsToReturn.add(objectToReturn);
                }
            }
        } catch (Exception e) {
            String logEntry = "The InvokeExpr " + invokeExpr + this.sourceLocation + " hasn't been modeled: " + 
                e.toString() + "\n";
            logEntry += Throwables.getStackTraceAsString(e);

            // The method isn't modeled, so we must invalidate every argument that we modeled
            this.invalidateParamObjects(paramObjectCartesianProduct);

            // If this is an InstanceInvoke, also invalidate the receiver object
            if (modeledReceiverObject != null){
                modeledReceiverObject.invalidate();
                logEntry += "\n" + "> invalidating receiver " + modeledReceiverObject + " as a result";
            }
            this.logError(logEntry);
        }
        this.simulatedMethods.add(invokeExpr.getMethod());
        return objectsToReturn;
            }

    /**
     * Creates (if it does not yet exist) and returns our model
     * of the dynamic type of the AllocNode if it is modeled
     */
    private ModeledClass createAndGetModel(AllocNode allocNode) {

        // don't track values for alloc nodes we create
        if (AddAllocsForAPICalls.v().isGeneratedExpr(allocNode.getNewExpr()))
            return null;

        // we can't give model for allocNodes whose type isn't RefType 
        if (!(allocNode.getType() instanceof RefType))
            return null;

        RefType refType = (RefType)allocNode.getType();
        SootClass sootClass = refType.getSootClass();

        // is the allocNode an Activity? 
        boolean isActivity = false;
        if(sootClass.hasSuperclass() && sootClass.getSuperclass().getName().equals("android.app.Activity")){
            isActivity = true;
        }

        // don't model allocNodes that came from the harness, unless it's an activity
        if (!isActivity && allocNode.getMethod() != null && allocNode.getMethod().equals(Harness.v().getMain()))
            return null;

        ModeledClass model = null;
        if (!objectToModelMap.containsKey(allocNode)) {
            Constructor<?> ctor;
            String logEntry = "Couldn't model an instance of the " + sootClass.getName() + this.sourceLocation + " ";
            Class<?> cls;
            try {
                cls = getDroidsafeClass(refType);
            } catch(ClassNotFoundException e) {
                logEntry += e.toString();
                this.logError(logEntry); return null;
            }
            try {
                ctor = cls.getConstructor(AllocNode.class);
            } catch(NoSuchMethodException e) {
                logEntry += "Available constructors are:\n";
                for (Constructor<?> constructor : cls.getConstructors()){
                    logEntry += constructor + "\n";
                }
                logEntry += e.toString();
                this.logError(logEntry);
                return null;
            } catch(SecurityException e) {
                logEntry += e.toString();
                this.logError(logEntry);
                return null;
            }
            try {
                model = (ModeledClass)ctor.newInstance(allocNode);
            } catch(Exception e){
                logEntry += e.toString();
                this.logError(logEntry);
                return null;
            }
            objectToModelMap.put(allocNode, model);
        } else {
            model = objectToModelMap.get(allocNode);
        }
        return model;
    }

    /**
     * Helper method that convers a refType into the appropriate droidsafe.analyses.attr.models.class
     *
     * @throws ClassNotFoundException if the correct class isn't modeled 
     */
    private Class<?> getDroidsafeClass(RefType refType) throws ClassNotFoundException {
        SootClass sootClass = refType.getSootClass();
        return this.getDroidsafeClass(sootClass);
    }

    /** wrapper around toAttrModelingModelClass */
    private Class<?> getDroidsafeClass(SootClass sootClass) throws ClassNotFoundException {
        String className = sootClass.getName();
        if(isActivity(sootClass)){
            className = "android.app.Activity";
        }
        return Class.forName(AttributeModelingUtils.toAttrModelingModelClass(className));
    }

    /** Check if a sootClass is an instance of Activity or one of its subclasses */
    private static boolean isActivity(SootClass sootClass){
        // is the allocNode an Activity? 
        if(sootClass.hasSuperclass() && sootClass.getSuperclass().getName().equals("android.app.Activity")){
            return true;
        }
        return false;
    }

    /**
     * Helper method to write to the file where we log all errors we encounter during
     * attribute modeling.
     */
    private void logError(String logEntry) {
        try {
            this.attrModelingTodoLog.write(logEntry + "\n");
        } catch (IOException ioe) {}
    }

    /**
     * Log the results of the modeling
     */
    private void log() {

        int validModeledIntentsNum = 0;
        int totalModeledIntentsNum = 0;
        int validModeledUriNum = 0;
        int totalModeledUriNum = 0;
        int validModeledStringsNum = 0;
        int totalModeledStringsNum = 0;

        for (Map.Entry<AllocNode, ModeledClass> entry : objectToModelMap.entrySet()) {
            ModeledClass modeledObject = entry.getValue();

            if (modeledObject instanceof droidsafe.analyses.attr.models.android.content.Intent){
                totalModeledIntentsNum++;
                if (!((droidsafe.analyses.attr.models.android.content.Intent)modeledObject).invalidated()){
                    validModeledIntentsNum++;
                }
            }
            if (modeledObject instanceof droidsafe.analyses.attr.models.android.net.Uri){
                totalModeledUriNum++;
                if (!((droidsafe.analyses.attr.models.android.net.Uri)modeledObject).invalidated()){
                    validModeledUriNum++;
                }
            }
            if (modeledObject instanceof droidsafe.analyses.attr.models.java.lang.String){
                totalModeledStringsNum++;
                if (!((droidsafe.analyses.attr.models.java.lang.String)modeledObject).invalidated()){
                    validModeledStringsNum++;
                }
            }
            logger.info("Finished Model: {}", modeledObject);
            logger.info("Corresponding AllocNode: {}", entry.getKey());
        }
        File attrModelingStatsFile = new File(Config.v().getApacHome() + "/doc/attr-modeling-stats.txt");

        try {
            attrModelingStatsFile.createNewFile();
        } catch(IOException ioe){
            logger.error("Couldn't write to attr-modeling-stats file:", ioe);
        }

        String stats = "";
        stats += "Intents: " + validModeledIntentsNum + "/" + totalModeledIntentsNum;
        stats += " Uri: " + validModeledUriNum + "/" + totalModeledUriNum;
        stats += " Strings: " + validModeledStringsNum + "/" + totalModeledStringsNum;

        logger.info("Attribute Modeling Statistics");
        logger.info(stats);
        /*
           try {
           stats = Project.v().getAppSrcDir() + "\n" + stats;
           PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(attrModelingStatsFile, true)));
           out.println(stats);
           out.close();
           } catch (IOException ioe) {
           logger.error("Couldn't write to attr-modeling-stats file:", ioe);
           }
           */
    }

    //=================================================================================================================
    // Nested Classes
    //=================================================================================================================

    /** Helper class for analyzing parameters of a method */
    public class ParamAnalyzer { 

        //=============================================================================================================
        // Private Attributes
        //=============================================================================================================

        /** All the possible permutations of params that the method can be called with. This analysis is flow 
         * insensitive and thus we have to consider every permutation */
        private Set<ArrayList<Object>> paramCartesianProduct;

        /** The class of each param */
        private ArrayList<Class> paramClasses;

        //=============================================================================================================
        // Constructors
        //=============================================================================================================

        /** constructor */
        private ParamAnalyzer(InvokeExpr invokeExpr) {
            int paramCount = invokeExpr.getArgCount(); 

            // Each index is the class of the param at that index
            this.paramClasses = new ArrayList<Class>(paramCount);

            List<Type> paramTypes = invokeExpr.getMethod().getParameterTypes();

            // Each index is a set of objects that the param at that index can possibly be 
            ArrayList<HashSet<Object>> paramObjectSets = new ArrayList<HashSet<Object>>();

            // Store the param object models so that we can later invalidate them if we haven't modeled the method
            ArrayList<ModeledClass> paramObjectModels = new ArrayList<ModeledClass>();

            // All this entire for loop does is fill in paramClasses and paramObjectSets.  We may quit early if we are 
            // unable to model any of the params. 
            for (int i = 0; i < paramCount; i++) {
                // Create a new set in which we'll put all possible objects that could be this param 
                paramObjectSets.add(i, new HashSet<Object>());

                Value arg = invokeExpr.getArg(i);
                // If the argument is a constant, we box it up. We don't model primitives.
                // If the argument is a RefType, then we use PTA to find all possible AllocNodes and their corresponding 
                // models
                // We can't simulate this invokeExpr if the argument doesn't fall in those two cases (yet)
                if (paramTypes.get(i) instanceof RefType) {
                    if(((RefType)paramTypes.get(i)).getSootClass().getName().equals("android.net.Uri$1"))
                        continue;
                }

                if(arg instanceof Constant) {
                    if(arg instanceof NullConstant){
                        try {
                            try {
                                paramClasses.get(i);
                            } catch (IndexOutOfBoundsException e) {
                                paramClasses.add(i, 
                                                 AttributeModeling.this.getDroidsafeClass((RefType)paramTypes.get(i)));
                            }
                        } catch(Exception e) {
                            AttributeModeling.this.logError("Type of parameter #" + i + " of method " + invokeExpr 
                                                            + " isn't modeled yet: " + e.toString());
                            return;
                        }
                        paramObjectSets.get(i).add(null);
                    } else {
                        Object object;
                        try {
                            object = SootUtils.constantValueToObject(arg);
                        } catch (ClassNotFoundException cnfe){
                            AttributeModeling.this.logError("Couldn't convert constant value " + arg + " to object: "
                                    + cnfe + "\n");
                            for(ModeledClass modeledObject : paramObjectModels){
                                modeledObject.invalidate();
                            }
                            return;
                        }
                        try {
                            paramClasses.get(i);
                        } catch(IndexOutOfBoundsException e) {
                            paramClasses.add(i, object.getClass());
                        }
                        paramObjectSets.get(i).add(object);
                    }
                } else if(arg.getType() instanceof RefType) {
                    // use PTA to find all possible AllocNodes and their corresponding models
                    Set<AllocNode> allocNodeSet = GeoPTA.v().getPTSetContextIns(arg);
                    if(valueToModelAttrMap.containsKey(arg)){
                        Object modelAttr = valueToModelAttrMap.get(arg);
                        try {
                            paramClasses.get(i);
                        } catch (IndexOutOfBoundsException e) {
                            paramClasses.add(i, modelAttr.getClass());
                        }
                        paramObjectSets.get(i).add(modelAttr); 
                    } else {
                        if (allocNodeSet.size() != 0){
                            for (AllocNode node : allocNodeSet) {
                                ModeledClass modeledParamObject = createAndGetModel(node);
                                if(modeledParamObject != null){
                                    paramObjectSets.get(i).add(modeledParamObject);
                                    try {
                                        try {
                                            paramClasses.get(i);
                                        } catch (IndexOutOfBoundsException e) {
                                            paramClasses.add(i, 
                                                    AttributeModeling.this.getDroidsafeClass((RefType)paramTypes.get(i)));
                                        }
                                    } catch(ClassNotFoundException cnfe) {
                                        AttributeModeling.this.logError("Couldn't getDroidsafeClass for arg " + arg 
                                                + "\n"); return;
                                    }
                                    // Store the param object model so that we can later invalidate it if we haven't 
                                    // modeled the method
                                    paramObjectModels.add(modeledParamObject);
                                } else {
                                    // We couldn't model the argument node, so invalidate any param models we've 
                                    // already created
                                    for(ModeledClass modeledObject : paramObjectModels){
                                        modeledObject.invalidate();
                                    }
                                    AttributeModeling.this.logError("Couldn't model argument " + i + " " + node 
                                            + " for method" + invokeExpr 
                                            + AttributeModeling.this.sourceLocation);
                                    return;
                                }
                            } 
                        } else {
                            AttributeModeling.this.logError("PTA didn't find any AllocNodes and the analysis dind't" 
                                    + " find any model attributes for arg #" + i 
                                    + " of instanceInvokeExpr " + invokeExpr);
                            // invalidate any param models we've already created
                            for(ModeledClass modeledObject : paramObjectModels){
                                modeledObject.invalidate();
                            }
                            return;
                        }
                    }
                } else {
                    AttributeModeling.this.logError("Arg #" + i + " of method " + invokeExpr 
                            + " isn't a constant or a RefType." 
                            + " Not sure what to do - invalidating other params" 
                            + "and not simulating.");
                    // invalidate any param models we've already created
                    for(ModeledClass modeledObject : paramObjectModels){
                        modeledObject.invalidate();
                    }
                    return;
                }
            }

            // What are all the possible ways in which the method can be called now that we know all possible params
            this.paramCartesianProduct = cartesianProduct(0, paramObjectSets);
        }

        //=================================================================================================================
        // Getters & Setters
        //=================================================================================================================

        /** get the cartesian product of the method parameters */ 
        public Set<ArrayList<Object>> getParamCartesianProduct(){
            return this.paramCartesianProduct;
        }

        /** get the classes of the parameters */
        public ArrayList<Class> getParamClasses(){
            return this.paramClasses;
        }
    } 
}
