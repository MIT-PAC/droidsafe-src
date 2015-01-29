package droidsafe.analyses;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.Context;
import soot.MethodOrMethodContext;
import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.Value;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.pta.IAllocNode;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.pta.PointsToAnalysisPackage;
import droidsafe.analyses.rcfg.OutputEvent;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.value.RefVAModel;
import droidsafe.utils.SootUtils;
import droidsafe.analyses.pta.PTABridge;
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
public class MethodCallsOnAlloc {
    private static final Logger logger = LoggerFactory.getLogger(MethodCallsOnAlloc.class);
    /** Map of alloc node to edges that could have alloc node as receiver or arg */
    private Map<IAllocNode,Set<Edge>> nodeToCalls;
    /** Singleton object */
    private static MethodCallsOnAlloc v;
    /** precalculate the types of objects we are tracking so we can reduce number of pta queries by 
     * a type based filter */
    private Set<Type> typesToConsider;

    /**
     * Private constructor
     */
    private MethodCallsOnAlloc() {
        nodeToCalls = new HashMap<IAllocNode,Set<Edge>>();
        typesToConsider = new HashSet<Type>();
        calculateTypesToConsider();
    }

    /**
     * precalculate the types we care about tracking so we can reduce the number of pta queries.
     */
    private void calculateTypesToConsider() {
        for (IAllocNode node : RCFG.v().getRecOrArgsForAPICalls()) {
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
        if (v == null)
            v = new MethodCallsOnAlloc();
        
        return v;
    }

    /**
     * Build maps of alloc nodes from RCFG list to API calls that have them as args or receiver.
     */
    public static void run() {
        v = new MethodCallsOnAlloc();
        if (PTABridge.v().getPackage() == PointsToAnalysisPackage.SPARK) {
            v.runInternalSpark();
        } else {
            logger.error("Only SPARK supported!");
            droidsafe.main.Main.exit(1);
        }
    }

    /** optimized search for context insensitive points to analysis */
    private void runInternalSpark() {
        //loop over all methods, for each invoke in or out, decide track appropriate metrics
        
        for (MethodOrMethodContext momc : PTABridge.v().getReachableMethodContexts()) {
            SootMethod method = momc.method();
            Context context = momc.context();
            
            //do nothing for system methods
            if (API.v().isSystemMethod(method))
                continue;
            
            Iterator<Edge> outgoingEdges = Scene.v().getCallGraph().edgesOutOf(momc);
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
                        Set<? extends IAllocNode> nodes;
                        nodes = PTABridge.v().getPTSet(iie.getBase(), context);
                        
                        for (IAllocNode an : nodes) {
                            if (RCFG.v().isRecOrArgForAPICall(an)) {
                                getCalls(an).add(edge);
                            }
                        }
                    }
                }

                for (Value argv : invoke.getArgs()) {
                    if (PTABridge.v().isPointer(argv) && typesToConsider.contains(argv.getType())) {
                        Set<? extends IAllocNode> nodes;
                        nodes = PTABridge.v().getPTSet(argv, context);
                            
                        for (IAllocNode an : nodes) {
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
     * For a given alloc node that is important for RCFG (used in an api call) return the set
     * of all calls that could have this alloc node as either a receiver or argument. 
     */
    public Set<Edge> getCalls(IAllocNode an) {
        if (!RCFG.v().isRecOrArgForAPICall(an)) 
            return null;

        if (!nodeToCalls.containsKey(an)) {
            nodeToCalls.put(an, new HashSet<Edge>());
        }

        return nodeToCalls.get(an);
    }
}
