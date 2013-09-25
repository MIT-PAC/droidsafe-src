package droidsafe.analyses;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import soot.SootMethod;
import soot.Value;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.Edge;
import droidsafe.analyses.helper.CallGraphContextVisitor;
import droidsafe.analyses.helper.CallGraphTraversal;
import droidsafe.analyses.rcfg.OutputEvent;
import droidsafe.analyses.rcfg.RCFG;

/**
 * Build a mapping of AllocNode to calls that could have the allocnode as either a receiver or an 
 * argument.
 * 
 * The mapping contains only allocnodes that were themselves either an argument or a receiver to an 
 * interesting API call as decided by RCFG creation.
 * 
 * @author mgordon
 *
 */
public class MethodCallsOnAlloc extends CallGraphContextVisitor {
    /** Map of alloc node to edges that could have alloc node as receiver or arg */
    private Map<AllocNode,Set<Edge>> nodeToCalls;
    /** Singleton object */
    private static MethodCallsOnAlloc v;
    
    /**
     * Private constructor
     */
    private MethodCallsOnAlloc() {
        nodeToCalls = new HashMap<AllocNode,Set<Edge>>();
    }
    
    /**
     * Return singleton.
     */
    public static MethodCallsOnAlloc v() {
        return v;
    }
    
    /**
     * Build maps of alloc nodes from RCFG list to API calls that have them as args or receiver.
     */
    public static void run() {
        v = new MethodCallsOnAlloc();
        CallGraphTraversal.accept(v);
    }
    
    /**
     * For each method call edge, decide if the receiver or any of the args could be an alloc node
     * for the list of alloc nodes used in api calls (from RCFG).  Store in the map the alloc node to edge
     * mapping.
     */
    public void visitEntryContextAnd1CFA(SootMethod method, Edge context, Edge edgeInto) {
        //do nothing this is not a normal call
        if (edgeInto.srcStmt() == null || !edgeInto.srcStmt().containsInvokeExpr())
            return;
        
        InvokeExpr invoke = edgeInto.srcStmt().getInvokeExpr();
        
        if (invoke == null)
            return;
        
        if (invoke instanceof InstanceInvokeExpr) {
            InstanceInvokeExpr iie = (InstanceInvokeExpr)invoke;
            for (AllocNode an : GeoPTA.v().getPTSet(iie.getBase(), context)) {
                if (RCFG.v().isRecOrArgForAPICall(an)) {
                    getCalls(an).add(edgeInto);
                }
            }
        }
        
        for (Value argv : invoke.getArgs()) {
            if (GeoPTA.v().isPointer(argv)) {
                for (AllocNode an : GeoPTA.v().getPTSet(argv, context)) {
                    if (RCFG.v().isRecOrArgForAPICall(an)) {
                        getCalls(an).add(edgeInto);
                    }
                }
            }
        }
    }
    
    /**
     * For a given alloc node that is important for RCFG (used in an api call) return the set
     * of all calls that could have this alloc node as either a receiver or argument. 
     */
    public Set<Edge> getCalls(AllocNode an) {
        if (!RCFG.v().isRecOrArgForAPICall(an)) 
            return null;
        
        if (!nodeToCalls.containsKey(an)) {
            nodeToCalls.put(an, new HashSet<Edge>());
        }
        
        return nodeToCalls.get(an);
    }
}
