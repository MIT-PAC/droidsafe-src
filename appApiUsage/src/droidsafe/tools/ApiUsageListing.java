package droidsafe.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;

import droidsafe.utils.SootUtils;

/**
 * This class lists APIs used in a given app.  This will help collect API directly used
 * so that we can properly model and annotate the APIs
 * @author Nguyen Nguyen
 *
 */
public class ApiUsageListing {
    private static final Logger logger = LoggerFactory.getLogger(ApiUsageListing.class);
    
    private PrintStream printStream = System.out;

    public ApiUsageListing() {
        setSootOptions();
    }
    
    
    public void addApiJar(String jarFile) {
        //SootUtils.loadClassesFromJar(jarFile, true, null);
        JarFile jar;
        try {
            jar = new JarFile(jarFile);
            SootUtils.loadClassesFromJar(jar, false, new HashSet<String>());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        };               
    }

    private HashMap<SootMethod, Integer> apiAllUsage    = new HashMap<SootMethod, Integer>();
    private HashMap<SootMethod, Integer> apiAllOverride = new HashMap<SootMethod, Integer>();
    
    int jarCount = 0;
    
    public void addAppJar(String jarFile) {
        //SootUtils.loadClassesFromJar(jarFile, true, null);
        logger.info("Loading appJar {}", jarFile);
        JarFile jar;
        try {
            jar = new JarFile(jarFile);
            SootUtils.loadClassesFromJar(jar, true, new HashSet<String>());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        };
        
        jarCount++;
        
        HashMap<SootMethod, Integer> apiUsage    = new HashMap<SootMethod, Integer>();
        HashMap<SootMethod, Integer> apiOverride = new HashMap<SootMethod, Integer>();
        
        Scene.v().getApplicationClasses().clear();

        // Going through all methods inside the class
        for (SootClass sootClass: Scene.v().getApplicationClasses()) {
            logger.info("Application classes {} ", sootClass);
        
            for (SootMethod sootMethod: sootClass.getMethods()) {
                // Check for overriding method
                // check for method being called by someone
                logger.info("Method {} ", sootMethod);
                                
                SootMethod overriden = SootUtils.getApiOverridenMethod(sootMethod);

                //if (SootUtils.isApiOverridenMethod(sootMethod)) {
                if (overriden != null) {

                    logger.info("{} is API overring method ", sootMethod);
                    if (!apiOverride.containsKey(overriden)) {
                        apiOverride.put(overriden, 0);                        
                    }
                    // add the counter
                    apiOverride.put(overriden, apiOverride.get(overriden)+1);
                }

                Set<SootMethod> calleeSet = SootUtils.getCalleeSet(sootMethod);
                for (SootMethod method: calleeSet) {
                    // skip aplication class
                    if (method.getDeclaringClass().isApplicationClass()) {
                        continue;
                    }
                    // if the callee is not application class, it is direct API class
                   if (!apiUsage.containsKey(method)) {
                        apiUsage.put(method, 0);                        
                    }
                    
                    // add the counter
                    apiUsage.put(method, apiUsage.get(method)+1); 
                }
            }            
        }
        
        printJarReport(jarFile, apiOverride, apiUsage);
        
        apiAllOverride.putAll(apiOverride);
        apiAllUsage.putAll(apiUsage);
    }
    
    /**
     * Set a report File
     * @param reportFile
     */
    public void setReportFile(String reportFile) {
        try {
            PrintStream stream = new PrintStream(reportFile);
            printStream = stream;
        }
        catch (Exception ex) {
            logger.warn("Cannot open report file {}", reportFile);
        }        
    }
    
    public void printSummaryReport(){
       printStream.printf("======== Summary for all (%d) Jars =============\n", jarCount); 
       printJarReport("All", apiAllOverride, apiAllUsage);
    }
    /**
     * Output report for each section
     * @param jarFile
     * @param overrideMap
     * @param usageMap
     */
    private void printJarReport(String jarFile, Map<SootMethod, Integer> overrideMap, 
                                Map<SootMethod, Integer> usageMap) {
       
       printStream.printf("========Output Report for jar %s=======\n", jarFile);
       printStream.printf("API overriden methods:\n");
       printStream.printf("----------------------\n");
       
       ArrayList<String> methodList = new ArrayList<String>(overrideMap.size());
       
       for (SootMethod method: overrideMap.keySet()) {
           methodList.add(method.toString());
       }
       Collections.sort(methodList);
       
       for (String methodSig: methodList) {
           SootMethod method = Scene.v().getMethod(methodSig); 
           printStream.printf("%s => %d \n",  method, overrideMap.get(method));           
       }
       methodList = new ArrayList<String>(usageMap.size());
       

       for (SootMethod method: usageMap.keySet()) {
           methodList.add(method.toString());
       }
       Collections.sort(methodList);
       
       printStream.printf("\nDirect API call methods: \n");
       printStream.printf("----------------------\n");
       for (String methodSig: methodList) {
           SootMethod method = Scene.v().getMethod(methodSig);       
           printStream.printf("%s => %d \n",  method, usageMap.get(method));           
       }
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
        
        if (commandLine.hasOption("out")) {
            String outFile = commandLine.getOptionValue("out");
            listing.setReportFile(outFile);
        }
        
        StringBuilder cp = new StringBuilder();
        
        cp.append(".");
        for (String jarName: libJars) {
            cp.append(File.pathSeparator + jarName);
        }

        List<String> appJarFiles = new LinkedList<String>();
        String[] arguments = commandLine.getArgs();
        for (String arg: arguments) {
            appJarFiles.add(arg);
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
            cp.append(File.pathSeparator + jarName);
        }
        System.setProperty("soot.class.path", cp.toString());
        logger.info("classpath: {} ", cp.toString());

        for (String jarName: libJars) {
            logger.warn("Loading API jar {} ", jarName);
            listing.addApiJar(jarName);
        }
 

        for (String jarName: appJarFiles) {
            logger.warn("Loading app jar {} ", jarName);
            listing.addAppJar(jarName);
        }
        
        listing.printSummaryReport();

    }
    
    private static void printHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("AndroidSdkResourceCrawler [options] <app-jars> ", options);
    }   

}
