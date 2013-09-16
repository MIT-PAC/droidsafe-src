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
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.Edge;

import soot.RefType;

import soot.SootClass;

import soot.SootMethod;

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
public class ValueAnalysis implements CallGraphContextVisitor {

    /** Singleton for analysis */
    private static ValueAnalysis am;

    /** 
     * AllocNode keys are the objects that we can and want to model. 
     * The value is the Model object which simulates that object. 
     */
    private Map<AllocNode, VAModel> allocNodeToVAModel; 

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

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /** Private constructor to enforce singleton pattern */
    private ValueAnalysis() {
        this.allocNodeToVAModel = new LinkedHashMap<AllocNode, VAModel>();
    }


    //==================================================================================================================
    // Public Methods
    //==================================================================================================================

    /**
     * Getter for analysis result
     */
    public Map<AllocNode, VAModel> getResults() {
        return this.allocNodeToVAModel;
    }

    /**
     * Return true if this alloc node has an analysis result (and is not invalidated)
     */
    public boolean hasResult(AllocNode node) {
        return this.allocNodeToVAModel.containsKey(node) &&
            !this.allocNodeToVAModel.get(node).__ds__invalidated();
    }

    /**
     * Return the ModeledObject result for a given alloc node.
     */
    public VAModel getResult(AllocNode node) {
        return this.allocNodeToVAModel.get(node);
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
        return Class.forName(ValueAnalysisUtils.toAttrModelingModelClass(className));
    }

    //==================================================================================================================
    // Static Methods
    //==================================================================================================================

    /** access to the singleton instance */
    public static ValueAnalysis v() {
        return am;
    }
    
    /** run the analysis to fixed point */
    public static void run() {
        if (GeoPTA.v() == null) {
            logger.error("The GeoPTA pass has not been run. Value analysis requires it.");
            droidsafe.main.Main.exit(1);
        }      
       
        if (am == null)
            am = new ValueAnalysis();

        runOnce();
        
        System.out.print("\n");

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
        if (GeoPTA.v() == null) {
            logger.error("The GeoPTA pass has not been run. Value analysis requires it.");
            droidsafe.main.Main.exit(1);
        }      

        // va errors file used to help figure out what to model
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

        CallGraphTraversal.accept(am);
    }

    @Override
    public void visit(SootMethod sootMethod, Edge context, Edge edgeInto) {
        
        if(!sootMethod.isConcrete())
            return;
        
        if(!sootMethod.hasActiveBody())
            sootMethod.retrieveActiveBody();

        if(!GeoPTA.v().isValidMethod(sootMethod))
            return;

        logResult(sootMethod.toString());
        for(Iterator stmts = sootMethod.getActiveBody().getUnits().iterator(); stmts.hasNext();) {
            Stmt stmt = (Stmt) stmts.next();
            /*
            if(stmt instanceof AssignStmt) {
              AssignStmt assignStmt = (AssignStmt)stmt;
              Value leftOp = assignStmt.getLeftOp();
              if(leftOp instanceof InstanceFieldRef) {
                InstanceFieldRef instanceFieldRef = (InstanceFieldRef)leftOp;
                Value baseValue = instanceFieldRef.getBase();

              }
            }
            */
            //logResult(stmt.toString());
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

    }
}
