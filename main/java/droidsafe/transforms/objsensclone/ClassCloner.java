package droidsafe.transforms.objsensclone;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.strings.JSAStrings;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.main.Config;
import droidsafe.speclang.Method;
import droidsafe.utils.SootMethodList;
import droidsafe.utils.SootUtils;
import soot.Body;
import soot.Modifier;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootFieldRef;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;
import soot.Value;
import soot.ValueBox;
import soot.jimple.FieldRef;
import soot.jimple.InvokeExpr;
import soot.jimple.NewExpr;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.options.Options;
import soot.util.Chain;

/**
 * This transformation will create a clone of a given class that is appropriate for separating the cloned
 * class from the parent in the points to analysis, such that we can introduce Object Sensitivity.
 * 
 * In the original class, all private fields are made protected, so that code in the clone can access them.
 * 
 * The clone that is created does not include fields from the ancestor classes.
 * 
 * All non-static methods from the original class plus its ancestors are added to the clone by using the
 * CloneInheritedMethods transformation (they are added in a way such that method inheritance is correctly 
 * observed from the original hierarchy).  
 * 
 * @author mgordon
 *
 */
public class ClassCloner {
    /** static logger class */
    private static final Logger logger = LoggerFactory.getLogger(ClassCloner.class);
    /** original soot class which we are cloning */
    private SootClass original;
    /** the clone we have created */
    private SootClass clone;
    /** unique ID used for introduced fields */
    private static int uniqueID = 0;
    /** appended to name cloned classes */
    public static final String CLONE_POSTFIX = "_ds_clone_";
    /** transform to clone inherited methods and remove dynamic dispatch */
    private CloneInheritedMethods cim;
    /** if true, clone all methods, otherwise clone only reachable methods */
    private boolean cloneAllMethods;
    
    /**
     * Private constructor for a specific class cloner.
     */
    private ClassCloner(SootClass org, boolean allMethods) {
        this.original = org;
        cloneAllMethods = allMethods;
    }

    /**
     * Return the cloned class.
     */
    public SootClass getClonedClass() {
        return clone;
    }


    /**
     * Return set of cloned methods that are reachable based on whether the original method 
     * that was clone was reachable based on the current pta result.
     * @return
     */
    public Set<SootMethod> getReachableClonedMethods() {
        return cim.getReachableClonedMethods();
    }

    public Map<SootMethod,SootMethod> getCloneToOriginalMap() {
        return cim.getCloneToOriginalMap();
    }

    /** 
     * Static call to clone a particular class, and return the clone. 
     * 
     * If isAPIClass is true, then treat the cloned class as an api class and add it to the list of api classes, and
     * set its methods as safe,spec,ban based on ancestors.
     * 
     * if allMethods is true, then clone all methods from ancestor classes, otherwise if false, clone only reachables
     */
    public static ClassCloner cloneClassAndInheritedMethods(SootClass original, boolean allMethods) {
        ClassCloner c = new ClassCloner(original, allMethods);
        c.cloneClassCloneMethodsAndInstallClass();
        return c;
    }

    public static ClassCloner cloneClass(SootClass original) {
        ClassCloner c = new ClassCloner(original, false);
        c.cloneAndInstallClass();
        return c;
    }

    private void cloneAndInstallClass() {
        clone = new SootClass(original.getName() + CLONE_POSTFIX + uniqueID, 
            original.getModifiers());
        uniqueID++;

        //System.out.printf("Cloning class %s with %s.\n", original, clone);

        //set parent
        if (original.isFinal()) {
            //change final modifier
            logger.info("Changing final modifier on {}", original);
            original.setModifiers(original.getModifiers() ^ Modifier.FINAL);
        }
        clone.setSuperclass(original);
        
        //install the class
        Scene.v().addClass(clone);
        Scene.v().loadClass(clone.getName(), SootClass.BODIES);
        clone.setApplicationClass();  

        API.v().cloneClassClassifications(original, clone);
    }
    
    /**
     * Perform the work of actually clone class, changing fields and cloning methods.
     */
    private void cloneClassCloneMethodsAndInstallClass() {
        cloneAndInstallClass();

        //remove inheritance by cloning
        cim = new CloneInheritedMethods(clone, cloneAllMethods);
        cim.transform();

      
        //for all new expressions in the cloned methods of the clone,
        //replace self creations with creations of clone
        RefType originalType = RefType.v(original);
        RefType cloneType = RefType.v(clone);
        for (SootMethod method : clone.getMethods()) {        
            StmtBody stmtBody = (StmtBody)method.retrieveActiveBody();
            for (ValueBox vb : stmtBody.getUseAndDefBoxes()) {
                if (vb.getValue() instanceof NewExpr &&
                        ((NewExpr)vb.getValue()).getBaseType().equals(originalType)) {
                    NewExpr newE = (NewExpr)vb.getValue();
                    newE.setBaseType(cloneType);
                }
            }
        }

    }

    public static boolean isClonedClass(SootClass clz) {
        return clz.getName().contains(CLONE_POSTFIX);
    }

    public static String removeClassCloneSuffix(String str) {
        String regex = CLONE_POSTFIX+"[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.replaceAll("");
    }

    public static SootClass getClonedClassFromClone(SootClass clone) {
        return Scene.v().getSootClass(ClassCloner.removeClassCloneSuffix(clone.getName()));
    }
}
