package dk.brics.string.java;

import java.util.ArrayList;
import java.util.List;

import soot.SootMethod;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import dk.brics.string.intermediate.Call;
import dk.brics.string.intermediate.Method;
import dk.brics.string.intermediate.ObjectCorrupt;
import dk.brics.string.intermediate.Variable;
import dk.brics.string.intermediate.VariableType;

/**
 * Calls to non-external methods and constructors are translated to {@link Call} statements.
 * External methods are not translated.
 */
public class ApplicationMethodCallTranslator implements MethodCallTranslator {
	
	public Variable translateAbstractMethodCall(InstanceInvokeExpr expr,
			SootMethod target, Variable callee, List<Variable> arguments,
			IntermediateFactory factory) {
		return null;
	}
	
	public boolean translateConstructorCall(InstanceInvokeExpr expr,
			Variable callee, List<Variable> arguments,
			IntermediateFactory factory) {
		SootMethod sootMethod = expr.getMethod();
		Method method = factory.getMethod(sootMethod);
		if (method == null)
			return false;
		
		Variable var = factory.createVariable(VariableType.NONE);
		factory.addStatement(new Call(var, method, translateArguments(sootMethod, arguments, factory)));
		
		// the constructor of custom collection types must produce corrupt collections
		if (callee.getType() != VariableType.NONE) {
			factory.addStatement(new ObjectCorrupt(callee));
		}
		
		return true;
	}
	
	public Variable translateMethodCall(InstanceInvokeExpr expr,
			SootMethod target, Variable callee, List<Variable> arguments,
			IntermediateFactory factory) {
		Method method = factory.getMethod(target);
		if (method == null)
			return null;
		
		Variable result = factory.createVariable(factory.fromSootType(target.getReturnType()));
		
		factory.addStatement(new Call(result, method, translateArguments(target, arguments, factory)));
		
		return result;
	}

	public Variable translateStaticMethodCall(InvokeExpr expr,
			List<Variable> arguments, IntermediateFactory factory) {
		SootMethod sootMethod = expr.getMethod();
		Method method = factory.getMethod(sootMethod);
		if (method == null)
			return null;
		
		Variable result = factory.createVariable(factory.fromSootType(sootMethod.getReturnType()));
		factory.addStatement(new Call(result, method, translateArguments(sootMethod, arguments, factory)));
		
		return result;
	}
	
	private Variable[] translateArguments(SootMethod method, List<Variable> arguments, IntermediateFactory factory) {
		// Calls must only send non-NONE variables, so we have to translate a bit
		// TODO compile a long list of all such invariants so we don't have these hidden mysteries
		List<Variable> newArgs = new ArrayList<Variable>();
		int i = 0;
		for (Variable arg : arguments) {
			if (factory.fromSootType(method.getParameterType(i)) != VariableType.NONE) {
				newArgs.add(arg);
			}
			i++;
		}
		return newArgs.toArray(new Variable[0]);
	}
	
}
