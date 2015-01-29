package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.string.charset.CharSet;

/**
 * Asserts that the string is not empty. There is no <tt>AssertEmpty</tt> operation since
 * an assignment to the empty string is used instead.
 * 
 * @author Asger
 *
 */
public class AssertNotEmpty extends UnaryOperation {

    @Override
    public CharSet charsetTransfer(CharSet a) {
        return a;
    }

    @Override
    public Automaton op(Automaton a) {
        return a.minus(Automaton.makeEmptyString());
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String toString() {
        return "notEmpty";
    }
    
    @Override
    public boolean isAssertion() {
        return true;
    }
    
}
