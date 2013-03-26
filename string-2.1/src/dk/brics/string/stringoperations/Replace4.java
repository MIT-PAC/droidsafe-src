package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.State;
import dk.brics.automaton.Transition;
import dk.brics.string.charset.CharSet;

import java.util.ArrayList;
import java.util.Set;

/**
 * Automaton operation for {@link String#replace(char,char)} where neither character is known.
 */
public class Replace4 extends UnaryOperation {

    /**
     * Automaton operation for {@link String#replace(char,char)} where neither character is known.
     */
    public Replace4() {
    }

    /**
     * Automaton operation.
     * Constructs new automaton as copy of <tt>a</tt> where all transitions are
     * replaced by Sigma transitions.
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
                State dest = t.getDest();
                transitions.remove(t);
                transitions.add(new Transition(Character.MIN_VALUE, Character.MAX_VALUE, dest));
            }
        }
        b.setDeterministic(false);
        b.reduce();
        b.minimize();
        return b;
    }

    @Override
    public String toString() {
        return "replace4";
    }

    @Override
    public int getPriority() {
        return 7;
    }

    @Override
    public CharSet charsetTransfer(CharSet a) {
        return CharSet.makeAnychars();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Replace4;
    }
}
