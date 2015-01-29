package dk.brics.string.flow.operations;

import dk.brics.string.flow.*;
import dk.brics.string.stringoperations.Basic;

import java.util.*;

/**
 * Flow graph simplifier.
 */
public class Simplifier {

    private Simplifier() {
    }

    /**
     * Simplifies the given graph.
     * Performs the following optimizations:
     * <ul>
     * <li>Nodes that are of same type and have ingoing edges from the same nodes are merged.
     * <li>Sequences of assignments with only one ingoing edge are compressed.
     * <li>Concatenation nodes are bypassed if the first argument has exactly one edge and it comes
     * from an initialization node with the empty string.
     * <li>Self-loops on assignments are removed.
     * </ul>
     *
     * @return a map from the original nodes to the corresponding
     *         node in the simplified graph
     */
    public static Map<Node, Node> simplify(FlowGraph g) {
        ArrayList<Node> old_nodes = new ArrayList<Node>(g.getNodes());
        Map<Node, Node> simp_map = new HashMap<Node, Node>(); // map containing all simplifications
        Set<Node> dirty_s = new HashSet<Node>(g.getNodes());
        LinkedList<Node> dirty_l = new LinkedList<Node>(g.getNodes());
        Map<NodeEquivalence, Node> equiv = new HashMap<NodeEquivalence, Node>();
        Set<Node> removed_nodes = new HashSet<Node>();
        while (!dirty_l.isEmpty()) {
            Node n = dirty_l.removeFirst();
            dirty_s.remove(n);
            NodeEquivalence ne = new NodeEquivalence(n);
            Node nn = null;
            if (equiv.containsKey(ne)) {
                // already seen equivalent node
                nn = equiv.get(ne);
                redirectUses(n, nn);
                new RedirectDefs(n, nn);
            } else if (n instanceof AssignmentNode) {
                Use from = ((AssignmentNode) n).getArg();
                if (from.getDefs().contains(n)) {
                    // found self-loop on assignment
                    from.removeDef(n);
                    n.getUses().remove(n);
                }
                if (from.getDefs().size() == 1) {
                    Node def = from.getDefs().iterator().next();
                    if (def != n) {
                        // found assignment node with only one ingoing edge
                        def.getUses().remove(from);
                        redirectUses(n, def);
                        nn = def;
                    }
                }
            } else if (n instanceof ConcatenationNode) {
                Use left = ((ConcatenationNode) n).getArg1();
                Use right = ((ConcatenationNode) n).getArg2();
                if (left.getDefs().size() == 1) {
                    Node ld = left.getDefs().iterator().next();
                    if (ld instanceof InitializationNode &&
                            ((InitializationNode) ld).getReg().equals(Basic.makeEmptyString())) {
                        // found concat node where left arg is one init node with ""
                        AssignmentNode a = g.addAssignmentNode();
                        ld.getUses().remove(left);
                        redirectUses(n, a);
                        redirectDefs(right, a.getArg());
                        nn = a;
                    }
                }

            }
            if (nn != null) {
                // mark all uses dirty
                for (Use use : nn.getUses()) {
                    Node un = use.getUser();
                    if (!dirty_s.contains(un)) {
                        equiv.remove(new NodeEquivalence(un));
                        dirty_l.addLast(un);
                        dirty_s.add(un);
                    }
                }
                simp_map.put(n, nn);
                removed_nodes.add(n);
            } else {
                equiv.put(ne, n);
            }
        }
        g.removeNodes(removed_nodes);
        // build final mapping
        Map<Node, Node> trans_map = new HashMap<Node, Node>();
        for (Node n : old_nodes) {
            Node n2 = n;
            while (simp_map.containsKey(n2)) {
                n2 = simp_map.get(n2);
            }
            trans_map.put(n, n2);
        }
        return trans_map;
    }

    static void redirectUses(Node n1, Node n2) {
        for (Use u : n1.getUses()) {
            u.removeDef(n1);
            u.addDef(n2);
            n2.getUses().add(u);
        }
        n1.getUses().clear();
    }

    static void redirectDefs(Use u1, Use u2) {
        for (Node d : u1.getDefs()) {
            d.getUses().remove(u1);
            d.getUses().add(u2);
            u2.addDef(d);
        }
        u1.clearDefs();
    }

    /**
     * Normalizes the given graph.
     * In a normalized graph, only assignment nodes may have multiple incoming edges.
     * (Concat nodes and binary operation nodes have at most one edge for each argument.)
     */
    public static void normalize(FlowGraph g) {
        for (Node n : new ArrayList<Node>(g.getNodes())) {
            if (n instanceof ConcatenationNode) {
                Use left = ((ConcatenationNode) n).getArg1();
                Use right = ((ConcatenationNode) n).getArg2();
                if (left.getDefs().size() > 1) {
                    AssignmentNode a = g.addAssignmentNode();
                    redirectDefs(left, a.getArg());
                    left.addDefUse(a);
                }
                if (right.getDefs().size() > 1) {
                    AssignmentNode a = g.addAssignmentNode();
                    redirectDefs(right, a.getArg());
                    right.addDefUse(a);
                }
            } else if (n instanceof UnaryNode) {
                Use arg = ((UnaryNode) n).getArg();
                if (arg.getDefs().size() > 1) {
                    AssignmentNode a = g.addAssignmentNode();
                    redirectDefs(arg, a.getArg());
                    arg.addDefUse(a);
                }
            } else if (n instanceof BinaryNode) {
                Use arg1 = ((BinaryNode) n).getArg1();
                Use arg2 = ((BinaryNode) n).getArg2();
                if (arg1.getDefs().size() > 1) {
                    AssignmentNode a = g.addAssignmentNode();
                    redirectDefs(arg1, a.getArg());
                    arg1.addDefUse(a);
                }
                if (arg2.getDefs().size() > 1) {
                    AssignmentNode a = g.addAssignmentNode();
                    redirectDefs(arg2, a.getArg());
                    arg2.addDefUse(a);
                }
            }
        }
    }

    static class RedirectDefs implements NodeVisitor {

        private Node n2;

        public RedirectDefs(Node n1, Node n2) {
            this.n2 = n2;
            n1.visitBy(this);
        }

        public void visitAssignmentNode(AssignmentNode n) {
            Simplifier.redirectDefs(n.getArg(), ((AssignmentNode) n2).getArg());
        }

        public void visitConcatenationNode(ConcatenationNode n) {
            Simplifier.redirectDefs(n.getArg1(), ((ConcatenationNode) n2).getArg1());
            Simplifier.redirectDefs(n.getArg2(), ((ConcatenationNode) n2).getArg2());
        }

        public void visitInitializationNode(InitializationNode n) {
        }

        public void visitUnaryNode(UnaryNode n) {
            Simplifier.redirectDefs(n.getArg(), ((UnaryNode) n2).getArg());
        }

        public void visitBinaryNode(BinaryNode n) {
            Simplifier.redirectDefs(n.getArg1(), ((BinaryNode) n2).getArg1());
            Simplifier.redirectDefs(n.getArg2(), ((BinaryNode) n2).getArg2());
        }
    }
}
