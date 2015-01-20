package droidsafe.utils;

import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;
import soot.jimple.SpecialInvokeExpr;

/**
 * Used to denote that a method cannot be found during a search.  Most prominently used to 
 * denote that a method cannot be found for an instance invoke expression (a virtual call).
 * 
 * @author mgordon
 *
 */
public class CannotFindMethodException extends Exception {
    /** serialization id */
    private static final long serialVersionUID = 1L;

    /**
     * Create new exception with clz and method that cannot be found.
     */
    public CannotFindMethodException(SootClass clz, SootMethod method) {
        super(String.format("Cannot find or resolve %s in %s.", method, clz));
    }
    
    /**
     * Create new exception with clz and method that cannot be found.
     */
    public CannotFindMethodException(SootClass clz, SootMethodRef method) {
        super(String.format("Cannot find or resolve %s in %s.", method, clz));
    }
    
    /**
     * Create new exception for a special invoke.
     */
    public CannotFindMethodException(SpecialInvokeExpr invoke, SootMethod method) {
        super(String.format("Cannot find or resolve %s in %s.", invoke, method));
    }
    
    /**
     * Create new exception with type and method that cannot be found (for a receiver)
     */
    public CannotFindMethodException(Type t, SootMethod method) {
        super(String.format("Cannot find or resolve method %s with type of receiver %s.", method,
            t));
    }
}
