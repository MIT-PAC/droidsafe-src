package dk.brics.string.directedgraph;

import java.util.Collection;

/**
 * Interface for strongly connected component.
 */
public interface GraphComponent<N extends GraphNode> {

    /**
     * Returns the (unmodifiable) collection of nodes in this component.
     */
    Collection<N> getNodes();

    /**
     * Adds a node to this component.
     */
    void add(N n);
}
