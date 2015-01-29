package dk.brics.string.intermediate;

/**
 * No operation.
 */
public class Nop extends Statement {

    public Nop() {
    }

    @Override
    public void visitBy(StatementVisitor v) {
        v.visitNop(this);
    }
}
