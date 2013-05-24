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

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.CaughtExceptionRef;
import soot.jimple.IdentityStmt;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Targets;
import soot.toolkits.graph.Block;
import soot.toolkits.graph.BlockGraph;
import soot.toolkits.graph.DirectedGraph;
import soot.util.dot.DotGraph;

/**
 * This class represents a control flow graph for a whole program.
 */

public class InterproceduralControlFlowGraph implements DirectedGraph<Block> {
    private final List<Block> heads;

    private final Map<Block, List<Block>> blockToSuccs;
    private final Map<Block, List<Block>> blockToPreds;
    private final List<Block> blocks;

    private final Map<SootMethod, List<Block>> methodToHeads;
    private final Map<SootMethod, List<Block>> methodToTails;
    public final Map<SootMethod, List<Block>> methodToBlocks;

    public final Map<Unit, Block> unitToBlock;

    private static InterproceduralControlFlowGraph v;

    private final static Logger logger = LoggerFactory.getLogger(InterproceduralControlFlowGraph.class);

    public static InterproceduralControlFlowGraph v() {
        return v;
    }

    public static void run() {
        v = new InterproceduralControlFlowGraph();
    }

    @Override
    public List<Block> getHeads() {
        return heads;
    }

    @Override
    public List<Block> getTails() {
        throw new UnsupportedOperationException("InterproceduralControlFlowGraph::getTails()");
    }

    @Override
    public List<Block> getPredsOf(Block block) {
        return blockToPreds.get(block);
    }

    @Override
    public List<Block> getSuccsOf(Block block) {
        return blockToSuccs.get(block);
    }

    @Override
    public int size() {
        return blocks.size();
    }

    @Override
    public Iterator<Block> iterator() {
        return blocks.iterator();
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("({");
        for (Block block : blocks) {
            buf.append(block.getBody().getMethod() + ": " + block + ", ");
        }
        buf.append("}, {");
        for (Block curr : blocks) {
            for (Block succ : blockToSuccs.get(curr)) {
                buf.append("(" + curr.getBody().getMethod() + ": " + curr + ", " + succ.getBody().getMethod() + ": " + succ + "), ");
            }
        }
        buf.append("})");
        return buf.toString();
    }

    public DotGraph toDotGraph() {
        DotGraph graph = new DotGraph("Interprocedural Control Flow Graph");
        for (Block src : blocks) {
            String s = blockToString(src);
            graph.drawNode(s);
            for (Block tgt : blockToSuccs.get(src)) {
                graph.drawEdge(s, blockToString(tgt));
            }
        }
        return graph;
    }

    public Graph<Block, DefaultEdge> toJGraphT() {
        DefaultDirectedGraph<Block, DefaultEdge> graph = new DefaultDirectedGraph<Block, DefaultEdge>(DefaultEdge.class);
        for (Block block : blocks) {
            graph.addVertex(block);
            for (Block succ : blockToSuccs.get(block)) {
                graph.addVertex(succ);
                graph.addEdge(block, succ);
            }
        }
        return graph;
    }

    public Graph<Block, DefaultEdge> toJGraphT(SootMethod method) {
        DefaultDirectedGraph<Block, DefaultEdge> graph = new DefaultDirectedGraph<Block, DefaultEdge>(DefaultEdge.class);
        for (Block curr : methodToBlocks.get(method)) {
            graph.addVertex(curr);
            for (Block pred : blockToPreds.get(curr)) {
                graph.addVertex(pred);
                graph.addEdge(pred, curr);
            }
            for (Block succ : blockToSuccs.get(curr)) {
                graph.addVertex(succ);
                graph.addEdge(curr, succ);
            }
        }
        return graph;
    }

    public Block getPrecedingCallBlock(Block fallThroughBlock, SootMethod method) {
        for (Block pred : blockToPreds.get(fallThroughBlock)) {
            if (((Stmt)pred.getTail()).containsInvokeExpr() && pred.getBody().getMethod().equals(method)) {
                return pred;
            }
        }
        return null;
    }

