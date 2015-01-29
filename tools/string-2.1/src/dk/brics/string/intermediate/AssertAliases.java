package dk.brics.string.intermediate;

/**
 * Asserts whether two variables are aliases.
 * 
 * @author Asger
 *
 */
public class AssertAliases extends AssertStatement {
	public Variable a, b;
	public boolean alias;

	public AssertAliases(Statement targetStatement, Variable a, Variable b, boolean alias) {
		super(targetStatement);
		this.a = a;
		this.b = b;
		this.alias = alias;
	}

	@Override
	public void visitBy(StatementVisitor v) {
		v.visitAssertAliases(this);
	}
	
}
