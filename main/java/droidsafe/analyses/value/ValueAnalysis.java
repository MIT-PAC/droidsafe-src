package droidsafe.analyses.value;

import com.google.common.base.Throwables;
import com.google.common.collect.Sets;

import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.strings.JSAStrings;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisBoolean;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisByte;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisChar;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisDouble;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisFloat;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisInt;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisLong;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisShort;
import droidsafe.analyses.value.ValueAnalysisModeledObject;

import droidsafe.android.app.Harness;
import droidsafe.android.app.Project;

import droidsafe.main.Config;

import droidsafe.speclang.Method;

import droidsafe.transforms.AddAllocsForAPICalls;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.lang.reflect.Constructor;

import java.util.ArrayList;
import java.util.Arrays;
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

import soot.BooleanType;

import soot.ByteType;

import soot.CharType;

import soot.DoubleType;

import soot.FloatType;

import soot.IntType;

import soot.jimple.AssignStmt;
import soot.jimple.ClassConstant;
import soot.jimple.Constant;
import soot.jimple.DoubleConstant;
import soot.jimple.FloatConstant;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.LongConstant;
import soot.jimple.NullConstant;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.spark.pag.StringConstantNode;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.StringConstant;
import soot.jimple.toolkits.typing.fast.Integer127Type;
import soot.jimple.toolkits.typing.fast.Integer1Type;
import soot.jimple.toolkits.typing.fast.Integer32767Type;

import soot.LongType;

import soot.PrimType;

import soot.RefType;

import soot.Scene;

import soot.ShortType;

import soot.SootClass;

import soot.SootMethod;

import soot.tagkit.LineNumberTag;
import soot.tagkit.SourceFileTag;

import soot.Type;

import soot.Unit;

import soot.util.Chain;

import soot.Value;

/** Models certain Android objects such as Intents, Strings, and Uris so that we better understand the way they are
 * built up and used.
 *
 * We don't want to present the analyst with the built up of each like we do now, but instead each at the time of its
 * use with as much Context as possible (this might help shorten the spec a little bit). For example, for an Intent i,
 * we should tell the analyst which View or Uri will be started when StartActivity(i) is called and let them decide
 * whether its malware or not.
 *
 * We are assuming that in general, each is used simply and once.
 * 
 * @author dpetters
 *
 */
public class ValueAnalysis {

    //==================================================================================================================
    // Methods to step through
    //==================================================================================================================

    /** Set of methods to not invalidate */
    private Set<String> signaturesOfMethodsToStepThru = new HashSet<String>(
    Arrays.asList("<android.app.Activity: void startActivityForResult(android.content.Intent,int)>", 
                  "<android.app.Activity: void onActivityResult(int,int,android.content.Intent)>",
                  "<droidsafe.helpers.DSUtils: void translateIntent(android.content.Intent,android.content.Intent)>",
                  "<android.net.URI: android.net.Uri parse(java.lang.String)", 
                  "<java.net.URI: java.lang.URI create(java.lang.String)>",
                  "<java.lang.Object: void addTaint(boolean)>"));

    //==================================================================================================================
    // Attributes
    //==================================================================================================================


    /** Singleton for analysis */
    private static ValueAnalysis am;

    /** 
     * AllocNode keys are the objects that we can and want to model. 
     * The value is the Model object which simulates that object. 
     */
    private Map<AllocNode, ValueAnalysisModeledObject> objectToModelMap; 

    /** Map to store Values to attributes of Models */
    private Map<Value, Object> valueToModelAttrMap;

    /** Set of methods we simulated and thus don't want to step through */
    private Set<SootMethod> simulatedMethods;

    /** FileWriter used to log what we still don't model but perhaps should */
    private FileWriter attrModelingTodoLog;

    /** Source location of current statement */
    private String sourceLocation;

    /** singleton instance of of the JSA analysis that contains its results */
    private JSAStrings jsa;

    /** Generic logger */
    private static final Logger logger = LoggerFactory.getLogger(ValueAnalysis.class);

    /** The package of the value analysis models */
    public static final String MODEL_PACKAGE = "droidsafe.analyses.value.models";

