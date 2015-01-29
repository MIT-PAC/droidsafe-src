package dk.brics.string.java;

import java.util.List;

import soot.Local;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.ValueBox;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.ParameterRef;
import dk.brics.automaton.Automaton;
import dk.brics.string.intermediate.Field;
import dk.brics.string.intermediate.Method;
import dk.brics.string.intermediate.Statement;
import dk.brics.string.intermediate.Variable;
import dk.brics.string.intermediate.VariableType;

/**
 * This is a Facade pattern, used by {@link StatementTranslatorImpl} and {@link MethodCallTranslator}.
 * It is designed to minimize the amount of code required in these classes.
 * <p/>
 * The main objective of the interface is to abstract away all contextual information for the
 * translator. For example, {@link #addStatement} itself determines where to place a statement,
 * and {@link #canBeNull} itself knows which statement is currently being translated.
 * <p/>
 * <i>
 * It is likely that more methods will be added during development.
 * </i>
 */
public interface IntermediateFactory {	// TODO perhaps a better name for this interface?? 
										// Someone might confuse it with the abstract factory pattern
	/**
	 * Adds a statement to the intermediate program. The same statement 
	 * must not be added twice.
	 * @param stm statement to add.
	 */
	void addStatement(Statement stm);
	
	/**
	 * Registers the specified value box as a hotspot. Should only
	 * be called if {@link #isHotspot(ValueBox)} returned <tt>true</tt> for
	 * the specified value box.
	 * @param var variable holding the result of the hotspto expression
	 * @param box value box containing the expression marked as a hotspot
	 */
	void addHotspot(Variable var, ValueBox box);
	
	/**
	 * Remembers the current position in the program, so successive
	 * calls to {@link #useBranch()} jumps back here.
	 */
	void startBranch();
	
	/**
	 * Jumps back to the statement added before the previous call to {@link #startBranch()},
	 * so statements added with {@link #addStatement(Statement)} are added from there.
	 */
	void useBranch();
	
	/**
	 * Ends the current branch, by removing the position stored by the previous call to {@link #startBranch()},
	 * and restores the position marked by the <tt>startBranch</tt> before that.
	 */
	void endBranch();
	
	/**
	 * Creates a new variable with the specified type.
	 * @param type type of the variable to create.
	 * @return a new variable.
	 */
	Variable createVariable(VariableType type);
	
	/**
	 * Returns the intermediate variable corresponding to the specified local.
	 */
	Variable getLocal(Local local);
	
	/**
	 * Returns the intermediate field corresponding to the specified field;
	 */
	Field getField(SootField field);
	
	/**
	 * Returns the variable corresponding to a soot parameter reference
	 */
	Variable getParameter(ParameterRef ref);
	
	/**
	 * Returns a variable representing everything we don't care about in the analysis.
	 * The variable has type <tt>NONE</tt> and must not be assigned to anything!
	 * @return a variable of type <tt>NONE</tt>.
	 */
	Variable getNothing();
	
	/**
	 * Returns <tt>true</tt> if the specified value is marked as a hotspot.
	 */
	boolean isHotspot(ValueBox box);
	
	/**
	 * Returns the intermediate method representing the specified non-interface class's
	 * <tt>toString</tt> method.
	 * @param clazz an application class that is not an interface.
	 * @return an intermediate method.
	 */
	Method getToStringMethod(SootClass clazz);  // TODO create toString methods for interfaces.
												// Just link them to all known implementations.
	
	/**
	 * Gets a list of possible targets for the specified invocation.
	 */
	List<SootMethod> getTargetsOf(InstanceInvokeExpr invocation);
	
	/**
	 * Returns the intermediate method definition corresponding to
	 * the specified Soot method, or <tt>null</tt> if the method is
	 * external.
	 */
	Method getMethod(SootMethod method);
	
	/**
	 * Returns whether the specified local might be <tt>null</tt> at the current
	 * program point.
	 * @param local a soot local variable
	 * @return <tt>true</tt> if the specified local might be <tt>null</tt>.
	 */
	boolean canBeNull(Local local);
	
	/**
	 * Reports that the specified expression was evaluated and stored in the specified intermediate variable.
	 * @param value a jimple expression
	 * @param variable an intermediate variable
	 */
	void setExpressionVariable(ValueBox value, Variable variable);

    /**
     * Returns the static string type of the <i>n</i>th parameter to
     * the specified method, or <tt>null</tt> if the parameter has no static string type.
     * @param ref a parameter
     * @return language of the static string type, or <tt>null</tt> if the parameter has no static string type
     */
    Automaton getParameterType(ParameterRef ref);
    
    /**
     * Returns the static string type of the specified method's return value, or <tt>null</tt> if
     * the return value has no static string type.
     * @param method a soot method
     * @return language of the static string type, or <tt>null</tt> if the return value has no static string type
     */
    Automaton getMethodReturnType(SootMethod method);
    
    /**
     * Returns the static string type of the specified field, or <tt>null</tt> if
     * the field has no static string type.
     * @param field a field
     * @return language of the static string type, or <tt>null</tt> if the field has no static string type
     */
    Automaton getFieldType(SootField field);
    
    /**
     * Returns true if the first argument is a type that extends, implements, or equals
     * the second argument.
     */
    boolean isSubtypeOf(SootClass a, SootClass b);
    
    VariableType fromSootType(Type type);
}
