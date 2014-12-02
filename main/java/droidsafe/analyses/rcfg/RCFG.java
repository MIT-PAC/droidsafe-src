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
import soot.Context;
import soot.Kind;
import soot.MethodContext;
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
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.util.Chain;
import soot.util.queue.QueueReader;
import soot.Type;
import soot.RefLikeType;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.pta.PointsToAnalysisPackage;
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
public class RCFG  {
    /** logger object */
    private static final Logger logger = LoggerFactory.getLogger(RCFG.class);
    /** Singleton of this class */
    private static RCFG v;
    /** File name for output of unreachable user methods */
    private static final String REACHABLES_FILE_NAME = "reachable-user-class-methods.txt"; 
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
    private Set<IAllocNode> apiCallNodes;
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
        //optimized new search, assumes far fewer user calls than api calls
        v().runAlt();

        //print unreachable methods to the debug log
        v().printReachableMethods();

        //System.out.println(v().toString());
    }
    
        
    /**
     * Return true if the method or method x content could be an entry point, meaning it is
     * defined in a user class, and it is called from the api.
     */
    public static boolean isUserEntryPoint(MethodOrMethodContext method) {
        CallGraph cg = Scene.v().getCallGraph();
        
        if (API.v().isSystemMethod(method.method()))
            return false;
        
        //here we know it is a user method
        if (API.v().isAIDLCallback(method.method())) 
            return true;
        
        if (method instanceof SootMethod) {
            for (MethodOrMethodContext mc : PTABridge.v().getMethodContexts((SootMethod)method)) {
                Iterator<Edge> incomings = cg.edgesInto(mc);
                while (incomings.hasNext()) {
                    Edge incoming = incomings.next();
                    if (API.v().isSystemMethod(incoming.src()))
                        return true;
                }
            }
            
        } else if (method instanceof MethodContext) {
            Iterator<Edge> incomings = cg.edgesInto(method);
            while (incomings.hasNext()) {
                Edge incoming = incomings.next();
                if (API.v().isSystemMethod(incoming.src()))
                    return true;
            }
        }
        
        return false;
    }
    

    private void runAlt() {
        CallGraph cg = Scene.v().getCallGraph();

        //loop over all reachable methods
        for (MethodOrMethodContext momc : PTABridge.v().getReachableMethodContexts()) {
            SootMethod sootMethod = momc.method();
            Context context = momc.context();

            //don't do anything for system methods
            if (API.v().isSystemMethod(sootMethod))
                continue;

            visitedMethods.add(sootMethod);

            logger.info("RCFG: looking at method {}", momc);

            Iterator<Edge> incomingEdges = cg.edgesInto(momc);
            while (incomingEdges.hasNext()) {
                Edge incomingEdge = incomingEdges.next();
                //if method is user, and has incoming edge from system, then it is an entry point
                if (API.v().isSystemMethod(incomingEdge.src()) || API.v().isAIDLCallback(sootMethod)) {
                    //System.out.println("Event Edge: " + incomingEdge);
                    //now we have an entry point
                    //find all reachable user code from method
                    //for each method call, see if it is an api call
                    
                    //add ie for aidl callback no matter if there are sensitive calls
                    if (API.v().isAIDLCallback(sootMethod)) {
                        //this will create the rcfgnode
                        getNodeForEntryEdge(incomingEdge);
                    }
                    
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
        logger.info("find output events for event edge: {}", entryEdge);
        CallGraph cg = Scene.v().getCallGraph();

        LinkedList<Edge> stack = new LinkedList<Edge>();
        Set<Edge> visitedEdges = new HashSet<Edge>();

        stack.add(entryEdge);

        while (!stack.isEmpty()) {
            Edge current = stack.pop();

            //do not visit if we have seen this full context and entry edge before
            if (visitedEdges.contains(current)) 
                continue;

            MethodOrMethodContext momc = current.getTgt();

            //remember what we have visited
            visitedEdges.add(current);

            //don't do anything if we are in a system method
            if (API.v().isSystemMethod(momc.method()))
                continue;

            Iterator<Edge> ciEdges = cg.edgesOutOf(momc);

            //iterate over all the ci edges from soot, and check to see
            //if they are valid given the context
            while (ciEdges.hasNext()) {

                Edge outgoingEdge = ciEdges.next();

                logger.info("Looking at edge: {}", outgoingEdge);

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
        this.apiCallNodes = new HashSet<IAllocNode>();
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
    public boolean isRecOrArgForAPICall(IAllocNode an) {
        return apiCallNodes.contains(an);
    }

    /**
     * Return all nodes that are receiver or argument for interesting api calls.
     */
    public Set<IAllocNode> getRecOrArgsForAPICalls() {
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

        /*System.out.printf("Checking for output edge: %s %s %s %s\n", callee, API.v().isSystemMethod(callee), 
            !API.v().isSystemMethod(caller),
            API.v().isInterestingMethod(callee));

        System.out.println("\t" + callEdge.srcStmt());*/

        if (API.v().isSystemMethod(callee) && 
                !API.v().isSystemMethod(caller) && 
                API.v().reportInSpec(callee) &&
                !IGNORE_SYS_METHOD_WITH_NAME.contains(callee.getName()) &&
                !ignoreSet.contains(callEdge.srcStmt())) {

            RCFGNode node = getNodeForEntryEdge(eventEdge);

            Context context = callEdge.srcCtxt();

            SourceLocationTag line = 
                    SootUtils.getSourceLocation(callEdge.srcStmt(), callEdge.src().getDeclaringClass());

            InvokeExpr invoke = callEdge.srcStmt().getInvokeExpr();
            if (invoke instanceof InstanceInvokeExpr) {
                InstanceInvokeExpr iie = (InstanceInvokeExpr)invoke;

                //use the pta to find all the alloc nodes for the source call
                //for each, see if they map to the destination method, if they do,
                //create the output event
                for (IAllocNode allocNode : PTABridge.v().getPTSet(iie.getBase(), context)) {
                    //System.out.printf("\t %s %s %s\n", entry.getKey(), entry.getValue(), callee);
                    //System.out.println("\tReachable: " + Scene.v().getReachableMethods().contains(entry.getValue()));

                    SootMethod resolved = Scene.v().getActiveHierarchy().resolveConcreteDispatch(
                        SootUtils.getCallingTypeForReceiver((RefLikeType)allocNode.getType()), 
                        iie.getMethod());

                    if (resolved.equals(callee)) {
                        if (debug)
                            System.out.println(allocNode);

                        if (node.hasOutputEventEdge(callEdge)) {
                            //we already have added an output event for this call site, so just add
                            //the new allocnode
                            OutputEvent oe = node.getOutputEvent(callEdge);
                            oe.addReceiverNode(allocNode);
                        } else {
                            //new output event that we have not seen, create output event and install it
                            OutputEvent oe = new OutputEvent(callEdge, node, line);
                            logger.debug("Found output event: {}", callEdge.tgt());
                            oe.addReceiverNode(allocNode);
                            node.addOutputEvent(callEdge, oe);
                            apiCallNodes.addAll(oe.getAllArgsPTSet());
                        }

                        //remember interesting alloc nodes
                        apiCallNodes.add(allocNode);                            
                    }

                }

            } else {
                if (!node.hasOutputEventEdge(callEdge)) {
                    OutputEvent oe = new OutputEvent(callEdge, node, line);
                    logger.debug("Found output event: {} (null receiver)", callEdge.tgt());
                    node.addOutputEvent(callEdge, oe);
                    apiCallNodes.addAll(oe.getAllArgsPTSet());
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

            if (API.v().isSensitiveAction(method))
                strBuilder.append("\t" + method + "\n");
        }

        return strBuilder.toString();
    }

    /**
     * Loop over methods in the application we did not hit, because the analysis thinks they
     * are unreachable, and inform the user of any api calls in unreachable methods.
     */
    private void printReachableMethods() {

        try {
            FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + REACHABLES_FILE_NAME);

            fw.write("# All Reachable Methods in User Classes (including system methods) \n\n");

            for (MethodOrMethodContext mc : PTABridge.v().getReachableMethodContexts()) {
                SootMethod method = mc.method();

                if (!API.v().isSystemMethod(method) || 
                        method.getDeclaringClass().getName().startsWith("droidsafe.generated")) {
                    fw.write(mc + "\n");
                    fw.write("\tSRCS:\n");
                    for (Edge src : PTABridge.v().incomingEdges(mc)) {
                        fw.write("\t" + src.getSrc() + "\n");
                    }
                    /*
                    fw.write("\n\tDESTS:\n");
                    Iterator<Edge> edges = Scene.v().getCallGraph().edgesOutOf(mc);
                    while (edges.hasNext()){
                        fw.write("\t" + edges.next() + "\n");
                    } 
                     */      
                    fw.write("\n");
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
