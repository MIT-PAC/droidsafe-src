package dk.brics.string.stringoperations;

/**
 * Abstract superclass for operations on standard automata.
 */
abstract public class Operation {

    /**
     * Returns name of this operation.
     */
    @Override
    abstract public String toString();

    /**
     * Returns priority of this operation.
     * When approximating operation loops in grammars, operations with
     * high priority are considered first.
     */
    abstract public int getPriority();
}
