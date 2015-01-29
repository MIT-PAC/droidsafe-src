package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.string.charset.CharSet;

/**
 * Automaton operation for <tt>String.charAt(int)</tt> with a non-constant index.
 * 
 * @author Asger
 *
 */
public class CharAt2 extends UnaryOperation {
    
    @Override
    public CharSet charsetTransfer(CharSet a) {
        return a;
    }
    
    @Override
    public Automaton op(Automaton a) {
        return a.singleChars();
    }
    
    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String toString() {
        return "charAt1";
    }
    
}
