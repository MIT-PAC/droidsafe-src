package droidsafe.analyses.helper;

import soot.SootMethod;
import soot.jimple.toolkits.callgraph.Edge;

/**
 * Interface for analyses that need to traverse the call graph (context sensitively) and 
 * do some calcuation on each method in the CG given the context (entry) edge and the calling edge.
 * 
 * @author mgordon
 *
 */
public class CallGraphContextVisitor {

    /**
     * Called for each edge in the call graph.  Allows the visitor to do something with the method
     * and its context edge.
     *  
     * @param method the callee method
     * @param entryEdge the context entry point edge
     * @param edgeInto the calling edge (1CFA edge)
     */
    public void visitEntryContextAnd1CFA(SootMethod method, Edge entryEdge, Edge edgeInto) {}
    
    /**
     * Called for each reachable combinations of method / 1CFA (calling edge) context
     * 
     * @param method Callee method
     * @param edgeInto 1CFA call edge
     */
    public void visit1CFA(SootMethod method, Edge edgeInto) {}
    
    /**
     * Called for each reachable combination of method / entry edge context 
     * 
     * @param method callee method
     * @param entryEdge entry point edge 
     */
    public void visitEntryContext(SootMethod method, Edge entryEdge) {}
}
