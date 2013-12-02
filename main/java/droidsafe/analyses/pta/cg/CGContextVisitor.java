package droidsafe.analyses.pta.cg;

import droidsafe.analyses.pta.PTAContext;
import soot.SootMethod;
import soot.jimple.toolkits.callgraph.Edge;

public interface CGContextVisitor {
    /**
     * Called for each reachable method call and context
     * 
     * @param method Callee method
     * @param context call edge context with type
     */
    public void visit(SootMethod method, PTAContext context);

}
