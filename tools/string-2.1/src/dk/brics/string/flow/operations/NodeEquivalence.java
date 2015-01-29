package dk.brics.string.flow.operations;

import dk.brics.string.flow.*;

/**
 * Node equivalence checker.
 * Two nodes are equivalent if they are of the same type and
 * have ingoing edges from the same nodes.
 * It is assumed that InitializationNode instances are equal
 * if their automata both have associated info objects and
 * these info objects are equal.
 */
class NodeEquivalence {

    private Node node;
    private int hash;

    NodeEquivalence(Node n) {
        node = n;
        node.visitBy(new HashCalculator());
    }

    Node getNode() {
        return node;
    }

    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NodeEquivalence) {
            NodeComparator nc = new NodeComparator();
            ((NodeEquivalence) obj).getNode().visitBy(nc);
            return nc.result;
        } else {
            return false;
        }
    }

    private class HashCalculator implements NodeVisitor {

        public void visitAssignmentNode(AssignmentNode n) {
            hash = n.getArg().getDefsHashCode() * 3;
        }

        public void visitConcatenationNode(ConcatenationNode n) {
            hash = n.getArg1().getDefsHashCode() * 5 + n.getArg2().getDefsHashCode() * 7;
        }

        public void visitInitializationNode(InitializationNode n) {
            if (n.getReg().getInfo() != null) {
                hash = n.getReg().getInfo().hashCode();
            } else {
                hash = n.hashCode();
            }
        }

        public void visitUnaryNode(UnaryNode n) {
            hash = n.getOp().hashCode() * 17 + n.getArg().getDefsHashCode() * 19;
        }

        public void visitBinaryNode(BinaryNode n) {
            hash = n.getOp().hashCode() * 23 + n.getArg1().getDefsHashCode() * 29 + n.getArg2().getDefsHashCode() * 31;
        }
    }

    private class NodeComparator implements NodeVisitor {

        boolean result;

        public void visitAssignmentNode(AssignmentNode n) {
            result = (node instanceof AssignmentNode) &&
                    ((AssignmentNode) node).getArg().equalDefs(n.getArg());
        }

        public void visitConcatenationNode(ConcatenationNode n) {
            result = (node instanceof ConcatenationNode) &&
                    ((ConcatenationNode) node).getArg1().equalDefs(n.getArg1()) &&
                    ((ConcatenationNode) node).getArg2().equalDefs(n.getArg2());
        }

        public void visitInitializationNode(InitializationNode n) {
            if (node instanceof InitializationNode) {
                InitializationNode n2 = (InitializationNode) node;
                Object i1 = n.getReg().getInfo();
                Object i2 = n2.getReg().getInfo();
                result = (i1 != null && i2 != null && i1.equals(i2));
            } else {
                result = false;
            }
        }

        public void visitUnaryNode(UnaryNode n) {
            result = (node instanceof UnaryNode)
                    && ((UnaryNode) node).getOp().equals(n.getOp())
                    && ((UnaryNode) node).getArg().equalDefs(n.getArg());
        }

        public void visitBinaryNode(BinaryNode n) {
            result = (node instanceof BinaryNode)
                    && ((BinaryNode) node).getOp().equals(n.getOp())
                    && ((BinaryNode) node).getArg1().equalDefs(n.getArg1())
                    && ((BinaryNode) node).getArg2().equalDefs(n.getArg2());
        }
    }
}
