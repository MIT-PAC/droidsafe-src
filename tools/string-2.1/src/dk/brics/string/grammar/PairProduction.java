package dk.brics.string.grammar;

/**
 * Pair production [<tt>a -> b c</tt>].
 */
public class PairProduction extends Production {

    Nonterminal b, c;

    PairProduction(Nonterminal b, Nonterminal c) {
        this.b = b;
        this.c = c;
    }

    /**
     * Returns the first nonterminal.
     */
    public Nonterminal getNonterminal1() {
        return b;
    }

    /**
     * Returns the second nonterminal.
     */
    public Nonterminal getNonterminal2() {
        return c;
    }

    @Override
    public String toString() {
        return b + " " + c;
    }

    @Override
    public void visitBy(Nonterminal a, ProductionVisitor v) {
        v.visitPairProduction(a, this);
    }
}
