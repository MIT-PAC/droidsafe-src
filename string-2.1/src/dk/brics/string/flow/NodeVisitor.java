package dk.brics.string.flow;

/**
 * Node visitor interface.
 */
public interface NodeVisitor {

    /**
     * Invoked on assignment nodes.
     */
    public void visitAssignmentNode(AssignmentNode n);

    /**
     * Invoked on concatenation nodes.
     */
    public void visitConcatenationNode(ConcatenationNode n);

    /**
     * Invoked on initialization nodes.
     */
    public void visitInitializationNode(InitializationNode n);

    /**
     * Invoked on unary operation nodes.
     */
    public void visitUnaryNode(UnaryNode n);

    /**
     * Invoked on binary operation nodes.
     */
    public void visitBinaryNode(BinaryNode n);
}
