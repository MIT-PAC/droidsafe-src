package dk.brics.string.intermediate;

/**
 * Append a primitive char variable to a string buffer.
 * 
 * @author Asger
 *
 */
public class StringBufferAppendChar extends StringBufferOperation {
    
    public Variable from;
    
    public StringBufferAppendChar(Variable to, Variable from) {
        super(to);
        this.from = from;
        
        assert from.getType().mightBeAliasOf(VariableType.PRIMITIVE);
        assert from.isLocal();
    }

    @Override
    public void visitBy(StatementVisitor v) {
        v.visitStringBufferAppendChar(this);
    }
    
}
