package dk.brics.string.java;

import soot.jimple.InvokeExpr;

/**
 * Used for taint analysis. 
 * The implementer must given an invokeExp determine whether the result is a taint string.
 */
public interface TaintAnalysisStrategy {

	/**
	 * Returns true if the given invoke statement is taint
     */
    public boolean isTaint(InvokeExpr s);
}
