package droidsafe.transforms.objsensclone;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.value.VAResultContainerClassGenerator;
import droidsafe.android.app.Hierarchy;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.utils.SootUtils;

import java.util.Arrays;
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

import soot.Body;
import soot.jimple.AssignStmt;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.NewExpr;
import soot.jimple.NullConstant;
import soot.jimple.internal.JAssignStmt;
import soot.jimple.internal.JGotoStmt;
import soot.jimple.internal.JIfStmt;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.Local;
import soot.PrimType;
import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;
import soot.VoidType;
import soot.util.Chain;
import soot.ValueBox;

/**
 * Introduce selective object sensitivity by cloning certain api classes.  
 * When a new expression of one of the tracked classes is encountered in application code, 
 * a clone is created of the original class (clone contains methods from ancestors), and the
 * new expression (plus constructor call) are changed to reference the new cloned class.  
 * 
 * Does not rely on PTA.
 * 
 * @author mgordon
 *
 */
public class ObjectSensitivityCloner {
    /** logger object */
    private static final Logger logger = LoggerFactory.getLogger(ObjectSensitivityCloner.class);

    /** list of classes resolved by VA, some of which should be cloned */
    public static final Set<SootClass> VA_RESOLVED_CLASSES = 
            VAResultContainerClassGenerator.getClassesAndFieldsToModel(false).keySet();

    private static final String[] STRING_CLASSES = new String[]{"java.lang.String", 
                                                                "java.lang.StringBuffer",
    "java.lang.StringBuilder"};

    private int numClonedClasses = 0;
    private int cloneErrors = 0;
    private List<SootMethod> masterMethodList;
    private static ObjectSensitivityCloner v;

    private Set<SootClass> clonedClasses;

    public static ObjectSensitivityCloner v() {
        if (v == null)
            v = new ObjectSensitivityCloner();

        return v;
    }

    public static void reset() {
        v = null;
    }


    private ObjectSensitivityCloner() {
        clonedClasses = new HashSet<SootClass>();
    }

    private void initMasterList() {
        //we want to keep a consistent numbering across runs of droidsafe for clones
        //so we sort the classes list we go through
        masterMethodList = new LinkedList<SootMethod>();
        masterMethodList.addAll(PTABridge.v().getAllReachableMethods());
        Collections.sort(masterMethodList, new ToStringComparator());
    }

    /**
     * Run the cloner on all new expression of classes in the list of classes to clone.  Produce clones for each
     * new expression.
     */
    public void runForVA() {
        numClonedClasses = 0;
        AllocationGraph aGraph = new AllocationGraph();

        initMasterList();

        for (SootClass currentClass : aGraph.workList()) {
            //don't clone strings on first run
            if (("java.lang.String".equals(currentClass.getName()) ||
                    "java.lang.StringBuffer".equals(currentClass.getName()) ||
                    "java.lang.StringBuilder".equals(currentClass.getName()) ) )
                continue;

            cloneAllAllocsOfClass(currentClass);
        }

        Scene.v().releaseActiveHierarchy();
        Scene.v().releaseFastHierarchy();

        System.out.printf("Finished cloning: added %d classes (%d errors).\n", numClonedClasses, cloneErrors);
    }
    

    public void runForInfoFlow() {
        numClonedClasses = 0;

        initMasterList();

        for (String stringClass : STRING_CLASSES) {
            SootClass currentClass = Scene.v().getSootClass(stringClass);
            cloneAllAllocsOfClass(currentClass);
        }

        Scene.v().releaseActiveHierarchy();
        Scene.v().releaseFastHierarchy();
        
        System.out.printf("Finished cloning: added %d classes (%d errors).\n", numClonedClasses, cloneErrors);
    }

