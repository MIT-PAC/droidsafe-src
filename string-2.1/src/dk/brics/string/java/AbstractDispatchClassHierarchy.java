package dk.brics.string.java;

import java.util.Collections;
import java.util.List;

import soot.ArrayType;
import soot.Hierarchy;
import soot.NullType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.Value;
import soot.jimple.InstanceInvokeExpr;

/**
 * Finds the possible targets of an invocation using the class hierarchy of the
 * application.
 */
public class AbstractDispatchClassHierarchy implements AbstractDispatchStrategy {
    private Hierarchy hierarchy;
    
    public AbstractDispatchClassHierarchy(Hierarchy hierarchy) {
        this.hierarchy = hierarchy;
    }
    
    @SuppressWarnings("unchecked")
    public List<SootMethod> getTargetsOf(InstanceInvokeExpr expr) {
        Value v = expr.getBase();
        
        SootMethod m = expr.getMethod();
        SootClass rc;
        Type t = v.getType();
        List<SootMethod> targets;
        if (t instanceof NullType) {
        	return Collections.emptyList();
        } else if (t instanceof ArrayType) {
            rc = Scene.v().getSootClass("java.lang.Object");
            targets = Collections.singletonList(hierarchy.resolveConcreteDispatch(rc, m));
        } else {
            rc = ((RefType) v.getType()).getSootClass();
            targets = hierarchy.resolveAbstractDispatch(rc, m);
        }
        
        return targets;
    }
    
}
