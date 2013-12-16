package droidsafe.analyses.rcfg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.AnySubType;
import soot.ArrayType;
import soot.Body;
import soot.Kind;
import soot.MethodOrMethodContext;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.jimple.AssignStmt;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.NewExpr;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.internal.JAssignStmt;
import soot.jimple.spark.geom.dataRep.CgEdge;
import soot.jimple.spark.geom.geomPA.GeomPointsTo;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.util.Chain;
import soot.util.queue.QueueReader;
import soot.Type;
import soot.RefLikeType;
import droidsafe.analyses.pta.ContextType;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.pta.PTAContext;
import droidsafe.analyses.pta.PointsToAnalysisPackage;
import droidsafe.analyses.pta.cg.CGContextVisitor;
import droidsafe.analyses.pta.cg.CGVisitorEntryAnd1CFA;
import droidsafe.analyses.pta.cg.CallGraphTraversal;
import droidsafe.android.app.EntryPoints;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Project;
import droidsafe.android.app.resources.Resources;
import droidsafe.android.system.API;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;
import droidsafe.utils.Utils;


/**
 * This class represents the reduced control flow graph starting from
 * the entry points defined as edge from API to user code.  It is 
 * built on top of the geometric points to analysis from soot.  
 * 
 * @author mgordon
 *
 */
public class RCFG implements CGContextVisitor {
    /** logger object */
    private static final Logger logger = LoggerFactory.getLogger(RCFG.class);
    /** Singleton of this class */
    private static RCFG v;
    /** File name for output of unreachable user methods */
    private static final String UNREACHABLES_FILE_NAME = "unreachable-user-methods.txt"; 
    /** list of names of methods to ignore when creating the RCFG output events */
    private static final Set<String> IGNORE_SYS_METHOD_WITH_NAME = 
            new HashSet<String>(Arrays.asList("<clinit>", "finalize"));
    /** list of package name REs in which to ignore output events */
    private static final Pattern[] IGNORE_INPUT_EVENTS_IN = 
        {Pattern.compile("android.support.*")};
    /** Map of entry edge to the rcfg node representing it */
    private Map<Edge,RCFGNode> entryEdgeToNode;
    /** methods we have visited in our search */
    private Set<SootMethod> visitedMethods;
    /** alloc nodes that are either a receiver or argument for an api call */
    private Set<AllocNode> apiCallNodes;
    /** ignore making output events for stmts in this set */
    private Set<Stmt> ignoreSet;

    /**
     * Return the singleton of this class.
     */
    public static RCFG v() {
        if (v == null)
            v = new RCFG();

        return v;
    }

    /**
     * Reset state of this analysis.
     */
    public static void reset() {
        v = null;
        v = new RCFG();
    }

    /**
     * Generate the rCFG.
     */
    public static void generate() {
        //old traversal
        //CallGraphTraversal.acceptContext(v(), ContextType.EVENT_CONTEXT);;
        
        //optimized new search, assumes far fewer user calls than api calls
        v().runAlt();
        
        //print unreachable methods to the debug log
        v().printUnreachableSrcMethods();
    }

    private void runAlt() {
        CallGraph cg = Scene.v().getCallGraph();
        
        //loop over all reachable methods
        for (SootMethod method : PTABridge.v().getAllReachableMethods()) {
            //don't do anything for system methods
            if (API.v().isSystemMethod(method))
                continue;
       
            visitedMethods.add(method);
            
            Iterator<Edge> incomingEdges = cg.edgesInto(method);
            while (incomingEdges.hasNext()) {
                Edge incomingEdge = incomingEdges.next();
                //if method is user, and has incoming edge from system, then it is an entry point
                if (API.v().isSystemMethod(incomingEdge.src())) {
                    //System.out.println("Event Edge: " + incomingEdge);
                    //now we have an entry point
                    //find all reachable user code from method
                    //for each method call, see if it is an api call
                    findOutputEventsForEventEdge(incomingEdge);
                }
            }
        } 
    }
    
