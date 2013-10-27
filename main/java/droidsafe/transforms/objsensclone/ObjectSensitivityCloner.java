package droidsafe.transforms.objsensclone;

import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.value.VAResultContainerClassGenerator;

import droidsafe.android.system.API;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;

import soot.jimple.AssignStmt;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.NewExpr;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;

import soot.Local;

import soot.RefType;

import soot.Scene;

import soot.SootClass;

import soot.SootMethod;

import soot.SootMethodRef;

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

    /** list of class names that should not be cloned */
    public static final Set<String> CLASSES_TO_NOT_CLONE = 
            new HashSet<String>(java.util.Arrays.asList("java.lang.String", 
                "java.lang.Class", 
                "java.lang.CharSequence", 
                    "android.app.Activity"));



    /**
     * Run the cloner on all new expression of classes in the list of classes to clone.  Produce clones for each
     * new expression.
     */
    public static void run() {
        int clonedClasses = 0;
        
        for (SootMethod method : GeoPTA.v().getAllReachableMethods()) {
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
                        if (VA_RESOLVED_CLASSES.contains(base) && !CLASSES_TO_NOT_CLONE.contains(baseClassName)) {
                            logger.info("Found new expr to replace and clone class: {} {}\n",
                                method, assign);

                            //now change the constructor call after find the appropriate call to change
                            try {
                                SpecialInvokeExpr special = findConstructorCall(method,
                                    assign);

                                if (special != null) {
                                    //found an appropriate constructor call

                                    //clone class and install it as an new API class
                                    SootClass cloned = 
                                            ClassCloner.cloneClass(oldNewExpr.getBaseType().getSootClass(), true);

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

                                    clonedClasses++;
                                } else {
                                    throw new Exception("Special Invoke Not Found!");
                                }
                            } catch (Exception e) {
                                logger.error("Error processing constructor call after modifying new expr: {}", 
                                    stmt, e);
                            }

                        }
                    }
                }
            }
        }

        System.out.printf("Finished cloning: added %d classes.\n", clonedClasses);
    }

    /**
     * Given the assignment statement that includes the new expression, find the associated constructor call
     * that is called on the local value.  This method will search starting from the assignment, and conservatively
     * find the constructor call.  Will return null if a constructor is not found.
     */
    private static SpecialInvokeExpr findConstructorCall(SootMethod method, AssignStmt assignStmt) {
        Local local = (Local)assignStmt.getLeftOp();

        //loop through all instructions in method and find the special invoke on this allocnode
        Body body = method.getActiveBody();
        StmtBody stmtBody = (StmtBody)body;
        Chain units = stmtBody.getUnits();
        Iterator stmtIt = units.iterator();

        boolean beginSearch = false;
        while (stmtIt.hasNext()) {
            Stmt stmt = (Stmt)stmtIt.next();

            if (stmt == assignStmt) {
                beginSearch = true;
                continue;
            }

            if (beginSearch) {
                if (stmt.containsInvokeExpr() && stmt.getInvokeExpr() instanceof SpecialInvokeExpr) {
                    SpecialInvokeExpr si = (SpecialInvokeExpr) stmt.getInvokeExpr();
                    if (si.getBase() == local)
                        return si;

                    //value has been redefined before we found a constructor, so we can't find anything!
                    for (ValueBox def : stmt.getDefBoxes()) {
                        if (def.canContainValue(local)) {
                            return null;
                        }
                    }

                } else if (stmt.branches()) {
                    //check for control flow?
                    return null;
                }
            }
        }

        return null;
    }

    /**
     * This call is deprecated and uses the PTA to try to find the appropriate constructor call.
     * We might need this in the future if we are having issues find appropriate constructor calls with 
     * the simple linear search above.
     * 
     * Need to run PTA right before the cloner if we are going to use this!
     */
    private static SpecialInvokeExpr findConstructorCall(SootMethod method, Local l, NewExpr oldNewExpr) {
        AllocNode allocNode = GeoPTA.v().getAllocNode(oldNewExpr);
        System.out.printf("\tLooking for allocnode: %s\n", allocNode);

        //loop through all instructions in method and find the special invoke on this allocnode
        Body body = method.getActiveBody();
        StmtBody stmtBody = (StmtBody)body;
        Chain units = stmtBody.getUnits();
        Iterator stmtIt = units.iterator();

        SpecialInvokeExpr found = null;

        while (stmtIt.hasNext()) {
            Stmt stmt = (Stmt)stmtIt.next();

            if (stmt.containsInvokeExpr() && stmt.getInvokeExpr() instanceof SpecialInvokeExpr) {
                SpecialInvokeExpr si = (SpecialInvokeExpr) stmt.getInvokeExpr();

                System.out.printf("\tFound special invoke: %s\n", si);

                Set<AllocNode> nodes = GeoPTA.v().getPTSetContextIns(si.getBase());

                //we found the appropriate constructor call if we have an alloc node set size of 1
                //and the alloc node we are looking for is the only element in the set.
                if (nodes.size() == 1 && nodes.contains(allocNode) == true) {
                    System.out.printf("\tFound Alloc Node\n");
                    if (found != null) {
                        //we found 2 appropriate constructor calls
                        //should not happen, so return null to abort the replacement
                        logger.error("Strange, found two constructor calls {} {} in method {} for {}.", 
                                found, si, method, oldNewExpr);
                        return null;
                    }

                    found = si;
                }
            }
        }

        return found;
    }
}
