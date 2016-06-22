package objsenspark;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Scene;
import soot.SootClass;
import soot.options.Options;

/**
 * This class performs soot configuration and class loading in anticipation of the 
 * PTA run.
 */
public class SootConfig {
    private static final Logger logger = LoggerFactory.getLogger(SootConfig.class);
    
    

    public static void init() {
    	
        setOptions();
        setSootClassPath();
    }

    /**
     * Set command line options for soot.
     */
    private static void setOptions() {
        List<String> dirs = new ArrayList<String>();
        // add the classes directory or the application jar
        dirs.add(Config.v().APP_PATH);
        dirs.addAll(jreClassPathEntries());
        System.out.println("soot process dirs: " + Arrays.toString(dirs.toArray()));
        soot.options.Options.v().set_process_dir(dirs);
        if (Config.v().MAIN_CLASS != null) {
            soot.options.Options.v().set_main_class(Config.v().MAIN_CLASS);
        }
        soot.options.Options.v().set_keep_line_number(true);
        soot.options.Options.v().set_whole_program(true);
        if (Config.v().REFLECTION_LOG != null) {
            soot.options.Options.v().setPhaseOption("cg", "reflection-log:" + Config.v().REFLECTION_LOG);
        }
        soot.options.Options.v().setPhaseOption("cg", "verbose:false");
        soot.options.Options.v().setPhaseOption("cg", "trim-clinit:true");
        //soot.options.Options.v().setPhaseOption("jb.tr", "ignore-wrong-staticness:true");

        // don't optimize the program 
        soot.options.Options.v().setPhaseOption("wjop", "enabled:false");
        // allow for the absence of some classes
        soot.options.Options.v().set_allow_phantom_refs(true);
    }

    /**
     * Set the soot class path to point to the default class path appended with
     * the app path (the classes dir or the application jar)
     * and jar files in the library dir of the application.
     */
    private static void setSootClassPath() {
        StringBuffer cp = new StringBuffer();

//        String defaultClassPath = Scene.v().defaultClassPath();
//        cp.append(defaultClassPath);
               
        cp.append(jreClassPath());
        
        //add the classes directory or the application jar file
        cp.append( File.pathSeparator+ Config.v().APP_PATH);

        //add library jars
        for (File f : Project.v().getAppLibJars()) {
            cp.append(File.pathSeparator + f.toString());
        }
        
        if (Config.v().REFLECTION_LOG != null) {
            File reflectionLog = new File(Config.v().REFLECTION_LOG);
            cp.append(File.pathSeparator + reflectionLog.getParent());
        }
        
        String classpath = cp.toString();

        logger.info("Setting Soot ClassPath: {}", classpath);
        System.setProperty("soot.class.path", classpath);
        Scene.v().setSootClassPath(classpath);
    }

    private static String jreClassPath() {
    	List<String> entries = jreClassPathEntries();
    	StringBuffer buf = new StringBuffer();
    	
    	for (String entry : entries) {
    		buf.append(entry + File.pathSeparator);
    	}
    	
    	return buf.toString();
    }
    
    private static List<String> jreClassPathEntries() {
    	List<String> entries = new LinkedList<String>();
    	String jreClassesDir = Config.v().JRE + File.separator + ".." + File.separator + "Classes" + File.separator;	
    	String jreLibDir = Config.v().JRE  + File.separator + "lib" + File.separator;
    	
        StringBuffer sb = new StringBuffer();
        if(System.getProperty("os.name").equals("Mac OS X")) {
            //in older Mac OS X versions, rt.jar was split into classes.jar and ui.jar
        	entries.add(jreClassesDir + "classes.jar");    
        	entries.add(jreClassesDir + "ui.jar");
        }
        
        entries.add(jreLibDir + "rt.jar");       
        entries.add(jreLibDir + "jce.jar");
        
        return entries;
    }
}
