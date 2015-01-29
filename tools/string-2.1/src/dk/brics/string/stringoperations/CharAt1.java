package dk.brics.string.stringoperations;

import java.util.HashSet;
import java.util.Set;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.State;
import dk.brics.automaton.Transition;
import dk.brics.string.charset.CharSet;

/**
 * Automaton operation for <tt>String.charAt(int)</tt> with a constant index.
 * 
 * @author Asger
 *
 */
public class CharAt1 extends UnaryOperation {
    
    private int index;
    
    public CharAt1(int index) {
        this.index = index;
    }

    @Override
    public CharSet charsetTransfer(CharSet a) {
        return a;
    }

    @Override
    public Automaton op(Automaton a) {
        // find all states reachable in N steps that may reach an accept state
        // TODO: insert check for huge integer constant. no reason to stall the analysis because of that.
        Set<State> queue = new HashSet<State>();
        Set<State> queue2 = new HashSet<State>();
        queue.add(a.getInitialState());
        for (int i=0; i<index; i++) {
            for (State state : queue) {
                for (Transition t : state.getTransitions()) {
                    queue2.add(t.getDest());
                }
            }
            
            // switch buffers
            queue.clear();
            Set<State> tmp = queue;
            queue = queue2;
            queue2 = tmp;
        }
        
        Automaton result = new Automaton();
        State initial = result.getInitialState();
        State accept = new State();
        accept.setAccept(true);
        
        Set<State> live = a.getLiveStates();
        for (State state : queue) {
            for (Transition t : state.getTransitions()) {
                if (live.contains(t.getDest())) {
                    initial.addTransition(new Transition(t.getMin(), t.getMax(), accept));
                }
            }
        }
        
        // boilerplate stuff
        result.restoreInvariant();
        result.reduce();
        result.determinize();
        result.minimize();
        
        return result;
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String toString() {
        return "charAt1";
    }
    
}
