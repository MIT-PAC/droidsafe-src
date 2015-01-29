package dk.brics.string.java;

import java.util.List;

import soot.SootMethod;
import soot.jimple.InstanceInvokeExpr;

/**
 * Strategy for finding the set of possible targets of an instance invocation.
 */
public interface AbstractDispatchStrategy {
    /**
     * Returns the list of methods that might be invoked by the specified invocation statement.
     * @param expr an invocation statement.
     * @return a read-only list of methods.
     */
    List<SootMethod> getTargetsOf(InstanceInvokeExpr expr);
}
