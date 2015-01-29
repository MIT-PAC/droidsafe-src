package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.string.charset.CharSet;

/**
 * Asserts that the string is empty.
 * 
 * @author Asger
 *
 */
public class AssertEmpty extends UnaryOperation {

    @Override
    public CharSet charsetTransfer(CharSet a) {
        return a;
    }

    @Override
    public Automaton op(Automaton a) {
        return a.intersection(Automaton.makeEmptyString());
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String toString() {
        return "isEmpty";
    }
    
    @Override
    public boolean isAssertion() {
        return true;
    }
    
}
