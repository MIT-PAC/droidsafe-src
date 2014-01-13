package droidsafe.transforms.objsensclone;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.HashBiMap;

import soot.Body;
import soot.Hierarchy;
import soot.Modifier;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;
import soot.ValueBox;
import soot.jimple.InvokeExpr;
import soot.jimple.NewExpr;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.util.Chain;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.strings.JSAStrings;
import droidsafe.android.system.API;
import droidsafe.main.Config;
import droidsafe.utils.SootMethodList;
import droidsafe.utils.SootUtils;

/**
 * This transformation pulls all inherited methods into a class by cloning them and fixing up th
 * cloned code.  It essentially introduces a limited form of object sensitivity on the cloned methods
 * in the class because there are now distinct versions of the parent methods for each inherited class.
 * 
 * It is careful about respecting proper inheritance and remaining sound (one hopes).
 * 
 * @author mgordon
 *
 */
public class CloneInheritedMethods {
    /** logger object */
    private static final Logger logger = LoggerFactory.getLogger(CloneInheritedMethods.class);
    /** methods of the new cloned class */
    private SootMethodList methods;
    /** map of cloned method to the original method */
    private HashBiMap<SootMethod,SootMethod> clonedToOriginal; 
    /** class on which we are working */
    private SootClass clazz;
    /** suffix to add to cloned methods that were hidden by inheritance but are reachable by invoke special */
    private static final String CLONED_HIDDEN_METHOD_SUFFIX = "_ds_hidden_clone_";
    /** id to add to cloned methods that were hidden by inheritance but are reachable by invoke special */
    private static int cloned_method_id = 0;

    public CloneInheritedMethods(SootClass clz) {
        clazz = clz;
        methods = new SootMethodList();
        
        clonedToOriginal = HashBiMap.create();
        
        //add methods already in the clz
        for (SootMethod method : clazz.getMethods())
            methods.addMethod(method);
    }

    public void transform() {
        if (clazz.isPhantom())
            return;

        //build ancestor
        List<SootClass> ancestors = Scene.v().getActiveHierarchy().getSuperclassesOf(clazz);

        for (SootClass ancestor : ancestors) {
            if (ancestor.isPhantom())
                continue;

            cloneReachableNonHiddenAncestorMethods(ancestor);
        }

        //modify ancestors fields
        for (SootClass ancestor : ancestors) {
            if (ancestor.isPhantom())
                continue;

            makeAncestorFieldsVisible(ancestor);
        }

        cloneHiddenAncestorMethodsAndFixInvokeSpecial();
    }

    /**
     * Change private to protected for ancestor fields.
     */
    private void makeAncestorFieldsVisible(SootClass ancestor) {  
        for (SootField ancestorField : ancestor.getFields()) {
            if (ancestorField.isPrivate()) {
                //turn on protected
                ancestorField.setModifiers(ancestorField.getModifiers() | Modifier.PROTECTED);
                //turn off private
                ancestorField.setModifiers(ancestorField.getModifiers() ^ Modifier.PRIVATE);
            }

            //turn off final for ancestor methods
            if (ancestorField.isFinal())
                ancestorField.setModifiers(ancestorField.getModifiers() ^ Modifier.FINAL);
        }
    }

    /**
     * Return set of cloned methods that are reachable based on whether the original method 
     * that was clone was reachable based on the current pta result.
     * @return
     */
    public Set<SootMethod> getReachableClonedMethods() {
        return clonedToOriginal.keySet();
    }


    public Map<SootMethod,SootMethod> getCloneToOriginalMap() {
        return clonedToOriginal;
    }

    /**
     * Clone non-static ancestor methods that are not hidden by virtual dispatch and that are reachable
     * based on a pta run.
     */
    private void cloneReachableNonHiddenAncestorMethods(SootClass ancestor) {
        if (ClassCloner.isClonedClass(ancestor)) {
            logger.error("Cloning method from clone: {}", ancestor);
            droidsafe.main.Main.exit(1);
        }

        //create all methods, cloning body, replacing instance field refs
        for (SootMethod ancestorM : ancestor.getMethods()) {
            if (ancestorM.isAbstract() || ancestorM.isPhantom() || !ancestorM.isConcrete() || 
                    SootUtils.isRuntimeStubMethod(ancestorM))
                continue;

            //never clone static methods
            if (ancestorM.isStatic())
                continue;

            //clone only reachable methods
            if (!PTABridge.v().getAllReachableMethods().contains(ancestorM))
                continue;

            //check if this method already exists
            if (containsMethod(ancestorM.getSignature())) {
                //System.out.printf("\tAlready contains method %s.\n", ancestorM);
                continue;
            }

            //turn off final for ancestor methods
            if (ancestorM.isFinal())
                ancestorM.setModifiers(ancestorM.getModifiers() ^ Modifier.FINAL);

            cloneMethod(ancestorM, ancestorM.getName());
        }
    }

