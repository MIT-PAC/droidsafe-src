package droidsafe.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Scene;
import soot.SootClass;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import droidsafe.analyses.pta.PointsToAnalysisPackage;
import droidsafe.utils.SootUtils;

/**
 * Class to store and configure options and variables.
 * 
 * To add cmd line variables, add a string field, then add to option to setOptions, then assign in
 * setVars.
 * 
 * The precision level by default is set to 2, and the options for this can be found in setPrecision()
 * at the bottom of this file.
 * 
 * @author mgordon
 * 
 */
public class Config {
    private final static Logger logger = LoggerFactory.getLogger(Config.class);

    private final static Config config = new Config();

    /** The points to analysis to run */
    public PointsToAnalysisPackage POINTS_TO_ANALYSIS_PACKAGE = PointsToAnalysisPackage.SPARK;

    public static final Set<String> TARGETS = new LinkedHashSet<String>(Arrays.asList("specdump",
            "confcheck"));

    /** Value analysis depth for following fields when printing */
    public static final int VA_PRINTING_LEVEL = 3;

    /** location of all android apps */
    public static final String ANDROID_APP_DIR_REL = "android-apps";

    public static final String ANDROID_LIB_DIR_REL = "android-lib";
    
    public static final String EXPECT_INFO_FLOW_FILE = "expected-info-flows.txt";

    /** location of the GITI api model jar */
    private static String DROIDSAFE_API_MODEL_JAR_PATH = config.getApacHome() + File.separator + ANDROID_LIB_DIR_REL 
            + File.separator + "droidsafe-api-model.jar";

    /** location of the manual api model jar */
    private static String DROIDSAFE_MANUAL_API_MODEL_JAR_PATH = config.getApacHome() + File.separator + ANDROID_LIB_DIR_REL 
            + File.separator + "droidsafe-manual-api-model.jar";
    /** location of configuration files */
    public static final String SYSTEM_CLASSES_FILE = "config-files" + File.separator
            + "system_class_files.txt";

    public static final String SYSTEM_METHODS_FILE = "config-files" + File.separator
            + "android-api-methods.txt";
    /** location of api modeling base directory relative to apac_home */

    public static final String API_MODELING_DIR_REL = "modeling" + File.separator + "api";

    public static final String ANDROID_JAR = "android.jar";

    public static final String LIBRARY_PACKAGE_PREFIXES_FILE = "config-files" + File.separator
            + "library_package_prefixes.txt";

    /** Path for the root folder for the Android application under analysis. */
    public String APP_ROOT_DIR;

    /** Path for the root folder for droidsafe code */
    private String apacHome = System.getenv("APAC_HOME");

    public File ANDROID_LIB_DIR = new File(System.getenv("APAC_HOME") + File.separator + ANDROID_LIB_DIR_REL);  

    public String target = "specdump";

    /** Relative path (w.r.t. APP_ROOT_DIR) for the apk file to be analyzed by droidsafe.  */
    public String apk;

    /** Don't include source location information when outputting spec */
    public boolean noSourceInfo = false;
    /** If true, analyze information flows. */
    public boolean infoFlow = true;
   
    public boolean checkInfoFlow = false;
    
    /** InfoValues that we are concerned with  */
    public String[] infoFlowValues;
    /** If true, track all methods (excluding those in java.lang) regardless of APIInfoKindMapping.hasSourceInfoKind() */
    public boolean infoFlowTrackAll = false;
    /** If true, list native methods that cut information flows. */
    public boolean infoFlowNative = false;
    /** if true, use event context, otherwise, use insensitive result */
    public boolean eventContextPTA = false;
    /** should we call unreachable callbacks, and insert dummy objects for unmodeled api calls? */
    public boolean addFallbackModeling = true;

    /** if true, write readable jimple output for all app classes */
    public boolean writeJimpleAppClasses = false;

    /** if true, dump pta to a file */
    public boolean dumpPta = false;

    public boolean dumpCallGraph = false;
    
    /**
     * If true, run string analysis on app classes. true by default
     */
    public boolean runStringAnalysis = true;

