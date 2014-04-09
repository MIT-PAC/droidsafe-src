package droidsafe.main;

import au.com.bytecode.opencsv.CSVWriter;
import droidsafe.analyses.CheckInvokeSpecials;
import droidsafe.analyses.infoflow.AllocNodeUtils;
import droidsafe.analyses.infoflow.InformationFlowAnalysis;
import droidsafe.analyses.infoflow.InjectedSourceFlows;
import droidsafe.analyses.infoflow.InterproceduralControlFlowGraph;
import droidsafe.analyses.infoflow.ObjectUtils;
import droidsafe.analyses.MethodCallsOnAlloc;
import droidsafe.analyses.pta.PointsToAnalysisPackage;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.CallGraphDumper;
import droidsafe.analyses.CatchBlocks;
import droidsafe.analyses.RCFGToSSL;
import droidsafe.analyses.RequiredModeling;
import droidsafe.analyses.TestPTA;
import droidsafe.analyses.strings.JSAStrings;
import droidsafe.analyses.strings.JSAUtils;
import droidsafe.analyses.value.ValueAnalysis;
import droidsafe.analyses.value.VAStats;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Project;
import droidsafe.android.app.resources.Resources;
import droidsafe.android.app.resources.ResourcesSoot;
import droidsafe.android.app.TagImplementedSystemMethods;
import droidsafe.android.system.API;
import droidsafe.android.system.AutomatedSourceTagging;
import droidsafe.android.system.Permissions;
import droidsafe.speclang.model.AllocLocationModel;
import droidsafe.speclang.model.CallLocationModel;
import droidsafe.speclang.model.SecuritySpecModel;
import droidsafe.speclang.SecuritySpecification;
import droidsafe.transforms.CallBackModeling;
import droidsafe.transforms.ClassGetNameToClassString;
import droidsafe.transforms.InsertUnmodeledObjects;
import droidsafe.transforms.IntegrateXMLLayouts;
import droidsafe.transforms.JSAResultInjection;
import droidsafe.transforms.ObjectGetClassToClassConstant;
import droidsafe.transforms.objsensclone.ObjectSensitivityCloner;
import droidsafe.transforms.RemoveStupidOverrides;
import droidsafe.transforms.ResolveStringConstants;
import droidsafe.transforms.ScalarAppOptimizations;
import droidsafe.transforms.ServiceTransforms;
import droidsafe.transforms.StartActivityTransformStats;
import droidsafe.transforms.TransformStringBuilderInvokes;
import droidsafe.transforms.UndoJSAResultInjection;
import droidsafe.transforms.VATransformsSuite;
import droidsafe.utils.DroidsafeDefaultProgressMonitor;
import droidsafe.utils.DroidsafeExecutionStatus;
import droidsafe.utils.IDroidsafeProgressMonitor;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.time.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import checks.CloggedNativeMethods;
import soot.G;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;

/**
 * Main entry class for DroidSafe analysis.
 * 
 * @author mgordon
 * @author dpetters
 * 
 */
public class Main {

    /** logger field */
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private static IDroidsafeProgressMonitor sMonitor;

    /**
     * Entry point of DroidSafe Tool.
     * @throws FileNotFoundException 
     * 
     */
    public static void main(String[] args) throws FileNotFoundException {
        driverMsg("Starting DroidSafe Run");
        // grab command line args and set some globals
        Config.v().init(args);

        run(new DroidsafeDefaultProgressMonitor());
    }

    public static DroidsafeExecutionStatus run(IDroidsafeProgressMonitor monitor) throws FileNotFoundException {
        sMonitor = monitor;
        monitor.subTask("Initializing Environment");
        G.reset();
        // initial project directories and lib jar files
        Project.v().init();
        // configure soot and soot classpath
        SootConfig.init();
        // load the api classes and modeling classes
        API.v().init();
        // load the application classes
        Project.v().loadClasses();
        // create the permissions map
        Permissions.init();
        //sink high-level information flow mapping 
        ResourcesSoot.reset();
        JimpleRelationships.reset();
        AllocLocationModel.reset();
        CallLocationModel.reset();
        ObjectSensitivityCloner.reset();
        RCFG.reset();

        if (Config.v().infoFlowTrackAll) {
            monitor.worked(1);
            AutomatedSourceTagging.run();
            if (monitor.isCanceled()) {
                return DroidsafeExecutionStatus.CANCEL_STATUS;
            }
        }


        driverMsg("Removing identity overrides.");
        monitor.subTask("Removing identity overrides.");
        RemoveStupidOverrides.run();
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }

