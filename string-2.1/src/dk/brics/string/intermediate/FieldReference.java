package dk.brics.string.intermediate;

/**
 * Assignment from a field to a local variable.
 * @see Field
 */
public class FieldReference  extends Statement implements FieldStatement {

	private Field field;
	
	/** The variable into which the returned value is written */
	private Variable to;
	
	public FieldReference(Field field, Variable retvar) {
		this.field = field;
		this.to = retvar;
		this.field.addFieldReference(this);
		
        assert retvar.isLocal();
	}
	
	@Override
	public void visitBy(StatementVisitor v) {
		v.visitFieldReference(this);
	}
	
	/**
	 * Returns the weak variable of the field being assigned from.
	 */
	public Variable getFrom() {
		return field.getVariable();
	}
	
	/**
	 * Returns the local variable being assigned to.
	 */
	public Variable getTo() {
		return to;
	}
	
	/**
	 * Returns the field being assigned from.
	 */
	public Field getField() {
		return field;
	}
	
	
}
