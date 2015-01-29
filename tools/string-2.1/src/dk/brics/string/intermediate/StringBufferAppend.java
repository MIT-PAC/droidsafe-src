package dk.brics.string.intermediate;

/**
 * Appending a string to a string buffer.
 * The result is put into the string buffer.
 */
public class StringBufferAppend extends StringBufferOperation {

    /**
     * The string to append.
     */
    public Variable from;

    public StringBufferAppend(Variable to, Variable from) {
        super(to);
        this.from = from;
        
        assert from.getType().mightBeAliasOf(VariableType.STRING);  
        assert from.isLocal();
    }

    @Override
    public void visitBy(StatementVisitor v) {
        v.visitStringBufferAppend(this);
    }
}

