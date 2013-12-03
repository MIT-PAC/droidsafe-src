package droidsafe.analyses.pta.cg;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.analyses.pta.ContextType;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.pta.PTAContext;
import droidsafe.android.app.Harness;
import droidsafe.android.system.API;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.SootUtils;
import soot.Kind;
import soot.Scene;
import soot.SootMethod;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.spark.geom.dataRep.CgEdge;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;

/**
 * This class performs a traversal of the call graph (hopefully using context sensitivity), and calls a visitor 
 * method at different points in the traversal based on the given PTA context.  For example, if 1CFA is used, 
 * then the visitor will be called for each method and 1cfa context (a unique method may be visited multiple times, 
 * each with a unique context).
 * 
 * The traversals are cached because the call graph is huge.
 * 
 * @author mgordon
 *
 */
public class CallGraphTraversal {
    /** Logger field */
    private static final Logger logger = LoggerFactory.getLogger(CallGraphTraversal.class);
    /** The spark (context insensitive) call graph */ 
    private CallGraph sparkCG;
    /** combination of entry and 1cfa edge in the traversal */
    private Set<EdgeAndContext> visitedEntryAnd1CFA;
    /** The edges (and the context) that we have visited */
    private Set<Edge> visitedEdges;
    /** the combination of method and entry point edge in the traversal */
    private Set<MethodAndContext> visitedMethodAndContext;
    /** Static singleton */
    private static CallGraphTraversal v;

    /**
     * Reset the cache of the call graph traversal for a new run or for a change in the code.
     */
    public static void reset() {
        v = null;
    }

    /**
     * Create a new singleton and cache the traversals
     */
    private static void createCachedTraversal() {
        v = new CallGraphTraversal();
        //create the cached traversal
        v.traversal();
        
        System.out.println("Methods: " + PTABridge.v().getAllReachableMethods().size());
        System.out.println("Edges: " + v.visitedEdges.size());
        System.out.println("Method and Entry: " + v.visitedMethodAndContext.size());
        System.out.println("Method + Entry + 1CFA: " + v.visitedEntryAnd1CFA.size());
    }

    /**
     * Called for each edge in the call graph.  Allows the visitor to do something with the method
     * and its context edge.
     */  
    public static void acceptEntryContextAnd1CFA(CGVisitorEntryAnd1CFA visitor) {
        if (v == null)
            createCachedTraversal();

        for (EdgeAndContext edgeAndContext : v.visitedEntryAnd1CFA) {
            visitor.visitEntryContextAnd1CFA(edgeAndContext.oneCFAEdge.tgt(), 
                new PTAContext(ContextType.EVENT_CONTEXT, edgeAndContext.eventEdge), 
                new PTAContext(ContextType.ONE_CFA, edgeAndContext.oneCFAEdge));
        }
    }

    /**
     * Called for each reachable combination of context based on the context type (1CFA or Event)
     */
    public static void acceptContext(CGContextVisitor visitor, ContextType type) {
        if (v == null)
            createCachedTraversal();

        if (type == ContextType.ONE_CFA) {
            for (Edge edge : v.visitedEdges) {
                visitor.visit(edge.tgt(), new PTAContext(ContextType.ONE_CFA, edge));
            }
        } else if (type == ContextType.EVENT_CONTEXT) {
            for (MethodAndContext methodAndContext : v.visitedMethodAndContext) {
                visitor.visit(methodAndContext.method, 
                    new PTAContext(ContextType.EVENT_CONTEXT, methodAndContext.context));
            }
        } else {
            logger.error("Invalid context type: {}", type);
            droidsafe.main.Main.exit(1);
        }
    }

    /**
     * Create a new traversal.
     */
    private CallGraphTraversal() {
        sparkCG = Scene.v().getCallGraph();
        visitedEntryAnd1CFA = new LinkedHashSet<EdgeAndContext>();
        visitedEdges = new LinkedHashSet<Edge>();
        visitedMethodAndContext = new LinkedHashSet<MethodAndContext>();
    }

