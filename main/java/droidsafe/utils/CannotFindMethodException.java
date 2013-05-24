package droidsafe.utils;

import soot.SootClass;
import soot.SootMethod;
import soot.Type;

/**
 * Used to denote that a method cannot be found during a search.  Most prominently used to 
 * denote that a method cannot be found for an instance invoke expression (a virtual call).
 * 
 * @author mgordon
 *
 */
public class CannotFindMethodException extends Exception {
    public CannotFindMethodException(SootClass clz, SootMethod method) {
        super(String.format("Cannot find or resolve %s in %s.", method, clz));
    }
    
    public CannotFindMethodException(Type t, SootMethod method) {
        super(String.format("Cannot find or resolve method %s with type of receiver %s.", method,
            t));
    }
}
