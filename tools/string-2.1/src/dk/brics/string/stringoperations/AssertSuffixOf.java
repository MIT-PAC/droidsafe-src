package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.string.charset.CharSet;

/**
 * Asserts that the first string is a suffix of the second. This is the mirror of {@link AssertStartsWith}.
 * 
 * @author Asger
 *
 */
public class AssertSuffixOf extends BinaryOperation {

    @Override
    public CharSet charsetTransfer(CharSet a1, CharSet a2) {
        return a1.clone();
    }

    @Override
    public Automaton op(Automaton a1, Automaton a2) {
        return a1.intersection(Basic.getSuffixesOf(a2));
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String toString() {
        return "suffixOf";
    }
    
    @Override
    public boolean isAssertion() {
        return true;
    }
    
}
