package droidsafe.analyses.infoflow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import soot.ArrayType;
import soot.G;
import soot.RefType;
import soot.SootField;
import soot.jimple.toolkits.pta.IAllocNode;
import droidsafe.analyses.pta.PTABridge;

public class AllocNodeUtils {
    private static AllocNodeUtils v;

    public static void run() {
        v = new AllocNodeUtils();
    }

    public static AllocNodeUtils v() {
        return v;
    }

    HashMap<IAllocNode, Set<IAllocNode>> allocNodeToReachableAllocNodes = new HashMap<IAllocNode, Set<IAllocNode>>();


    Set<IAllocNode> reachable(Set<IAllocNode> allocNodes) {
        HashSet<IAllocNode> reachableAllocNodes = new HashSet<IAllocNode>();
        for (IAllocNode allocNode : allocNodes) {
            reachableAllocNodes.addAll(reachable(allocNode));
        }
        return reachableAllocNodes;
    }

    Set<IAllocNode> reachable(IAllocNode allocNode) {
        return reachable(allocNode, new HashSet<IAllocNode>());
    }

    Set<IAllocNode> reachable(IAllocNode allocNode, Set<IAllocNode> visitedAllocNodes) {
        visitedAllocNodes.add(allocNode);

        if (allocNodeToReachableAllocNodes.containsKey(allocNode)) {
            return allocNodeToReachableAllocNodes.get(allocNode);
        }

        Set<IAllocNode> reachableAllocNodes = new HashSet<IAllocNode>();
        reachableAllocNodes.add(allocNode);
        Set<IAllocNode> directlyReachableAllocNodes = new HashSet<IAllocNode>();
        if (allocNode.getType() instanceof RefType) {
        	if (allocNode instanceof soot.jimple.spark.pag.AllocNode) {
                for (soot.jimple.spark.pag.AllocDotField allocDotField : ((soot.jimple.spark.pag.AllocNode) allocNode).getFields()) {
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
        	} else if (allocNode instanceof soot.jimple.paddle.AllocNode) {
        		Iterator iter = ((soot.jimple.paddle.AllocNode) allocNode).fields();
        		while (iter.hasNext()) {
        			soot.jimple.paddle.AllocDotField allocDotField = (soot.jimple.paddle.AllocDotField) iter.next();
        			// FIXME FIXME       FIXME       FIXME                   FIXME
        			// FIXME             FIXME             FIXME       FIXME
        			// FIXME FIXME       FIXME                   FIXME
        			// FIXME             FIXME             FIXME       FIXME
        			// FIXME             FIXME       FIXME                   FIXME
        			try {
        				directlyReachableAllocNodes.addAll(PTABridge.v().getPTSet(allocNode, (SootField)allocDotField.field()));
        			} catch (RuntimeException exception) {
        				exception.printStackTrace(G.v().out);
        			}
        		}
        	}
        } else if (allocNode.getType() instanceof ArrayType) {
            directlyReachableAllocNodes.addAll(PTABridge.v().getPTSetOfArrayElement(allocNode));
        }
        for (IAllocNode directlyReachableAllocNode : directlyReachableAllocNodes) {
            if (!visitedAllocNodes.contains(directlyReachableAllocNode)) {
                reachableAllocNodes.addAll(reachable(directlyReachableAllocNode, visitedAllocNodes));
            }
        }
        allocNodeToReachableAllocNodes.put(allocNode, reachableAllocNodes);

        return reachableAllocNodes;
    }
}
