package droidsafe.analyses.infoflow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import soot.ArrayType;
import soot.G;
import soot.RefType;
import soot.SootField;
import soot.jimple.spark.pag.AllocDotField;
import soot.jimple.spark.pag.AllocNode;
import droidsafe.analyses.pta.PTABridge;

public class AllocNodeUtils {
    private static AllocNodeUtils v;

    public static void run() {
        v = new AllocNodeUtils();
    }

    public static AllocNodeUtils v() {
        return v;
    }

    HashMap<AllocNode, Set<AllocNode>> allocNodeToReachableAllocNodes = new HashMap<AllocNode, Set<AllocNode>>();


    Set<AllocNode> reachable(Set<AllocNode> allocNodes) {
        HashSet<AllocNode> reachableAllocNodes = new HashSet<AllocNode>();
        for (AllocNode allocNode : allocNodes) {
            reachableAllocNodes.addAll(reachable(allocNode));
        }
        return reachableAllocNodes;
    }

    Set<AllocNode> reachable(AllocNode allocNode) {
        return reachable(allocNode, new HashSet<AllocNode>());
    }

    Set<AllocNode> reachable(AllocNode allocNode, Set<AllocNode> visitedAllocNodes) {
        visitedAllocNodes.add(allocNode);

        if (allocNodeToReachableAllocNodes.containsKey(allocNode)) {
            return allocNodeToReachableAllocNodes.get(allocNode);
        }

        Set<AllocNode> reachableAllocNodes = new HashSet<AllocNode>();
        reachableAllocNodes.add(allocNode);
        Set<AllocNode> directlyReachableAllocNodes = new HashSet<AllocNode>();
        if (allocNode.getType() instanceof RefType) {
            for (AllocDotField allocDotField : allocNode.getFields()) {
                // FIXME FIXME       FIXME       FIXME                   FIXME
                // FIXME             FIXME             FIXME       FIXME
                // FIXME FIXME       FIXME                   FIXME
                // FIXME             FIXME             FIXME       FIXME
                // FIXME             FIXME       FIXME                   FIXME
                try {
                    directlyReachableAllocNodes.addAll(PTABridge.v().getPTSet(allocNode, (SootField)allocDotField.getField()));
                } catch (RuntimeException exception) {
                    exception.printStackTrace(G.v().out);
                }
            }
        } else if (allocNode.getType() instanceof ArrayType) {
            directlyReachableAllocNodes.addAll(PTABridge.v().getPTSetOfArrayElement(allocNode));
        }
        for (AllocNode directlyReachableAllocNode : directlyReachableAllocNodes) {
            if (!visitedAllocNodes.contains(directlyReachableAllocNode)) {
                reachableAllocNodes.addAll(reachable(directlyReachableAllocNode, visitedAllocNodes));
            }
        }
        allocNodeToReachableAllocNodes.put(allocNode, reachableAllocNodes);

        return reachableAllocNodes;
    }
}
