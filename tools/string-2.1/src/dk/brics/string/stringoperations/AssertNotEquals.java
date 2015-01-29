package dk.brics.string.stringoperations;

import java.util.Set;

import dk.brics.automaton.Automaton;
import dk.brics.string.charset.CharSet;

/**
 * String operation asserting that one string is equal to another. The result is the intersection
 * of their automata.
 * 
 * @author Asger
 *
 */
public class AssertNotEquals extends BinaryOperation {

    @Override
    public CharSet charsetTransfer(CharSet a1, CharSet a2) {
        return a1;
    }
    
    @Override
    public Automaton op(Automaton a1, Automaton a2) {
        // if the other automaton may only be one string, remove that from the language
        // otherwise, we can't do anything
        Set<String> strings = a2.getFiniteStrings(1);
        if (strings == null)
            return a1;
        
        return a1.intersection(a2.complement());
    }
    
    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String toString() {
        return "notEquals";
    }
    
    @Override
    public boolean isAssertion() {
        return true;
    }
    
    
}
