package dk.brics.string.intermediate;

/**
 * Writing an array into an array of higher dimension.
 */
public class ArrayWriteArray extends ArrayStatement {

    /**
     * The array that is written into the other.
     */
    public Variable from;

    public ArrayWriteArray(Variable to, Variable from) {
        super(to);
        this.from = from;
        
        assert from.getType().mightBeAliasOf(VariableType.ARRAY);
        assert from.isLocal();
    }

    @Override
    public void visitBy(StatementVisitor v) {
        v.visitArrayWriteArray(this);
    }

}
