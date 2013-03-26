package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.string.charset.CharSet;

/**
 * Asserts that the second string is a suffix of the first string. This is the mirror of {@link AssertSuffixOf}.
 * 
 * @author Asger
 *
 */
public class AssertEndsWith extends BinaryOperation {

    @Override
    public CharSet charsetTransfer(CharSet a1, CharSet a2) {
        return a1.clone();
    }

    @Override
    public Automaton op(Automaton a1, Automaton a2) {
        return a1.intersection(Automaton.makeAnyString().concatenate(a2));
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String toString() {
        return "endsWith";
    }
    
    @Override
    public boolean isAssertion() {
        return true;
    }
    
}
