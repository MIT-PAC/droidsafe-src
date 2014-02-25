package droidsafe.analyses.infoflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.MethodOrMethodContext;
import soot.Scene;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
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

    private static InterproceduralControlFlowGraph v;

    private final static Logger logger = LoggerFactory.getLogger(InterproceduralControlFlowGraph.class);

    public static InterproceduralControlFlowGraph v() {
        return InterproceduralControlFlowGraph.v;
    }

    public static void run() {
        InterproceduralControlFlowGraph.v = new InterproceduralControlFlowGraph();
    }

    @Override
    public List<Block> getHeads() {
        return this.headBlocks;
    }

    @Override
    public List<Block> getTails() {
        throw new UnsupportedOperationException("InterproceduralControlFlowGraph::getTails()");
    }

    @Override
    public List<Block> getPredsOf(Block block) {
        return this.blockToPrecedingBlocks.get(block);
    }

    @Override
    public List<Block> getSuccsOf(Block block) {
        return this.blockToFollowingBlocks.get(block);
    }

    @Override
    public int size() {
        return this.blocks.size();
    }

    @Override
    public Iterator<Block> iterator() {
        return this.blocks.iterator();
    }

    public DotGraph toDotGraph() {
        DotGraph graph = new DotGraph("Interprocedural Control Flow Graph");
        for (Block block : this.blocks) {
            String blockString = blockToString(block);
            graph.drawNode(blockString);
            List<Block> followingBlocks = this.blockToFollowingBlocks.get(block);
            for (Block followingBlock : followingBlocks) {
                graph.drawEdge(blockString, blockToString(followingBlock));
            }
        }
        return graph;
    }

    public Graph<Block, DefaultEdge> toJGraphT() {
        DefaultDirectedGraph<Block, DefaultEdge> graph = new DefaultDirectedGraph<Block, DefaultEdge>(DefaultEdge.class);
        for (Block block : this.blocks) {
            graph.addVertex(block);
            List<Block> followingBlocks = this.blockToFollowingBlocks.get(block);
            for (Block followingBlock : followingBlocks) {
                graph.addVertex(followingBlock);
                graph.addEdge(block, followingBlock);
            }
        }
        return graph;
    }

    public Graph<Block, DefaultEdge> toJGraphT(SootMethod method) {
        DefaultDirectedGraph<Block, DefaultEdge> graph = new DefaultDirectedGraph<Block, DefaultEdge>(DefaultEdge.class);
        List<Block> blocks = this.methodToBlocks.get(method);
        for (Block block : blocks) {
            graph.addVertex(block);
            List<Block> precedingBlocks = this.blockToPrecedingBlocks.get(block);
            for (Block precedingBlock : precedingBlocks) {
                graph.addVertex(precedingBlock);
                graph.addEdge(precedingBlock, block);
            }
            List<Block> followingBlocks = this.blockToFollowingBlocks.get(block);
            for (Block followingBlock : followingBlocks) {
                graph.addVertex(followingBlock);
                graph.addEdge(block, followingBlock);
            }
        }
        return graph;
    }

    public Block getFallThroughBlock(Block callerBlock) {
        if (Config.v().strict) {
            assert ((Stmt)callerBlock.getTail()).containsInvokeExpr();
        }
        Body callerBody = callerBlock.getBody();
        SootMethod callerMethod = callerBody.getMethod();
        List<Block> followingBlocks = this.blockToFollowingBlocks.get(callerBlock);
        for (Block followingBlock : followingBlocks) {
            Body followingBody = followingBlock.getBody();
            SootMethod followingMethod = followingBody.getMethod();
            if (followingMethod.equals(callerMethod)) {
                List<Block> headBlocks = this.methodToHeadBlocks.get(callerMethod);
                if (!(headBlocks.contains(followingBlock))) {
                    return followingBlock;
                }
            }
        }
        return null;
    }

    public static boolean containsCaughtExceptionRef(Unit unit) {
        if (!(unit instanceof IdentityStmt)) {
            return false;
        }
        Value value = ((IdentityStmt)unit).getRightOp();
        return value instanceof CaughtExceptionRef;
    }

    private InterproceduralControlFlowGraph() {
        this.headBlocks = new ArrayList<Block>();

        this.blockToFollowingBlocks = new HashMap<Block, List<Block>>();
        this.blockToPrecedingBlocks = new HashMap<Block, List<Block>>();
        this.blocks = new ArrayList<Block>();

        this.methodToHeadBlocks = new HashMap<SootMethod, List<Block>>();
        this.methodToTailBlocks = new HashMap<SootMethod, List<Block>>();
        this.methodToBlocks = new HashMap<SootMethod, List<Block>>();

        this.unitToBlock = new HashMap<Unit, Block>();

        collectIntraproceduralControlFlowGraphs();
        connectIntraproceduralControlFlowGraphs();
    }

    private void collectIntraproceduralControlFlowGraphs() {
        Set<SootMethod> reachableMethods = PTABridge.v().getReachableMethods();
        List<SootMethod> entryPoints = Scene.v().getEntryPoints();
        CallGraph callGraph = Scene.v().getCallGraph();
        TopologicalOrderer topologicalOrderer = new TopologicalOrderer(callGraph);
        topologicalOrderer.go();
        List<MethodOrMethodContext> topologicallyOrderedMethods = topologicalOrderer.order();
        List<MethodOrMethodContext> reverseTopologicallyOrderedMethods = Lists.reverse(topologicallyOrderedMethods);
        for (MethodOrMethodContext methodContext : reverseTopologicallyOrderedMethods) {
            SootMethod method = methodContext.method();
            if (this.methodToBlocks.containsKey(method)) {
                continue;
            }
            if (reachableMethods.contains(method)) {
                if (method.hasActiveBody() && !(SootUtils.isRuntimeStubMethod(method)) && !(ObjectUtils.v().isAddTaint(method)) && !(ObjectUtils.v().isGetTaint(method))) {
                    Body body = method.getActiveBody();
                    BlockGraph blockGraph = new MyBriefBlockGraph(body);
                    if (entryPoints.contains(method)) {
                        List<Block> headBlocks = blockGraph.getHeads();
                        this.headBlocks.addAll(headBlocks);
                    }
                    for (Block block : blockGraph) {
                        List<Block> followingBlocks = blockGraph.getSuccsOf(block);
                        this.blockToFollowingBlocks.put(block, new ArrayList<Block>(followingBlocks));
                        List<Block> precedingBlocks = blockGraph.getPredsOf(block);
                        this.blockToPrecedingBlocks.put(block, new ArrayList<Block>(precedingBlocks));
                        this.blocks.add(block);
                        Iterator<Unit> units = block.iterator();
                        while (units.hasNext()) {
                            this.unitToBlock.put(units.next(), block);
                        }
                    }
                    List<Block> headBlocks = blockGraph.getHeads();
                    this.methodToHeadBlocks.put(method, headBlocks);
                    List<Block> tailBlocks = blockGraph.getTails();
                    this.methodToTailBlocks.put(method, tailBlocks);
                    List<Block> blocks = blockGraph.getBlocks();
                    this.methodToBlocks.put(method, blocks);
                } else {
                    InterproceduralControlFlowGraph.logger.info(method + ": no active body");
                }
            }
        }
    }

    private void connectIntraproceduralControlFlowGraphs() {
        CallGraph callGraph = Scene.v().getCallGraph();
        for (Block block : this.blocks) {
            Unit tailUnit = block.getTail();
            if (((Stmt)tailUnit).containsInvokeExpr()) {
                List<Block> followingBlocks = this.blockToFollowingBlocks.get(block);
                if (Config.v().strict) {
                    assert followingBlocks.size() == 1;
                }
                Block fallThroughBlock = followingBlocks.get(0);
                if (Config.v().strict) {
                    assert !(containsCaughtExceptionRef(fallThroughBlock.getHead()));
                }
                if (Config.v().strict) {
                    assert block.getBody().getMethod().equals(fallThroughBlock.getBody().getMethod());
                }
                Iterator<Edge> callEdges = callGraph.edgesOutOf(tailUnit);
                while (callEdges.hasNext()) {
                    Edge callEdge = callEdges.next();
                    // HACK: our model calls <clinit> explicitly, using staticinvoke.
                    if (callEdge.isClinit()) {
                        continue;
                    }
                    MethodOrMethodContext calleeMethodContext = callEdge.getTgt();
                    SootMethod calleeMethod = calleeMethodContext.method();
                    if (ObjectUtils.v().isGetTaint(calleeMethod) || ObjectUtils.v().isAddTaint(calleeMethod)) {
                        continue;
                    }
                    if (SootUtils.isRuntimeStubMethod(calleeMethod)) {
                        continue;
                    }
                    if (this.methodToHeadBlocks.containsKey(calleeMethod)) {
                        List<Block> calleeHeadBlocks = this.methodToHeadBlocks.get(calleeMethod);
                        for (Block calleeHeadBlock : calleeHeadBlocks) {
                            Unit calleeHeadUnit = calleeHeadBlock.getHead();
                            if (!(containsCaughtExceptionRef(calleeHeadUnit))) {
                                if (!(followingBlocks.contains(calleeHeadBlock))) {
                                    followingBlocks.add(calleeHeadBlock);
                                }
                                List<Block> calleePrecedingBlocks = this.blockToPrecedingBlocks.get(calleeHeadBlock);
                                if (!(calleePrecedingBlocks.contains(block))) {
                                    calleePrecedingBlocks.add(block);
                                }
                            }
                        }
                        // XXX: is the following statement valid for a recursive call?
                        this.headBlocks.removeAll(calleeHeadBlocks);
                        List<Block> calleeTailBlocks = this.methodToTailBlocks.get(calleeMethod);
                        for (Block calleeTailBlock : calleeTailBlocks) {
                            List<Block> calleeTailFollowingBlocks = this.blockToFollowingBlocks.get(calleeTailBlock);
                            if (!(calleeTailFollowingBlocks.contains(fallThroughBlock))) {
                                calleeTailFollowingBlocks.add(fallThroughBlock);
                            }
                            List<Block> fallThroughPrecedingBlocks = this.blockToPrecedingBlocks.get(fallThroughBlock);
                            if (!(fallThroughPrecedingBlocks.contains(calleeTailBlock))) {
                                fallThroughPrecedingBlocks.add(calleeTailBlock);
                            }
                        }
                    }
                }
            }
        }
    }

    private String blockToString(Block block) {
        // XXX: If we are very unlucky, two different statements may be mapped to the same string under the following naming scheme.
        Body body = block.getBody();
        SootMethod method = body.getMethod();
        int id = System.identityHashCode(block);
        return method + "\\n" + block.toString().replaceAll("\n", "\\\\n") + "[" + id + "]";
    }
}
