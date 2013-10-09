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
    
    Set<AllocNode> reachable(AllocNode root) {
        if (allocNodeToReachableAllocNodes.containsKey(root)) {
            return allocNodeToReachableAllocNodes.get(root);
        }
        
        Set<AllocNode> allocNodesReachable = new HashSet<AllocNode>();
        allocNodesReachable.add(root);
        Set<AllocNode> allocNodesToVisit = new HashSet<AllocNode>();
        allocNodesToVisit.add(root);
        Set<AllocNode> allocNodesVisited = new HashSet<AllocNode>();
        while (!(allocNodesToVisit.isEmpty())) {
            Set<AllocNode> allocNodesToVisitNewly = new HashSet<AllocNode>();
            for (AllocNode allocNode : allocNodesToVisit) {
                allocNodesVisited.add(allocNode);
                final Set<AllocNode> allocNodes = new HashSet<AllocNode>();
                if (allocNode.getType() instanceof RefType) {
                    for (AllocDotField allocDotField : allocNode.getFields()) {
                        ((PointsToSetInternal)((GeomPointsTo)Scene.v().getPointsToAnalysis()).reachingObjects(allocNode, (SootField)allocDotField.getField())).forall(new P2SetVisitor() {
                            public void visit(Node node) {
                                allocNodes.add((AllocNode)node);
                            }
                        });
                    }
                } else if (allocNode.getType() instanceof ArrayType) {
                    HashPointsToSet pointsToSet = new HashPointsToSet(allocNode.getType(), (GeomPointsTo)Scene.v().getPointsToAnalysis());
                    pointsToSet.add(allocNode);
                    ((PointsToSetInternal)((GeomPointsTo)Scene.v().getPointsToAnalysis()).reachingObjectsOfArrayElement(pointsToSet)).forall(new P2SetVisitor() {
                        public void visit(Node node) {
                            allocNodes.add((AllocNode)node);
                        }
                    });
                }
                allocNodesReachable.addAll(allocNodes);
                for (AllocNode node : allocNodes) {
                    if (!allocNodesVisited.contains(node)) {
                        allocNodesToVisitNewly.add(node);
                    }
                }
            }
            allocNodesToVisit = allocNodesToVisitNewly;
        }
        allocNodeToReachableAllocNodes.put(root, allocNodesReachable);
        return allocNodesReachable;
    }
    
    Set<AllocNode> reachable(Set<AllocNode> roots) {
        HashSet<AllocNode> reachableAllocNodes = new HashSet<AllocNode>();
        for (AllocNode root : roots) {
            reachableAllocNodes.addAll(reachable(root));
        }
        return reachableAllocNodes;
    }
}
