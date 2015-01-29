package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.State;
import dk.brics.automaton.StatePair;
import dk.brics.automaton.Transition;
import dk.brics.string.charset.CharSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Automaton operation for {@link StringBuffer#reverse()}.
 */
public class Reverse extends UnaryOperation {

    /**
     * Constructs new operation object.
     */
    public Reverse() {
    }

    /**
     * Automaton operation.
     * Constructs new automaton as copy of <tt>a</tt> with a fresh initial state, epsilon transitions
     * from that state to all old accept states, the old initial state as only new accept state, and all
     * transitions reversed.
     *
     * @param a input automaton
     * @return resulting automaton
     */
    @Override
    public Automaton op(Automaton a) {
        Automaton b = new Automaton();
        Map<State, State> map = new HashMap<State, State>();
        for (State s : a.getStates()) {
            State ss = new State();
            map.put(s, ss);
        }
        State initial = new State();
        b.setInitialState(initial);
        map.get(a.getInitialState()).setAccept(true);
        Set<StatePair> epsilons = new HashSet<StatePair>();
        for (State s : a.getStates()) {
            State ss = map.get(s);
            if (s.isAccept()) {
                epsilons.add(new StatePair(initial, ss));
            }
            for (Transition t : s.getTransitions()) {
                State pp = map.get(t.getDest());
                pp.addTransition(new Transition(t.getMin(), t.getMax(), ss));
            }
        }
        b.setDeterministic(false);
        b.addEpsilons(epsilons);
        b.minimize();
        return b;
    }

    @Override
    public String toString() {
        return "reverse";
    }

    @Override
    public int getPriority() {
        return 1;
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
        return obj instanceof Reverse;
    }
}
