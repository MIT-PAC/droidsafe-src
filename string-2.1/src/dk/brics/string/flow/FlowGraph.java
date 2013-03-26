package dk.brics.string.flow;

import dk.brics.automaton.Automaton;
import dk.brics.string.flow.operations.FlowGraph2Dot;
import dk.brics.string.flow.operations.Simplifier;
import dk.brics.string.stringoperations.BinaryOperation;
import dk.brics.string.stringoperations.UnaryOperation;

import java.util.*;

/**
 * Flow graph.
 * Nodes represent definitions (variables or expressions).
 * Edges represent data flow.
 *
 * @author Anders M&oslash;ller &lt;<a href="mailto:amoeller@cs.au.dk">amoeller@cs.au.dk</a>&gt;
 * @author Aske Simon Christensen &lt;<a href="mailto:aske@cs.au.dk">aske@cs.au.dk</a>&gt;
 */
public class FlowGraph {

    private List<Node> nodes = new ArrayList<Node>();

    /**
     * Constructs new empty flow graph.
     */
    public FlowGraph() {
    }

    /**
     * Returns the (unmodifiable) collection of nodes in this graph.
     */
    public List<Node> getNodes() {
        return Collections.unmodifiableList(nodes);
    }

    private int getNextKey() {
        return nodes.size();
    }

    /**
     * Adds new assignment node to this flow graph.
     *
     * @return new node
     */
    public AssignmentNode addAssignmentNode() {
        AssignmentNode n = new AssignmentNode(getNextKey());
        nodes.add(n);
        return n;
    }

    /**
     * Adds new concatenation node to this flow graph.
     *
     * @return new node
     */
    public ConcatenationNode addConcatenationNode() {
        ConcatenationNode n = new ConcatenationNode(getNextKey());
        nodes.add(n);
        return n;
    }

    /**
     * Adds new initialization node to this flow graph.
     *
     * @param reg regular language representing initialization values
     * @return new node
     */
    public InitializationNode addInitializationNode(Automaton reg) {
        InitializationNode n = new InitializationNode(getNextKey(), reg);
        nodes.add(n);
        return n;
    }

    /**
     * Adds new unary operation node to this flow graph.
     *
     * @param op unary operation
     * @return new node
     */
    public UnaryNode addUnaryNode(UnaryOperation op) {
        UnaryNode n = new UnaryNode(getNextKey(), op);
        nodes.add(n);
        return n;
    }

    /**
     * Adds new binary operation node to this flow graph.
     *
     * @param op binary operation
     * @return new node
     */
    public BinaryNode addBinaryNode(BinaryOperation op) {
        BinaryNode n = new BinaryNode(getNextKey(), op);
        nodes.add(n);
        return n;
    }

    /**
     * Returns number of nodes in this graph.
     */
    public int getNumberOfNodes() {
        return nodes.size();
    }

    /**
     * Returns number of edges in this graph.
     */
    public int getNumberOfEdges() {
        int x = 0;
        for (Node n : nodes) {
            x += n.getUses().size();
        }
        return x;
    }

    /**
     * Removes the given nodes from this graph.
     */
    public void removeNodes(Set<Node> removed) {
        nodes.removeAll(removed);
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).setIndex(i);
        }
    }

    /**
     * Visits all nodes with the given visitor.
     */
    public void visitNodes(NodeVisitor v) {
        for (Node n : nodes) {
            n.visitBy(v);
        }
    }

    /**
     * See {@link Simplifier#normalize(FlowGraph)}.
     */
    public void normalize() {
        Simplifier.normalize(this);
    }

    /**
     * See {@link Simplifier#simplify(FlowGraph)}.
     */
    public Map<Node, Node> simplify() {
        return Simplifier.simplify(this);
    }

    /**
     * See {@link FlowGraph2Dot#toDot(FlowGraph)}.
     */
    public String toDot() {
        return FlowGraph2Dot.toDot(this);
    }

    /**
     * See {@link FlowGraph2Dot#toDot(FlowGraph,Collection)}.
     */
    public String toDot(Collection<Node> hotspots) {
        return FlowGraph2Dot.toDot(this, hotspots);
    }
}