    public static boolean containsCaughtExceptionRef(Unit unit) {
        return (unit instanceof IdentityStmt) && (((IdentityStmt)unit).getRightOp() instanceof CaughtExceptionRef);
    }

    private InterproceduralControlFlowGraph() {
        heads = new ArrayList<Block>();

        blockToSuccs = new HashMap<Block, List<Block>>();
        blockToPreds = new HashMap<Block, List<Block>>();
        blocks = new ArrayList<Block>();

        methodToHeads = new HashMap<SootMethod, List<Block>>();
        methodToTails = new HashMap<SootMethod, List<Block>>();
        methodToBlocks = new HashMap<SootMethod, List<Block>>();

        unitToBlock = new HashMap<Unit, Block>();

        collectIntraproceduralControlFlowGraphs();
        connectIntraproceduralControlFlowGraphs();
    }

    private void collectIntraproceduralControlFlowGraphs() {
        List<SootMethod> entryPoints = Scene.v().getEntryPoints();
        for (SootClass clz : Scene.v().getApplicationClasses()) {
            for (SootMethod method : clz.getMethods()) {
                if (method.hasActiveBody()) {
                    BlockGraph blockGraph = new MyBriefBlockGraph(method.getActiveBody());
                    if (entryPoints.contains(method)) {
                        heads.addAll(blockGraph.getHeads());
                    }
                    for (Block block : blockGraph) {
                        blockToSuccs.put(block, new ArrayList<Block>(blockGraph.getSuccsOf(block)));
                        blockToPreds.put(block, new ArrayList<Block>(blockGraph.getPredsOf(block)));
                        blocks.add(block);
                        Iterator<Unit> it = block.iterator();
                        while (it.hasNext()) {
                            unitToBlock.put(it.next(), block);
                        }
                    }
                    methodToHeads.put(method, blockGraph.getHeads());
                    methodToTails.put(method, blockGraph.getTails());
                    methodToBlocks.put(method, blockGraph.getBlocks());
                } else {
                    logger.info(method + ": no active body");
                }
            }
        }
    }

    private void connectIntraproceduralControlFlowGraphs() {
        CallGraph cg = Scene.v().getCallGraph();
        for (Block curr : blocks) {
            if (((Stmt)curr.getTail()).containsInvokeExpr()) {
                Block succ = null;
                // XXX: assuming that there is only one fall-through and that the others are "$r0 := @caughtexception"
                for (Block s : blockToSuccs.get(curr)) {
                    if (!containsCaughtExceptionRef(s.getHead())) {
                        succ = s;
                        break;
                    }
                }
                assert(succ != null);
                Targets tgts = new Targets(cg.edgesOutOf(curr.getTail()));
                while (tgts.hasNext()) {
                    SootMethod method = tgts.next().method();
                    if (methodToHeads.containsKey(method)) {
                        List<Block> heads = methodToHeads.get(method);
                        for (Block head : heads) {
                            if (!containsCaughtExceptionRef(head.getHead())) {
                                if (!blockToSuccs.get(curr).contains(head)) {
                                    blockToSuccs.get(curr).add(head);
                                }
                                if (!blockToPreds.get(head).contains(curr)) {
                                    blockToPreds.get(head).add(curr);
                                }
                            }
                        }
                        this.heads.removeAll(heads);
                        for (Block tail : methodToTails.get(method)) {
                            if (!blockToSuccs.get(tail).contains(succ)) {
                                blockToSuccs.get(tail).add(succ);
                            }
                            if (!blockToPreds.get(succ).contains(tail)) {
                                blockToPreds.get(succ).add(tail);
                            }
                        }
                    }
                }
            }
        }
    }

    private String blockToString(Block block) {
        // XXX: If we are very unlucky, two different statements may be mapped to the same string under the following naming scheme.
        return block.getBody().getMethod() + "\\n" + block.toString().replaceAll("\n", "\\\\n") + "[" + System.identityHashCode(block) + "]";
    }
}
