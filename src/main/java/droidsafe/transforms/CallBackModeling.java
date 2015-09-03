/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

package droidsafe.transforms;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.ArrayType;
import soot.Body;
import soot.Local;
import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.VoidType;
import soot.jimple.AssignStmt;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.NewExpr;
import soot.jimple.NullConstant;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.util.Chain;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Hierarchy;
import droidsafe.android.app.Project;
import droidsafe.android.app.resources.Resources;
import droidsafe.android.system.API;
import droidsafe.reports.UnresolvedICC;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.DroidsafeExecutionStatus;
import droidsafe.utils.SootUtils;

public class CallBackModeling {
    private final static Logger logger = LoggerFactory.getLogger(CallBackModeling.class);
    /** Singleton */
    private static CallBackModeling v;

    private static final String CALLBACK_CALLER_NAME = "DS__FAKE__CALLBACKS__";

    private Map<SootClass, SootMethod> classToCallbackMethod;
    private Map<SootMethod, Local> callbackMethodToThisLocal;
    private Set<Stmt> allocAlreadyConsidered;
    private Set<SootClass> calledFallback;

    private static int LOCAL_ID = 0;

    private CallBackModeling() {
        //reset any state object state
        classToCallbackMethod = new HashMap<SootClass, SootMethod>();
        callbackMethodToThisLocal = new HashMap<SootMethod, Local>();
        allocAlreadyConsidered = new HashSet<Stmt>();
        calledFallback = new HashSet<SootClass>();
    }


    public static CallBackModeling v() {
        if (v == null) 
            v = new CallBackModeling();

        return v;
    }

    public void run() {
        //go through all user classes and find method that override system methods that are not called
        //create a method for each class that calls inherited methods that are not reachable (and not verified)
        //for each allocation of one of these classes, call the fallback callback method
        findDeadCallbackAndCreateFallbackMethod();

        //call the methods that we have created at each allocation
        callFallBackMethods();

        //check for components that are not created anywhere
        findAndCreateUnallocedComponents();
    }

    /**
     * Find component classes in user code that was not declared in the manifest, and create fields for
     * them in the harness.
     */
    private void findAndCreateUnallocedComponents() {
        List<SootClass> sortedClasses = new ArrayList<SootClass>(Scene.v().getClasses());

        Collections.sort(sortedClasses, new Comparator<SootClass>() {
            @Override
            public int compare(SootClass o1, SootClass o2) {
                return o1.getName().compareTo(o2.getName());
            }

        });

        for (SootClass clz : sortedClasses) {
            if (!clz.isInterface() && Hierarchy.inheritsFromAndroidBroadcastReceiver(clz) && !Harness.v().hasCreatedField(clz) &&
                    Project.v().isSrcClass(clz) && Resources.v().getManifest().isEnabled(clz)) {
                //found component that is not allocated, should we call is??
                logger.warn("Found BroadcastReceiver not in manifest and not created in code: {}. Adding modeling.", 
                    clz);                               

                Harness.v().createComponentsNotInManifest(clz);
            }
        }
    }

