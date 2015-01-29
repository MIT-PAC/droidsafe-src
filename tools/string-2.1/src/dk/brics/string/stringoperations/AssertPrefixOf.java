package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.string.charset.CharSet;

/**
 * Asserts that the first string is a prefix of the second. This is the mirror of {@link AssertStartsWith}.
 * 
 * @author Asger
 *
 */
public class AssertPrefixOf extends BinaryOperation {

    @Override
    public CharSet charsetTransfer(CharSet a1, CharSet a2) {
        return a1.clone();
    }

    @Override
    public Automaton op(Automaton a1, Automaton a2) {
        return a1.intersection(Basic.getPrefixesOf(a2));
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String toString() {
        return "prefixOf";
    }
    
    @Override
    public boolean isAssertion() {
        return true;
    }
    
}
