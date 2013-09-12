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
import soot.jimple.spark.geom.geomPA.CgEdge;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;

/**
 * This class performs a traversal of the call graph (hopefully using context sensitivity), and calls a visitor 
 * for each edge in the call graph.  The visitor is called with the context edge and the 1CFA edge.
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
    private HashSet<EdgeAndContext> visited;

    /**
     * Accept a visitor and perform a traversal of the call graph, calling the visit method 
     * of the visitor for each call graph edge.
     */
    public static void accept(CallGraphContextVisitor visitor) {
        Edge edgeToMain = new Edge(null, null, Harness.v().getMain(), Kind.STATIC);
        new CallGraphTraversal(visitor).traversal(visitor, new EdgeAndContext(edgeToMain, edgeToMain));
    }

    /**
     * Create a new traversal.
     */
    private CallGraphTraversal(CallGraphContextVisitor visitor) {
        // TODO Auto-generated constructor stub
        sparkCG = Scene.v().getCallGraph();
        visited = new HashSet<EdgeAndContext>();
    }

    /** 
     * Recursive method to perform the traversal.
     */
    private void traversal(CallGraphContextVisitor visitor, EdgeAndContext edgeAndContext) {
        
        if (visited.contains(edgeAndContext)) 
            return;
        
        Edge current = edgeAndContext.edgeInto;
        Edge contextEntry = edgeAndContext.context;
        SootMethod method = current.tgt();
        
        visitor.visit(method, contextEntry, current);
        visited.add(edgeAndContext);
        
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
                    Map<AllocNode, SootMethod> virtualCallMap = GeoPTA.v().resolveVirtualInvokeMap(iie, contextEntry);
                    for (Map.Entry<AllocNode, SootMethod> entry: 
                        virtualCallMap.entrySet()) {
                        // Only the virtual calls do the following test
                        if ( entry.getValue() == target ) {
                            //found edge in context sensitive search
                            traversal(visitor, new EdgeAndContext(curEdge, newContextEntry));
                            break;
                        }   
                    } 
                } catch (CannotFindMethodException e) {
                    logger.error("Cannot resolve method during CallGraph traversal: {}", iie);
                    droidsafe.main.Main.exit(1);
                }   
            } else {
                traversal(visitor, new EdgeAndContext(curEdge, newContextEntry));
            }
        }
        
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
