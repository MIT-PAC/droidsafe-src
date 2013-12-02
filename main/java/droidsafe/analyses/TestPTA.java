package droidsafe.analyses;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Local;
import soot.SootMethod;
import soot.Value;
import soot.jimple.AnyNewExpr;
import soot.jimple.AssignStmt;
import soot.jimple.CastExpr;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.NullConstant;
import soot.jimple.Stmt;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.Edge;
import droidsafe.android.system.API;
import droidsafe.utils.SootUtils;
import droidsafe.analyses.pta.ContextType;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.pta.PTAContext;
import droidsafe.analyses.pta.cg.*;

/**
 * Hacked up testing pass for the PTA and the call graph traversal.
 * 
 * @author mgordon
 *
 */
public class TestPTA implements CGContextVisitor {
    /** Logger field */
    private static final Logger logger = LoggerFactory.getLogger(TestPTA.class);

    int numMethods = 0;
    
    public TestPTA() {
        // TODO Auto-generated constructor stub
        CallGraphTraversal.acceptContext(this, ContextType.EVENT_CONTEXT);
        System.out.println("Number of method/context visited: " + numMethods);
    }

    @Override
    public void visit(SootMethod method, PTAContext context) {
        // TODO Auto-generated method stub
        testMethod(method, context);
        //countMethods(method, context);
    }

    private void countMethods(SootMethod sm, Edge context) {
        numMethods++;
        System.out.println("Call: " + sm);
    }
    
    private void testMethod(SootMethod sm, PTAContext context) {
        //if (API.v().isSystemMethod(sm))
        //    return;
                
        numMethods++;
        System.out.println("Test Method: " + sm);
        
        //System.out.println(sm);
        System.out.println("  " + context);
                
        /*System.out.println("context: " + context);
        System.out.println("Edge into: " + edgeInto);
        System.out.println("Context context: " + context.srcCtxt());
        System.out.println("Stmt: " + context.srcStmt());
        System.out.println();
        */

        if (!sm.isConcrete())
            return;
        if (!sm.hasActiveBody()) {
            sm.retrieveActiveBody();
        }
       

        // We first gather all the memory access expressions
        for (Iterator stmts = sm.getActiveBody().getUnits().iterator(); stmts.hasNext();) {
            Stmt st = (Stmt) stmts.next();

            InstanceInvokeExpr iie = SootUtils.getInstanceInvokeExpr(st);

            if (false) {
                
                System.out.println("Instance Invoke: " + st);
                System.out.println("Context: " + context);
                for (AllocNode node : PTABridge.v().getPTSet(iie.getBase(),
                    context)) 
                    System.out.println("  " + node);
                System.out.println("Args");
                for (Value val : iie.getArgs()) {
                    if (PTABridge.v().isPointer(val)) {
                        for (AllocNode node : PTABridge.v().getPTSet(val, 
                            context))
                            System.out.println("  " + node);
                    } else {
                        System.out.println("  not a pointer.");
                    }
                }
                System.out.println();
               
            }
            if (st instanceof AssignStmt) {

                AssignStmt a = (AssignStmt) st;
                try {
                    if (a.getRightOp() instanceof AnyNewExpr) {
                        if (PTABridge.v().getAllocNode(a.getRightOp()) == null)
                            System.out.println("New expr not in map: " + a);
                    } 
                    
                    if (PTABridge.v().isPointer(a.getLeftOp())) {
                        Set<AllocNode> lhsNodes = PTABridge.v().getPTSet(a.getLeftOp(), context);

                        Set<AllocNode> rhsNodes = null;
                        if (PTABridge.v().isPointer(a.getRightOp())) {
                            rhsNodes = PTABridge.v().getPTSet(a.getRightOp(), 
                                context);
                        } else if (PTABridge.v().getAllocNode(a.getRightOp()) != null) {
                            rhsNodes = new LinkedHashSet<AllocNode>();
                            rhsNodes.add(PTABridge.v().getAllocNode(a.getRightOp()));
                        } else if (a.getRightOp() instanceof CastExpr) {
                            CastExpr castExpr = (CastExpr)a.getRightOp();
                            rhsNodes = PTABridge.v().getPTSet(castExpr.getOp(), context);
                            Set<AllocNode> toRemove = new HashSet<AllocNode>();
                            for (AllocNode node : rhsNodes) {
                                if (!PTABridge.v().isLegalCast(node.getType(), castExpr.getCastType())) {
                                    toRemove.add(node);
                                }
                            }
                            rhsNodes.removeAll(toRemove);
                        } else if (a.getRightOp() instanceof InvokeExpr || a.getRightOp() instanceof NullConstant) {
                            rhsNodes = new LinkedHashSet<AllocNode>();
                        } else {
                            rhsNodes = new LinkedHashSet<AllocNode>();
                            System.out.println("** Empty RHS: " + a.getRightOp());
                        }

                        if (a.getLeftOp() instanceof Local && !lhsNodes.containsAll(rhsNodes)) {
                            System.out.println(sm + "\nAssign: " + st);
                            System.out.println("  Context: " + context);
                            System.out.println("RHS: " + a.getRightOp() + " " + a.getRightOp().getClass());
                            for (AllocNode node : rhsNodes) 
                                System.out.println("  " + node);
                            System.out.println("LHS: " + a.getLeftOp() + " " + a.getLeftOp().getClass());
                            for (AllocNode node : lhsNodes) 
                                System.out.println("  " + node);
                            if (a.getLeftOp() instanceof InstanceFieldRef) {
                                Set<AllocNode> baseNodes = 
                                        PTABridge.v().getPTSet(
                                            ((InstanceFieldRef)a.getLeftOp()).getBase(), 
                                            context);
                                for (AllocNode node : baseNodes) {
                                    System.out.println("  baseNode: " + node);
                                }
                            }
                            /*  System.out.println("Ins LHS: ");
                        for (AllocNode node : PTABridge.v().getPTSetContextIns(a.getLeftOp()))
                            System.out.println("  " + node);
                             */
                          }
                    }
                } catch (Exception e) {
                    logger.error("Error with PTA: {}", st, e);
                    droidsafe.main.Main.exit(1);
                }
            }
        }
    }

}