    /** timeout value in minutes for running the string analysis. 0 means no timeout. Default is 120 (2 hours). */
    public int stringAnalysisTimeout = 120;

    /** if true, run value analysis */
    public boolean runValueAnalysis = true;

    /** if true, compute value analysis result stats */
    public boolean dumpVAStats = false;

    /** if true, compute StartActivityTransform ICC result stats */
    public boolean dumpICCStats = false;

    /** if true, use the small manual set of android classes for the api model, for a fast run. */
    public boolean useManualModeling = false;

    /** for various passes do extra work to print stats, tied to --stats */
    public boolean statsRun = false;

    /**
     * if true, string analysis is done for all soot application classes. Otherwise, it is only done
     * for the source classes of the project.
     */
    public boolean unfilteredStringAnalysis = false;
    /** are we debugging */
    public boolean debug = false;
    /** are we in strict mode and should fail on errors */
    public boolean strict = false;
    /** depth of obj sens when running pta for precision (with context) */
    public int kobjsens = 3;
    /** should we clone static methods to add call site sensitivity for them? */
    public boolean cloneStaticCalls = true;
    /** should we not add any precision for strings and clump them all together */
    public boolean impreciseStrings = false;
    /** if true, then in the info flow analysis ignore methods with NoContext */
    public boolean ignoreNoContextFlows = false;
    /** track only annotated source in the source */
    public boolean onlyannotatedsources = true;
    /** Generate pta result for eclipse plugin */
    public boolean ptaresult = true;
    /** Produce indicator reports**/
    public boolean produceReports = true;
    /** should a context sensitive pta add context to static inits? */
    public boolean staticinitcontext = true;
    /** if true, use types (instead of alloc sites) for object sensitive context elements > 1 */
    public boolean typesForContext = false;
    /** in spark limit heap context for strings if we are object sensitive */
    public boolean fullContextForStrings = true;
    /** in spark limit heap context for some GUI elements */
    public boolean fullContextForGUI = true;
    /** name of benchmark we are running */    
    public String appName = "";
    /** some additional information about configuration */
    public String additionalInfo = "";
    /** should we add extra context for arrays in the pta? */
    public boolean extraArrayContext = true;
    /** ignore flows through throwable objects */
    public boolean ignoreThrowableFlows = false;
    /** use precise reporting for info flow results of args to sinks */
    public boolean preciseInfoFlow = false;
    /** When querying the info flow through Method.java, only report flows through args
     * and receiver */      
    public boolean reportOnlyArgFlows = false;
    /** report on unmodeled taint */
    public boolean reportUnmodeledFlows = false;
    
    public boolean ptaInfoFlowRefinement = false;
    /** should we run multiple passes of fallback modeling create unmodeled objects from API */
    public boolean multipassfb = false;
    
    /**
     * Flag to control what to do when Main.exit(int) is called. The default value is true, forcing
     * the application to System.exit(int) when Main.exit() is called. We use this option when running
     * droidsafe from the command line.
     * 
     * When running using the eclipse plugin, we set this flag to false to Main.exit() only throws an
     * exception and do not kill the running eclipse.
     * 
     */
    public boolean callSystemExitOnError = true;

    public String libraryPackagePrefixesFile;
    public Set<String> libraryPackagePrefixes = new HashSet<String>();

    public static Config v() {
        return config;
    }

    public String getApacHome() {
        return this.apacHome;
    }

    public void setApacHome(String apacHome) {
        this.apacHome = apacHome;
        Config.DROIDSAFE_API_MODEL_JAR_PATH = this.apacHome + File.separator + ANDROID_LIB_DIR_REL 
                + File.separator + "droidsafe-api-model.jar";
        Config.DROIDSAFE_MANUAL_API_MODEL_JAR_PATH = config.getApacHome() + File.separator + ANDROID_LIB_DIR_REL 
                + File.separator + "droidsafe-manual-api-model.jar";
    }

    /**
     * Return the absolute path name for the android lib concrete model to use for this run.
     */
    public String getAndroidLibJarPath() {
        if (useManualModeling)
            return DROIDSAFE_MANUAL_API_MODEL_JAR_PATH;
        else
            return DROIDSAFE_API_MODEL_JAR_PATH;
    }

