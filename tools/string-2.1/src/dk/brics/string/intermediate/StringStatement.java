package dk.brics.string.intermediate;

/**
 * Superclass of all statements that manipulate string variables.
 */
public abstract class StringStatement extends Statement {

    /**
     * The string variable being manipulated.
     */
    public Variable to;

    public StringStatement(Variable to) {
        this.to = to;   
        
        assert to.getType().mightBeAliasOf(VariableType.STRING);
        assert to.isLocal();
    }
}
