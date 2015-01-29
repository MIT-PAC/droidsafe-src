package dk.brics.string.flow;

/**
 * Concatenation node.
 */
public class ConcatenationNode extends Node {

    Use left;
    Use right;

    ConcatenationNode(int key) {
        super(key);
        left = new Use(this);
        right = new Use(this);
    }

    /**
     * Returns <tt>Use</tt> for first argument.
     */
    public Use getArg1() {
        return left;
    }

    /**
     * Returns <tt>Use</tt> for second argument.
     */
    public Use getArg2() {
        return right;
    }

    @Override
    public void visitBy(NodeVisitor v) {
        v.visitConcatenationNode(this);
    }
}
