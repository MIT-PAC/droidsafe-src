package droidsafe.main;

import java.io.File;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Scene;
import soot.SootClass;
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
	}
	
	public static void loadAppClasses(Set<String> classes) {
		//load the application classes and set them as app classes
		for (String clz : classes) {
			//Scene.v().loadClassAndSupport(clz).setApplicationClass();
			Scene.v().loadClass(clz, SootClass.BODIES).setApplicationClass();
			logger.debug("Loading class as application class: {}", clz);
		}
	}
			
	/**
	 * Set command line options for soot.
	 */
	private static void setOptions() {
		 soot.options.Options.v().set_keep_line_number(true);
		 soot.options.Options.v().set_whole_program(true);
		 soot.options.Options.v().setPhaseOption("cg", "verbose:false");
		 soot.options.Options.v().setPhaseOption("cg", "trim-clinit:true");
		 //soot.options.Options.v().setPhaseOption("jb.tr", "ignore-wrong-staticness:true");
		 		
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
		
		//add the api modeling directory first so we can load modeling classes
		cp.append(Config.v().getAndroidLibJarPath());
		
		//add the classes directory
		cp.append( File.pathSeparator+ Project.v().getAppClassesDir().toString());
		
		//add the android.jar
		File aj = new File(Config.v().ANDROID_LIB_DIR + File.separator + Config.ANDROID_JAR);
	
		if (!aj.exists()) {
			logger.error("android.jar does not exist");
			droidsafe.main.Main.exit(1);
		}
		
		cp.append(File.pathSeparator + aj.toString());

		//add jars in the libs directory
		
		if (Project.v().getAppLibDir().exists()) {
			for (File f : FileUtils.listFiles(Project.v().getAppLibDir(), new String[]{"jar"}, true)) {
				cp.append(File.pathSeparator + f.toString());
			}
		}

		logger.info("Setting Soot ClassPath: {}", cp.toString());
        System.setProperty("soot.class.path", cp.toString());
	}
}
