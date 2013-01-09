package droidsafe.android.app;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.commons.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.main.Config;
import droidsafe.main.Main;
import droidsafe.utils.Utils;

/** 
 * Represent an Android project including the source files, resource files,
 * android manifest, etc.
 * 
 * @author mgordon
 *
 */
public class Project {
	private static final Logger logger = LoggerFactory.getLogger(Project.class);
	
	public static final String SRC_DIR = "src";
	public static final String CLASSES_DIR = "bin" + File.separator + "classes";
	public static final String LIBS_DIR = "libs";
	public static final String RES_DIR = "res";
	public static final String LAYOUTS_DIR = RES_DIR + File.separator + "layout";
	public static final String MANIFEST_FILE = "AndroidManifest.xml";
	public static final String OUTPUT_DIR = "droidsafe";
	
	private final static Project project;
	
	private File appSrcDir;
	private File appClassesDir;
	private File appLibDir;
	private File outputDir;
	private Set<String> appClasses;
	private Set<String> libClasses;
	
	static {
		project = new Project();
	}
	
	public static Project v() {
		return project;
	}
	
	public void init() {
		this.appSrcDir = new File(Config.v().APP_ROOT_DIR + File.separator + SRC_DIR);
		
		this.appClassesDir = new File(Config.v().APP_ROOT_DIR + File.separator + CLASSES_DIR);
		logger.info("Setting application class directory to {}.", appClassesDir.toString());
		if (!this.appClassesDir.exists()) {
			logger.error("Project not configured properly. Directory does not exist: " + this.appClassesDir);
			System.exit(1);
		}
		
		this.appLibDir = new File(Config.v().APP_ROOT_DIR + File.separator + LIBS_DIR);
		
		this.outputDir = new File(Config.v().APP_ROOT_DIR + File.separator + OUTPUT_DIR);
		if (!outputDir.exists()) {
			try {
				outputDir.mkdirs();
			} catch (Exception e) {
				logger.error("Cannot create output directory", e);
				System.exit(1);
			}
		}
		
		setAppClasses();
		setLibClasses();
		
		//create the output directory if it does not exist
		File outputDir = new File(getOutputDir());
		if (!outputDir.exists()) {
			if (!outputDir.isDirectory()) {
				logger.error("Output directory cannot be created because a file exists in its way: {}." + OUTPUT_DIR);
				System.exit(1);
			}
			outputDir.mkdirs();
		}
	}
	
	/**
	 * Add all classes from in bin/classes to the appClasses
	 */
	private void setAppClasses() {
		appClasses = new LinkedHashSet<String>();
		for (File clazz : FileUtils.listFiles(this.appClassesDir, new String[]{"class"}, true)) {
			
			String clzName = Utils.fromFileToClass(clazz.toString().substring(this.appClassesDir.toString().length() + 1));
			logger.info("Application class: {}", clzName);
			appClasses.add(clzName);
		}
	}
	
	/**
	 * Add all classes from any jar files into the set for library classes.
	 */
	private void setLibClasses() {
		libClasses = new LinkedHashSet<String>();
		
		if (!this.appLibDir.exists())
			return;
		
		for (File f : FileUtils.listFiles(this.appLibDir, new String[]{"jar"}, true)) {
			JarFile jarFile = null;
			try {
				jarFile = new JarFile(f);
			} catch (IOException e1) {
				logger.error("Error opening jar file", e1);
				System.exit(1);
			}
			
			for (Enumeration<JarEntry> e = jarFile.entries() ; e.hasMoreElements() ;) {
		         JarEntry entry = e.nextElement();
		         if (!entry.getName().endsWith(".class"))
		        	 continue;
		         
		         libClasses.add(Utils.fromFileToClass(entry.getName()));
			}
		}
	}
	
	public File getAppLibDir() {
		return appLibDir;
	}

	public File getAppSrcDir() {
		return appSrcDir;
	}

	public File getAppClassesDir() {
		return appClassesDir;
	}
	
	public String getOutputDir() {
		return Config.v().APP_ROOT_DIR + File.separator + OUTPUT_DIR;
	}
	
	/**
	 * Return set of all classes defined in the all jar files 
	 * in the libs directory of the application.
	 */
	public Set<String> getLibClasses() {
		return libClasses;
	}
	
	/**
	 * Return true if arg class name is a class from a jar file located
	 * in the libs directory of the application. 
	 */
	public boolean isLibClass(String clz) {
		return libClasses.contains(clz);
	}
	
	/**
	 * Return set of all classes defined in bin/classes of app.
	 */
	public Set<String> getAppClasses() {
		return appClasses;
	}
}
