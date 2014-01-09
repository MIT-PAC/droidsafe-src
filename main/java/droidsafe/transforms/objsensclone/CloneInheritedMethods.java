package droidsafe.transforms.objsensclone;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import soot.Body;
import soot.Modifier;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;
import soot.ValueBox;
import soot.jimple.InvokeExpr;
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

public class CloneInheritedMethods {

    /** methods of the new cloned class */
    private SootMethodList methods;
    /** methods of the clone that are currently reachable based on if the orig method is reachable */
    private Set<SootMethod> reachableClonedMethods;
    /** set of methods from ancestors that we have cloned into this clone */
    private Set<SootMethod> ancestorMethodsAdded = new HashSet<SootMethod>();

    private SootClass clazz;

    public CloneInheritedMethods(SootClass clz) {
        clazz = clz;
        methods = new SootMethodList();

        //add methods already in the clz
        for (SootMethod method : clazz.getMethods())
            methods.addMethod(method);

        reachableClonedMethods = new HashSet<SootMethod>();
    }

    public void transform() {
        //build ancestor
        List<SootClass> ancestors = Scene.v().getActiveHierarchy().getSuperclassesOf(clazz);

        for (SootClass ancestor : ancestors) {
            incorporateAncestorMethods(ancestor);
        }

        //modify ancestors fields
        for (SootClass ancestor : ancestors) {
            makeAncestorFieldsVisible(ancestor);

        }

        fixInvokeSpecials();
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
        return reachableClonedMethods;
    }


    /**
     * Clone non-static ancestor methods that are not hidden by virtual dispatch.
     */
    private void incorporateAncestorMethods(SootClass ancestor) {

        //create all methods, cloning body, replacing instance field refs
        for (SootMethod ancestorM : ancestor.getMethods()) {
            if (ancestorM.isAbstract() || ancestorM.isPhantom() || !ancestorM.isConcrete() || 
                    SootUtils.isRuntimeStubMethod(ancestorM))
                continue;

            //never clone static methods
            if (ancestorM.isStatic())
                continue;


            //check if this method already exists
            if (containsMethod(ancestorM.getSignature())) {
                //System.out.printf("\tAlready contains method %s.\n", ancestorM);
                continue;
            }

            //turn off final for ancestor methods
            if (ancestorM.isFinal())
                ancestorM.setModifiers(ancestorM.getModifiers() ^ Modifier.FINAL);

            ancestorMethodsAdded.add(ancestorM);

            SootMethod newMeth = new SootMethod(ancestorM.getName(), ancestorM.getParameterTypes(),
                ancestorM.getReturnType(), ancestorM.getModifiers(), ancestorM.getExceptions());

            //System.out.printf("\tAdding method %s.\n", ancestorM);
            //register method
            methods.addMethod(newMeth);
            clazz.addMethod(newMeth);


            if (API.v().isBannedMethod(ancestorM.getSignature())) 
                API.v().addBanMethod(newMeth);
            else if (API.v().isSpecMethod(ancestorM)) 
                API.v().addSpecMethod(newMeth);
            else if (API.v().isSafeMethod(ancestorM)) 
                API.v().addSafeMethod(newMeth);
            else if (API.v().isSystemClass(ancestor)){
                //some methods are auto generated and don't have a classification 
                //make them safe
                API.v().addSafeMethod(newMeth);
            }


            //clone body
            Body newBody = (Body)ancestorM.retrieveActiveBody().clone();
            newMeth.setActiveBody(newBody);

            updateJSAResults(ancestorM.retrieveActiveBody(), newBody);

            //if the original method is reachable, then so is this method
            if (PTABridge.v().getAllReachableMethods().contains(ancestorM))
                reachableClonedMethods.add(newMeth);
        }
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

    private void fixInvokeSpecials() {
        for (SootMethod method : clazz.getMethods()) {

            Body body = method.getActiveBody();
            StmtBody stmtBody = (StmtBody)body;
            Chain units = stmtBody.getUnits();
            Iterator stmtIt = units.iterator();

            while (stmtIt.hasNext()) {
                Stmt stmt = (Stmt)stmtIt.next();

                if (stmt.containsInvokeExpr() && stmt.getInvokeExpr() instanceof SpecialInvokeExpr) {
                    SpecialInvokeExpr si = (SpecialInvokeExpr) stmt.getInvokeExpr();

                    if (ancestorMethodsAdded.contains(si.getMethod())) {
                        SootMethodRef clonedMethodRef = clazz.getMethod(si.getMethod().getSubSignature()).makeRef();
                        si.setMethodRef(clonedMethodRef);
                    }
                }
            }
        }
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
