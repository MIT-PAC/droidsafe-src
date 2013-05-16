package droidsafe.main;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import droidsafe.analyses.AttributeModeling;
import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.RCFGToSSL;
import droidsafe.analyses.RequiredModeling;
import droidsafe.analyses.infoflow.InformationFlowAnalysis;
import droidsafe.analyses.infoflow.InjectedSourceFlows;
import droidsafe.analyses.infoflow.InterproceduralControlFlowGraph;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.strings.JSAStrings;
import droidsafe.android.app.EntryPoints;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Project;
import droidsafe.android.app.TagImplementedSystemMethods;
import droidsafe.android.app.resources.Resources;
import droidsafe.android.system.API;
import droidsafe.android.system.Permissions;
import droidsafe.transforms.AddAllocsForAPICalls;
import droidsafe.transforms.LocalForStringConstantArguments;
import droidsafe.transforms.ResolveStringConstants;
import droidsafe.transforms.ScalarAppOptimizations;
import droidsafe.utils.SootUtils;

/**
 * Main entry class for DroidSafe analysis.
 * 
 * @author mgordon
 * 
 */
public class Main {
  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  // public static final String LOG_TXT_FILE = "droidsafe.log.txt";
  // public static final String LOG_XML_FILE = "droidsafe.log.xml";


  /**
	 */
  public static void main(String[] args) {
    logger.info("Starting DroidSafe Run");
    // grab command line args and set some globals
    Config.v().init(args);
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

    logger.info("Creating locals for all string constant arguments.");
    LocalForStringConstantArguments.run();

    logger.info("Calling scalar optimizations.");
    ScalarAppOptimizations.run();

    logger.info("Create tags for the overriden system methods in user code.");
    TagImplementedSystemMethods.run();

    logger.info("Resolving resources and Manifest.");

    Resources.resolveManifest(Config.v().APP_ROOT_DIR);

    logger.info("Resolving String Constants");
    ResolveStringConstants.run(Config.v().APP_ROOT_DIR);


    logger.info("Finding entry points in user code.");
    EntryPoints.v().calculate();

    logger.info("Creating Harness.");
    Harness.create();

    logger.info("Setting Harness Main as entry point.");
    setHarnessMainAsEntryPoint();

    // The JSA analysis fails if it follows AddAllocsForAPICalls.run()
    if (Config.v().runStringAnalysis) {

      JSAStrings.init(Config.v());

      // Predefined hotspots. Should be removed.
      JSAStrings.v().addArgumentHotspots("<android.content.Intent: void <init>(java.lang.String)>",
          0);
      JSAStrings.v().addArgumentHotspots(
          "<android.content.Intent: android.content.Intent addCategory(java.lang.String)>", 0);

      JSAStrings.v().addArgumentHotspots(
          "<android.content.Intent: android.content.Intent setAction(java.lang.String)>", 0);

      JSAStrings.v().addArgumentHotspots("<java.net.URI: void <init>(java.lang.String)>", 0);
      JSAStrings.v().addArgumentHotspots(
          "<android.content.Intent: android.content.Intent setType(java.lang.String)>", 0);

      JSAStrings
          .v()
          .addArgumentHotspots(
              "<android.widget.Toast: android.widget.Toast makeText(android.content.Context,java.lang.CharSequence,int)>",
              1);

      JSAStrings
          .v()
          .addArgumentHotspots(
              "<com.example.android.apis.content.PickContact$ResultDisplayer: void <init>(com.example.android.apis.content.PickContact,java.lang.String,java.lang.String)>",
              1);
      JSAStrings
          .v()
          .addArgumentHotspots(
              "<com.example.android.apis.content.PickContact$ResultDisplayer: void <init>(com.example.android.apis.content.PickContact,java.lang.String,java.lang.String)>",
              2);

      JSAStrings.v().addArgumentHotspots(
          "<android.app.Activity: void setTitle(java.lang.CharSequence)>", 0);
      JSAStrings.run();


      // Debugging.
      JSAStrings.v().log();
    }

    AddAllocsForAPICalls.run();

    logger.info("Starting PTA...");
    GeoPTA.run();

    //logger.info("Incorporating XML layout information");
    // IntegrateXMLLayouts.run();

    //logger.info("Specializing API Calls");
    // APICallSpecialization.run();

    // all transforms should be done by here!
    // logger.info("Restarting PTA...");
    // GeoPTA.release();
    // GeoPTA.run();

    // write jimple txt files for all classes so we can analzye them
    // all transforms should be done by here.
    if (Config.v().writeJimpleAppClasses) {
      writeAllAppClasses();
    }

    RCFG.generate();
    logger.info("Ending DroidSafe Run");

    logger.info("Starting Attribute Modeling");
    AttributeModeling.run();
    logger.info("Finished Attribute Modeling");

    // print out what modeling is required for this application
    RequiredModeling.run();


    if (Config.v().infoFlow) {
      logger.info("Starting Information Flow Analysis...");
      InjectedSourceFlows.run();
      InterproceduralControlFlowGraph.run();
      InformationFlowAnalysis.run();

      String infoFlowDotFile = Config.v().infoFlowDotFile;
      if (infoFlowDotFile != null) {
        try {
          String infoFlowDotMethod = Config.v().infoFlowDotMethod;
          if (infoFlowDotMethod != null) {
            InformationFlowAnalysis.exportDotGraph(Scene.v().getMethod(infoFlowDotMethod),
                infoFlowDotFile);
          } else {
            InformationFlowAnalysis.exportDotGraph(infoFlowDotFile);
          }
        } catch (IOException exp) {
          logger.error(exp.toString());
        }
      }
      logger.info("Finished Information Flow Analysis...");
    }

    if (Config.v().target.equals("specdump")) {
      RCFGToSSL.run();

    } else if (Config.v().target.equals("confcheck")) {
      logger.error("Not implemented yet!");
    }

    // System.out.print(RCFG.v().toString());

  }

  private static void setHarnessMainAsEntryPoint() {
    List<SootMethod> entryPoints = new LinkedList<SootMethod>();
    entryPoints.add(Harness.v().getMain());
    Scene.v().setEntryPoints(entryPoints);
    // Scene.v().setMainClass(Harness.v().getHarnessClass());
  }

  private static void writeAllAppClasses() {
    for (SootClass clz : Scene.v().getClasses()) {
      if (clz.isApplicationClass() /* && Project.v().isSrcClass(clz.toString()) */) {
        SootUtils.writeByteCodeAndJimple(
            Project.v().getOutputDir() + File.separator + clz.toString(), clz);
      }
    }
  }

}
