package droidsafe.analyses;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.SootMethod;
import soot.jimple.AssignStmt;
import soot.jimple.CastExpr;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.NullConstant;
import soot.jimple.Stmt;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.Edge;
import droidsafe.analyses.helper.CallGraphContextVisitor;
import droidsafe.analyses.helper.CallGraphTraversal;
import droidsafe.utils.SootUtils;

/**
 * Hacked up testing pass for the PTA and the call graph traversal.
 * 
 * @author mgordon
 *
 */
public class TestPTA implements CallGraphContextVisitor {
    /** Logger field */
    private static final Logger logger = LoggerFactory.getLogger(TestPTA.class);

    public TestPTA() {
        // TODO Auto-generated constructor stub
        CallGraphTraversal.accept(this);
    }

    @Override
    public void visit(SootMethod method, Edge context, Edge edgeInto) {
        // TODO Auto-generated method stub
        testMethod(method, context, edgeInto);
    }

    private void testMethod(SootMethod sm, Edge context, Edge edgeInto) {
        //logger.info("Test Method: " + sm);
        /*logger.info("context: " + context);
        logger.info("Edge into: " + edgeInto);
        logger.info("Context context: " + context.srcCtxt());
        logger.info("Stmt: " + context.srcStmt());
        logger.info();
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
                /*
                logger.info("Instance Invoke: " + st);
                logger.info("Context: " + context);
                for (AllocNode node : GeoPTA.v().getPTSet(iie.getBase(), context)) 
                    logger.info("  " + node);
                
                for (AllocNode node : GeoPTA.v().getPTSetContextIns((iie.getBase()))) 
                    logger.info("  Ins: " + node);
                
                logger.info();
                */
            } else  if (st instanceof AssignStmt) {

                AssignStmt a = (AssignStmt) st;
                try {
                    if (GeoPTA.v().isPointer(a.getLeftOp())) {
                        Set<AllocNode> lhsNodes = GeoPTA.v().getPTSet(a.getLeftOp(), context);

                        Set<AllocNode> rhsNodes = null;
                        if (GeoPTA.v().isPointer(a.getRightOp())) {
                            rhsNodes = GeoPTA.v().getPTSet(a.getRightOp(), context);
                        } else if (GeoPTA.v().getAllocNode(a.getRightOp()) != null) {
                            rhsNodes = new LinkedHashSet<AllocNode>();
                            rhsNodes.add(GeoPTA.v().getAllocNode(a.getRightOp()));
                        } else if (a.getRightOp() instanceof CastExpr) {
                            CastExpr castExpr = (CastExpr)a.getRightOp();
                            rhsNodes = GeoPTA.v().getPTSet(castExpr.getOp(), context);
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
                            logger.info("** Empty RHS: " + a.getRightOp());
                        }

                        if (!lhsNodes.containsAll(rhsNodes)) {
                            logger.info(sm + "\n" + st);
                            logger.info("  Context: " + context);
                            logger.info("RHS:");
                            for (AllocNode node : rhsNodes) 
                                logger.info("  " + node);
                            logger.info("LHS:");
                            for (AllocNode node : lhsNodes) 
                                logger.info("  " + node);
                            if (a.getLeftOp() instanceof InstanceFieldRef) {
                                Set<AllocNode> baseNodes = GeoPTA.v().getPTSet(((InstanceFieldRef)a.getLeftOp()).getBase(), 
                                    context);
                                for (AllocNode node : baseNodes) {
                                    logger.info("  baseNode: " + node);
                                }
                            }
                            /*  logger.info("Ins LHS: ");
                        for (AllocNode node : GeoPTA.v().getPTSetContextIns(a.getLeftOp()))
                            logger.info("  " + node);
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
