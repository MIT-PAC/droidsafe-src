package droidsafe.analyses.infoflow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import soot.ArrayType;
import soot.RefType;
import soot.Scene;
import soot.SootField;
import soot.jimple.spark.geom.geomPA.GeomPointsTo;
import soot.jimple.spark.pag.AllocDotField;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.spark.pag.Node;
import soot.jimple.spark.sets.HashPointsToSet;
import soot.jimple.spark.sets.P2SetVisitor;
import soot.jimple.spark.sets.PointsToSetInternal;

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
        final Set<AllocNode> directlyReachableAllocNodes = new HashSet<AllocNode>();
        if (allocNode.getType() instanceof RefType) {
            for (AllocDotField allocDotField : allocNode.getFields()) {
                ((PointsToSetInternal)((GeomPointsTo)Scene.v().getPointsToAnalysis()).reachingObjects(allocNode, (SootField)allocDotField.getField())).forall(new P2SetVisitor() {
                    @Override
                    public void visit(Node node) {
                        directlyReachableAllocNodes.add((AllocNode)node);
                    }
                });
            }
        } else if (allocNode.getType() instanceof ArrayType) {
            HashPointsToSet pointsToSet = new HashPointsToSet(allocNode.getType(), (GeomPointsTo)Scene.v().getPointsToAnalysis());
            pointsToSet.add(allocNode);
            ((PointsToSetInternal)((GeomPointsTo)Scene.v().getPointsToAnalysis()).reachingObjectsOfArrayElement(pointsToSet)).forall(new P2SetVisitor() {
                @Override
                public void visit(Node node) {
                    directlyReachableAllocNodes.add((AllocNode)node);
                }
            });
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
