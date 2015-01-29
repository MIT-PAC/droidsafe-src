package dk.brics.string.flow;

import dk.brics.string.stringoperations.UnaryOperation;

/**
 * Unary operation node.
 */
public class UnaryNode extends Node {

    UnaryOperation op;
    Use arg;

    UnaryNode(int key, UnaryOperation op) {
        super(key);
        this.op = op;
        arg = new Use(this);
    }

    /**
     * Returns <tt>Use</tt> for argument.
     */
    public Use getArg() {
        return arg;
    }

    /**
     * Returns the operation.
     */
    public UnaryOperation getOp() {
        return op;
    }

    @Override
    public void visitBy(NodeVisitor v) {
        v.visitUnaryNode(this);
    }
}
