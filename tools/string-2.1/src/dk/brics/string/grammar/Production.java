package dk.brics.string.grammar;

/**
 * Superclass for productions.
 */
abstract public class Production {

    /**
     * Visits this production with the given visitor.
     */
    abstract public void visitBy(Nonterminal a, ProductionVisitor v);
}
