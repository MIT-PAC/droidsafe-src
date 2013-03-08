package droidsafe.main;

import java.io.File;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.PosixParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

/**
 * Class to store and configure options and variables.
 * 
 * To add cmd line variables, add a string field, then add to option to setOptions,
 * then assign in setVars.
 * 
 * @author mgordon
 *
 */
public class Config {
	private final static Logger logger = LoggerFactory.getLogger(Config.class);
	
	private final static Config config = new Config();
	
	public String APP_ROOT_DIR;
	public File ANDROID_LIB_DIR;
	public String target = "specdump";
	/** Don't include source location information when outputting spec */
	public boolean noSourceInfo = false;
	/** If true, then classes loaded from android.jar will be treated as 
	 * application classes and analyses may analyze them.
	 */
	public boolean API_CLASSES_ARE_APP = false;
	/** if true, write readable jimple output for all app classes */
	public boolean WRITE_JIMPLE_APP_CLASSES = false;
	
	private static final String ANDROID_LIB_DIR_REL = "android-lib";
	
	/** location of configuration files */
	public static final String SYSTEM_CLASSES_FILE = "config-files/system_class_files.txt";
	
	private String APAC_HOME; 
	
	public static Config v() {
		return config;
	}
	
	public String APAC_HOME() {
		return APAC_HOME;
	}
	
	private static void setOptions(Options options) {
		//application root directory
		Option approot   = OptionBuilder.withArgName("dir")
                .hasArg()
                .withDescription("The Android application root directory")
                .create("approot");
		options.addOption(approot);
		
		Option target  = OptionBuilder.withArgName( "target" )
                .hasArg()
                .withDescription( "Target pass to run" )
                .create( "t"); 
		options.addOption(target);
		
		Option spec = OptionBuilder.withArgName("ssl_file")
				.hasArg()
				.withDescription("Security Specification for application (used with confcheck)")
				.create("s");
		options.addOption(spec);
		
		Option help = new Option( "help", "print this message" );
		options.addOption(help);
		
		Option noSourceInfo = new Option("nosourceinfo", "Do not print source information in spec");
		options.addOption(noSourceInfo);
		
		Option debugLog = new Option("debuglog", "Print debug log to current ./droidsafe/droidsafe.log");
		options.addOption(debugLog);
		
		Option apiAsApp = new Option("analyzeapi", "Fully analyze API classes from android.jar.");
		options.addOption(apiAsApp);
		
		Option writeJimple = new Option("jimple", "Dump readable jimple files for all app classes in /droidsafe.");
		options.addOption(writeJimple);
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
		
		if (cmd.hasOption("target")) {
			this.target = cmd.getOptionValue("target");
		}
		
		if (!Main.TARGETS.contains(target)) {
			logger.error("Unsupported Target: {}.", target);
			System.exit(1);
		}
		
		if (cmd.hasOption("nosourceinfo")) {
			this.noSourceInfo = true;
		}
		
		if (cmd.hasOption("analyzeapi")) 
			this.API_CLASSES_ARE_APP = true;
		
		if (cmd.hasOption("jimple"))
			this.WRITE_JIMPLE_APP_CLASSES = true;
		
		if (cmd.hasOption("debuglog")) {
			//we want to create a debug log file, so load the 
			//logback-debug.xml from the config files directory
			 // assume SLF4J is bound to logback in the current environment
			
		    LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		    
		    try {
		      JoranConfigurator configurator = new JoranConfigurator();
		      configurator.setContext(context);
		      // Call context.reset() to clear any previous configuration, e.g. default 
		      // configuration. For multi-step configuration, omit calling context.reset().
		      context.reset(); 
		      configurator.doConfigure(APAC_HOME + File.separator + "config-files/logback-debug.xml");
		    } catch (JoranException je) {
		      // StatusPrinter will handle this
		    }
		    StatusPrinter.printInCaseOfErrorsOrWarnings(context);
			
		}
		
		APP_ROOT_DIR = getPathFromCWD(cmd.getOptionValue("approot"));
		logger.info("approot: {}", APP_ROOT_DIR);
	}
	
	/**
	 * Construct an absolute path from the string argument.  If the argument is a 
	 * relative path, then append to the CWD.  If the empty string is given, then 
	 * return the cwd.
	 */
	private static String getPathFromCWD(String path) {
		if (path == null || path.equals(""))
			path = ".";
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
			System.exit(1);
		}
		
		if (!fpath.exists()) {
			logger.error("App root directory does not exist: {}", ret);
			System.exit(1);
		}
		
		return fpath.toString();
	}
	
	public void printOptions(String error, Options options) {
		System.out.println("Error: " + error + "\n");
		printOptions(options);
	}
	
	public  void printOptions(Options options) {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp( "droidsafe", options );
	}
	
	public void init(String[] args) {
	
		APAC_HOME = System.getenv("APAC_HOME");
		logger.info("APAC_HOME = {}", APAC_HOME);
		if (APAC_HOME == null) {
			logger.error("$APAC_HOME not set!");
			System.exit(1);
		}
		
		Options options = new Options();
		setOptions(options);
		
		CommandLineParser parser = new GnuParser();
		
		try {
			CommandLine cmd = parser.parse( options, args);
			setVars(options, cmd);
		} catch (Exception e) {
			logger.error("Error parsing command line options", e);
			printOptions(e.getMessage(), options);
			System.exit(1);
		}
		
		ANDROID_LIB_DIR = new File(System.getenv ("APAC_HOME") + File.separator + ANDROID_LIB_DIR_REL);
		if (!ANDROID_LIB_DIR.exists()) {
			logger.error("Android library directory for DroidSafe does not exist.");
			System.exit(1);
		}
	}
}

