package dk.brics.string.intermediate;

/**
 * Reading an array from an array of higher dimension.
 */
public class ArrayFromArray extends ArrayStatement {

    /**
     * The array being read from.
     */
    public Variable from;

    public ArrayFromArray(Variable to, Variable from) {
        super(to);
        this.from = from;
        
        assert from.getType().mightBeAliasOf(VariableType.ARRAY);
        assert from.isLocal();
    }

    @Override
    public void visitBy(StatementVisitor v) {
        v.visitArrayFromArray(this);
    }
}
