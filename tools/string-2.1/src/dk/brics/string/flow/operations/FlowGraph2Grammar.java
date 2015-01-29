package dk.brics.string.flow.operations;

import dk.brics.string.flow.*;
import dk.brics.string.grammar.Grammar;
import dk.brics.string.grammar.Nonterminal;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter from flow graphs to grammars.
 *
 * @see dk.brics.string.StringAnalysis
 */
public class FlowGraph2Grammar {

    private FlowGraph g;

    private List<Nonterminal> node2nt;

    /**
     * Constructs a new converter for the given flow graph.
     */
    public FlowGraph2Grammar(FlowGraph g) {
        this.g = g;
    }

    /**
     * Constructs grammar for the flow graph.
     *
     * @see #getNonterminal(Node)
     */
    public Grammar convert() {
        final Grammar r = new Grammar();
        node2nt = new ArrayList<Nonterminal>();
        for (Node node : g.getNodes()) {
            Nonterminal n = r.addNonterminal();
            n.setTaint(node.isTaint());
            node2nt.add(n);
        }
        g.visitNodes(new NodeVisitor() {

            public void visitAssignmentNode(AssignmentNode n) {
                for (Node m : n.getArg().getDefs()) {
                    r.addUnitProduction(getNonterminal(n), getNonterminal(m));
                }
            }

            public void visitConcatenationNode(ConcatenationNode n) {
                for (Node m1 : n.getArg1().getDefs()) {
                    for (Node m2 : n.getArg2().getDefs()) {
                        r.addPairProduction(getNonterminal(n), getNonterminal(m1), getNonterminal(m2));
                    }
                }
            }

            public void visitInitializationNode(InitializationNode n) {
                r.addAutomatonProduction(getNonterminal(n), n.getReg());
            }

            public void visitUnaryNode(UnaryNode n) {
                for (Node m : n.getArg().getDefs()) {
                    r.addUnaryProduction(getNonterminal(n), n.getOp(), getNonterminal(m));
                }
            }

            public void visitBinaryNode(BinaryNode n) {
                for (Node m1 : n.getArg1().getDefs()) {
                    for (Node m2 : n.getArg2().getDefs()) {
                        r.addBinaryProduction(getNonterminal(n), n.getOp(), getNonterminal(m1), getNonterminal(m2));
                    }
                }
            }
        });
        return r;
    }

    /**
     * Returns grammar nonterminal for the given node.
     * Should only be invoked after {@link #convert()}.
     */
    public Nonterminal getNonterminal(Node n) {
        return node2nt.get(n.getIndex());
    }
}
