package dk.brics.string.mlfa;

import dk.brics.string.stringoperations.UnaryOperation;

/**
 * Unary operation transition.
 */
public class UnaryTransition extends MLFATransition {

    private UnaryOperation op;

    private MLFAState s, f;

    /**
     * Constructs a new unary transition.
     */
    UnaryTransition(UnaryOperation op, MLFAState s, MLFAState f) {
        this.op = op;
        this.s = s;
        this.f = f;
    }

    /**
     * Returns the unary operation.
     */
    public UnaryOperation getOperation() {
        return op;
    }

    /**
     * Returns the start state.
     */
    public MLFAState getStartState() {
        return s;
    }

    /**
     * Returns the final state.
     */
    public MLFAState getFinalState() {
        return f;
    }

    @Override
    public String toString() {
        return op + "(" + s + "," + f + ")";
    }

    @Override
    public <T> T visitBy(TransitionVisitor<T> v) {
        return v.visitUnaryTransition(this);
    }
}
