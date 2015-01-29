package dk.brics.string.mlfa;

/**
 * Identity transition.
 */
public class IdentityTransition extends MLFATransition {

    private MLFAState s, f;

    /**
     * Constructs a new identity transition.
     */
    public IdentityTransition(MLFAState s, MLFAState f) {
        this.s = s;
        this.f = f;
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
        return "(" + s + "," + f + ")";
    }

    @Override
    public <T> T visitBy(TransitionVisitor<T> v) {
        return v.visitIdentityTransition(this);
    }
}
