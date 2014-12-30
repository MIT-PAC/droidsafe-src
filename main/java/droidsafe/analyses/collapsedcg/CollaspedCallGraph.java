package droidsafe.analyses.collapsedcg;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.jgrapht.graph.DirectedMultigraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.jgrapht.traverse.BreadthFirstIterator;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.app.Harness;
import droidsafe.android.system.API;
import soot.MethodOrMethodContext;
import soot.Scene;
import soot.SootMethod;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;

/**
 * This class represents the call grpah after a pta run is performed.  It is an overlay 
 * for the soot call graph that does not include API methods, but shortcuts edges between app methods
 * through the api.  For example if USER_A -> API_M -> USER_B, where USER_A and USER_B, are user methods, 
 * and API_M is an api method, then the collapsed call graph will have an edge from USER_A to USER_B, but 
 * API_M is not in the graph.
 * 
 * To create the graph use the sequence of reset() and v().
 *  
 * @author mgordon
 *
 */
public class CollaspedCallGraph {
    private final static Logger logger = LoggerFactory.getLogger(CollaspedCallGraph.class);
    
    private static CollaspedCallGraph v;
    
    private static boolean enabled = false;
    
    private DirectedMultigraph<SootMethod, StmtEdge> callgraph;
    
    private Set<SootMethod> entryPoints;
    
    private Map<Stmt, Set<StmtEdge<SootMethod>>> stmtToEdges;
    
    private CollaspedCallGraph() {
        callgraph = new DirectedMultigraph<SootMethod, StmtEdge>(StmtEdge.class);
        entryPoints = new LinkedHashSet<SootMethod>();
        stmtToEdges = new LinkedHashMap<Stmt, Set<StmtEdge<SootMethod>>>();
        createCG();
    }
    
    public static CollaspedCallGraph v() {
        if (v == null) {
            v = new CollaspedCallGraph();
        }
        
        return v;
    }
    
    public static void reset() {
        v = null;
    }
    
    public Set<SootMethod> getAllMethods() {
        return callgraph.vertexSet();
    }
    
    public boolean containsEdge(SootMethod v1, SootMethod v2, Stmt stmt) {
        Set<StmtEdge> edges = callgraph.getAllEdges(v1, v2);
        
        for (StmtEdge edge : edges) {
            if (stmt == null) {
                if (edge.getStmt() == null)
                    return true;
                else 
                    continue;
            }
            
            if (stmt.equals(edge.getStmt())) 
                return true;
        }
        
        return false;
    }
    
    private void resolveEdgesThroughAPI(Edge orginalEdge) {
               
        
        if (!(API.v().isIPCSink(orginalEdge.tgt()) || API.v().isIPCMethod(orginalEdge.tgt())))
            return;
        
        CallGraph cg = Scene.v().getCallGraph();
        
        List<SootMethod> userMethods = new LinkedList<SootMethod>();
        
        Queue<Edge> unprocessed = new LinkedList<Edge>();
        
        Iterator<Edge> outgoing = cg.edgesOutOf(orginalEdge.getTgt());
        while (outgoing.hasNext()) {
            unprocessed.add(outgoing.next());
        }
        
        Set<Edge> processed = new HashSet<Edge>();
        processed.add(orginalEdge);
        
        while (!unprocessed.isEmpty()) {
            Edge current = unprocessed.poll();
            
            if (!processed.add(current))
                continue;
            
            if (!API.v().isSystemMethod(current.tgt())) {
                if (!API.v().isSystemMethod(current.src())) {
                    logger.error("Should not see user method in middle of search: {}", current.src());
                }
                
                //user method
                userMethods.add(current.tgt());
            } else {
                // system method
                // find all edges from it, and add them to the queue unless they have been processed
                Iterator<Edge> outFromCurrent = cg.edgesOutOf(current.getTgt());
                while (outFromCurrent.hasNext()) {
                    Edge out = outFromCurrent.next();
                    if (!processed.contains(out)) {
                        unprocessed.add(out);
                    }
                }
            }
        }
        
        Stmt stmt = orginalEdge.srcStmt();
        callgraph.addVertex(orginalEdge.src());
        
        for (SootMethod userTarget : userMethods) {
            callgraph.addVertex(userTarget);
            
            if (!containsEdge(orginalEdge.src(), userTarget, stmt)) {
                StmtEdge<SootMethod> newEdge = new StmtEdge<SootMethod>(orginalEdge.src(), userTarget, stmt, true);
                
                callgraph.addEdge(orginalEdge.src(), userTarget, newEdge);
                                
                if (!stmtToEdges.containsKey(stmt)) {
                    stmtToEdges.put(stmt, new LinkedHashSet<StmtEdge<SootMethod>>());
                }
                
                stmtToEdges.get(stmt).add(newEdge);
            }                            
        }
    }
    
