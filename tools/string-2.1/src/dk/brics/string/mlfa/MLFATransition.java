package dk.brics.string.mlfa;

/**
 * Abstract superclass for transitions.
 */
abstract public class MLFATransition {

    /**
     * Visits this transition with the given visitor.
     */
    abstract public <T> T visitBy(TransitionVisitor<T> v);
}
