package dk.brics.string.java;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import soot.SootMethod;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import dk.brics.automaton.Automaton;
import dk.brics.string.external.InvalidResolutionException;
import dk.brics.string.external.MethodResolution;
import dk.brics.string.external.Resolver;
import dk.brics.string.intermediate.ArrayNew;
import dk.brics.string.intermediate.ArrayWriteElement;
import dk.brics.string.intermediate.ObjectCorrupt;
import dk.brics.string.intermediate.StringBufferInit;
import dk.brics.string.intermediate.StringInit;
import dk.brics.string.intermediate.Variable;
import dk.brics.string.intermediate.VariableType;

/**
 * Uses a list of {@link Resolver} strategies to translate method calls.
 * <p/>
 * This class will not ask a resolver to resolve a method whose returned value cannot
 * be a {@link String}, {@link StringBuffer}, {@link StringBuilder}, or an array of {@link String}s,
 * but the static return type may be less specific than that. For example, a method that
 * returns {@link Cloneable} might return an array of strings, and one that returns {@link Appendable}
 * might return a string buffer.
 */
public class ResolverMethodCallTranslator implements MethodCallTranslator {
	
	private List<Resolver> resolvers = new LinkedList<Resolver>();
	
	/**
	 * Creates a strategy that translates methods using information provided by 
	 * the specified {@link Resolver} strategies.
	 * @param resolvers resolvers used to examine invocations. Should not contain duplicates.
	 */
	public ResolverMethodCallTranslator(Collection<? extends Resolver> resolvers) {
		this.resolvers.addAll(resolvers);
	}
	
	public boolean translateConstructorCall(InstanceInvokeExpr expr,
			Variable callee, List<Variable> arguments,
			IntermediateFactory factory) {
		// TODO the Resolver interface does not actually state if constructors are allowed.
		//		Maybe that should be clarified.
		// So far we just assume constructors cannot be resolved
		return false;
	}
	
	public Variable translateAbstractMethodCall(InstanceInvokeExpr expr,
			SootMethod target, Variable callee, List<Variable> arguments,
			IntermediateFactory factory) {
		return resolveToVariable(expr, target, arguments, factory);
	}
	
	public Variable translateMethodCall(InstanceInvokeExpr expr,
			SootMethod target, Variable callee, List<Variable> arguments,
			IntermediateFactory factory) {
		return resolveToVariable(expr, target, arguments, factory);
	}

	public Variable translateStaticMethodCall(InvokeExpr expr,
			List<Variable> arguments, IntermediateFactory factory) {
		return resolveToVariable(expr, expr.getMethod(), arguments, factory);
	}
	
	private MethodResolution getResolution(InvokeExpr expr, SootMethod target) {
		for (Resolver resolver : resolvers) {
			MethodResolution res = resolver.resolveMethod(expr, target);
			if (res != null)
				return res;
		}
		return null;
	}
	
	/**
	 * Tries to resolve a method using the list of resolvers. If the method
	 * could be resolved, some intermediate statements are created, and a
	 * variable containing its return-type is created and returned.
	 * @param expr a static or non-static method invocation expression.
	 * @param target the method being invoked
	 * @return a variable with holding the method's return value, or <tt>null</tt> if the method was unknown by the resolvers.
	 */
	private Variable resolveToVariable(InvokeExpr expr, SootMethod target, List<Variable> arguments, IntermediateFactory factory) {
	    // only non-application methods may be resolved
	    if (target.getDeclaringClass().isApplicationClass())
	        return null;
	    
		// Get the return type
		VariableType resultType = factory.fromSootType(target.getReturnType());
		
		MethodResolution resolution = getResolution(expr, target);
		
		// give up if no resolver could resolve the method
		if (resolution == null)
			return null;
		
		// make return value
		Variable result;
		if (resolution.getReturnedAutomaton() != null) {
			Automaton auto = resolution.getReturnedAutomaton();
			
			Variable temp = factory.createVariable(VariableType.STRING);
			factory.addStatement(new StringInit(temp, auto));
			
			switch (resultType) {
			case ARRAY:
				result = factory.createVariable(resultType);
				factory.addStatement(new ArrayNew(result));
				factory.addStatement(new ArrayWriteElement(result, temp));
				break;
			
			case STRINGBUFFER:
				result = factory.createVariable(resultType);
				factory.addStatement(new StringBufferInit(result, temp));
				break;
				
			case STRING:
			case OBJECT:
			case PRIMITIVE:
				result = temp;
				break;
			
			default:
				result = factory.getNothing();
			}
			
		} else if (resolution.getReturnedArgument() != -1) {
			result = arguments.get(resolution.getReturnedArgument());
			
		} else {
			result = factory.createVariable(resultType);
			factory.addStatement(new ObjectCorrupt(result));
		}
		
		// handle corrupted arguments
		if (resolution.getCorruptedArguments().size() != arguments.size()) {
			throw new InvalidResolutionException("Incorrect number of arguments in method resolution");
		}
		for (int i=0; i<arguments.size(); i++) {
			if (arguments.get(i).isMutable() && resolution.isArgumentCorrupted(i)) {
				factory.addStatement(new ObjectCorrupt(arguments.get(i)));
			}
		}
		
		return result;
	}

}
