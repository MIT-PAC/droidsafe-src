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
import soot.Type;
import soot.util.Chain;

import droidsafe.utils.SootUtils;

/**
 * This class lists public/protected APIs that are called by other API.  These are good indications
 * of potential user callback hooks/overriding 
 * so that we can properly model and annotate the APIs
 * @author Nguyen Nguyen
 *
 */
public class ApiCalledByApi extends ApiUsageListing{
    private static final Logger logger = LoggerFactory.getLogger(ApiCalledByApi.class);
    
    private PrintStream printStream = System.out;
    
    private Map<SootMethod, Set<SootMethod>> callerSetMap = new HashMap<SootMethod, Set<SootMethod>>();
    private Set<SootMethod> noCalleeSet = new HashSet<SootMethod>();
    private Set<SootMethod> privateNoCallerSet = new HashSet<SootMethod>();
    protected HashSet<SootMethod> interfaceParameterMethodSet = new HashSet<SootMethod>();
    
    private int privateCount = 0;
    private int publicCount = 0;
    private int protectedCount = 0;
    
    public ApiCalledByApi() {
        super();
    }
    
    public void buildInterfaceApiMap() {
        for (SootClass  clz: Scene.v().getClasses()) {
            for (SootMethod method: clz.getMethods()) {
                if (method.isAbstract())
                    continue;
                for (Type type: method.getParameterTypes()) {
                    if (type instanceof soot.RefType) {
                        SootClass clazz = ((soot.RefType)type).getSootClass();
                        if (clazz.isInterface() && !clazz.isApplicationClass()) {
                            logger.info("method {} uses API interface", method);
                            interfaceParameterMethodSet.add(method); 
                        }
                    }
                }

            }
        }
    }
    
