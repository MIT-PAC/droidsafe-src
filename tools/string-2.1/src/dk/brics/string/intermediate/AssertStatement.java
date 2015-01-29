package dk.brics.string.intermediate;

/**
 * An assertion asserts that something was true last time another specified statement completed.
 * Only if the variables involved are unchanged between that statement and the assertion can the
 * assertion be trusted.
 * 
 * @author Asger
 *
 */
public abstract class AssertStatement extends Statement {
    public Statement targetStatement;

    public AssertStatement(Statement targetStatement) {
        this.targetStatement = targetStatement;
        
        assert targetStatement != null;
    }
}
