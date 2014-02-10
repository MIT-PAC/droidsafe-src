package droidsafe.transforms;

import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.Local;
import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.VoidType;
import soot.jimple.AssignStmt;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.NewExpr;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.util.Chain;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Hierarchy;
import droidsafe.android.system.API;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.DroidsafeExecutionStatus;
import droidsafe.utils.SootUtils;

public class CallBackModeling {
    private final static Logger logger = LoggerFactory.getLogger(CallBackModeling.class);
    /** Singleton */
    private static CallBackModeling v;

    private static final String CALLBACK_CALLER_NAME = "DS__FAKE__CALLBACKS__";

    private Map<SootClass, SootMethod> hasFallbackMethod;

    boolean passChange = false;
    
    private CallBackModeling() {
       
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
      
        int i = 1;
        do {
            System.out.println("Fallback modeling pass " + i++ + "...");
            droidsafe.main.Main.afterTransform(false);
            
            passChange = false;
            
            //reset any state object state
            hasFallbackMethod = new HashMap<SootClass, SootMethod>();
            
            //find call backs that are not called
            findDeadCallbackAndCreateFallbackMethod();
            callFallBackMethods();
            
            //find api methods that return null values
            findAPICallsWithNullReturnValues();
        } while (passChange);

    }

    private void findDeadCallbackAndCreateFallbackMethod() {
        for (SootClass clz : Scene.v().getClasses()) {
            //do this only for app classes
            if (API.v().isSystemClass(clz))
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
                        PTABridge.v().isReachableMethod(method) || 
                        !Hierarchy.isImplementedSystemMethod(method))
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
                        if (parent.isInterface() && 
                                parent.declaresMethod(method.getSubSignature()) &&
                                !API.v().isDSVerifiedMethod(parent.getMethod(method.getSubSignature()))) {
                            shouldFake = true;
                            break;
                        }
                    }

                } else {
                    //don't add fallback callback modeling the method is verified and unreachable...
                    if (!API.v().isDSVerifiedMethod(closetSystemParent))
                        shouldFake = true;
                }

                if (shouldFake) {
                    System.out.println("Need to fake method " + method);
                    toFake.add(method);
                }
            }

            if (!toFake.isEmpty()) {
                createFakeMethod(clz, toFake);
            }
        }
    }

    private void createFakeMethod(SootClass clz, List<SootMethod> methods) {
        int localID = 0;
        SootMethod toAdd = new SootMethod(CALLBACK_CALLER_NAME, (List)new LinkedList(), VoidType.v(), Modifier.PUBLIC);

        toAdd.setDeclaringClass(clz);
        clz.addMethod(toAdd);
        API.v().addSafeMethod(toAdd);

        JimpleBody body = Jimple.v().newBody(toAdd);
        toAdd.setActiveBody(body);
        Chain<Unit> units = body.getUnits();

        Local thisLocal = Jimple.v().newLocal("thisLocal", RefType.v(clz));
        body.getLocals().add(thisLocal);
        units.add(Jimple.v().newIdentityStmt(thisLocal, Jimple.v().newThisRef(RefType.v(clz)))); 

        Map<Type, Local> createdAlready = new HashMap<Type,Local>();
        
        for (SootMethod callMe : methods) {

            //TODO: ADD SOMETHING HERE ABOUT ADDING TAINT TO THE METHOD ARGS BASED ON PACKAGE OF PARENT?
            //TODO: ADD A GET INFOKIND METHOD TO A MODEL

            //TODO: object local for all return types?

            //TODO: for primitives, do something to get all fields from ancestors?
            //TODO: create big add expression?

            
            InvokeExpr invoke = TransformsUtils.createCallCreatingArgs(callMe, body, thisLocal, createdAlready);
            
            Local returnLocal = Jimple.v().newLocal("returnLocal" + localID++, callMe.getReturnType());
            body.getLocals().add(returnLocal);
            
            AssignStmt assign = Jimple.v().newAssignStmt(returnLocal, invoke);
            
            units.add(assign);
            
            //check all inherited fields and see if the return value could be assigned to any?
            
            //if a call is created, add to fall back class list
            hasFallbackMethod.put(clz, toAdd);
            
           
        }
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

                Body body = method.getActiveBody();
                StmtBody stmtBody = (StmtBody)body;
                Chain units = stmtBody.getUnits();
                Iterator stmtIt = units.snapshotIterator();

                while (stmtIt.hasNext()) {
                    Stmt stmt = (Stmt)stmtIt.next();

                    if (stmt instanceof AssignStmt) {
                        AssignStmt assign = (AssignStmt) stmt;
                        if (assign.getRightOp() instanceof NewExpr && assign.getLeftOp() instanceof Local) {
                            NewExpr newExpr = (NewExpr) assign.getRightOp();
                            SootClass classWithFallBackMethod = newExpr.getBaseType().getSootClass();
                            if (hasFallbackMethod.containsKey(classWithFallBackMethod)) {
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
                                            hasFallbackMethod.get(classWithFallBackMethod).makeRef()));

                                    units.insertAfter(fallBackCall, consCall);
                                    //make a change to the code!
                                    passChange = true;
                                } else {
                                    logger.warn("Error finding constructor call for class with fall back modeling: {} {}", clz, assign);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void findAPICallsWithNullReturnValues() {
        for (SootClass clz : Scene.v().getClasses()) {

            for (SootMethod method : clz.getMethods()) {
                if (API.v().isSystemMethod(method))
                    continue;

                if (method.isPhantom() || method.isAbstract() || !method.isConcrete())
                    continue;
                
                if (!PTABridge.v().isReachableMethod(method))
                    continue;
               

                Body body = method.getActiveBody();
                StmtBody stmtBody = (StmtBody)body;
                Chain units = stmtBody.getUnits();
                Iterator stmtIt = units.snapshotIterator();

                while (stmtIt.hasNext()) {
                    Stmt stmt = (Stmt)stmtIt.next();

                    if (stmt instanceof AssignStmt) {
                        AssignStmt assign = (AssignStmt) stmt;
                        if (assign.getRightOp() instanceof InvokeExpr) {
                            boolean hasAPITarget = false;
                            InvokeExpr invoke = (InvokeExpr)assign.getRightOp();
                            
                            //don't care if the return type is a primitive
                            if (!(invoke.getMethodRef().returnType() instanceof RefLikeType))
                                continue;            
                            
                            try {
                                Collection<SootMethod> targets = PTABridge.v().resolveInvoke(invoke);
                                for (SootMethod target : targets) 
                                    if (API.v().isSystemMethod(target)) {
                                        hasAPITarget = true;
                                        break;
                                    }
                            } catch (CannotFindMethodException e) {
                                
                            }
                            
                            
                            if (hasAPITarget) {
                                //we have a method that could target the api, now see if the return value has 
                                //anything in its pt set
                                
                                if (PTABridge.v().getPTSet(assign.getLeftOp()).isEmpty())
                                    System.out.printf("Call to %s in %s has null return value.\n", stmt, method);
                            }
                        }
                    }
                }
            }
        }
    }
}
