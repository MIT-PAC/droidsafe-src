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
import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.MethodCallsOnAlloc;
import droidsafe.analyses.RCFGToSSL;
import droidsafe.analyses.RequiredModeling;
import droidsafe.analyses.TestPTA;
import droidsafe.analyses.helper.CallGraphTraversal;
import droidsafe.analyses.infoflow.InformationFlowAnalysis;
import droidsafe.analyses.infoflow.InjectedSourceFlows;
import droidsafe.analyses.infoflow.InterproceduralControlFlowGraph;
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
import droidsafe.speclang.model.SecuritySpecModel;
import droidsafe.transforms.AddAllocsForAPICalls;
import droidsafe.transforms.IntegrateXMLLayouts;
import droidsafe.transforms.LocalForStringConstantArguments;
import droidsafe.transforms.ResolveStringConstants;
import droidsafe.transforms.ScalarAppOptimizations;
import droidsafe.utils.DroidsafeDefaultProgressMonitor;
import droidsafe.utils.DroidsafeExecutionStatus;
import droidsafe.utils.IDroidsafeProgressMonitor;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;

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
    logger.info("Starting DroidSafe Run");
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
    ResourcesSoot.reset();
    JimpleRelationships.reset();
    CallGraphTraversal.reset();
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return DroidsafeExecutionStatus.CANCEL_STATUS;
    }

    logger.info("Creating locals for all string constant arguments.");
    monitor.subTask("Creating locals for string constant arguments.");
    LocalForStringConstantArguments.run();
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return DroidsafeExecutionStatus.CANCEL_STATUS;
    }

    logger.info("Calling scalar optimizations.");
    monitor.subTask("Scalar Optimization");
    ScalarAppOptimizations.run();
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return DroidsafeExecutionStatus.CANCEL_STATUS;
    }

    logger.info("Create tags for the overriden system methods in user code.");
    monitor.subTask("Create tags for overriden system methods");
    TagImplementedSystemMethods.run();
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return DroidsafeExecutionStatus.CANCEL_STATUS;
    }

    logger.info("Resolving resources and Manifest.");
    monitor.subTask("Resolving Manifest");
    Resources.resolveManifest(Config.v().APP_ROOT_DIR);
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return DroidsafeExecutionStatus.CANCEL_STATUS;
    }

    logger.info("Finding entry points in user code.");
    monitor.subTask("Finding entry points.");
    EntryPoints.v().calculate();
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return DroidsafeExecutionStatus.CANCEL_STATUS;
    }

    logger.info("Creating Harness.");
    monitor.subTask("Creating Harness");
    Harness.create();
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return DroidsafeExecutionStatus.CANCEL_STATUS;
    }

    logger.info("Setting Harness Main as entry point.");
    monitor.subTask("Setting Harness Main as entry point");
    setHarnessMainAsEntryPoint();
    if (monitor.isCanceled()) {
      return DroidsafeExecutionStatus.CANCEL_STATUS;
    }

    // JSA analysis fails if it follows AddAllocsForAPICalls.run()
    // Set up the analysis object no matter what.
    JSAStrings.init(Config.v());
    if (Config.v().runStringAnalysis) {
      monitor.subTask("Running String Analysis.");
      jsaAnalysis(monitor);
    }
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return DroidsafeExecutionStatus.CANCEL_STATUS;
    }

    logger.info("Starting PTA...");
    monitor.subTask("PTA First Pass");
    GeoPTA.release();
    GeoPTA.run();
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return DroidsafeExecutionStatus.CANCEL_STATUS;
    }

    logger.info("Incorporating XML layout information");
    monitor.subTask("Incorporating XML layout information");
    IntegrateXMLLayouts.run();
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return DroidsafeExecutionStatus.CANCEL_STATUS;
    }

    logger.info("Resolving String Constants");
    monitor.subTask("Resolving String Constants");
    ResolveStringConstants.run(Config.v().APP_ROOT_DIR);
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return DroidsafeExecutionStatus.CANCEL_STATUS;
    }

    // all transforms should be done by here!
    logger.info("Restarting PTA...");
    monitor.subTask("PTA Second Pass");
    GeoPTA.release();
    GeoPTA.run();
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return DroidsafeExecutionStatus.CANCEL_STATUS;
    }
    
    //reset the cache of the call graph traversal
    CallGraphTraversal.reset();
    
    // write jimple txt files for all classes so we can analzye them
    // all transforms should be done by here.

    logger.info("Caching Jimple Hierarchy Relationships...");
    monitor.subTask("Caching Jimple Hierarchy Relationships...");
    JimpleRelationships.v();
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return DroidsafeExecutionStatus.CANCEL_STATUS;
    }

    if (Config.v().writeJimpleAppClasses) {
      monitor.subTask("Writing all app classes");
      writeAllAppClasses();
    }
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return DroidsafeExecutionStatus.CANCEL_STATUS;
    }

    //create instance of value analysis object, so that later passes an query empty result.
    ValueAnalysis.setup();
    if (Config.v().runValueAnalysis) {
        logger.info("Starting Value Analysis");
        monitor.subTask("Value Analysis");
        ValueAnalysis.run();
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return DroidsafeExecutionStatus.CANCEL_STATUS;
        }
        logger.info("Finished Value Analysis");
    }

    logger.info("Starting Generate RCFG...");
    monitor.subTask("Generating Spec");
    RCFG.generate();
    logger.info("Finished Generating RCFG.");
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return DroidsafeExecutionStatus.CANCEL_STATUS;
    }

    
    logger.info("Finding method calls on all important alloc nodes...");
    monitor.subTask("Generating Spec");
    MethodCallsOnAlloc.run();
    logger.info("Finished finding method calls on alloc nodes.");
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

    if (Config.v().infoFlow) {
      logger.info("Starting Information Flow Analysis...");
      monitor.subTask("Information Flow Analysis: Injected source flow");
      InjectedSourceFlows.run();
      if (monitor.isCanceled()) {
        return DroidsafeExecutionStatus.CANCEL_STATUS;
      }
      monitor.subTask("Information Flow Analysis: Control flow graph");
      InterproceduralControlFlowGraph.run();
      if (monitor.isCanceled()) {
        return DroidsafeExecutionStatus.CANCEL_STATUS;
      }
      monitor.subTask("Information Flow Analysis: Information flow");
      InformationFlowAnalysis.run();
      if (monitor.isCanceled()) {
        return DroidsafeExecutionStatus.CANCEL_STATUS;
      }

      String infoFlowDotFile = Config.v().infoFlowDotFile;
      if (infoFlowDotFile != null) {
        try {
          String infoFlowDotMethod = Config.v().infoFlowDotMethod;
          if (infoFlowDotMethod != null) {
            monitor.subTask("Information Flow Analysis: Export Dot Graph");
            InformationFlowAnalysis.exportDotGraph(Scene.v().getMethod(infoFlowDotMethod),
                infoFlowDotFile);
          } else {
            monitor.subTask("Information Flow Analysis: Export Dot Graph");
            InformationFlowAnalysis.exportDotGraph(infoFlowDotFile);
          }
        } catch (IOException exp) {
          logger.error(exp.toString());
        }
      }
      logger.info("Finished Information Flow Analysis...");
    }
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return DroidsafeExecutionStatus.CANCEL_STATUS;
    }

    if (Config.v().target.equals("specdump")) {
      logger.info("Converting RCFG to SSL and dumping...");
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
      }
      monitor.worked(1);
      if (monitor.isCanceled()) {
        return DroidsafeExecutionStatus.CANCEL_STATUS;
      }

    } else if (Config.v().target.equals("confcheck")) {
      logger.info("Converting RCFG to SSL ...");
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
      System.exit(1);
    } else {
      throw new IllegalStateException();
    }
  }
}
