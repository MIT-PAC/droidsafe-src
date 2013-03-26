package dk.brics.string.java;

import java.util.List;

import soot.SootMethod;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import dk.brics.string.intermediate.Variable;

/**
 * Method-call translator that can't handle any methods.
 */
public class NaiveMethodCallTranslator implements MethodCallTranslator {

	public Variable translateAbstractMethodCall(InstanceInvokeExpr expr,
			SootMethod target, Variable callee, List<Variable> arguments,
			IntermediateFactory factory) {
		return null;
	}
	
	public Variable translateMethodCall(InstanceInvokeExpr expr, SootMethod target, Variable callee,
			List<Variable> arguments, IntermediateFactory factory) {
		return null;
	}

	public Variable translateStaticMethodCall(InvokeExpr expr,
			List<Variable> arguments, IntermediateFactory factory) {
		return null;
	}

	public boolean translateConstructorCall(InstanceInvokeExpr expr,
			Variable callee, List<Variable> arguments,
			IntermediateFactory factory) {
		return false;
	}
	
}
