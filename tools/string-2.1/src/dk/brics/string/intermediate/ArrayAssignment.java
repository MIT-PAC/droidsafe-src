package dk.brics.string.intermediate;

/**
 * Assignment between array variables.
 */
public class ArrayAssignment extends ArrayStatement {

    /**
     * The array variable being assigned from
     */
    public Variable from;

    public ArrayAssignment(Variable to, Variable from) {
        super(to);
        this.from = from;
        
        assert from.getType().mightBeAliasOf(VariableType.ARRAY);
        assert from.isLocal();
    }

    @Override
    public void visitBy(StatementVisitor v) {
        v.visitArrayAssignment(this);
    }
}
