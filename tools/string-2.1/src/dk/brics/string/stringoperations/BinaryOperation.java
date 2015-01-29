package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.string.charset.CharSet;

/**
 * Abstract superclass for binary operations.
 */
abstract public class BinaryOperation extends Operation {

    /**
     * Binary operation on automata.
     *
     * @param a1 first input automaton, should not be modified
     * @param a2 second input automaton, should not be modified
     * @return output automaton
     */
    abstract public Automaton op(Automaton a1, Automaton a2);

    /**
     * Transfer function for character set analysis.
     */
    abstract public CharSet charsetTransfer(CharSet a1, CharSet a2);
    
    /**
     * Returns whether this operation is an assertion. By default,
     * this returns <tt>false</tt>.
     * <p/>
     * This is used when breaking operation cycles in the grammar.
     */
    public boolean isAssertion() {
        return false;
    }
}
