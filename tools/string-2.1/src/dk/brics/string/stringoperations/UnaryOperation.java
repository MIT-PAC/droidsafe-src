package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.string.charset.CharSet;

/**
 * Abstract superclass for unary operations.
 */
abstract public class UnaryOperation extends Operation {

    /**
     * Unary operation on automata.
     *
     * @param a input automaton, should not be modified
     * @return output automaton
     */
    abstract public Automaton op(Automaton a);

    /**
     * Transfer function for character set analysis.
     */
    abstract public CharSet charsetTransfer(CharSet a);
    
    /**
     * Returns whether this is an assertion.
     * Unary assertions must output a strict subset language of the input language.
     */
    public boolean isAssertion() {
        return false;
    }
}
