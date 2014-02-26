package droidsafe.analyses.infoflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;

import soot.Body;
import soot.MethodOrMethodContext;
import soot.Scene;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.TopologicalOrderer;
import soot.toolkits.graph.Block;
import soot.toolkits.graph.BlockGraph;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.utils.SootUtils;

/**
 * This class represents a control flow graph for a whole program.
 */

public class InterproceduralControlFlowGraph implements Iterable<Block> {
    private final List<Block> blocks = new ArrayList<Block>();

    public final Map<SootMethod, List<Block>> methodToBlocks = new HashMap<SootMethod, List<Block>>();
    
    public final Map<Unit, Block> unitToBlock = new HashMap<Unit, Block>();

    private static InterproceduralControlFlowGraph v;

    public static InterproceduralControlFlowGraph v() {
        return InterproceduralControlFlowGraph.v;
    }

    public static void run() {
        InterproceduralControlFlowGraph.v = new InterproceduralControlFlowGraph();
    }

    @Override
    public Iterator<Block> iterator() {
        return this.blocks.iterator();
    }

    private InterproceduralControlFlowGraph() {
        collectIntraproceduralControlFlowGraphs();
    }

    private void collectIntraproceduralControlFlowGraphs() {
        Set<SootMethod> reachableMethods = PTABridge.v().getReachableMethods();
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
                    List<Block> blocks = blockGraph.getBlocks();
                    this.blocks.addAll(blocks);
                    this.methodToBlocks.put(method, blocks);
                    for (Block block : blockGraph) {
                        Iterator<Unit> units = block.iterator();
                        while (units.hasNext()) {
                            Unit unit = units.next();
                            this.unitToBlock.put(unit, block);
                        }
                    }
                }
            }
        }
    }
}
