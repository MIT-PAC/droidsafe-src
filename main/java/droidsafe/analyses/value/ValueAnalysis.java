package droidsafe.analyses.value;

import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.helper.CallGraphTraversal;
import droidsafe.analyses.helper.CGVisitorEntryAnd1CFA;
import droidsafe.analyses.strings.JSAStrings;
import droidsafe.analyses.value.modelgen.ModelCodeGenerator;
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
     * keys are the objects that we can and want to model (they are new expressions) 
     * The value is the Model object which simulates that object. 
     */
    private Map<Object, VAModel> allocNodeToVAModelMap; 

    private Map<SootClass, Set<SootField>> classesAndFieldsToModel;

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
        this.allocNodeToVAModelMap = new LinkedHashMap<Object, VAModel>();
        this.classesAndFieldsToModel = ModelCodeGenerator.getClassesAndFieldsToModel(true);
    }

    /**
     * Getter for analysis result
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
        //TODO: Do we want to change this to getAllNewExprs()?
        for(AllocNode allocNode : GeoPTA.v().getAllAllocNodes()) {
            createObjectModel(allocNode);    
        }
    }

    //TODO: Change this to accept Object newExpr?
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
          //TODO: Change constructor of modeled class to an Object (new expr) argument?
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
            //TODO: Change constructor of modeled class to an Object (new expr) argument?
            model = (RefVAModel)ctor.newInstance(allocNode);
        } catch(Exception e){
            errorLogEntry += e.toString();
            logError(errorLogEntry);
            return;
        }
        if(model != null) {
            Object newExpr = GeoPTA.v().getNewExpr(allocNode);
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
                    Set<AllocNode> baseAllocNodes = GeoPTA.v().getPTSetContextIns(baseValue);
                   
                    for(AllocNode allocNode : baseAllocNodes) {
                        Object newExpr = GeoPTA.v().getNewExpr(allocNode);
                        VAModel vaModel = this.allocNodeToVAModelMap.get(newExpr);
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
                                        } else {
                                            fieldPrimVAModel.invalidate();
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
        for(Map.Entry<Object, VAModel> entry : allocNodeToVAModelMap.entrySet()) {
            logResult("NewExpr: " + entry.getKey().toString());
            logResult("AllocNode: " + GeoPTA.v().getAllocNode(entry.getKey()));
            logResult("Model: " + entry.getValue().toString());
        }
    }
}
