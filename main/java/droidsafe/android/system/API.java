package droidsafe.android.system;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.LineNumberReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.ArrayType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.tagkit.AnnotationArrayElem;
import soot.tagkit.AnnotationElem;
import soot.tagkit.AnnotationEnumElem;
import soot.tagkit.AnnotationTag;
import soot.tagkit.SyntheticTag;
import soot.tagkit.Tag;
import soot.tagkit.VisibilityAnnotationTag;
import droidsafe.android.app.Hierarchy;
import droidsafe.android.app.Project;
import droidsafe.main.Config;
import droidsafe.utils.SootMethodList;
import droidsafe.utils.SootUtils;
import droidsafe.utils.Utils;


/**
 * This class represents the Android API classes and methods and our classification 
 * of those methods.  
 * 
 * There are sets for classification of the methods into safe, spec, and ban.
 * 
 * @author mgordon
 *
 */
public class API {
    private final static Logger logger = LoggerFactory.getLogger(API.class);
    /** all safe methods */
    private  SootMethodList safe_methods = new SootMethodList(); 
    /** all spec methods */
    private  SootMethodList spec_methods = new SootMethodList();
    /** All the system methods defined in the API */
    private SootMethodList all_sys_methods = new SootMethodList();
    /** All banned methods as described in config-files */
    private  SootMethodList banned_methods = new SootMethodList();
    /** All methods that are modeled in the api modeling */
    private  SootMethodList api_modeled_methods = new SootMethodList();
    /** Set of all Android Classes */
    private Set<SootClass> allSystemClasses;
    /** Set of android methods that have DSVerified annotation */
    private SootMethodList verified_methods = new SootMethodList();
    /** the current runtime instance */
    private static API v;
    /** The classes that define the droidsafe library */
    private final Set<String> droidSafeLibraryClasses = 
            new HashSet<String>(Arrays.asList(
                "edu.mit.csail.droidsafe.DroidSafeCalls"
                    ));

    private Map<String,Class<?>> stubsForModeledClasses;
    /** Classification category for methods */
    private Map<SootMethod, String> classificationCat;
    /** map of sources from soot method to info kinds */
    private Map<SootMethod,Set<InfoKind>> srcsMapping;
    /** map of sinks from soot method to info kinds */
    private Map<SootMethod,Set<InfoKind>> sinksMapping;
    /** default info kind for a spec or ban method that is not labeled */
    public InfoKind SENSITIVE_NOCATEGORY;

    /** Container classes that we have modified to be understood by our analysis. */
    private Set<String> droidSafeContainerClasses = 
            new HashSet<String>(Arrays.asList(
                "java.util.AbstractCollection",
                "java.util.AbstractList",
                "java.util.ArrayList",
                "java.util.AbstractSequentialList",
                "java.util.LinkedList",
                "java.util.Vector",
                "java.UnsafeArrayList",
                "java.util.AbstractQueue",
                "java.util.AbstractSet",
                "java.util.HashSet",
                "java.util.LinkedHashSet",
                "java.util.TreeSet",
                "java.util.AbstractMap",
                "java.util.EnumMap",
                "java.util.HashMap",
                "java.util.LinkedHashMap",
                "java.util.TreeMap",
                "java.util.IdentityHashMap",
                "java.util.WeakHashMap",
                "java.util.Dictionary",
                "java.util.Hashtable"
                    ));



    static {
        v = new API();
    }

    /**
     * Return the current runtime instance.
     */
    public static API v() {
        return v;
    }

    /**
     * Return true if the given string represents a container class that we have modified to 
     * be understood by our analysis.
     */
    public boolean isContainerClass(String clz) {
        return droidSafeContainerClasses.contains(clz);
    }

    /**
     * Add a class to the list of container classes...
     */
    public void addContainerClass(SootClass clz) {
        droidSafeContainerClasses.add(clz.getName());
    }
    