    /** The prefix that is prepended to fully qualified value analysis models */
    public static final String MODEL_PACKAGE_PREFIX = MODEL_PACKAGE + ".";

    /** The directory relative from APAC_HOME that is the base of the modeling source code for this abstract semantics 
    */
    public static final String MODEL_SRC_BASE_DIR = "src/main/java/droidsafe.analyses.value.models.";

    /** The directory relative from APAC_HOME that is the base of the modeling class files for this abstract semantics 
    */
    public static final String MODEL_CLASS_BASE_DIR = "classes/main/droidsafe.analyses.value.models.";

    /** 
     * Determined whether the analysis should be run again. Used to make sure the analysis runs to a fixed point.
     */
    public static boolean runAgain = false;

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /** Private constructor to enforce singleton pattern */
    private ValueAnalysis() {
        this.objectToModelMap = new LinkedHashMap<AllocNode, ValueAnalysisModeledObject>();
        this.valueToModelAttrMap = new HashMap<Value, Object>();
        this.simulatedMethods = new HashSet<SootMethod>();

        try {
            this.attrModelingTodoLog = new FileWriter(Project.v().getOutputDir() + File.separator 
                    + "attr-modeling-errors.log");
        } catch (Exception e) {
            logger.warn("Unable to write to the attribute modeling log:", e);
        }

        jsa = JSAStrings.v();
    }


    //==================================================================================================================
    // Public Methods
    //==================================================================================================================


    /**
     * Getter for analysis result
     */
    public Map<AllocNode, ValueAnalysisModeledObject> getResults() {
        return this.objectToModelMap;
    }


    /**
     * Return true if this alloc node has an analysis result (and is not invalidated)
     */
    public boolean hasResult(AllocNode node) {
        return this.objectToModelMap.containsKey(node) &&
            !this.objectToModelMap.get(node).__ds__invalidated();
    }

    /**
     * Return the ModeledObject result for a given alloc node.
     */
    public ValueAnalysisModeledObject getResult(AllocNode node) {
        return this.objectToModelMap.get(node);
    }

    /**
     * Helper method that convers a refType into the appropriate droidsafe.analyses.value.models.class
     *
     * @throws ClassNotFoundException if the correct class isn't modeled 
     */
    public Class<?> getDroidsafeClass(RefType refType) throws ClassNotFoundException {
        SootClass sootClass = refType.getSootClass();
        return this.getDroidsafeClass(sootClass);
    }

    /** wrapper around toAttrModelingModelClass */
    public Class<?> getDroidsafeClass(SootClass sootClass) throws ClassNotFoundException {
        String className = sootClass.getName();
        if(isActivity(sootClass)){
            className = "android.app.Activity";
        }
        return Class.forName(ValueAnalysisUtils.toAttrModelingModelClass(className));
    }

    //==================================================================================================================
    // Static Methods
    //==================================================================================================================

    /** access to the singleton instance */
    public static ValueAnalysis v() {
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
        am.objectToModelMap = new LinkedHashMap<AllocNode, ValueAnalysisModeledObject>();
        am.valueToModelAttrMap = new HashMap<Value, Object>();

        // Now run the analysis to fixed point, not stepping through the methods that we simulate.
        do {
            System.out.println("\nValue Analysis Progress: fixed point not reached, re-running");
            runAgain = false;
            runOnce();
        } while(runAgain);
 
        System.out.print("\n");
 
        // log the results and statistics    
        am.log();
    }
 
    /** Sets the global runAgain to true, meaning that the analysis will run again. Called when fixed points has been
     *  determined to not have been reached yet.
     */
    public static void runAgain() {
        logger.info("Value Analysis: runAgain got called");
        runAgain = true;
    }

