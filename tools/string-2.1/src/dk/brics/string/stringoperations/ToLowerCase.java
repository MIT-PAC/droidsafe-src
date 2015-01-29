package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.State;
import dk.brics.automaton.Transition;
import dk.brics.string.charset.CharSet;

import java.util.ArrayList;
import java.util.Set;

/**
 * Automaton operation for {@link String#toLowerCase()}.
 */
public class ToLowerCase extends UnaryOperation {

    /**
     * Constructs new operation object.
     */
    public ToLowerCase() {
    }

    /**
     * Automaton operation.
     * Constructs new automaton as copy of <tt>a</tt> where all characters in all transitions are
     * converted to lower case, except that Sigma transitions are left unchanged.
     *
     * @param a input automaton
     * @return resulting automaton
     */
    @Override
    public Automaton op(Automaton a) {
        Automaton b = a.clone();
        for (State s : b.getStates()) {
            Set<Transition> transitions = s.getTransitions();
            for (Transition t : new ArrayList<Transition>(transitions)) {
                char min = t.getMin();
                char max = t.getMax();
                State dest = t.getDest();
                if (min != Character.MIN_VALUE || max != Character.MAX_VALUE) {
                    transitions.remove(t);
                    for (int c = min; c <= max; c++) {
                        transitions.add(new Transition(Character.toLowerCase((char) c), dest));
                    }
                }
            }
        }
        b.setDeterministic(false);
        b.reduce();
        b.minimize();
        return b;
    }

    @Override
    public String toString() {
        return "toLowerCase";
    }

    @Override
    public int getPriority() {
        return 2;
    }

    @Override
    public CharSet charsetTransfer(CharSet a) {
        return a.toLowerCase();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ToLowerCase;
    }
}