    /**
     * When adding a method clone, make sure the cloned method has all same designations as
     * original.
     */
    public void cloneMethodClassifications(SootMethod original, SootMethod clone) {
        if (API.v().isBannedMethod(original.getSignature())) 
            API.v().addBanMethod(clone);
        else if (API.v().isSpecMethod(original)) 
            API.v().addSpecMethod(clone);
        else if (API.v().isSafeMethod(original)) 
            API.v().addSafeMethod(clone);
        else if (API.v().isSystemClass(original.getDeclaringClass())){
            //some methods are auto generated and don't have a classification 
            API.v().addBanMethod(clone);
        }
        
        if (classificationCat.containsKey(original)) {
            classificationCat.put(clone, classificationCat.get(original));
        }
        
        if (srcsMapping.containsKey(original)) {
            Set<InfoKind> ifs = new HashSet<InfoKind>();
            ifs.addAll(srcsMapping.get(original));
            srcsMapping.put(clone, ifs);
        }
        
        if (sinksMapping.containsKey(original)) {
            Set<InfoKind> ifs = new HashSet<InfoKind>();
            ifs.addAll(sinksMapping.get(original));
            sinksMapping.put(clone, ifs);
        }
    }
    
    /**
     * If adding a class that is a clone, make sure to add the clone to the correct maps,
     * as guided by the original class.
     */
    public void cloneClassClassifications(SootClass original, SootClass clone) {
        if (isSystemClass(original)) {
            addSystemClass(clone);
        }

        if (isContainerClass(original.getName())) 
            addContainerClass(clone);

        if (Project.v().isSrcClass(original)) {
            Project.v().addSrcClass(clone);
        }

        if (Project.v().isGenClass(original)) {
            Project.v().addGenClass(clone);
        }

        if (Project.v().isLibClass(original)) {
            Project.v().addLibClass(clone);
        }
    }

    public void init() {
        //uncomment this to create system method files
        //createAllSystemMethodsFile();

        try {
            srcsMapping = new HashMap<SootMethod,Set<InfoKind>>();

            sinksMapping = new HashMap<SootMethod,Set<InfoKind>>();

            allSystemClasses = new LinkedHashSet<SootClass>();

            safe_methods = new SootMethodList(); 

            spec_methods = new SootMethodList();

            all_sys_methods = new SootMethodList();

            banned_methods = new SootMethodList();

            api_modeled_methods = new SootMethodList();

            classificationCat = new HashMap<SootMethod, String>();
            
            SENSITIVE_NOCATEGORY = InfoKind.getInfoKind("SENSITIVE_NOCATEGORY");

            //load any modeled classes from the api model, overwrite the stub classes
            JarFile apiModeling = new JarFile(new File(Config.v().getAndroidLibJarPath()));
            Set<SootClass> modeledClasses = SootUtils.loadClassesFromJar(apiModeling, true, new LinkedHashSet<String>()); 
            allSystemClasses.addAll(modeledClasses);
            all_sys_methods.addAllMethods(apiModeling);

            Set<String> modeledClassNames = new LinkedHashSet<String>();
            for (SootClass modeled : modeledClasses) 
                modeledClassNames.add(modeled.getName());

            Config.v();
            //load the configured android jar file
            JarFile androidJar = new JarFile(new File(Config.v().ANDROID_LIB_DIR, Config.ANDROID_JAR));
            allSystemClasses.addAll(SootUtils.loadClassesFromJar(androidJar, false, modeledClassNames));
            all_sys_methods.addAllMethods(androidJar);

        } catch (Exception e) {
            logger.error("Error loading android.jar", e);
            droidsafe.main.Main.exit(1);
        }

        //loadDroidSafeCalls();
        findModeledMethods();
        checkForUnmodeledMissingAPIMethods();
        //old load classification code from config_files/system_calls.txt
        //now we classify based on the annotation DSModeled
        //loadClassification();
    }

    /**
     * Add the given class to the list of system classes.  Used when new classes are created.
     */
    public void addSystemClass(SootClass sc) {
        allSystemClasses.add(sc);
    }

    /** 
     * Add the given method to the list of safe methods.
     */
    public void addSafeMethod(SootMethod sm) {
        all_sys_methods.addMethod(sm);
        safe_methods.addMethod(sm);
        api_modeled_methods.addMethod(sm);
    }

