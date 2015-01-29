package dk.brics.string.flow.operations;

import dk.brics.string.Misc;
import dk.brics.string.flow.*;
import dk.brics.string.stringoperations.Basic;

import java.util.Collection;

/**
 * Converter from flow graphs to
 * <a href="http://www.research.att.com/sw/tools/graphviz/"
 * target="_top">Graphviz Dot</a> representation.
 */
public class FlowGraph2Dot {

    private FlowGraph2Dot() {
    }

    /**
     * Returns <a href="http://www.research.att.com/sw/tools/graphviz/"
     * target="_top">Graphviz Dot</a> representation of the given graph.
     * All nodes are shown as hotspots.
     */
    public static String toDot(FlowGraph g) {
        return toDot(g, null);
    }

    /**
     * Returns <a href="http://www.research.att.com/sw/tools/graphviz/"
     * target="_top">Graphviz Dot</a> representation of the given graph.
     */
    public static String toDot(FlowGraph g, final Collection<Node> hotspots) {
        final StringBuilder s = new StringBuilder();
        s.append("digraph FlowGraph {\n");
        g.visitNodes(new NodeVisitor() {

            private String hot(Node n) {
                if (hotspots != null && hotspots.contains(n)) {
                    return ",style=bold";
                } else {
                    return "";
                }
            }

            public void visitAssignmentNode(AssignmentNode n) {
                s.append("  ").append(n).append(" [label=\"\",shape=circle" + hot(n) + "]\n");
                for (Node m : n.getArg().getDefs()) {
                    s.append("  ").append(m).append(" -> ").append(n).append("\n");
                }
            }

            public void visitConcatenationNode(ConcatenationNode n) {
                s.append("  ").append(n).append(" [label=\"concat|<arg1>|<arg2>\",shape=record" + hot(n) + "]\n");
                for (Node m : n.getArg1().getDefs()) {
                    s.append("  ").append(m).append(" -> ").append(n).append(":arg1\n");
                }
                for (Node m : n.getArg2().getDefs()) {
                    s.append("  ").append(m).append(" -> ").append(n).append(":arg2\n");
                }
            }

            public void visitInitializationNode(InitializationNode n) {
                s.append("  ").append(n).append(" [label=\"" + Misc.escape(Basic.getName(n.getReg())) + "\"" + hot(n) + "]\n");
            }

            public void visitUnaryNode(UnaryNode n) {
                s.append("  ").append(n).append(" [label=\"" + n.getOp() + "|<arg>\",shape=record" + hot(n) + "]\n");
                for (Node m : n.getArg().getDefs()) {
                    s.append("  ").append(m).append(" -> ").append(n).append(":arg\n");
                }
            }

            public void visitBinaryNode(BinaryNode n) {
                s.append("  ").append(n).append(" [label=\"" + n.getOp() + "|<arg1>|<arg2>\",shape=record" + hot(n) + "]\n");
                for (Node m : n.getArg1().getDefs()) {
                    s.append("  ").append(m).append(" -> ").append(n).append(":arg1\n");
                }
                for (Node m : n.getArg2().getDefs()) {
                    s.append("  ").append(m).append(" -> ").append(n).append(":arg2\n");
                }
            }
        });
        s.append("}\n");
        return s.toString();
    }
}
