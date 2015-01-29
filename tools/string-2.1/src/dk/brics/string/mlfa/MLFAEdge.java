package dk.brics.string.mlfa;

/**
 * Automaton edge (pair of transition and destination state).
 */
public class MLFAEdge {

    private MLFATransition t;

    private MLFAState dest;

    /**
     * Constructs a new edge.
     */
    public MLFAEdge(MLFATransition t, MLFAState dest) {
        this.t = t;
        this.dest = dest;
    }

    /**
     * Retuerns the transition of this edge.
     */
    public MLFATransition getTransition() {
        return t;
    }

    /**
     * Retuerns the destination of this edge.
     */
    public MLFAState getDestination() {
        return dest;
    }
}
