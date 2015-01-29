package droidsafe.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.HashSet;
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
 * This class holds the tool to inject callback to various class
 * @author Nguyen Nguyen
 *
 */
public class CallbackInject extends ApiUsageListing {

    private static final Logger logger = LoggerFactory.getLogger(ApiCalledByApi.class);
    
    private List<SootMethod> callbackList = new LinkedList<SootMethod>();
    
    public CallbackInject() {
        super();
    }
    
    public void addCallbacks(List<String>list) {
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
                    callbackList.add(method);
            }
            catch (Exception ex) {
               logger.warn("{}", ex); 
            }
            
        }
    }
    

    private String buildConstructorInvoke(String className){     
        SootClass paramClass = null;
        
        try {
             paramClass = Scene.v().getSootClass(className);
        }
        catch(Exception ex){
            logger.warn("cannot resolve class {} ", className);
            return "null";
        }
        
        
        if (!paramClass.isConcrete()) {
            SootClass resolved = SootUtils.getCloseConcrete(paramClass);
            logger.info("class {} is not CONRETE, try to resolve to {} ", paramClass, resolved);
            paramClass = resolved; 
        }            


        if (paramClass == null) {
            logger.warn("className {} has no conrete implementation ", className);
            return "null";            
        }

        SootMethod constructor = SootUtils.findSimpliestConstructor(paramClass);            
        String shortName = paramClass.getShortName();
        
        if (constructor.getParameterCount() == 0 && !constructor.isPrivate()) {
            return (String.format("new %s()", shortName));
        }
        
       
        return String.format("%s.droidsafeObtain()", shortName);
        // for more complicated one, we will 
        //return buildInvokeString(constructor);
    }
    
    
    private String buildInvokeString(SootMethod method) {
          
        List<Type> parameters = method.getParameterTypes();
        logger.info("name {}: parameters {} ", method.getName(), parameters);
        
        StringBuilder paramBuilder = new StringBuilder();
        for (Type paramType: parameters) {
            if (paramBuilder.length() > 0)
                paramBuilder.append(", ");
            
            // take care of boolean
            if (paramType instanceof BooleanType) {
                paramBuilder.append("getTaintBoolean()");
                continue;
            }
            // take care of other primitives
            if (paramType instanceof  PrimType) {
                paramBuilder.append("getTaintByte()");
                continue;
            }
            
            if (paramType instanceof ArrayType) {
                ArrayType arrayType = (ArrayType)paramType;
                Type elementType = arrayType.getArrayElementType();   
                paramBuilder.append(String.format("new %s[1]", elementType.toString()));
                continue;
            }
            
            // take care of reference
            String className = paramType.toString();
            String constructorInvoke = buildConstructorInvoke(className);
            
            paramBuilder.append(constructorInvoke);                     
        }
        logger.info("paramBuilder {} ", paramBuilder.toString());
                
        return String.format("%s(%s);", method.getName(), paramBuilder.toString());        
        
    }
    
    public void generateOutput(String fileName) {
        
        PrintStream stream;
        try {
            stream = new PrintStream(fileName);
            generateOutput(stream);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }                      
    }
    
    /**
     * 
     * @param stream
     */
    public void generateOutput(PrintStream stream) {
        Set<SootClass> processedClasses = new HashSet<SootClass>();
        
        StringBuilder builder = new StringBuilder();
        for (SootMethod method: callbackList) {
            SootClass clz = method.getDeclaringClass();
            
            if (!processedClasses.contains(clz)) {
                
                //close previous classes
                if (!processedClasses.isEmpty()) {
                    builder.append("}\n\n");
                    stream.append(builder.toString());
                }
                    
                processedClasses.add(clz);
                builder = new StringBuilder();
                builder.append("//////////////////////////////////////////////////\n");
                builder.append("//callback injection for " + clz.toString() + "\n");
                builder.append("//////////////////////////////////////////////////\n");
                builder.append("\n");
                builder.append("public void droidsafeInvokeCallbacks() {\n");
            }
            
            builder.append("    " + buildInvokeString(method) + "\n");
                    
        }        
        if (!processedClasses.isEmpty()) {
            builder.append("}\n\n");
            stream.append(builder.toString());
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
        options.addOption("l", "injectlist", true,  "callback list to inject (soot format)");
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
        
        CallbackInject listing = new CallbackInject();
        
        if (!commandLine.hasOption("injectlist") || !commandLine.hasOption("out")) {
            
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
      
        
        InputStream listFile;
        try {
            logger.warn("adding callback list");
            listFile = new FileInputStream(commandLine.getOptionValue("injectlist"));
            List<String> list = IOUtils.readLines(listFile);
            listing.addCallbacks(list);                
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(-1);
        }            
 
        String outFile = commandLine.getOptionValue("out");
        listing.generateOutput(outFile);
                        
    }
    
    private static void printHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("CallbackInject [options]", options);
    }   
}
