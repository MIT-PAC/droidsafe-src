package dk.brics.string.intermediate;

/**
 * The variable should be evaluated as a hotspot here.
 */
public class Hotspot extends Statement {
	/**
	 * An auxillary variable being assigned to.
	 */
	public Variable to;
	
	/**
	 * A variable containing the value of a hotspot expression.
	 */
	public Variable from;
	
	/**
	 * Create a hotspot that evaluates the specified variable here.
	 */
	public Hotspot(Variable to, Variable from) {
		this.to = to;
		this.from = from;
	}

	@Override
	public void visitBy(StatementVisitor v) {
		v.visitHotspot(this);
	}
	
}