    /** run the full analysis once */ 
    public static void runOnce() {
        if (GeoPTA.v() == null) {
            logger.error("The GeoPTA pass has not been run. Attribute modeling / requires it.");
            droidsafe.main.Main.exit(1);
        }      if (am == null)
        am = new ValueAnalysis();
        Set<SootMethod> reachableMethods = GeoPTA.v().getAllReachableMethods();

        // loop over all code, creating models and simulating whichever invokeExprs we can as we go
        Chain<SootClass> sootClasses = Scene.v().getApplicationClasses();
        int progressCounter = 0; 
        for (SootClass clazz : sootClasses) {
            System.out.print("Value Analysis Progress: " + (int)Math.ceil(100*(double)progressCounter/sootClasses.size()) + "%\r");
            progressCounter++;
            String className = clazz.getName();
            // We don't care about the harness or interfaces
            if (clazz.isInterface() || className.equals(Harness.HARNESS_CLASS_NAME))
                continue;

            // DroidSafeCalls will go away eventually and we don't want to look at it for now 
            if(className.equals("edu.mit.csail.droidsafe.DroidSafeCalls")){
                continue;
            }

            logger.info("Value Analysis: stepping through " + clazz);
            
            // Get source filename that contains the class 
            SourceFileTag sourceFileTag = (SourceFileTag)clazz.getTag("SourceFileTag");

            for (SootMethod meth : clazz.getMethods()) {
                if (meth.isConcrete() && reachableMethods.contains(meth) && !am.simulatedMethods.contains(meth)) {
                    
                    logger.info("Value Analysis: stepping through " + meth);
                    
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
                        
                        SootMethod sootMethod = invokeExpr.getMethod();
                        SootClass sootClass = sootMethod.getDeclaringClass();

                        // don't simulate java.lang.String methods. We use JSA's results to obtain string values.
                        if(sootClass.equals("java.lang.String")){
                            continue;
                        }

                        paramAnalyzer = am.new ParamAnalyzer(invokeExpr);

                        // Compute cartesian product of params, creating models as we do so.  If we can't model 
                        // something, we invalidate any param models that we created for this method already and return
                        // null
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
                                ValueAnalysisModeledObject modeledReceiverObject = am.createAndGetModel(node);
                                if(modeledReceiverObject != null) {
                                    if(paramObjectCartesianProduct != null){
                                        // simulateInvokeExprEffects will simulate the call for each param permutation 
                                        // in paramObjectCartesianProduct
                                        returnedObjects = am.simulateInvokeExprEffects(modeledReceiverObject, 
                                                modeledReceiverObject.getClass(), invokeExpr, 
                                                paramObjectCartesianProduct, paramClasses);
                                    } else {
                                        String methodSignature = sootMethod.getSignature();
                                        if(!am.signaturesOfMethodsToStepThru.contains(methodSignature)) {
                                            // We couldn't model one of the arguments so we can't simulate the call and 
                                            // have to invalidate the receiver
                                            modeledReceiverObject.__ds__invalidate();
                                            am.logError("Couldn't model every parameter for " + iie 
                                                        + am.sourceLocation + "\n" + "> invalidating " 
                                                        + modeledReceiverObject.__ds__toString() + " as a result");
                                        }
                                    }
                                }
                            }
                        }
                        else if (invokeExpr instanceof StaticInvokeExpr){
                            Class<?> cls;
                            try {
                                cls = am.getDroidsafeClass(sootClass);
                            } catch(ClassNotFoundException e) {
                                am.logError("Couldn't get corresponding droidsafe.analyses.value.models.class for static"
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
     *  Invalidate any param that we modeled and log each invalidation.
     */
    public void invalidateParamObjects(Set<ArrayList<Object>> paramObjectCartesianProduct){  
        if(paramObjectCartesianProduct != null) {
            for (ArrayList paramObjectPermutation : paramObjectCartesianProduct){
                for (Object object : paramObjectPermutation){
                    if(object instanceof ValueAnalysisModeledObject){
                        ValueAnalysisModeledObject modeledObject = (ValueAnalysisModeledObject)object;
                        modeledObject.__ds__invalidate();
                        this.logError("> invalidating argument " + modeledObject.__ds__toString() + " as a result");
                    }
                }
            }
        }
    }

    /**
     * Calls the invokeExpr for every possible permutation of params.
     */
    public ArrayList<Object> simulateInvokeExprEffects(ValueAnalysisModeledObject  modeledReceiverObject, Class invokeExprClass, 
            InvokeExpr invokeExpr, Set<ArrayList<Object>> paramObjectCartesianProduct, 
            ArrayList<Class> paramObjectClasses) { 

        // objects returned by the simulation of the invoke exprs will be aggregated here
        ArrayList<Object> objectsToReturn = new ArrayList<Object>();

        SootMethod sootMethod= invokeExpr.getMethod();

        // init methods are constructors
        // they can't have angled brackets in the name so we use underscores instead
        String methodName = sootMethod.getName();
        if(methodName.equals("<init>")){
            methodName = "_init_";
        }
        try {
            // get the method we are going to simulate
            Class[] paramObjectClassArray = paramObjectClasses.toArray(new Class[paramObjectClasses.size()]);
            // we use getMethod because it takes into account inheritance appropriately. However, it doesn't find
            // private methods and thus all value analysis model methods should be public
            java.lang.reflect.Method method = invokeExprClass.getMethod(methodName, paramObjectClassArray);    

            // simulate the method using reflection for every permutation of parameter values, aggregating the returned
            // objects
            Object objectToReturn;

            logger.info("Value Analysis: simulating " + invokeExpr);

            for (ArrayList paramObjectPermutation : paramObjectCartesianProduct) {
                objectToReturn = method.invoke(modeledReceiverObject, paramObjectPermutation.toArray());
                if (objectToReturn != null) {
                    objectsToReturn.add(objectToReturn);
                }
            }
            this.simulatedMethods.add(invokeExpr.getMethod());
        } catch (Exception e) {
            // If we don't have the method market as one we will step through, that means we haven't modeled it at all
            // and thus the receiver and argument models 
           String methodSignature = sootMethod.getSignature();
           if(!this.signaturesOfMethodsToStepThru.contains(methodSignature)) {
                String error = "The InvokeExpr " + invokeExpr + this.sourceLocation + " hasn't been modeled: " 
                    + e.toString() + "\n";
                error += Throwables.getStackTraceAsString(e);

                // If this is an InstanceInvoke, also invalidate the receiver object
                if (modeledReceiverObject != null){
                    modeledReceiverObject.__ds__invalidate();
                    error += "\n" + "> invalidating receiver " + modeledReceiverObject.__ds__toString() + " as a result";
                }
                this.logError(error);
                // The method isn't modeled, so we must invalidate every argument that we modeled
                this.invalidateParamObjects(paramObjectCartesianProduct);

            }
        }
        return objectsToReturn;
    }

    /**
     * Creates (if it does not yet exist) and returns our model
     * of the dynamic type of the AllocNode if it is modeled
     */
    private ValueAnalysisModeledObject createAndGetModel(AllocNode allocNode) {

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

        ValueAnalysisModeledObject model = null;
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
                model = (ValueAnalysisModeledObject)ctor.newInstance(allocNode);
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

        for (Map.Entry<AllocNode, ValueAnalysisModeledObject> entry : objectToModelMap.entrySet()) {
            ValueAnalysisModeledObject modeledObject = entry.getValue();

            if (modeledObject instanceof droidsafe.analyses.value.models.android.content.Intent){
                totalModeledIntentsNum++;
                if (!((droidsafe.analyses.value.models.android.content.Intent)modeledObject).__ds__invalidated()){
                    validModeledIntentsNum++;
                }
            }
            if (modeledObject instanceof droidsafe.analyses.value.models.android.net.Uri){
                totalModeledUriNum++;
                if (!((droidsafe.analyses.value.models.android.net.Uri)modeledObject).__ds__invalidated()){
                    validModeledUriNum++;
                }
            }
            logger.info("Finished Model: {}", modeledObject.__ds__toString());
            logger.info("Corresponding AllocNode: {}", entry.getKey());
        }
        /*
           File attrModelingStatsFile = new File(Config.v().getApacHome() + "/doc/attr-modeling-stats.txt");

           try {
           attrModelingStatsFile.createNewFile();
           } catch(IOException ioe){
           logger.error("Couldn't write to attr-modeling-stats file:", ioe);
           }
           */
        String stats = "";
        stats += "Intents: " + validModeledIntentsNum + "/" + totalModeledIntentsNum;
        stats += " Uri: " + validModeledUriNum + "/" + totalModeledUriNum;

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
    // Inner Classes
    //=================================================================================================================

    /** 
     * Inner class for analyzing parameters of a method 
     */
    public class ParamAnalyzer { 

        //=============================================================================================================
        // Private Attributes
        //=============================================================================================================

        /** 
         * Set that contains all the possible permutations of parameter values that the method can be called with. 
         * We have to consider every permutation because attribute analysis is flow insensitive.
         */
        private Set<ArrayList<Object>> paramCartesianProduct;

        /** 
         * The class of each parameter, in order.
         * */
        private ArrayList<Class> paramClasses;

        //=============================================================================================================
        // Constructors
        //=============================================================================================================

        /** 
         * Constructor that analyzes the parameters right away.
         * TODO: change this such that the constructor doesn't do everything right away but instead calls a
         * method that does it. That way it's better for testing.
         * */
        private ParamAnalyzer(InvokeExpr invokeExpr) {
            int paramCount = invokeExpr.getArgCount(); 

            SootMethod sootMethod = invokeExpr.getMethod();

            String methodSignature = sootMethod.getSignature();

            // Each index is the class of the parameter at that index
            this.paramClasses = new ArrayList<Class>(paramCount);

            List<Type> paramTypes = invokeExpr.getMethod().getParameterTypes();

            // Each index is a set of objects that the param at that index can possibly be 
            ArrayList<HashSet<Object>> paramObjectSets = new ArrayList<HashSet<Object>>();

            // Store the param object models so that we can later invalidate them if we haven't modeled the method
            ArrayList<ValueAnalysisModeledObject> paramObjectModels = new ArrayList<ValueAnalysisModeledObject>();

            // All this entire for loop does is fill in paramClasses and paramObjectSets.  We may quit early if we are 
            // unable to model any of the params. 
            for (int i = 0; i < paramCount; i++) {
                // Create a new set in which we'll put all possible objects that could be this param 
                paramObjectSets.add(i, new HashSet<Object>());

                Value arg = invokeExpr.getArg(i);
                Type type = arg.getType();

                // we ignore parameters that are instances of inner classes
                // TODO: figure out how to properly handle inner classes
                if (paramTypes.get(i) instanceof RefType) {
                    if(((RefType)paramTypes.get(i)).getSootClass().getName().equals("android.net.Uri$1"))
                        continue;
                }
                if(ValueAnalysis.this.valueToModelAttrMap.containsKey(arg)){
                    Object obj = ValueAnalysis.this.valueToModelAttrMap.get(arg);
                    paramObjectSets.get(i).add(obj);
                    if(Set.class.isAssignableFrom(obj.getClass())){
                        paramClasses.add(i, Set.class);
                    } else {
                        paramClasses.add(i, obj.getClass());
                    }
                } else {
                    // If the argument is a constant, we box it up. We don't model primitives.
                    // If the argument is a RefType, then we use PTA to find all possible AllocNodes and their
                    // corresponding model
                    // We can't simulate this invokeExpr if the argument doesn't fall in those two cases (yet)
                    if(arg instanceof Constant) {
                        if(arg instanceof NullConstant){
                            try {
                                try {
                                    paramClasses.get(i);
                                } catch (IndexOutOfBoundsException e) {
                                    paramClasses.add(i, ValueAnalysis.this.getDroidsafeClass((RefType)paramTypes.get(i)));
                                }
                            } catch(Exception e) {
                                ValueAnalysis.this.logError("Type of parameter #" + i + " of method " + invokeExpr 
                                        + " isn't modeled yet: " + e.toString());
                                return;
                            }
                            paramObjectSets.get(i).add(null);
                        } else {
                            Object obj;
                            if(valueToModelAttrMap.containsKey(arg)){
                                obj = valueToModelAttrMap.get(arg);
                            } else {
                                try {
                                    if(arg instanceof NullConstant) {
                                        obj = null;
                                    } else if (arg instanceof IntConstant) {
                                        obj = new ValueAnalysisInt(((IntConstant)arg).value);
                                    } else if (arg instanceof StringConstant) {
                                        obj = new String(((StringConstant)arg).value);
                                    } else if (arg instanceof LongConstant) {
                                        obj = new ValueAnalysisLong(((LongConstant)arg).value);
                                    } else if (arg instanceof DoubleConstant) {
                                        obj = new ValueAnalysisDouble(((DoubleConstant)arg).value);
                                    } else if (arg instanceof FloatConstant) {
                                        obj = new ValueAnalysisFloat(((FloatConstant)arg).value);
                                    } else if (arg instanceof ClassConstant) {
                                        String className = ((ClassConstant)arg).value.replace("/", ".");
                                        obj = Project.v().getAppJavaClass(className);
                                    } else {
                                        throw new RuntimeException("Unhandled SootConstant parameter: " + arg);
                                    }
                                    valueToModelAttrMap.put(arg, Sets.newHashSet(obj));
                                } catch (ClassNotFoundException cnfe){
                                    ValueAnalysis.this.logError("Couldn't convert constant value " + arg + " to object: "
                                            + cnfe + "\n");
                                    if(!ValueAnalysis.this.signaturesOfMethodsToStepThru.contains(methodSignature)) {
                                        for(ValueAnalysisModeledObject modeledObject : paramObjectModels){
                                            modeledObject.__ds__invalidate();
                                        }
                                    }
                                    return;
                                }
                            }
                            try {
                                paramClasses.get(i);
                            } catch(IndexOutOfBoundsException e) {
                                paramClasses.add(i, Set.class);
                            }
                            paramObjectSets.get(i).add(Sets.newHashSet(obj));
                        }
                    } else if(type instanceof RefType) {
                        Set<AllocNode> allocNodeSet = GeoPTA.v().getPTSetContextIns(arg);
                        // If the arg is a ref to a java.lang.String, check to see if the nodes found by pta are all
                        // StringConstantNodes and if so, use their values. Otherwise, fall back to JSA's results. 
                        RefType refType = (RefType)type;
                        String className = refType.getClassName();
                        if(className.equals("java.lang.String")){
                            Set<String> constantStrVals = new HashSet<String>();
                            boolean allStringConstants = true;
                            for(AllocNode allocNode : allocNodeSet) {
                                if(allocNode instanceof StringConstantNode) {
                                    constantStrVals.add(((StringConstantNode)allocNode).getString());
                                } else {
                                    allStringConstants = false;
                                    break;
                                }
                            }
                            // if all allocnodes were StringConstantNodes, use their values. Otherwise fall back to JSA.
                            if(allStringConstants) {
                                paramObjectSets.get(i).add(constantStrVals); 
                            } else {
                                String strVal = new String(jsa.getRegex(arg));
                                Set<String> strVals = Sets.newHashSet(strVal);
                                paramObjectSets.get(i).add(strVals);
                            }
                            // String -> Set<String> always
                            paramClasses.add(i, Set.class);
                        } else {
                            // use PTA to find all possible AllocNodes and their corresponding models
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
                                        ValueAnalysisModeledObject modeledParamObject = createAndGetModel(node);
                                        if(modeledParamObject != null){
                                            paramObjectSets.get(i).add(modeledParamObject);
                                            try {
                                                try {
                                                    paramClasses.get(i);
                                                } catch (IndexOutOfBoundsException e) {
                                                    RefType paramRef = (RefType)paramTypes.get(i);
                                                    paramClasses.add(i, ValueAnalysis.this.getDroidsafeClass(paramRef));
                                                }
                                            } catch(ClassNotFoundException cnfe) {
                                                ValueAnalysis.this.logError("Couldn't getDroidsafeClass for arg " + arg 
                                                        + "\n"); 
                                                // We couldn't model the argument node, so invalidate any param models we've 
                                                // already created
                                                if(!ValueAnalysis.this.signaturesOfMethodsToStepThru.contains(methodSignature)) {
                                                    for(ValueAnalysisModeledObject modeledObject : paramObjectModels){
                                                        ValueAnalysis.this.logError("> invalidating argument model " + modeledObject.__ds__toString());
                                                        modeledObject.__ds__invalidate();
                                                    }
                                                }
                                                return;
                                            }
                                            // Store the param object model so that we can later invalidate it if we 
                                            // haven't modeled the method
                                            paramObjectModels.add(modeledParamObject);
                                        } else {
                                            ValueAnalysis.this.logError("Couldn't model argument " + i + " " + node 
                                                    + " for method" + invokeExpr 
                                                    + ValueAnalysis.this.sourceLocation);
                                            // We couldn't model the argument node, so invalidate any param models we've 
                                            // already created
                                            if(!ValueAnalysis.this.signaturesOfMethodsToStepThru.contains(methodSignature)) {
                                                for(ValueAnalysisModeledObject modeledObject : paramObjectModels){
                                                    ValueAnalysis.this.logError("> invalidating argument model " + modeledObject.__ds__toString());
                                                    modeledObject.__ds__invalidate();
                                                }
                                            }
                                     return;
                                        }
                                    } 
                                } else {
                                    ValueAnalysis.this.logError("PTA didn't find any AllocNodes and the analysis"
                                            + " dind't find any model attributes for arg #" + i 
                                            + " of instanceInvokeExpr " + invokeExpr);
                                    // invalidate any param models we've already created
                                    if(!ValueAnalysis.this.signaturesOfMethodsToStepThru.contains(methodSignature)) {
                                        for(ValueAnalysisModeledObject modeledObject : paramObjectModels){
                                            ValueAnalysis.this.logError("> invalidating argument model " + modeledObject.__ds__toString());
                                            modeledObject.__ds__invalidate();
                                        }
                                    }
                                    return;
                                }
                            }
                        }
                    } else if(arg.getType() instanceof PrimType) {
                        Object obj = null;
                        if(valueToModelAttrMap.containsKey(arg)) {
                            obj = valueToModelAttrMap.get(arg);
                        } else {
                            if(type instanceof BooleanType) {
                                obj = new ValueAnalysisBoolean();
                            } else if (type instanceof ByteType) {
                                obj = new ValueAnalysisByte();
                            } else if (type instanceof CharType) {
                                obj = new ValueAnalysisChar();
                            } else if (type instanceof DoubleType) {
                                obj = new ValueAnalysisDouble();
                            } else if(type instanceof FloatType) {
                                obj = new ValueAnalysisFloat();
                            } else if(type instanceof Integer127Type) {
                                logger.error("unhandled Integer127Type: {}", type);
                                droidsafe.main.Main.exit(1);
                            } else if(type instanceof Integer1Type) {
                                logger.error("unhandled Integer1Type: {}", type);
                                droidsafe.main.Main.exit(1);
                            } else if (type instanceof Integer32767Type) {
                                logger.error("unhandled Integer32676Type: {}", type);
                                droidsafe.main.Main.exit(1);
                            } else if (type instanceof IntType) {
                                obj =  new ValueAnalysisInt();
                            } else if (type instanceof LongType) {
                                obj = new ValueAnalysisLong();
                            } else if (type instanceof ShortType) {
                                obj = new ValueAnalysisShort();
                            } else {
                                logger.error("unhandled PrimType: {}", type);
                                droidsafe.main.Main.exit(1);
                            }
                            valueToModelAttrMap.put(arg, obj);
                        }
                        paramObjectSets.get(i).add(Sets.newHashSet(obj));
                        paramClasses.add(i, Set.class);
                    } else {
                        ValueAnalysis.this.logError("Arg #" + i + " of method " + invokeExpr + " isn't a constant or a "
                                   + "RefType. Not sure what to do - invalidating other arguments and not simulating.");
                        // invalidate any param models we've already created
                        if(!ValueAnalysis.this.signaturesOfMethodsToStepThru.contains(methodSignature)) {
                            for(ValueAnalysisModeledObject modeledObject : paramObjectModels){
                                ValueAnalysis.this.logError("> invalidating argument model " + modeledObject.__ds__toString());
                                modeledObject.__ds__invalidate();
                            }
                        }
                        return;
                    }
                }
            }

            // What are all the possible ways in which the method can be called now that we know all possible params
            this.paramCartesianProduct = cartesianProduct(0, paramObjectSets);
        }

        //==============================================================================================================
        // Getters & Setters
        //==============================================================================================================

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
