package droidsafe.analyses.infoflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import soot.PatchingChain;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Targets;
import soot.toolkits.graph.BriefUnitGraph;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.UnitGraph;
import soot.util.Chain;
import soot.util.HashChain;
import soot.util.dot.DotGraph;

/**
 * This class represents a control flow graph for a whole program.
 */

public class InterproceduralControlFlowGraph implements DirectedGraph<Unit> {
    private final List<Unit> heads;

    private final Map<Unit, List<Unit>> unitToSuccs;
    private final Map<Unit, List<Unit>> unitToPreds;
    private final Chain<Unit> unitChain;

    private final Map<SootMethod, List<Unit>> methodToHeads;
    private final Map<SootMethod, List<Unit>> methodToTails;

    private final Map<Unit, SootMethod> unitToMethod;

    private static InterproceduralControlFlowGraph v;

    public static InterproceduralControlFlowGraph v() {
        return v;
    }

    public static void run() {
        v = new InterproceduralControlFlowGraph();
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
                    UnitGraph unitGraph = new BriefUnitGraph(method.getActiveBody());
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
                }
            }
        }
    }

    private void connectIntraproceduralControlFlowGraphs() {
        CallGraph cg = Scene.v().getCallGraph();
        for (Unit unit : unitChain) {
            if (((Stmt)unit).containsInvokeExpr()) {
                Unit succ = unitToSuccs.get(unit).get(0);
                Targets tgts = new Targets(cg.edgesOutOf(unit));
                while (tgts.hasNext()) {
                    SootMethod method = tgts.next().method();
                    if (methodToHeads.containsKey(method)) {
                        for (Unit head : methodToHeads.get(method)) {
                            unitToSuccs.get(unit).add(head);
                            unitToPreds.get(head).add(unit);
                        }
                        for (Unit tail : methodToTails.get(method)) {
                            unitToSuccs.get(tail).add(succ);
                            unitToPreds.get(succ).add(tail);
                        }
                    }
                }
            }
        }
    }

    @Override
    public List<Unit> getHeads() {
        return heads;
    }

    @Override
    public List<Unit> getTails() {
        throw new UnsupportedOperationException();
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
        for (Unit unit : unitChain) {
            for (Unit succ : unitToSuccs.get(unit)) {
                buf.append("(" + unitToMethod.get(unit) + ": " + unit + ", " + unitToMethod.get(succ) + ": " + succ + "), ");
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
            // HACK: If we are very unlucky, two different statements may be mapped to the same node under the following naming scheme.
            String s = unitToMethod.get(src) + "\\n" + src + "\\n[" + System.identityHashCode(src) + "]";
            graph.drawNode(s);
            for (Unit tgt : unitToSuccs.get(src)) {
                // HACK: If we are very unlucky, two different statements may be mapped to the same node under the following naming scheme.
                String t = unitToMethod.get(tgt) + "\\n" + tgt + "\\n[" + System.identityHashCode(tgt) + "]";
                graph.drawEdge(s, t);
            }
        }
        return graph;
    }
}
