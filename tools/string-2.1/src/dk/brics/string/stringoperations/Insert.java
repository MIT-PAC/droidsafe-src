package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.State;
import dk.brics.automaton.StatePair;
import dk.brics.string.charset.CharSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Automaton operation for {@link StringBuffer#insert(int,Object)} and related methods.
 */
public class Insert extends BinaryOperation {

    /**
     * Constructs new operation object.
     */
    public Insert() {
    }

    /**
     * Automaton operation.
     * Constructs new automaton as two copies, <i>a1</i> and <i>a2</i>, of <tt>a</tt> and
     * one copy, <i>b</i>, of <tt>b</tt>.  The initial state is the one from <i>a1</i>, the accept states
     * are those in <i>a2</i>. Epsilon transitions are added from each state in <i>a1</i> to the
     * initial state in <i>b</i> and from each accept state in <i>b</i> to each state in <i>a2</i>.
     *
     * @param a first input automaton
     * @param b second input automaton
     * @return resulting automaton
     */
    @Override
    public Automaton op(Automaton a, Automaton b) {
        return pop(a, b);
    }

    static Automaton pop(Automaton a, Automaton b) {
        Automaton a1 = a.clone();
        Automaton a2 = a.clone();
        Automaton bb = b.clone();
        Set<StatePair> epsilons = new HashSet<StatePair>();
        for (State s : a1.getStates()) {
            s.setAccept(false);
            epsilons.add(new StatePair(s, bb.getInitialState()));
        }
        for (State s : bb.getAcceptStates()) {
            s.setAccept(false);
            for (State p : a2.getStates()) {
                epsilons.add(new StatePair(s, p));
            }
        }
        a1.addEpsilons(epsilons);
        a1.minimize();
        return a1;
    }

    @Override
    public String toString() {
        return "insert";
    }

    @Override
    public int getPriority() {
        return 8;
    }

    @Override
    public CharSet charsetTransfer(CharSet a1, CharSet a2) {
        return a1.union(a2);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Insert;
    }
}
