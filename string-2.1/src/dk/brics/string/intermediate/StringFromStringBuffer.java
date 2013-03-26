package dk.brics.string.intermediate;

/**
 * Extracting the current string value from a string buffer.
 */
public class StringFromStringBuffer extends StringStatement {

    /**
     * The string buffer to extract from.
     */
    public Variable from;

    public StringFromStringBuffer(Variable to, Variable from) {
        super(to);
        this.from = from;
        
        assert from.getType().mightBeAliasOf(VariableType.STRINGBUFFER);    
        assert from.isLocal();
    }
    
    @Override
    public void visitBy(StatementVisitor v) {
        v.visitStringFromStringBuffer(this);
    }
}