    /**
     * Getter for callSystemExitOnError
     * 
     * @return The current value of boolean flag callSystemExitOnError.
     */
    public boolean getCallSystemExitOnError() {
        return this.callSystemExitOnError;
    }

    /**
     * Setter for callSystemErrorOnExit
     * 
     * @param value The new value to be setS
     */
    public void setCallSystemExitOnError(boolean value) {
        this.callSystemExitOnError = value;
    }

    private static Options setOptions() {
        Options options = new Options();
        // application root directory

        Option help = new Option("help", "print this message");
        options.addOption(help);

        Option noSourceInfo = new Option("nosourceinfo", "Do not print source information in spec");
        options.addOption(noSourceInfo);

        Option debug =
                new Option("debug", "Enable debugging: log at ./droidsafe/droidsafe.log");
        options.addOption(debug);
        
        Option debug_user 
            = new Option ("debuguser", "Enable debugging with log config file user-logback-debug.xml");
        options.addOption(debug_user);
        
        Option jsa = new Option("nojsa", "Do not use JSA");
        options.addOption(jsa);

        Option jsatimeout =
                OptionBuilder.withArgName("value").hasArg()
                .withDescription("Timeout value for the string analysis (default 120)").create("jsatimeout");
        options.addOption(jsatimeout);
        
        Option appNameOpt =
                OptionBuilder.withArgName("<str>").hasArg()
                .withDescription("Name of application (used for reporting)").create("appname");
        options.addOption(appNameOpt);
        
        Option addConfigOpt =
                OptionBuilder.withArgName("<str>").hasArg()
                .withDescription("Additional Configuration String (used for reporting)").create("configstr");
        options.addOption(addConfigOpt);

        Option kObjSens = OptionBuilder.withArgName("k").hasArg()
                .withDescription("Depth for Object Sensitivity for PTA").create("kobjsens");
        options.addOption(kObjSens);

        Option strict = new Option("strict", "Strict mode: die on errors and assertions.");
        options.addOption(strict);
        
        Option noCloneStatics = new Option("noclonestatics", "Do not clone static methods to add call site sensitivity");
        options.addOption(noCloneStatics);

        Option impreciseStrs = new Option("imprecisestrings", "turn off precision for all strings, FAST and IMPRECISE");
        options.addOption(impreciseStrs);
        
        Option refinement = new Option("refinement", "Experimental refinement of pta and information flow");
        options.addOption(refinement);

        Option limitContextForStrings = new Option("limitcontextforstrings", "Limit context depth for Strings in PTA");
        options.addOption(limitContextForStrings);
        
        Option preciseInfoFlow = new Option("preciseinfoflow", "For info flow reporting use memory access analysis for args to sinks.");
        options.addOption(preciseInfoFlow);
        
        Option reportOnlyArgFlows = new Option("reportonlyargsflows", "For infoflow reporting, report only flows through args and receiver of sinks");
        options.addOption(reportOnlyArgFlows);
        
        Option reportUnmodeledFlows = new Option("reportunmodeledflows", "Report on flows from objects introduced by fallback modeling");
        options.addOption(reportUnmodeledFlows);
        
        Option limitContextForGUI = new Option("limitcontextforgui", "Limit context depth for some GUI objects PTA");
        options.addOption(limitContextForGUI);
        
        Option ignoreExceptionFlows = new Option("ignoreexceptionflows", "Ignore flows through throwable objects and their fields.");
        options.addOption(ignoreExceptionFlows);

        Option tforC = new Option("typesforcontext", "use types (instead of alloc sites) for object sensitive context elements > 1");
        options.addOption(tforC);
        
        Option ignorenocontextflows = new Option("ignorenocontextflows", "Ignore flows that occur in method with no context");
        options.addOption(ignorenocontextflows);
        
        Option writeJimple =
                new Option("jimple", "Dump readable jimple files for all app classes in /droidsafe.");
        options.addOption(writeJimple);

        Option manualAPIMod = 
                new Option("manualmod", "Use small set of manual Android API modeling for fast run.");
        options.addOption(manualAPIMod);

        Option noVA =
                new Option("nova", "Do not run value analysis.");
        options.addOption(noVA);
        
        Option noStaticInitContext = new Option("noclinitcontext", "PTA will not add special context for static inits");
        options.addOption(noStaticInitContext);
        
        Option noPTAResult =
                new Option("noptaresult", "Do not translate PTA result for eclipse plugin");
        options.addOption(noPTAResult);

        Option vaStats =
                new Option("vastats", "Dump VA stats.");
        options.addOption(vaStats);

        Option iccStats =
                new Option("iccstats", "Dump ICC stats.");
        options.addOption(iccStats);

        Option allStatsRun =
                new Option("stats", "Perform extra work to generate stats.");
        options.addOption(allStatsRun);

        Option ptaPackage = 
                OptionBuilder.withArgName("package").hasArg()
                .withDescription("Run with pta package: spark, paddle, geo")
                .create("pta");
        options.addOption(ptaPackage);

        Option runStringAnalysisUnfiltered =
                new Option("analyzestrings_unfiltered",
                        "Run string analysis with no application class filtering.");
        options.addOption(runStringAnalysisUnfiltered);

        Option pta = new Option("ptadump", "Dump pta to ./droidsafe/pta.txt");
        options.addOption(pta);

        Option fallbackMod = new Option("nofallback", "Disable Fallback Modeling");
        options.addOption(fallbackMod);

        Option multipassfb = new Option("multipassfb", "Enable multiple passes of fallback modeling");
        options.addOption(multipassfb);

        
        Option eventContext = new Option("eventcontext", "Run analysis with Event Context.");
        options.addOption(eventContext);

        Option callgraph = new Option("callgraph", "Output .dot callgraph file ");
        options.addOption(callgraph);
        
        Option checkInfoFlow =
                new Option("checkinfoflow", "Check infoflow result against expected-info-flows.txt");
        options.addOption(checkInfoFlow);

        options.addOption(allStatsRun);


        Option noInfoFlow = new Option("noinfoflow", 
                "Turn off information flow analysis");
        options.addOption(noInfoFlow);

        Option infoFlowValue =
                OptionBuilder
                .withArgName("INFOVALUE")
                .hasArg()
                .withDescription(
                        "Print contexts and local variables that have INFOVALUE. Use \"\\$$r1 = ...\" if line has $.")
                        .withLongOpt("infoflow-value").create("x");
        options.addOption(infoFlowValue);
        
        Option precisionLevel = 
                OptionBuilder.withArgName("INT").
                    hasArg().
                    withDescription("Run with precision level: 0 - 3, increasing precision.").
                    withLongOpt("precision").
                    create("p");
        
        options.addOption(precisionLevel);

        Option infoFlowTrackAll = new Option("trackallflows", 
                "Track all methods (excluding those in java.lang) during information flow analysis");
        options.addOption(infoFlowTrackAll);

        Option infoflowNative = new Option("native", "List native methods that cut information flows");
        options.addOption(infoflowNative);

        Option approot =
                OptionBuilder.withArgName("dir").hasArg()
                .withDescription("The Android application root directory").create("approot");
        options.addOption(approot);

        Option noReports = new Option ("noreports", "Do not generate indicator reports.");
        options.addOption (noReports);
             
        Option target =
                OptionBuilder.withArgName("target").hasArg().withDescription("Target pass to run")
                .create("t");
        options.addOption(target);

        Option spec =
                OptionBuilder.withArgName("ssl_file").hasArg()
                .withDescription("Security Specification for application (used with confcheck)")
                .create("s");
        options.addOption(spec);

        Option apk = new Option("apk", "Run analysis on apk.");
        options.addOption(apk);

        Option apkFile =
                OptionBuilder.withArgName("file").hasArg()
                .withDescription("APK file to run the analysis on")
                .create("apkfile");
        options.addOption(apkFile);

        Option libPkgPrefixesFile =
                OptionBuilder.withArgName("file").hasArg()
                .withDescription("file containing library package prefixes")
                .create("libpkgfile");
        options.addOption(libPkgPrefixesFile);

        return options;
    }

