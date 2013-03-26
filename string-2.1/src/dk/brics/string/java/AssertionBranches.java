package dk.brics.string.java;

import dk.brics.string.intermediate.Method;

/**
 * A pair of assertion branches ({@link AssertionBranch}); corresponding to the
 * true and false outcomes of a branching condition, respectively.
 * @author Asger
 *
 */
public final class AssertionBranches {
    private AssertionBranch whenFalse;
    private AssertionBranch whenTrue;
    
    /**
     * Creates a pair of assertion branches.
     * @param whenFalse assertions that must hold when the condition is false. Must not be null.
     * @param whenTrue assertions that must hold when the condition is true. Must not be null.
     */
    public AssertionBranches(AssertionBranch whenFalse, AssertionBranch whenTrue) {
        assert whenFalse != null && whenTrue != null;
        
        this.whenFalse = whenFalse;
        this.whenTrue = whenTrue;
    }
    
    /**
     * Creates two empty assertion branches.
     */
    public AssertionBranches(Method method) {
        whenFalse = new AssertionBranch(method);
        whenTrue = new AssertionBranch(method);
    }
    
    /**
     * Gets the assertions that must hold when the condition is false.
     * @return never null
     */
    public AssertionBranch getWhenFalse() {
        return whenFalse;
    }
    /**
     * Gets the assertions that must hold when the condition is true.
     * @return never null
     */
    public AssertionBranch getWhenTrue() {
        return whenTrue;
    }
}
