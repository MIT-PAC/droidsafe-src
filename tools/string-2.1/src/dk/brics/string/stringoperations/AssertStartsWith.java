package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.string.charset.CharSet;

/**
 * Asserts that the second string is a prefix of the first string. This is the mirror of {@link AssertPrefixOf}.
 * 
 * @author Asger
 *
 */
public class AssertStartsWith extends BinaryOperation {

    @Override
    public CharSet charsetTransfer(CharSet a1, CharSet a2) {
        return a1.clone();
    }

    @Override
    public Automaton op(Automaton a1, Automaton a2) {
        return a1.intersection(a2.concatenate(Automaton.makeAnyString()));
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String toString() {
        return "startsWith";
    }
    
    @Override
    public boolean isAssertion() {
        return true;
    }
    
}
