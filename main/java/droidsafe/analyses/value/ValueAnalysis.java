package droidsafe.analyses.value;

import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.helper.CallGraphTraversal;
import droidsafe.analyses.helper.CGVisitorEntryAnd1CFA;
import droidsafe.analyses.value.primitives.StringVAModel;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.speclang.Method;
import droidsafe.transforms.JSAResultInjection;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashSet;
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
import soot.jimple.LongConstant;
import soot.jimple.StringConstant;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.spark.pag.StringConstantNode;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.Edge;
import soot.RefType;
import soot.SootClass;
import soot.SootField;
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
     * Sometimes the api has values that are useful, but also sometimes, if we track
     * api generated values, we get a huge blowup, so we limit the number of values that we track here,
     * that are generated in the api code and not in app source.
     */
    private static final int MAX_NUM_OF_NON_APP_VALUES_TO_TRACK = 5;

    /** 
     * keys are the objects that we can and want to model (they are new expressions) 
     * The value is the Model object which simulates that object. 
     */
    private Map<Object, VAModel> allocNodeToVAModelMap; 

    private Map<SootClass, Set<SootField>> classesAndFieldsToModel;

    /** va errors file used to help figure out what to model */
    public static FileWriter vaErrorsLog;

    /** va stats file */
    public static FileWriter vaResultsLog;

    /** Generic logger */
    private static final Logger logger = LoggerFactory.getLogger(ValueAnalysis.class);

    /** The package of the value analysis models */
    public static final String MODEL_PACKAGE = "droidsafe.analyses.value.VAResultContainerClasses";

    /** The prefix that is prepended to fully qualified value analysis models */
    public static final String MODEL_PACKAGE_PREFIX = MODEL_PACKAGE + ".";

    /** Private constructor to enforce singleton pattern */
    private ValueAnalysis() {
        this.allocNodeToVAModelMap = new LinkedHashMap<Object, VAModel>();
        this.classesAndFieldsToModel = VAResultContainerClassGenerator.getClassesAndFieldsToModel(true);
    }

    /**
     * Getter for analysis result.  Jimple NewExpr -> VAModel.
     */
    public Map<Object, VAModel> getResults() {
        return this.allocNodeToVAModelMap;
    }

    /**
     * Getter for analysis result
     */
    public Map<SootClass, Set<SootField>> getClassesAndFieldsToModel() {
        return this.classesAndFieldsToModel;
    }

    /**
     * Return true if this alloc node has an analysis result (and is not invalidated)
     */
    public boolean hasResult(AllocNode node) {
        Object newExpr = GeoPTA.v().getNewExpr(node);

        return this.allocNodeToVAModelMap.containsKey(newExpr) &&
                !this.allocNodeToVAModelMap.get(newExpr).invalidated();
    }

    /**
     * Return the ModeledObject result for a given alloc node.
     */
    public VAModel getResult(AllocNode node) {
        Object newExpr = GeoPTA.v().getNewExpr(node);

        return this.allocNodeToVAModelMap.get(newExpr);
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
            vaErrorsLog = new FileWriter(Project.v().getOutputDir() + File.separator 
                + "va-errors.log");
        } catch (Exception e) {
            logger.warn("Unable to open va-errors.log:", e);
        }

        try {
            vaResultsLog = new FileWriter(Project.v().getOutputDir() + File.separator 
                + "va-results.log");
        } catch (Exception e) {
            logger.warn("Unable to open va-results.log: ", e);
        }

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
            Object newExpr = GeoPTA.v().getNewExpr(allocNode);
            createObjectModel(allocNode, newExpr);    
        }
    }

    public void createObjectModel(AllocNode allocNode, Object newExpr) {
        if(!(allocNode.getType() instanceof RefType)) {
            this.logError(allocNode.toString());
            return;
        }
        RefType refType = (RefType)allocNode.getType();

        String errorLogEntry = "Couldn't model an instance of the " + refType.getSootClass().getName() + " ";

        SootClass sootClass = refType.getSootClass();

        Class<?> cls = null;
        while(sootClass.hasSuperclass() && cls == null) {
            try {
                cls = VAUtils.getDroidsafeClass(sootClass);
            } catch(ClassNotFoundException e) {
                errorLogEntry += e.toString();
                this.logError(errorLogEntry);
                sootClass = sootClass.getSuperclass();
            }
        }

        if (cls == null) {
            return;
        }

        RefVAModel model = null;
        Constructor<?> ctor;
        try {
            ctor = cls.getConstructor(Object.class);
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
            model = (RefVAModel)ctor.newInstance(newExpr);
        } catch(Exception e){
            errorLogEntry += e.toString();
            logError(errorLogEntry);
            return;
        }
        if(model != null) {
            this.allocNodeToVAModelMap.put(newExpr, model);
        }
    }
 
    @Override
    public void visitEntryContextAnd1CFA(SootMethod sootMethod, Edge entryEdge, Edge edgeInto) {

        if(!sootMethod.isConcrete())
            return;

        if(!sootMethod.hasActiveBody())
            sootMethod.retrieveActiveBody();

        for(Iterator stmts = sootMethod.getActiveBody().getUnits().iterator(); stmts.hasNext();) {
            Stmt stmt = (Stmt) stmts.next();
            if(stmt instanceof AssignStmt) {
                AssignStmt assignStmt = (AssignStmt)stmt;
                Value leftOp = assignStmt.getLeftOp();
                Value rightOp = assignStmt.getRightOp();
                if(leftOp instanceof InstanceFieldRef) {
                    InstanceFieldRef instanceFieldRef = (InstanceFieldRef)leftOp;
                    Value baseValue = instanceFieldRef.getBase();
                    Set<AllocNode> baseAllocNodes = GeoPTA.v().getPTSetEventContext(baseValue, entryEdge);
                    for(AllocNode allocNode : baseAllocNodes) {
                        Object newExpr = GeoPTA.v().getNewExpr(allocNode);
                        VAModel vaModel = this.allocNodeToVAModelMap.get(newExpr);
                        if(vaModel != null) {
                            Class<?> c = vaModel.getClass();
                            String fieldName = instanceFieldRef.getField().getName();
                            try {
                                Field field = c.getField(fieldName);
                                try {
                                    Object fieldObject = field.get(vaModel);
                                    VAModel fieldObjectVAModel = (VAModel)fieldObject;
                                    if(fieldObjectVAModel instanceof PrimVAModel) {
                                        PrimVAModel fieldPrimVAModel = (PrimVAModel)fieldObjectVAModel;
                                        if (fieldPrimVAModel instanceof StringVAModel) {
                                            handleString(assignStmt, fieldPrimVAModel, entryEdge);
                                        } else  {
                                            //primitive, but not string primitive
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
                                                    System.out.println("Unhandled constant case: " + 
                                                            rightOpConstant.getClass());
                                                    System.exit(1);
                                                }
                                            } else {
                                                fieldPrimVAModel.invalidate();
                                            }
                                        }
                                    }
                                } catch(IllegalAccessException e) {
                                }
                            } catch(NoSuchFieldException e) {
                            }
                        }
                    }
                }
            }
        }
    }

    
    /**
     * Handle case where type for assignment is a string
     */
    private void handleString(AssignStmt assignStmt, PrimVAModel fieldPrimVAModel, Edge entryEdge) {
        //Found string
        //System.out.println("Found String!!: " + fieldObject);
        Set<AllocNode> rhsNodes;
        
        //get the string nodes the rhs expression could possibly point to
        if (assignStmt.getRightOp() instanceof StringConstant) {
            //if a direct string constant, then get the string constant node from pta
            rhsNodes = new HashSet<AllocNode>();
            rhsNodes.add(GeoPTA.v().getAllocNode(assignStmt.getRightOp()));
        } else {
            //if not a string constant, then query pta
            rhsNodes = GeoPTA.v().getPTSetEventContext(assignStmt.getRightOp(), entryEdge);
        }
        
        int nonAppValues = 0;
        for(AllocNode rhsNode : rhsNodes) {
            boolean knownValue = false;
            if(rhsNode instanceof StringConstantNode) {
                //logger.info("handleString: {}", rhsNode.getMethod());
                StringConstant sc = (StringConstant)rhsNode.getNewExpr();
                //are we tracking all strings, or just the strings injected by jsa for api calls in user code
                if (nonAppValues < MAX_NUM_OF_NON_APP_VALUES_TO_TRACK || 
                        JSAResultInjection.createdStringConstants.contains(sc)) {
                    String value = ((StringConstantNode)rhsNode).getString();
                    value = value.replaceAll("(\\r|\\n)", "");
                    value = value.replace("\"", "");
                    value = value.replace("\\uxxxx", "");
                    fieldPrimVAModel.addValue(value);
                    knownValue = true;
                    if (!JSAResultInjection.createdStringConstants.contains(sc))
                        nonAppValues++;
                }
            }
            if (!knownValue) {
                // all strings weren't constants, write unknown value
                ValueAnalysis.logError(fieldPrimVAModel.toString() + 
                    " the value it is assigned, " + 
                    rhsNode + " is not a constant. Contained values beforehand: " + 
                    fieldPrimVAModel.getValues());
                fieldPrimVAModel.addValue("UNKNOWN");
            }
        }                           
    }

    
    /**
     * Helper method to write to the file where we log all errors we encounter during value analysis
     */
    public static void logError(String logEntry) {
        /*
        try {
            vaErrorsLog.write(logEntry + "\n");
        } catch (IOException ioe) {
            logger.warn("Unable to write to the va-errors.log file.", ioe);
        }
         */
    }

    /**
     * Helper method to write to the file where we log all the value analysis statistics
     */
    public static void logResult(String logEntry) {
        try {
            vaResultsLog.write(logEntry + "\n");
        } catch (IOException ioe) {
            //logger.warn("Unable to write to the va-results.log file.", ioe);
        }
    }

    /**
     * Log the results of the modeling
     */
    private void logResults() {
        for(Map.Entry<Object, VAModel> entry : allocNodeToVAModelMap.entrySet()) {
            logResult("NewExpr: " + entry.getKey().toString());
            logResult("AllocNode: " + GeoPTA.v().getAllocNode(entry.getKey()));
            logResult("Model: " + entry.getValue().toStringPretty());
        }
    }
}
