package droidsafe.transforms;

import java.util.Set;

import soot.Body;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.Edge;
import soot.SootMethod;

/**
 * @author mgordon
 * @author dpetters
 */
public interface VATransform {
    /**
     * transforms the invokeExpr if the signature of the method it calls (callee, as resolved by PTA) matches one that 
     * of the ones returned by sigsOfInvokesToTransform
     */
    public void tranformsInvoke(SootMethod containingMthd, SootMethod callee, InvokeExpr invokeExpr, Stmt stmt, Body body, Edge context);

    /**
     * @return set of string method signatures. Matching invokeExpr will be transformed by this transformation
     */
    public Set<String> sigsOfInvokesToTransform();
}
