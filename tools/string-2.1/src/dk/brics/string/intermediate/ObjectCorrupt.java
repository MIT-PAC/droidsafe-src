package dk.brics.string.intermediate;

/**
 * Corruption of a variable whose type is uncertain. Unless the object has type <tt>String</tt>, its value
 * may change spontaneously at any point after this.
 * <p/>
 * Depending on the type of the variable, certain other variables might be aliases of it,
 * which is why we want to keep such corruption statements.
 */
public class ObjectCorrupt extends Statement {
	
	public Variable to;
	
	/**
	 * Corruption of a variable whose type is uncertain.
	 * @param to variable to corrupt
	 */
	public ObjectCorrupt(Variable to) {
		this.to = to; 
        assert to.isLocal();
	}
	
	@Override
	public void visitBy(StatementVisitor v) {
		v.visitObjectCorrupt(this);
	}
	
	
}
