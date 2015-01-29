package dk.brics.string.grammar;

/**
 * Unit production [<tt>a -> b</tt>].
 */
public class UnitProduction extends Production {

    Nonterminal b;

    public UnitProduction(Nonterminal b) {
        this.b = b;
    }

    /**
     * Returns the nonterminal.
     */
    public Nonterminal getNonterminal() {
        return b;
    }

    @Override
    public String toString() {
        return b.toString();
    }

    @Override
    public void visitBy(Nonterminal a, ProductionVisitor v) {
        v.visitUnitProduction(a, this);
    }
}
