package droidsafe.main;

import java.io.File;
import java.util.LinkedHashMap;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.PosixParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
		
	}
	
	/**
	 * Set all variables from the command line arguments.
	 * 
	 * @param cmd
	 */
	private void setVars(CommandLine cmd) {
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
		
		CommandLineParser parser = new PosixParser();
		
		try {
			CommandLine cmd = parser.parse( options, args);
			setVars(cmd);
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

