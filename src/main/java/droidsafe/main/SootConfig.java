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

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.options.Options;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;

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
	
	/**
	 * Load set of classes as application classes to be analyzed.

	 * This happens after the API has been initialized.  So if there is a clash with a
	 * class name in the API, remove it from the API list of classes and method.
	 * 
	 * If shouldReplace is true, then replace a class if it is already defined.
	 * If shouldReplace is false, then don't replace the class if it is already defined
	 * 
	 * Return list of classes that were not loaded
	 */
	public static Set<String> loadAppClasses(Set<String> classes) {
	    Set<String> notLoaded = new HashSet<String>();
		//load the application classes and set them as app classes
		for (String clz : classes) {			    
			//Scene.v().loadClassAndSupport(clz).setApplicationClass();
			SootClass sc = Scene.v().loadClass(clz, SootClass.BODIES);
			sc.setApplicationClass();
			logger.debug("Loading class as application class: {}", clz);
			
			if (API.v().isSystemClass(sc)) {
				API.v().removeSystemClassDesignation(sc);
				//remove all methods as system methods
				for (SootMethod m : sc.getMethods()) {
					API.v().removeSystemMethodDesignation(m);
				}
			}
		
		}
		return notLoaded;
	}
			
	/**
	 * Set command line options for soot.
	 */
	private static void setOptions() {
		 soot.options.Options.v().set_keep_line_number(true);
		 soot.options.Options.v().set_whole_program(true);
         // LWG
		 soot.options.Options.v().setPhaseOption("jb", "use-original-names:true");
		 soot.options.Options.v().setPhaseOption("cg", "verbose:false");
		 soot.options.Options.v().setPhaseOption("cg", "trim-clinit:true");
		 //soot.options.Options.v().setPhaseOption("jb.tr", "ignore-wrong-staticness:true");
		 		
		 if (Config.v().apk != null) {
		   soot.options.Options.v().set_src_prec(Options.src_prec_apk);
		 }
		 		
		 // don't optimize the program 
		 soot.options.Options.v().setPhaseOption("wjop", "enabled:false");
		 // allow for the absence of some classes
		 soot.options.Options.v().set_allow_phantom_refs(true);
		 
		 soot.options.Options.v().set_ignore_resolution_errors(true);
	}
	
	/**
	 * Set the soot class path to point to  bin/classes, android.jar, and 
	 * and jar files in the library dir of the application.
	 */
	private static void setSootClassPath() {
		StringBuffer cp = new StringBuffer();
		
		//add the application classes  directory 
		cp.append(Project.v().getAppClassesDir().toString());
		
		//if we are analyzing source, add the lib directory next
		if (Project.v().getAppLibDir().exists()) {
			for (File f : FileUtils.listFiles(Project.v().getAppLibDir(), new String[]{"jar"}, true)) {
				cp.append(File.pathSeparator + f.toString());
			}
		}		
		//add the  droidsafe model jar next so we can load modeling classes
		cp.append(File.pathSeparator + Config.v().getAndroidLibJarPath());			
		
		//add the android.jar to account for any classes missing in droidsafe model
		File aj = new File(Config.v().ANDROID_LIB_DIR + File.separator + Config.ANDROID_JAR);
	
		if (!aj.exists()) {
			logger.error("android.jar does not exist");
			droidsafe.main.Main.exit(1);
		}
		
		cp.append(File.pathSeparator + aj.toString());
		
		logger.info("Setting Soot ClassPath: {}", cp.toString());
        System.setProperty("soot.class.path", cp.toString());
	}
}
