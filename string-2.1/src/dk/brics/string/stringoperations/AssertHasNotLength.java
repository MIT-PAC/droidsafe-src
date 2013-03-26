package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.string.charset.CharSet;

/**
 * Asserts that the string does not have a length between <tt>min</tt> and <tt>max</tt> (inclusive)
 * 
 * @author Asger
 *
 */
public class AssertHasNotLength extends UnaryOperation {
    
    private int min, max;
    
    public AssertHasNotLength(int min, int max) {
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
            return a;
        // XXX insert safeguard against huge lengths?
        return a.intersection(Automaton.makeAnyChar().repeat(min,max).complement());
    }
    
    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String toString() {
        if (min == max)
            return "hasntLength["+min+"]";
        else
            return "hasntLength["+min+".."+max+"]";
    }
    
    @Override
    public boolean isAssertion() {
        return true;
    }
    
}
