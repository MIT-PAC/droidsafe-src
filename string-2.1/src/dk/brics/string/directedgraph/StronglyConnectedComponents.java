package dk.brics.string.directedgraph;

import java.util.*;

/**
 * Finds strongly connected components of a directed graph.
 */
public class StronglyConnectedComponents<N extends GraphNode, C extends GraphComponent<N>> {

    private DirectedGraph<N, C> g;

    private Collection<C> components;

    private List<C> node_component;

    private List<Collection<N>> nexts;
    private int[] dfnumber, lowlink;
    private boolean[] newmark, onstack;

    // FIXME: check that components are indeed ordered bottom-up

    /**
     * Finds strongly connected components using Tarjan's algorithm.
     * Components are ordered bottom-up, i.e. leaves in the SCC tree appear first and roots last.
     */
    public StronglyConnectedComponents(DirectedGraph<N, C> g) {
        this.g = g;
        components = new ArrayList<C>();
        int n = g.getNodes().size();
        node_component = new ArrayList<C>();
        for (int i = 0; i < n; i++) {
            node_component.add(null);
        }
        nexts = g.getSuccesors();
        dfnumber = new int[n];
        lowlink = new int[n];
        newmark = new boolean[n];
        for (int i = 0; i < n; i++) {
            newmark[i] = true;
        }
        onstack = new boolean[n];
        Stack<N> stack = new Stack<N>();
        for (N v : g.getNodes()) {
            if (newmark[v.getKey()]) {
                searchc(v, 0, stack);
            }
        }
    }

    private int searchc(N v, int count, Stack<N> stack) {
        int vn = v.getKey();
        newmark[vn] = false;
        lowlink[vn] = dfnumber[vn] = count++;
        stack.push(v);
        onstack[vn] = true;
        for (N w : nexts.get(vn)) {
            int wn = w.getKey();
            if (newmark[wn]) {
                count = searchc(w, count, stack);
                if (lowlink[wn] < lowlink[vn]) {
                    lowlink[vn] = lowlink[wn];
                }
            } else if (dfnumber[wn] < dfnumber[vn] && onstack[wn] && dfnumber[wn] < lowlink[vn]) {
                lowlink[vn] = dfnumber[wn];
            }
        }
        if (lowlink[vn] == dfnumber[vn]) {
            C c = g.makeComponent();
            components.add(c);
            N x;
            do {
                x = stack.pop();
                int xn = x.getKey();
                onstack[xn] = false;
                c.add(x);
                node_component.set(x.getKey(), c);
            } while (x != v);
        }
        return count;
    }

    /**
     * Adds a new node to a component.
     */
    public void add(N n, C c) {
        c.add(n);
        node_component.add(c);
    }

    /**
     * Returns the (unmodifiable) collection of components.
     */
    public Collection<C> getComponents() {
        return Collections.unmodifiableCollection(components);
    }

    /**
     * Returns the component of the given node.
     */
    public C getComponent(N n) {
        return node_component.get(n.getKey());
    }

    @Override
    public String toString() {
        return components.toString();
    }
}