    /**
     * Make sure that all invoke special targets are cloned into the class from ancestors.
     * This might mean that we have to clone hidden methods, and change their names.
     * So clone them in, and update the clone to original map, and update the invoke special
     * Also, this will update invoke specials that target methods cloned in previous call 
     * to above cloneReachableNonHiddenAncestorMethods()
     */
    private void cloneHiddenAncestorMethodsAndFixInvokeSpecial() {
        Set<SootClass> parents = SootUtils.getParents(clazz);
        
        boolean debug = false;//(clazz.getName().contains("ResultDisplayer"));
        
        boolean cloneAdded = false;
        do {
            cloneAdded = false;
            for (SootMethod method : clazz.getMethods()) {

                if (method.isAbstract() || method.isPhantom() || !method.isConcrete())
                    continue;

                if (debug) System.out.println(method);
                
                Body body = method.retrieveActiveBody();
                StmtBody stmtBody = (StmtBody)body;

                Chain units = stmtBody.getUnits();
                Iterator stmtIt = units.iterator();

                while (stmtIt.hasNext()) {
                    Stmt stmt = (Stmt)stmtIt.next();

                    if (stmt.containsInvokeExpr() && stmt.getInvokeExpr() instanceof SpecialInvokeExpr) {
                        SpecialInvokeExpr si = (SpecialInvokeExpr) stmt.getInvokeExpr();

                        SootMethod target = resolveSpecialInvokeTarget(si); //si.getMethod();

                        if (debug) System.out.printf("\t%s %s", si, target);
                        
                        if (clonedToOriginal.values().contains(target)) {
                            //found target of invoke special, and it has been cloned, so change the invoke special
                            SootMethod cloneOfTarget = clonedToOriginal.inverse().get(target);
                            si.setMethodRef(cloneOfTarget.makeRef());
                            if (debug) System.out.println("\tChange ref " + cloneOfTarget);
                        } else if (parents.contains(target.getDeclaringClass())) {
                            //target has not been cloned, but should be cloned, so clone it and change ref of invoke
                            String name = target.getName() + CLONED_HIDDEN_METHOD_SUFFIX + (cloned_method_id++);
                            SootMethod clonedMethod = cloneMethod(target, name);
                            si.setMethodRef(clonedMethod.makeRef());
                            cloneAdded = true;
                            if (debug) System.out.println("\tClone and Change ref " + clonedMethod);
                        } 
                    }
                }
            }
        } while (cloneAdded);
    }

    /**
     * Resolve the concrete target of a special invoke using our modified semantics for special invoke expression.
     */
    private SootMethod resolveSpecialInvokeTarget(SpecialInvokeExpr si) {
        SootMethod target = si.getMethod();
        String targetSubSig = target.getSubSignature();

        SootClass current = target.getDeclaringClass();

        while (true) {
            if (current.declaresMethod(targetSubSig)) {
                return current.getMethod(targetSubSig);
            } 

            //not a match in current, try superclass on next loop
            if (current.hasSuperclass())
                current = current.getSuperclass();
            else {
                logger.error("Cannot find concrete method target for special invoke: {}", si);
                droidsafe.main.Main.exit(1);
                return null;
            }
        }
    }

    /**
     * Clone given method into this class with given name.
     * Update necessary state of prior analyses.
     */
    private SootMethod cloneMethod(SootMethod ancestorM, String cloneName) {
        //check if we are cloning a method multiple times
        if (clonedToOriginal.containsValue(ancestorM)) {
            logger.error("Cloning method twice: {}", ancestorM);
            droidsafe.main.Main.exit(1);
        }

        SootMethod newMeth = new SootMethod(cloneName, ancestorM.getParameterTypes(),
            ancestorM.getReturnType(), ancestorM.getModifiers(), ancestorM.getExceptions());

        //System.out.printf("\tAdding method %s.\n", ancestorM);
        //register method
        methods.addMethod(newMeth);
        clazz.addMethod(newMeth);

        clonedToOriginal.put(newMeth, ancestorM);

        if (API.v().isBannedMethod(ancestorM.getSignature())) 
            API.v().addBanMethod(newMeth);
        else if (API.v().isSpecMethod(ancestorM)) 
            API.v().addSpecMethod(newMeth);
        else if (API.v().isSafeMethod(ancestorM)) 
            API.v().addSafeMethod(newMeth);
        else if (API.v().isSystemClass(ancestorM.getDeclaringClass())){
            //some methods are auto generated and don't have a classification 
            //make them safe
            API.v().addBanMethod(newMeth);
        }

        //clone body
        Body newBody = (Body)ancestorM.retrieveActiveBody().clone();
        newMeth.setActiveBody(newBody);

        updateJSAResults(ancestorM.retrieveActiveBody(), newBody);
        
        return newMeth;
    }

    /**
     * Return true if the clone already contains a method that would resolve to this method, this 
     * is the test that mimics virtual dispatch, so we don't clone in methods that would not be called.
     */
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


            return true;
        }

        //didn't find it
        return false;
    }

    /**
     * For each value in original body that is hotspots for JSA, add the corresponding cloned
     * value in the clone body to the JSA results with the same result.
     */
    private void updateJSAResults(Body originalBody, Body cloneBody) {
        if (!Config.v().runStringAnalysis || !JSAStrings.v().hasRun())
            return;

        assert originalBody.getUnits().size() == cloneBody.getUnits().size();

        //loop over all methods of both clone and originals
        Iterator originalIt = originalBody.getUnits().iterator();
        Iterator cloneIt = cloneBody.getUnits().iterator();

        while (originalIt.hasNext()) {
            Stmt origStmt = (Stmt)originalIt.next();
            Stmt cloneStmt = (Stmt)cloneIt.next();

            if (!origStmt.containsInvokeExpr()) {
                continue;
            }

            InvokeExpr origInvokeExpr = (InvokeExpr)origStmt.getInvokeExpr();
            InvokeExpr cloneInvokeExpr = (InvokeExpr)cloneStmt.getInvokeExpr();

            //iterate over the args and see if any arg from orig is tracked by jsa
            //if so, add the clone to jsa results
            for (int i = 0; i < origInvokeExpr.getArgCount(); i++) {
                ValueBox origVB = origInvokeExpr.getArgBox(i);

                if (JSAStrings.v().isHotspotValue(origVB.getValue())) {
                    ValueBox cloneVB = cloneInvokeExpr.getArgBox(i);
                    JSAStrings.v().copyResult(origVB.getValue(), 
                        cloneInvokeExpr.getMethodRef().getSignature(), 
                        i, 
                        cloneVB);
                }
            }
        }   
    }
}
