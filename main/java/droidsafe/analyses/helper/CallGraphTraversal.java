package droidsafe.analyses.helper;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.analyses.GeoPTA;
import droidsafe.android.app.Harness;
import droidsafe.android.system.API;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.SootUtils;

import soot.Kind;
import soot.Scene;
import soot.SootMethod;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.spark.geom.geomPA.CgEdge;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;

/**
 * This class performs a traversal of the call graph (hopefully using context sensitivity), and calls a visitor 
 * method at different points in the traversal:
 * 
 * 1. Visitor is called for each callee method / entry point edge / 1cfa edge combination.
 * 2. Visitor is called for each callee method / 1cfa edge combination
 * 3. Visitor is called for each callee method / entry point edge combination.
 * 
 * @author mgordon
 *
 */
public class CallGraphTraversal {
    /** Logger field */
    private static final Logger logger = LoggerFactory.getLogger(CallGraphTraversal.class);
    /** The spark (context insensitive) call graph */ 
    private CallGraph sparkCG;
    /** The edges (and the context) that we have visited */
    private HashSet<EdgeAndContext> visitedEntryAnd1CFA;
    private HashSet<Edge> visitedEdges;
    private HashSet<MethodAndContext> visitedMethodAndContext;

    /**
     * Accept a visitor and perform a traversal of the call graph, calling the visit method 
     * of the visitor for each call graph edge.
     */
    public static void accept(CallGraphContextVisitor visitor) {
        Edge edgeToMain = new Edge(null, null, Harness.v().getMain(), Kind.STATIC);
        new CallGraphTraversal(visitor).traversal(visitor, new EdgeAndContext(edgeToMain, edgeToMain),
                new MethodAndContext(Harness.v().getMain(), edgeToMain));
    }

    /**
     * Create a new traversal.
     */
    private CallGraphTraversal(CallGraphContextVisitor visitor) {
        // TODO Auto-generated constructor stub
        sparkCG = Scene.v().getCallGraph();
        visitedEntryAnd1CFA = new HashSet<EdgeAndContext>();
        visitedEdges = new HashSet<Edge>();
        visitedMethodAndContext = new HashSet<MethodAndContext>();
    }

    /** 
     * Recursive method to perform the traversal.
     */
    private void traversal(CallGraphContextVisitor visitor, EdgeAndContext edgeAndContext, 
                           MethodAndContext methodAndContext) {
        //do not visit if we have seen this full context and entry edge before
        if (visitedEntryAnd1CFA.contains(edgeAndContext)) 
            return;
        
        Edge current = edgeAndContext.edgeInto;
        Edge contextEntry = edgeAndContext.context;
        SootMethod method = current.tgt();
        
        //always visit with full combination
        visitor.visitEntryContextAnd1CFA(method, contextEntry, current);
        
        //visit the method and the 1cfa context edge if we have not visited it before
        if (!visitedEdges.contains(current)) 
            visitor.visit1CFA(method, current);
        
        //visit the method and the entry edge context
        if (!visitedMethodAndContext.contains(methodAndContext))
            visitor.visitEntryContext(methodAndContext.method, methodAndContext.context);
        
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
                            GeoPTA.v().resolveInstanceInvokeMap1CFA(iie, current);
                    for (Map.Entry<AllocNode, SootMethod> entry: 
                        virtualCallMap.entrySet()) {
                      
                        // Only the virtual calls do the following test
                        if ( entry.getValue() == target ) {
                            //found edge in context sensitive search
                           
                            traversal(visitor, new EdgeAndContext(curEdge, newContextEntry), 
                                new MethodAndContext(target, newContextEntry));
                            break;
                        }   
                    } 
                } catch (CannotFindMethodException e) {
                    //if we could not find the method during the resolution, just ignore for now...
                    logger.info("Cannot resolve method during CallGraph traversal: {}", iie);
                    //droidsafe.main.Main.exit(1);
                }   
            } else {
                traversal(visitor, new EdgeAndContext(curEdge, newContextEntry), 
                    new MethodAndContext(target, newContextEntry));
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
    Edge edgeInto;
    Edge context;
    
    public EdgeAndContext(Edge edgeInto, Edge context) {
        super();
        this.edgeInto = edgeInto;
        this.context = context;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((context == null) ? 0 : context.hashCode());
        result = prime * result + ((edgeInto == null) ? 0 : edgeInto.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        EdgeAndContext other = (EdgeAndContext) obj;
        if (context == null) {
            if (other.context != null) return false;
        } else if (!context.equals(other.context)) return false;
        if (edgeInto == null) {
            if (other.edgeInto != null) return false;
        } else if (!edgeInto.equals(other.edgeInto)) return false;
        return true;
    }
    
    
}
