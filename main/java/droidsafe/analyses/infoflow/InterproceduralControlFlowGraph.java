package droidsafe.analyses.infoflow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

import soot.Scene;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.CaughtExceptionRef;
import soot.jimple.IdentityStmt;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.callgraph.TopologicalOrderer;
import soot.toolkits.graph.Block;
import soot.toolkits.graph.BlockGraph;
import soot.toolkits.graph.DirectedGraph;
import soot.util.dot.DotGraph;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.pta.ContextType;
import droidsafe.analyses.pta.PTAContext;
import droidsafe.analyses.pta.cg.CGContextVisitor;
import droidsafe.analyses.pta.cg.CallGraphTraversal;
import droidsafe.main.Config;
import droidsafe.utils.SootUtils;

/**
 * This class represents a control flow graph for a whole program.
 */

public class InterproceduralControlFlowGraph implements DirectedGraph<Block> {
    private final List<Block> headBlocks;

    private final Map<Block, List<Block>> blockToFollowingBlocks;
    private final Map<Block, List<Block>> blockToPrecedingBlocks;
    private final List<Block> blocks;

    public final Map<SootMethod, List<Block>> methodToHeadBlocks;
    private final Map<SootMethod, List<Block>> methodToTailBlocks;
    public final Map<SootMethod, List<Block>> methodToBlocks;
    
    public final Map<Unit, Block> unitToBlock;

