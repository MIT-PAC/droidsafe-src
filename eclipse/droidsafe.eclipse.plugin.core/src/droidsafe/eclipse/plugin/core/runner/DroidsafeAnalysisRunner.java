package droidsafe.eclipse.plugin.core.runner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osgi.framework.Bundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.G;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.RCFGToSSL;
import droidsafe.analyses.RequiredModeling;
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
import droidsafe.android.system.API;
import droidsafe.android.system.Permissions;
import droidsafe.eclipse.plugin.core.Activator;
import droidsafe.eclipse.plugin.core.preferences.PreferenceConstants;
import droidsafe.eclipse.plugin.core.specmodel.CodeLocationModel;
import droidsafe.eclipse.plugin.core.specmodel.HotspotModel;
import droidsafe.eclipse.plugin.core.specmodel.MethodModel;
import droidsafe.eclipse.plugin.core.specmodel.SecuritySpecModel;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.main.Config;
import droidsafe.main.Main;
import droidsafe.main.SootConfig;
import droidsafe.speclang.Method;
import droidsafe.speclang.SecuritySpecification;
import droidsafe.transforms.AddAllocsForAPICalls;
import droidsafe.transforms.InsertDSTaintAllocs;
import droidsafe.transforms.IntegrateXMLLayouts;
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
public class DroidsafeAnalysisRunner extends Main {
  private static final Logger logger = LoggerFactory.getLogger(DroidsafeAnalysisRunner.class);

  /**
   * Id for the markers to be added to the Android app files.
   */
  public final String DROIDSAFE_MARKER_ID = Activator.PLUGIN_ID + ".droidsafemarker";

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

    // LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
    // StatusPrinter.print(lc);

    IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();
    boolean logDebug = preferenceStore.getBoolean(PreferenceConstants.P_DEBUGLOG);
    configureDebugLog(logDebug);

    // lc = (LoggerContext) LoggerFactory.getILoggerFactory();
    // StatusPrinter.print(lc);

    logger.info("\nAPAC_HOME = " + Config.v().getApacHome() + "\nAPP_ROOT_DIR for project = "
        + Config.v().APP_ROOT_DIR + "\nANDROID_LIB_DIR = " + Config.v().ANDROID_LIB_DIR);
    logger.info("Starting DroidSafe Run Init");


    boolean writeJimpleClasses = preferenceStore.getBoolean(PreferenceConstants.P_JIMPLE);
    Config.v().writeJimpleAppClasses = writeJimpleClasses;
    boolean infoFlow = preferenceStore.getBoolean(PreferenceConstants.P_INFOFLOW);
    Config.v().infoFlow = infoFlow;
    if (infoFlow) {
      Config.v().infoFlowDotFile = preferenceStore.getString(PreferenceConstants.P_INFOFLOWDOTFILE);
      Config.v().infoFlowDotMethod =
          preferenceStore.getString(PreferenceConstants.P_INFOFLOWMETHOD);
    }
    String passTarget = preferenceStore.getString(PreferenceConstants.P_TARGET_PASS);
    Config.v().target = passTarget;
    Config.v().dumpPta = preferenceStore.getBoolean(PreferenceConstants.P_DUMP_PTA);
    Config.v().dumpCallGraph = preferenceStore.getBoolean(PreferenceConstants.P_DUMP_CALL_GRAPH);
    Config.v().runStringAnalysis =
        preferenceStore.getBoolean(PreferenceConstants.P_RUN_STRING_ANALYSIS);
    Config.v().unfilteredStringAnalysis =
        preferenceStore.getBoolean(PreferenceConstants.P_UNFILTERED_STRING_ANALYSIS);

    // Set this flag to false to avoid killing eclipse when the analysis get an error.
    Config.v().callSystemExitOnError = false;
    logger.info("From Activator.getPreferenceStore" + "\nJIMPLE Prefence = " + writeJimpleClasses
        + "\nInfoFlow = " + infoFlow + "\nPass = " + passTarget);

