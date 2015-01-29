package dk.brics.string.grammar;

import dk.brics.automaton.Automaton;
import dk.brics.string.stringoperations.Basic;

/**
 * Automaton production [<tt>a -> reg</tt>].
 */
public class AutomatonProduction extends Production {

    Automaton n;

    AutomatonProduction(Automaton n) {
        this.n = n;
    }

    /**
     * Returns the automaton.
     */
    public Automaton getAutomaton() {
        return n;
    }

    @Override
    public String toString() {
        return Basic.getName(n);
    }

    @Override
    public void visitBy(Nonterminal a, ProductionVisitor v) {
        v.visitAutomatonProduction(a, this);
    }
}
