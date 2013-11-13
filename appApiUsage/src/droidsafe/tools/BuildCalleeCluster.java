package droidsafe.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.utils.SootUtils;

import soot.SootClass;
import soot.SootMethod;
import soot.Scene;
import soot.Type;
import soot.PrimType;
import soot.BooleanType;
import soot.ArrayType;


/**
 * This class dump all methods reachable from a given method.  We use this to check
 * the coverage of our models
 * @author Nguyen Nguyen
 *
 */
public class BuildCalleeCluster extends ApiUsageListing {

    private static final Logger logger = LoggerFactory.getLogger(ApiCalledByApi.class);
    
    private List<SootMethod> entryList = new LinkedList<SootMethod>();
    
    public BuildCalleeCluster() {
        super();
    }
    
    public void addEntryClass(String className) {
        activateSootScene();
        
        SootClass clz = Scene.v().getSootClass(className);
        
        for (SootMethod method: clz.getMethods()) {
            if (method.isPublic())
                entryList.add(method);
        }
        
    }

    public void addEntries(List<String>list) {
        Collections.sort(list);        
        activateSootScene();
        
        for (String methodName: list){
            methodName = methodName.replaceAll("=>.*$", "");
            methodName = methodName.trim();
            if (methodName.length() == 0)
                continue;
            
            logger.debug("methodName *{}* ", methodName);
            try {
                SootMethod method = Scene.v().getMethod(methodName);
                if (!method.getName().contains("<clinit>") && 
                    !method.getName().contains("<init>"))
                    entryList.add(method);
            }
            catch (Exception ex) {
               logger.warn("{}", ex); 
            }
            
        }
    }
    

    
    public void generateOutput(String fileName) {
        
        PrintStream stream = null;
        try {
            stream = new PrintStream(fileName);
            generateOutput(stream);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }                      
        
    }
    
    /**
     * 
     * @param stream
     */
    public void generateOutput(PrintStream stream) {
        for (SootMethod entry: entryList){
            generateMethodCluster(stream, entry);
        }
    }
    
    private void generateMethodCluster(PrintStream outStream, SootMethod method) {
        List<SootMethod> tocrawlList = new LinkedList<SootMethod>();
        LinkedHashSet<SootMethod> crawledSet = new LinkedHashSet<SootMethod>();
        
        Set<SootMethod> calleeSet = SootUtils.getCalleeSet(method);
        
        tocrawlList.addAll(calleeSet);
        
        while(!tocrawlList.isEmpty()) {
            SootMethod crawling = tocrawlList.remove(0);            
            crawledSet.add(crawling);            
            calleeSet = SootUtils.getCalleeSet(crawling);
            
            for (SootMethod callee: calleeSet){
                if (!crawledSet.contains(callee))
                    tocrawlList.add(callee);
            }
        }
        
        // Now the callee should have everything we need
        outStream.append("==================================================\n");
        outStream.printf("Method reachable by %s ", method.toString());
        outStream.append("==================================================\n");
        
        ArrayList<String> methodList = new ArrayList<String>(crawledSet.size());
        
        for (SootMethod oneMethod: crawledSet) {
            methodList.add(oneMethod.toString());
        }
        Collections.sort(methodList);
        
        int privateCount = 0;
        int protectedCount = 0;
        int publicCount = 0;
        int staticCount = 0;
        
        for (String methodName: methodList) {
            SootMethod aMethod = null;            
            try {
                aMethod = Scene.v().getMethod(methodName);
            }
            catch (Exception ex) {
                continue;
            }
            
            if (aMethod.isStatic()) {                
                staticCount++;
                continue;
            }
            
            if (aMethod.isPrivate())
                privateCount++;
            
            if (aMethod.isProtected())
                protectedCount++;
            
            if (aMethod.isPublic())
                publicCount++;                    
        }
        
        outStream.printf("%d static, %d public, %d protected, %d private, total %d \n",
                staticCount, publicCount, protectedCount, privateCount,
                (staticCount + publicCount + protectedCount + privateCount));
        
        outStream.printf("-----------------------------------------\n");
        outStream.printf("public/protected methods: %d \n",  (protectedCount + publicCount));
        
        for (String methodName: methodList) {
            SootMethod aMethod = null;            
            try {
                aMethod = Scene.v().getMethod(methodName);
            }
            catch (Exception ex) {
                continue;
            }
            if (aMethod.isProtected() || aMethod.isPublic())
                outStream.printf("  %s\n",  methodName);
        }
        
        outStream.printf("-----------------------------------------\n");
        outStream.printf("public methods: %d \n",  publicCount);
        
        for (String methodName: methodList) {
            SootMethod aMethod = null;            
            try {
                aMethod = Scene.v().getMethod(methodName);
            }
            catch (Exception ex) {
                continue;
            }
            if (aMethod.isPublic())
                outStream.printf("  %s\n",  methodName);
        }
        
        outStream.printf("-----------------------------------------\n");
        outStream.printf("protected methods: %d \n",  protectedCount);
        
        for (String methodName: methodList) {
            SootMethod aMethod = null;            
            try {
                aMethod = Scene.v().getMethod(methodName);
            }
            catch (Exception ex) {
                continue;
            }
            if (aMethod.isProtected())
                outStream.printf("  %s\n",  methodName);
        }
        

        
        outStream.printf("-----------------------------------------\n");
        outStream.printf("private methods: %d \n",  privateCount);
        
        for (String methodName: methodList) {
            SootMethod aMethod = null;            
            try {
                aMethod = Scene.v().getMethod(methodName);
            }
            catch (Exception ex) {
                continue;
            }
            if (aMethod.isPrivate())
                outStream.printf("  %s\n",  methodName);
        }
        
        outStream.printf("-----------------------------------------\n");
        outStream.printf("static methods: %d \n",  staticCount);
        
        for (String methodName: methodList) {
            SootMethod aMethod = null;            
            try {
                aMethod = Scene.v().getMethod(methodName);
            }
            catch (Exception ex) {
                continue;
            }
            if (aMethod.isStatic())
                outStream.printf("  %s\n",  methodName);
        }
        
        
    }
 
    /**
     * 
     */
    /**
     * @param args
     */
    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("o", "out",        true,  "output filename");
        options.addOption("l", "entrylist", true,  "callback list to inject (soot format)");
        options.addOption("a", "apijar",     true,  "Optional API jar file");

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
        
        BuildCalleeCluster listing = new BuildCalleeCluster();
        
        if (!commandLine.hasOption("out")) {
            
            printHelp(options);
            System.exit(-1);
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
        
        List<String> methodList = new LinkedList<String>();
        String[] arguments = commandLine.getArgs();
      
        
        if (commandLine.hasOption("entrylist")) {
            InputStream listFile;
            try {
                logger.warn("adding entry methods");
                listFile = new FileInputStream(commandLine.getOptionValue("entrylist"));
                List<String> list = IOUtils.readLines(listFile);
                listing.addEntries(list);                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.exit(-1);
            }          
        }
        
        for (String arg: commandLine.getArgs()) {
            listing.addEntryClass(arg);
        }
 
        String outFile = commandLine.getOptionValue("out");
        listing.generateOutput(outFile);
                        
    }
    
    private static void printHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("CallbackInject [options]", options);
    }   
}