    private void createCG() {
        CallGraph ptaCG = Scene.v().getCallGraph();
        
        //find all user methods in pta call graph, and build edges from them
        for (MethodOrMethodContext momc : PTABridge.v().getReachableMethodContexts()) {
            SootMethod src = momc.method();
            
            if (API.v().isSystemMethod(src))
                continue;
            
            callgraph.addVertex(src);
                        
            Iterator<Edge> outgoingEs = ptaCG.edgesOutOf(momc); 
            while (outgoingEs.hasNext()) {
                Edge edge = outgoingEs.next();
                SootMethod tgt = edge.tgt();
                
                //resolve edges through api
                resolveEdgesThroughAPI(edge);
                
                if (API.v().isSystemMethod(tgt))
                    continue;
                
                callgraph.addVertex(tgt);
                                
                if (!containsEdge(src, tgt, edge.srcStmt())) {
                    StmtEdge<SootMethod> newEdge = new StmtEdge<SootMethod>(src, tgt, edge.srcStmt(), false);
                    
                    if (!stmtToEdges.containsKey(edge.srcStmt())) {
                        stmtToEdges.put(edge.srcStmt(), new LinkedHashSet<StmtEdge<SootMethod>>());
                    }
                    
                    stmtToEdges.get(edge.srcStmt()).add(newEdge);
                    
                    callgraph.addEdge(src, tgt, newEdge);
                }
            }
            
            //is this an entry point?
            Iterator<Edge> incomingEdges = ptaCG.edgesInto(momc);
            while (incomingEdges.hasNext()) {
                Edge incoming = incomingEdges.next();
                
                if (API.v().isSystemMethod(incoming.src())) {
                    entryPoints.add(src);
                    break;
                }
            }
        }
    }
    
    public BreadthFirstIterator<SootMethod,StmtEdge> getBreadthFirstTraversalFrom(SootMethod startVertex) {
        BreadthFirstIterator<SootMethod,StmtEdge> bfi = 
                new BreadthFirstIterator<SootMethod,StmtEdge>(callgraph, startVertex);
        
        return bfi;
    }
    
    public Set<StmtEdge> getAllThroughAPIEdges() {
        Set<StmtEdge> edges = new LinkedHashSet<StmtEdge>();
        
        for (StmtEdge edge : callgraph.edgeSet()) {
            if (edge.isThroughAPI())
                edges.add(edge);
        }
        
        return edges;
    }
    
    public Set<StmtEdge> getTargetsForMethod(SootMethod method) {
        if (callgraph.containsVertex(method)) {
            return callgraph.outgoingEdgesOf(method);
        } else
            return Collections.emptySet();
    }
    
    public Set<StmtEdge<SootMethod>> getTargetsForStmt(Stmt stmt) {
        if (stmtToEdges.containsKey(stmt)) {
            return stmtToEdges.get(stmt);                
        } else
            return Collections.emptySet();
    }
    
    /**
     * Returns all system methods called from method, does not prune the list based
     * on API.v().isInterestingMethod().
     */
    public Set<CallToTarget> getAPICallTargets(SootMethod method) {
        Set<CallToTarget> apiTargets = new LinkedHashSet<CallToTarget>();
        for (MethodOrMethodContext mc : PTABridge.v().getMethodContexts(method)) {
            Iterator<Edge> outgoing = Scene.v().getCallGraph().edgesOutOf(mc);
            while  (outgoing.hasNext()) {
                Edge edge = outgoing.next();
                
                if (API.v().isSystemMethod(edge.tgt())) 
                    apiTargets.add(new CallToTarget(edge.srcStmt(),edge.tgt()));
            }
        }
        return apiTargets;
    }
    
    public class CallToTarget {
        Stmt stmt;
        SootMethod target;
        
        public CallToTarget(Stmt stmt, SootMethod target) {
            super();
            this.stmt = stmt;
            this.target = target;
        }
        public Stmt getStmt() {
            return stmt;
        }
        public void setStmt(Stmt stmt) {
            this.stmt = stmt;
        }
        public SootMethod getTarget() {
            return target;
        }
        public void setTarget(SootMethod target) {
            this.target = target;
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((stmt == null) ? 0 : stmt.hashCode());
            result = prime * result + ((target == null) ? 0 : target.hashCode());
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            CallToTarget other = (CallToTarget) obj;
            if (!getOuterType().equals(other.getOuterType())) return false;
            if (stmt == null) {
                if (other.stmt != null) return false;
            } else if (!stmt.equals(other.stmt)) return false;
            if (target == null) {
                if (other.target != null) return false;
            } else if (!target.equals(other.target)) return false;
            return true;
        }
        private CollaspedCallGraph getOuterType() {
            return CollaspedCallGraph.this;
        }
        
        
    }
}
