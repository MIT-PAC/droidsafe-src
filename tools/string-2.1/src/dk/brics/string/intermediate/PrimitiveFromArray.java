package dk.brics.string.intermediate;

/**
 * Reading a primitive from an array.
 */
public class PrimitiveFromArray extends PrimitiveStatement {

    /**
     * The array to read from.
     */
    public Variable from;

    public PrimitiveFromArray(Variable to, Variable from) {
        super(to);
        this.from = from;
        
        assert from.getType().mightBeAliasOf(VariableType.ARRAY);   
        assert from.isLocal();
    }

    @Override
    public void visitBy(StatementVisitor v) {
        v.visitPrimitiveFromArray(this);
    }
}
