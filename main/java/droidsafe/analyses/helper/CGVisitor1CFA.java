package droidsafe.analyses.helper;

import soot.SootMethod;
import soot.jimple.toolkits.callgraph.Edge;

public interface CGVisitor1CFA {
    /**
     * Called for each reachable combinations of method / 1CFA (calling edge) context
     * 
     * @param method Callee method
     * @param edgeInto 1CFA call edge
     */
    public void visit1CFA(SootMethod method, Edge edgeInto);
}
