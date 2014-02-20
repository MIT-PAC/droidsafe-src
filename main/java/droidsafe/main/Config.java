package droidsafe.main;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashSet;
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

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import droidsafe.analyses.pta.PointsToAnalysisPackage;

/**
 * Class to store and configure options and variables.
 * 
 * To add cmd line variables, add a string field, then add to option to setOptions, then assign in
 * setVars.
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

    /** location of all android apps */
    public static final String ANDROID_APP_DIR_REL = "android-apps";

    public static final String ANDROID_LIB_DIR_REL = "android-lib";

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

    /** Path for the root folder for the Android application under analysis. */
    public String APP_ROOT_DIR;

    /** Path for the root folder for droidsafe code */
    private String apacHome = System.getenv("APAC_HOME");

    public File ANDROID_LIB_DIR = new File(System.getenv("APAC_HOME") + File.separator + ANDROID_LIB_DIR_REL);  

    public String target = "specdump";
    /** Don't include source location information when outputting spec */
    public boolean noSourceInfo = false;
    /** If true, analyze information flows. */
    public boolean infoFlow = true;
    /** Methods on which to export information flows in DOT */
    public String[] infoFlowDotMethods;
    /** If true, track all methods (excluding those in java.lang) regardless of APIInfoKindMapping.hasSourceInfoKind() */
    public boolean infoFlowTrackAll = false;
    /** If true, analyze memory addresses to be read (a.k.a. access analysis) */
    public boolean memoryReadAnalysis = true;
    /** if true, use event context, otherwise, use insensitive result */
    public boolean eventContextPTA = false;
    /** should we call unreachable callbacks, and insert dummy objects for unmodeled api calls? */
    public boolean addFallbackModeling = true;

    /**
     * If true, classes loaded from android.jar will be treated as application classes and analysis
     * may analyze them.
     */
    public boolean apiClassesAreApp = false;
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

    public boolean addObjectSensitivity = true;

    /** if true, run value analysis */
    public boolean runValueAnalysis = true;

    /** if true, compute value analysis result stats */
    public boolean computeVAStats = false;

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

        Option jsa = new Option("nojsa", "Do not use JSA");
        options.addOption(jsa);

        Option jsatimeout =
                OptionBuilder.withArgName("value").hasArg()
                .withDescription("Timeout value for the string analysis (default 120)").create("jsatimeout");
        options.addOption(jsatimeout);

        Option strict = new Option("strict", "Strict mode: die on errors and assertions.");
        options.addOption(strict);

        Option writeJimple =
                new Option("jimple", "Dump readable jimple files for all app classes in /droidsafe.");
        options.addOption(writeJimple);

        Option manualAPIMod = 
                new Option("manualmod", "Use small set of manual Android API modeling for fast run.");
        options.addOption(manualAPIMod);

        Option noVA =
                new Option("nova", "Do not run value analysis.");
        options.addOption(noVA);

        Option vaStats =
                new Option("vastats", "Calculate VA stats.");
        options.addOption(vaStats);

        Option allStatsRun =
                new Option("stats", "Perform extra work to generate stats.");
        options.addOption(allStatsRun);

        Option noObjSens =
                new Option("noobjsens", "Do not add object sensitivity to points to analysis.");
        options.addOption(noObjSens);

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

        Option eventContext = new Option("eventcontext", "Run analysis with Event Context.");
        options.addOption(eventContext);

        Option callgraph = new Option("callgraph", "Output .dot callgraph file ");
        options.addOption(callgraph);


        Option noInfoFlow = new Option("noinfoflow", 
                "Turn off information flow analysis");
        options.addOption(noInfoFlow);

        Option infoFlowDotMethod =
                OptionBuilder
                .withArgName("METHOD")
                .hasArg()
                .withDescription(
                    "Export information flows specific to METHOD only: METHOD is specified by its signature"
                            + " (e.g. \"<com.jpgextractor.PicViewerActivity: void sendExif(java.util.ArrayList)>\")")
                            .withLongOpt("infoflow-dot-method").create("x");
        options.addOption(infoFlowDotMethod);

        Option infoFlowTrackAll = new Option("trackallflows", 
                "Track all methods (excluding those in java.lang) during information flow analysis");
        options.addOption(infoFlowTrackAll);

        Option noMemoryRead = new Option("nomemoryread",
                "Turn off memory read analysis (a.k.a. access analysis)");
        options.addOption(noMemoryRead);

        Option approot =
                OptionBuilder.withArgName("dir").hasArg()
                .withDescription("The Android application root directory").create("approot");
        options.addOption(approot);

        Option target =
                OptionBuilder.withArgName("target").hasArg().withDescription("Target pass to run")
                .create("t");
        options.addOption(target);

        Option spec =
                OptionBuilder.withArgName("ssl_file").hasArg()
                .withDescription("Security Specification for application (used with confcheck)")
                .create("s");
        options.addOption(spec);


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

        if (cmd.hasOption("vastats"))
            this.computeVAStats = true;

        if (cmd.hasOption("stats"))
            this.statsRun = true;

        if (cmd.hasOption("noobjsens"))
            this.addObjectSensitivity = false;

        if (cmd.hasOption("manualmod")) 
            this.useManualModeling = true;

        if (cmd.hasOption("nojsa")) {
            this.runStringAnalysis = false;
        }

        if (cmd.hasOption("jsatimeout")) {
            this.stringAnalysisTimeout = Integer.parseInt(cmd.getOptionValue("jsatimeout"));
        }

        if (cmd.hasOption("strict")) {
            this.strict = true;
        }

        if (cmd.hasOption("noinfoflow")) {
            this.infoFlow = false;
        }

        if (cmd.hasOption("infoflow-dot-method")) {
            assert this.infoFlow;
            this.infoFlowDotMethods = cmd.getOptionValues("infoflow-dot-method");
        }

        if (cmd.hasOption("nomemoryread")) {
            this.memoryReadAnalysis = false;
        }

        if (cmd.hasOption("pta")) {
            String ptaPackage = cmd.getOptionValue("pta");
            if ("spark".equals(ptaPackage)) 
                POINTS_TO_ANALYSIS_PACKAGE = PointsToAnalysisPackage.SPARK;
            else if ("geo".equals(ptaPackage)) {
                POINTS_TO_ANALYSIS_PACKAGE = PointsToAnalysisPackage.GEOPTA;
                logger.warn("Running with GeoPTA, turning off object sensitivity cloning.");
                this.addObjectSensitivity = false;
            }
            else if ("paddle".equals(ptaPackage)) {
                POINTS_TO_ANALYSIS_PACKAGE = PointsToAnalysisPackage.PADDLE;
                logger.warn("Running with Paddle, turning off object sensitivity cloning.");
                this.addObjectSensitivity = false;  
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
        
        if (cmd.hasOption("callgraph")) this.dumpCallGraph = true;


        if (cmd.hasOption("debug")) {
            configureDebugLog();
            this.debug = true;
        }

        if (cmd.hasOption("analyzestrings_unfiltered")) {
            this.unfilteredStringAnalysis = true;
        }

        APP_ROOT_DIR = getPathFromCWD(cmd.getOptionValue("approot"));
        logger.info("approot: {}", APP_ROOT_DIR);
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
     * Construct an absolute path from the string argument. If the argument is a relative path, then
     * append to the CWD. If the empty string is given, then return the cwd.
     */
    private static String getPathFromCWD(String path) {
        if (path == null || path.equals("")) path = ".";
        String ret = "";
        File fpath = new File(path);
        if (fpath.isAbsolute())
            ret = path;
        else {
            ret = System.getProperty("user.dir") + File.separator + path;
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

}
