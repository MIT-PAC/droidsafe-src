package droidsafe.analyses.value;

import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.helper.CGVisitorEntryAnd1CFA;
import droidsafe.analyses.helper.CallGraphTraversal;
import droidsafe.analyses.strings.JSAStrings;
import droidsafe.analyses.value.VAModel;

import droidsafe.android.app.Project;
import droidsafe.android.system.API;

import droidsafe.speclang.Method;
import droidsafe.utils.SootUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.AssignStmt;
import soot.jimple.Constant;
import soot.jimple.DoubleConstant;
import soot.jimple.FloatConstant;
import soot.jimple.InstanceFieldRef;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.LongConstant;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.Edge;

import soot.Local;
import soot.RefType;

import soot.SootMethod;

import soot.Value;

/** 
 * Determine soundly and conservatively the possible values of fields of security sensitive  Android objects such as 
 * Intents, Strings, and Uris.
 *
 * This will make it easier for an analyst to determine if a particular security-sensitive API call that one of these
 * objects interacts with is used maliciously by providing the necessary context.
 * 
 * @author dpetters
 */
public class ValueAnalysis implements CGVisitorEntryAnd1CFA {

    /** Singleton for analysis */
    private static ValueAnalysis am;

    /** 
     * AllocNode keys are the objects that we can and want to model. 
     * The value is the Model object which simulates that object. 
     */
    private Map<AllocNode, VAModel> allocNodeToVAModelMap; 

    /** va errors file used to help figure out what to model */
    private FileWriter vaErrorsLog;

    /** va stats file */
    private FileWriter vaResultsLog;

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

    /** Private constructor to enforce singleton pattern */
    private ValueAnalysis() {
        this.allocNodeToVAModelMap = new LinkedHashMap<AllocNode, VAModel>();
    }

    /**
     * Getter for analysis result
     */
    public Map<AllocNode, VAModel> getResults() {
        return this.allocNodeToVAModelMap;
    }

    /**
     * Return true if this alloc node has an analysis result (and is not invalidated)
     */
    public boolean hasResult(AllocNode node) {
        return this.allocNodeToVAModelMap.containsKey(node) &&
            !this.allocNodeToVAModelMap.get(node).invalidated();
    }

    /**
     * Return the ModeledObject result for a given alloc node.
     */
    public VAModel getResult(AllocNode node) {
        return this.allocNodeToVAModelMap.get(node);
    }

    /** access to the singleton instance */
    public static ValueAnalysis v() {
        return am;
    }

    public static void setup() {
        if (am == null)
            am = new ValueAnalysis();
    }

    /** run the analysis to fixed point */
    public static void run() {
        if (GeoPTA.v() == null) {
            logger.error("The GeoPTA pass has not been run. Value analysis requires it.");
            droidsafe.main.Main.exit(1);
        }      

        try {
            am.vaErrorsLog = new FileWriter(Project.v().getOutputDir() + File.separator 
                    + "va-errors.log");
        } catch (Exception e) {
            logger.warn("Unable to open va-errors.log:", e);
        }

        try {
            am.vaResultsLog = new FileWriter(Project.v().getOutputDir() + File.separator 
                    + "va-results.log");
        } catch (Exception e) {
            logger.warn("Unable to open va-results.log: ", e);
        }

        System.out.println(JSAStrings.v().getHotspots());

        am.createObjectModels();

        CallGraphTraversal.acceptEntryContextAnd1CFA(am);

        am.logResults();

        try {
            am.vaErrorsLog.close();
        } catch (IOException e){
            logger.warn("Unable to close the va-errors.log file.", e);
        }

        try {
            am.vaResultsLog.close();
        } catch (IOException e){
            logger.warn("Unable to close the va-results.log file.", e);
        }
    }

    public void createObjectModels() {
        for(AllocNode allocNode : GeoPTA.v().getAllAllocNodes()) {
            createObjectModel(allocNode);    
        }
    }

    public void createObjectModel(AllocNode allocNode) {
        if(!(allocNode.getType() instanceof RefType)) {
            this.logError(allocNode.toString());
            return;
        }
        RefType refType = (RefType)allocNode.getType();

        String errorLogEntry = "Couldn't model an instance of the " + refType.getSootClass().getName() + " ";

        Class<?> cls;
        try {
            cls = VAUtils.getDroidsafeClass(refType);
        } catch(ClassNotFoundException e) {
            errorLogEntry += e.toString();
            this.logError(errorLogEntry);
            return;
        }

        RefVAModel model = null;
        Constructor<?> ctor;
        try {
            ctor = cls.getConstructor(AllocNode.class);
        } catch(NoSuchMethodException e) {
            errorLogEntry += "Available constructors are:\n";
            for (Constructor<?> constructor : cls.getConstructors()){
                errorLogEntry += constructor + "\n";
            }
            errorLogEntry += e.toString();
            logError(errorLogEntry);
            return;
        } catch(SecurityException e) {
            errorLogEntry += e.toString();
            logError(errorLogEntry);
            return;
        }

        try {
            model = (RefVAModel)ctor.newInstance(allocNode);
        } catch(Exception e){
            errorLogEntry += e.toString();
            logError(errorLogEntry);
            return;
        }
        if(model != null)
            this.allocNodeToVAModelMap.put(allocNode, model);
    }
    
