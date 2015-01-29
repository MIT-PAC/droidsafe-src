package dk.brics.string.stringoperations;

import java.util.Set;

import dk.brics.automaton.Automaton;
import dk.brics.string.charset.CharSet;

/**
 * Automaton operation for <tt>String.contains(String)</tt>.
 * @author Asger
 *
 */
public class Contains extends BinaryOperation {
    
    @Override
    public CharSet charsetTransfer(CharSet a1, CharSet a2) {
        // even if the charsets are disjoint, the argument could be the empty string
        // so we cannot deduce anything here
        return Basic.getBinaryBooleanCharSet();
    }
    
    @Override
    public Automaton op(Automaton a1, Automaton a2) {
        if (a1.isEmpty() || a2.isEmpty())
            return Automaton.makeEmpty();
        
        Automaton anyStringContainingArgument = 
            Automaton.makeAnyString().concatenate(a2).concatenate(Automaton.makeAnyString());

        // if no string in a1 contains any of the possible arguments, then
        // the answer is always false
        Automaton intersection = a1.intersection(anyStringContainingArgument);
        if (intersection.isEmpty()) {
            return Basic.makeBinaryBoolean(false);
        }
        
        // if an infinite number of arguments are possible, we can't deduce anything
        // simple proof: for any callee X there exists an argument Y that is longer than X, and therefore X cannot contain Y
        if (!a2.isFinite())
            return Basic.getBinaryBooleans();
        
        // note: 30 is an arbitrary limit to avoid time explosion
        Set<String> finite = a2.getFiniteStrings(30);
        if (finite == null)
            return Basic.getBinaryBooleans();
        
        // try every finite string in the language
        for (String s : finite) {
            Automaton a = Automaton.makeAnyString().concatenate(Automaton.makeString(s)).concatenate(Automaton.makeAnyString());
            if (!a1.subsetOf(a)) {
                return Basic.getBinaryBooleans();
            }
        }
        
        // every possible argument string is contained in every possible callee
        return Basic.makeBinaryBoolean(true);
    }
    
    @Override
    public int getPriority() {
        return 1;
    }
    
    @Override
    public String toString() {
        return "contains1";
    }
    
}
