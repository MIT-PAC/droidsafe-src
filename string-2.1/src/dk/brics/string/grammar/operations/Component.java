package dk.brics.string.grammar.operations;

import dk.brics.string.directedgraph.GraphComponent;
import dk.brics.string.grammar.Nonterminal;
import dk.brics.string.grammar.PairProduction;
import dk.brics.string.grammar.Production;
import dk.brics.string.mlfa.MLFAState;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Strongly connected component.
 */
public class Component implements GraphComponent<Nonterminal> {

    public enum Recursion {
        NONE, RIGHT, LEFT, BOTH
    }

    ;

    private Recursion recursion;

    private Collection<Nonterminal> nonterminals = new ArrayList<Nonterminal>();

    private MLFAState state;

    /**
     * Constructs a new empty component.
     */
    public Component() {
    }

    public void add(Nonterminal n) {
        nonterminals.add(n);
    }

    /**
     * Returns the (unmodifiable) collection of nonterminals for this component.
     */
    public Collection<Nonterminal> getNodes() {
        return Collections.unmodifiableCollection(nonterminals);
    }

    /**
     * Finds recursion kind for this components.
     */
    public void findRecursion() {
        recursion = Recursion.NONE;
        for (Nonterminal n : nonterminals) {
            for (Production p : n.getProductions()) {
                if (p instanceof PairProduction) {
                    PairProduction pp = (PairProduction) p;
                    if (nonterminals.contains(pp.getNonterminal1())) {
                        add(Recursion.LEFT);
                    }
                    if (nonterminals.contains(pp.getNonterminal2())) {
                        add(Recursion.RIGHT);
                    }
                }
            }
        }
    }

    private void add(Recursion r) {
        if (recursion == Recursion.NONE) {
            recursion = r;
        }
        if (recursion != r) {
            recursion = Recursion.BOTH;
        }
    }

    /**
     * Checks whether the given nonterminal is in this component.
     */
    public boolean contains(Nonterminal x) {
        return nonterminals.contains(x);
    }

    /**
     * Returns recursion kind for this component.
     */
    public Recursion getRecursion() {
        return recursion;
    }

    /**
     * Sets recursion kind for this component.
     */
    public void setRecursion(Recursion r) {
        recursion = r;
    }

    /**
     * Sets the MLFA state of this component.
     */
    public void setState(MLFAState s) {
        state = s;
    }

    /**
     * Returns the MLFA state of this component.
     */
    public MLFAState getState() {
        return state;
    }

    @Override
    public String toString() {
        return nonterminals.toString() + recursion;
    }
}
