package dk.brics.string.stringoperations;

import dk.brics.automaton.BasicOperations;
import dk.brics.automaton.Automaton;
import dk.brics.automaton.Transition;
import dk.brics.automaton.State;
import dk.brics.automaton.StatePair;
import dk.brics.string.charset.CharSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Automaton operation for {@link
 * StringBuffer#substring(int)}. Assumes that the int is known. Will
 * give a more precise result in the case that the automaton is a
 * linear series of transitions with no cycles.
 */
public class Postfix2 extends UnaryOperation {

    private int start;
    /**
     * Constructs new operation object.
     */
    public Postfix2(int start) {
        this.start = start;
    }

    public int getStart() {
        return start;
    }

     @Override
     public Automaton op(Automaton a) {
        Automaton b = a.clone();
        Set<State> visited = new HashSet<State>();
        Set<Transition> trans;
        State cur = b.getInitialState();

        // Skip over initial segment
        for(int i = 0; i < start; i++) {
            visited.add(cur);
            trans = cur.getTransitions();
            if (trans.size() != 1) {
                return opFailed(a);
            }

            cur = ((Transition)trans.toArray()[0]).getDest();
            if (visited.contains(cur)) 
                return opFailed(a);
            b.setInitialState(cur);
        }
        return b;
    }


    /**
     * Automaton operation.
     * Constructs new automaton as copy of <tt>a</tt> with a new initial state <i>p</i>.
     * Epsilon transitions are added from <i>p</i> to every other state.
     *
     * @param a input automaton
     * @return resulting automaton
     */
    public Automaton opFailed(Automaton a) {
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
        return "postfix2(" + start + ")";
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