    /** 
     * Starting from entry edge, find all reachable user method, stopping at system calls
     * for each user method, find all output event api calls and build nodes for them
     */
    private void findOutputEventsForEventEdge(Edge entryEdge) {
        CallGraph cg = Scene.v().getCallGraph();
        
        LinkedList<Edge> stack = new LinkedList<Edge>();
        Set<Edge> visitedEdges = new HashSet<Edge>();
        
        stack.add(entryEdge);

        while (!stack.isEmpty()) {
            Edge current = stack.pop();

            //do not visit if we have seen this full context and entry edge before
            if (visitedEdges.contains(current)) 
                continue;

            SootMethod method = current.tgt();
            
            //remember what we have visited
            visitedEdges.add(current);
            
            //don't do anything if we are in a system method
            if (API.v().isSystemMethod(method))
                continue;
                        
            Iterator<Edge> ciEdges = cg.edgesOutOf(method);

            //iterate over all the ci edges from soot, and check to see
            //if they are valid given the context
            while (ciEdges.hasNext()) {
                Edge outgoingEdge = ciEdges.next();

                SootMethod calleeMethod = outgoingEdge.tgt();

                if (API.v().isSystemMethod(calleeMethod)) {
                    //possibly an output event
                    addOutputEvent(outgoingEdge, entryEdge);
                    //don't traverse into call
                    
                } else {
                    //call to another user method, add to stack if we have not seen it
                    if (!visitedEdges.contains(outgoingEdge))
                        stack.push(outgoingEdge);
                }
            }
        }
    }
    
    private RCFG() {
        this.visitedMethods = new HashSet<SootMethod>();
        this.entryEdgeToNode = new LinkedHashMap<Edge, RCFGNode>();
        this.apiCallNodes = new HashSet<AllocNode>();
        this.ignoreSet = new HashSet<Stmt>(); 
    }

    /**
     * Don't create output events for any methods from this invoke expr
     */
    public void ignoreInvokeForOutputEvents(Stmt stmt) {
        ignoreSet.add(stmt);
    }

    /**
     * Return true if this allocation node can possible be an argument or receiver for an output event.
     */
    public boolean isRecOrArgForAPICall(AllocNode an) {
        return apiCallNodes.contains(an);
    }

    /**
     * Return all nodes that are receiver or argument for interesting api calls.
     */
    public Set<AllocNode> getRecOrArgsForAPICalls() {
        return apiCallNodes;
    }

    /**
     * Get the nodes of the rCFG (a forrest).
     */
    public Collection<RCFGNode> getNodes() {
        return entryEdgeToNode.values();
    }

    /**
     * Given an edge from api -> app, return the rcfgnode that represents it in the RCFG.  
     */
    public RCFGNode getNodeForEntryEdge(Edge entryEdge) {
        if (!entryEdgeToNode.containsKey(entryEdge)) {
            logger.info("Creating new RCFG node from edge {}", entryEdge);
            entryEdgeToNode.put(entryEdge, new RCFGNode(entryEdge));
        }

        return entryEdgeToNode.get(entryEdge);
    }


