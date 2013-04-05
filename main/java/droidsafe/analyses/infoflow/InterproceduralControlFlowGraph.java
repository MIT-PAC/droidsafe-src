package droidsafe.analyses.infoflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.PatchingChain;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.CaughtExceptionRef;
import soot.jimple.IdentityStmt;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Targets;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.util.Chain;
import soot.util.HashChain;
import soot.util.dot.DotGraph;

/**
 * This class represents a control flow graph for a whole program.
 */

public class InterproceduralControlFlowGraph implements DirectedGraph<Unit> {
    public final Map<Unit, SootMethod> unitToMethod;

    private final List<Unit> heads;

    private final Map<Unit, List<Unit>> unitToSuccs;
    private final Map<Unit, List<Unit>> unitToPreds;
    private final Chain<Unit> unitChain;

    private final Map<SootMethod, List<Unit>> methodToHeads;
    private final Map<SootMethod, List<Unit>> methodToTails;

    private static InterproceduralControlFlowGraph v;

    private final static Logger logger = LoggerFactory.getLogger(InterproceduralControlFlowGraph.class);

    public static InterproceduralControlFlowGraph v() {
        return v;
    }

    public static void run() {
        v = new InterproceduralControlFlowGraph();
    }

    @Override
    public List<Unit> getHeads() {
        return heads;
    }

    @Override
    public List<Unit> getTails() {
        throw new UnsupportedOperationException("InterproceduralControlFlowGraph::getTails()");
    }

    @Override
    public List<Unit> getPredsOf(Unit unit) {
        return unitToPreds.get(unit);
    }

    @Override
    public List<Unit> getSuccsOf(Unit unit) {
        return unitToSuccs.get(unit);
    }

    @Override
    public int size() {
        return unitChain.size();
    }

    @Override
    public Iterator<Unit> iterator() {
        return unitChain.iterator();
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("({");
        for (Unit unit : unitChain) {
            buf.append(unitToMethod.get(unit) + ": " + unit + ", ");
        }
        buf.append("}, {");
        for (Unit curr : unitChain) {
            for (Unit succ : unitToSuccs.get(curr)) {
                buf.append("(" + unitToMethod.get(curr) + ": " + curr + ", " + unitToMethod.get(succ) + ": " + succ + "), ");
            }
        }
        buf.append("})");
        return buf.toString();
    }

    /**
     * Returns the {@link soot.util.dot.DotGraph DotGraph} representation of the graph.
     *
     * @return the {@link soot.util.dot.DotGraph DotGraph} representation of the graph
     */
    public DotGraph toDotGraph() {
        DotGraph graph = new DotGraph("Interprocedural Control Flow Graph");
        for (Unit src : unitChain) {
            String s = unitToString(src);
            graph.drawNode(s);
            for (Unit tgt : unitToSuccs.get(src)) {
                graph.drawEdge(s, unitToString(tgt));
            }
        }
        return graph;
    }

    public Graph<Unit, DefaultEdge> toJGrapthT() {
        DefaultDirectedGraph<Unit, DefaultEdge> graph = new DefaultDirectedGraph<Unit, DefaultEdge>(DefaultEdge.class);
        for (Unit src : unitChain) {
            graph.addVertex(src);
            for (Unit tgt : unitToSuccs.get(src)) {
                graph.addVertex(tgt);
                graph.addEdge(src, tgt);
            }
        }
        return graph;
    }

    Unit getPrecedingCallStmt(Unit fallThroughStmt, SootMethod method) {
        for (Unit pred : unitToPreds.get(fallThroughStmt)) {
            if (((Stmt)pred).containsInvokeExpr() && unitToMethod.get(pred).equals(method)) {
                return pred;
            }
        }
        return null;
    }

    static boolean containsCaughtExceptionRef(Unit unit) {
        return (unit instanceof IdentityStmt) && (((IdentityStmt)unit).getRightOp() instanceof CaughtExceptionRef);
    }

    private InterproceduralControlFlowGraph() {
        heads = new ArrayList<Unit>();

        unitToSuccs = new HashMap<Unit, List<Unit>>();
        unitToPreds = new HashMap<Unit, List<Unit>>();
        unitChain = new PatchingChain<Unit>(new HashChain<Unit>());

        methodToHeads = new HashMap<SootMethod, List<Unit>>();
        methodToTails = new HashMap<SootMethod, List<Unit>>();

        unitToMethod = new HashMap<Unit, SootMethod>();

        collectIntraproceduralControlFlowGraphs();
        connectIntraproceduralControlFlowGraphs();
    }

    private void collectIntraproceduralControlFlowGraphs() {
        List<SootMethod> entryPoints = Scene.v().getEntryPoints();
        for (SootClass clz : Scene.v().getApplicationClasses()) {
            for (SootMethod method : clz.getMethods()) {
                if (method.hasActiveBody()) {
                    UnitGraph unitGraph = new ExceptionalUnitGraph(method.getActiveBody());
                    if (entryPoints.contains(method)) {
                        heads.addAll(unitGraph.getHeads());
                    }
                    for (Unit unit : unitGraph) {
                        unitToSuccs.put(unit, new ArrayList<Unit>(unitGraph.getSuccsOf(unit)));
                        unitToPreds.put(unit, new ArrayList<Unit>(unitGraph.getPredsOf(unit)));
                        unitChain.add(unit);
                        unitToMethod.put(unit, method);
                    }
                    methodToHeads.put(method, unitGraph.getHeads());
                    methodToTails.put(method, unitGraph.getTails());
                } else {
                    logger.warn(method + ": no active body");
                }
            }
        }
    }

    private void connectIntraproceduralControlFlowGraphs() {
        CallGraph cg = Scene.v().getCallGraph();
        for (Unit curr : unitChain) {
            if (((Stmt)curr).containsInvokeExpr()) {
                Unit succ = null;
                // XXX: assuming that there is only one fall-through and that the others are "$r0 := @caughtexception"
                for (Unit s : unitToSuccs.get(curr)) {
                    if (!containsCaughtExceptionRef(s)) {
                        succ = s;
                        break;
                    }
                }
                assert(succ != null);
                Targets tgts = new Targets(cg.edgesOutOf(curr));
                while (tgts.hasNext()) {
                    SootMethod method = tgts.next().method();
                    if (methodToHeads.containsKey(method)) {
                        List<Unit> heads = methodToHeads.get(method);
                        for (Unit head : heads) {
                            if (!containsCaughtExceptionRef(head)) {
                                unitToSuccs.get(curr).add(head);
                                unitToPreds.get(head).add(curr);
                            }
                        }
                        this.heads.removeAll(heads);
                        for (Unit tail : methodToTails.get(method)) {
                            unitToSuccs.get(tail).add(succ);
                            unitToPreds.get(succ).add(tail);
                        }
                    }
                }
            }
        }
    }

    private String unitToString(Unit unit) {
        // XXX: If we are very unlucky, two different statements may be mapped to the same string under the following naming scheme.
        return unitToMethod.get(unit) + "\\n" + unit + "\\n[" + System.identityHashCode(unit) + "]";
    }
}