    public final Map<SootMethod, Set<Edge>> methodToEntryEdges;
    
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
        return headBlocks;
    }

    @Override
    public List<Block> getTails() {
        throw new UnsupportedOperationException("InterproceduralControlFlowGraph::getTails()");
    }

    @Override
    public List<Block> getPredsOf(Block block) {
        return blockToPrecedingBlocks.get(block);
    }

    @Override
    public List<Block> getSuccsOf(Block block) {
        return blockToFollowingBlocks.get(block);
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
        StringBuffer buffer = new StringBuffer();
        buffer.append("({");
        for (Block block : blocks) {
            buffer.append(block.getBody().getMethod() + ": " + block + ", ");
        }
        buffer.append("}, {");
        for (Block curr : blocks) {
            for (Block succ : blockToFollowingBlocks.get(curr)) {
                buffer.append("(" + curr.getBody().getMethod() + ": " + curr + ", " + succ.getBody().getMethod() + ": " + succ + "), ");
            }
        }
        buffer.append("})");
        return buffer.toString();
    }

    public DotGraph toDotGraph() {
        DotGraph graph = new DotGraph("Interprocedural Control Flow Graph");
        for (Block block : blocks) {
            String blockString = blockToString(block);
            graph.drawNode(blockString);
            for (Block followingBlock : blockToFollowingBlocks.get(block)) {
                graph.drawEdge(blockString, blockToString(followingBlock));
            }
        }
        return graph;
    }

    public Graph<Block, DefaultEdge> toJGraphT() {
        DefaultDirectedGraph<Block, DefaultEdge> graph = new DefaultDirectedGraph<Block, DefaultEdge>(DefaultEdge.class);
        for (Block block : blocks) {
            graph.addVertex(block);
            for (Block followingBlock : blockToFollowingBlocks.get(block)) {
                graph.addVertex(followingBlock);
                graph.addEdge(block, followingBlock);
            }
        }
        return graph;
    }

    public Graph<Block, DefaultEdge> toJGraphT(SootMethod method) {
        DefaultDirectedGraph<Block, DefaultEdge> graph = new DefaultDirectedGraph<Block, DefaultEdge>(DefaultEdge.class);
        for (Block block : methodToBlocks.get(method)) {
            graph.addVertex(block);
            for (Block precedingBlock : blockToPrecedingBlocks.get(block)) {
                graph.addVertex(precedingBlock);
                graph.addEdge(precedingBlock, block);
            }
            for (Block followingBlock : blockToFollowingBlocks.get(block)) {
                graph.addVertex(followingBlock);
                graph.addEdge(block, followingBlock);
            }
        }
        return graph;
    }

    public Block getPrecedingCallBlock(Block fallThroughBlock, SootMethod method) {
        for (Block precedingBlock : blockToPrecedingBlocks.get(fallThroughBlock)) {
            if (((Stmt)precedingBlock.getTail()).containsInvokeExpr() && precedingBlock.getBody().getMethod().equals(method)) {
                return precedingBlock;
            }
        }
        return null;
    }

    public Block getFallThrough(Block callerBlock) {
        if (Config.v().strict) {
            assert ((Stmt)callerBlock.getTail()).containsInvokeExpr();
        }
        SootMethod method = callerBlock.getBody().getMethod();
        for (Block followingBlock : blockToFollowingBlocks.get(callerBlock)) {
            if (followingBlock.getBody().getMethod().equals(method) && !methodToHeadBlocks.get(method).contains(followingBlock)) {
                return followingBlock;
            }
        }
        return null;
    }

    public static boolean containsCaughtExceptionRef(Unit unit) {
        return (unit instanceof IdentityStmt) && (((IdentityStmt)unit).getRightOp() instanceof CaughtExceptionRef);
    }

    private InterproceduralControlFlowGraph() {
        headBlocks = new ArrayList<Block>();

        blockToFollowingBlocks = new HashMap<Block, List<Block>>();
        blockToPrecedingBlocks = new HashMap<Block, List<Block>>();
        blocks = new ArrayList<Block>();

        methodToHeadBlocks = new HashMap<SootMethod, List<Block>>();
        methodToTailBlocks = new HashMap<SootMethod, List<Block>>();
        methodToBlocks = new HashMap<SootMethod, List<Block>>();

        unitToBlock = new HashMap<Unit, Block>();

        collectIntraproceduralControlFlowGraphs();
        connectIntraproceduralControlFlowGraphs();
        
        methodToEntryEdges = new DefaultHashMap<SootMethod, Set<Edge>>(Collections.<Edge>emptySet());
        CallGraphTraversal.acceptContext(new CGContextVisitor () {
            @Override
            public void visit(SootMethod method, PTAContext eventContext) {
                Set<Edge> entryEdges = methodToEntryEdges.get(method);
                if (entryEdges.isEmpty()) {
                    entryEdges = new HashSet<Edge>();
                }
                entryEdges.add(eventContext.getContext());
                methodToEntryEdges.put(method, entryEdges);
            }
        }, ContextType.EVENT_CONTEXT);
    }

    private void collectIntraproceduralControlFlowGraphs() {
        Set<SootMethod> reachableMethods = PTABridge.v().getAllReachableMethods();
        List<SootMethod> entryPoints = Scene.v().getEntryPoints();
        TopologicalOrderer topologicalOrderer = new TopologicalOrderer(Scene.v().getCallGraph());
        topologicalOrderer.go();
        for (SootMethod method : Lists.reverse(topologicalOrderer.order())) {
            if (reachableMethods.contains(method)) {
                if (method.hasActiveBody() && !SootUtils.isRuntimeStubMethod(method)) {
                    BlockGraph blockGraph = new MyBriefBlockGraph(method.getActiveBody());
                    if (entryPoints.contains(method)) {
                        headBlocks.addAll(blockGraph.getHeads());
                    }
                    for (Block block : blockGraph) {
                        blockToFollowingBlocks.put(block, new ArrayList<Block>(blockGraph.getSuccsOf(block)));
                        blockToPrecedingBlocks.put(block, new ArrayList<Block>(blockGraph.getPredsOf(block)));
                        blocks.add(block);
                        Iterator<Unit> it = block.iterator();
                        while (it.hasNext()) {
                            unitToBlock.put(it.next(), block);
                        }
                    }
                    methodToHeadBlocks.put(method, blockGraph.getHeads());
                    methodToTailBlocks.put(method, blockGraph.getTails());
                    methodToBlocks.put(method, blockGraph.getBlocks());
                } else {
                    logger.info(method + ": no active body");
                }
            }
        }
        //G.v().out.println("Number of Units = " + unitToBlock.keySet().size());
    }

    private void connectIntraproceduralControlFlowGraphs() {
        CallGraph callGraph = Scene.v().getCallGraph();
        for (Block block : blocks) {
            Unit tailUnit = block.getTail();
            if (((Stmt)tailUnit).containsInvokeExpr()) {
                Block followingBlock = null;
                followingBlock = blockToFollowingBlocks.get(block).get(0);
                if (Config.v().strict) {
                    assert !containsCaughtExceptionRef(followingBlock.getHead());
                }
                if (Config.v().strict) {
                    assert block.getBody().getMethod().equals(followingBlock.getBody().getMethod());
                }
                Iterator<Edge> edges = callGraph.edgesOutOf(tailUnit);
                while (edges.hasNext()) {
                    Edge edge = edges.next();
                    // HACK: our model calls <clinit> explicitly, using staticinvoke.
                    if (edge.isClinit()) {
                        continue;
                    }
                    SootMethod calleeMethod = (SootMethod)edge.getTgt();
                    if (ObjectUtils.v().isGetTaint(calleeMethod) || ObjectUtils.v().isAddTaint(calleeMethod)) {
                        continue;
                    }
                    if (SootUtils.isRuntimeStubMethod(calleeMethod)) {
                        continue;
                    }
                    if (methodToHeadBlocks.containsKey(calleeMethod)) {
                        List<Block> headBlocks = methodToHeadBlocks.get(calleeMethod);
                        for (Block headBlock : headBlocks) {
                            if (!containsCaughtExceptionRef(headBlock.getHead())) {
                                if (!blockToFollowingBlocks.get(block).contains(headBlock)) {
                                    blockToFollowingBlocks.get(block).add(headBlock);
                                }
                                if (!blockToPrecedingBlocks.get(headBlock).contains(block)) {
                                    blockToPrecedingBlocks.get(headBlock).add(block);
                                }
                            }
                        }
                        // XXX: is the following statement valid for a recursive call?
                        this.headBlocks.removeAll(headBlocks);
                        for (Block tailBlock : methodToTailBlocks.get(calleeMethod)) {
                            if (!blockToFollowingBlocks.get(tailBlock).contains(followingBlock)) {
                                blockToFollowingBlocks.get(tailBlock).add(followingBlock);
                            }
                            if (!blockToPrecedingBlocks.get(followingBlock).contains(tailBlock)) {
                                blockToPrecedingBlocks.get(followingBlock).add(tailBlock);
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
