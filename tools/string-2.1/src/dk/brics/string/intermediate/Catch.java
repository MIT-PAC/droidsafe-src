package dk.brics.string.intermediate;

/**
 * Catches an exception. Any edge to a catch statement represents an
 * exception thrown inside the source statement and caught by the catch statement.
 * 
 * @author Asger
 *
 */
public class Catch extends Statement {

	@Override
	public void visitBy(StatementVisitor v) {
		v.visitCatch(this);
	}
	
}
