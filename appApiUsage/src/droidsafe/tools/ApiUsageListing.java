package droidsafe.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarFile;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.main.SootConfig;
import droidsafe.utils.SootUtils;

/**
 * This class lists APIs used in a given app.  This will help collect API directly used
 * so that we can properly model and annotate the APIs
 * @author Nguyen Nguyen
 *
 */
public class ApiUsageListing {
    private static final Logger logger = LoggerFactory.getLogger(ApiUsageListing.class);

    public ApiUsageListing() {
        setSootOptions();
    }
    
    
    public void addApiJar(String jarFile) {
        //SootUtils.loadClassesFromJar(jarFile, true, null);
        JarFile jar;
        try {
            jar = new JarFile(jarFile);
            SootUtils.loadClassesFromJar(jar, false, null);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        };               
    }

    public void addAppJar(String jarFile) {
        //SootUtils.loadClassesFromJar(jarFile, true, null);
        JarFile jar;
        try {
            jar = new JarFile(jarFile);
            SootUtils.loadClassesFromJar(jar, true, null);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        };       
    }

    public void setReport(String reportFile) {
        
    }
    
    private static void setSootOptions() {
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
     * @param args
     */
    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("o", "out",     true,  "output filename");
        options.addOption("i", "inlist",  true,  "input list of jar files");
        options.addOption("a", "apijar",  true,  "Optional API jar file");

        if (args.length == 0){
            printHelp(options);
            return;         
        }
        
        CommandLineParser cliParser = new BasicParser();
        CommandLine commandLine = null;
        try {
            commandLine = cliParser.parse(options, args);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }
                       
        String[] libJars = null;
        if (commandLine.hasOption("apijar")) {
             libJars = commandLine.getOptionValues("apijar");
            
            for (String jarFile: libJars) {
                System.out.println("jarfile: " + jarFile);
            }
        } else {
            libJars = new String[1];
            libJars[0] = droidsafe.main.Config.v().getAndroidLibJarPath();
        }
        
        ApiUsageListing listing = new ApiUsageListing();
        
        
        for (String jarName: libJars) {
            logger.warn("Loading API jar {} ", jarName);
            listing.addApiJar(jarName);
        }
        
        List<String> appJarFiles = new LinkedList<String>();
        if (commandLine.getArgList() != null){
            appJarFiles.addAll(commandLine.getArgList());
        }

        if (commandLine.hasOption("inlist")) {
            InputStream listFile;
            try {
                listFile = new FileInputStream(commandLine.getOptionValue("inlist"));
                List<String> list = IOUtils.readLines(listFile);
                appJarFiles.addAll(list);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }            
        }
        
        for (String jarName: appJarFiles) {
            logger.warn("Loading app jar {} ", jarName);
            listing.addAppJar(jarName);
        }
        
        // TODO Auto-generated method stub
        // Project.v().init();
    }
    
    private static void printHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("AndroidSdkResourceCrawler [options] <app-jars> ", options);
    }   

}
