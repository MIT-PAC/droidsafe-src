package dk.brics.string.mlfa;

import java.util.ArrayList;
import java.util.List;

/**
 * MLFA state.
 */
public class MLFAState {

    private List<MLFAEdge> edges = new ArrayList<MLFAEdge>();

    private int key;

    MLFAState(int key) {
        this.key = key;
    }

    /**
     * Returns the key of this nonterminal.
     */
    public int getKey() {
        return key;
    }

    /**
     * Adds outgoing edge.
     */
    public void addEdge(MLFATransition t, MLFAState dest) {
        edges.add(new MLFAEdge(t, dest));
    }

    /**
     * Returns the list of outgoing edges of this state.
     */
    public List<MLFAEdge> getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        return "S" + key;
    }
}
