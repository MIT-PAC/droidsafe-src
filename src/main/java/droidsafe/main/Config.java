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
 * The precision level by default is set to 4, and the options for this can be found in setPrecision()
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
            "confcheck", "errorhandling"));
   
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
    private String apacHome = System.getenv("DROIDSAFE_SRC_HOME");

    public File ANDROID_LIB_DIR = new File(System.getenv("DROIDSAFE_SRC_HOME") + File.separator + ANDROID_LIB_DIR_REL);  

    public String target = "specdump";

    /** Relative path (w.r.t. APP_ROOT_DIR) for the apk file to be analyzed by droidsafe.  */
    public String apk;

    /** Don't include source location information when outputting spec */
    public boolean noSourceInfo = false;
    /** If true, analyze information flows. */
    public boolean infoFlow = true;
   
    /** If true, analyze implicit information flows. */
    public boolean implicitFlow = false;

    public boolean checkInfoFlow = false;
    
    /** InfoValues that we are concerned with  */
    public String[] infoFlowValues;
    /** If true, track all methods (excluding those in java.lang) regardless of APIInfoKindMapping.hasSourceInfoKind() */
    public boolean infoFlowTrackAll = false;
    /** If true, list native methods that cut information flows. */
    public boolean infoFlowNative = false;
    /** If true, do not transfer taints that flow into array indices. */
    public boolean infoFlowNoArrayIndex = false;
    /** If true, always transfer y.taint into x.taint (or x) for x = y.m() */
    public boolean infoFlowTransferTaintField = false;
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
    /** Limit context for complex classes */
    public boolean limitcontextforcomplex = false;
    
    /** should we run multiple passes of fallback modeling create unmodeled objects from API */
    public boolean multipassfb = false;
    /** if true, then produce a json file that describes the possible inter-applications sinks */
    public boolean produceInterAppFlowsFile = false;
    /** if not empty, then read the file given as possible interapp flows from other applications to be 
     * considered
     */
    public String readInterAppFlowsFile = "";
    /** the depth in which to follow call graph edges from app code when building the call graph, -1 is
     * follow all edges, 0 is don't traverse into api, 1 is traverse one edge only, ... */
    public int apiCallDepth = -1;
    
    /** If true, then only run the core analysis, and exit before reports are produced */
    public boolean analysisOnlyRun = false;
    
    public boolean createRCFG = true;
    /** if true, then run scalar opts like copy / constant prop and folding */
    public boolean scalarOpts = true;
    /** if true, run JSA on string args of all system method calls in app code, 
     * if false, then run JSA only on calls that VA Transforms register
     */
    public boolean runJSAOnAllSystemMethodCalls = false;
    
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

        Option analysisOnly = new Option("analysisonlyrun", "Only run core analysis, and do not create reports or Eclipse output");
        options.addOption(analysisOnly);
        
        Option noRCFG = new Option("norcfg", "Do not organize results by triggering event.  Does not produce eclipse files.");
        options.addOption(noRCFG);
        
        Option noScalarOpts = new Option("noscalaropts", "Do not run scalar opts like copy / constant prop and folding");
        options.addOption(noScalarOpts);

        Option jsatimeout =
                OptionBuilder.withArgName("value").hasArg()
                .withDescription("Timeout value for the string analysis in mins (default 120)").create("jsatimeout");
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

        Option APICallDepth = OptionBuilder.withArgName("n").hasArg()
                .withDescription("API Call Depth").create("apicalldepth");
        options.addOption(APICallDepth);
        
        Option strict = new Option("strict", "Strict mode: die on errors and assertions.");
        options.addOption(strict);
        
        Option noCloneStatics = new Option("noclonestatics", "Do not clone static methods to add call site sensitivity");
        options.addOption(noCloneStatics);

        Option impreciseStrs = new Option("imprecisestrings", "turn off precision for all strings, FAST and IMPRECISE");
        options.addOption(impreciseStrs);
        
        Option limitContextForStrings = new Option("limitcontextforstrings", "Limit context depth for Strings in PTA");
        options.addOption(limitContextForStrings);
        
        Option limitContextForComplex = new Option("limitcontextforcomplex", "Limit context depth for classes that might blow up PTA");
        options.addOption(limitContextForComplex);
        
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

        Option allStatsRun =
                new Option("stats", "Perform extra work to generate stats.");
        options.addOption(allStatsRun);

        Option produceInterAppFlows = new Option("writeinterappflows", "Produce json file for possible inter app sinks in this app");
        options.addOption(produceInterAppFlows);
        
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

        Option runJSAOnAllAPICalls = new Option("extrajsa", "Run JSA on all API calls (Default analyzes Value Analysis API calls)");
        options.addOption(runJSAOnAllAPICalls);

        
        Option callgraph = new Option("callgraph", "Output .dot callgraph file ");
        options.addOption(callgraph);
        
        Option checkInfoFlow =
                new Option("checkinfoflow", "Check infoflow result against expected-info-flows.txt");
        options.addOption(checkInfoFlow);

        options.addOption(allStatsRun);
        
        Option noInfoFlow = new Option("noinfoflow", 
                "Turn off information flow analysis");
        options.addOption(noInfoFlow);

        Option implicitFlow = new Option("implicitflow", 
                "Turn on implicit information flow analysis");
        options.addOption(implicitFlow);

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
                    withDescription("Run with precision level: 0 - 5, increasing precision.").
                    withLongOpt("precision").
                    create("p");
        
        options.addOption(precisionLevel);

        Option infoFlowTrackAll = new Option("trackallflows", 
                "Track all methods (excluding those in java.lang) during information flow analysis");
        options.addOption(infoFlowTrackAll);

        Option infoflowNative = new Option("native", "List native methods that cut information flows");
        options.addOption(infoflowNative);

        options.addOption(new Option("noarrayindex", "Do not transfer taints that flow into array indices"));
        options.addOption(new Option("transfertaintfield", "Always transfer y.taint into x.taint (or x) for x = y.m()"));

        Option approot =
                OptionBuilder.withArgName("dir").hasArg()
                .withDescription("The Android application root directory").create("approot");
        options.addOption(approot);

        Option noReports = new Option ("noreports", "Do not generate indicator reports.");
        options.addOption (noReports);
             
        Option target =
                OptionBuilder.withArgName("target").hasArg().withDescription("Target pass to run")
                .withLongOpt("target")
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
        
        Option interAppFlowFile = 
                OptionBuilder.withArgName("file").hasArg()
                .withDescription("Inject inter app flows from file")
                .create("injectflows");
        options.addOption(interAppFlowFile);

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
            setPrecisionLevel(4);
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

        
        if (cmd.hasOption("stats"))
            this.statsRun = true;

        if (cmd.hasOption("manualmod")) 
            this.useManualModeling = true;

        if (cmd.hasOption("nojsa")) {
            this.runStringAnalysis = false;
        }
        
        if (cmd.hasOption("analysisonlyrun")) {
            this.analysisOnlyRun = true;
        }
        
        if (cmd.hasOption("norcfg")) {
            this.createRCFG = false;
        }
        
        if (cmd.hasOption("noscalaropts")) {
            this.scalarOpts = false;
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
        
        if (cmd.hasOption("apicalldepth")) {
            this.apiCallDepth = Integer.parseInt(cmd.getOptionValue("apicalldepth"));
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
        
        if (cmd.hasOption("limitcontextforcomplex")) {
            this.limitcontextforcomplex = false;
        }
        
        if (cmd.hasOption("preciseinfoflow")) {
            this.preciseInfoFlow = true;
        }
        
        if (cmd.hasOption("writeinterappflows")) {
            this.produceInterAppFlowsFile = true;
        }
        
        if (cmd.hasOption("reportonlyargsflows")) {
            this.reportOnlyArgFlows = true;
        }
        
        if (cmd.hasOption("reportunmodeledflows")) {
            this.reportUnmodeledFlows = true;
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

        if (cmd.hasOption("implicitflow")) {
            assert this.infoFlow;
            this.implicitFlow = true;
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

        if (cmd.hasOption("noarrayindex")) {
            assert this.infoFlow;
            this.infoFlowNoArrayIndex = true;
        }

        if (cmd.hasOption("transfertaintfield")) {
            assert this.infoFlow;
            this.infoFlowTransferTaintField = true;
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

        if (cmd.hasOption("nofallback"))
            this.addFallbackModeling = false;
        
        if (cmd.hasOption("multipassfb"))
            this.multipassfb = true;
        
        if (cmd.hasOption("extrajsa"))
            this.runJSAOnAllSystemMethodCalls = true;

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

        if (cmd.hasOption("injectflows")) {
            this.readInterAppFlowsFile =  cmd.getOptionValue("injectflows");
        }
        
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
        logger.info("DROIDSAFE_SRC_HOME = {}", apacHome);
        if (this.apacHome == null) {
            logger.error("Environment variable $DROIDSAFE_SRC_HOME not set!");
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
            case 0:  //k = 3, and apiCallDepth = 6, limit context for complex;     
                kobjsens = 3;
                multipassfb = false;
                apiCallDepth = 6;
                ignoreNoContextFlows = false;
                fullContextForGUI = false;
                fullContextForStrings = false;
                runStringAnalysis = false;
                runValueAnalysis = true;
                cloneStaticCalls = false;
                staticinitcontext = false;
                extraArrayContext = true;
                limitcontextforcomplex = true;
                break;
            case 1:   //k = 3, api call depth = 12
                kobjsens = 3;
                apiCallDepth = 12;
                multipassfb = false;
                ignoreNoContextFlows = false;
                fullContextForGUI = false;
                fullContextForStrings = false;
                runStringAnalysis = false;
                runValueAnalysis = true;
                cloneStaticCalls = false;
                staticinitcontext = false;
                extraArrayContext = true;
                limitcontextforcomplex = false;
                break;
            case 2:  // no string analysis
                kobjsens = 3;
                multipassfb = false;
                ignoreNoContextFlows = false;
                fullContextForGUI = false;
                fullContextForStrings = false;
                runStringAnalysis = false;
                runValueAnalysis = true;
                cloneStaticCalls = true;
                staticinitcontext = false;
                extraArrayContext = false;
                limitcontextforcomplex = true;
                break;
            case 3:   //limit context for complex classes
                kobjsens = 3;
                multipassfb = false;
                ignoreNoContextFlows = false;
                fullContextForGUI = false;
                fullContextForStrings = false;
                runStringAnalysis = true;
                runValueAnalysis = true;
                cloneStaticCalls = true;
                staticinitcontext = false;
                extraArrayContext = true;
                limitcontextforcomplex = true;
                break;                   
            case 4: //default
                kobjsens = 3;
                multipassfb = false;
                ignoreNoContextFlows = false;
                fullContextForGUI = true;
                fullContextForStrings = true;
                runStringAnalysis = true;
                runValueAnalysis = true;
                cloneStaticCalls = true;
                staticinitcontext = true;
                extraArrayContext = true;
                limitcontextforcomplex = false;
                break;
            case 5:   //multi pass fb
                kobjsens = 3;
                multipassfb = true;
                ignoreNoContextFlows = false;
                fullContextForGUI = true;
                fullContextForStrings = true;
                runStringAnalysis = true;
                runValueAnalysis = true;
                cloneStaticCalls = true;
                staticinitcontext = true;
                extraArrayContext = true;
                limitcontextforcomplex = false;
                break;
            default:
                logger.error("Invalid precision level, must be between 0 and 5 inclusive.");
                droidsafe.main.Main.exit(1);          
                break;
        }
    }
    
}
