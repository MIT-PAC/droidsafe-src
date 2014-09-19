package droidsafe.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.tagkit.*;

public class ListApiMethods extends ApiUsageListing {
    
    public static int ANNO_REPORT_NONE = 0;
    public static int ANNO_REPORT_COMMENT = 1;
    public static int ANNO_REPORT_CLASSIFCATION = 2;
    public static int ANNO_REPORT_INFOFLOW = 4;
    
    private int annotationReportType = ANNO_REPORT_NONE;
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
                if (entry.startsWith("<")) {
                    entry = entry.replaceAll("^<", "");
                    entry = entry.replaceAll("\\(.*", "");
                    entry = entry.replaceAll(":\\s+.*\\s+", ".");

/*                    <java.net.InetSocketAddress: void <init>(int)>
                    <java.net.InetSocketAddress: void <init>(java.net.InetAddress,int)>
                    <java.net.InetSocketAddress: void <init>(java.lang.String,int)>
                    <java.net.InetSocketAddress: java.net.InetSocketAddress createUnresolved(java.lang.String,int)>
*/
                }
                else {
                    entry = entry.trim();
                    entry = entry.replaceAll("^\\s*\\d+\\s+",  "");
                    entry = entry.replaceAll("\\s+",  ".");
                }
                logger.debug("adding {}", entry);
                interestList.add(entry);
            }
        }
        catch (Exception ex) {
            return;
        }
    }
    
    public void setAnnoReportType(int type) {
        annotationReportType = type;
    }

    /**
     * Helper method to get a method's full name
     * @param method
     * @return
     */
    String getMethodFullName(SootMethod method) {
        String sig = method.getDeclaringClass().toString() + "." + method.getName();
        return sig;
    }

    /**
     * check if a method is of interest
     * @param sig
     * @return
     */
    private boolean methodOfInterest(String sig) {        
        if (interestList.size() == 0)
            return true;
        return interestList.contains(sig);
    }
        
    public String getAutoClassification(SootMethod method) {
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
        return classification;
    }

    /**
     * Method toe extract annotations
     * @param method
     * @return list of annotation in string format
     */
    public  List<String> extractDSAnnotations(SootMethod method) {
        List<String> annoList = new LinkedList<String>();
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

                if (!annoTag.getType().matches(".*DS(Safe|Spec|Ban|Comment|Sink|Source).*")) {
                    continue; 
                }

                logger.info("=========AnnotationTag=======");
                logger.info("{}", annoTag);
                AnnotationElem elem = annoTag.getElemAt(0);
                logger.info("TYPE:{}, ELEM-CLASS: {}, ELEM: {}", 
                        annoTag.getType(), elem.getClass(), elem);

                if (elem instanceof AnnotationStringElem) {
                    AnnotationStringElem strElem = (AnnotationStringElem)elem;
                    logger.info("TYPE: {}/ NAME:{}/VALUE: {}", 
                            annoTag.getType(), strElem.getName(), strElem.getValue());
                    String commentAnno = String.format("@DSComment(\"%s\")",strElem.getValue());
                    annoList.add(commentAnno);
                    logger.info("comment Anno: {}", commentAnno);
                }

                if (elem instanceof AnnotationEnumElem) {
                    AnnotationEnumElem enumElem = (AnnotationEnumElem)elem;
                    logger.info("TYPE:{}/ TYPENAME:{} /CONST_NAME{}: {}", enumElem.getName(), 
                            annoTag.getType(),
                            enumElem.getTypeName(),
                            enumElem.getConstantName());

                    String[] tokens = annoTag.getType().split("/");

                    String classificationType = tokens[tokens.length-1];
                    classificationType = classificationType.replace(";", "");
                    String classificationAnno = String.format("@%s(DSCat.%s)", 
                            classificationType, enumElem.getConstantName());
                    annoList.add(classificationAnno);
                    logger.info("classification Type {}", classificationAnno);
                }

                if (elem instanceof AnnotationArrayElem) {
                    AnnotationArrayElem arrayElem = (AnnotationArrayElem)elem;
                    AnnotationEnumElem enumElem = (AnnotationEnumElem)arrayElem.getValueAt(0);

                    logger.info("SINK/SOURCE {} ", enumElem);
                    String infoflowType = "None";
                    String[] tokens = annoTag.getType().split("/");
                    if (tokens.length > 0)
                        infoflowType = tokens[tokens.length-1];
                    infoflowType = infoflowType.replace(";", "");
                    logger.info("infoflowType {} ", infoflowType);

                    tokens = enumElem.getTypeName().split("/");
                    String typeName = ""; 
                    if (tokens.length > 0)
                        typeName = tokens[tokens.length - 1];
                    typeName = typeName.replaceAll(";", "");

                    String infoflowAnno = String.format("@%s({%s.%s})", 
                            infoflowType, typeName, enumElem.getConstantName());

                    logger.info("info annotation {} ", infoflowAnno);
                    annoList.add(infoflowAnno);
                }
                logger.info("==========================");
            }
        }

        return annoList;
    }

    /**
     * given a method, find its current classification
     * @param method
     * @return
     */
    public String getExistingClassification(SootMethod method) {
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


                if (!annoTag.getType().matches(".*DS(Safe|Spec|Ban|Comment|Sink|Source).*")) {
                    continue; 
                }

                logger.info("=========AnnotationTag=======");
                logger.info("{}", annoTag);
                AnnotationElem elem = annoTag.getElemAt(0);
                logger.info("TYPE:{}, ELEM-CLASS: {}, ELEM: {}", 
                        annoTag.getType(), elem.getClass(), elem);

                if (elem instanceof AnnotationStringElem) {
                    AnnotationStringElem strElem = (AnnotationStringElem)elem;
                    logger.info("TYPE: {}/ NAME:{}/VALUE: {}", 
                            annoTag.getType(), strElem.getName(), strElem.getValue());
                    commentAnno = String.format("@DSComment(\"%s\")",strElem.getValue());
                    logger.info("comment Anno: {}", commentAnno);
                }

                if (elem instanceof AnnotationEnumElem) {
                    AnnotationEnumElem enumElem = (AnnotationEnumElem)elem;
                    logger.info("TYPE:{}/ TYPENAME:{} /CONST_NAME{}: {}", enumElem.getName(), 
                            annoTag.getType(),
                            enumElem.getTypeName(),
                            enumElem.getConstantName());

                    String[] tokens = annoTag.getType().split("/");

                    String classificationType = tokens[tokens.length-1];
                    classificationType = classificationType.replace(";", "");
                    classificationAnno = String.format("@%s(DSCat.%s)", 
                            classificationType, enumElem.getConstantName());

                    logger.info("classification Type {}", classificationAnno);
                }

                if (elem instanceof AnnotationArrayElem) {
                    AnnotationArrayElem arrayElem = (AnnotationArrayElem)elem;
                    AnnotationEnumElem sinkSourceElem = (AnnotationEnumElem) arrayElem.getValueAt(0);
                    AnnotationEnumElem enumElem = (AnnotationEnumElem)arrayElem.getValueAt(0);

                    String[] tokens = annoTag.getType().split("/");
                    String infoflowType = tokens[tokens.length-1];
                    infoflowType = infoflowType.replace(";", "");
                    String infoflowAnno = String.format("@%s(DSCat.%s)", 
                            infoflowType, enumElem.getConstantName());

                    logger.info("SINK/SOURCE {} ", enumElem);
                }
                logger.info("==========================");
            }
        }

        if (classificationAnno != null && commentAnno != null) {
            classificationAnno = classificationAnno + " - " + commentAnno;
        }
        return classificationAnno;
    }
    
    public String getExistingInfoFlow(SootMethod method) {
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


                if (!annoTag.getType().matches(".*DS(Sink|Source).*")) {
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

        if (classificationAnno != null && commentAnno != null) {
            classificationAnno = classificationAnno + " - " + commentAnno;
        }
        return classificationAnno;
    }
    
    private String getModelReportLine(String line, List<String> annoList) {

        String sinkAnno = "NO_INFO";
        String sourceAnno = "NO_INFO";
        String classification = "UNCLASSIFIED";
        String comment = null;

        for (String anno: annoList) {
            if (anno.matches("@DS(Safe|Spec|Ban).*")) {
                classification = anno;
            }

            if (anno.matches("@DSSink.*")) {
                sinkAnno = anno;
            }
            if (anno.matches("@DSSource.*")) {
                sourceAnno = anno;
            }
            
            if (anno.matches("@DSComment.*")) {
                comment = anno;
            }            
        }
        
        String annoStr = "";
        if ((annotationReportType & ANNO_REPORT_CLASSIFCATION) != 0)             
            annoStr = annoStr + " - " + classification;
        
        if ((annotationReportType & ANNO_REPORT_INFOFLOW) != 0) {
            if (sourceAnno.equals("NO_INFO"))
                annoStr = annoStr + " - " + sinkAnno;
            else if (sinkAnno.equals("NO_INFO"))
                annoStr = annoStr + " - " + sourceAnno;
            else
                annoStr = annoStr + " - " + sourceAnno + " - " + sinkAnno;
        }
        
        if ((annotationReportType & ANNO_REPORT_COMMENT) != 0 && comment != null)          
            annoStr = annoStr + " - " + comment;
        
        return String.format("%s %s ", line, annoStr);
    }
 
    /**
     * Method to report state of the modelling
     * @param fileName
     * @throws FileNotFoundException
     */
    public void reportModeling(String fileName, boolean withinList) throws FileNotFoundException {
        
        PrintStream outStream = new PrintStream(fileName);
        Set<String> matchedSet = new HashSet<String>();
        for(SootClass cls: Scene.v().getClasses()) {
            for (SootMethod method: cls.getMethods()) {
                

                String name = getMethodFullName(method);
                //match list only when used with classification
                if (!methodOfInterest(name) && withinList)
                    continue;
                
                logger.info("orig method: {}", method);
                 
                Set<SootMethod> allMethods = SootUtils.getAllOverridingMethodsIncluding(method);

                for (SootMethod subMethod: allMethods) {
                    
                    name = getMethodFullName(subMethod);
                    matchedSet.add(name);
                    String line = subMethod.getSignature();
    
                    List<String> annoList = extractDSAnnotations(subMethod);
                    String reportLine = getModelReportLine(line, annoList);
                    outStream.println(reportLine);
                }
            }
        }    

        logger.info("Original list: size {}, matched {} ", 
                interestList.size(), matchedSet.size());

        interestList.removeAll(matchedSet);
        
        logger.info("After removed: {} ", interestList.size());
        
        String getString = "android.app.Activity.getString";
        if (interestList.contains(getString)) {
            logger.info("android.app.Activity.getString is still around");        
        }
        
        if (matchedSet.contains(getString)) {
            logger.info("getString {} is in matched set", getString);        
        }

        logger.info("==========Checking superclass's models .... ");
        if (interestList.size() > 0) {
            outStream.println("");
            outStream.println("");
            outStream.println("=================================================");
            outStream.println("         Superclass has models ");
            outStream.println("=================================================");
            
            List<String> remainedList = new ArrayList<String>(interestList);
            Collections.sort(remainedList);          
            
            
            for (String api: remainedList) {
                String[] tokens = api.split("\\.");
                String methodName = tokens[tokens.length - 1];
                
                String className = "";
                for (int i = 0; i < tokens.length - 1; i++) {
                    if (i == 0)
                        className = tokens[i];
                    else
                        className = className + "." + tokens[i];
                }

                logger.info("{} => {}/{}", api, className, methodName);

                SootClass sootClass = Scene.v().getSootClass(className);
                List<SootMethod> potentials = SootUtils.findPossibleInheritedMethods(sootClass, methodName);
                Set<SootMethod> potentialSet = new HashSet<SootMethod>(potentials);
                
                boolean hasSuperMethod = false;
                for (SootMethod method: potentialSet) {
                    //remove duplicate

                    String name = getMethodFullName(method);
                    logger.info("api {}, potential {} => name {} ", api, method, name);
                    
                    if (matchedSet.contains(name)) {
                        matchedSet.add(api);
                        continue;
                    }

                    List<String> annoList = extractDSAnnotations(method);
                    String reportLine = getModelReportLine(name, annoList);
                    outStream.printf("%s - ENG3 %s\n", reportLine, api);
                    matchedSet.add(name);
                    matchedSet.add(api);
                    break;
                }
            }
            
            outStream.println("");
            outStream.println("");
            outStream.println("=================================================");
            outStream.println("         No Source Found");
            outStream.println("=================================================");
            interestList.removeAll(matchedSet);
            remainedList = new ArrayList<String>(interestList); 
            Collections.sort(remainedList);
            for (String api: remainedList) {
                outStream.println(api);
            }
        }
        outStream.close();
    }
    
    private final static String CLASSIFICATION_KEY = "classification";
    private final static String SINK_KEY = "sink";
    private final static String SOURCE_KEY = "source";
    private final static String COMMENT_KEY = "comment";
    
    private final static String UNCLASSIFIED = "UNCLASSIFIED";
    private final static String NO_INFO = "NO_INFO";
    private final static String NO_COMMENT = "";
    
    public void groupClassify(String fileName, boolean withinList) throws FileNotFoundException {
        
        PrintStream outStream = new PrintStream(fileName);
        Set<String> matchedSet = new HashSet<String>();
        for(SootClass cls: Scene.v().getClasses()) {
            for (SootMethod method: cls.getMethods()) {
                String name = getMethodFullName(method);
                //match list only when used with classification
                if (!methodOfInterest(name) && withinList)
                    continue;
                
                logger.info("orig method: {}", method);
                 
                Set<SootMethod> allMethods = SootUtils.getAllOverridingMethodsIncluding(method);
                List<String> parentAnnoList = extractDSAnnotations(method); 
                Map<String, String> parentAnnotHash = new HashMap<String, String>();
                parentAnnotHash.put(CLASSIFICATION_KEY, UNCLASSIFIED);
                parentAnnotHash.put(SINK_KEY, NO_INFO);
                parentAnnotHash.put(SOURCE_KEY, NO_INFO);
                parentAnnotHash.put(COMMENT_KEY, NO_COMMENT);
                
                for (String ann: parentAnnoList) {
                    logger.info("parrent {} annotation {} ", method, ann);
                    if (ann.matches("@DS(Ban|Spec|Safe).*")) {
                        logger.info("=> Classification***");                        
                        parentAnnotHash.put(CLASSIFICATION_KEY, ann);
                    }
                                        
                    if (ann.matches("@DSSink.*")) {
                        logger.info("=> Sink ***");                        
                        parentAnnotHash.put(SINK_KEY, ann);
                    }
                    if (ann.matches("@DSSource.*")) {
                        logger.info("=> Source ***");                        
                        parentAnnotHash.put(SOURCE_KEY, ann);
                    }
                    if (ann.matches("@DSComment.*")) {
                        logger.info("=> Comment ***");                        
                        parentAnnotHash.put(COMMENT_KEY, ann);
                    }
                }
                

                // we carry the annotation of the parent method over
                for (SootMethod subMethod: allMethods) {
                    
                    name = getMethodFullName(subMethod);
                    matchedSet.add(name);
                    String line = subMethod.getSignature();    
                    
                    Map<String, String> subMethodAnnotHash = new HashMap<String, String>();
                    
                    for(String ann: extractDSAnnotations(subMethod)) {
                        logger.info("method {}, ann {} ", subMethod, ann);
                        if (ann.matches("@DS(Ban|Spec|Safe).*")) {
                            logger.info("classification => {} ", ann);
                            subMethodAnnotHash.put(CLASSIFICATION_KEY, ann);
                        }
                        if (ann.matches("@DSSink.*")) {
                            subMethodAnnotHash.put(SINK_KEY, ann);
                        }
                        if (ann.matches("@DSSource.*")) {
                            subMethodAnnotHash.put(SOURCE_KEY, ann);
                        }
                        if (ann.matches("@DSComment.*")) {
                            subMethodAnnotHash.put(COMMENT_KEY, ann);
                        }
                    }
                    
                    
                    if (!subMethodAnnotHash.containsKey(CLASSIFICATION_KEY)) {
                        String myClass = parentAnnotHash.get(CLASSIFICATION_KEY);
                        if (subMethod.isPrivate()) {
                            myClass = "@DSBan(DSCat.PRIVATE_METHOD)";
                        }
                        else if (!subMethod.isPublic() && !subMethod.isProtected()) {
                            myClass = "@DSBan(DSCat.DEFAULT_MODIFIER)";
                        }
                        logger.info("submethod {} got classification ", subMethod);
                        subMethodAnnotHash.put(CLASSIFICATION_KEY, myClass);
                    }
                    
                    if (!subMethodAnnotHash.containsKey(SINK_KEY))
                        subMethodAnnotHash.put(SINK_KEY, parentAnnotHash.get(SINK_KEY));
                    
                    if (!subMethodAnnotHash.containsKey(SOURCE_KEY))
                        subMethodAnnotHash.put(SOURCE_KEY, parentAnnotHash.get(SOURCE_KEY));
                    
                    
                    
                    List<String> annoList = new LinkedList<String>(subMethodAnnotHash.values());

                    String reportLine = getModelReportLine(line, annoList);
                    outStream.println(reportLine);
                }
            }
        }    

        logger.info("Original list: size {}, matched {} ", 
                interestList.size(), matchedSet.size());

        interestList.removeAll(matchedSet);
        
        logger.info("After removed: {} ", interestList.size());
        
        String getString = "android.app.Activity.getString";
        if (interestList.contains(getString)) {
            logger.info("android.app.Activity.getString is still around");        
        }
        
        if (matchedSet.contains(getString)) {
            logger.info("getString {} is in matched set", getString);        
        }

        logger.info("==========Checking superclass's models .... ");
        if (interestList.size() > 0) {
            outStream.println("");
            outStream.println("");
            outStream.println("=================================================");
            outStream.println("         Superclass has models ");
            outStream.println("=================================================");
            
            List<String> remainedList = new ArrayList<String>(interestList);
            Collections.sort(remainedList);          
            
            
            for (String api: remainedList) {
                String[] tokens = api.split("\\.");
                String methodName = tokens[tokens.length - 1];
                
                String className = "";
                for (int i = 0; i < tokens.length - 1; i++) {
                    if (i == 0)
                        className = tokens[i];
                    else
                        className = className + "." + tokens[i];
                }

                logger.info("{} => {}/{}", api, className, methodName);

                SootClass sootClass = Scene.v().getSootClass(className);
                List<SootMethod> potentials = SootUtils.findPossibleInheritedMethods(sootClass, methodName);
                Set<SootMethod> potentialSet = new HashSet<SootMethod>(potentials);
                
                boolean hasSuperMethod = false;
                for (SootMethod method: potentialSet) {
                    //remove duplicate

                    String name = getMethodFullName(method);
                    logger.info("api {}, potential {} => name {} ", api, method, name);
                    
                    if (matchedSet.contains(name)) {
                        matchedSet.add(api);
                        continue;
                    }

                    List<String> annoList = extractDSAnnotations(method);
                    String reportLine = getModelReportLine(name, annoList);
                    outStream.printf("%s - ENG3 %s\n", reportLine, api);
                    matchedSet.add(name);
                    matchedSet.add(api);
                    break;
                }
            }
            
            outStream.println("");
            outStream.println("");
            outStream.println("=================================================");
            outStream.println("         No Source Found");
            outStream.println("=================================================");
            interestList.removeAll(matchedSet);
            remainedList = new ArrayList<String>(interestList); 
            Collections.sort(remainedList);
            for (String api: remainedList) {
                outStream.println(api);
            }
        }
        outStream.close();
    }
       
    public void dumpBooleanCast(String fileName) {
        PrintStream outStream = null;
        try {
            outStream = new PrintStream(fileName);
        } 
        catch (Exception ex) {
            return;
        }
        
        for(SootClass cls: Scene.v().getClasses()) {
            for (SootMethod method: cls.getMethods()) {
                String line = method.getSignature();
                String modifierString = "";
                if (method.getModifiers() != 0) {
                    modifierString = soot.Modifier.toString(method.getModifiers()); 
                    if (modifierString.contains("abstract"))
                        continue;
                }

                line = modifierString + " - " + line;
                
                if (method.getReturnType().toString().equals("boolean")) {
                    outStream.println(line);
                }
            }
        }
    }

    public void saveApiList(String fileName, boolean useModifier, boolean classify) throws FileNotFoundException {
        
        PrintStream outStream = new PrintStream(fileName);
        Set<String> matchedSet = new HashSet<String>();
        for(SootClass cls: Scene.v().getClasses()) {
            for (SootMethod method: cls.getMethods()) {
               
                String classificationAnno = null;
                String commentAnno = null;
                //Extracting classification annotation
                
                String name = getMethodFullName(method);
                //match list only when used with classification
                if (!methodOfInterest(name) && classify)
                    continue;

                matchedSet.add(name);
                String line = method.getSignature();
                if (useModifier && method.getModifiers() != 0)
                    line = soot.Modifier.toString(method.getModifiers()) + ":" + line;

                if (classify) {
                    String classification = getAutoClassification(method);
                    if (classification != null)
                        classification = "[A] " + classification;
                    
                    String existingClassification = getExistingClassification(method);
                    if (existingClassification != null)
                        classification  = "[E] " + existingClassification;

                   if (classification != null)
                       line = classification + " - " +  line;         
                   else 
                       line = "[N] " + line;
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
                String[] tokens = api.split("\\.");
                String methodName = tokens[tokens.length - 1];
                
                String className = "";
                for (int i = 0; i < tokens.length - 1; i++) {
                    if (i == 0)
                        className = tokens[i];
                    else
                        className = className + "." + tokens[i];
                }

                logger.debug("{} => {}/{}", api, className, methodName);
                SootClass sootClass = Scene.v().getSootClass(className);
                List<SootMethod> potentials = SootUtils.findPossibleInheritedMethods(sootClass, methodName);
                
                boolean hasSuperMethod = false;
                for (SootMethod method: potentials) {

                    String classification = getAutoClassification(method);
                    String existingClassification = getExistingClassification(method);
                    if (existingClassification != null)
                        classification = existingClassification;
                    
                    if (classification != null) {
                        outStream.println("[UA] " + api);
                        outStream.println("  [UA] " + classification + " - " + method);
                        hasSuperMethod = true;
                    }
                }
                if (!hasSuperMethod)
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
        options.addOption("o", "out",      true,  "output filename");
        options.addOption("c", "classify", false, "automatic classification");
        options.addOption("gc", "groupclass", true, "Group classification");
        
        options.addOption("a", "apijar",   true,  "Optional API jar file");
        options.addOption("l", "list",     true,  "list of api to list (class methodname)");
        options.addOption("r", "report",   true,  "modeling report");
        options.addOption("b", "boolcast", true,  "ouputput boolean cast to a file");

        options.addOption("rc", "report-class",   false,  "include classification in report");
        options.addOption("ri", "report-info",    false,  "include info flow in report");
        options.addOption("rm", "report-comment", false,  "include comment in report");

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
       
        int annotationType = ANNO_REPORT_NONE;
        
        if (commandLine.hasOption("report-comment")) {
            annotationType |= ANNO_REPORT_COMMENT;
        }
        
        if (commandLine.hasOption("report-class")) {
            annotationType |= ANNO_REPORT_CLASSIFCATION;
        }
        
        if (commandLine.hasOption("report-info")) {
            annotationType |= ANNO_REPORT_INFOFLOW;
        }
        
        ListApiMethods listing = new ListApiMethods();
        
        logger.info("setting annotation type {} ", annotationType);

        listing.setAnnoReportType(annotationType);
        
        if (!commandLine.hasOption("out") && !commandLine.hasOption("classify") && 
            !commandLine.hasOption("boolcast") &&
            !commandLine.hasOption("groupclass") &&
            !commandLine.hasOption("report")) {
            System.out.println("Please specify options r, o, or c, b");
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
        
        boolean useList = false;
        if (commandLine.hasOption("l")) {
            listing.setReadList(commandLine.getOptionValue("l"));
            useList = true;
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
        
        if (commandLine.hasOption("report")) {
            String fileName = commandLine.getOptionValue("report");
            try {
                listing.reportModeling(fileName, useList);
            }
            catch (Exception ex) {
                
            }
        }
        
        if (commandLine.hasOption("gc")) {
            String fileName = commandLine.getOptionValue("gc");
            try {
                listing.groupClassify(fileName, useList);
            }
            catch (Exception ex) {
                
            }
        }
        
        if (commandLine.hasOption("boolcast")) {
            listing.dumpBooleanCast(commandLine.getOptionValue("boolcast"));
        }
    }
    
    private static void printHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("ListApiMethods [options] ", options);
    }   

}