    /** 
     * Add the given method to the list of spec methods.
     */
    public void addSpecMethod(SootMethod sm) {
        all_sys_methods.addMethod(sm);
        spec_methods.addMethod(sm);
        api_modeled_methods.addMethod(sm);
    }

    /** 
     * Add the given method to the list of spec methods.
     */
    public void addBanMethod(SootMethod sm) {
        all_sys_methods.addMethod(sm);
        banned_methods.addMethod(sm);
        api_modeled_methods.addMethod(sm);
    }

    /**
     * Create the system method txt file with the signature and modifiers for all 
     * system methods.  Should not be called on a normal run.
     */
    private void createAllSystemMethodsFile() {
        try {
            JarFile androidJar = new JarFile(new File(Config.v().ANDROID_LIB_DIR, Config.ANDROID_JAR));
            Set<SootClass> systemClasses = SootUtils.loadClassesFromJar(androidJar, false, new HashSet<String>());

            FileWriter fw = new FileWriter(new File(Config.v().getApacHome(), Config.SYSTEM_METHODS_FILE));

            for (SootClass clz : systemClasses) {
                for (SootMethod meth : clz.getMethods()) {
                    fw.write(String.format("%s#%s\n", meth.getModifiers(), meth.getSignature()));
                }
            }

            fw.close();
        } catch (Exception e) {
            logger.error("Error creating android api methods file {}", e);
        }
        droidsafe.main.Main.exit(1);
    }