    public void buildCallerSetMap() {
        for (SootClass  clz: Scene.v().getClasses()) {
            for (SootMethod caller: clz.getMethods()) {
                if (caller.isPrivate())
                    privateCount++;

                if (caller.isProtected())
                    protectedCount++;

                if (caller.isPublic())
                    publicCount++;

                // Find the list of caller
                Set<SootMethod> calleeSet = SootUtils.getCalleeSet(caller);
                // Foreach callee, we build a set of methods that call the callee
                for (SootMethod callee: calleeSet) {
                    if (!callerSetMap.containsKey(callee)) {
                        Set<SootMethod> callerSet = new HashSet<SootMethod>();
                        callerSetMap.put(callee, callerSet);
                    }
                    Set<SootMethod> callerSet = callerSetMap.get(callee);
                    callerSet.add(caller);
                }
                // add to the set of methods that don't call anyone
                if (calleeSet.size() == 0 && !caller.isPrivate()) {
                    noCalleeSet.add(caller);
                }
            }
        }
        
        // find out private methods that have no caller
        for (SootClass  clz: Scene.v().getClasses()) {
            for (SootMethod method: clz.getMethods()) {
                if (method.isPrivate() && !callerSetMap.containsKey(method)) {
                    //both private and has no caller
                    privateNoCallerSet.add(method);
                }             
            }
        }
        // Now we are going through callerSetMap to list out all the keys
        // which are the callees that are called by other methods
        
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
    
    public void printApiUsedInApi(){
       printStream.printf("======== List of API used inside API =============\n");
       printStream.printf("public: %d,  protected: %d, private: %d, total: %d \n",
                   publicCount, protectedCount, privateCount,
                   (publicCount + privateCount + protectedCount));
       
       ArrayList<String> methodList = new ArrayList<String>(callerSetMap.size());
       
       for (SootMethod method: callerSetMap.keySet()) {
           methodList.add(method.toString());
       }
       Collections.sort(methodList);
       
       for (String methodSig: methodList) {
           try {
               SootMethod callee = Scene.v().getMethod(methodSig);
               SootClass clz = callee.getDeclaringClass();
               // if callee is interface, final, private, don't bother
               if (clz == null || clz.isInterface() || clz.isPrivate()) 
                   continue;
               
               if (callee.isPrivate() || callee.isAbstract())
                   continue;
               
               Set<SootMethod> callerSet = callerSetMap.get(callee);

               printStream.printf("%s => %d \n",  callee, callerSetMap.get(callee).size());
           }
           catch (Exception e) {
               logger.warn("exception {}", e);
           }
       }
       
       printStream.printf("======== List of unused private methods (%d) =============\n",
               privateNoCallerSet.size());
       
       methodList = new ArrayList<String>(privateNoCallerSet.size());
       for (SootMethod method: privateNoCallerSet){
           methodList.add(method.toString());
       }
       Collections.sort(methodList);
       
       for (String methodSig: methodList) {
           printStream.printf("%s \n", methodSig);
       }
       
       printStream.printf("======== Non-private, no callee methods (%d) =============\n",
               noCalleeSet.size());
       
       methodList = new ArrayList<String>(noCalleeSet.size());
       for (SootMethod method: noCalleeSet){
           if (!method.isPrivate())
           methodList.add(method.toString());
       }
       Collections.sort(methodList);
       
       for (String methodSig: methodList) {
           printStream.printf("%s \n", methodSig);
       }
       printApiWithInterfaceParam();
    }
    
    
    /**
     * print out public method without callees
     * @param fileName
     */
    public void printPublicWithNoCallee(String fileName) {
        
    }

    public void printApiWithInterfaceParam() {
        
        List<String>methodList = new ArrayList<String>(interfaceParameterMethodSet.size());
        
        for (SootMethod method: this.interfaceParameterMethodSet) {
            logger.info("method: {}", method);
            methodList.add(method.toString());
        }
        Collections.sort(methodList);
        
        printStream.printf("----------------------------------------------\n");
        printStream.printf("\nMethod with API Interface parameters: \n");
        printStream.printf("----------------------\n");
        for (String methodSig: methodList) {
            try {
            SootMethod method = Scene.v().getMethod(methodSig);       
            printStream.printf("%s \n",  method);
            }
            catch (Exception e) {
                //logger.warn("exception {}", e);
                logger.info("method {} not availalbe ", methodSig);
            }
        }
    }
       
    public void printCallByTree(String callbyFile){
        printCallByTree(callbyFile, false);
    }
    /**
     * 
     * @param callbyFile
     * @param everything no filter
     */
    public void printCallByTree(String callbyFile, boolean everything){
        PrintStream stream; 
        try {
            stream = new PrintStream(callbyFile);            
        }
        catch (Exception ex) {
            logger.warn("Cannot open report file {}", callbyFile);
            return;            
        }    
        
        ArrayList<String> methodList = new ArrayList<String>(callerSetMap.size());
        
        for (SootMethod method: callerSetMap.keySet()) {
            methodList.add(method.toString());
        }
        Collections.sort(methodList);
        
        for (String methodSig: methodList) {
            try {
                SootMethod callee = Scene.v().getMethod(methodSig);
                SootClass clz = callee.getDeclaringClass();
                // if callee is interface, final, private, don't bother
                if (!everything) {
                    if (clz.isInterface() || clz.isPrivate())
                        continue;
                    
                    if (callee.isPrivate() || callee.isAbstract())
                        continue;
                }
            
                Set<SootMethod> callerSet = callerSetMap.get(callee);

                stream.printf("%s => %d \n",  callee, callerSetMap.get(callee).size());
                for (SootMethod caller: callerSet) {
                    stream.printf("    %s \n",  caller);
                }
                stream.println();
            }
            catch (Exception e) {
                logger.warn("exception {}", e);
            }
        }
        
        
        // for each method, we will print out a list of API that calls it
        stream.close();        
      
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("o", "out",     true,  "output filename");
        options.addOption("c", "callby",  true,  "callby tree output");
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
        
        ApiCalledByApi listing = new ApiCalledByApi();
        
        if (commandLine.hasOption("out")) {
            String outFile = commandLine.getOptionValue("out");
            listing.setReportFile(outFile);
        }
        
        StringBuilder cp = new StringBuilder();
        
        cp.append(".");
        for (String jarName: libJars) {
            cp.append(File.pathSeparator + jarName);
        }

        System.setProperty("soot.class.path", cp.toString());
        logger.info("classpath: {} ", cp.toString());

        for (String jarName: libJars) {
            logger.warn("Loading API jar {} ", jarName);
            listing.addApiJar(jarName);
        }
 
        listing.buildCallerSetMap();
        listing.buildInterfaceApiMap();
        listing.printApiUsedInApi();
        
        if (commandLine.hasOption("callby")) {
            String callbyFile = commandLine.getOptionValue("callby");
            listing.printCallByTree(callbyFile);
        }
    }
    
    private static void printHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("ApiCalledByApi [options]", options);
    }   

}
