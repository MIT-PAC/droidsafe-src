package dk.brics.string.intermediate;

/**
 * Assignment between variables whose types are uncertain.
 */
public class ObjectAssignment extends Statement {
	
	public Variable to;
	public Variable from;
	
	/**
	 * Assignment between locals variables whose types are uncertain.
	 * @param to the variable to assign to
	 * @param from the variable to assign from
	 */
	public ObjectAssignment(Variable to, Variable from) { 
		this.to = to;
		this.from = from;
		
        assert from.isLocal();  
        assert to.isLocal();
	}
	
	@Override
	public void visitBy(StatementVisitor v) {
		v.visitObjectAssignment(this);
	}
	
}