    /**
     * Set all variables from the command line arguments.
     * 
     * @param cmd
     */
    private void setVars(Options options, CommandLine cmd) {
        if (cmd.hasOption("help")) {
            printOptions(options);
            droidsafe.main.Main.exit(0);
        }

        if (cmd.hasOption("precision")) {
            int level = Integer.parseInt(cmd.getOptionValue("precision"));
            setPrecisionLevel(level);
        } else {
            setPrecisionLevel(2);
        }
        
        if (cmd.hasOption("target")) {
            this.target = cmd.getOptionValue("target");
        }

        if (!Config.TARGETS.contains(target)) {
            logger.error("Unsupported Target: {}.", target);
            droidsafe.main.Main.exit(1);
        }

        if (cmd.hasOption("nosourceinfo")) {
            this.noSourceInfo = true;
        }

        if (cmd.hasOption("jimple")) 
            this.writeJimpleAppClasses = true;

        if (cmd.hasOption("nova"))
            this.runValueAnalysis = false;
        
        if (cmd.hasOption ("noreports"))
            this.produceReports = false;
       
        if (cmd.hasOption("noclinitcontext"))
            this.staticinitcontext = false;
        
        if (cmd.hasOption("noptaresult"))
            this.ptaresult = false;
               
        if (cmd.hasOption("ignoreexceptionflows")) {
            this.ignoreThrowableFlows = true;
        }
        
        if (cmd.hasOption("vastats"))
            this.dumpVAStats = true;

        if (cmd.hasOption("iccstats"))
            this.dumpICCStats = true;

        if (cmd.hasOption("stats"))
            this.statsRun = true;

        if (cmd.hasOption("manualmod")) 
            this.useManualModeling = true;

        if (cmd.hasOption("nojsa")) {
            this.runStringAnalysis = false;
        }
        
        if (cmd.hasOption("appname")) {
            this.appName = cmd.getOptionValue("appname");
        }
        
        if (cmd.hasOption("configstr")) {
            this.additionalInfo = cmd.getOptionValue("configstr");
        }
        
        if (cmd.hasOption("jsatimeout")) {
            this.stringAnalysisTimeout = Integer.parseInt(cmd.getOptionValue("jsatimeout"));
        }

        if (cmd.hasOption("kobjsens")) {
            this.kobjsens = Integer.parseInt(cmd.getOptionValue("kobjsens"));
        }
      
        if (cmd.hasOption("strict")) {
            this.strict = true;
        }

        if (cmd.hasOption("noclonestatics")) {
            this.cloneStaticCalls = false;
        }

        if (cmd.hasOption("imprecisestrings")) {
            this.impreciseStrings = true;
        }
        
        if (cmd.hasOption("limitcontextforstrings")) {
            this.fullContextForStrings = false;
        }
        
        if (cmd.hasOption("preciseinfoflow")) {
            this.preciseInfoFlow = true;
        }
        
        if (cmd.hasOption("reportonlyargsflows")) {
            this.reportOnlyArgFlows = true;
        }
        
        if (cmd.hasOption("reportunmodeledflows")) {
            this.reportUnmodeledFlows = true;
        }
        
        if (cmd.hasOption("refinement")) {
            ptaInfoFlowRefinement = true;
        }
        
        if (cmd.hasOption("limitcontextforgui")) {
            this.fullContextForGUI = false;
        }
               
        if (cmd.hasOption("typesforcontext")) {
            this.typesForContext = true;
        }
        
        if (cmd.hasOption("ignorenocontextflows")) {
            this.ignoreNoContextFlows = true;
        }
        
        if (cmd.hasOption("noinfoflow")) {
            this.infoFlow = false;
            this.checkInfoFlow = false;
        }

        if (cmd.hasOption("infoflow-value")) {
            assert this.infoFlow;
            System.out.println(cmd.getOptionValues("infoflow-value")[0]);
            this.infoFlowValues = cmd.getOptionValues("infoflow-value");
        }

        if (cmd.hasOption("checkinfoflow")) {
            this.checkInfoFlow = true;
        }

        if (cmd.hasOption("native")) {
            assert this.infoFlow;
            this.infoFlowNative = true;
        }
   
        if (cmd.hasOption("pta")) {
            String ptaPackage = cmd.getOptionValue("pta");
            if ("spark".equals(ptaPackage)) 
                POINTS_TO_ANALYSIS_PACKAGE = PointsToAnalysisPackage.SPARK;
            else if ("geo".equals(ptaPackage)) {
                POINTS_TO_ANALYSIS_PACKAGE = PointsToAnalysisPackage.GEOPTA;
            }
            else if ("paddle".equals(ptaPackage)) {
                POINTS_TO_ANALYSIS_PACKAGE = PointsToAnalysisPackage.PADDLE;
            }
            else {
                logger.error("Invalid PTA Package specified: {}", ptaPackage);
                droidsafe.main.Main.exit(1);
            }
        }

        if (cmd.hasOption("trackallflows")) {
            this.infoFlowTrackAll = true;
        }

        if (cmd.hasOption("ptadump")) this.dumpPta = true;

        if (cmd.hasOption("eventcontext"))
            this.eventContextPTA = true;

        if (cmd.hasOption("nofallback"))
            this.addFallbackModeling = false;
        
        if (cmd.hasOption("multipassfb"))
            this.multipassfb = true;

        if (cmd.hasOption("callgraph")) this.dumpCallGraph = true;


        if (cmd.hasOption("debug")) {
            configureDebugLog();
            this.debug = true;
        }
        
        if (cmd.hasOption("debug-user")) {
            configureUserDebugLog();
            this.debug = true;
        }

        if (cmd.hasOption("analyzestrings_unfiltered")) {
            this.unfilteredStringAnalysis = true;
        }

        APP_ROOT_DIR = getPathFromCWD(cmd.getOptionValue("approot"));
        logger.info("approot: {}", APP_ROOT_DIR);

        if (cmd.hasOption("apkfile")) {
            this.apk = getPathFrom(cmd.getOptionValue("apkfile"), APP_ROOT_DIR);
        } else if (cmd.hasOption("apk")) {
            File appRootDir = new File(APP_ROOT_DIR);
            List<String> apkFiles = new ArrayList<String>();
            for (String file: appRootDir.list()) {
                if (file.endsWith(".apk")) {
                    apkFiles.add(file);
                }
            }
            if (apkFiles.size() == 1) {
                this.apk = APP_ROOT_DIR + File.separator + apkFiles.get(0);
            } else {
                logger.error("Error finding .apk file in app root directory");
                droidsafe.main.Main.exit(1);
            }
        }
        
        if (cmd.hasOption("libpkgfile")) {
            this.libraryPackagePrefixesFile = getPathFromCWD(cmd.getOptionValue("libpkgfile"));
        } else {
            this.libraryPackagePrefixesFile = LIBRARY_PACKAGE_PREFIXES_FILE;
        }
        
        setLibraryPackagePrefixes();

    }

