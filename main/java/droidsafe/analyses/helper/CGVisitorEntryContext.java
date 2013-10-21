package droidsafe.analyses.helper;

import soot.SootMethod;
import soot.jimple.toolkits.callgraph.Edge;

public interface CGVisitorEntryContext {
    /**
     * Called for each reachable combination of method / entry edge context 
     * 
     * @param method callee method
     * @param entryEdge entry point edge 
     */
    public void visitEntryContext(SootMethod method, Edge entryEdge);
}
