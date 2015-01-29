package dk.brics.string.intermediate;

/**
 * Creation of a new string buffer object with some initial string content.
 * The new string buffer is assigned to the
 * {@link dk.brics.string.intermediate.StringBufferStatement#to to} variable.
 */
public class StringBufferInit extends StringBufferStatement {

    /**
     * The string forming the initial content.
     */
    public Variable from;

    public StringBufferInit(Variable to, Variable from) {
        super(to);
        this.from = from;
        
        assert from.getType().mightBeAliasOf(VariableType.STRING);  
        assert from.isLocal();
    }

    @Override
    public void visitBy(StatementVisitor v) {
        v.visitStringBufferInit(this);
    }
}

