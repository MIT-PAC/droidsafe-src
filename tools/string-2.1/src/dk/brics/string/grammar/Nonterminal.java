package dk.brics.string.grammar;

import dk.brics.string.directedgraph.GraphNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Grammar nonterminal.
 */
public class Nonterminal implements GraphNode, Comparable<Nonterminal> {

    private List<Production> productions = new LinkedList<Production>();

    private int key;

    private boolean taint;

    Nonterminal(int key) {
        this.key = key;
    }

    public boolean isTaint() {
        return taint;
    }

    public void setTaint(boolean taint) {
        this.taint = taint;
    }

    /**
     * Returns the key of this nonterminal.
     */
    public int getKey() {
        return key;
    }

    /**
     * Returns the productions of this nonterminal.
     */
    public List<Production> getProductions() {
        return productions;
    }

    /**
     * Sets the productions of this nonterminal.
     */
    public void setProductions(List<Production> p) {
        productions = p;
    }

    public int compareTo(Nonterminal n) {
        return n.key - key;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Returns name of this nonterminal.
     */
    @Override
    public String toString() {
        return "x" + key;
    }
}