    G.reset();
    Project.v().init();
    SootConfig.init();
    API.v().init();
    Project.v().loadClasses();
    Permissions.init();
  }

  public IStatus run(IProgressMonitor monitor) {
    logger.info("Creating locals for all string constant arguments.");
    LocalForStringConstantArguments.run();
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return Status.CANCEL_STATUS;
    }

    // IJobManager mgr = Job.getJobManager();
    // Job currentJob = mgr.currentJob();
    // currentJob.cancel();
    // monitor.setCanceled(true);
    // if (monitor.isCanceled()){
    // return Status.CANCEL_STATUS;
    // }

    monitor.subTask("Scalar Optimization");
    logger.info("Calling scalar optimizations.");
    ScalarAppOptimizations.run();
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return Status.CANCEL_STATUS;
    }

    logger.info("Create tags for the overriden system methods in user code.");
    monitor.subTask("Create tags for overriden system methods");
    TagImplementedSystemMethods.run();
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return Status.CANCEL_STATUS;
    }

    logger.info("Resolving resources and Manifest.");
    monitor.subTask("Resolving Manifest");
    Resources.resolveManifest(Config.v().APP_ROOT_DIR);
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return Status.CANCEL_STATUS;
    }


    logger.info("Finding entry points in user code.");
    monitor.subTask("Finding entry points in user code.");
    EntryPoints.v().calculate();
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return Status.CANCEL_STATUS;
    }

    logger.info("Creating Harness.");
    monitor.subTask("Creating Harness");
    Harness.create();
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return Status.CANCEL_STATUS;
    }

    logger.info("Setting Harness Main as entry point.");
    monitor.subTask("Setting Harness Main as entry point");
    setHarnessMainAsEntryPoint();
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return Status.CANCEL_STATUS;
    }

    JSAStrings.init(Config.v());
    if (Config.v().runStringAnalysis) {
      jsaAnalysis();
    }
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return Status.CANCEL_STATUS;
    }

    logger.info("Inserting DSTaintObject allocations at each new expression...");
    monitor.subTask("Inserting DSTaintObject allocations at each new expression");
    InsertDSTaintAllocs.run();
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return Status.CANCEL_STATUS;
    }

    AddAllocsForAPICalls.run();
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return Status.CANCEL_STATUS;
    }

    logger.info("Starting PTA...");
    monitor.subTask("PTA First Pass");
    GeoPTA.release();
    GeoPTA.run();
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return Status.CANCEL_STATUS;
    }

    logger.info("Incorporating XML layout information");
    monitor.subTask("Incorporating XML layout information");
    IntegrateXMLLayouts.run();
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return Status.CANCEL_STATUS;
    }

    logger.info("Resolving String Constants");
    monitor.subTask("Resolving String Constants");
    ResolveStringConstants.run(Config.v().APP_ROOT_DIR);
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return Status.CANCEL_STATUS;
    }

    logger.info("Restarting PTA...");
    monitor.subTask("PTA Second Pass");
    GeoPTA.release();
    GeoPTA.run();
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return Status.CANCEL_STATUS;
    }

    // write jimple txt files for all classes so we can analzye them
    if (Config.v().writeJimpleAppClasses) {
      writeAllAppClasses();
    }

    logger.info("Starting Value Analysis");
    monitor.subTask("Value Analysis");
    ValueAnalysis.run();
    monitor.worked(1);
    logger.info("Finished Value Analysis");
    if (monitor.isCanceled()) {
      return Status.CANCEL_STATUS;
    }

    monitor.subTask("Generating Spec");
    RCFG.generate();
    logger.info("Finished generatin spec");
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return Status.CANCEL_STATUS;
    }

    // print out what modeling is required for this application
    monitor.subTask("Required Modeling");
    RequiredModeling.run();
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return Status.CANCEL_STATUS;
    }

    if (Config.v().infoFlow) {
      logger.info("Starting Information Flow Analysis...");
      monitor.subTask("Information Flow Analysis");
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
    monitor.worked(1);
    if (monitor.isCanceled()) {
      return Status.CANCEL_STATUS;
    }

    if (Config.v().target.equals("specdump")) {
      monitor.subTask("Writing Spec to File");
      RCFGToSSL.run(false);
      SecuritySpecification spec = RCFGToSSL.v().getSpec();

      if (spec != null) {
        SecuritySpecModel securitySpecModel = new SecuritySpecModel(spec, Config.v().APP_ROOT_DIR);
        SecuritySpecModel.serializeSpecToFile(securitySpecModel, Config.v().APP_ROOT_DIR);
        generateMarkersForSecuritySpecification(securitySpecModel);
      }
      monitor.worked(1);
      if (monitor.isCanceled()) {
        return Status.CANCEL_STATUS;
      }
    } else if (Config.v().target.equals("confcheck")) {
      logger.error("Not implemented yet!");
    }


    // List<ValueBox> hs = JSAStrings.v().getHotspots();
    // for (ValueBox vb : hs) {
    // logger
    // .debug(
    // "String analysis \nClass {} \nSource File {} \nMethodName {} \nSource Line {} \nRegex {}\n",
    // new Object[] {JSAStrings.v().getClassName(vb), JSAStrings.v().getSourceFile(vb),
    // JSAStrings.v().getMetodName(vb), JSAStrings.v().getSourceLine(vb),
    // JSAStrings.v().getRegex(vb.getValue())});
    // }

    // Map<String, List<Hotspot>> signatureToHotspotMap = JSAStrings.v().getSignatureToHotspotMap();
    // for (String sig : signatureToHotspotMap.keySet()) {
    // for (Hotspot hot : signatureToHotspotMap.get(sig)) {
    // for (ValueBox vb : hot.getHotspots()) {
    // logger
    // .debug(
    // "String analysis \nSignature {}\nArgument Position {}\nClass {} \nSource File {} \nMethodName {} \nSource Line {} \nRegex {}\n",
    // new Object[] {sig, hot.getArgumentPosition(), JSAStrings.v().getClassName(vb),
    // JSAStrings.v().getSourceFile(vb), JSAStrings.v().getMetodName(vb),
    // JSAStrings.v().getSourceLine(vb), JSAStrings.v().getRegex(vb.getValue())});
    // }
    // }
    // }

    monitor.worked(1);
    return Status.OK_STATUS;
  }


  /**
   * Run the JSA analysis
   */
  private static void jsaAnalysis() {
    JSAUtils.setUpHotspots();

    // Adds hotspots added manually by the user.
    SecuritySpecModel previousSpec =
        SecuritySpecModel.deserializeSpecFromFile(Config.v().APP_ROOT_DIR);
    if (previousSpec != null) {
      Map<String, List<HotspotModel>> hotspotMap = previousSpec.getHotspotMap();
      if (hotspotMap != null) {
        for (String sig : hotspotMap.keySet()) {
          List<HotspotModel> hotspots = hotspotMap.get(sig);
          List<Integer> argumentsAlreadySeen = new ArrayList<Integer>();
          if (hotspots != null) {
            for (HotspotModel hotspot : hotspots) {
              int position = hotspot.getArgumentPosition();
              if (!argumentsAlreadySeen.contains(position)) {
                if (position == -1) {
                  // JSAStrings.v().addReturnHotspot(sig);
                  logger.debug("\n\nJSAStrings.v().addReturnHotspot({});\n", sig);
                  argumentsAlreadySeen.add(position);
                } else {
                  JSAStrings.v().addArgumentHotspots(sig, position);
                  logger.debug("\n\nJSAStrings.v().addArgumentHotspot({},{});\n", sig, position);
                  argumentsAlreadySeen.add(position);
                }
              }
            }
          }
        }
      }
    }
    JSAStrings.run();
    JSAStrings.v().log();
  }


  /**
   * Set's harness as entry point for Soot. Run after EntryPoints.
   */
  private void setHarnessMainAsEntryPoint() {
    List<SootMethod> entryPoints = new LinkedList<SootMethod>();
    entryPoints.add(Harness.v().getMain());
    Scene.v().setEntryPoints(entryPoints);
  }

  /**
   * Dump jimple files for all application classes.
   */
  private void writeAllAppClasses() {
    for (SootClass clz : Scene.v().getClasses()) {
      if (clz.isApplicationClass()) {
        SootUtils.writeByteCodeAndJimple(
            Project.v().getOutputDir() + File.separator + clz.toString(), clz);
      }
    }
  }

  /**
   * Sets the location of the xml file to be used by the logging infrastructure.
   * 
   * @param debugLog
   */
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
      configurator.doConfigure(Config.v().getApacHome() + File.separator + configLogFile);
    } catch (JoranException je) {
      // StatusPrinter will handle this
    }
    StatusPrinter.printInCaseOfErrorsOrWarnings(context);
  }


  /**
   * Creates eclipse task markers for all input events locations in the selected app.
   * 
   * @param spec
   */
  @SuppressWarnings("unused")
  private void generateMarkersForSecuritySpecification(SecuritySpecification spec) {
    String markerId = Activator.PLUGIN_ID + ".droidsafemarker";
    IMarker markers[];
    try {
      markers = this.project.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
      for (IMarker marker : markers) {
        marker.delete();
      }
    } catch (CoreException ex) {
      ex.printStackTrace();
    }

    // for (Method m : spec.getWhitelist()) {
    // SourceLocationTag line = m.getDeclSourceLocation();
    // if (line != null) {
    // String clz = line.getClz();
    // int lineNbr = line.getLine();
    // //logger.info("White List Method " + m.toString(true) + " class " + clz + " Line Number = "
    // // + lineNbr);
    // }
    // }

    List<Method> methods = new ArrayList<Method>(spec.getEventBlocks().keySet());
    Collections.sort(methods);

    for (Method inputMethod : methods) {
      SourceLocationTag line = inputMethod.getDeclSourceLocation();
      if (line != null) {
        String clz = line.getClz();
        String classPath = DroidsafePluginUtilities.classNamePath(clz);
        IFile file = this.project.getFile(classPath);
        int lineNbr = line.getLine();
        // logger.info("Main Method " + inputMethod.toString(true) + " class " + clz
        // + " Line Number = " + lineNbr + "\n Class Name path = " + classPath + " \n File = "
        // + file);
        if (file.exists()) {
          try {
            IMarker marker = file.createMarker(markerId);
            marker.setAttribute(IMarker.LINE_NUMBER, lineNbr);
            marker.setAttribute(IMarker.MESSAGE, inputMethod.toString(true));
            marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
            marker.setAttribute("methodName", inputMethod.getName());
            marker.setAttribute("methodClass", inputMethod.getCname());
            if (inputMethod.getReceiver() != null) {
              marker.setAttribute("methodReceiver", inputMethod.getReceiver().toString());
            }
          } catch (CoreException ex) {
            ex.printStackTrace();
          }
        }
      }


      // List<Method> outputMethods = new ArrayList<Method>(spec.getEventBlocks().get(inputMethod));
      // Collections.sort(outputMethods);
      // for (Method outputMethod : outputMethods) {
      // SourceLocationTag outputMethodLine = outputMethod.getDeclSourceLocation();

      // if (outputMethodLine != null) {
      // String clz = outputMethodLine.getClz();
      // int lineNbr = outputMethodLine.getLine();
      // logger.info("Output Method " + outputMethod.toString(true) + " class " + clz
      // + " Line Number = " + lineNbr + "\n Class Name path = "
      // + DroidsafePluginUtilities.classNamePath(clz));
      // }
      // }
    }
  }



  /**
   * Creates eclipse task markers for all input events locations in the selected app.
   * 
   * @param spec
   */
  private void generateMarkersForSecuritySpecification(SecuritySpecModel spec) {

    IMarker markers[];
    try {
      markers = this.project.findMarkers(DROIDSAFE_MARKER_ID, true, IResource.DEPTH_INFINITE);
      for (IMarker marker : markers) {
        marker.delete();
      }
    } catch (CoreException ex) {
      ex.printStackTrace();
    }
    List<MethodModel> methods = new ArrayList<MethodModel>(spec.getEntryPoints());
    Collections.sort(methods);
    Map<MethodModel, List<MethodModel>> inputEventBlocks = spec.getInputEventBlocks();
    if (inputEventBlocks != null) {
      for (MethodModel inputMethod : inputEventBlocks.keySet()) {
        SourceLocationTag line = inputMethod.getDeclSourceLocation();
        if (line != null) {
          String clz = line.getClz();
          String classPath = DroidsafePluginUtilities.classNamePath(clz);
          IFile file = this.project.getFile(classPath);
          int lineNbr = line.getLine() - 1;
          if (file.exists()) {
            try {
              addMarkerForMethod(inputMethod, file, inputMethod.getShortSignature(), lineNbr);
              addMarkerForMethod(inputMethod, file, inputMethod.getSignature(), lineNbr);
              if (inputMethod.getReceiver()!=null){
                addMarkerForMethod(inputMethod, file, inputMethod.getReceiver(), lineNbr);
              }
              if (inputMethod.getPermissions() != null) {
                for (String permission : inputMethod.getPermissions()) {
                  String message = "Permission: " + permission;
                  addMarkerForMethod(inputMethod, file, message, lineNbr);
                }
              }


              // IMarker marker = file.createMarker(DROIDSAFE_MARKER_ID);
              // marker.setAttribute(IMarker.LINE_NUMBER, lineNbr);
              // marker.setAttribute(IMarker.MESSAGE, inputMethod.getShortSignature());
              // marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
              // marker.setAttribute("methodName", inputMethod.getMethodName());
              // marker.setAttribute("methodClass", inputMethod.getClassName());
              //
              // marker = file.createMarker(DROIDSAFE_MARKER_ID);
              // marker.setAttribute(IMarker.LINE_NUMBER, lineNbr);
              // marker.setAttribute(IMarker.MESSAGE, inputMethod.getSignature());
              // marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
              // marker.setAttribute("methodName", inputMethod.getMethodName());
              // marker.setAttribute("methodClass", inputMethod.getClassName());

            } catch (CoreException ex) {
              ex.printStackTrace();
            }
          }
        }
        for (MethodModel outputMethod : inputEventBlocks.get(inputMethod)) {
          List<CodeLocationModel> locations = outputMethod.getLines();
          if (locations != null) {
            for (CodeLocationModel location : locations) {
              String clz = location.getClz();
              String classPath = DroidsafePluginUtilities.classNamePath(clz);
              IFile file = this.project.getFile(classPath);
              int lineNbr = location.getLine();
              if (file.exists()) {
                try {
                  addMarkerForMethod(outputMethod, file, outputMethod.getShortSignature(), lineNbr);
                  addMarkerForMethod(outputMethod, file, outputMethod.getSignature(), lineNbr);
                  if (outputMethod.getPermissions() != null) {
                    for (String permission : outputMethod.getPermissions()) {
                      String message = "Permission: " + permission;
                      addMarkerForMethod(outputMethod, file, message, lineNbr);
                    }
                  }
                  if (outputMethod.getReceiver()!=null){
                    addMarkerForMethod(outputMethod, file, outputMethod.getReceiver(), lineNbr);
                  }
                  List<HotspotModel> hotspots = location.getHotspots();
                  for (HotspotModel hotspot : hotspots) {
                    addMarkerForMethod(outputMethod, file, hotspot.toString(), lineNbr);
                  }
                  
                  // IMarker marker = file.createMarker(DROIDSAFE_MARKER_ID);
                  // marker.setAttribute(IMarker.LINE_NUMBER, lineNbr);
                  // marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
                  // marker.setAttribute("methodName", outputMethod.getMethodName());
                  // marker.setAttribute("methodClass", outputMethod.getClassName());
                  // marker.setAttribute(IMarker.MESSAGE, outputMethod.getShortSignature());
                  //
                  // marker = file.createMarker(DROIDSAFE_MARKER_ID);
                  // marker.setAttribute(IMarker.LINE_NUMBER, lineNbr);
                  // marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
                  // marker.setAttribute("methodName", outputMethod.getMethodName());
                  // marker.setAttribute("methodClass", outputMethod.getClassName());
                  // marker.setAttribute(IMarker.MESSAGE, outputMethod.getSignature());
                  //
                  // List<HotspotModel> hotspots = location.getHotspots();
                  // for (HotspotModel hotspot : hotspots) {
                  // marker = file.createMarker(DROIDSAFE_MARKER_ID);
                  // marker.setAttribute(IMarker.LINE_NUMBER, lineNbr);
                  // marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
                  // marker.setAttribute("methodName", outputMethod.getMethodName());
                  // marker.setAttribute("methodClass", outputMethod.getClassName());
                  // marker.setAttribute(IMarker.MESSAGE, hotspot.toString());
                  // }
                } catch (CoreException ex) {
                  ex.printStackTrace();
                }
              }
            }
          }
        }
      }
    }
  }

  private void addMarkerForMethod(MethodModel method, IFile file, String message, int lineNbr)
      throws CoreException {
    IMarker marker = file.createMarker(DROIDSAFE_MARKER_ID);
    marker.setAttribute(IMarker.LINE_NUMBER, lineNbr);
    marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
    marker.setAttribute("methodName", method.getMethodName());
    marker.setAttribute("methodClass", method.getClassName());
    marker.setAttribute(IMarker.MESSAGE, message);
  }

  public static void exit(int status) {
    throw new IllegalStateException();
  }
}
