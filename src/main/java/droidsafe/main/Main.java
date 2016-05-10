/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

package droidsafe.main;

import au.com.bytecode.opencsv.CSVWriter;
import droidsafe.analyses.CheckInvokeSpecials;
import droidsafe.analyses.cg.collapsedcg.CollaspedCallGraph;
import droidsafe.analyses.errorhandling.ErrorHandlingAnalysis;
import droidsafe.analyses.infoflow.InformationFlowAnalysis;
import droidsafe.analyses.infoflow.InjectedSourceFlows;
import droidsafe.analyses.interapp.GenerateInterAppSourceFlows;
import droidsafe.analyses.interapp.InjectInterAppFlows;
import droidsafe.analyses.MethodCallsOnAlloc;
import droidsafe.analyses.pta.PointsToAnalysisPackage;
import droidsafe.analyses.pta.IntrospectiveAnalysis;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.CallGraphDumper;
import droidsafe.analyses.CatchBlocks;
import droidsafe.analyses.RCFGToSSL;
import droidsafe.analyses.RequiredModeling;
import droidsafe.analyses.TestPTA;
import droidsafe.analyses.allocationgraph.AllocationGraph;
import droidsafe.analyses.strings.JSAStrings;
import droidsafe.analyses.strings.JSAUtils;
import droidsafe.analyses.value.ValueAnalysis;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Project;
import droidsafe.android.app.resources.Resources;
import droidsafe.android.app.resources.ResourcesSoot;
import droidsafe.android.app.TagImplementedSystemMethods;
import droidsafe.android.system.API;
import droidsafe.android.system.AutomatedSourceTagging;
import droidsafe.android.system.Permissions;
import droidsafe.reports.ICCEntryPointCallTree;
import droidsafe.reports.ICCMap;
import droidsafe.reports.IPCEntryPointCallTree;
import droidsafe.reports.InfoFlowReportNoRCFG;
import droidsafe.reports.InformationFlowReport;
import droidsafe.reports.ObjectMethodOverrideContracts;
import droidsafe.reports.SensitiveSources;
import droidsafe.reports.SourceCallTree;
import droidsafe.reports.UnresolvedICC;
import droidsafe.reports.AllEntryPointCallTree;
import droidsafe.speclang.model.AllocLocationModel;
import droidsafe.speclang.model.CallLocationModel;
import droidsafe.speclang.model.SecuritySpecModel;
import droidsafe.speclang.SecuritySpecification;
import droidsafe.stats.IntentResolutionStats;
import droidsafe.stats.PTAPaper;
import droidsafe.transforms.ArrayNewInstanceTransform;
import droidsafe.transforms.CallBackModeling;
import droidsafe.transforms.ClassGetNameToClassString;
import droidsafe.transforms.FilePrecisionTransforms;
import droidsafe.transforms.InsertUnmodeledObjects;
import droidsafe.transforms.IntegrateXMLLayouts;
import droidsafe.transforms.JSAResultInjection;
import droidsafe.transforms.NativeMethodBuilder;
import droidsafe.transforms.ObjectGetClassToClassConstant;
import droidsafe.transforms.objsensclone.ObjectSensitivityCloner;
import droidsafe.transforms.va.VATransformsSuite;
import droidsafe.transforms.RemoveStupidOverrides;
import droidsafe.transforms.ResolveStringConstants;
import droidsafe.transforms.ScalarAppOptimizations;
import droidsafe.transforms.TransformStringBuilderInvokes;
import droidsafe.transforms.UndoJSAResultInjection;
import droidsafe.utils.DroidsafeDefaultProgressMonitor;
import droidsafe.utils.DroidsafeExecutionStatus;
import droidsafe.utils.IDroidsafeProgressMonitor;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.time.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import checks.CloggedNativeMethods;
import soot.Context;
import soot.G;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.spark.pag.InsensitiveAllocNode;
import soot.jimple.spark.pag.ObjectSensitiveAllocNode;
import soot.jimple.spark.pag.ObjectSensitiveConfig;
import soot.jimple.toolkits.pta.IAllocNode;

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

    private static Date startTime;

    private static final String COMPLETION_FILE_NAME = "completed.log";

    private static String commandLineArgs = "";

    /**
     * Entry point of DroidSafe Tool.
     * @throws FileNotFoundException 
     * 
     */
    public static void main(String[] args) throws FileNotFoundException {
        driverMsg("Starting DroidSafe Run");

        for (String arg : args) {
            commandLineArgs += (arg + " ");
        }

        // grab command line args and set some globals
        Config.v().init(args);

        IDroidsafeProgressMonitor monitor = new DroidsafeDefaultProgressMonitor();

        common_init(monitor);

        //run the main target
        if (Config.v().target.equals("errorhandling")) {
            run_errorhandling(monitor);
        } else if (Config.v().target.equals("specdump")) {
            run_specdump(monitor);
        } else {
            logger.error("Unknown DroidSafe run target: {}", Config.v().target);
        }

        writeCompletionFile();
        System.out.println("Finished!");
        System.exit(0);
    }

    /**
     * Perform initialization tasks common to all targets.
     */
    private static DroidsafeExecutionStatus common_init(IDroidsafeProgressMonitor monitor) {

        //get current date time with Date()
        startTime = new Date();

        monitor.subTask("Initializing Environment");
        G.reset();
        // initial project directories and lib jar files
        Project.v().init();
        // configure soot and soot classpath

        //delete completed file if it exist 
        try {
            File completedFile = new File(Project.v().getOutputDir() + File.separator + COMPLETION_FILE_NAME);
            if (completedFile.exists() && !completedFile.isDirectory()) {
                completedFile.delete();
            }
        } catch (Exception e) {
            logger.error("Could not delete completed file!", e);
        }

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

        driverMsg("Create tags for the overriden system methods in user code.");
        monitor.subTask("Create tags for overriden system methods");
        TagImplementedSystemMethods.run();
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }

        return DroidsafeExecutionStatus.OK_STATUS;
    }

    public static DroidsafeExecutionStatus run_errorhandling(IDroidsafeProgressMonitor monitor) {
        ErrorHandlingAnalysis.v().run(monitor);
        return DroidsafeExecutionStatus.OK_STATUS;
    }

    public static DroidsafeExecutionStatus run_specdump(IDroidsafeProgressMonitor monitor) throws FileNotFoundException {
        //used to create the eng 4a concrete methods list
        //dumpConcreteMethods();

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
        
        driverMsg("Converting java.lang.reflect.Array.newInstance()...");
        monitor.subTask("Converting java.lang.reflect.Array.newInstance()...");
        ArrayNewInstanceTransform.run();
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }
        
        if (Config.v().scalarOpts) {
            driverMsg("Calling scalar optimizations.");
            monitor.subTask("Scalar Optimization");
            ScalarAppOptimizations.run();
            monitor.worked(1);
            if (monitor.isCanceled()) {
                return DroidsafeExecutionStatus.CANCEL_STATUS;
            }
        }

        driverMsg("Implementing native methods.");
        monitor.subTask("Implementing native methods.");
        NativeMethodBuilder.v().run();
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
            if (afterTransformPrecise(monitor, false, 2) == DroidsafeExecutionStatus.CANCEL_STATUS)
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

        //account for any transformations
        if (afterTransformFast(monitor, false) == DroidsafeExecutionStatus.CANCEL_STATUS)
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        
        driverMsg("Cloning static methods to introduce call site context...");
        monitor.subTask("Cloning static methods to introduce callsite context...");
        try {
            ObjectSensitivityCloner.cloneStaticMethods();
        }
        catch (Exception ex) {
            logger.warn("Excpetion while cloning static methods {} ", ex);
        }
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        } 

        //run value analysis, if it runs, then the code may have veen transformed
        if (Config.v().runValueAnalysis) {
            driverMsg("Running Value Analysis");
            try {
                runVA(monitor);
            }
            catch (Exception ex) {
                logger.warn("VA throws exection {}, stack {} ", ex, ex.getStackTrace());
            }
        }

        //run file precison transforms if enabled
        if (Config.v().runFilePrecisionTransforms) {
        	driverMsg("Running File Precision Transforms...");
        	if (FilePrecisionTransforms.v().run()) {
        		driverMsg("Successfully ran and applied file precision transformations.");
        	} else {
        		driverMsg("File precision transformations could not be applied.");
        	}
        }

        //inject inter app flows if defined
        if (!Config.v().readInterAppFlowsFile.isEmpty()) {
            driverMsg("Injecting inter-app flows...");
            InjectInterAppFlows.v().run();            
        }

        //add fallback object modeling for any value from the api that leaks into user
        //code as null    
        if (Config.v().addFallbackModeling) {
            driverMsg("Inserting Unmodeled Objects...");
            monitor.subTask("Inserting Unmodeled Objects...");
            //calls pta precise
            InsertUnmodeledObjects.v().run(monitor);
            monitor.worked(1);
            if (monitor.isCanceled()) {
                return DroidsafeExecutionStatus.CANCEL_STATUS;
            }
        }



        //account for any transformations
        if (afterTransformFast(monitor, false) == DroidsafeExecutionStatus.CANCEL_STATUS)
            return DroidsafeExecutionStatus.CANCEL_STATUS;

        //so that we don't lose a level of object sensitive in AbstractStringBuilder.toString()
        //replace calls with new expressions, and let the modeling pass taint appropriately
        driverMsg("Converting AbstractStringBuilder.toString()");
        TransformStringBuilderInvokes.run();


        if (afterTransformPrecise(monitor, false, Config.v().kobjsens) == DroidsafeExecutionStatus.CANCEL_STATUS)
            return DroidsafeExecutionStatus.CANCEL_STATUS;        

        //new TestPTA();     

        if (Config.v().createRCFG) {
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
        }

        // print out what modeling is required for this application
        if (Config.v().produceReports) {
            monitor.subTask("Required Modeling");
            RequiredModeling.run();     
            monitor.worked(1);
            if (monitor.isCanceled()) {
                return DroidsafeExecutionStatus.CANCEL_STATUS;
            }
        }

        //if debugging then write some jimple classes
        if (Config.v().debug) {
            writeSrcAndGeneratedJimple();
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

        IntentResolutionStats.v().writeStats();

        if (Config.v().produceReports)
            writeJSONReports();



        //run information flow
        if (runInfoFlow(monitor) == DroidsafeExecutionStatus.CANCEL_STATUS)
            return DroidsafeExecutionStatus.CANCEL_STATUS;

        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }
        
        //if (!Config.v().createRCFG) {
            //produce info flow report without rcfg information
            new InfoFlowReportNoRCFG().run();
        //}

        //finished all core analysis
        //exit here if we are not producing results
        if (Config.v().analysisOnlyRun) 
            return DroidsafeExecutionStatus.OK_STATUS;


        //Start with reports and eclipse output
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

        StopWatch timer = new StopWatch();

        if (Config.v().createRCFG) {
            driverMsg("Converting RCFG to SSL and dumping...");
            monitor.subTask("Writing Spec to File");      
            timer.start();
            RCFGToSSL.run(false);
            SecuritySpecification spec = RCFGToSSL.v().getSpec();
            monitor.worked(1);
            if (monitor.isCanceled()) {
                return DroidsafeExecutionStatus.CANCEL_STATUS;
            }
            timer.stop();
            driverMsg("Finished converting RCFG to SSL and dumping: " + timer);


            //find inter app flows here
            if (Config.v().produceInterAppFlowsFile)
                GenerateInterAppSourceFlows.v().run(spec);

            if (spec != null) {

                driverMsg("Creating Eclipse Plugin Serialized Specification...");
                timer.reset();
                timer.start();
                SecuritySpecModel securitySpecModel = new SecuritySpecModel(spec, Config.v().APP_ROOT_DIR);
                SecuritySpecModel.serializeSpecToFile(securitySpecModel, Config.v().APP_ROOT_DIR);
                if (Config.v().debug)
                    SecuritySpecModel.writeSpecInfoToFiles(securitySpecModel, Config.v().APP_ROOT_DIR);

                timer.stop();
                driverMsg("Finished Eclipse Plugin Serialized Specification: " + timer);
            }
            monitor.worked(1);
            if (monitor.isCanceled()) {
                return DroidsafeExecutionStatus.CANCEL_STATUS;
            }
            
            PTAPaper.writeReport();
            
            //check info flow last
            if (Config.v().infoFlow) {
                InformationFlowReport.v().run(spec);
            }
        } 
        
        monitor.worked(1);       
        return DroidsafeExecutionStatus.OK_STATUS;
    }    

    private static DroidsafeExecutionStatus runInfoFlow(IDroidsafeProgressMonitor monitor) {
        if (Config.v().infoFlow) {

            StopWatch timer = new StopWatch();
            driverMsg("Starting Information Flow Analysis...");
            monitor.subTask("Information Flow Analysis: Injected source flow");
            timer.start();
            InjectedSourceFlows.run();
            if (monitor.isCanceled()) {
                return DroidsafeExecutionStatus.CANCEL_STATUS;
            }
            monitor.subTask("Information Flow Analysis: Information flow");
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

            PTAPaper.infoFlowTimeSec = timer.getTime() / 1000.0;
            if (Config.v().produceReports)
                droidsafe.stats.AvgInfoFlowSetSize.run();

            driverMsg("Finished Information Flow Analysis: " + timer);         
        }

        return DroidsafeExecutionStatus.OK_STATUS;        
    }

    private static void writeCompletionFile() {
        try {
            Date endTime = new Date();

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + COMPLETION_FILE_NAME);
            fw.write("Cmd line options = " + commandLineArgs + "\n");            
            fw.write("Start time = " + dateFormat.format(startTime) + "\n");
            fw.write("End time = " + dateFormat.format(endTime) + "\n");    

            long elapsedTime = endTime.getTime() - startTime.getTime();

            fw.write("Elapsed Minutes: " + ((int) ((elapsedTime / 1000) / 60)) + ":" + 
                    ((int) ((elapsedTime / 1000) % 60)) + "\n");

            int GB = 1024*1024*1024;

            //Getting the runtime reference from system
            Runtime runtime = Runtime.getRuntime();

            //Print used memory
            fw.write("Used Memory: "
                    + (runtime.totalMemory() - runtime.freeMemory()) / GB + " GB\n");

            //Print free memory
            fw.write("Free Memory: "
                    + runtime.freeMemory() / GB + " GB\n");

            //Print total available memory
            fw.write("Total Memory: " + runtime.totalMemory() / GB + " GB\n");

            //Print Maximum available memory
            fw.write("Max Memory: " + runtime.maxMemory() / GB + " GB\n");

            fw.close();
        } catch (Exception e) {
            logger.error("Error writing completed file.", e);
        }
    }

    /**
     * Run the JSA analysis
     */
    private static DroidsafeExecutionStatus jsaAnalysis(IDroidsafeProgressMonitor monitor) {
        try {
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
        } catch (Exception e) {
            logger.warn("Error in JSA analysis.  Continuing...", e);
            Config.v().runStringAnalysis = false;
            JSAStrings.v().setHasRun(false);
        }

        return DroidsafeExecutionStatus.OK_STATUS;
    }

    private static void writeJSONReports() {
        try {
            CollaspedCallGraph.v();
            driverMsg ("Building indicator reports");
            AllEntryPointCallTree.v().toJson(Project.v().getOutputDir());
            IPCEntryPointCallTree.v().toJson(Project.v().getOutputDir());
            ICCEntryPointCallTree.v().toJson(Project.v().getOutputDir());
            ICCMap.v().toJSON(Project.v().getOutputDir());
            UnresolvedICC.v().toJSON(Project.v().getOutputDir());
            SensitiveSources.v().toJSON(Project.v().getOutputDir());
            SourceCallTree.v().toJson(Project.v().getOutputDir());
            ObjectMethodOverrideContracts.v().toJSON(Project.v().getOutputDir());
            driverMsg ("Indicator reports complete");
        } catch (Exception e) {
            logger.error("Error writing json indicator, ignoring and moving on...", e);
        }


        try {
            driverMsg ("Searching for catch blocks (precise)");
            StopWatch cbtimer = new StopWatch();
            cbtimer.start();
            CatchBlocks cb = new CatchBlocks();
            cb.run();
            cbtimer.stop();
            if (cb.timeout())
                driverMsg ("Catch Block Analysis timed out: " + cbtimer);
            else
                driverMsg ("Finished Catch Block Analysis: " + cbtimer);
        } catch (Exception e) {
            logger.error("Error writing json indicator, ignoring and moving on...", e);
        }
    }

    private static DroidsafeExecutionStatus runVA(IDroidsafeProgressMonitor monitor) {
    	if (afterTransformPrecise(monitor, false, Config.v().kobjsens) == DroidsafeExecutionStatus.CANCEL_STATUS)
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
        if (afterTransformPrecise(monitor, true, Config.v().kobjsens) == DroidsafeExecutionStatus.CANCEL_STATUS)
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
    	if (Config.v().limitcontextforcomplex) {
    		IntrospectiveAnalysis.reset();
    		IntrospectiveAnalysis.v().generateMetrics(monitor);
    	}
    	
        Map<String,String> opts = new HashMap<String,String>();

        if (Config.v().POINTS_TO_ANALYSIS_PACKAGE == PointsToAnalysisPackage.SPARK) {
            //build fast options for spark
            opts.put("merge-stringbuffer","true");   
            opts.put("string-constants","true");   
            opts.put("kobjsens", "1");
            
        } 

        return afterTransform(monitor, recordTime, opts);
    }



    public static DroidsafeExecutionStatus afterTransformPrecise(IDroidsafeProgressMonitor monitor, boolean recordTime, int k) {
    	
    	if (Config.v().limitcontextforcomplex) {
    		IntrospectiveAnalysis.reset();
    		IntrospectiveAnalysis.v().generateMetrics(monitor);
    	}
    	
        Map<String,String> opts = new HashMap<String,String>();

        k = Math.min(k, Config.v().kobjsens);

        if (Config.v().POINTS_TO_ANALYSIS_PACKAGE == PointsToAnalysisPackage.SPARK) {
            //build precise options for spark
            //build fast options for spark
            opts.put("merge-stringbuffer","false");   
            opts.put("string-constants","true");   
            opts.put("kobjsens", Integer.toString(k));   

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
        //AllocationGraph.update();
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

    private static void writeSrcAndGeneratedJimple() {
        for (SootClass clz : Scene.v().getClasses()) {
            if (Project.v().isSrcClass(clz) || Project.v().isDroidSafeGeneratedClass(clz)) {
                SootUtils.writeByteCodeAndJimple(
                    Project.v().getOutputDir(), clz);
            }
        }
    }

    /**
     * Dump jimple files for all application classes.
     */
    public static void writeAllAppClasses() {
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


    private static Collection<SootMethod> getAllTargetMethodsPrecise(SootClass sc, String methodName) {
        Set<SootMethod> possibleTargets = new HashSet<SootMethod>();

        SootClass current = sc;
        while (true) {
            for (SootMethod method : current.getMethods()) {
                if (method.getName().equals(methodName)) {
                    SootMethod resolved = SootUtils.resolveMethod(sc, method.getSignature());
                    if (resolved != null && resolved.equals(method))
                        possibleTargets.add(method);
                }
            }

            if (!current.hasSuperclass())
                break;

            current = current.getSuperclass();
        }

        return possibleTargets; 
    }


    private static Collection<SootMethod> getAllTargetMethodsFast(SootClass sc, String methodName) {

        Set<SootMethod> possibleTargets = new HashSet<SootMethod>();
        //search up inheritance tree for first declaration of method
        Set<String> subSigsAdded = new HashSet<String>();

        SootClass current = sc;
        while (true) {
            for (SootMethod method : current.getMethods()) {
                if (method.getName().equals(methodName) &&
                        !subSigsAdded.contains(method.getSubSignature())) {
                    //match not added before
                    subSigsAdded.add(method.getSubSignature());
                    possibleTargets.add(method);
                }
            }

            if (!current.hasSuperclass())
                break;

            current = current.getSuperclass();
        }

        return possibleTargets; 
    }

}
