package droidsafe.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

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
import soot.SootMethod;
import soot.Type;
import soot.RefType;

public class CallbackWithContext extends ApiUsageListing{
    private static final Logger logger = LoggerFactory.getLogger(CallbackWithContext.class);
    
    List<String> methodList   = new LinkedList<String>();
    List<String> filteredList = new LinkedList<String>();

    public CallbackWithContext() {
        super();
    }
    
    /**
     * performing filtering on the list
     */
    private void filterMethods() {
        activateSootScene();
        filteredList.clear();
        for (String methodSig: methodList) {
            String category = categorize(methodSig);
            filteredList.add(String.format("[%s]: %s", category, methodSig));
        }
    }
    
    private boolean canIgnoreMethod(String methodSig) {
        SootMethod method;
        
        try {
            method = Scene.v().getMethod(methodSig);
        }
        catch (Exception ex) {
            return false;
        }

        if (method == null)
            return false;
        
        List<Type> typeList = method.getParameterTypes();
       
        boolean canIgnore = true;
        for(Type myType: typeList) {
            if (myType instanceof RefType) {
                logger.info("method {}, paramType {}", method, myType);
                canIgnore = false;
            }
        }
        return canIgnore;
    }
    
    private String categorize(String methodSig) {
        SootMethod method;
        
        try {
            method = Scene.v().getMethod(methodSig);
        }
        catch (Exception ex) {
            return "NOT_AVAIL";
        }

        if (method == null) {
            return "NULL_METHOD";
        }
        
        List<Type> typeList = method.getParameterTypes();
       
        String category = "IGNORE";
        boolean canIgnore = true;
        for(Type myType: typeList) {
            if (myType instanceof RefType) {
                if (myType.toString().endsWith("Event")) {
                    category = "VENT_TYPE";
                }
                else if (myType.toString().equals("java.lang.CharSequence") ||
                        myType.toString().equals("java.lang.String")) { 
                    category = "STRING_TYPE";
                }
                else {
                    logger.info("method {}, paramType {}", method, myType);
                    category = "KEEP_PARAM";
                    break;
                }
            }
        }
        // check return type
        if (!category.equals("KEEP_PARAM")) {
            Type myType = method.getReturnType();
            if ((myType instanceof RefType) && 
               !myType.toString().equals("java.lang.CharSequence") &&
               !myType.toString().equals("java.lang.CharSequence")) { 
                    category = "KEEP_RETURN"; 
            }
        }
        return category;
    }
    
    public void setMethodListFile(String file) {
        InputStream listFile;
        try {
            logger.warn("adding callback list");
            listFile = new FileInputStream(file);
            List<String> list = IOUtils.readLines(listFile);
            for (String methodSig: list) {
                methodSig = methodSig.replaceAll("=>.*", "");
                methodSig = methodSig.trim();
                if (methodSig.length() > 0)
                    methodList.add(methodSig);
            }
                            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(-1);
        }    
    }
    
    public void dumpFilteredList(String fileName) {
        try {
            PrintStream stream = new PrintStream(fileName);
            dumpFilteredList(stream);
        }
        catch (Exception ex) {
            
        }
        
    }
    
    public void dumpFilteredList() {
        dumpFilteredList(System.out);
    }
    
    /**
     * Dump filtered list to a stream
     * @param stream
     */
    private void dumpFilteredList(PrintStream stream) {
        for(String method: filteredList) {
            stream.println(method);
        }
    }
    
    
    /**
       
    /**
     * @param args
     */
    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("l", "list",   true,  "api list");
        options.addOption("a", "apijar", true,  "optional API jar file");
        options.addOption("o", "out",    true,  "ouput file");


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
        
        if (commandLine.getArgs().length == 0) {
            logger.warn("need to specify api list file ");
            System.exit(-1);
        }
        
        CallbackWithContext listing = new  CallbackWithContext();
        
        
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
 
        listing.setMethodListFile(commandLine.getArgs()[0]);
        listing.filterMethods();
        

        if (commandLine.hasOption("out")) {
            String outFile = commandLine.getOptionValue("out");
            listing.dumpFilteredList(outFile);
        }
        else {
            listing.dumpFilteredList();
        }
        
    }
    
    private static void printHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("ApiCalledByApi [options]", options);
    }   


}
