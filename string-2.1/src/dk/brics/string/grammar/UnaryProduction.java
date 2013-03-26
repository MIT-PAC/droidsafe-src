package dk.brics.string.grammar;

import dk.brics.string.stringoperations.UnaryOperation;

/**
 * Unary production [<tt>a -> op1(b)</tt>].
 */
public class UnaryProduction extends Production {

    UnaryOperation op;
    Nonterminal b;

    UnaryProduction(UnaryOperation op, Nonterminal b) {
        this.op = op;
        this.b = b;
    }

    /**
     * Returns the operation.
     */
    public UnaryOperation getOperation() {
        return op;
    }

    /**
     * Returns the nonterminal.
     */
    public Nonterminal getNonterminal() {
        return b;
    }

    @Override
    public String toString() {
        return op + "(" + b + ")";
    }

    @Override
    public void visitBy(Nonterminal a, ProductionVisitor v) {
        v.visitUnaryProduction(a, this);
    }
}
