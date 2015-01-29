package dk.brics.string.java;

import java.util.ArrayList;
import java.util.List;

import soot.SootMethod;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import dk.brics.string.intermediate.Variable;

/**
 * Groups multiple translators together. The underlying translators are called
 * the children of the composite translator.
 * <p/>
 * A method call is handled if any of the children can handle it. If more than one child
 * can handle a method call, only the first of these children is assigned to handle it.
 */
public class CompositeMethodCallTranslator implements MethodCallTranslator {
	
	private List<MethodCallTranslator> children = new ArrayList<MethodCallTranslator>();
	
	/**
	 * Creates a composite translator without any children.
	 */
	public CompositeMethodCallTranslator() {
	}
	
	/**
	 * Creates a translator that groups multiple other translators together.
	 * @param translators translators to use, ordered by priority.
	 */
	public CompositeMethodCallTranslator(MethodCallTranslator ... translators) {
		for (MethodCallTranslator translator : translators) {
			children.add(translator);
		}
	}
	
	/**
	 * Gets a reference to the list of children.
	 * @return a mutable reference to the list of children.
	 */
	public List<MethodCallTranslator> getChildren() {
		return children;
	}
	
	public Variable translateAbstractMethodCall(InstanceInvokeExpr expr,
			SootMethod target, Variable callee, List<Variable> arguments,
			IntermediateFactory factory) {
		for (MethodCallTranslator child : children) {
			Variable r = child.translateAbstractMethodCall(expr, target, callee, arguments, factory); 
			if (r != null)
				return r;
		}
		return null;
	}
	
	public boolean translateConstructorCall(InstanceInvokeExpr expr,
			Variable callee, List<Variable> arguments,
			IntermediateFactory factory) {
		// try each of the children in the order they were added
		for (MethodCallTranslator child : children) {
			if (child.translateConstructorCall(expr, callee, arguments, factory))
				return true;
		}
		return false;
	}

	public Variable translateMethodCall(InstanceInvokeExpr expr,
			SootMethod target, Variable callee, List<Variable> arguments,
			IntermediateFactory factory) {
		for (MethodCallTranslator child : children) {
			Variable result = child.translateMethodCall(expr, target, callee, arguments, factory);
			if (result != null)
				return result;
		}
		return null;
	}

	public Variable translateStaticMethodCall(InvokeExpr expr,
			List<Variable> arguments, IntermediateFactory factory) {
		for (MethodCallTranslator child : children) {
			Variable result = child.translateStaticMethodCall(expr, arguments, factory);
			if (result != null)
				return result;
		}
		return null;
	}
	
}
