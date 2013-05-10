package droidsafe.eclipse.plugin.core.runner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osgi.framework.Bundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import droidsafe.analyses.AttributeModeling;
import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.RCFGToSSL;
import droidsafe.analyses.RequiredModeling;
import droidsafe.analyses.infoflow.InformationFlowAnalysis;
import droidsafe.analyses.infoflow.InterproceduralControlFlowGraph;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.android.app.EntryPoints;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Project;
import droidsafe.android.app.TagImplementedSystemMethods;
import droidsafe.android.app.resources.Resources;
import droidsafe.android.system.API;
import droidsafe.android.system.Permissions;
import droidsafe.eclipse.plugin.core.Activator;
import droidsafe.eclipse.plugin.core.preferences.PreferenceConstants;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.main.Config;
import droidsafe.main.SootConfig;
import droidsafe.speclang.Method;
import droidsafe.speclang.SecuritySpecification;
import droidsafe.transforms.AddAllocsForAPICalls;
import droidsafe.transforms.LocalForStringConstantArguments;
import droidsafe.transforms.ResolveStringConstants;
import droidsafe.transforms.ScalarAppOptimizations;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;

/*
 * This is the main run class for Droidsafe Eclipse Plugin. It is based on droidsafe.Main.java
 * 
 * Author: Marcel Becker (becker@kestrel.edu)
 */
public class DroidsafeAnalysisRunner {
  private static final Logger logger = LoggerFactory.getLogger(DroidsafeAnalysisRunner.class);

  // @Preference(nodePath = "droidsafe.eclipse.plugin.core", value = PreferenceConstants.P_JIMPLE)
  boolean writeJimpleClasses;

  // @Preference(nodePath = "droidsafe.eclipse.plugin.core", value = PreferenceConstants.P_INFOFLOW)
  boolean infoFlow;

  // @Preference(nodePath = "droidsafe.eclipse.plugin.core", value =
  // PreferenceConstants.P_INFOFLOWDOTFILE)
  String infoFlowDotFile;

  // @Preference(nodePath = "droidsafe.eclipse.plugin.core", value =
  // PreferenceConstants.P_INFOFLOWMETHOD)
  String infoFlowDotMethod;

  // @Preference(nodePath = "droidsafe.eclipse.plugin.core", value =
  // PreferenceConstants.P_TARGET_PASS)
  String passTarget;

  IProject project;

  public DroidsafeAnalysisRunner(IProject project) {
    this.project = project;
    init();
  }