    private void cloneAllAllocsOfClass(SootClass currentClass) {
        if (clonedClasses.contains(currentClass)) {
            logger.error("Trying to clone allocs for already cloned class: {}", currentClass);
            droidsafe.main.Main.exit(1);
        }


        //System.out.println("Cloning " + currentClass.getName());

        //create a list to iterate over that is the current snap shot of the master list
        //because we update the master list for each clone...
        List<SootMethod> iterationList = new LinkedList<SootMethod>();
        iterationList.addAll(masterMethodList);

        //don't need to clone the first allocation expr
        //boolean isFirst = true;

        for (SootMethod method : iterationList) {

            //if (API.v().isSystemMethod(method))
            //    continue;

            if (method.isAbstract() || !method.isConcrete())
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
                        NewExpr oldNewExpr = (NewExpr) assign.getRightOp();
                        SootClass base = oldNewExpr.getBaseType().getSootClass();
                        String baseClassName = base.getName();

                        if (!currentClass.equals(base)) 
                            continue;

                        logger.info("Found new expr to replace and clone class: {} {}\n",
                            method, assign);

                        //now change the constructor call after find the appropriate call to change
                        try {
                            Set<Local> local = new HashSet<Local>();
                            local.add((Local)assign.getLeftOp());
                            
                            SpecialInvokeExpr special = findConstructorCall(method,
                                (Stmt)units.getSuccOf(assign), local);

                            if (special != null) {
                                //found an appropriate constructor call
                                //clone class and install it as an new API class

                                ClassCloner cCloner = ClassCloner.cloneClass(base);
                                
                                SootClass cloned = cCloner.getClonedClass();

                                //add all cloned methods clone to the master list
                                masterMethodList.addAll(cCloner.getReachableClonedMethods());

                                SootMethodRef origMethodRef = special.getMethodRef();

                                //replace old constructor call with call to cloned class
                                special.setMethodRef(Scene.v().makeMethodRef(cloned, 
                                    origMethodRef.name(), 
                                    origMethodRef.parameterTypes(), 
                                    origMethodRef.returnType(), 
                                    origMethodRef.isStatic()));

                                //replace new expression with new expression of cloned class
                                NewExpr newNewExpr = Jimple.v().newNewExpr(RefType.v(cloned));
                                assign.setRightOp(newNewExpr);

                                numClonedClasses++;
                                clonedClasses.add(currentClass);
                            } else {
                                throw new Exception("Special Invoke Not Found!");
                            }
                        } catch (Exception e) {
                            logger.info("Error processing constructor call after modifying new expr: {} in {}", 
                                stmt, method, e);
                            //droidsafe.main.Main.exit(1);
                            cloneErrors++;
                        }

                    }
                }
            }
        }
        
    }

    /**
     * After all clones are created for clz, wipe clean the original methods of clz, but deleting their code
     * and calling super if it is a method that overrides a superclasses method... 
     * 
     * @param clz
     */
    private void sanitizeOriginalClass(SootClass clz) {
        //what about for super methods that return a value?

        for (SootMethod method : clz.getMethods()) {
            //don't clean static methods, and don't do anything for methods that don't have a body
            if (method.isStatic() || method.isAbstract() || method.isPhantom() || !method.isConcrete() || 
                    SootUtils.isRuntimeStubMethod(method))
                continue;

            //release the active body
            method.releaseActiveBody();
            //create a new body that sets the this, and the arguments
            JimpleBody body = Jimple.v().newBody(method);
            method.setActiveBody(body);

            //create the this identity
            Local thisLocal = Jimple.v().newLocal("this_local", clz.getType());
            body.getLocals().add(thisLocal);
            body.getUnits().add(Jimple.v().newIdentityStmt(thisLocal,
                Jimple.v().newThisRef(clz.getType())));

            //create locals for parameters and reference params
            int i = 0;
            Local[] argLocals = new Local[method.getParameterCount()];

            for (Type type : method.getParameterTypes()) {
                //add local
                argLocals[i] = Jimple.v().newLocal("l" + i, type);
                body.getLocals().add(argLocals[i]);

                //add param assignment
                body.getUnits().add(Jimple.v().newIdentityStmt(argLocals[i], 
                    Jimple.v().newParameterRef(type, i)));

                i++;
            }

            Type rType = method.getReturnType();
            SootMethod ancestorMethod = null;
            //object has no superclass...
            if (clz.hasSuperclass())
                ancestorMethod = SootUtils.findClosetMatch(clz.getSuperclass(), method.makeRef());

            boolean isOverride = ancestorMethod != null && 
                    Scene.v().getActiveHierarchy().isVisible(clz, ancestorMethod);

            if (isOverride) {
                //of an override, then call super, if has a return type, then return it's value
                //find super method reference
                SootMethodRef superRef = ancestorMethod.makeRef();

                //construct args
                List<Local> args = Arrays.asList(argLocals);

                if (rType == VoidType.v()) {
                    //add call to super
                    body.getUnits().add(Jimple.v().newInvokeStmt(Jimple.v().newSpecialInvokeExpr(
                        thisLocal, superRef, args)));

                    //add return statement
                    body.getUnits().add(Jimple.v().newReturnVoidStmt());
                } else {
                    //create local 
                    Local retValue = Jimple.v().newLocal("super_ret_value", clz.getType());
                    body.getLocals().add(retValue);

                    //assign local to the super call
                    body.getUnits().add(Jimple.v().newAssignStmt(
                        retValue, 
                        Jimple.v().newSpecialInvokeExpr(thisLocal, superRef, args)
                            )); 

                    //return ret value
                    body.getUnits().add(Jimple.v().newReturnStmt(retValue));
                }
            } else {
                //remember this will never be called, but should generate legal code

                //if not an override, then just return the return type or null
                if (rType == VoidType.v()) {
                    body.getUnits().add(Jimple.v().newReturnVoidStmt());
                } else if (rType instanceof RefLikeType || rType instanceof PrimType) {
                    body.getUnits().add(Jimple.v().newReturnStmt(SootUtils.getNullValue(rType)));
                } else {
                    logger.error("Unknown return type when sanitizing original method: {}", method.getReturnType());
                    droidsafe.main.Main.exit(1);
                }
            }
        }
    }

    /**
     * Given the assignment statement that includes the new expression, find the associated constructor call
     * that is called on the local value.  This method will search starting from the assignment, and conservatively
     * find the constructor call.  Will return null if a constructor is not found.
     */
    private SpecialInvokeExpr findConstructorCall(SootMethod method, Stmt startStmt, Set<Local> locals) {
        //loop through all instructions in method and find the special invoke on this allocnode
        Body body = method.getActiveBody();
        StmtBody stmtBody = (StmtBody)body;
        Chain units = stmtBody.getUnits();
        Iterator stmtIt = units.iterator(startStmt);

        while (stmtIt.hasNext()) {
            Stmt stmt = (Stmt)stmtIt.next();

            if (stmt.containsInvokeExpr() && stmt.getInvokeExpr() instanceof SpecialInvokeExpr) {
                SpecialInvokeExpr si = (SpecialInvokeExpr) stmt.getInvokeExpr();
                if (locals.contains(si.getBase()))
                    return si;
            }
            
            //assigning local to new local, remember lhs
            if (stmt instanceof AssignStmt &&
                    locals.contains(((AssignStmt)stmt).getRightOp()) &&
                    ((AssignStmt)stmt).getLeftOp() instanceof Local) {
                
                locals.add((Local) ((AssignStmt)stmt).getLeftOp());
                continue;
            }

            //check
            //value has been redefined before we found a constructor, so we can't find anything!
            for (ValueBox def : stmt.getDefBoxes()) {
                if (locals.contains(def.getValue())) {
                    //System.out.println("Failed on can contain value: " + stmt);
                    return null;
                }

            }

            //now account for some jumps, and if constructs
            if (stmt instanceof JGotoStmt) {
                //recurse into goto statements
                
                //but only go forward...to avoid loops
                if (!units.follows((Stmt)((JGotoStmt) stmt).getTarget(), stmt))
                    return null;
                
                return findConstructorCall(method, (Stmt)((JGotoStmt) stmt).getTarget(), locals);
            } else if (stmt instanceof JIfStmt) {
                if (!units.follows((Stmt)((JIfStmt) stmt).getTarget(), stmt))
                    return null;
                
                //recurse into if statement target and fall through
                SpecialInvokeExpr trueBranch = findConstructorCall(method, ((JIfStmt) stmt).getTarget(), locals); 
                SpecialInvokeExpr falseBranch = findConstructorCall(method, (Stmt)units.getSuccOf(stmt), locals); 

                if (trueBranch == falseBranch)
                    return trueBranch;
                else 
                    return null;
            } 
        }

        return null;
    }
    
    /**
     * For each original class that was cloned, remove it from lists of src, lib, gen
     */
    private void cleanUpProjectSets() {
        for (SootClass clz : clonedClasses) {
            Project.v().removeSrcClass(clz);
            Project.v().removeGenClass(clz);
            Project.v().removeLibClass(clz);
        }
    }
}

class ToStringComparator implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        return o1.toString().compareTo(o2.toString());
    }

}