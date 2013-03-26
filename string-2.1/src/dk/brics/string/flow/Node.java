package dk.brics.string.flow;

import java.util.HashSet;
import java.util.Set;

/**
 * Superclass for flow graph nodes. A node represent a definition (a variable or expression).
 */
public abstract class Node implements Comparable<Node> {

    /**
     * Uses of this node.
     */
    private Set<Use> uses = new HashSet<Use>();

    private int key;

    private boolean taint;

    Node(int key) {
        this.key = key;
    }

    /**
     * Returns set of {@link Use} objects representing uses of this definition.
     */
    public Set<Use> getUses() {
        return uses;
    }

    /**
     * Returns the index of this node.
     */
    public int getIndex() {
        return key;
    }

    /**
     * Sets the index of this node.
     */
    void setIndex(int index) {
        key = index;
    }

    /**
     * Visitor.
     */
    public abstract void visitBy(NodeVisitor v);

    public boolean isTaint() {
        return taint;
    }

    public void setTaint(boolean taint) {
        this.taint = taint;
    }

    /**
     * Returns name of this node.
     */
    @Override
    public String toString() {
        return "N" + key;
    }

    public int compareTo(Node n) {
        return key - n.key;
    }
}
