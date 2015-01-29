package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.string.charset.CharSet;

public class AssertContainsOther extends BinaryOperation {

    @Override
    public CharSet charsetTransfer(CharSet a1, CharSet a2) {
        return a1;
    }
    
    @Override
    public Automaton op(Automaton a1, Automaton a2) {
        Automaton x = Automaton.makeAnyString().concatenate(a2).concatenate(Automaton.makeAnyString());
        return a1.intersection(x);
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String toString() {
        return "contains";
    }
    
    @Override
    public boolean isAssertion() {
        return true;
    }
    
}
