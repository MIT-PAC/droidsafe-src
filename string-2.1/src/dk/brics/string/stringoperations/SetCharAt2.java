package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.State;
import dk.brics.automaton.Transition;
import dk.brics.string.charset.CharSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Automaton operation for {@link StringBuffer#setCharAt(int,char)} where the character is unknown.
 */
public class SetCharAt2 extends UnaryOperation {

    /**
     * Automaton operation for {@link StringBuffer#setCharAt(int,char)} where the character is unknown.
     */
    public SetCharAt2() {
    }

    /**
     * Automaton operation.
     * Constructs new automaton from two copies, <i>a1</i> and <i>a2</i>, of <tt>a</tt>.
     * The initial state is the one from <i>a1</i>, the accept states
     * are those in <i>a2</i>. Extra Sigma transitions are added from each state <i>q</i> in <i>a1</i> to the
     * the states in <i>a2</i> that are reachable in exactly one step from the one that corresponds to <i>q</i>.
     *
     * @param a input automaton
     * @return resulting automaton
     */
    @Override
    public Automaton op(Automaton a) {
        Automaton a1 = a.clone();
        Map<State, State> map = new HashMap<State, State>();
        Set<State> a1s = a1.getStates();
        for (State s : a1s) {
            State p = new State();
            map.put(s, p);
            if (s.isAccept()) {
                p.setAccept(true);
                s.setAccept(false);
            }
        }
        for (State s : a1s) {
            State p = map.get(s);
            for (Transition t : s.getTransitions()) {
                p.addTransition(new Transition(t.getMin(), t.getMax(), map.get(t.getDest())));
            }
        }
        a1.setDeterministic(false);
        for (State s : a1s) {
            for (Transition t : map.get(s).getTransitions()) {
                s.addTransition(new Transition(Character.MIN_VALUE, Character.MAX_VALUE, t.getDest()));
            }
        }
        a1.minimize();
        return a1;
    }

    @Override
    public String toString() {
        return "setCharAt2";
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
        return obj instanceof SetCharAt2;
    }
}
