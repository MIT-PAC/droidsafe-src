package dk.brics.string.mlfa;

/**
 * Visitor interface for MLFA transitions.
 */
public interface TransitionVisitor<T> {

    /**
     * Invoked on automaton transitions.
     */
    T visitAutomatonTransition(AutomatonTransition t);

    /**
     * Invoked on epsilon transitions.
     */
    T visitEpsilonTransition(EpsilonTransition t);

    /**
     * Invoked on identity transitions.
     */
    T visitIdentityTransition(IdentityTransition t);

    /**
     * Invoked on unary operation transitions.
     */
    T visitUnaryTransition(UnaryTransition t);

    /**
     * Invoked on binary operation transitions.
     */
    T visitBinaryTransition(BinaryTransition t);
}
