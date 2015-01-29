package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.State;
import dk.brics.automaton.Transition;
import dk.brics.string.charset.CharSet;

import java.util.ArrayList;
import java.util.Set;

/**
 * Automaton operation for {@link String#replace(char,char)} where only the first character is known.
 */
public class Replace2 extends UnaryOperation {

    char c;

    /**
     * Automaton operation for {@link String#replace(char,char)} where only the first character is known.
     * @param c the known value of the first argument.
     */
    public Replace2(char c) {
        this.c = c;
    }

    /**
     * Automaton operation.
     * Constructs new automaton as copy of <tt>a</tt> where all <tt>c</tt> transitions are changed
     * to Sigma transitions.
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
                if (min <= c && c <= max) {
                    transitions.add(new Transition(Character.MIN_VALUE, Character.MAX_VALUE, dest));
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
        return "replace2[" + Basic.escapeChar(c) + "]";
    }

    @Override
    public int getPriority() {
        return 5;
    }

    @Override
    public CharSet charsetTransfer(CharSet a) {
        if (a.contains(c)) {
            return CharSet.makeAnychars();
        } else {
            return a;
        }
    }

    @Override
    public int hashCode() {
        return getClass().hashCode() + c;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Replace2) {
            Replace2 o = (Replace2) obj;
            return c == o.c;
        } else {
            return false;
        }
    }
}
