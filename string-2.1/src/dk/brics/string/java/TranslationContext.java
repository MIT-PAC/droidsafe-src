package dk.brics.string.java;

import java.util.List;

import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.Value;
import soot.ValueBox;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.ParameterRef;
import dk.brics.string.intermediate.Application;
import dk.brics.string.intermediate.Method;
import dk.brics.string.intermediate.Variable;
import dk.brics.string.intermediate.VariableType;

/**
 * Provides information from the higher-level aspects of the analysis to
 * lower-level aspects. The methods in this interface are also present 
 * in {@link IntermediateFactory}.
 * <p/>
 * Currently implemented by {@link Jimple2Intermediate} and used by {@link StatementTranslatorImpl} 
 * and its method call translators (see the {@link MethodTranslator translation overview}), through
 * the {@link IntermediateFactory}.
 */
public interface TranslationContext extends StaticStringTypes {
	/*
	 * TODO: This interface might need a better name, and/or be decomposed into other interfaces.
	 */
    
    Application getApplication();
    
    VariableManager getVariableManager();
	
	/**
	 * Returns the intermediate method definition corresponding to
	 * the specified Soot method, or <tt>null</tt> if the method is
	 * external.
	 */
	Method getMethod(SootMethod method);
	
	/**
	 * Returns the variable corresponding to a soot parameter reference
	 */
	Variable getParameter(SootMethod method, ParameterRef ref);
	
	/**
	 * Gets a list of possible targets for the specified invocation.
	 */
	List<SootMethod> getTargetsOf(InstanceInvokeExpr expr);

	/**
	 * Returns the intermediate method representing the specified non-interface class's
	 * <tt>toString</tt> method.
	 * @param c an application class that is not an interface.
	 * @return an intermediate method.
	 */
	Method getToStringMethod(SootClass c);
	
	/**
	 * Returns <tt>true</tt> if the specified value is marked as a hotspot.
	 */
	boolean isHotspot(ValueBox expr);
    
    /**
     * Reports that the specified expression was evaluated and stored in the specified intermediate variable.
     * @param value a jimple expression
     * @param variable an intermediate variable
     */
    void setExpressionVariable(Value value, Variable variable);
    
    /**
     * Returns the variable holding the result of the specified expression.
     * @param value a jimple expression
     * @return an intermediate variable, or <tt>null</tt> if the expression has not been translated
     */
    Variable getExpressionVariable(Value value);
    
    /**
     * Returns true if the first argument is a type that extends, implements, or equals
     * the second argument.
     */
	boolean isSubtypeOf(SootClass a, SootClass b);
	
	/**
	 * Returns the most specific intermediate variable type that may be assigned to
	 * from the specified Java type.
	 */
	VariableType fromSootType(Type type);
}
