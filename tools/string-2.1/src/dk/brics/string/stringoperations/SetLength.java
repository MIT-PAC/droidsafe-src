package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.State;
import dk.brics.automaton.StatePair;
import dk.brics.automaton.Transition;
import dk.brics.string.charset.CharSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Automaton operation for {@link StringBuffer#setLength(int)}.
 */
public class SetLength extends UnaryOperation {

    /**
     * Constructs new operation object.
     */
    public SetLength() {
    }

    /**
     * Automaton operation.
     * Constructs new automaton as copy of <tt>a</tt> where a fresh state is
     * the only accept state, it has a 0-transition to itself, all original accept states has
     * an epsilon edge to it, and every state reachable from the initial state becomes an
     * accept state.
     *
     * @param a input automaton
     * @return resulting automaton
     */
    @Override
    public Automaton op(Automaton a) {
        Automaton b = a.clone();
        State pad = new State();
        pad.setAccept(true);
        pad.addTransition(new Transition('\u0000', pad));
        Set<StatePair> epsilons = new HashSet<StatePair>();
        for (State s : b.getStates()) {
            if (s.isAccept()) {
                epsilons.add(new StatePair(s, pad));
            } else {
                s.setAccept(true);
            }
        }
        b.setDeterministic(false);
        b.addEpsilons(epsilons);
        b.minimize();
        return b;
    }

    @Override
    public String toString() {
        return "setLength";
    }

    @Override
    public int getPriority() {
        return 6;
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
        return obj instanceof SetLength;
    }
}
