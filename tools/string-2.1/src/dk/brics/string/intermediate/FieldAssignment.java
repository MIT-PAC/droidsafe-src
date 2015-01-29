package dk.brics.string.intermediate;

/**
 * Assignment from a local varable to a field.
 * @see Field
 */
public class FieldAssignment extends Statement implements FieldStatement {

	private Field field;
	private Variable from;
	
	public FieldAssignment(Field field, Variable from) {
		this.field = field;
		this.from = from;
		field.addFieldAssignment(this);
		
        assert from.isLocal();
	}
	
	@Override
	public void visitBy(StatementVisitor v) {
		v.visitFieldAssignment(this);
	}
	
	/**
	 * Returns the weak variable of the field being assigned to.
	 */
	public Variable getTo() {
		return field.getVariable();
	}
	
	/**
	 * Returns the variable being assigned from.
	 */
	public Variable getFrom() {
		return from;
	}
	
	/**
	 * Returns the field being assigned to.
	 */
	public Field getField() {
		return field;
	}
	
	
}
