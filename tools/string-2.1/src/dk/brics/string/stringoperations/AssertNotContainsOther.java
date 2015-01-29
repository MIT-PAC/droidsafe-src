package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.string.charset.CharSet;

public class AssertNotContainsOther extends BinaryOperation {

    @Override
    public CharSet charsetTransfer(CharSet a1, CharSet a2) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Automaton op(Automaton a1, Automaton a2) {
        
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String toString() {
        return "notContains";
    }
    
    @Override
    public boolean isAssertion() {
        return true;
    }
    
}
