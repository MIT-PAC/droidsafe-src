package objsenspark;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.SootClass;

/** 
 * Represent an Android project including the source files, resource files,
 * android manifest, etc.
 * 
 * @author mgordon
 *
 */
public class Project {
    /** Logger field */
    private static final Logger logger = LoggerFactory.getLogger(Project.class);
    /** singleton for this class */
    private static final Project project;
    /** File object for the application classes directory or for the application jar file*/
    private File appPath;
    /** File object for included libraries directory */
    private File appLibPath;
    /** Set of all src class names (fully qualified) */
    private Set<String> srcClasses;
    /** Set of all lib class names (fully qualified) */
    private Set<String> libClasses = new LinkedHashSet<String>();
    /** Class loader for loading modeled classes */
    private ClassLoader javaAppClassLoader;
    
    static {
        project = new Project();
    }

    /**
     * Return the singleton project object the current run of DroidSafe.
     */
    public static Project v() {
        return project;
    }

    /**
     * Initialize the Project object by creating File objects and directories
     */
    public void init() {
        if (Config.v().APP_PATH == null) {
            logger.error("Project not configured properly. Missing option -apppath.");
            System.exit(1);
        } else {
            appPath = new File(Config.v().APP_PATH);
            logger.info("Setting application path to {}.", appPath.toString());
            if (!appPath.exists()) {
                logger.error("Project not configured properly. Application path {} does not exist: ", appPath);
                System.exit(1);
            }
        }
        setSrcClasses();
        if (Config.v().LIB_PATH != null) {
            appLibPath = new File(Config.v().LIB_PATH);
            setLibClasses();
        }
    }

    /** 
     * Returns the java.lang.class for an application class, represented by string s.
     */
    public Class<?> getAppJavaClass(String s) throws ClassNotFoundException {
        return javaAppClassLoader.loadClass(s);
    }

    /**
     * Add all classes from in bin/classes to the appClasses
     */
    private void setSrcClasses() {
        srcClasses = new LinkedHashSet<String>();
        if (appPath.isDirectory()) {
            for (File clazz : FileUtils.listFiles(appPath, new String[]{"class"}, true)) {

                String clzName = 
                        Utils.fromFileToClass(clazz.toString().substring(appPath.toString().length() + 1));
                logger.info("Application class: {}", clzName);
                srcClasses.add(clzName);
            }
        } else {
            try {
                JarFile jar = new JarFile(appPath);
                for (String clzName: Utils.getClassesFromJar(jar)) {
                    logger.info("Application class: {}", clzName);
                    srcClasses.add(clzName);
                }
            } catch (IOException e) {
                logger.error("Error in processing jar file {}", appPath, e);
                System.exit(1);
            }
        }
    }

    /**
     * Add all classes from any jar files into the set for library classes.
     */
    private void setLibClasses() {
        for (File f : getAppLibJars()) {
            JarFile jarFile = null;
            try {
                jarFile = new JarFile(f);
            } catch (IOException e1) {
                logger.error("Error opening jar file ",  e1);
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

    /**
     * Return the application's library directory. 
     */
    public File getAppLibPath() {
        return appLibPath;
    }

    /**
     * Returns a collection of files, one for each of the jar files in the app's lib folder
     */
    public Collection<File> getAppLibJars() {
        if (appLibPath != null && appLibPath.exists()) {
            if (appLibPath.isDirectory()) {
                return FileUtils.listFiles(appLibPath, new String[]{"jar"}, true);
            } else if (appLibPath.isFile()) {
                if (appLibPath.getName().endsWith(".jar")) {
                    Collection<File> appLibJars = new ArrayList<File>();
                    appLibJars.add(appLibPath);
                    return appLibJars;
                }
                logger.error("Project not configured properly. Application library path {} is not a jar file.", appLibPath);
                System.exit(1);
            }
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * Return the application's compiled classes directory or the application jar file. 
     */
    public File getAppPath() {
        return appPath;
    }

    /**
     * Return true if the class was loaded from the application src/ directory.
     * 
     * @param clz
     * @return
     */
    public boolean isSrcClass(String clz) {
        return srcClasses.contains(clz);
    }
    
    

    /**
     * Add a generated class to the list of src classes.
     */
    public void addSrcClass(SootClass clz) {
        srcClasses.add(clz.getName());
    }
    
    /**
     * Remove a class from the list of src classes.
     */
    public void removeSrcClass(SootClass clz) {
        srcClasses.remove(clz.getName());
    }
    
    /**
     * Return true if the class was loaded from the application src/ directory.
     * 
     * @param clz
     * @return
     */
    public boolean isSrcClass(SootClass clz) {
        return srcClasses.contains(clz.getName());
    }

    /**
     * Return set of all classes defined in bin/classes of app.
     */
    public Set<String> getSrcClasses() {
        return srcClasses;
    }

}