    /**
     * Given a call edge from user to api, and an event edge, decide if we should create
     * an output event for it, and if so, create the output event.
     */
    private void addOutputEvent(Edge callEdge, Edge eventEdge) {
        SootMethod caller = callEdge.src();
        SootMethod callee = callEdge.tgt();
        boolean debug = false;
        
        PTAContext eventContext = new PTAContext(ContextType.EVENT_CONTEXT, eventEdge);
        PTAContext oneCFAContext = new PTAContext(ContextType.ONE_CFA, callEdge);
        
        if (API.v().isSystemMethod(callee) && 
                !API.v().isSystemMethod(caller) &&
                API.v().isInterestingMethod(callee) &&
                !IGNORE_SYS_METHOD_WITH_NAME.contains(callee.getName()) &&
                !ignoreSet.contains(callEdge.srcStmt())) {
            
            RCFGNode node = getNodeForEntryEdge(eventEdge);
            
            SourceLocationTag line = 
                    SootUtils.getSourceLocation(callEdge.srcStmt(), callEdge.src().getDeclaringClass());
            
            InvokeExpr invoke = callEdge.srcStmt().getInvokeExpr();
            if (invoke instanceof InstanceInvokeExpr) {
                InstanceInvokeExpr iie = (InstanceInvokeExpr)invoke;
                try {
                    //use the pta to find all the alloc nodes for the source call
                    //for each, see if they map to the destination method, if they do,
                    //create the output event
                    for (Map.Entry<AllocNode, SootMethod> entry : 
                        PTABridge.v().resolveInstanceInvokeMap(iie, eventContext).entrySet()) {
                        if (entry.getValue().equals(callee)) {
                            if (debug)
                                System.out.println(entry.getKey());
                            
                            OutputEvent oe = new OutputEvent(oneCFAContext, eventContext, node, line);
                            oe.addReceiverNode(entry.getKey());
                            
                            node.addOutputEvent(oe);
                            //remember interesting alloc nodes
                            apiCallNodes.add(entry.getKey());
                            apiCallNodes.addAll(oe.getAllArgsPTSet(eventContext));
                        }

                    }
                } catch (CannotFindMethodException e) {
                    logger.error("Could not find a possible target for a call (RCFG): {} in {}", iie, 
                        callEdge.getSrc());
                    droidsafe.main.Main.exit(1);
                }
            } else {
                OutputEvent oe = new OutputEvent(oneCFAContext, eventContext, node, line);
                logger.debug("Found output event: {} (null receiver)", callEdge.tgt());
                node.addOutputEvent(oe);
                apiCallNodes.addAll(oe.getAllArgsPTSet(eventContext));
            }
        }
    }

    /**
     * for each edge, decide if the edge should appear as an output event for the context edge represented
     * by the RCFGNode for the context.
     * 
     * Also, when an output event is found, query for all the alloc nodes that could be either a receiver or an 
     * argument, and remember these nodes for later processing by MethodCallsOnAllocs.
     */
    public void visit(SootMethod method, PTAContext eventContext) { 
        //remember that we have visited this method
        visitedMethods.add(method);

        //loop through all incoming edges for this method
        CallGraph cg = Scene.v().getCallGraph();
        Iterator<Edge> incomingEdges = cg.edgesInto(method); 
        while (incomingEdges.hasNext()) {
            Edge incomingEdge = incomingEdges.next();
            PTAContext oneCFAContext = new PTAContext(ContextType.ONE_CFA, incomingEdge);

            //only add to the rcfg node if there is a call from app code (non-system method) into the api (system method)
            //and the called system method is interesting
            //and we should not ignore it.
            if (API.v().isSystemMethod(method) && 
                    !API.v().isSystemMethod(incomingEdge.src()) &&
                    API.v().isInterestingMethod(method) &&
                    !IGNORE_SYS_METHOD_WITH_NAME.contains(method.getName()) &&
                    !ignoreSet.contains(incomingEdge.srcStmt())) {

                RCFGNode node = getNodeForEntryEdge(eventContext.getContext());

                SourceLocationTag line = 
                        SootUtils.getSourceLocation(incomingEdge.srcStmt(), incomingEdge.src().getDeclaringClass());

                InvokeExpr invoke = incomingEdge.srcStmt().getInvokeExpr();
                if (invoke instanceof InstanceInvokeExpr) {
                    InstanceInvokeExpr iie = (InstanceInvokeExpr)invoke;
                    try {
                        //use the pta to find all the alloc nodes for the source call
                        //for each, see if they map to the destination method, if they do,
                        //create the output event
                        for (Map.Entry<AllocNode, SootMethod> entry : 
                            PTABridge.v().resolveInstanceInvokeMap(iie, eventContext).entrySet()) {
                            if (entry.getValue().equals(method)) {
                                OutputEvent oe = 
                                        new OutputEvent(oneCFAContext, eventContext, node, line);
                                oe.addReceiverNode(entry.getKey());
                                
                                logger.debug("Found output event: {} {}", incomingEdge.tgt(), entry.getKey());
                                node.addOutputEvent(oe);
                                //remember interesting alloc nodes
                                apiCallNodes.add(entry.getKey());
                                apiCallNodes.addAll(oe.getAllArgsPTSet(eventContext));
                            }

                        }
                    } catch (CannotFindMethodException e) {
                        logger.error("Could not find a possible target for a call (RCFG): {} in {}", iie, 
                            incomingEdge.getSrc());
                        droidsafe.main.Main.exit(1);
                    }
                } else {
                    OutputEvent oe = new OutputEvent(oneCFAContext, eventContext, node, line);
                    logger.debug("Found output event: {} (null receiver)", incomingEdge.tgt());
                    node.addOutputEvent(oe);
                    apiCallNodes.addAll(oe.getAllArgsPTSet(eventContext));
                }
            }
        }
    }

