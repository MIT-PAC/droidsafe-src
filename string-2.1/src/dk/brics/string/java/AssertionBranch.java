package dk.brics.string.java;

import dk.brics.string.intermediate.Method;
import dk.brics.string.intermediate.Nop;
import dk.brics.string.intermediate.Statement;

/**
 * A subgraph containing assertions. The only statements allowed are assertions and nop statements. 
 * @author Asger
 *
 */
public class AssertionBranch {
    private Statement first;
    private Statement last;
    
    /**
     * Creates a non-empty branch of assertions.
     * @param first first statement
     * @param last last statement
     */
    public AssertionBranch(Statement first, Statement last) {
        assert first != null;
        assert last != null;
        
        this.first = first;
        this.last = last;
    }
    
    /**
     * Creates an empty branch.
     */
    public AssertionBranch(Method method) {
        first = last = new Nop();
        method.addStatement(first);
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    /**
     * The first statement. Never null.
     */
    public Statement getFirst() {
        return first;
    }
    /**
     * The last statement. Never null.
     */
    public Statement getLast() {
        return last;
    }
}
