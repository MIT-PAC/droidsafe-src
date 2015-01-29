package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.string.charset.CharSet;

/**
 * Converts a primitive boolean to a string.
 * 
 * @author Asger
 *
 */
public class BooleanToString extends UnaryOperation {
    
    // Java VM spec 3.3.4 says 1 represents true, and 0 represents false
    // This means Java is NOT like C/C++ where non-zero integer is true. 
    private static final char FALSE = (char)0;
    private static final char TRUE = (char)1;
    
    @Override
    public CharSet charsetTransfer(CharSet a) {
        CharSet s = new CharSet();
        if (a.contains(FALSE))
            s = s.add(FALSE);
        if (a.contains(TRUE))
            s = s.add(TRUE);
        return s;
    }
    
    @Override
    public Automaton op(Automaton a) {
        Automaton result = Automaton.makeEmpty();
        if (a.run("" + FALSE))
            result = result.union(Automaton.makeString("false"));
        if (a.run("" + TRUE))
            result = result.union(Automaton.makeString("true"));
        return result;
    }
    
    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String toString() {
        return "booleanToString";
    }
    
    
    
}
