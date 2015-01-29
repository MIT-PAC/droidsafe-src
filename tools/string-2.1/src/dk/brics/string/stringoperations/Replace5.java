package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.string.charset.CharSet;

/**
 * Automaton operation for {@link StringBuffer#replace(int,int,String)}.
 */
public class Replace5 extends BinaryOperation {

    /**
     * Constructs new operation object.
     */
    public Replace5() {
    }

    /**
     * Automaton operation.
     * See {@link Insert#op(Automaton,Automaton) Insert.op(Automaton,Automaton)}.
     *
     * @param a first input automaton
     * @param b second input automaton
     * @return resulting automaton
     */
    @Override
    public Automaton op(Automaton a, Automaton b) {
        return Insert.pop(a, b);
    }

    @Override
    public String toString() {
        return "replace5";
    }

    @Override
    public int getPriority() {
        return 6;
    }

    @Override
    public CharSet charsetTransfer(CharSet a1, CharSet a2) {
        return a1.union(a2);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Replace5;
    }
}
