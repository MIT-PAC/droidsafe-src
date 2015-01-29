package dk.brics.string.intermediate;

/**
 * Writing a string or primitive into an array.
 */
public class ArrayWriteElement extends ArrayStatement {

    /**
     * The string being written.
     */
    public Variable from;

    public ArrayWriteElement(Variable to, Variable from) {
        super(to);
        this.from = from;
        
        assert from.getType().mightBeAliasOf(VariableType.STRING) || from.getType() == VariableType.PRIMITIVE;
        assert from.isLocal();
    }

    @Override
    public void visitBy(StatementVisitor v) {
        v.visitArrayWriteElement(this);
    }
}