    /** 
     * Read in all method from all_system_methods, then create a SootMethod for missing api
     * methods from modeled classes.
     */
    private void checkForUnmodeledMissingAPIMethods() {
        try {
            File sys_calls_file= new File(Config.v().getApacHome(), Config.SYSTEM_METHODS_FILE);
            LineNumberReader br = new LineNumberReader (new FileReader (sys_calls_file));
            String line;
            int lineNum;
            while ((line = br.readLine()) != null) {
                lineNum = br.getLineNumber();

                String[] lineSplit = line.trim().split("#");

                int modifiers = Integer.parseInt(lineSplit[0]);
                String methodSig = lineSplit[1];

                try {
                    SootClass clz = Scene.v().getSootClass(SootUtils.grabClass(methodSig));
                    if (clz == null) {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    logger.warn("Android class not modeled: {} (Might be ok because of modeling simplification).", 
                        SootUtils.grabClass(methodSig));
                }

                if (!Scene.v().containsMethod(methodSig)) {
                    logger.info("Android method not modeled: {} (Might be ok because of modeling simplification).",  
                        methodSig);
                }

            }

        } catch (Exception e) {
            logger.error("Error reading android api methods file: {}", e);
            droidsafe.main.Main.exit(1);
        }
    }

    private Classification getModeledClassification(SootMethod method, List<Tag> tags) {
        Classification c;
        for (Tag tag : tags) {
            if (tag instanceof VisibilityAnnotationTag) {
                VisibilityAnnotationTag vat = (VisibilityAnnotationTag)tag;
                for (AnnotationTag at : vat.getAnnotations()) {
                    if (at.getType().contains("droidsafe/annotations/DSSafe")) {
                        c = Classification.SAFE;
                    } else if (at.getType().contains("droidsafe/annotations/DSSpec")) {
                        c = Classification.SPEC;
                    } else if (at.getType().contains("droidsafe/annotations/DSBan")) {
                        c = Classification.BAN;  
                    } else {
                        c = Classification.NONE;
                    }

                    if (c != Classification.NONE && at.getElems().size() > 0) {
                        String category = ((AnnotationEnumElem)at.getElemAt(0)).getConstantName();
                        logger.info("Adding classification category for {}: {}", method, category);
                        classificationCat.put(method, category);
                    } 

                    return c;
                }
            }
        }

        return Classification.NONE;
    }


    /**
     * Based on the annotation we are adding to api modeled methods from modeled classes,
     * add modeled methods to the soot method list for them.
     * 
     * Also, read the classification and put methods into appropriate sets (ban, spec, safe)
     */
    private void findModeledMethods() {
        markClinitsAsModeled();
        for (SootMethod method : all_sys_methods) {

            //try to get the active method body for any modeled method and make sure it exists
            if (method.isConcrete()) {
                method.retrieveActiveBody();
                if (!method.hasActiveBody()) {
                    logger.error("Modeled api method has no active body: {}", method);
                    droidsafe.main.Main.exit(1);
                }
            }

            Classification c = Classification.NONE;
            boolean verified = false;
            boolean sink = false;
            boolean source = false;
            String category = "";
            for (Tag tag : method.getTags()) {
                if (tag instanceof VisibilityAnnotationTag) {

                    VisibilityAnnotationTag vat = (VisibilityAnnotationTag)tag;
                    for (AnnotationTag at : vat.getAnnotations()) {
                        if (at.getType().contains("droidsafe/annotations/DSSafe")) {
                            c = Classification.SAFE;
                            category = getCategoryFromClassificationTag(at);
                            addSafeMethod(method);
                            logger.info("Found method with SAFE classification: {}", method);
                        } else if (at.getType().contains("droidsafe/annotations/DSSpec")) {
                            addSpecMethod(method);
                            category = getCategoryFromClassificationTag(at);
                            c = Classification.SPEC;
                            logger.info("Found method with SPEC classification: {}", method);
                        } else if (at.getType().contains("droidsafe/annotations/DSBan")) {
                            c = Classification.BAN; 
                            category = getCategoryFromClassificationTag(at);
                            addBanMethod(method);
                            logger.info("Found method with BAN classification: {}", method);
                        } else if (at.getType().contains("droidsafe/annotations/DSVerified")) {
                            verified = true;
                        } else if (at.getType().contains("droidsafe/annotations/DSSink")) {
                            logger.info("Found sink method: {}", method);
                            addSinkSourceTag(method, at, sinksMapping);
                            sink = true;
                        } else if (at.getType().contains("droidsafe/annotations/DSSource")) {
                            logger.info("Found source method: {}", method); 
                            addSinkSourceTag(method, at, srcsMapping);
                            source = true; 
                        }
                    }
                }
            }

            if (c != Classification.NONE && !category.isEmpty()) {
                logger.info("Adding classification category for {}: {}", method, category);
                classificationCat.put(method, category);
            } 

            if (c == Classification.NONE) {
                banned_methods.addMethod(method);
                logger.info("Found method with no classification: {}", method);
            }

            if (verified) {
                logger.info("Found verified method: {}", method);
                api_modeled_methods.addMethod(method);
                verified_methods.addMethod(method);
            }
        }
    }
    
    /**
     * Add infokind taint to the return value of the method.
     */
    public void addSourceInfoKind(SootMethod sootMethod, String kind) {
        if (!srcsMapping.containsKey(sootMethod)) {
            srcsMapping.put(sootMethod, new HashSet<InfoKind>());
        }
        srcsMapping.get(sootMethod).add(InfoKind.getInfoKind(kind));
    }

    private void addSinkSourceTag(SootMethod sootMethod, AnnotationTag at, Map<SootMethod, Set<InfoKind>> mapping) {
        if (!(at.getElemAt(0) instanceof AnnotationArrayElem)) {
            logger.error("DSSink/DSSource Annotation incorrect for: {} is {}", sootMethod, at.getElemAt(0).getClass());
            droidsafe.main.Main.exit(1);
        }
        
        for (AnnotationElem ae : ((AnnotationArrayElem)at.getElemAt(0)).getValues()) {
            if (!(ae instanceof AnnotationEnumElem)) {
                logger.error("DSSink/DSSource Annotation Element incorrect for: {} is {}", sootMethod, ae.getClass());
                droidsafe.main.Main.exit(1);
            }
            
            String infoKind = ((AnnotationEnumElem)ae).getConstantName();
            
            if (!mapping.containsKey(sootMethod)) {
                mapping.put(sootMethod, new HashSet<InfoKind>());
            }
            mapping.get(sootMethod).add(InfoKind.getInfoKind(infoKind));
            logger.info("Adding sink/source infokind category for {} as {}", sootMethod, infoKind);
        }
            
            
    }
    
    private String getCategoryFromClassificationTag(AnnotationTag at) {
        if (at.getElems().size() > 0)
            return ((AnnotationEnumElem)at.getElemAt(0)).getConstantName();
        return "";
    }

    /**
     * Add all clinits in the api as safe methods to call.
     */
    private void markClinitsAsModeled() {
        for (SootClass clz : allSystemClasses) {
            if (clz.declaresMethod("void <clinit>()")) {
                SootMethod clinit = clz.getMethod("void <clinit>()");
                //System.out.printf("** Found modeled clinit: %s\n", clinit);
                api_modeled_methods.addMethod(clinit);
                safe_methods.addMethod(clinit);
            }
        }
    }

    private void loadDroidSafeCalls() {
        try {
            //load the classes from the droidcalls library
            File dsLib = new File(Config.v().getApacHome(), 
                    "android-lib/droidcalls.jar");
            JarFile dsJar = new JarFile(dsLib);
            SootUtils.loadClassesFromJar(dsJar, true, new LinkedHashSet<String>());
            all_sys_methods.addAllMethods(dsJar);			
        } catch (Exception e) {
            logger.error("Error loading droidsafe call jar (maybe it does not exist).");
            droidsafe.main.Main.exit(1);
        }
    }

    //old load classification code from config_files/system_calls.txt
    //now we classify based on the annotation DSModeled
    private void loadClassification()	{
        // Read in the system call descriptors.  The file format has lines
        // of the form <type>[|flags] <descr>.  More detail is in the
        // comments at the top of the file.  Descriptors are matched on
        // the string representation.  The canonical form is <class>:
        // <return_type> <method>(args) Arbitrary white space is supported
        // in the file, the code below reduces all white space to a single
        // space and removes spaces between arguments
        File sys_calls_file = null;
        String errors = "";
        int line_num = 0;
        try {
            sys_calls_file= new File(Config.v().getApacHome(), 
                    "config-files/system_calls.txt");
            LineNumberReader br 
            = new LineNumberReader (new FileReader (sys_calls_file));
            String line = null;
            while ((line = br.readLine()) != null) {
                line_num = br.getLineNumber();
                line = line.trim();
                line = line.replaceFirst (" *[#].*$", "");
                if (line.isEmpty())
                    continue;
                String[] sa = line.split ("[\\s]+", 2);
                String[] labels = sa[0].split ("[|]");
                String call_typ = labels[0];
                for (int ii = 1; ii  < labels.length; ii++)
                    if (!labels[ii].equals ("model"))
                        errors += "unexpected flag " + labels[ii] + "\n";

                String method_descr = sa[1];
                method_descr = method_descr.replaceAll (", *", ",");
                method_descr = method_descr.replaceAll ("[\\s]+", " ");
                method_descr = "<" + method_descr + ">";
                // System.out.printf ("Adding sys %s: '%s'\n", call_typ, method_descr);
                if (!all_sys_methods.contains (method_descr))
                    errors += String.format ("invalid method signature '%s'\n",
                        method_descr);
                if (safe_methods.contains (method_descr) 
                        || spec_methods.contains (method_descr)
                        || banned_methods.contains (method_descr))
                    errors += String.format ("dup method signature '%s'\n", 
                        method_descr);
                if (call_typ.equals ("safe")) {
                    safe_methods.addMethod (method_descr);
                } else if (call_typ.equals ("spec"))
                    spec_methods.addMethod (method_descr);
                else if (call_typ.equals ("ban")) {
                    banned_methods.addMethod(method_descr);
                } else {
                    errors += String.format ("unexpected call type '%s'\n", 
                        call_typ); 
                }
            }
        } catch (Exception e) {
            throw new RuntimeException ("error reading " + sys_calls_file 
                + "at line " + line_num, e);
        }
        if (errors != "")
            throw new RuntimeException 
            (String.format ("Errors in %s: \n%s", sys_calls_file, errors));
        if ("Y".equals(System.getProperty("droidsafe.print_unclassified")))
            dumpUnclassifiedMethodsToFile();
    }

    /** 
     * Returns whether or not a method should be included in the spec.
     * It returns true for any method in
     * a system class (any class in Android.jar) that is not explicitly marked
     * as safe in system_calls.txt (see safe_methods)
     */
    public boolean isInterestingMethod(SootMethod method) {
        if (all_sys_methods.contains(method) && !safe_methods.contains (method)) {
            return true;
        }

        return false;
    }


    public String api_xref (String method_sig, String txt) {
        String sig = method_sig.replace ("<", "");
        sig = sig.replace (">", "");
        String[] sa = sig.split (":* ");
        String class_name = sa[0].replace (".", "/");
        String ret_type = sa[1];
        String method = sa[2].replaceAll (", *", ", ");
        return String.format 
                ("<a href=\"http://developer.android.com/reference/%s.html#%s\">%s</a>", 
                    class_name, method, txt);
    }

    public void dumpUnclassifiedMethodsToFile() {
        try {
            File unclassified = new File(Config.v().getApacHome(), 
                    "config-files/sys_methods_to_classify.txt");
            FileWriter fstream = new FileWriter(unclassified);
            BufferedWriter out = new BufferedWriter(fstream);

            for (SootMethod sm : all_sys_methods) {
                String m = sm.getSignature();

                if (!(spec_methods.contains(m) || banned_methods.contains(m) || safe_methods.contains(m)))
                    out.write(m.substring(1, m.length() - 1) + "\n");
            }
            out.close();
        } catch (Exception e) {
            logger.error("Error writing unclassified methods file", e);
            droidsafe.main.Main.exit(1);
        }

    }

    /** 
     * Used by the specification create to check if a method is legal to put in the 
     * spec.  Must check the method, and all superclass definitions of the method.
     * 
     * @param sig
     * @return
     */
    public boolean isBannedMethod(String sig) {
        return banned_methods.contains(sig);
    }

    /** 
     * Used by the specification create to check if a method is legal to put in the 
     * spec.  Must check the method, and all superclass definitions of the method.
     * 
     * @param sig
     * @return
     */
    public boolean isBannedMethod(SootMethod m) {
        return banned_methods.contains(m);
    }


    /** 
     * Check if a method is safe.  meaning it should not appear in the specification.
     */
    public boolean isSafeMethod(SootMethod m) {
        return safe_methods.contains(m);
    }

    /** 
     * Check if a method is spec.  meaning it is support and should appear in the spec.
     */
    public boolean isSpecMethod(SootMethod m) {
        return spec_methods.contains(m);
    }

    /**
     * Return true if this is a system method define in anrdoid.jar.
     */
    public boolean isSystemMethod(String sig) {
        return all_sys_methods.contains(sig);
    }

    /**
     * Return true if this is a system method define in anrdoid.jar.
     */
    public boolean isSystemMethod(SootMethod m) {
        return all_sys_methods.contains(m);
    }

    /**
     * Given a signature for a method, find the system method that would 
     * be called given the types of the receiver and params of the signature.
     */
    public SootMethod findSupportedMethod(String sig) {
        return all_sys_methods.getMethod(sig);
    }

    /**
     * Return true if this method is contained in the list of safe or spec methods.
     * Return false if a banned method or if a user method.
     * This method will perform a polymorphic search. 
     */
    public boolean isSupportedMethod(SootMethod method) {
        if (safe_methods.contains(method) || spec_methods.contains(method))
            return true;

        //if we get here, we might have a call that either overrides an 
        //api call or has args that implement superclass or interface
        //so do a smarter search
        if (spec_methods.containsPoly(method))
            return true;

        return safe_methods.containsPoly(method);
    }

    /**
     * @return True if this class is a droidsafe library class.
     */
    public boolean isDroidSafeLibraryClass(String name) {
        return droidSafeLibraryClasses.contains(name);
    }

    /**
     * Return true if this class is a system class defined in android.jar.
     */
    public boolean isSystemClass(SootClass clz) {
        return allSystemClasses.contains(clz);
    }

    public boolean isSystemClassReference(Type t) {
        if (t instanceof RefType) 
            return isSystemClass(((RefType)t).getSootClass());
        else if (t instanceof ArrayType) 
            return isSystemClassReference(((ArrayType)t).getElementType());
        else 
            return false;
    }

    /**
     * Given a method in a non-system class, return the closest api method that the method 
     * overrides.  Return null if the method does not override a system method.  Search 
     * class inheritance for parents before interfaces.
     */
    public SootMethod getClosestOverridenAPIMethod(SootMethod method) {
        if (this.isSystemClass(method.getDeclaringClass())) {
            logger.error("Calling getClosestOverridenAPIMethod() on API method: {}", method);
            droidsafe.main.Main.exit(1);
        }
        return all_sys_methods.getClosestOverriddenMethod(method);
    }

    /**
     * Return true if this method has the DSVerified annotation.  (don't search parents)
     */
    public boolean isDSVerifiedMethod(SootMethod m) {
        return verified_methods.contains(m);
    }
    
    /**
     * Return true if the argument is a modeled method from the api.
     */
    public boolean isAPIModeledMethod(SootMethod m) {
        return api_modeled_methods.contains(m);
    }

    public SootMethodList getAllSystemMethods() {
        return all_sys_methods;
    }

    /**
     * Return turn if the method is a source method that has a high level information kind defined.
     */
    public boolean hasSourceInfoKind(SootMethod method) {
        if (srcsMapping.containsKey(method)) 
            return true;
        
        //check for all overriden methods because of possible cloning
        if (API.v().isSystemMethod(method)) {
            for (SootMethod parent : 
                SootUtils.getOverriddenMethodsFromSuperclasses(method)) {
                if (srcsMapping.containsKey(parent))
                    return true;
            }
        }
        
        return false;
    }
    
    /**
     * Return the high level information kinds defined for this source method.  Search all parent overriden methods
     * as well for info kind.
     */
    public Set<InfoKind> getSourceInfoKinds(SootMethod method) {
        if (srcsMapping.containsKey(method))
            return srcsMapping.get(method);
        
        Set<InfoKind> kinds = new HashSet<InfoKind>();
        
        if (API.v().isSystemMethod(method)) {
            for (SootMethod parent : 
                SootUtils.getOverriddenMethodsFromSuperclasses(method)) {
                Set<InfoKind> parentMappings = srcsMapping.get(parent);
                if (parentMappings != null)
                    kinds.addAll(parentMappings);
            }
        }
        
        return kinds;
    }
    
    /**
     * Return turn if the method is a sink method that has a high level information kind defined.
     * Search all parent overriden methods as well for info kind.
     */
    public boolean hasSinkInfoKind(SootMethod method) {
        if (sinksMapping.containsKey(method)) 
            return true;
        
        //check for all overriden methods because of possible cloning
        if (API.v().isSystemMethod(method)) {
            for (SootMethod parent : 
                SootUtils.getOverriddenMethodsFromSuperclasses(method)) {
                if (sinksMapping.containsKey(parent))
                    return true;
            }
        }
        
        return false;
    }
    
    /**
     * Return the high level information kinds defined for this sink method. Search all parent overriden methods
     * as well for info kind.
     */
    public Set<InfoKind> getSinkInfoKinds(SootMethod method) {
        if (sinksMapping.containsKey(method))
            return sinksMapping.get(method);
        
        Set<InfoKind> kinds = new HashSet<InfoKind>();
        
        if (API.v().isSystemMethod(method)) {
            for (SootMethod parent : 
                SootUtils.getOverriddenMethodsFromSuperclasses(method)) {
                Set<InfoKind> parentMapping = sinksMapping.get(parent);
                if (parentMapping != null)
                    kinds.addAll(parentMapping);
            }
        }
        
        return kinds;
    }


    public enum Classification {
        SAFE, SPEC, BAN, NONE;
    }
}
