package dk.brics.string.intermediate.operations;

import java.util.LinkedList;
import java.util.List;

import dk.brics.string.intermediate.Method;
import dk.brics.string.intermediate.Statement;

/**
 * A worklist algorithm for performing flow analyses on
 * a set of methods.
 */
public class WorkList {
	
	// XXX: Avoid duplicate entries in the queue? Or will the overhead from a set be higher than the benefit?
	// Using a bitvector as set should be fast enough to gain some speed.
    private LinkedList<Statement> list;
    private FlowAnalysis fa;

    /**
     * Creates a worklist for the given analysis.
     *
     * @param fa the flow analysis.
     */
    public WorkList(FlowAnalysis fa) {
        list = new LinkedList<Statement>();
        this.fa = fa;
    }

    /**
     * Adds all statements from the body of the given method
     * to the worklist.
     *
     * @param m the method.
     */
    public void addAll(Method m) {
        list.addAll(m.getStatements());
    }
    
    /**
     * Adds all specified statements to the worklist.
     */
    public void addAll(List<? extends Statement> statements) {
        list.addAll(statements);
    }

    /**
     * Adds the given statement to the worklist.
     *
     * @param s the statement.
     */
    public void add(Statement s) {
        list.add(s);
    }

    /**
     * Iterate through the worklist until no more statements remain.
     * <p/>
     * In each iteration step, the {@link dk.brics.string.intermediate.operations.FlowAnalysis#transfer transfer}
     * method in the associated {@link dk.brics.string.intermediate.operations.FlowAnalysis}
     * is called, which will in turn call the {@link dk.brics.string.intermediate.operations.WorkList#add add}
     * method in the worklist for all statements affected by the change.
     */
    public void iterate() {
        // TODO: better worklist strategy
        while (!list.isEmpty()) {
            Statement s = list.removeFirst();
            fa.transfer(s);
        }
    }

}
