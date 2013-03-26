package dk.brics.string.mlfa;

import dk.brics.string.stringoperations.BinaryOperation;

/**
 * Binary operation transition.
 */
public class BinaryTransition extends MLFATransition {

    private BinaryOperation op;

    private MLFAState s1, f1, s2, f2;

    /**
     * Constructs a new binary operation transition.
     */
    public BinaryTransition(BinaryOperation op, MLFAState s1, MLFAState f1, MLFAState s2, MLFAState f2) {
        this.op = op;
        this.s1 = s1;
        this.f1 = f1;
        this.s2 = s2;
        this.f2 = f2;
    }

    @Override
    public String toString() {
        return op + "((" + s1 + "," + f1 + "),(" + s2 + "," + f2 + "))";
    }

    /**
     * Returns the binary operation.
     */
    public BinaryOperation getOperation() {
        return op;
    }

    /**
     * Returns the first start state.
     */
    public MLFAState getStartState1() {
        return s1;
    }

    /**
     * Returns the first final state.
     */
    public MLFAState getFinalState1() {
        return f1;
    }

    /**
     * Returns the second start state.
     */
    public MLFAState getStartState2() {
        return s2;
    }

    /**
     * Returns the second final state.
     */
    public MLFAState getFinalState2() {
        return f2;
    }

    @Override
    public <T> T visitBy(TransitionVisitor<T> v) {
        return v.visitBinaryTransition(this);
    }
}
