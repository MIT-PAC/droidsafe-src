package droidsafe.main;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.G;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.options.Options;
import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.MethodCallsOnAlloc;
import droidsafe.analyses.RCFGToSSL;
import droidsafe.analyses.RequiredModeling;
import droidsafe.analyses.TestPTA;
import droidsafe.analyses.helper.CallGraphTraversal;
import droidsafe.analyses.infoflow.APIInfoKindMapping;
import droidsafe.analyses.infoflow.AllocNodeUtils;
import droidsafe.analyses.infoflow.InformationFlowAnalysis;
import droidsafe.analyses.infoflow.InjectedSourceFlows;
import droidsafe.analyses.infoflow.InterproceduralControlFlowGraph;
import droidsafe.analyses.infoflow.ObjectUtils;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.strings.JSAStrings;
import droidsafe.analyses.strings.JSAUtils;
import droidsafe.analyses.value.ValueAnalysis;
import droidsafe.android.app.EntryPoints;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Project;
import droidsafe.android.app.TagImplementedSystemMethods;
import droidsafe.android.app.resources.Resources;
import droidsafe.android.app.resources.ResourcesSoot;
import droidsafe.android.system.API;
import droidsafe.android.system.Permissions;
import droidsafe.speclang.SecuritySpecification;
import droidsafe.speclang.model.AllocLocationModel;
import droidsafe.speclang.model.CallLocationModel;
import droidsafe.speclang.model.SecuritySpecModel;
import droidsafe.stats.AppMethodsEventContextStats;
import droidsafe.stats.PTASetsAvgSize;
import droidsafe.transforms.IntegrateXMLLayouts;
import droidsafe.transforms.JSAResultInjection;
import droidsafe.transforms.UndoJSAResultInjection;
import droidsafe.transforms.LocalForStringConstantArguments;
import droidsafe.transforms.ResolveStringConstants;
import droidsafe.transforms.ScalarAppOptimizations;
import droidsafe.transforms.VATransformsSuite;
import droidsafe.transforms.objsensclone.ObjectSensitivityCloner;
import droidsafe.utils.DroidsafeDefaultProgressMonitor;
import droidsafe.utils.DroidsafeExecutionStatus;
import droidsafe.utils.IDroidsafeProgressMonitor;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;

import org.apache.commons.lang3.time.*;

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

  /**
   * Entry point of DroidSafe Tool.
   * 
   */
  public static void main(String[] args) {
    driverMsg("Starting DroidSafe Run");
    // grab command line args and set some globals
    Config.v().init(args);
    run(new DroidsafeDefaultProgressMonitor());
  }

  public static DroidsafeExecutionStatus run(IDroidsafeProgressMonitor monitor) {
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
    APIInfoKindMapping.initMapping();
    ResourcesSoot.reset();
    JimpleRelationships.reset();
    CallGraphTraversal.reset();
    AllocLocationModel.reset();
    CallLocationModel.reset();
    RCFG.reset();
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

    driverMsg("Resolving resources and Manifest.");
    monitor.subTask("Resolving Manifest");
    Resources.resolveManifest(Config.v().APP_ROOT_DIR);
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return DroidsafeExecutionStatus.CANCEL_STATUS;
    }

    driverMsg("Finding entry points in user code.");
    monitor.subTask("Finding entry points.");
    EntryPoints.v().calculate();
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
    
    if (afterTransform(monitor) == DroidsafeExecutionStatus.CANCEL_STATUS)
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
    
    //some stats to collect, probably want a better structure for stats gathering
    /*{
        if (afterTransform(monitor) == DroidsafeExecutionStatus.CANCEL_STATUS)
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        
        AppMethodsEventContextStats.run();
        PTASetsAvgSize.run();
        exit(0);
    }*/
    
    if (afterTransform(monitor) == DroidsafeExecutionStatus.CANCEL_STATUS)
        return DroidsafeExecutionStatus.CANCEL_STATUS;
    
    if (Config.v().addObjectSensitivity) {
        driverMsg("Adding Object Sensitivity by cloning...");
        monitor.subTask("Adding Object Sensitivity by cloning...");
        ObjectSensitivityCloner.run();
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }
    }

    if (afterTransform(monitor) == DroidsafeExecutionStatus.CANCEL_STATUS)
        return DroidsafeExecutionStatus.CANCEL_STATUS;
    
    //run jsa after we inject strings from XML values and layout
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

