package droidsafe.analyses.pta.cg;

import droidsafe.analyses.pta.PTAContext;
import soot.SootMethod;
import soot.jimple.toolkits.callgraph.Edge;

public interface CGVisitorEntryAnd1CFA {
    /**
     * Called for each edge in the call graph.  Allows the visitor to do something with the method
     * and its context edge.
     *  
     * @param method the callee method
     * @param entryEdge the context entry point edge
     * @param edgeInto the calling edge (1CFA edge)
     */
    public void visitEntryContextAnd1CFA(SootMethod method, PTAContext eventContext, PTAContext oneCFAContext);
}