       driverMsg("Calling scalar optimizations.");
        monitor.subTask("Scalar Optimization");
        ScalarAppOptimizations.run();
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }

        driverMsg("Create tags for the overriden system methods in user code.");
        monitor.subTask("Create tags for overriden system methods");
        TagImplementedSystemMethods.run();
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }

        /* used when we were cloning classes 
        driverMsg("Checking invoke special calls...");
        CheckInvokeSpecials.run();
         */

        driverMsg("Resolving resources and Manifest.");
        monitor.subTask("Resolving Manifest");
        Resources.resolveManifest(Config.v().APP_ROOT_DIR);
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }

        driverMsg("Creating Harness.");
        monitor.subTask("Creating Harness");
        Harness.create();
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }

        driverMsg("Setting Harness Main as entry point.");
        monitor.subTask("Setting Harness Main as entry point");
        setHarnessMainAsEntryPoint();
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }

        if (afterTransformFast(monitor, false) == DroidsafeExecutionStatus.CANCEL_STATUS)
            return DroidsafeExecutionStatus.CANCEL_STATUS;

        driverMsg("Incorporating XML layout information");
        monitor.subTask("Incorporating XML layout information");
        IntegrateXMLLayouts.run();
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }

        driverMsg("Resolving String Constants");
        monitor.subTask("Resolving String Constants");
        ResolveStringConstants.run(Config.v().APP_ROOT_DIR);
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }

        if (Config.v().addFallbackModeling) {
            //fallback modeling...

            if (afterTransformFast(monitor, false) == DroidsafeExecutionStatus.CANCEL_STATUS)
                return DroidsafeExecutionStatus.CANCEL_STATUS;

            driverMsg ("Adding Missing Modeling...");
            monitor.subTask("Adding Missing Modeling...");
            CallBackModeling.v().run();
            monitor.worked(1);
            if (monitor.isCanceled())
                return DroidsafeExecutionStatus.CANCEL_STATUS;
        }

        //run jsa after we inject strings from XML values and layout
        //does not need a pta run before
        driverMsg("Starting String Analysis...");
        StopWatch timer1 = new StopWatch();
        timer1.start();
        JSAStrings.init(Config.v());
        if (Config.v().runStringAnalysis) {
            monitor.subTask("Running String Analysis.");
            jsaAnalysis(monitor);
        }
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }
        timer1.stop();
        driverMsg("Finished String Analysis: " + timer1);

        driverMsg("Cloning static methods to introduce call site context...");
        monitor.subTask("Cloning static methods to introduce callsite context...");
        ObjectSensitivityCloner.cloneStaticMethods(true);
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        } 

        //run value analysis, if it runs, then the code may have veen transformed
        if (Config.v().runValueAnalysis) {
            runVA(monitor);
        }

        {
            //patch in messages
            ServiceTransforms.v().run();
            
        }
        
        //add fallback object modeling for any value from the api that leaks into user
        //code as null    
        if (Config.v().addFallbackModeling) {

            if (afterTransformFast(monitor, false) == DroidsafeExecutionStatus.CANCEL_STATUS)
                return DroidsafeExecutionStatus.CANCEL_STATUS;

            driverMsg("Inserting Unmodeled Objects...");
            monitor.subTask("Inserting Unmodeled Objects...");
            InsertUnmodeledObjects.v().run();
            monitor.worked(1);
            if (monitor.isCanceled()) {
                return DroidsafeExecutionStatus.CANCEL_STATUS;
            }
        }

        {
            //account for any transformations
            if (afterTransformFast(monitor, false) == DroidsafeExecutionStatus.CANCEL_STATUS)
                return DroidsafeExecutionStatus.CANCEL_STATUS;

            // Search for catch blocks
            if (Config.v().runCatchBlocksFast) {
            	driverMsg ("Searching for catch blocks (fast)");
            	StopWatch cbtimer = new StopWatch();
            	cbtimer.start();
            	CatchBlocks cb = new CatchBlocks();
            	cb.run();
            	cbtimer.stop();
            	driverMsg ("Finished Catch Block Analysis: " + cbtimer);
            	System.exit (0);
            } else {
            	driverMsg ("no catch block run");
            }

            if (Config.v().dumpCallGraph) {
                CallGraphDumper.runGEXF(Project.v().getOutputDir() + File.separator + "callgraph.gexf");
            }

            //so that we don't lose a level of object sensitive in AbstractStringBuilder.toString()
            //replace calls with new expressions, and let the modeling pass taint appropriately
            driverMsg("Converting AbstractStringBuilder.toString()");
            TransformStringBuilderInvokes.run();
        }

        if (afterTransformPrecise(monitor, false) == DroidsafeExecutionStatus.CANCEL_STATUS)
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        
        // Search for catch blocks
        if (Config.v().runCatchBlocks) {
            driverMsg ("Searching for catch blocks (precise)");
            StopWatch cbtimer = new StopWatch();
            cbtimer.start();
            CatchBlocks cb = new CatchBlocks();
            cb.run();
            cbtimer.stop();
            driverMsg ("Finished Catch Block Analysis: " + cbtimer);
        }
       
        //new TestPTA();

        driverMsg("Starting Generate RCFG...");
        StopWatch rcfgTimer = new StopWatch();
        rcfgTimer.start();
        monitor.subTask("Generating Spec");
        RCFG.generate();
        rcfgTimer.stop();
        driverMsg("Finished Generating RCFG: " + rcfgTimer);
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }

        if (Config.v().dumpVAStats) {
            driverMsg("Dumping Value Analysis Stats");
            monitor.subTask("Dumping Value Analysis Stats");
            StopWatch vaStatsTimer = new StopWatch();
            vaStatsTimer.start();
            VAStats.run();
            vaStatsTimer.stop();
            monitor.worked(1);
            if (monitor.isCanceled()) {
                return DroidsafeExecutionStatus.CANCEL_STATUS;
            }
            driverMsg("Finished Dumping Value Analysis Stats: " + vaStatsTimer.toString());
        }

        // print out what modeling is required for this application
        monitor.subTask("Required Modeling");
        RequiredModeling.run();
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }


        if (Config.v().writeJimpleAppClasses) {
            driverMsg("Writing Jimple Classes.");
            monitor.subTask("Writing all app classes");
            writeAllAppClasses();
        }
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }

        if (Config.v().infoFlow) {
            // ObjectSensitivityCloner.v().runForInfoFlow();

            StopWatch timer = new StopWatch();
            driverMsg("Starting Information Flow Analysis...");
            monitor.subTask("Information Flow Analysis: Injected source flow");
            timer.start();
            InjectedSourceFlows.run();
            if (monitor.isCanceled()) {
                return DroidsafeExecutionStatus.CANCEL_STATUS;
            }
            monitor.subTask("Information Flow Analysis: Control flow graph");
            ObjectUtils.run();
            InterproceduralControlFlowGraph.run();
            if (monitor.isCanceled()) {
                return DroidsafeExecutionStatus.CANCEL_STATUS;
            }
            monitor.subTask("Information Flow Analysis: Information flow");
            AllocNodeUtils.run();
            InformationFlowAnalysis.run();
            if (monitor.isCanceled()) {
                return DroidsafeExecutionStatus.CANCEL_STATUS;
            }

            try {
                String[] values = Config.v().infoFlowValues;
                if (values != null) {
                    for (String value : values) {
                        String pathName = Project.v().getOutputDir() + File.separator + value + ".txt";
                        BufferedWriter writer = new BufferedWriter(new FileWriter(pathName));
                        InformationFlowAnalysis.v().printContextLocals(value, writer);
                        InformationFlowAnalysis.v().printAllocNodeFields(value, writer);
                        InformationFlowAnalysis.v().printAllocNodes(value, writer);
                        InformationFlowAnalysis.v().printFields(value, writer);
                        writer.close();
                    }
                }
            } catch (IOException exp) {
                logger.error(exp.toString());
            }

            if (Config.v().infoFlowNative) {
                try {
                    CloggedNativeMethods.run();
                } catch (IOException exp) {
                    logger.error(exp.toString());
                }
            }

            timer.stop();
            droidsafe.stats.AvgInfoFlowSetSize.run();
            driverMsg("Finished Information Flow Analysis: " + timer);
        }
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }

        if (Config.v().ptaresult) {
            driverMsg("Finding method calls on all important alloc nodes...");
            monitor.subTask("Generating Spec");
            MethodCallsOnAlloc.run();
            driverMsg("Finished finding method calls on alloc nodes.");
            monitor.worked(1);
            if (monitor.isCanceled()) {
                return DroidsafeExecutionStatus.CANCEL_STATUS;
            }
        }

        if (Config.v().target.equals("specdump")) {
            driverMsg("Converting RCFG to SSL and dumping...");
            monitor.subTask("Writing Spec to File");
            StopWatch timer = new StopWatch();
            timer.start();
            RCFGToSSL.run(false);
            SecuritySpecification spec = RCFGToSSL.v().getSpec();
            monitor.worked(1);
            if (monitor.isCanceled()) {
                return DroidsafeExecutionStatus.CANCEL_STATUS;
            }
            timer.stop();
            driverMsg("Finished converting RCFG to SSL and dumping: " + timer);

            if (spec != null) {
                driverMsg("Creating Eclipse Plugin Serialized Specification...");
                timer.reset();
                timer.start();
                SecuritySpecModel securitySpecModel = new SecuritySpecModel(spec, Config.v().APP_ROOT_DIR);
                SecuritySpecModel.serializeSpecToFile(securitySpecModel, Config.v().APP_ROOT_DIR);
                if (Config.v().debug)
                    SecuritySpecModel.printSpecInfo(securitySpecModel, Config.v().APP_ROOT_DIR);
                timer.stop();
                driverMsg("Finished Eclipse Plugin Serialized Specification: " + timer);
            }
            monitor.worked(1);
            if (monitor.isCanceled()) {
                return DroidsafeExecutionStatus.CANCEL_STATUS;
            }

        } else if (Config.v().target.equals("confcheck")) {
            driverMsg("Converting RCFG to SSL ...");
            RCFGToSSL.run(true);
            logger.error("Not implemented yet!");
        }

        monitor.worked(1);
        System.out.println("Finished!");
        return DroidsafeExecutionStatus.OK_STATUS;
    }

    /**
     * Run the JSA analysis
     */
    private static DroidsafeExecutionStatus jsaAnalysis(IDroidsafeProgressMonitor monitor) {
        //set up the executor for the timeouts
        //set as single thread executor so no threads get away from us
        JSAStrings.executor = Executors.newSingleThreadExecutor();

        monitor.subTask("String Analysis: Setting Hotspots");
        JSAUtils.setupSpecHotspots();
        if (monitor.isCanceled()) {
            JSAStrings.executor.shutdownNow();
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }

        monitor.subTask("String Analysis: Running Analysis");
        JSAStrings.run();
        if (monitor.isCanceled()) {
            JSAStrings.executor.shutdownNow();
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }

        monitor.subTask("String Analysis: Logging");
        JSAStrings.v().log();
        if (monitor.isCanceled()) {
            JSAStrings.executor.shutdownNow();
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }

        JSAStrings.executor.shutdownNow();
        return DroidsafeExecutionStatus.OK_STATUS;
    }

    private static DroidsafeExecutionStatus runVA(IDroidsafeProgressMonitor monitor) {
        if (afterTransformMedium(monitor, false) == DroidsafeExecutionStatus.CANCEL_STATUS)
            return DroidsafeExecutionStatus.CANCEL_STATUS;

        driverMsg("Injecting String Analysis Results.");
        monitor.subTask("Injecting String Analysis Results.");
        JSAResultInjection.run();
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }

        // ObjectGetClassToClassConstant must run before ClassGetNameToClassString 
        driverMsg("Converting Object.getClass calls to class constant.");
        monitor.subTask("Converting Object.getClass calls to class constant.");
        ObjectGetClassToClassConstant.run();
        monitor.worked(1);
        if (monitor.isCanceled())
            return DroidsafeExecutionStatus.CANCEL_STATUS;

        driverMsg("Converting Class.getName calls to class name strings.");
        monitor.subTask("Converting Class.getName calls to class name strings.");
        ClassGetNameToClassString.run();
        monitor.worked(1);
        if (monitor.isCanceled())
            return DroidsafeExecutionStatus.CANCEL_STATUS;
               
        //need this pta run to account for jsa injection and class / forname
        if (afterTransformPrecise(monitor, true) == DroidsafeExecutionStatus.CANCEL_STATUS)
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        monitor.worked(1);

        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }

        driverMsg("Starting Value Analysis");
        monitor.subTask("Value Analysis");
        StopWatch vaTimer = new StopWatch();
        vaTimer.start();
        ValueAnalysis.run();
        vaTimer.stop();
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }
        driverMsg("Finished Value Analysis: " + vaTimer);

        vaTimer.reset();
        vaTimer.start();
        driverMsg("Running Value Analysis Tranform Suite...");
        VATransformsSuite.run();
        driverMsg("Finished Value Analysis Transforms Suite: " + vaTimer);

        if (Config.v().dumpICCStats) {
            driverMsg("Dumping ICC Stats");
            monitor.subTask("Dumping ICC Stats");
            StopWatch iccStatsTimer = new StopWatch();
            iccStatsTimer.start();
            StartActivityTransformStats.run();
            iccStatsTimer.stop();
            monitor.worked(1);
            if (monitor.isCanceled()) {
                return DroidsafeExecutionStatus.CANCEL_STATUS;
            }
            driverMsg("Finished Computing ICC Stats: " + iccStatsTimer.toString());
        }


        driverMsg("Undoing String Analysis Result Injection.");
        monitor.subTask("Undoing String Analysis Result Injection.");
        UndoJSAResultInjection.run();
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }

        return DroidsafeExecutionStatus.OK_STATUS;
    }

    /**
     * Print message to out and to logger.
     * 
     * @param str
     */
    private static void driverMsg(String str) {
        System.out.println(str);
        logger.info(str);
    }

    public static DroidsafeExecutionStatus afterTransformFast(IDroidsafeProgressMonitor monitor, boolean recordTime) {
        Map<String,String> opts = new HashMap<String,String>();

        if (Config.v().POINTS_TO_ANALYSIS_PACKAGE == PointsToAnalysisPackage.SPARK) {
            //build fast options for spark
            opts.put("merge-stringbuffer","true");   
            opts.put("string-constants","false");   
            opts.put("kobjsens", "0");
        } 

        return afterTransform(monitor, recordTime, opts);
    }

    public static DroidsafeExecutionStatus afterTransformMedium(IDroidsafeProgressMonitor monitor, boolean recordTime) {
        Map<String,String> opts = new HashMap<String,String>();

        if (Config.v().POINTS_TO_ANALYSIS_PACKAGE == PointsToAnalysisPackage.SPARK) {
            //build fast options for spark
            opts.put("merge-stringbuffer","true");   
            opts.put("string-constants","true");   
            opts.put("kobjsens", "1");
        } 

        return afterTransform(monitor, recordTime, opts);
    }
    
    public static DroidsafeExecutionStatus afterTransformPrecise(IDroidsafeProgressMonitor monitor, boolean recordTime) {
        Map<String,String> opts = new HashMap<String,String>();

        if (Config.v().POINTS_TO_ANALYSIS_PACKAGE == PointsToAnalysisPackage.SPARK) {
            //build precise options for spark
            //build fast options for spark
            opts.put("merge-stringbuffer","false");   
            opts.put("string-constants","true");   
            opts.put("kobjsens", Integer.toString(Config.v().kobjsens));
        } 

        return afterTransform(monitor, recordTime, opts);   
    }

    /**
     * Called after one or more transforms to recalculate any underlying analysis.
     */
    private static DroidsafeExecutionStatus afterTransform(IDroidsafeProgressMonitor monitor, 
                                                           boolean recordTime, 
                                                           Map<String, String> opts) {
        Scene.v().releaseActiveHierarchy();
        driverMsg("Running PTA...");
        monitor.subTask("Running PTA");
        StopWatch timer = new StopWatch();
        timer.start();
        PTABridge.release();
        PTABridge.run(Config.v().POINTS_TO_ANALYSIS_PACKAGE, opts);
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }

        logger.info("Caching Jimple Hierarchy Relationships...");
        monitor.subTask("Caching Jimple Hierarchy Relationships...");
        JimpleRelationships.reset();
        JimpleRelationships.v();
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }

        timer.stop();

        driverMsg("Finished PTA: " + timer);

        return DroidsafeExecutionStatus.OK_STATUS;
    }

    /**
     * Set's harness as entry point for Soot. Run after EntryPoints.
     */
    private static void setHarnessMainAsEntryPoint() {
        List<SootMethod> entryPoints = new LinkedList<SootMethod>();
        entryPoints.add(Harness.v().getMain());
        Scene.v().setEntryPoints(entryPoints);
        // Scene.v().setMainClass(Harness.v().getHarnessClass());
    }

    /**
     * Dump jimple files for all application classes.
     */
    private static void writeAllAppClasses() {
        for (SootClass clz : Scene.v().getClasses()) {
            if (clz.isApplicationClass() /* && Project.v().isSrcClass(clz.toString()) */) {
                SootUtils.writeByteCodeAndJimple(
                    Project.v().getOutputDir(), clz);
            }
        }
    }

    /**
     * Handles the error in the analysis. If the flag Config.callSystemExitOnError is true, the
     * application will exit, otherwise it will just throw an exception.
     * 
     * @param status
     */
    public static void exit(int status) {
        if (Config.v().getCallSystemExitOnError()) {
            System.exit(status);
        } else {
            throw new IllegalStateException();
        }
    }
}