    /** 
     * Read in all method from all_system_methods, then create a SootMethod for missing api
     * methods from modeled classes.
     */
    private void setLibraryPackagePrefixes() {
        try {
            File libPkgPrefixesFile = new File(this.apacHome, this.libraryPackagePrefixesFile);
            BufferedReader reader = new BufferedReader(new FileReader(libPkgPrefixesFile));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty())
                    this.libraryPackagePrefixes.add(line);
            }
            reader.close();
        } catch (Exception e) {
            logger.error("Error reading library package prefixes file {}: {}", libraryPackagePrefixesFile, e);
            droidsafe.main.Main.exit(1);
        }
    }

    /**
     * Method to configure the logging infrastructure to use the debug logging configuration file.
     */
    public void configureDebugLog() {
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
            configurator.doConfigure(apacHome + File.separator + "config-files/logback-debug.xml");
        } catch (JoranException je) {
            // StatusPrinter will handle this
        }
        StatusPrinter.printInCaseOfErrorsOrWarnings(context);
    }
    
    /**
     * Method to configure the logging infrastructure to use the debug logging configuration file.
     */
    public void configureUserDebugLog() {
        // Load $user-logback.xml from the config files directory
        // assume SLF4J is bound to logback in the current environment
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        try {
            JoranConfigurator configurator = new JoranConfigurator();
            configurator.setContext(context);
            // Call context.reset() to clear any previous configuration, e.g. default
            // configuration. For multi-step configuration, omit calling context.reset().
            context.reset();
            configurator.doConfigure(apacHome + File.separator + "config-files/user-logback-debug.xml");
        } catch (JoranException je) {
            // StatusPrinter will handle this
        }
        StatusPrinter.printInCaseOfErrorsOrWarnings(context);
    }

    /**
     * Construct an absolute path from the string argument. If the argument is a relative path, then
     * append to the CWD. If the empty string is given, then return the cwd.
     */
    private static String getPathFromCWD(String path) {
        String basePath = System.getProperty("user.dir");
        return getPathFrom(path, basePath);
    }

    /**
     * Construct an absolute path from the string argument. If the argument is a relative path, then
     * append to the CWD. If the empty string is given, then return the cwd.
     */
    private static String getPathFrom(String path, String basePath) {
        if (path == null || path.equals("")) path = ".";
        String ret = "";
        File fpath = new File(path);
        if (fpath.isAbsolute())
            ret = path;
        else {
            ret = basePath + File.separator + path;
            fpath = new File(ret);
        }

        try {
            fpath = new File(fpath.getCanonicalPath());
        } catch (Exception e) {
            logger.error("Error getting canonical path for app root", e);
            droidsafe.main.Main.exit(1);
        }

        if (!fpath.exists()) {
            logger.error("App root directory does not exist: {}", ret);
            droidsafe.main.Main.exit(1);
        }

        return fpath.toString();
    }

    public void printOptions(String error, Options options) {
        System.out.println("Error: " + error + "\n");
        printOptions(options);
    }

    public void printOptions(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("droidsafe", options);
    }

    public void init(String[] args) {
        logger.info("APAC_HOME = {}", apacHome);
        if (this.apacHome == null) {
            logger.error("Environment variable $APAC_HOME not set!");
            droidsafe.main.Main.exit(1);
        }

        this.ANDROID_LIB_DIR = new File(this.apacHome + File.separator + ANDROID_LIB_DIR_REL);
        if (!this.ANDROID_LIB_DIR.exists()) {
            logger.error("Android library directory for DroidSafe {} does not exist.", ANDROID_LIB_DIR);
            droidsafe.main.Main.exit(1);
        }

        Options options = setOptions();
        CommandLineParser parser = new GnuParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            setVars(options, cmd);
        } catch (Exception e) {
            logger.error("Error parsing command line options", e);
            printOptions(e.getMessage(), options);
            droidsafe.main.Main.exit(1);
        }
    }

    private void setPrecisionLevel(int level) {
                
        switch (level) {
            case 0:
                kobjsens = 1;
                fullContextForGUI = true;
                fullContextForStrings = true;
                runStringAnalysis = true;
                runValueAnalysis = true;
                cloneStaticCalls = false;
                staticinitcontext = false;
                break;
            case 1: 
                kobjsens = 2;
                ignoreNoContextFlows = false;
                fullContextForGUI = true;
                fullContextForStrings = true;
                runStringAnalysis = true;
                runValueAnalysis = true;
                cloneStaticCalls = true;
                staticinitcontext = false;
                extraArrayContext = true;
                break;
            case 2: //default
                kobjsens = 3;
                ignoreNoContextFlows = false;
                fullContextForGUI = true;
                fullContextForStrings = true;
                runStringAnalysis = true;
                runValueAnalysis = true;
                cloneStaticCalls = true;
                staticinitcontext = true;
                extraArrayContext = true;
                break;
            case 3: 
                kobjsens = 3;
                ignoreNoContextFlows = false;
                fullContextForGUI = true;
                fullContextForStrings = true;
                runStringAnalysis = true;
                runValueAnalysis = true;
                cloneStaticCalls = true;
                staticinitcontext = true;
                extraArrayContext = true;
                break;
            default:
                logger.error("Invalid precision level, must be between 0 and 5 inclusive.");
                droidsafe.main.Main.exit(1);          
                break;
        }
    }
    
}