    private void findDeadCallbackAndCreateFallbackMethod() {
        List<SootClass> classes = new LinkedList<SootClass>();
        classes.addAll(Scene.v().getClasses());
        for (SootClass clz : classes) {
            //do this only for app classes
            //don't do this for lib classes
            if (API.v().isSystemClass(clz) || clz.isInterface() || Project.v().isLibClass(clz))
                continue;

            List<SootMethod> toFake = new LinkedList<SootMethod>();

            //find all inherited non-overriden methods from user parents and the methods defined in this class
            //check them
            List<SootMethod> toCheck = new LinkedList<SootMethod>();
            toCheck.addAll(clz.getMethods());
            toCheck.addAll(SootUtils.getInheritedMethods(clz));

            for (SootMethod method : toCheck) {
                //don't worry about constructors or static methods
                if (method.isConstructor() || method.isStatic())
                    continue;

                //if method is reachable or is not an implemented system method or is itself a system method from 
                //a parent
                if (API.v().isSystemMethod(method) || 
                        PTABridge.v().isReachableMethod(method)) {              
                    continue;
                }


                if (!(Hierarchy.isImplementedSystemMethod(method) || API.v().isIPCCallback(method)))
                    continue;

                //find system method that is inherited
                SootMethod closetSystemParent = Hierarchy.closestOverridenSystemMethodNoInterfaces(method);

                boolean shouldFake = false;

                if (closetSystemParent == null) {
                    //could be interface defined, so get all interface parents, and see if they
                    //define the method
                    //and make sure all of them are verified, if any of them is unverified, then we need 
                    //to fake (maybe, who knows, that is what we do)...
                    for (SootClass parent : SootUtils.getParents(clz)) {
                        if (!API.v().isSystemClass(parent))
                            continue;

                        if (parent.isInterface() && 
                                parent.declaresMethod(method.getSubSignature()) /*&&
                                !API.v().isDSVerifiedMethod(parent.getMethod(method.getSubSignature()))*/) {
                            shouldFake = true;
                            break;
                        }
                    }

                } else {
                    //don't add fallback callback modeling the method is verified, but if the class is a 
                    //component, then we cannot rely on the verified tag, so fake anyway
                    //if (!API.v().isDSVerifiedMethod(closetSystemParent) || Hierarchy.isAndroidComponentClass(clz))

                    shouldFake = true;
                }

                if (API.v().isAIDLCallback(method)) 
                    shouldFake = true; 

                if (shouldFake) {
                    logger.info("Need to fake method %s in %s\n", method, clz);
                    if (API.v().isIPCCallback(method))
                        UnresolvedICC.v().addInfo(method, "AIDL Callback");
                    toFake.add(method);
                }
            }

            if (!toFake.isEmpty()) {
                createFakeMethod(clz, toFake);
            }
        }
    }

    private void createFakeMethod(SootClass clz, List<SootMethod> methods) {

        if (!classToCallbackMethod.containsKey(clz)) {

            SootMethod toAdd = new SootMethod(CALLBACK_CALLER_NAME, (List)new LinkedList(), VoidType.v(), Modifier.PUBLIC);

            toAdd.setDeclaringClass(clz);
            clz.addMethod(toAdd);
            API.v().addSafeMethod(toAdd);

            JimpleBody body = Jimple.v().newBody(toAdd);
            toAdd.setActiveBody(body);
            Chain<Unit> units = body.getUnits();

            Local thisLocal = Jimple.v().newLocal("_$thisLocal", RefType.v(clz));
            body.getLocals().add(thisLocal);
            units.add(Jimple.v().newIdentityStmt(thisLocal, Jimple.v().newThisRef(RefType.v(clz)))); 

            //if a call is created, add to fall back class list
            classToCallbackMethod.put(clz, toAdd);
            callbackMethodToThisLocal.put(toAdd, thisLocal);
        }

        SootMethod fallBackMethod = classToCallbackMethod.get(clz);
        JimpleBody body = (JimpleBody)fallBackMethod.getActiveBody();
        Chain<Unit> units = body.getUnits();
        Local thisLocal = callbackMethodToThisLocal.get(fallBackMethod);

        for (SootMethod callMe : methods) {
            InvokeExpr invoke = createCallFakingArgs(callMe, body, thisLocal);

            if (SootUtils.isVoidType(callMe.getReturnType())) {

                units.add(Jimple.v().newInvokeStmt(invoke));
            } else {
                Local returnLocal = Jimple.v().newLocal("_$returnLocal" + LOCAL_ID++, callMe.getReturnType());
                body.getLocals().add(returnLocal);

                AssignStmt assign = Jimple.v().newAssignStmt(returnLocal, invoke);

                units.add(assign);
            }
        }
        units.add(Jimple.v().newReturnVoidStmt());
    }

