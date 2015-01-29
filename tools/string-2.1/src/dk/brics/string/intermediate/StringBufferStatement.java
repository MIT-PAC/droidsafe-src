package dk.brics.string.intermediate;

/**
 * Superclass of all statements that manipulate string buffers
 * or string buffer variables.
 */
public abstract class StringBufferStatement extends Statement {

    /**
     * The string buffer variable being manipulated.
     */
    public Variable to;

    public StringBufferStatement(Variable to) {
        this.to = to;  
        
        assert to.getType().mightBeAliasOf(VariableType.STRINGBUFFER);
        assert to.isLocal();
    }
}
