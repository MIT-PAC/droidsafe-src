package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.State;
import dk.brics.automaton.Transition;
import dk.brics.string.charset.CharSet;

import java.util.*;

/**
 * Automaton operation for {@link String#trim()}.
 */
public class Trim extends UnaryOperation {

    /**
     * Constructs new operation object.
     */
    public Trim() {
    }

    /**
     * Automaton operation.
     * Constructs new automaton as copy of <tt>a</tt> with a new initial state and a new accept state.
     * Non-epsilon transitions are added from the new initial state to states that are reachable from the
     * old initial state in zero or more special chars followed by one non-special char, thereby skipping initial
     * special chars. Similarly, non-epsilon transitions are added from states that can reach the old
     * final state in one non-special char followed by zero or more special chars to the new final state,
     * thereby skipping final special chars. ("Special" chars are those with value less than or equal to 0x20.)
     * The new initial state is accepting if the old one could reach an accept state by zero or more special chars.
     *
     * @param a input automaton
     * @return resulting automaton
     */
    @Override
    public Automaton op(Automaton a) {
        Automaton b = a.clone();
        b.setDeterministic(false);
        Map<State, Set<State>> normal_prevs = new HashMap<State, Set<State>>();
        Map<State, Set<State>> special_prevs = new HashMap<State, Set<State>>();
        findPrevs(b, normal_prevs, special_prevs);
        Set<State> pre = findPreSet(b);
        Set<State> post = findPostSet(b, special_prevs);
        boolean initial_accept = post.contains(b.getInitialState());
        State initial = new State();
        b.setInitialState(initial);
        for (State s : pre) {
            for (Transition t : new ArrayList<Transition>(s.getTransitions())) {
                char min = t.getMin();
                char max = t.getMax();
                if (min <= '\u0020') {
                    min = '\u0021';
                }
                if (min <= max) {
                    initial.addTransition(new Transition(min, max, t.getDest()));
                }
            }
        }
        State accept = new State();
        accept.setAccept(true);
        for (State s : b.getAcceptStates()) {
            s.setAccept(false);
        }
        if (initial_accept) {
            initial.setAccept(true);
        }
        for (State s : post) {
            Set<State> prevset = normal_prevs.get(s);
            if (prevset != null) {
                for (State p : prevset) {
                    for (Transition t : new ArrayList<Transition>(p.getTransitions())) {
                        if (t.getDest() == s) {
                            char min = t.getMin();
                            char max = t.getMax();
                            if (min <= '\u0020') {
                                min = '\u0021';
                            }
                            if (min <= max) {
                                p.addTransition(new Transition(min, max, accept));
                            }
                        }
                    }
                }
            }
        }
        b.minimize();
        return b;
    }

    private Set<State> findPreSet(Automaton b) {
        Set<State> pre = new HashSet<State>();
        TreeSet<State> pending = new TreeSet<State>();
        pending.add(b.getInitialState());
        while (!pending.isEmpty()) {
            State p = pending.first();
            pending.remove(p);
            pre.add(p);
            for (Transition t : p.getTransitions()) {
                if (t.getMin() <= '\u0020') {
                    State q = t.getDest();
                    if (!pre.contains(q)) {
                        pending.add(q);
                    }
                }
            }
        }
        return pre;
    }

    private Set<State> findPostSet(Automaton b, Map<State, Set<State>> special_prevs) {
        Set<State> post = new HashSet<State>();
        TreeSet<State> pending = new TreeSet<State>();
        pending.addAll(b.getAcceptStates());
        while (!pending.isEmpty()) {
            State p = pending.first();
            pending.remove(p);
            post.add(p);
            Set<State> prevset = special_prevs.get(p);
            if (prevset != null) {
                for (State q : prevset) {
                    if (!post.contains(q)) {
                        pending.add(q);
                    }
                }
            }
        }
        return post;
    }

    private void findPrevs(Automaton b, Map<State, Set<State>> normal_prevs, Map<State, Set<State>> special_prevs) {
        for (State s : b.getStates()) {
            for (Transition t : s.getTransitions()) {
                char min = t.getMin();
                char max = t.getMax();
                State dest = t.getDest();
                if (min <= '\u0020') {
                    Set<State> prevset = special_prevs.get(dest);
                    if (prevset == null) {
                        prevset = new HashSet<State>();
                        special_prevs.put(dest, prevset);
                    }
                    prevset.add(s);
                }
                if (max > '\u0020') {
                    Set<State> prevset = normal_prevs.get(dest);
                    if (prevset == null) {
                        prevset = new HashSet<State>();
                        normal_prevs.put(dest, prevset);
                    }
                    prevset.add(s);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "trim";
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
        return obj instanceof Trim;
    }
}
