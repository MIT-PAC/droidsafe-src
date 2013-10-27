package droidsafe.analyses;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import droidsafe.analyses.helper.CallGraphTraversal;
import droidsafe.android.system.API;
import droidsafe.utils.SootUtils;
import droidsafe.analyses.helper.*;

/**
 * Hacked up testing pass for the PTA and the call graph traversal.
 * 
 * @author mgordon
 *
 */
public class TestPTA implements CGVisitorEntryContext {
    /** Logger field */
    private static final Logger logger = LoggerFactory.getLogger(TestPTA.class);

    int numMethods = 0;
    
    public TestPTA() {
        // TODO Auto-generated constructor stub
        CallGraphTraversal.acceptEntryContext(this);
        System.out.println("Number of method/context visited: " + numMethods);
    }

    @Override
    public void visitEntryContext(SootMethod method, Edge context) {
        // TODO Auto-generated method stub
        testMethod(method, context);
        //countMethods(method, context);
    }

    private void countMethods(SootMethod sm, Edge context) {
        numMethods++;
        System.out.println("Call: " + sm);
    }
    
    private void testMethod(SootMethod sm, Edge context) {
        if (API.v().isSystemMethod(sm))
            return;
        
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
        if ( !GeoPTA.v().isValidMethod(sm) )
            return;

        // We first gather all the memory access expressions
        for (Iterator stmts = sm.getActiveBody().getUnits().iterator(); stmts.hasNext();) {
            Stmt st = (Stmt) stmts.next();

            InstanceInvokeExpr iie = SootUtils.getInstanceInvokeExpr(st);

            if (iie != null) {
                
                System.out.println("Instance Invoke: " + st);
                System.out.println("Context: " + context);
                for (AllocNode node : GeoPTA.v().getPTSetEventContext(iie.getBase(), context)) 
                    System.out.println("  " + node);
                System.out.println("Args");
                for (Value val : iie.getArgs()) {
                    if (GeoPTA.v().isPointer(val)) {
                        for (AllocNode node : GeoPTA.v().getPTSetEventContext(val, context))
                            System.out.println("  " + node);
                    } else {
                        System.out.println("  not a pointer.");
                    }
                }
                System.out.println();
               
            } else  if (st instanceof AssignStmt) {

                AssignStmt a = (AssignStmt) st;
                try {
                    if (a.getRightOp() instanceof AnyNewExpr) {
                        if (GeoPTA.v().getAllocNode(a.getRightOp()) == null)
                            System.out.println("New expr not in map: " + a);
                    } 
                    
                    if (GeoPTA.v().isPointer(a.getLeftOp())) {
                        Set<AllocNode> lhsNodes = GeoPTA.v().getPTSetEventContext(a.getLeftOp(), context);

                        Set<AllocNode> rhsNodes = null;
                        if (GeoPTA.v().isPointer(a.getRightOp())) {
                            rhsNodes = GeoPTA.v().getPTSetEventContext(a.getRightOp(), context);
                        } else if (GeoPTA.v().getAllocNode(a.getRightOp()) != null) {
                            rhsNodes = new LinkedHashSet<AllocNode>();
                            rhsNodes.add(GeoPTA.v().getAllocNode(a.getRightOp()));
                        } else if (a.getRightOp() instanceof CastExpr) {
                            CastExpr castExpr = (CastExpr)a.getRightOp();
                            rhsNodes = GeoPTA.v().getPTSetEventContext(castExpr.getOp(), context);
                            Set<AllocNode> toRemove = new HashSet<AllocNode>();
                            for (AllocNode node : rhsNodes) {
                                if (!GeoPTA.v().isLegalCast(node.getType(), castExpr.getCastType())) {
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

                        if (!lhsNodes.containsAll(rhsNodes)) {
                            System.out.println(sm + "\nAssign: " + st);
                            System.out.println("  Context: " + context);
                            System.out.println("RHS:");
                            for (AllocNode node : rhsNodes) 
                                System.out.println("  " + node);
                            System.out.println("LHS:");
                            for (AllocNode node : lhsNodes) 
                                System.out.println("  " + node);
                            if (a.getLeftOp() instanceof InstanceFieldRef) {
                                Set<AllocNode> baseNodes = 
                                        GeoPTA.v().getPTSetEventContext(
                                            ((InstanceFieldRef)a.getLeftOp()).getBase(), 
                                            context);
                                for (AllocNode node : baseNodes) {
                                    System.out.println("  baseNode: " + node);
                                }
                            }
                            /*  System.out.println("Ins LHS: ");
                        for (AllocNode node : GeoPTA.v().getPTSetContextIns(a.getLeftOp()))
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
