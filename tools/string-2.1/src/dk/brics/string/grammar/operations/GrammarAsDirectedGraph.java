package dk.brics.string.grammar.operations;

import dk.brics.string.Debug;
import dk.brics.string.directedgraph.DirectedGraph;
import dk.brics.string.grammar.*;

import java.util.*;

/**
 * Directed graph facade for grammars.
 */
public class GrammarAsDirectedGraph implements DirectedGraph<Nonterminal, Component> {

    private Grammar g;

    /**
     * Constructs a new facade.
     *
     * @param g
     */
    public GrammarAsDirectedGraph(Grammar g) {
        this.g = g;
    }

    public List<Nonterminal> getNodes() {
        return g.getNonterminals();
    }

    public List<Collection<Nonterminal>> getSuccesors() {
        final List<Collection<Nonterminal>> nexts = new ArrayList<Collection<Nonterminal>>();
        for (int i = 0; i < g.getNonterminals().size(); i++) {
            Collection<Nonterminal> c;
            if (Debug.isTest()) {
                c = new TreeSet<Nonterminal>();
            } else {
                c = new HashSet<Nonterminal>();
            }
            nexts.add(c);
        }
        g.visitProductions(new ProductionVisitor() {

            public void visitAutomatonProduction(Nonterminal a, AutomatonProduction p) {
            }

            public void visitBinaryProduction(Nonterminal a, BinaryProduction p) {
                nexts.get(a.getKey()).add(p.getNonterminal1());
                nexts.get(a.getKey()).add(p.getNonterminal2());
            }

            public void visitEpsilonProduction(Nonterminal a, EpsilonProduction p) {
            }

            public void visitPairProduction(Nonterminal a, PairProduction p) {
                nexts.get(a.getKey()).add(p.getNonterminal1());
                nexts.get(a.getKey()).add(p.getNonterminal2());
            }

            public void visitUnaryProduction(Nonterminal a, UnaryProduction p) {
                nexts.get(a.getKey()).add(p.getNonterminal());
            }

            public void visitUnitProduction(Nonterminal a, UnitProduction p) {
                nexts.get(a.getKey()).add(p.getNonterminal());
            }

        });
        return nexts;
    }

    public Component makeComponent() {
        return new Component();
    }
}
