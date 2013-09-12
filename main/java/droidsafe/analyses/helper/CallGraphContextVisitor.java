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
public interface CallGraphContextVisitor {

    /**
     * Called for each edge in the call graph.  Allows the visitor to do something with the method
     * and its context edge.
     *  
     * @param method the callee method
     * @param context the context entry point edge
     * @param edgeInto the calling edge (1CFA edge)
     */
    public void visit(SootMethod method, Edge context, Edge edgeInto);
}
