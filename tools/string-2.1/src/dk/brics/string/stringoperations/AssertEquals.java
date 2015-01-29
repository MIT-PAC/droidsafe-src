package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.string.charset.CharSet;

/**
 * String operation asserting that one string is equal to another. The result is the intersection
 * of their automata.
 * 
 * @author Asger
 *
 */
public class AssertEquals extends BinaryOperation {

    @Override
    public CharSet charsetTransfer(CharSet a1, CharSet a2) {
        return a1.intersection(a2);
    }
    
    @Override
    public Automaton op(Automaton a1, Automaton a2) {
        return a1.intersection(a2);
    }
    
    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String toString() {
        return "equals";
    }
    
    @Override
    public boolean isAssertion() {
        return true;
    }
    
    
    
}
