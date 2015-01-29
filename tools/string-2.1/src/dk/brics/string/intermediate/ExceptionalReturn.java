package dk.brics.string.intermediate;

/**
 * Method returns by throwing an exception. Every method has exactly
 * one exceptional return statement. A statement that might throw an
 * exception should have an edge to the exceptional return.
 * <p/>
 * The exceptional return cannot be reached by normal control flow.
 * @author Asger
 */
public class ExceptionalReturn extends Statement {

	@Override
	public void visitBy(StatementVisitor v) {
		v.visitExceptionalReturn(this);
	}

}
