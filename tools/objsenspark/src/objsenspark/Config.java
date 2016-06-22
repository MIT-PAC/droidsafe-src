package objsenspark;

import java.io.File;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Config {
    private final static Logger logger = LoggerFactory.getLogger(Config.class);

    private final static Config config = new Config();

    /** Path for the JRE to be used for whole program analysis. */
    public String JRE = null;

    /** Path for the root folder for the application classes or for the application jar file. */
    public String APP_PATH = null;

    /** Path for the root folder for the library jars. */
    public String LIB_PATH = null;

    /** Main class for the application. */
    public String MAIN_CLASS = null;

    /** Path for the reflection log file for the application. */
    public String REFLECTION_LOG = null;

    /** depth of obj sens when running pta for precision (with context) */
    public int kobjsens = 2;

    /** if true, dump pta to a file */
    public boolean dumpPta = false;

    public boolean dumpCallGraph = false;

    /** should we not add any precision for strings and clump them all together */
    public boolean impreciseStrings = false;
    /** if true add context sensitivity for all objects in pta, otherwise start in user code, and lose it based on k*/
    public boolean allContextForPTA = false;
    /** should a context sensitive pta add context to static inits? */
    public boolean staticinitcontext = true;
    /** if true, use types (instead of alloc sites) for object sensitive context elements > 1 */
    public boolean typesForContext = false;
    /** in spark limit heap context for strings if we are object sensitive */
    public boolean limitHeapContextForStrings = false;   ;
    /** should we add extra context for arrays in the pta? */
    public boolean extraArrayContext = true;

    /** in spark propagate all string constants */
    public boolean stringConstants = false;
    
    public static Config v() {
        return config;
    }

    /**
     * Setter for callSystemErrorOnExit
     * 
     * @param value The new value to be setS
     */
    private static Options setOptions() {
        Options options = new Options();
        // application root directory

        Option help = new Option("help", "print this message");
        options.addOption(help);

        Option jrePath =
                OptionBuilder.withArgName("dir").hasArg()
                .withDescription("The directory containing the version of JRE to be used for whole program analysis").create("jre");
        options.addOption(jrePath);

        Option appPath =
                OptionBuilder.withArgName("dir or jar").hasArg()
                .withDescription("The directory containing the classes for the application or the application jar file").create("apppath");
        options.addOption(appPath);

        Option libPath =
                OptionBuilder.withArgName("dir or jar").hasArg()
                .withDescription("The directory containing the library jar files for the application or the library jar file").create("libpath");
        options.addOption(libPath);

        Option mainClass =
                OptionBuilder.withArgName("class name").hasArg()
                .withDescription("Name of the main class for the application").create("mainclass");
        options.addOption(mainClass);

        Option reflectionLog =
                OptionBuilder.withArgName("file").hasArg()
                .withDescription("The reflection log file for the application for resolving reflective call sites").create("reflectionlog");
        options.addOption(reflectionLog);

        Option kObjSens = OptionBuilder.withArgName("k").hasArg()
                .withDescription("Depth for Object Sensitivity for PTA (default value: 2").create("kobjsens");
        options.addOption(kObjSens);

        Option impreciseStrs = new Option("imprecisestrings", "turn off precision for all strings, FAST and IMPRECISE (default value: false)");
        options.addOption(impreciseStrs);
        
        Option strConstants = new Option("stringconstants", "propagate all string constants (default value: true)");
        options.addOption(strConstants);
        
        Option limitHeapContextForStrings = new Option("limitcontextforstrings", "Limit heap context to 1 for Strings in PTA (default value: false)");
        options.addOption(limitHeapContextForStrings);

        Option tforC = new Option("typesforcontext", "use types (instead of alloc sites) for object sensitive context elements > 1 (default value: false)");
        options.addOption(tforC);
        
        Option noStaticInitContext = new Option("noclinitcontext", "PTA will not add special context for static inits (default value: false)");
        options.addOption(noStaticInitContext);
        
        Option pta = new Option("ptadump", "Dump pta to ./output/pta.txt (default value: false)");
        options.addOption(pta);

        Option callgraph = new Option("callgraph", "Output .dot callgraph file (default value: false)");
        options.addOption(callgraph);

        return options;
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
            logger.error("Error getting canonical path for path", e);
            System.exit(1);
        }

        if (!fpath.exists()) {
            logger.error("Path does not exist: {}", ret);
            System.exit(1);
        }

        return fpath.toString();
    }

    /**
     * Set all variables from the command line arguments.
     * 
     * @param cmd
     */
    private void setVars(Options options, CommandLine cmd) {
        if (cmd.hasOption("help")) {
            printOptions(options);
            System.exit(0);
        }

        if (cmd.hasOption("jre")) {
            this.JRE = getPathFromCWD(cmd.getOptionValue("jre"));
        } else {
        	 this.JRE = System.getProperty("java.home");
        }

        if (cmd.hasOption("apppath")) {
            this.APP_PATH = getPathFromCWD(cmd.getOptionValue("apppath"));
        }

        if (cmd.hasOption("libpath")) {
            this.LIB_PATH = getPathFromCWD(cmd.getOptionValue("libpath"));
        }
        
        if (cmd.hasOption("mainclass")) {
            this.MAIN_CLASS = cmd.getOptionValue("mainclass");
        }

        if (cmd.hasOption("reflectionlog")) {
            this.REFLECTION_LOG = getPathFromCWD(cmd.getOptionValue("reflectionlog"));
        }

        if (cmd.hasOption("kobjsens")) {
            this.kobjsens = Integer.parseInt(cmd.getOptionValue("kobjsens"));
        }
        
        if (cmd.hasOption("noclinitcontext"))
            this.staticinitcontext = false;
        
        if (cmd.hasOption("imprecisestrings")) {
            this.impreciseStrings = true;
        }
        
        if (cmd.hasOption("stringconstants")) {
            this.stringConstants = true;
        }
        
        if (cmd.hasOption("limitcontextforstrings")) {
            this.limitHeapContextForStrings = true;
        }
        
        if (cmd.hasOption("typesforcontext")) {
            this.typesForContext = true;
        }
        
        if (cmd.hasOption("ptadump")) this.dumpPta = true;

        if (cmd.hasOption("callgraph")) this.dumpCallGraph = true;

    }

    public void printOptions(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("objsenspark", options);
    }

    public void init(String[] args) {
        Options options = setOptions();
        CommandLineParser parser = new GnuParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            setVars(options, cmd);
        } catch (Exception e) {
            logger.error("Error parsing command line options", e);
            System.exit(1);
        }
    }

}
