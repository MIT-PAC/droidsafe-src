package dk.brics.string.intermediate;

/**
 * Adds every string in one collection to another.
 */
public class ArrayAddAll extends ArrayStatement {
    /**
     * The array being read from.
     */
    public Variable from;
    
    public ArrayAddAll(Variable to, Variable from) {
        super(to);
        this.from = from;
        
        assert from.getType().mightBeAliasOf(VariableType.ARRAY);
        assert from.isLocal();
    }
    
    @Override
    public void visitBy(StatementVisitor v) {
        v.visitArrayAddAll(this);
    }
    

}
