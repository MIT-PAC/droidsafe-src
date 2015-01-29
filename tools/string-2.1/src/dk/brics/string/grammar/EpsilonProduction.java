package dk.brics.string.grammar;

/**
 * Epsilon production [<tt>a -> ""</tt>].
 */
public class EpsilonProduction extends Production {

    @Override
    public String toString() {
        return "\"\"";
    }

    @Override
    public void visitBy(Nonterminal a, ProductionVisitor v) {
        v.visitEpsilonProduction(a, this);
    }
}
