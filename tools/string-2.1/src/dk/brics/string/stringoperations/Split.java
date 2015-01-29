package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.string.charset.CharSet;

/**
 * Automaton operation used for <tt>String.split(String)</tt>. It produces an automaton
 * accepting every substring of the strings accepted by the input automaton.
 * 
 * @author Asger
 *
 */
public class Split extends UnaryOperation {
    
    /* XXX split precision
     * A more precise solution may be possible by analyzing the regular expression given.
     * However, the syntax used by split may differ from that of the automaton package we use,
     * so some rewriting would be necessary.
     */
    
    @Override
    public CharSet charsetTransfer(CharSet a) {
        return a;
    }
    
    @Override
    public Automaton op(Automaton a) {
        return Basic.getSubstringsOf(a);
    }
    
    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String toString() {
        return "split";
    }
    
}
