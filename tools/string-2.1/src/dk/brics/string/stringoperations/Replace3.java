package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.State;
import dk.brics.automaton.Transition;
import dk.brics.string.charset.CharSet;

import java.util.ArrayList;
import java.util.Set;

/**
 * Automaton operation for {@link String#replace(char,char)} where only the second character is known.
 */
public class Replace3 extends UnaryOperation {

    char d;

    /**
     * Automaton operation for {@link String#replace(char,char)} where only the second character is known.
     * @param d the known value of the second argument.
     */
    public Replace3(char d) {
        this.d = d;
    }

    /**
     * Automaton operation.
     * Constructs new automaton as copy of <tt>a</tt> where all transitions are supplemented with <tt>d</tt>
     * transitions.
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
                transitions.add(new Transition(d, dest));
            }
        }
        b.setDeterministic(false);
        b.reduce();
        b.minimize();
        return b;
    }

    @Override
    public String toString() {
        return "replace3[" + Basic.escapeChar(d) + "]";
    }

    @Override
    public int getPriority() {
        return 6;
    }

    @Override
    public CharSet charsetTransfer(CharSet a) {
        return a.add(d);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode() + d;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Replace3) {
            Replace3 o = (Replace3) obj;
            return d == o.d;
        } else {
            return false;
        }
    }
}
