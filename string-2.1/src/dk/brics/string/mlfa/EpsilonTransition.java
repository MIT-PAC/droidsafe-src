package dk.brics.string.mlfa;

/**
 * Epsilon transition.
 */
public class EpsilonTransition extends MLFATransition {

    /**
     * Constructs a new epsilon transition.
     */
    public EpsilonTransition() {
    }

    @Override
    public String toString() {
        return "\"\"";
    }

    @Override
    public <T> T visitBy(TransitionVisitor<T> v) {
        return v.visitEpsilonTransition(this);
    }
}
