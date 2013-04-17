package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.BasicOperations;
import dk.brics.automaton.State;
import dk.brics.automaton.StatePair;
import dk.brics.automaton.Transition;
import dk.brics.string.charset.CharSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Automaton operation for {@link
 * StringBuffer#substring(int,int)}. Assumes that the int is
 * known. Will give a more precise result in the case that the
 * automaton is a linear series of transitions with no cycles.
 */
public class Substring2 extends UnaryOperation {

    private int start;
    private int end;
    /**
     * Constructs new operation object.
     */
    public Substring2(int start,int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Automaton operation.
     * Constructs new automaton as copy of <tt>a</tt> with a new initial state <i>p</i> and a new accept state <i>s</i>.
     * Epsilon transitions are added from <i>p</i> to every other state and from all those to <i>s</i>.
     *
     * @param a input automaton
     * @return resulting automaton
     */
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

        // Cur contains the current state.

        // Collect the substring
        State temp = new State();
        b.setInitialState(temp);
        for (int i = start; i < end; i++) {
            temp.setAccept(false);
            visited.add(cur);

            trans = cur.getTransitions();
            if (trans.size() != 1) {
                return opFailed(a);
            }

            Transition t = (Transition) trans.toArray()[0];

            State next = t.getDest();
            if (visited.contains(next))
                return opFailed(a);

            State newTemp = new State();
            Transition tx = new Transition(t.getMin(),t.getMax(),newTemp);
            temp.addTransition(tx);
            cur = next;
            temp = newTemp;
            temp.setAccept(true);
        }
        temp.setAccept(true);
        b.minimize();
        return b;

    }


    private Automaton opFailed(Automaton a) {
        Automaton b = a.clone();
        State initial = new State();
        State accept = new State();
        accept.setAccept(true);
        Set<StatePair> epsilons = new HashSet<StatePair>();
        for (State s : b.getStates()) {
            epsilons.add(new StatePair(initial, s));
            epsilons.add(new StatePair(s, accept));
        }
        b.setInitialState(initial);
        b.addEpsilons(epsilons);
        b.minimize();
        return b;
    }




    @Override
    public String toString() {
        return "substring(" + start + "," + end + ")";
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
        return obj instanceof Substring;
    }
}
