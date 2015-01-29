package dk.brics.string.grammar;

import dk.brics.string.stringoperations.BinaryOperation;

/**
 * Binary production [<tt>a -> op2(b,c)</tt>].
 */
public class BinaryProduction extends Production {

    BinaryOperation op;
    Nonterminal b, c;

    BinaryProduction(BinaryOperation op, Nonterminal b, Nonterminal c) {
        this.op = op;
        this.b = b;
        this.c = c;
    }

    /**
     * Returns the operation.
     */
    public BinaryOperation getOperation() {
        return op;
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
        return op + "(" + b + "," + c + ")";
    }

    @Override
    public void visitBy(Nonterminal a, ProductionVisitor v) {
        v.visitBinaryProduction(a, this);
    }
}
