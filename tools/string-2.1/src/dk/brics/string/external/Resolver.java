package dk.brics.string.external;

import soot.SootMethod;
import soot.jimple.FieldRef;
import soot.jimple.InvokeExpr;

/**
 * Callback interface to allow the string analysis to model some
 * external methods and fields more precisely.
 * <p/>
 * A resolver is added to the current list of active resolvers by
 * the {@link dk.brics.string.StringAnalysis#addResolver StringAnalysis.addResolver} method.
 * Every time the analysis encounters a reference to a field or method
 * which it does not know about, it will ask all active resolvers (in the
 * order in which they were added) for information about the field or method.
 */
public interface Resolver {

    /**
     * Called by the string analysis when it encounters a call of an
     * unknown method in a non-application class.
     * <p/>
     * The resolver can return <tt>null</tt> to indicate that nothing special is
     * known about the invoked method. Otherwise, it can return a {@link MethodResolution}
     * object describing the behaviour of this method invocation.
     *
     * @param expr   the invoke expression that calls the unknown method.
     * @param target the unknown method.
     * @return a description of the possible return values, or <code>null</code>.
     * @see MethodResolution
     */
    public MethodResolution resolveMethod(InvokeExpr expr, SootMethod target);
    
    /**
     * Called by the string analysis when it encounters a reference of an
     * unknown <tt>String</tt> field in a non-application class. Mutable fields
     * in non-application classes cannot be resolved.
     * <p/>
     * The resolver can return <tt>null</tt> to indicate that nothing special is
     * known about the field. Otherwise, it can return a {@link FieldResolution}
     * object describing the possible values of the field.
     *
     * @param expr the field reference.
     * @return a description of the possible values, or <code>null</code>.
     * @see FieldResolution
     */
	public FieldResolution resolveField(FieldRef expr);
}