  public void init() {
    String pluginId = Activator.PLUGIN_ID;
    Bundle bundle = Platform.getBundle(pluginId);
    try {
      File file = FileLocator.getBundleFile(bundle);
      Config.v().setApacHome(file.getAbsolutePath());
      Config.v().ANDROID_LIB_DIR =
          new File(file.getPath() + File.separator + Config.ANDROID_LIB_DIR_REL);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    IPath path = project.getLocation();
    Config.v().APP_ROOT_DIR = path.toOSString();


    //LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
    //StatusPrinter.print(lc);

    IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();
    boolean logDebug = preferenceStore.getBoolean(PreferenceConstants.P_DEBUGLOG);
    configureDebugLog(logDebug);

    //lc = (LoggerContext) LoggerFactory.getILoggerFactory();   
    //StatusPrinter.print(lc);

    logger.info("\nAPAC_HOME = " + Config.v().APAC_HOME() + "\nAPP_ROOT_DIR for project = "
        + Config.v().APP_ROOT_DIR + "\nANDROID_LIB_DIR = " + Config.v().ANDROID_LIB_DIR);
    logger.info("Starting DroidSafe Run Init");



    // logger.info("\nFrom injecton \nJIMPLE Prefence = " + writeJimpleClasses + "\nInfoFlow = "
    // + infoFlow + "\nPass = " + passTarget);
    // Preferences preferences = ConfigurationScope.INSTANCE.getNode(Activator.PLUGIN_ID);
    // writeJimpleClasses = preferences.getBoolean(PreferenceConstants.P_JIMPLE, false);
    // infoFlow = preferences.getBoolean(PreferenceConstants.P_INFOFLOW, false);
    // passTarget = preferences.get(PreferenceConstants.P_TARGET_PASS, "specdump");
    // logger.info("From ConfigurationScope.INSTANCE\nPreferences = " + preferences
    // + "\nJIMPLE Prefence = " + writeJimpleClasses + "\nInfoFlow = " + infoFlow + "\nPass = "
    // + passTarget);



    writeJimpleClasses = preferenceStore.getBoolean(PreferenceConstants.P_JIMPLE);
    Config.v().WRITE_JIMPLE_APP_CLASSES = this.writeJimpleClasses;
    infoFlow = preferenceStore.getBoolean(PreferenceConstants.P_INFOFLOW);
    Config.v().infoFlow = this.infoFlow;
    if (infoFlow) {
      this.infoFlowDotFile = preferenceStore.getString(PreferenceConstants.P_INFOFLOWDOTFILE);
      Config.v().infoFlowDotFile = this.infoFlowDotFile;
      this.infoFlowDotMethod = preferenceStore.getString(PreferenceConstants.P_INFOFLOWMETHOD);
      Config.v().infoFlowDotMethod = this.infoFlowDotMethod;
    }
    passTarget = preferenceStore.getString(PreferenceConstants.P_TARGET_PASS);
    Config.v().target = this.passTarget;
    Config.v().DUMP_PTA = preferenceStore.getBoolean(PreferenceConstants.P_DUMP_PTA);
    Config.v().DUMP_CALL_GRAPH = preferenceStore.getBoolean(PreferenceConstants.P_DUMP_CALL_GRAPH);

    logger.info("From Activator.getPreferenceStore" + "\nJIMPLE Prefence = " + writeJimpleClasses
        + "\nInfoFlow = " + infoFlow + "\nPass = " + passTarget);

    Project.v().init();
    SootConfig.init();
    API.v().init();
    Project.v().loadClasses();
    Permissions.init();
  }

  public void run(IProgressMonitor monitor) {

    logger.info("Creating locals for all string constant arguments.");
    LocalForStringConstantArguments.run();
    monitor.worked(1);

    monitor.subTask("Scalar Optimization");
    logger.info("Calling scalar optimizations.");
    ScalarAppOptimizations.run();
    monitor.worked(1);

    logger.info("Create tags for the overriden system methods in user code.");
    monitor.subTask("Create tags for overriden system methods");
    TagImplementedSystemMethods.run();
    monitor.worked(1);

    logger.info("Resolving resources and Manifest.");
    monitor.subTask("Resolving Manifest");
    Resources.resolveManifest(Config.v().APP_ROOT_DIR);
    monitor.worked(1);

    logger.info("Resolving String Constants");
    monitor.subTask("Resolving String Constants");
    ResolveStringConstants.run(Config.v().APP_ROOT_DIR);
    monitor.worked(1);

    logger.info("Finding entry points in user code.");
    monitor.subTask("Finding entry points in user code.");
    EntryPoints.v().calculate();
    monitor.worked(1);

    logger.info("Creating Harness.");
    monitor.subTask("Creating Harness");
    Harness.create();
    monitor.worked(1);

    logger.info("Setting Harness Main as entry point.");
    monitor.subTask("Setting Harness Main as entry point");
    setHarnessMainAsEntryPoint();
    monitor.worked(1);

    AddAllocsForAPICalls.run();
    monitor.worked(1);

    logger.info("Starting PTA...");
    monitor.subTask("PTA First Pass");
    GeoPTA.release();
    GeoPTA.run();
    monitor.worked(1);

    // logger.info("Incorporating XML layout information");
    // IntegrateXMLLayouts.run();

    // logger.info("Specializing API Calls");
    // APICallSpecialization.run();

    //logger.info("Restarting PTA...");
    //monitor.subTask("PTA Second Pass");
    //GeoPTA.release();
    //GeoPTA.run();
    //monitor.worked(1);

    // write jimple txt files for all classes so we can analzye them
    if (this.writeJimpleClasses) {
      writeAllAppClasses();
    }
    
    monitor.subTask("Generating Spec");
    RCFG.generate();
    logger.info("Ending DroidSafe Run");
    monitor.worked(1);

    logger.info("Starting Attribute Modeling");
    monitor.subTask("Attribute Modeling");
    AttributeModeling.run();
    monitor.worked(1);
    logger.info("Finished Attribute Modeling");

    // print out what modeling is required for this application
    RequiredModeling.run();
    monitor.worked(1);


    if (this.infoFlow) {
      logger.info("Starting Information Flow Analysis...");
      InterproceduralControlFlowGraph.run();
      InformationFlowAnalysis.run();

      String infoFlowDotFile = this.infoFlowDotFile;
      if (infoFlowDotFile != null) {
        try {
          String infoFlowDotMethod = this.infoFlowDotMethod;
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

    if (this.passTarget.equals("specdump")) {
      RCFGToSSL.run();
      SecuritySpecification spec = RCFGToSSL.v().getSpec();
      generateMarkersForSecuritySpecification(spec);

    } else if (this.passTarget.equals("confcheck")) {
      logger.error("Not implemented yet!");
    }
    monitor.worked(1);
  }

  private void setHarnessMainAsEntryPoint() {
    List<SootMethod> entryPoints = new LinkedList<SootMethod>();
    entryPoints.add(Harness.v().getMain());
    Scene.v().setEntryPoints(entryPoints);

  }

  private void writeAllAppClasses() {
    for (SootClass clz : Scene.v().getClasses()) {
      if (clz.isApplicationClass()) {
        SootUtils.writeByteCodeAndJimple(
            Project.v().getOutputDir() + File.separator + clz.toString(), clz);
      }
    }
  }

  public void configureDebugLog(boolean debugLog) {
    // we want to create a debug log file, so load the
    // logback-debug.xml from the config files directory
    // assume SLF4J is bound to logback in the current environment
    LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
    try {
      JoranConfigurator configurator = new JoranConfigurator();
      configurator.setContext(context);
      // Call context.reset() to clear any previous configuration, e.g. default
      // configuration. For multi-step configuration, omit calling context.reset().
      context.reset();
      String configLogFile =
          debugLog ? "config-files/logback-debug.xml" : "config-files/logback.xml";
      configurator.doConfigure(Config.v().APAC_HOME() + File.separator + configLogFile);
    } catch (JoranException je) {
      // StatusPrinter will handle this
    }
    StatusPrinter.printInCaseOfErrorsOrWarnings(context);
  }



  private void generateMarkersForSecuritySpecification(SecuritySpecification spec) {
    String markerId = Activator.getDefault().PLUGIN_ID + ".droidsafemarker";
    IMarker markers[];
    try {
      markers = this.project.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
      for (IMarker marker : markers) {
        marker.delete();
      }
    } catch (CoreException ex) {
      ex.printStackTrace();
    }

    for (Method m : spec.getWhitelist()) {
      SourceLocationTag line = m.getDeclSourceLocation();
      if (line != null) {
        String clz = line.getClz();
        int lineNbr = line.getLine();
        logger.info("White List Method " + m.toString(true) + " class " + clz + " Line Number = "
            + lineNbr);
      }
    }

    List<Method> methods = new ArrayList<Method>(spec.getEventBlocks().keySet());
    Collections.sort(methods);

    for (Method inputMethod : methods) {
      SourceLocationTag line = inputMethod.getDeclSourceLocation();
      if (line != null) {
        String clz = line.getClz();
        String classPath = DroidsafePluginUtilities.classNamePath(clz);
        IFile file = this.project.getFile(classPath);
        int lineNbr = line.getLine();
        logger.info("Main Method " + inputMethod.toString(true) + " class " + clz
            + " Line Number = " + lineNbr + "\n Class Name path = " + classPath + " \n File = "
            + file);
        try {
          IMarker marker = file.createMarker(markerId);
          marker.setAttribute(IMarker.LINE_NUMBER, lineNbr);
          marker.setAttribute(IMarker.MESSAGE, inputMethod.toString(true));
          marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
          marker.setAttribute("methodName", inputMethod.getName());
          marker.setAttribute("methodClass", inputMethod.getCname());
          if (inputMethod.getReceiver() != null) {
            marker.setAttribute("methodReceiver", inputMethod.getReceiver());
          }
        } catch (CoreException ex) {
          ex.printStackTrace();
        }
      }

      List<Method> outputMethods = new ArrayList<Method>(spec.getEventBlocks().get(inputMethod));
      Collections.sort(outputMethods);
      for (Method outputMethod : outputMethods) {
        SourceLocationTag outputMethodLine = outputMethod.getDeclSourceLocation();

        if (outputMethodLine != null) {
          String clz = outputMethodLine.getClz();
          int lineNbr = outputMethodLine.getLine();
          logger.info("Output Method " + outputMethod.toString(true) + " class " + clz
              + " Line Number = " + lineNbr + "\n Class Name path = "
              + DroidsafePluginUtilities.classNamePath(clz));
        }
      }
    }
  }

}