    /**
     * Find all allocations of classes that have fall back modeling methods, and call the 
     * fall back modeling method right after the constructor is called for each allocation.
     */
    private void callFallBackMethods() {
        for (SootClass clz : Scene.v().getClasses()) {
            for (SootMethod method : clz.getMethods()) {
                if (method.isPhantom() || method.isAbstract() || !method.isConcrete())
                    continue;
                try {
                    Body body = method.getActiveBody();
                    StmtBody stmtBody = (StmtBody)body;
                    Chain units = stmtBody.getUnits();
                    Iterator stmtIt = units.snapshotIterator();

                    while (stmtIt.hasNext()) {
                        Stmt stmt = (Stmt)stmtIt.next();
                        if (allocAlreadyConsidered.contains(stmt))
                            continue;

                        if (stmt instanceof AssignStmt) {
                            AssignStmt assign = (AssignStmt) stmt;
                            if (assign.getRightOp() instanceof NewExpr && assign.getLeftOp() instanceof Local) {
                                NewExpr newExpr = (NewExpr) assign.getRightOp();
                                SootClass classWithFallBackMethod = newExpr.getBaseType().getSootClass();
                                if (classToCallbackMethod.containsKey(classWithFallBackMethod)) {
                                    //find constructor
                                    Set<Local> local = new HashSet<Local>();
                                    local.add((Local)assign.getLeftOp());

                                    Stmt consCall = TransformsUtils.findConstructorCall(method, 
                                        (Stmt)units.getSuccOf(assign), 
                                        local);

                                    if (consCall != null) {
                                        Local receiver = (Local)((SpecialInvokeExpr)consCall.getInvokeExpr()).getBase();
                                        //create call on local with no args 
                                        Stmt fallBackCall = Jimple.v().newInvokeStmt(
                                            Jimple.v().newVirtualInvokeExpr(receiver, 
                                                classToCallbackMethod.get(classWithFallBackMethod).makeRef()));

                                        units.insertAfter(fallBackCall, consCall);
                                        allocAlreadyConsidered.add(assign);
                                        calledFallback.add(classWithFallBackMethod);
                                    } else {
                                        logger.warn("Error finding constructor call for class with fall back modeling: {} {}", clz, assign);
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    logger.debug("Error in fallback callback modeling: {} {}", e, method);
                }
            }
        }
    }

    public static InvokeExpr createCallFakingArgs(SootMethod method, StmtBody body, Object receiver) {
        //next create locals for all arguments
        //List of argument position to locals created...
        List<Value> args = new LinkedList<Value>();
        for (Type argType : method.getParameterTypes()) {
            Value fieldRef = UnmodeledGeneratedClasses.v().getSootFieldForType(argType); 
            if (fieldRef != null && !fieldRef.equals(NullConstant.v())) {
                Local argLocal = Jimple.v().newLocal("_$TU" + LOCAL_ID++, fieldRef.getType());
                body.getLocals().add((Local)argLocal);
                body.getUnits().add(Jimple.v().newAssignStmt(argLocal, fieldRef));
                args.add(argLocal);
            } else {
                args.add(NullConstant.v());
            }
        }

        //now create call to entry point
        logger.debug("method args {} = size of args list {}", method.getParameterCount(), args.size());

        Local trueReceiver = null;
        if (receiver instanceof SootField) {

            trueReceiver = Jimple.v().newLocal("_$TU" + LOCAL_ID++, ((SootField)receiver).getType());
            body.getLocals().add((Local)trueReceiver);
            body.getUnits().add(Jimple.v().newAssignStmt(trueReceiver, Jimple.v().newStaticFieldRef(((SootField)receiver).makeRef())));
        } else if (receiver instanceof Local) {
            trueReceiver = (Local)receiver;
        } else {
            logger.error("Unknown value type for receiver when creating call: {} {}", receiver, receiver.getClass());
            return null;
        }

        return TransformsUtils.makeInvokeExpression(method, trueReceiver, args);
    }
}
