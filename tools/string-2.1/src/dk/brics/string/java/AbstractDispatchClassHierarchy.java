package dk.brics.string.java;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	// LWG
    private Logger log = LoggerFactory.getLogger(AbstractDispatchClassHierarchy.class); // FIXME: check uses of log4j ?!

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
            // LWG: TEMPORARY WORKAROUND - return empty list when failed to resolve abstract dispatch
            try {
            	targets = hierarchy.resolveAbstractDispatch(rc, m);
            } catch (RuntimeException e) {
            	log.warn(e.getMessage());
            	return Collections.emptyList();
            }
        }
        
        return targets;
    }
    
}
