package dk.brics.string.mlfa.operations;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.State;
import dk.brics.automaton.StatePair;
import dk.brics.string.mlfa.*;

import java.util.*;

/**
 * Converter from MLFAs to automata.
 *
 * @see dk.brics.string.StringAnalysis
 */
public class MLFA2Automaton {

    private Map<MLFAStatePair, Automaton> memo;

    private List<Set<MLFAState>> succs, prevs;

    private List<Set<MLFAState>> forward_reachable, backward_reachable;

    /**
     * Construcs a new converter for the given MLFA.
     */
    public MLFA2Automaton(MLFA m) {
        memo = new HashMap<MLFAStatePair, Automaton>();
        succs = new ArrayList<Set<MLFAState>>();
        prevs = new ArrayList<Set<MLFAState>>();
        forward_reachable = new ArrayList<Set<MLFAState>>();
        backward_reachable = new ArrayList<Set<MLFAState>>();
        for (int i = 0; i < m.getNumberOfStates(); i++) {
            succs.add(new HashSet<MLFAState>());
            prevs.add(new HashSet<MLFAState>());
            forward_reachable.add(null);
            backward_reachable.add(null);
        }
        for (MLFAState s : m.getStates()) {
            for (MLFAEdge e : s.getEdges()) {
                MLFAState d = e.getDestination();
                succs.get(s.getKey()).add(d);
                prevs.get(d.getKey()).add(s);
            }
        }
    }

    /**
     * Extracts ordinary minimal deterministic finite automaton from the MLFA.
     *
     * @param p pair representing initial and final state
     * @return minimal deterministic finite automaton (should not be modified by caller)
     */
    public Automaton extract(MLFAStatePair p) {
        return extract(p.getFirstState(), p.getSecondState(), new HashSet<MLFAStatePair>());
    }

    private Automaton extract(MLFAState s, MLFAState f, final Set<MLFAStatePair> stack) {
        MLFAStatePair p = new MLFAStatePair(s, f);
        Automaton a = memo.get(p);
        if (a != null) {
            return a;
        }
        if (stack.contains(p)) {
            throw new RuntimeException("MLFA is non-rankable");
        }
        stack.add(p);
        Set<MLFAState> reachable = findReachable(s, f);

        // handle special case with just one automaton/epsilon/identity transition from s to f
        if (((s != f && reachable.size() == 2) || (s == f && reachable.size() == 1))
                && s.getEdges().size() == 1 && f.getEdges().size() == 0) {
            MLFATransition t = s.getEdges().iterator().next().getTransition();
            a = t.visitBy(new TransitionVisitor<Automaton>() {

                public Automaton visitAutomatonTransition(AutomatonTransition t) {
                    return t.getAutomaton();
                }

                public Automaton visitEpsilonTransition(EpsilonTransition t) {
                    return Automaton.makeEmptyString();
                }

                public Automaton visitIdentityTransition(IdentityTransition t) {
                    return extract(t.getStartState(), t.getFinalState(), stack);
                }

                public Automaton visitUnaryTransition(UnaryTransition t) {
                    return null;
                }

                public Automaton visitBinaryTransition(BinaryTransition t) {
                    return null;
                }
            });
        }
        if (a == null) {
            a = new Automaton();

            // construct automaton states
            Map<MLFAState, State> statemap = new HashMap<MLFAState, State>();
            for (MLFAState q : reachable) {
                State ss = new State();
                statemap.put(q, ss);
                if (q == s) {
                    a.setInitialState(ss);
                }
                if (q == f) {
                    ss.setAccept(true);
                }
            }

            // add transitions
            final Set<StatePair> epsilons = new HashSet<StatePair>();
            for (MLFAState q : reachable) {
                for (MLFAEdge e : q.getEdges()) {
                    if (reachable.contains(e.getDestination())) {
                        final State qq = statemap.get(q);
                        final State pp = statemap.get(e.getDestination());
                        Automaton b = e.getTransition().visitBy(new TransitionVisitor<Automaton>() {

                            public Automaton visitAutomatonTransition(AutomatonTransition t) {
                                return t.getAutomaton().clone();
                            }

                            public Automaton visitEpsilonTransition(EpsilonTransition t) {
                                epsilons.add(new StatePair(qq, pp));
                                return null;
                            }

                            public Automaton visitIdentityTransition(IdentityTransition t) {
                                return extract(t.getStartState(), t.getFinalState(), stack).clone();
                            }

                            public Automaton visitUnaryTransition(UnaryTransition t) {
                                return t.getOperation().op(extract(t.getStartState(), t.getFinalState(), stack));
                            }

                            public Automaton visitBinaryTransition(BinaryTransition t) {
                                return t.getOperation().op(
                                        extract(t.getStartState1(), t.getFinalState1(), stack),
                                        extract(t.getStartState2(), t.getFinalState2(), stack));
                            }
                        });
                        if (b != null) {
                            epsilons.add(new StatePair(qq, b.getInitialState()));
                            for (State rr : b.getAcceptStates()) {
                                rr.setAccept(false);
                                epsilons.add(new StatePair(rr, pp));
                            }
                        }
                    }
                }
            }
            a.addEpsilons(epsilons);
            // a.minimize();
        }
        stack.remove(p);
        memo.put(p, a);
        return a;
    }

    private Set<MLFAState> getForwardReachable(MLFAState s) { // TODO: improve performance of getXXReachable using strongly connected components?
        Set<MLFAState> reachable = forward_reachable.get(s.getKey());
        if (reachable == null) {
            reachable = new HashSet<MLFAState>();
            Set<MLFAState> pending = new HashSet<MLFAState>();
            pending.add(s);
            while (!pending.isEmpty()) {
                MLFAState p = pending.iterator().next();
                pending.remove(p);
                reachable.add(p);
                for (MLFAState q : succs.get(p.getKey())) {
                    if (!reachable.contains(q)) {
                        pending.add(q);
                    }
                }
            }
            forward_reachable.set(s.getKey(), reachable);
        }
        return reachable;
    }

    private Set<MLFAState> getBackwardReachable(MLFAState s) {
        Set<MLFAState> reachable = backward_reachable.get(s.getKey());
        if (reachable == null) {
            reachable = new HashSet<MLFAState>();
            Set<MLFAState> pending = new HashSet<MLFAState>();
            pending.add(s);
            while (!pending.isEmpty()) {
                MLFAState p = pending.iterator().next();
                pending.remove(p);
                reachable.add(p);
                for (MLFAState q : prevs.get(p.getKey())) {
                    if (!reachable.contains(q)) {
                        pending.add(q);
                    }
                }
            }
            backward_reachable.set(s.getKey(), reachable);
        }
        return reachable;
    }

    /**
     * Finds states that are reachable from p and can reach f.
     */
    private Set<MLFAState> findReachable(MLFAState p, MLFAState f) {
        Set<MLFAState> r = new HashSet<MLFAState>(getForwardReachable(p));
        r.retainAll(getBackwardReachable(f));
        return r;
    }
}