    /** 
     * Recursive method to perform the traversal.
     */
    private void traversal() {
        Edge edgeToMain = new Edge(null, null, Harness.v().getMain(), Kind.STATIC);

        LinkedList<EdgeAndContext> stack = new LinkedList<EdgeAndContext>();

        EdgeAndContext startingEdgeContext = new EdgeAndContext(edgeToMain, edgeToMain);
        stack.add(startingEdgeContext);

        while (!stack.isEmpty()) {
            EdgeAndContext edgeAndContext = stack.pop();

            //do not visit if we have seen this full context and entry edge before
            if (visitedEntryAnd1CFA.contains(edgeAndContext)) 
                continue;

            MethodAndContext methodAndContext = new MethodAndContext(edgeAndContext.oneCFAEdge.tgt(), 
                edgeAndContext.eventEdge);

            Edge current = edgeAndContext.oneCFAEdge;
            Edge contextEntry = edgeAndContext.eventEdge;
            SootMethod method = current.tgt();

            //remember what we have visited
            visitedEntryAnd1CFA.add(edgeAndContext);
            visitedEdges.add(current);
            visitedMethodAndContext.add(methodAndContext);

            Iterator<Edge> ciEdges = sparkCG.edgesOutOf(method);

            //iterate over all the ci edges from soot, and check to see
            //if they are valid given the context
            while (ciEdges.hasNext()) {
                Edge curEdge = ciEdges.next();

                SootMethod target = curEdge.tgt();
                Edge newContextEntry = contextEntry;

                //context may change for this call if going from api -> user
                if (API.v().isSystemMethod(method) && !API.v().isSystemMethod(target)) {
                    newContextEntry = curEdge;
                }

                InstanceInvokeExpr iie = SootUtils.getInstanceInvokeExpr(curEdge.srcStmt());

                if (iie != null) {
                    //if a virtual call, use the pta to do a context sensitive search, and prune the call graph
                    //only visit the edge if it is in a context sensitive search (search with the old context)
                    try {

                        //Map<AllocNode, SootMethod> virtualCallMap = GeoPTA.v().resolveInstanceInvokeMap(iie, contextEntry);
                        Map<AllocNode, SootMethod> virtualCallMap = 
                                PTABridge.v().resolveInstanceInvokeMap(iie, 
                                    new PTAContext(ContextType.ONE_CFA, current));
                        for (Map.Entry<AllocNode, SootMethod> entry: 
                            virtualCallMap.entrySet()) {

                            // Only the virtual calls do the following test
                            if ( entry.getValue() == target ) {
                                //found edge in context sensitive search

                                EdgeAndContext newEdgeAndContext = new EdgeAndContext(curEdge, newContextEntry);
                                if (!visitedEntryAnd1CFA.contains((newEdgeAndContext)))
                                    stack.push(newEdgeAndContext);
                                break;
                            }   
                        } 
                    } catch (CannotFindMethodException e) {
                        //if we could not find the method during the resolution, just ignore for now...
                        logger.info("Cannot resolve method during CallGraph traversal: {}", iie);
                        //droidsafe.main.Main.exit(1);
                    }   
                } else {
                    EdgeAndContext newEdgeAndContext = new EdgeAndContext(curEdge, newContextEntry);
                    if (!visitedEntryAnd1CFA.contains((newEdgeAndContext)))
                        stack.push(newEdgeAndContext); 
                }
            }

        }
    }
}

/**
 * inner class to store a method and the entry point in which it was called during the traversal of the call graph.
 * 
 * @author mgordon
 *
 */
class MethodAndContext {
    SootMethod method;
    Edge context;

    public MethodAndContext(SootMethod method, Edge context) {
        super();
        this.method = method;
        this.context = context;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((context == null) ? 0 : context.hashCode());
        result = prime * result + ((method == null) ? 0 : method.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        MethodAndContext other = (MethodAndContext) obj;
        if (context == null) {
            if (other.context != null) return false;
        } else if (!context.equals(other.context)) return false;
        if (method == null) {
            if (other.method != null) return false;
        } else if (!method.equals(other.method)) return false;
        return true;
    }
}

/**
 * Internal class that stores the 1CFA and the entry point context in which it was called.
 * 
 * @author mgordon
 *
 */
class EdgeAndContext {
    Edge oneCFAEdge;
    Edge eventEdge;

    public EdgeAndContext(Edge edgeInto, Edge context) {
        super();
        this.oneCFAEdge = edgeInto;
        this.eventEdge = context;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((eventEdge == null) ? 0 : eventEdge.hashCode());
        result = prime * result + ((oneCFAEdge == null) ? 0 : oneCFAEdge.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        EdgeAndContext other = (EdgeAndContext) obj;
        if (eventEdge == null) {
            if (other.eventEdge != null) return false;
        } else if (!eventEdge.equals(other.eventEdge)) return false;
        if (oneCFAEdge == null) {
            if (other.oneCFAEdge != null) return false;
        } else if (!oneCFAEdge.equals(other.oneCFAEdge)) return false;
        return true;
    }


}
