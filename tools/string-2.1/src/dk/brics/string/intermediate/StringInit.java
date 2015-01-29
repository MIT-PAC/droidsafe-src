package dk.brics.string.intermediate;

import dk.brics.automaton.Automaton;

/**
 * Initialization of a string by a value in some regular set.
 */
public class StringInit extends StringStatement {

    /**
     * The set of possible values assigned.
     */
    public Automaton regexp;

    public StringInit(Variable to, Automaton regexp) {
        super(to);
        this.regexp = regexp;
    }

    @Override
    public void visitBy(StatementVisitor v) {
        v.visitStringInit(this);
    }
}
