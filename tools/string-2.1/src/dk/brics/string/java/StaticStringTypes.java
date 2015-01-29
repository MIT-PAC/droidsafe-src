package dk.brics.string.java;

import soot.SootField;
import soot.SootMethod;
import dk.brics.automaton.Automaton;
import dk.brics.string.annotation.Type;

/**
 * Provides the static string types of return values, parameters, and fields.
 * <p/>
 * In the runtime system, a static string type is specified using the {@link Type} annotation. 
 * 
 * @author Asger
 */
public interface StaticStringTypes {
    /**
     * Returns the static string type of the <i>n</i>th parameter to
     * the specified method, or <tt>null</tt> if the parameter has no static string type.
     * @param method a soot method
     * @param paramIndex index of the parameter
     * @return language of the static string type, or <tt>null</tt> if the parameter has no static string type
     */
    Automaton getParameterType(SootMethod method, int paramIndex);
    
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
}
