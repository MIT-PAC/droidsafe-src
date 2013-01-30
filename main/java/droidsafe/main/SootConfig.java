package droidsafe.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import soot.Scene;

import droidsafe.android.app.Project;

/**
 * This class performs soot configuration and class loading in anticipation of the 
 * PTA run.
 * 
 * @author mgordon
 *
 */
public class SootConfig {
	private static final Logger logger = LoggerFactory.getLogger(SootConfig.class);

	public static void init() {
		logger.info("Configuring Soot...");
		setOptions();
		setSootClassPath();
		loadClasses();
	}
	
	/**
	 * Load the necessary classes into soot, assumes the soot classpath has been 
	 * set appropriately. 
	 */
	private static void loadClasses() {
		//load the application classes and set them as app classes
		for (String clz : Project.v().getAppClasses()) {
			Scene.v().loadClassAndSupport(clz).setApplicationClass();
			logger.info("Loading class as application class: {}", clz);
		}
		
		//load all classes from jar file
		for (String clz : Project.v().getLibClasses()) {
			Scene.v().loadClassAndSupport(clz).setApplicationClass();
			logger.info("Loading class as application class (from libs jar): {}", clz);
		}
	}
	
	/**
	 * Set command line options for soot.
	 */
	private static void setOptions() {
		 soot.options.Options.v().set_keep_line_number(true);
		 soot.options.Options.v().set_whole_program(true);
		 soot.options.Options.v().setPhaseOption("cg", "verbose:true");
		 soot.options.Options.v().setPhaseOption("cg", "trim-clinit:true");
		 
		 
		 // don't optimize the program 
		 soot.options.Options.v().setPhaseOption("wjop", "enabled:false");
		 // allow for the absence of some classes
		 soot.options.Options.v().set_allow_phantom_refs(true);
	}
	
	/**
	 * Set the soot class path to point to  bin/classes, android.jar, and 
	 * and jar files in the library dir of the application.
	 */
	private static void setSootClassPath() {
		StringBuffer cp = new StringBuffer();
		
		//add the classes directory
		cp.append(Project.v().getAppClassesDir().toString());
		
		//add the android.jar
		File aj = new File(Config.v().ANDROID_LIB_DIR + File.separator + "android.jar");
		if (!aj.exists()) {
			logger.error("android.jar does not exist");
			System.exit(1);
		}
		cp.append(":" + aj.toString());

		//add jars in the libs directory
		
		if (Project.v().getAppLibDir().exists()) {
			for (File f : FileUtils.listFiles(Project.v().getAppLibDir(), new String[]{"jar"}, true)) {
				cp.append(":" + f.toString());
			}
		}

		logger.info("Setting Soot ClassPath: {}", cp.toString());
        System.setProperty("soot.class.path", cp.toString());
	}
}
