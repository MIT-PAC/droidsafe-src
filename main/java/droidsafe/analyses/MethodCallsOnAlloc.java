package droidsafe.analyses;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.Value;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.Edge;
import droidsafe.analyses.pta.ContextType;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.pta.PTAContext;
import droidsafe.analyses.pta.PointsToAnalysisPackage;
import droidsafe.analyses.rcfg.OutputEvent;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.utils.SootUtils;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.pta.cg.CGVisitorEntryAnd1CFA;
import droidsafe.analyses.pta.cg.CallGraphTraversal;
import droidsafe.android.system.API;

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
public class MethodCallsOnAlloc implements CGVisitorEntryAnd1CFA {
    /** Map of alloc node to edges that could have alloc node as receiver or arg */
    private Map<AllocNode,Set<Edge>> nodeToCalls;
    /** Singleton object */
    private static MethodCallsOnAlloc v;
    /** precalculate the types of objects we are tracking so we can reduce number of pta queries by 
     * a type based filter */
    private Set<Type> typesToConsider;

    /**
     * Private constructor
     */
    private MethodCallsOnAlloc() {
        nodeToCalls = new HashMap<AllocNode,Set<Edge>>();
        typesToConsider = new HashSet<Type>();
        calculateTypesToConsider();
    }

    /**
     * precalculate the types we care about tracking so we can reduce the number of pta queries.
     */
    private void calculateTypesToConsider() {
        for (AllocNode node : RCFG.v().getRecOrArgsForAPICalls()) {
            if (!(node.getType() instanceof RefType))
                continue;
            SootClass clz = ((RefType)node.getType()).getSootClass();

            typesToConsider.add(node.getType());
            
            for (SootClass parent : SootUtils.getParents(clz)) {
                typesToConsider.add(RefType.v(parent));
            }
        }
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
        if (PTABridge.v().getPackage() == PointsToAnalysisPackage.SPARK) {
            v.runInternalSpark();
        } else //full context traversal for any other pta 
            CallGraphTraversal.acceptEntryContextAnd1CFA(v);
    }

    /** optimized search for context insensitive points to analysis */
    private void runInternalSpark() {
        //loop over all methods, for each invoke in or out, decide track appropriate metrics
        
        for (SootMethod method : PTABridge.v().getAllReachableMethods()) {
            //do nothing for system methods
            if (API.v().isSystemMethod(method))
                continue;
            
            Iterator<Edge> outgoingEdges = Scene.v().getCallGraph().edgesOutOf(method);
            while (outgoingEdges.hasNext()) {
                Edge edge = outgoingEdges.next();
                
                if (edge.srcStmt() == null || !edge.srcStmt().containsInvokeExpr())
                    continue;
                
                InvokeExpr invoke = edge.srcStmt().getInvokeExpr();
                
                if (invoke == null)
                    continue;
                
                if (invoke instanceof InstanceInvokeExpr) {
                    InstanceInvokeExpr iie = (InstanceInvokeExpr)invoke;
                    if (typesToConsider.contains(iie.getBase().getType())) {
                        Set<AllocNode> nodes;
                        nodes = PTABridge.v().getPTSet(iie.getBase());
                        
                        for (AllocNode an : nodes) {
                            if (RCFG.v().isRecOrArgForAPICall(an)) {
                                getCalls(an).add(edge);
                            }
                        }
                    }
                }

                for (Value argv : invoke.getArgs()) {
                    if (PTABridge.v().isPointer(argv) && typesToConsider.contains(argv.getType())) {
                        Set<AllocNode> nodes;
                        nodes = PTABridge.v().getPTSet(argv);
                            
                        for (AllocNode an : nodes) {
                            if (RCFG.v().isRecOrArgForAPICall(an)) {
                                getCalls(an).add(edge);
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * For each method call edge, decide if the receiver or any of the args could be an alloc node
     * for the list of alloc nodes used in api calls (from RCFG).  Store in the map the alloc node to edge
     * mapping.
     */
    public void visitEntryContextAnd1CFA(SootMethod method, PTAContext eventContext, PTAContext oneCFAContext) {
        Edge edgeInto = oneCFAContext.getContext();
        
        
        //do nothing this is not a normal call
        if (edgeInto.srcStmt() == null || !edgeInto.srcStmt().containsInvokeExpr())
            return;

        InvokeExpr invoke = edgeInto.srcStmt().getInvokeExpr();

        if (invoke == null)
            return;

        if (invoke instanceof InstanceInvokeExpr) {
            InstanceInvokeExpr iie = (InstanceInvokeExpr)invoke;
            if (typesToConsider.contains(iie.getBase().getType())) {
                Set<AllocNode> nodes;
                //if the context is the same as the edge into, then we cannot use context back to the src
                if (eventContext.getContext() == edgeInto) 
                    nodes = PTABridge.v().getPTSet(iie.getBase());
                else    
                    nodes = PTABridge.v().getPTSet(iie.getBase(), eventContext);

                for (AllocNode an : nodes) {
                    if (RCFG.v().isRecOrArgForAPICall(an)) {
                        getCalls(an).add(edgeInto);
                    }
                }
            }
        }

        for (Value argv : invoke.getArgs()) {
            if (PTABridge.v().isPointer(argv) && typesToConsider.contains(argv.getType())) {
                Set<AllocNode> nodes;
                //if the context is the same as the edge into, then we cannot use context back to the src
                if (eventContext.getContext() == edgeInto) 
                    nodes = PTABridge.v().getPTSet(argv);
                else    
                    nodes = PTABridge.v().getPTSet(argv, eventContext);
                for (AllocNode an : nodes) {
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
