package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.string.charset.CharSet;

/**
 * Asserts that the string has a length between <tt>min</tt> and <tt>max</tt> (inclusive)
 * 
 * @author Asger
 *
 */
public class AssertHasLength extends UnaryOperation {
    
    private int min, max;
    
    public AssertHasLength(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public CharSet charsetTransfer(CharSet a) {
        return a;
    }

    @Override
    public Automaton op(Automaton a) {
        if (min > max)
            return Automaton.makeEmpty();
        // XXX insert safeguard against huge lengths?
        return a.intersection(Automaton.makeAnyChar().repeat(min,max));
    }
    
    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String toString() {
        if (min == max)
            return "hasLength["+min+"]";
        else
            return "hasLength["+min+".."+max+"]";
    }
    
    @Override
    public boolean isAssertion() {
        return true;
    }
    
}
