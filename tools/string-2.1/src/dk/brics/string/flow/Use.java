package dk.brics.string.flow;

import dk.brics.string.Debug;

import java.util.*;

/**
 * Set of incoming flow edges.
 * Has references to all corresponding definitions.
 */
public class Use {

    /**
     * Flow graph node of this use.
     */
    private Node user;

    /**
     * Definitions for this use.
     */
    Set<Node> defs;

    /**
     * Constructs a bew use.
     */
    public Use(Node user) {
        this.user = user;
        defs = new HashSet<Node>();
    }

    /**
     * Returns user node for this use.
     */
    public Node getUser() {
        return user;
    }

    /**
     * Adds definition node to this use and vice versa.
     * Should be invoked if there is a possible flow from the given definition to this use.
     */
    public void addDefUse(Node def) {
        defs.add(def);
        def.getUses().add(this);
    }

    /**
     * Adds definition node to this use.
     */
    public void addDef(Node def) {
        defs.add(def);
    }

    /**
     * Removes definition node from this use.
     */
    public void removeDef(Node def) {
        defs.remove(def);
    }

    /**
     * Returns (unmodifiable) collection of definition nodes for this use.
     * The result is sorted if in test mode.
     */
    public Collection<Node> getDefs() {
        Collection<Node> r = defs;
        if (Debug.isTest()) {
            r = new TreeSet<Node>(r);
        }
        return Collections.unmodifiableCollection(r);
    }

    /**
     * Returns hashcode for the definition nodes for this use.
     */
    public int getDefsHashCode() {
        return defs.hashCode();
    }

    /**
     * Checks whether this and the given use have the same definition nodes.
     */
    public boolean equalDefs(Use u) {
        return defs.equals(u.defs);
    }

    /**
     * Clears the set of definitions.
     */
    public void clearDefs() {
        defs.clear();
    }
}
