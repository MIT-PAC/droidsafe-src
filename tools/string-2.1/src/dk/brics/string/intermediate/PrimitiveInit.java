package dk.brics.string.intermediate;

import dk.brics.automaton.Automaton;

public class PrimitiveInit extends PrimitiveStatement {
    public Automaton regexp;

    public PrimitiveInit(Variable to, Automaton regexp) {
        super(to);
        this.regexp = regexp;
    }
    
    @Override
    public void visitBy(StatementVisitor v) {
        v.visitPrimitiveInit(this);
    }
}
