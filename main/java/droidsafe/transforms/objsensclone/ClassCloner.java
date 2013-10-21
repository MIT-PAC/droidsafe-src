package droidsafe.transforms.objsensclone;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.system.API;
import droidsafe.speclang.Method;
import droidsafe.utils.SootMethodList;
import droidsafe.utils.SootUtils;
import soot.Body;
import soot.Modifier;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootFieldRef;
import soot.SootMethod;
import soot.Type;
import soot.jimple.FieldRef;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.util.Chain;

/**
 * This transformation will create a clone of a given class that is appropriate for separating the cloned
 * class from the parent in the points to analysis, such that we can introduce Object Sensitivity for a subset of 
 * classes.
 * 
 * The clone that is created includes all fields from all parents of the original class.  The fields are renamed, and 
 * field refs in the cloned methods are updated appropriately.  
 * 
 * In the original class, all private static fields are made protected, so that code in the clone can access them.
 * 
 * All methods from the original class plus its ancestors are added to the clone (they are added in a way such that 
 * method inheritance is correctly observed from the original hierarchy).  
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
    /** a list of ancestor of the original class, plus the original class */
    private Set<SootClass> ancestorsOfIncluding;
    /** should we treat the new cloned class as an api class */
    private boolean isAPI;
    /** methods of the new cloned class */
    private SootMethodList methods;
    /** unique ID used for introduced fields */
    public static int uniqueID = 0;
    /** appended to name cloned classes */
    public static final String CLONE_POSTFIX = "_ds_clone_";
    /** appended to name of cloned fields */
    public static final String CLONED_FIELD_POSTFIX = "_ds_clone_field";
    
    private ClassCloner(SootClass org, boolean isSystem) {
        this.original = org;
        this.isAPI = isSystem;
        methods = new SootMethodList();
        ancestorsOfIncluding = new HashSet<SootClass>();
    }

    public static SootClass cloneClass(SootClass original, boolean isAPIClass) {
        ClassCloner cloner = new ClassCloner(original, isAPIClass);
        cloner.cloneAndInstallClass();
        return cloner.clone;
    }
    
    private void cloneAndInstallClass() {
        clone = new SootClass(original.getName() + CLONE_POSTFIX + uniqueID, 
            original.getModifiers());
        uniqueID++;
        
        //set parent
        if (original.isFinal()) {
            //change final modifier
            logger.error("Trying to clone final class!");
            droidsafe.main.Main.exit(1);
        }
        clone.setSuperclass(original);
        
        //create the class fields
        SootClass ancestor = original;
        while (!"java.lang.Object".equals(ancestor.getName())) {
            incorporateAncestorFields(ancestor);
            ancestorsOfIncluding.add(ancestor);
            ancestor = ancestor.getSuperclass();
        }
        
        //create the class methods
        ancestor = original;
        while (!"java.lang.Object".equals(ancestor.getName())) {
            incorporateAncestorMethods(ancestor);
            ancestor = ancestor.getSuperclass();
        }
        
        
        //install the class
        Scene.v().addClass(clone);
        Scene.v().loadClass(clone.getName(), SootClass.BODIES);
        clone.setApplicationClass();  
        if (isAPI) {
            API.v().addSystemClass(clone);
        }
    }

    private boolean containsMethod(String signature) {
        //check this class for the method with polymorpism
        String mName = SootUtils.grabName(signature);
        String[] args = SootUtils.grabArgs(signature);
        String rtype = SootUtils.grabReturnType(signature);

        for (SootMethod curr : methods) {
            if (!curr.getName().equals(mName) || curr.getParameterCount() != args.length)
                continue;

            //check the return types
            Type returnType = SootUtils.toSootType(rtype);
            if (!SootUtils.isSubTypeOfIncluding(returnType, curr.getReturnType())) 
                continue;

            boolean foundIncompArg = false;            
            for (int i = 0; i < args.length; i++) {
                if (!SootUtils.isSubTypeOfIncluding(SootUtils.toSootType(args[i]), curr.getParameterType(i))) {
                    foundIncompArg = true;
                    continue;
                }
            }
            
            //at least one parameter does not match!
            if (foundIncompArg)
                continue;

            //if we got here all is well and we found a method that matches!
            return true;
        }

        //didn't find it
        return false;
    }
    
    private void incorporateAncestorFields(SootClass ancestor) {  
        for (SootField ancestorField : ancestor.getFields()) {
            //make all static field protected
            if (ancestorField.isStatic()) {
                if (ancestorField.isPrivate()) {
                    //turn on protected
                    ancestorField.setModifiers(ancestorField.getModifiers() | Modifier.PROTECTED);
                    //turn off private
                    ancestorField.setModifiers(ancestorField.getModifiers() ^ Modifier.PRIVATE);
                }
            } else {
              //clone all instance fields
               SootField newField = new SootField(
                   ancestorField.getName() + "_" +  ancestor.getName() + CLONED_FIELD_POSTFIX,
                   ancestorField.getType(), ancestorField.getModifiers());
               newField.addAllTagsOf(ancestorField);
               clone.addField(newField);
            }
            
        }
    }
    
    private void incorporateAncestorMethods(SootClass ancestor) {
            
        //create all methods, cloning body, replacing instance field refs
        for (SootMethod ancestorM : ancestor.getMethods()) {
            //check if this method already exists
            if (containsMethod(ancestorM.getSignature())) {
                //System.out.printf("\tAlready contains method %s\n.", ancestorM);
                continue;
            }
            
            SootMethod newMeth = new SootMethod(ancestorM.getName(), ancestorM.getParameterTypes(),
                ancestorM.getReturnType(), ancestorM.getModifiers(), ancestorM.getExceptions());
            
            
            //System.out.printf("\tAdding method %s\n.", ancestorM);
            //register method
            methods.addMethod(newMeth);
            clone.addMethod(newMeth);
            if (isAPI) {
                if (API.v().isBannedMethod(ancestorM.getSignature())) 
                    API.v().addBanMethod(newMeth);
                else if (API.v().isSpecMethod(newMeth)) 
                    API.v().addSpecMethod(newMeth);
                else if (API.v().isSafeMethod(newMeth)) 
                    API.v().addSafeMethod(newMeth);
                
            }
            
            //clone body
            Body newBody = (Body)ancestorM.getActiveBody().clone();
            newMeth.setActiveBody(newBody);
            
            //go through original body and remember field references, so we can create correct ones later...
            Map<Integer, SootField> origStmtFieldMap = new HashMap<Integer,SootField>();
            
            Iterator origStmts = ancestorM.getActiveBody().getUnits().iterator();
            int i = -1;
            while (origStmts.hasNext()) {
                i++;
                Stmt stmt = (Stmt)origStmts.next();
                
                if (stmt.containsFieldRef()) {
                    FieldRef fieldRef = stmt.getFieldRef();
                    SootFieldRef sootFieldRef = fieldRef.getFieldRef();
                    SootField sootField = sootFieldRef.resolve();
                    
                    if (sootField.isStatic())
                        continue;
                    
                    origStmtFieldMap.put(i, sootField);
                }
                
                
            }
            
            //change all field references
            
            StmtBody stmtBody = (StmtBody)newBody;
            Chain units = stmtBody.getUnits();
            Iterator stmtIt = units.snapshotIterator();

            i = -1;
            while (stmtIt.hasNext()) {
                i++;
                Stmt stmt = (Stmt)stmtIt.next();
                
                if (stmt.containsFieldRef()) {
                    FieldRef fieldRef = stmt.getFieldRef();
                    SootFieldRef oldSootFieldRef = fieldRef.getFieldRef();
                   
                    //don't do anything if the field is of class that is not the original or is cloned
                    //this is before the field ref is resolved, so it shows that the possible field is not
                    //in the tree
                    if (fieldRef.getField().isStatic() || 
                            !ancestorsOfIncluding.contains(fieldRef.getField().getDeclaringClass()))
                        continue;  
                    
                    if (!origStmtFieldMap.containsKey(i)) {
                        logger.error("Some problem with consistency between orignal and cloned method: {} {}", stmt, 
                            newMeth);
                        droidsafe.main.Main.exit(1);
                    }
                    
                    SootField origField = origStmtFieldMap.get(i);
                    
                    //don't do anything if the resolved field is of class that is not the original or is cloned
                    if (!ancestorsOfIncluding.contains(origField.getDeclaringClass()))
                        continue;   
                    
                    //don't do anything for static fields or if the field was of Object
                    if ("java.lang.Object".equals(origField.getDeclaringClass().getName()))
                        continue;
                    
                    String newFieldName = oldSootFieldRef.name() + "_" + origField.getDeclaringClass() + 
                            CLONED_FIELD_POSTFIX;
                    
                    if (!clone.declaresField(newFieldName, oldSootFieldRef.type())) {
                        logger.error("Cannot find field {} in clone of {}. Originally in {}", 
                            newFieldName,
                            ancestor, origField.getDeclaringClass());
                    }
                    
                    SootFieldRef newSootFieldRef = 
                            Scene.v().makeFieldRef(clone, 
                                newFieldName, 
                                oldSootFieldRef.type(), 
                                false);
                    
                    
                    
                    fieldRef.setFieldRef(newSootFieldRef);
                }
            }
        }
    }
}
