package droidsafe.analyses.value;

import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.helper.CallGraphContextVisitor;
import droidsafe.analyses.helper.CallGraphTraversal;
import droidsafe.analyses.value.VAModel;

import droidsafe.android.app.Project;

import droidsafe.speclang.Method;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.lang.reflect.Constructor;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.AssignStmt;
import soot.jimple.Constant;
import soot.jimple.InstanceFieldRef;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.Edge;

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
public class ValueAnalysis extends CallGraphContextVisitor {

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

    /** 
     * Determined whether the analysis should be run again. Used to make sure the analysis runs to a fixed point.
     */
    public static boolean runAgain = false;

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
            !this.allocNodeToVAModelMap.get(node).__ds__invalidated();
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

        am.createObjectModels();

        am.runOnce();
        
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

    /** run the full analysis once */ 
    public static void runOnce() {
        CallGraphTraversal.accept(am);
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
            this.logError(errorLogEntry);
            return;
        } catch(SecurityException e) {
            errorLogEntry += e.toString();
            this.logError(errorLogEntry);
            return;
        }

        try {
            model = (RefVAModel)ctor.newInstance(allocNode);
        } catch(Exception e){
            errorLogEntry += e.toString();
            this.logError(errorLogEntry);
            return;
        }

        this.allocNodeToVAModelMap.put(allocNode, model);
    }

    @Override
    public void visitEntryContext(SootMethod sootMethod, Edge entryEdge) {

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
                    if(rightOp instanceof Constant) {
                        Constant rightOpConstant = (Constant)rightOp;
                        logResult(assignStmt.toString());
                        logResult(instanceFieldRef.toString());
                        logResult(rightOp.getType().toString());
                        logResult(rightOpConstant.toString());
                        logResult("\n");
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
            //logResult("AllocNode: " + entry.getKey().toString());
            //logResult("Model: " + entry.getValue().__ds__toString());
        }
    }
}
