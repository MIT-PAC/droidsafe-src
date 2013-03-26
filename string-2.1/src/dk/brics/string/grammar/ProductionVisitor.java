package dk.brics.string.grammar;

/**
 * Visitor for grammar productions.
 */
public interface ProductionVisitor {

    /**
     * Invoked on automaton productions.
     */
    void visitAutomatonProduction(Nonterminal a, AutomatonProduction p);

    /**
     * Invoked on binary productions.
     */
    void visitBinaryProduction(Nonterminal a, BinaryProduction p);

    /**
     * Invoked on epsilon productions.
     */
    void visitEpsilonProduction(Nonterminal a, EpsilonProduction p);

    /**
     * Invoked on pair productions.
     */
    void visitPairProduction(Nonterminal a, PairProduction p);

    /**
     * Invoked on unary productions.
     */
    void visitUnaryProduction(Nonterminal a, UnaryProduction p);

    /**
     * Invoked on unit productions.
     */
    void visitUnitProduction(Nonterminal a, UnitProduction p);
}
