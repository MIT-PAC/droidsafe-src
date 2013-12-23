package droidsafe.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
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

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;

public class ListApiMethods extends ApiUsageListing {
    private static final Logger logger = LoggerFactory.getLogger(ApiUsageListing.class);

    private Set<String> safeClassSet = new HashSet<String>();
    
    public ListApiMethods() {
        super();
    }
    
    public void saveApiList(String fileName, boolean useModifier) throws FileNotFoundException {
        
        PrintStream outStream = new PrintStream(fileName);
        for(SootClass cls: Scene.v().getClasses()) {
            for (SootMethod method: cls.getMethods()) {
                String line = '"' + method.getSignature() + '"';
                if (useModifier && method.getModifiers() != 0)
                    line = soot.Modifier.toString(method.getModifiers()) + ":" + line;
                outStream.println(line);
            }
        }    
        outStream.close();
    }
    
    public void loadSafeList(String listName) {
        InputStream listFile;
        try {
            listFile = new FileInputStream(listName);
            List<String> list = IOUtils.readLines(listFile);          
            for (String apiClass: list) {
                apiClass = apiClass.trim();
                if (apiClass.startsWith("/^\\s*#/") || apiClass.startsWith("#")) {
                    continue;
                }
                safeClassSet.add(apiClass);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }            
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Options options = new Options();
        options.addOption("o", "out",     true,  "output filename");
        options.addOption("c", "classify", true, "automatic classification");
        options.addOption("s", "safelist", true,  "list of safe classes");
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
        
        ListApiMethods listing = new ListApiMethods();
        
        if (!commandLine.hasOption("out") && !commandLine.hasOption("classify")) {
            System.out.println("Please specify either output or classify ");
            printHelp(options);
            return;
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
        listing.activateSootScene();
        
        if (commandLine.hasOption("out")) {
            String outFile = commandLine.getOptionValue("out");
            try {
                listing.saveApiList(outFile, true);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    private static void printHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("ListApiMethods [options] ", options);
    }   

}
