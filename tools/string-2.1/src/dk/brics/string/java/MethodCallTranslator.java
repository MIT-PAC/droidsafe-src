package dk.brics.string.java;

import java.util.List;

import soot.SootMethod;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import dk.brics.string.intermediate.Variable;

/**
 * Handles certain method calls specially by creating intermediate statements for them.
 * These methods will typically be the string operations in {@link String}, {@link StringBuffer}, 
 * and {@link StringBuilder}. The goal of an implementation is to provide higher precision.
 * <p/>
 * Even if the result of a method call is unknown or useless, it is still desirable to handle
 * the call to indicate whether the callee and the arguments are modified.
 * <p/>
 * This is an application of the Strategy pattern. Multiple method call translators can be
 * grouped with {@link CompositeMethodCallTranslator}.
 */
public interface MethodCallTranslator {
	/**
	 * Translates a non-static method call made to the specified method, which might be directed to a different implementation than that method.
	 * As such, the specified method may be abstract and may be declared in an interface.
	 * <p/>
	 * This is always called before the {@link #translateMethodCall} variant. If no translation can be found for an abstract invocation, each possible
	 * invocation target is inspected and {@link #translateMethodCall} will then be called for each target.
	 * @param expr the soot invocation expression. This provides access to the called method, parameter types, and declaring class.
	 * @param target the concrete implementation of the method being called. The expression might refer to a non-final method
	 			which is overridden or implemented by the target.
	 * @param callee variable holding the object being called on.
	 * @param arguments variables holding the (already evaluated) arguments.
	 * @param factory object used to create statements and variables.
	 * @return <tt>null</tt> if the method call could not be handled; a variable of type <tt>NONE</tt> if the method
	 * 	returned void; and otherwise a variable containing the method's return value.
	 */
	Variable translateAbstractMethodCall(InstanceInvokeExpr expr, SootMethod target, Variable callee, List<Variable> arguments, IntermediateFactory factory);
	
	/**
	 * Translates a non-static method call into a sequence of statements. The created statements should reflect the side-effects
	 * on the callee and the arguments, and the possible values of the return-value.
	 * <p/>
	 * This method is called once for each possible target of the invocation, with <tt>target</tt> varying with each call.
	 * 
	 * @param expr the soot invocation expression. This provides access to the called method, parameter types, and declaring class.
	 * @param target the concrete implementation of the method being called. The expression might refer to a non-final method
	 			which is overridden or implemented by the target.
	 * @param callee variable holding the object being called on.
	 * @param arguments variables holding the (already evaluated) arguments.
	 * @param factory object used to create statements and variables.
	 * @return <tt>null</tt> if the method call could not be handled; a variable of type <tt>NONE</tt> if the method
	 * 	returned void; and otherwise a variable containing the method's return value.
	 */
	Variable translateMethodCall(InstanceInvokeExpr expr, SootMethod target, Variable callee, List<Variable> arguments, IntermediateFactory factory);
	
	/**
	 * Translates a static method call into a sequence of statements. The created statements should reflect the side-effects
	 * on the arguments, and the possible values of the return-value.
	 * 
	 * @param expr the soot invocation expression. This provides access to the called method, parameter types, and declaring class.
	 * @param arguments variables holding the (already evaluated) arguments.
	 * @param factory object used to create statements and variables
	 * @return <tt>null</tt> if the method call could not be handled; a variable of type <tt>NONE</tt> if the method
	 * 	returned void; and otherwise a variable containing the method's return value.
	 */
	Variable translateStaticMethodCall(InvokeExpr expr, List<Variable> arguments, IntermediateFactory factory);
	
	/**
	 * Translates a constructor invocation into a sequence of statements. The created statements should reflect the side-effects
	 * on the constructed object (<tt>callee</tt>) and the arguments.
	 * @param expr the soot invocation expression. This provides access to the called method, parameter types, and declaring class.
	 * @param callee variable holding the object being called on.
	 * @param arguments variables holding the (already evaluated) arguments.
	 * @param factory object used to create statements and variables.
	 * @return <tt>true</tt> if the constructor call could be handled, <tt>false</tt> otherwise.
	 */
	boolean translateConstructorCall(InstanceInvokeExpr expr, Variable callee, List<Variable> arguments, IntermediateFactory factory);
}
