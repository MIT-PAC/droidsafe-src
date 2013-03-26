package dk.brics.string.flow;

/**
 * Assignment node.
 */
public class AssignmentNode extends Node {

    Use from;

    AssignmentNode(int key) {
        super(key);
        from = new Use(this);
    }

    /**
     * Returns <tt>Use</tt> for right-hand side of assignment.
     */
    public Use getArg() {
        return from;
    }

    @Override
    public void visitBy(NodeVisitor v) {
        v.visitAssignmentNode(this);
    }
}