/*
    if (Config.v().runValueAnalysis) {
        driverMsg("Injecting String Analysis Results.");
        monitor.subTask("Injecting String Analysis Results.");
        JSAResultInjection.run();
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }
    }
*/
    if (afterTransform(monitor) == DroidsafeExecutionStatus.CANCEL_STATUS)
        return DroidsafeExecutionStatus.CANCEL_STATUS;
    
    ValueAnalysis.setup();
    if (Config.v().runValueAnalysis) {
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

        driverMsg("Running Value Analysis Tranform Suite.");
        VATransformsSuite.run();

        driverMsg("Undoing String Analysis Result Injection.");
        monitor.subTask("Undoing String Analysis Result Injection.");
        UndoJSAResultInjection.run();
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }

        if (afterTransform(monitor) == DroidsafeExecutionStatus.CANCEL_STATUS)
            return DroidsafeExecutionStatus.CANCEL_STATUS;
    }

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

    // print out what modeling is required for this application
    monitor.subTask("Required Modeling");
    RequiredModeling.run();
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return DroidsafeExecutionStatus.CANCEL_STATUS;
    }

    //Test the points to analysis
    //new TestPTA();
    
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
            String[] infoFlowDotMethods = Config.v().infoFlowDotMethods;
            if (infoFlowDotMethods != null) {
                monitor.subTask("Information Flow Analysis: Export Dot Graph");
                for (String methodSignature : infoFlowDotMethods) {
                    SootMethod method = Scene.v().getMethod(methodSignature);
                    InformationFlowAnalysis.exportDotGraph(method, methodSignature + ".dot");
                }
                if (monitor.isCanceled()) {
                    return DroidsafeExecutionStatus.CANCEL_STATUS;
                }
            }
        } catch (IOException exp) {
            logger.error(exp.toString());
        }
        timer.stop();
        droidsafe.stats.AvgInfoFlowSetSize.run();
        driverMsg("Finished Information Flow Analysis: " + timer);
    }
    monitor.worked(1);
    if (monitor.isCanceled()) {
        return DroidsafeExecutionStatus.CANCEL_STATUS;
    }
    
    driverMsg("Finding method calls on all important alloc nodes...");
    monitor.subTask("Generating Spec");
    MethodCallsOnAlloc.run();
    driverMsg("Finished finding method calls on alloc nodes.");
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return DroidsafeExecutionStatus.CANCEL_STATUS;
    }

    if (Config.v().target.equals("specdump")) {
      driverMsg("Converting RCFG to SSL and dumping...");
      monitor.subTask("Writing Spec to File");
      RCFGToSSL.run(false);
      SecuritySpecification spec = RCFGToSSL.v().getSpec();
      monitor.worked(1);
      if (monitor.isCanceled()) {
        return DroidsafeExecutionStatus.CANCEL_STATUS;
      }

      if (spec != null) {
        SecuritySpecModel securitySpecModel = new SecuritySpecModel(spec, Config.v().APP_ROOT_DIR);
        SecuritySpecModel.serializeSpecToFile(securitySpecModel, Config.v().APP_ROOT_DIR);
        SecuritySpecModel.printSpecInfo(securitySpecModel, Config.v().APP_ROOT_DIR);
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
    return DroidsafeExecutionStatus.OK_STATUS;
  }

  /**
   * Run the JSA analysis
   */
  private static DroidsafeExecutionStatus jsaAnalysis(IDroidsafeProgressMonitor monitor) {
    monitor.subTask("String Analysis: Setting Hotspots");
    JSAUtils.setUpHotspots();
    if (monitor.isCanceled()) {
      return DroidsafeExecutionStatus.CANCEL_STATUS;
    }

    JSAUtils.setupSpecHotspots();
    if (monitor.isCanceled()) {
      return DroidsafeExecutionStatus.CANCEL_STATUS;
    }

    monitor.subTask("String Analysis: Running Analysis");
    JSAStrings.run();
    if (monitor.isCanceled()) {
      return DroidsafeExecutionStatus.CANCEL_STATUS;
    }

    monitor.subTask("String Analysis: Logging");
    JSAStrings.v().log();
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
  
  /**
   * Called after one or more transforms to recalculate any underlying analysis.
   */
  private static DroidsafeExecutionStatus afterTransform(IDroidsafeProgressMonitor monitor) {
      driverMsg("Running PTA...");
      monitor.subTask("Running PTA");
      StopWatch timer = new StopWatch();
      timer.start();
      GeoPTA.release();
      GeoPTA.run();
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
      
      //reset the cache of the call graph traversal
      CallGraphTraversal.reset();
      
      long endTime = System.currentTimeMillis();
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
            Project.v().getOutputDir() + File.separator + clz.toString(), clz);
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
