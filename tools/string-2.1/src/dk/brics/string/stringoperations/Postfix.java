package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.State;
import dk.brics.automaton.StatePair;
import dk.brics.string.charset.CharSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Automaton operation for {@link StringBuffer#substring(int)}.
 */
public class Postfix extends UnaryOperation {

    /**
     * Constructs new operation object.
     */
    public Postfix() {
    }

    /**
     * Automaton operation.
     * Constructs new automaton as copy of <tt>a</tt> with a new initial state <i>p</i>.
     * Epsilon transitions are added from <i>p</i> to every other state.
     *
     * @param a input automaton
     * @return resulting automaton
     */
    @Override
    public Automaton op(Automaton a) {
        Automaton b = a.clone();
        State initial = new State();
        Set<StatePair> epsilons = new HashSet<StatePair>();
        for (State s : b.getStates()) {
            epsilons.add(new StatePair(initial, s));
        }
        b.setInitialState(initial);
        b.addEpsilons(epsilons);
        b.minimize();
        return b;
    }

    @Override
    public String toString() {
        return "postfix";
    }

    @Override
    public int getPriority() {
        return 4;
    }

    @Override
    public CharSet charsetTransfer(CharSet a) {
        return a;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Postfix;
    }
}
