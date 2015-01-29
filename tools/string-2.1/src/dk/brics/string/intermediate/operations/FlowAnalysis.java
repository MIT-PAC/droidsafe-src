package dk.brics.string.intermediate.operations;

import dk.brics.string.intermediate.Statement;

/**
 * A simple flow analysis framework.
 *
 * @see dk.brics.string.intermediate.operations.WorkList
 */
public interface FlowAnalysis {

    /**
     * The transfer function.
     *
     * @param s the statement to transfer through.
     */
    public void transfer(Statement s);
}
