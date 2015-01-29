package dk.brics.string.intermediate;

/**
 * Concatenation of two strings.
 */
public class StringConcat extends StringStatement {

    /**
     * The left-hand string.
     */
    public Variable left;

    /**
     * The right-hand string.
     */
    public Variable right;

    public StringConcat(Variable to, Variable left, Variable right) {
        super(to);
        this.left = left;
        this.right = right;
        
        assert left.getType().mightBeAliasOf(VariableType.STRING);
        assert right.getType().mightBeAliasOf(VariableType.STRING); 
        assert left.isLocal();  
        assert right.isLocal();
    }

    @Override
    public void visitBy(StatementVisitor v) {
        v.visitStringConcat(this);
    }
}
