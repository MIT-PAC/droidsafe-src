package dk.brics.string.directedgraph;

import java.util.Collection;
import java.util.List;

/**
 * Interface for directed graphs.
 * Nodes are arranged in a list and numbered accordingly.
 */
public interface DirectedGraph<N extends GraphNode, C extends GraphComponent<N>> {

    /**
     * Returns the (unmodifiable) list of nodes of this graph.
     */
    List<N> getNodes();

    /**
     * Returns a collection of successor nodes for each node.
     */
    List<Collection<N>> getSuccesors();

    /**
     * Makes a new empty component.
     */
    C makeComponent();
}
