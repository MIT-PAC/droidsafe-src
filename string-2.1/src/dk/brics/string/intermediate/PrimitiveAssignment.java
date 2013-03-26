package dk.brics.string.intermediate;

/**
 * Assignment from one primitive to another. Since primitives are not references
 * they will not become aliases.
 * 
 * @author Asger
 *
 */
public class PrimitiveAssignment extends PrimitiveStatement {
    
    public Variable from;
    
    public PrimitiveAssignment(Variable to, Variable from) {
        super(to);
        this.from = from;
        
        assert from.getType().mightBeAliasOf(VariableType.PRIMITIVE);
        assert from.isLocal();
    }

    @Override
    public void visitBy(StatementVisitor v) {
        v.visitPrimitiveAssignment(this);
    }
}