    /**
     * Find and return a string of all invoke statements that could invoke an API call.
     */
    private String checkForCompleteness(SootMethod src) {

        if (!src.isConcrete())
            return "";

        if (Project.v().isLibClass(src.getDeclaringClass().toString()))
            return "";

        StringBuilder strBuilder = new StringBuilder();
        StmtBody stmtBody = (StmtBody)src.retrieveActiveBody();

        // get body's unit as a chain
        Chain<Unit> units = stmtBody.getUnits();

        // get a snapshot iterator of the unit since we are going to
        // mutate the chain when iterating over it.
        Iterator<Unit> stmtIt = units.snapshotIterator();

        while (stmtIt.hasNext()) {
            Stmt stmt = (Stmt)stmtIt.next();
            if (!stmt.containsInvokeExpr())
                continue;
            InvokeExpr invokeExpr = stmt.getInvokeExpr();

            SootMethod method = invokeExpr.getMethod();

            if (API.v().isInterestingMethod(method))
                strBuilder.append("\t" + method + "\n");
        }

        return strBuilder.toString();
    }

    /**
     * Loop over methods in the application we did not hit, because the analysis thinks they
     * are unreachable, and inform the user of any api calls in unreachable methods.
     */
    private void printUnreachableSrcMethods() {

        try {
            FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + UNREACHABLES_FILE_NAME);

            fw.write("# Unreachable Methods and the api calls they Invoke \n");
            fw.write("# DroidSafe determined that these methods are unreachable, but that may be unsound\n");
            fw.write("# due to Android api errors or omissions.\n\n");


            for (SootClass clz : Scene.v().getClasses()) {
                if (clz.isApplicationClass() && Project.v().isSrcClass(clz.toString()) &&
                        !Project.v().isGenClass(clz.toString())) {
                    for (SootMethod method : clz.getMethods()) {
                        if (!visitedMethods.contains(method)) {
                            String apiCalls = checkForCompleteness(method);

                            if (!apiCalls.isEmpty()) {
                                fw.write(method + ":\n" + apiCalls + "\n\n");
                            }
                        }
                    }
                }
            }

            fw.close();
        } catch (IOException e) {
            logger.error("Error writing unreachable user methods summary files.");
            droidsafe.main.Main.exit(1);
        } 
    }

    /** 
     * Return true if the class of the input event is in the ignore list, and thus the 
     * input event should be ignored.
     */
    private boolean shouldIgnoreInputEventFromClass(String clzName) {
        for (Pattern re : IGNORE_INPUT_EVENTS_IN) {
            Matcher matcher = re.matcher(clzName); 
            if (matcher.matches())
                return true;
        }
        return false;
    }

    /**
     * Return string representation of RCFG.
     */
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (RCFGNode node : entryEdgeToNode.values()) {
            str.append(node + "\n");
        }

        return str.toString();
    }
}