    private Map<Local, String> getJSALocalMap(Edge edgeInto) {
        SootMethod sootMethod = edgeInto.tgt();
        Map<Local,String> map = new HashMap<Local,String>();
        
        if (!API.v().isSystemMethod(sootMethod))
            return map;
        
        if (sootMethod.getParameterCount() == 0)
            return map;
        
        //query jsa for all arg values
        //if any are hotspots, add mapping from local to jsa value
        if (edgeInto.srcStmt() == null || !edgeInto.srcStmt().containsInvokeExpr())
            return map;

        InvokeExpr invoke = edgeInto.srcStmt().getInvokeExpr();
       
        int i = 0;
        for (Value argv : invoke.getArgs()) {
            Local local = sootMethod.getActiveBody().getParameterLocal(i);
            if (JSAStrings.v().isHotspotValue(argv)) {
                map.put(local, JSAStrings.v().getRegex(argv));
            }
            
            i++;
        }
        
        if (map.isEmpty())
            return map;
        
        //check to see if any of the local vals are lhs for any assignment
        //pull out of map if so
        for(Iterator stmts = sootMethod.getActiveBody().getUnits().iterator(); stmts.hasNext();) {
            Stmt stmt = (Stmt) stmts.next();
            if(stmt instanceof AssignStmt) {
                AssignStmt assignStmt = (AssignStmt)stmt;
                Value leftOp = assignStmt.getLeftOp();
                if (map.containsKey(leftOp))
                    map.remove(leftOp);
            }
        }
        
        return map;
    }

    @Override
    public void visitEntryContextAnd1CFA(SootMethod sootMethod, Edge entryEdge, Edge edgeInto) {

        if(!sootMethod.isConcrete())
            return;

        if(!sootMethod.hasActiveBody())
            sootMethod.retrieveActiveBody();

        Map<Local, String> jsaMap = getJSALocalMap(edgeInto);
        
        for(Iterator stmts = sootMethod.getActiveBody().getUnits().iterator(); stmts.hasNext();) {
            Stmt stmt = (Stmt) stmts.next();
            if(stmt instanceof AssignStmt) {
                AssignStmt assignStmt = (AssignStmt)stmt;
                Value leftOp = assignStmt.getLeftOp();
                Value rightOp = assignStmt.getRightOp();
                if(leftOp instanceof InstanceFieldRef) {
                    InstanceFieldRef instanceFieldRef = (InstanceFieldRef)leftOp;
                    Value baseValue = instanceFieldRef.getBase();
                    Set<AllocNode> baseAllocNodes = GeoPTA.v().getPTSetContextIns(baseValue);
                   
                    for(AllocNode allocNode : baseAllocNodes) {
                        VAModel vaModel = this.allocNodeToVAModelMap.get(allocNode);
                        if(vaModel != null) {
                            Class<?> c = vaModel.getClass();
                            String fieldName = instanceFieldRef.getField().getName();
                            try {
                                Field field = c.getDeclaredField(fieldName);
                                try {
                                    Object fieldObject = field.get(vaModel);
                                    VAModel fieldObjectVAModel = (VAModel)fieldObject;
                                    if(fieldObjectVAModel instanceof PrimVAModel) {
                                        PrimVAModel fieldPrimVAModel = (PrimVAModel)fieldObjectVAModel;
                                        if(fieldName.equals("mAction")) {
                                            System.out.println(allocNode);
                                            System.out.println("current method: " + sootMethod);
                                            System.out.println("source method: " + edgeInto.src());
                                            System.out.println(fieldPrimVAModel.getValues());
                                        }
                                       if(rightOp instanceof Constant) {
                                            Constant rightOpConstant = (Constant)rightOp;
                                            if(rightOpConstant instanceof IntConstant) {
                                                IntConstant intConstant = (IntConstant)rightOpConstant;
                                                fieldPrimVAModel.addValue(intConstant.value);
                                            } else if(rightOpConstant instanceof LongConstant) {
                                                LongConstant longConstant = (LongConstant)rightOpConstant;
                                                fieldPrimVAModel.addValue(longConstant.value);
                                            } else if(rightOpConstant instanceof DoubleConstant) {
                                                DoubleConstant doubleConstant = (DoubleConstant)rightOpConstant;
                                                fieldPrimVAModel.addValue(doubleConstant.value);
                                            } else if(rightOpConstant instanceof FloatConstant) {
                                                FloatConstant floatConstant = (FloatConstant)rightOpConstant;
                                                fieldPrimVAModel.addValue(floatConstant.value);
                                            } else {
                                                System.out.println("Unhandled constant case: " + rightOpConstant.getClass());
                                                System.exit(1);
                                            }
                                        } else if (rightOp instanceof Local && jsaMap.containsKey((Local)rightOp)) {
                                            if(fieldName.equals("mAction")){
                                                System.out.println(jsaMap.get((Local)rightOp) + "\n");
                                            }
                                            fieldPrimVAModel.addValue(jsaMap.get((Local)rightOp));

                                        } else {
                                            fieldPrimVAModel.invalidate();
                                            if(fieldName.equals("mAction")){
                                                System.out.println("invalidating");
                                            }
                                        }
                                    }
                                } catch(IllegalAccessException e) {
                                     logError(e.toString());
                                }
                            } catch(NoSuchFieldException e) {
                                logError(e.toString());
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Helper method to write to the file where we log all errors we encounter during value analysis
     */
    private void logError(String logEntry) {
        try {
            this.vaErrorsLog.write(logEntry + "\n");
        } catch (IOException ioe) {
            logger.warn("Unable to write to the va-errors.log file.", ioe);
        }
    }

    /**
     * Helper method to write to the file where we log all the value analysis statistics
     */
    private void logResult(String logEntry) {
        try {
            this.vaResultsLog.write(logEntry + "\n");
        } catch (IOException ioe) {
            logger.warn("Unable to write to the va-results.log file.", ioe);
        }
    }

    /**
     * Log the results of the modeling
     */
    private void logResults() {
        for(Map.Entry<AllocNode, VAModel> entry : allocNodeToVAModelMap.entrySet()) {
            logResult("AllocNode: " + entry.getKey().toString());
            logResult("Model: " + entry.getValue().toString());
        }
    }
}
