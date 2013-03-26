package dk.brics.string.intermediate;

/**
 * Superclass of all statements that manipulate primitive variables.
 */
public abstract class PrimitiveStatement extends Statement {

    /**
     * The string variable being manipulated.
     */
    public Variable to;
    
    public PrimitiveStatement(Variable to) {
        this.to = to;   
        
        assert to.getType().mightBeAliasOf(VariableType.PRIMITIVE);
        assert to.isLocal();
    }
}
