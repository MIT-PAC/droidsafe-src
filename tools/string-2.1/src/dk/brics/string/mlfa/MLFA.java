package dk.brics.string.mlfa;

import dk.brics.automaton.Automaton;
import dk.brics.string.stringoperations.BinaryOperation;
import dk.brics.string.stringoperations.UnaryOperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * MLFA.
 *
 * @author Anders M&oslash;ller &lt;<a href="mailto:amoeller@cs.au.dk">amoeller@cs.au.dk</a>&gt;
 */
public class MLFA {

    private List<MLFAState> states;

    /**
     * Constructs new empty MLFA.
     */
    public MLFA() {
        states = new ArrayList<MLFAState>();
    }

    /**
     * Adds a new state to this MLFA.
     *
     * @return new state
     */
    public MLFAState addState() {
        MLFAState s = new MLFAState(states.size());
        states.add(s);
        return s;
    }

    /**
     * Adds new identity transition to this MLFA.
     *
     * @param p source state
     * @param q target state
     * @param r pair of initial and final state at lower level
     */
    public void addIdentityTransition(MLFAState p, MLFAState q, MLFAStatePair r) {
        p.addEdge(new IdentityTransition(r.getFirstState(), r.getSecondState()), q);
    }

    /**
     * Adds new automaton transition to this MLFA.
     *
     * @param p source state
     * @param q target state
     * @param a (minimized) automaton at lower level
     */
    public void addAutomatonTransition(MLFAState p, MLFAState q, Automaton a) {
        p.addEdge(new AutomatonTransition(a), q);
    }

    /**
     * Adds new unary operation transition to this MLFA.
     *
     * @param p  source state
     * @param q  target state
     * @param op operation to perform on lower level
     * @param r  pair of initial and final state at lower level
     */
    public void addUnaryTransition(MLFAState p, MLFAState q, UnaryOperation op, MLFAStatePair r) {
        p.addEdge(new UnaryTransition(op, r.getFirstState(), r.getSecondState()), q);
    }

    /**
     * Adds new binary operation transition to this MLFA.
     *
     * @param p  source state
     * @param q  target state
     * @param op operation to perform on lower level
     * @param r  first pair of initial and final state at lower level
     * @param s  second pair of initial and final state at lower level
     */
    public void addBinaryTransition(MLFAState p, MLFAState q, BinaryOperation op, MLFAStatePair r, MLFAStatePair s) {
        p.addEdge(new BinaryTransition(op, r.getFirstState(), r.getSecondState(),
                s.getFirstState(), s.getSecondState()), q);
    }

    /**
     * Adds new epsilon transition to this MLFA.
     *
     * @param p source state
     * @param q target state
     */
    public void addEpsilonTransition(MLFAState p, MLFAState q) {
        p.addEdge(new EpsilonTransition(), q);
    }

    /**
     * Returns number of states in this MLFA.
     */
    public int getNumberOfStates() {
        return states.size();
    }

    /**
     * Returns the (unmodifiable) list of states in this MLFA.
     */
    public List<MLFAState> getStates() {
        return Collections.unmodifiableList(states);
    }

    /**
     * Returns string representation of this MLFA.
     */
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        for (MLFAState s : states) {
            for (MLFAEdge e : s.getEdges()) {
                b.append(s).append("--").append(e.getTransition()).append("-->").append(e.getDestination()).append("\n");
            }
        }
        return b.toString();
    }
}
