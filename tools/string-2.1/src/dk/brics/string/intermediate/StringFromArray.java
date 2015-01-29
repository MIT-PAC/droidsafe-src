package dk.brics.string.intermediate;

/**
 * Reading a string from an array.
 */
public class StringFromArray extends StringStatement {

    /**
     * The array to read from.
     */
    public Variable from;

    public StringFromArray(Variable to, Variable from) {
        super(to);
        this.from = from;
        
        assert from.getType().mightBeAliasOf(VariableType.ARRAY);   
        assert from.isLocal();
    }

    @Override
    public void visitBy(StatementVisitor v) {
        v.visitStringFromArray(this);
    }
}
