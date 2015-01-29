package dk.brics.string.flow;

import dk.brics.string.stringoperations.BinaryOperation;

/**
 * Binary operation node.
 */
public class BinaryNode extends Node {

    BinaryOperation op;
    Use arg1;
    Use arg2;

    BinaryNode(int key, BinaryOperation op) {
        super(key);
        this.op = op;
        arg1 = new Use(this);
        arg2 = new Use(this);
    }

    /**
     * Returns <tt>Use</tt> for first argument.
     */
    public Use getArg1() {
        return arg1;
    }

    /**
     * Returns <tt>Use</tt> for second argument.
     */
    public Use getArg2() {
        return arg2;
    }

    /**
     * Returns the operation.
     */
    public BinaryOperation getOp() {
        return op;
    }

    @Override
    public void visitBy(NodeVisitor v) {
        v.visitBinaryNode(this);
    }
}
