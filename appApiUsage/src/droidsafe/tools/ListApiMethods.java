package droidsafe.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
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

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.tagkit.*;

public class ListApiMethods extends ApiUsageListing {
    private static final Logger logger = LoggerFactory.getLogger(ApiUsageListing.class);

    private Set<String> safeClassSet = new HashSet<String>();
    
    private Set<String> interestList = new HashSet<String>();
    public ListApiMethods() {
        super();
    }
    
    /**
     * set the read list, will try to read the file
     * The file can be in the format:  class method  | class.method (no signature)
     * @param readList
     */
    public void setReadList(String readList) {
        InputStream listFile;
        try {
            logger.warn("adding interest list");
            listFile = new FileInputStream(readList);
            List<String> list = IOUtils.readLines(listFile);
            
            for (String entry: list) {
                entry = entry.trim();
                entry = entry.replaceAll("\\d+\\s+",  "");
                entry = entry.replaceAll("\\s+",  ".");
                logger.debug("adding {}", entry);
                interestList.add(entry);
            }
        }
        catch (Exception ex) {
            return;
        }
    }
    

    String getMethodFullName(SootMethod method) {
        String sig = method.getDeclaringClass().toString() + "." + method.getName();
        return sig;
    }
    private boolean matchedMethodSignature(String sig) {        
        if (interestList.size() == 0)
            return true;
        return interestList.contains(sig);
    }
    
    public void saveApiList(String fileName, boolean useModifier, boolean classify) throws FileNotFoundException {
        
        int i = 0;
        PrintStream outStream = new PrintStream(fileName);
        Set<String> matchedSet = new HashSet<String>();
        for(SootClass cls: Scene.v().getClasses()) {
            for (SootMethod method: cls.getMethods()) {
               
                String classificationAnno = null;
                String commentAnno = null;
                //Extracting classification annotation
                for (Tag tag: method.getTags()) {
                    logger.debug("{} => {}/{}", method, tag.getClass(), tag);
                    if (!(tag instanceof soot.tagkit.VisibilityAnnotationTag)) {
                        continue;
                    }
                    VisibilityAnnotationTag visAnnotation = (VisibilityAnnotationTag)tag;

                    logger.debug("visAnnotation {} ", visAnnotation);

                    StringBuilder sb = new StringBuilder();
                    for (AnnotationTag annoTag: visAnnotation.getAnnotations()) {
                        if (annoTag.getNumElems() < 1)
                            continue;

                        
                        if (!annoTag.getType().matches(".*DS(Safe|Spec|Ban|Comment).*")) {
                           continue; 
                        }

                        logger.debug("=========AnnotationTag=======");
                        logger.debug("{}", annoTag);
                        AnnotationElem elem = annoTag.getElemAt(0);
                        logger.debug("TYPE:{}, ELEM-CLASS: {}, ELEM: {}", 
                                annoTag.getType(), elem.getClass(), elem);
                        
                        if (elem instanceof AnnotationStringElem) {
                            AnnotationStringElem strElem = (AnnotationStringElem)elem;
                            logger.debug("TYPE: {}/ NAME:{}/VALUE: {}", 
                                    annoTag.getType(), strElem.getName(), strElem.getValue());
                            commentAnno = String.format("@DSComment(\"%s\")",strElem.getValue());
                            logger.debug("comment Anno: {}", commentAnno);
                        }

                        if (elem instanceof AnnotationEnumElem) {
                            AnnotationEnumElem enumElem = (AnnotationEnumElem)elem;
                            logger.debug("TYPE:{}/ TYPENAME:{} /CONST_NAME{}: {}", enumElem.getName(), 
                                    annoTag.getType(),
                                    enumElem.getTypeName(),
                                    enumElem.getConstantName());
                            
                            String[] tokens = annoTag.getType().split("/");

                            String classificationType = tokens[tokens.length-1];
                            classificationType = classificationType.replace(";", "");
                            classificationAnno = String.format("@%s(DSCat.%s)", 
                                    classificationType, enumElem.getConstantName());

                            logger.debug("classification Type {}", classificationAnno);
                        }
                        logger.debug("==========================");
                    }
                }

                String name = getMethodFullName(method);
                //match list only when used with classification
                if (!matchedMethodSignature(name) && classify)
                    continue;

                matchedSet.add(name);
                String line = method.getSignature();
                if (useModifier && method.getModifiers() != 0)
                    line = soot.Modifier.toString(method.getModifiers()) + ":" + line;
                if (classify) {
                   String classification = null;
                   int modifiers = method.getModifiers();
                   if (soot.Modifier.isAbstract(modifiers)) {
                       classification = "@DSSpec(DSCat.ABSTRACT_METHOD) - @DSComment(\"Abstract Method\")";  
                   }
                   else if (soot.Modifier.isPrivate(modifiers)) {
                       classification = "@DSBan(DSCat.PRIVATE_METHOD) - @DSComment(\"Private Method\")";  
                   }
                   else if (!soot.Modifier.isProtected(modifiers) && !soot.Modifier.isPublic(modifiers)) {
                       classification = "@DSBan(DSCat.DEFAULT_MODIFIER) - @DSComment(\"Package priviledge\")";  
                   }
                   else if (SafeAndroidClassesAndMethods.v().isSafeMethod(method)) {
                       classification = "@DSSafe(DSCat.SAFE_LIST) - @DSComment(\"From safe class list\")";                                     
                   }
                   
                   if (classificationAnno != null) {
                      if (commentAnno != null) {
                          classificationAnno = classificationAnno + " - " + commentAnno;
                      }
                      classification  = "[E] " + classificationAnno;
                   }

                   if (classification != null)
                       line = classification + " - " +  line;         
                }
                outStream.println(line);
            }
        }    
        if (interestList.size() > 0) {
            interestList.removeAll(matchedSet);
            outStream.println("");
            outStream.println("");
            outStream.println("=================================================");
            outStream.println("         Remained     ");
            outStream.println("=================================================");
            
            List<String> remainedList = new ArrayList<String>(interestList);
            Collections.sort(remainedList);          
            
            for (String api: remainedList) {
                outStream.println("[U] " + api);
            }
        }
        outStream.close();
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Options options = new Options();
        options.addOption("o", "out",     true,  "output filename");
        options.addOption("c", "classify", false, "automatic classification");
        options.addOption("a", "apijar",  true,  "Optional API jar file");
        options.addOption("l", "list",  true,  "list of api to list (class methodname)");

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
        
        boolean classify = false;
        
        if (commandLine.hasOption("classify"))
            classify = true;
        
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
        
        if (commandLine.hasOption("l")) {
            listing.setReadList(commandLine.getOptionValue("l"));
        }
        listing.activateSootScene();
        
        if (commandLine.hasOption("out")) {
            String outFile = commandLine.getOptionValue("out");

            try {
                if (classify)
                    listing.saveApiList(outFile, false, classify);
                else
                    listing.saveApiList(outFile, true, false);

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
