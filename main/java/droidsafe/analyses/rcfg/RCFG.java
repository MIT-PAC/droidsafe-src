package droidsafe.analyses.rcfg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.AnySubType;
import soot.ArrayType;
import soot.Body;
import soot.MethodOrMethodContext;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.NewExpr;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.internal.JAssignStmt;
import soot.jimple.spark.geom.geomPA.CgEdge;
import soot.jimple.spark.geom.geomPA.GeomPointsTo;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.util.Chain;
import soot.util.queue.QueueReader;
import soot.Type;

import droidsafe.analyses.GeoPTA;
import droidsafe.android.app.EntryPoints;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Project;
import droidsafe.android.app.resources.Resources;
import droidsafe.android.system.API;
import droidsafe.transforms.AddAllocsForAPICalls;
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
public class RCFG {
    /** logger object */
    private final static Logger logger = LoggerFactory.getLogger(RCFG.class);
    /** Soot's call graph */
    private CallGraph sparkCG;
    /** The forrest of rCFG nodes */
    private Set<RCFGNode> rCFG;
    /** list of names of methods to ignore when creating the RCFG output events */
    private static final Set<String> IGNORE_SYS_METHOD_WITH_NAME = new HashSet(Arrays.asList("<clinit>", "finalize"));
    /** Singleton of this class */
    private static RCFG v;
    /** methods we have visiting while building the rCFG */
    private Set<SootMethod> visitedMethods;

    /**
     * Return the singleton of this class.
     */
    public static RCFG v() {
        return v;
    }

    /**
     * Generate the rCFG.
     */
    public static void generate() {

        v = new RCFG();
        v.createRCFG();

        //for (RCFGNode node : v.rCFG)
        //	System.out.println(node.toString());
        //logger.info("\n" + v.toString());
    }

    /**
     * Private constructor.
     */
    private RCFG() {
        visitedMethods = new LinkedHashSet<SootMethod>();
    }

    /**
     * Get the nodes of the rCFG (a forrest).
     */
    public Set<RCFGNode> getNodes() {
        return rCFG;
    }

    /**
     * Internal method to iterate over all entry point edges and make rCFG nodes for them.
     */
    private void createRCFG() {
        sparkCG = Scene.v().getCallGraph();
        rCFG = new LinkedHashSet<RCFGNode>();

        //iterate over all edges to find entry points for rcfg
        //these entry points are edges from harness to user code
        //or edges from api call to user code
        QueueReader<Edge> edges = sparkCG.listener();

        while (edges.hasNext()) {
            Edge e = edges.next();
            SootClass tgtClass = e.tgt().getDeclaringClass();
            if (!Project.v().isLibClass(tgtClass) && !Project.v().isSrcClass(tgtClass))
                continue;

            SootClass srcClass = e.src().getDeclaringClass();
            //find edges from harness to user code
            if (srcClass.equals(Harness.v().getHarnessClass()) ||
                    API.v().isSystemClass(srcClass)) {
                //System.out.printf("Processing edge: %s\n", e);
                startAtEntry(e);
            }
        }
        //print unreachable methods to the debug log
        checkForUnreachableMethods();
    }

    /**
     * Create an RCFGNode from an entry point edge and then starting at this edge, find all api calls and add as 
     * output events to the rCFG edge.
     */
    private void startAtEntry(Edge edge) {
        SootMethod method = edge.tgt();

        //don't create entry points for edges into api
        if (API.v().isSystemMethod(edge.tgt()))  {
            logger.info("For RCFG, ignoring entry point: {}", method);
            return;
        }

        //create node, and add to it the RCFG
        RCFGNode node = new RCFGNode(edge);
        logger.info("Creating new RCFG node from edge {}", edge);
        rCFG.add(node);
        //visit the call graph from this point
        visitEdge(edge, edge, node, new LinkedHashSet<Edge>());
    }

    /**
     * Visit a edge during the construction of an single rCFG node.  Find all api calls and all calls to other app
     * methods.  Visit all of these edges in a recursive search.
     * 
     * Context is the context edge of the input event (the entry point).
     * edgeInto is the edge we are visiting.
     * 
     */
    private void visitEdge(Edge context, Edge edgeInto, RCFGNode rCFGNode, Set<Edge> visited) {
        SootMethod method = edgeInto.tgt();

        visited.add(edgeInto);
        visitedMethods.add(method);

        Set<Edge> appEdgesOut = new LinkedHashSet<Edge>();
        Set<Edge> allEdges = new LinkedHashSet<Edge>();

        //find all calls to api and save context and call to rCFGNode

        //first check on the calls directly in the call graph
        //and do this in a context sensitive way, process each edge
        csEdges(rCFGNode, context, edgeInto, appEdgesOut, allEdges);

        //next add calls that can happen in the runtime for any
        //api objects that are created, process each edge
        edgesFromAPIAllocs(rCFGNode, context, edgeInto, appEdgesOut, allEdges);

        //recurse into all calls of app methods
        for (Edge edge : appEdgesOut) {
            logger.debug("Visiting edge: {}", edge);
            if (!visited.contains(edge))
                visitEdge(context, edge, rCFGNode, visited);
        }

        //maybe cache methods at a certain depth if there are other edges into it
    }

    /** 
     * Found an edge that could be an output event or an app edge, 
     * 
     * if an output event create one and add necessary information, 
     * 
     * if an app edge, add edge to the set of app edges to inspect
     */
    private void processEdge(RCFGNode rCFGNode, Edge edge, Edge context, 
                             AllocNode receiver, Set<Edge> appEdgesOut, Set<Edge> allEdges, int debug) {

        allEdges.add(edge);
        //logger.info("Looking at method call for: {}->{} ({}).", edge.src(), edge.tgt(), edge.srcStmt());
        if (API.v().isSystemMethod(edge.tgt())) {
            if (!IGNORE_SYS_METHOD_WITH_NAME.contains(edge.tgt().getName())) {
                logger.debug("Found output event: {} {}", edge.tgt(), receiver );
                //System.out.printf("OE (%s): %s %s (%s)\n", debug, edge.tgt(), receiver, rCFGNode.getEntryPoint());
                SourceLocationTag line = SootUtils.getSourceLocation(edge.srcStmt(), edge.src().getDeclaringClass());
                OutputEvent oe = new OutputEvent(edge, context, rCFGNode, receiver, line);
                rCFGNode.addOutputEvent(oe);
            }
        } else {
            //it is an app edge, so recurse into later
            appEdgesOut.add(edge);
        }
    }

    /**
     * Check that we have considered all invoke statements in the code of the method.
     */
    private void checkForCompleteness(Set<Edge> edges, SootMethod src) {

        if (!src.isConcrete())
            return;

        if (Project.v().isLibClass(src.getDeclaringClass().toString()))
            return;

        //first build a set with all invokes we in the edges list
        Set<Stmt> invokes = new LinkedHashSet<Stmt>();
        for (Edge edge : edges) {
            invokes.add(edge.srcStmt());
        }


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

            if (!invokes.contains(stmt))
                logger.info("Found invoke statement that was not in the callgraph edge list when build rCFG:" +
                        " {} in {} (might be dead code)", stmt, src);

        }
    }

    /**
     * Loop over methods in the application we did not hit, because the analysis thinks they
     * are unreachable, and inform the user of any calls in unreachable methods.
     */
    private void checkForUnreachableMethods() {
        for (SootClass clz : Scene.v().getClasses()) {
            if (clz.isApplicationClass() && Project.v().isSrcClass(clz.toString()) &&
                    !Project.v().isGenClass(clz.toString())) {
                for (SootMethod method : clz.getMethods()) {
                    if (!visitedMethods.contains(method) && method.isDeclared()) {
                        checkForCompleteness(new LinkedHashSet<Edge>(), method);
                    }
                }
            }
        }
    }

    /***
     * We have to be extra careful for calls with the receiver as a generated alloc expression
     * from an api call (see droidsafe.transforms.AddAllocsForAPICalls).  
     * 
     * Since we often times do not know which specific runtime type is returned from an api method,
     * we create allocs of the most general types.  But if the later, the object is cast to something 
     * more specific, and then a method is called on it, that is not a method defined in the more general
     * class, this method will not appear in the call graph, because soot cannot find it.
     * 
     * So we look for these calls, and add them manually for now.  This should be fixed when we model api
     * call return values.
     * 
     * We don't know the exact type
     * of the expression, so we need to add calls for all overriding methods of the receiver and method
     * combination.
     */
    private void edgesFromAPIAllocs(RCFGNode rCFGNode, Edge context, Edge edgeInto, 
                                    Set<Edge> appEdgesOut, Set<Edge> allEdges) {
        SootMethod src = edgeInto.tgt();

        if (src.isNative()) {
            logger.error("Found a native method during analysis: {}. It could do anything!\n\n", src);
            System.exit(1);
        }

        if (!src.isConcrete())
            return;

        StmtBody stmtBody = (StmtBody)src.getActiveBody();

        // get body's unit as a chain
        Chain<Unit> units = stmtBody.getUnits();

        // get a snapshot iterator of the unit since we are going to
        // mutate the chain when iterating over it.
        Iterator<Unit> stmtIt = units.snapshotIterator();

        while (stmtIt.hasNext()) {
            Stmt stmt = (Stmt)stmtIt.next();
            InstanceInvokeExpr expr = SootUtils.getInstanceInvokeExpr(stmt);
            if (expr == null) 
                continue;

            /*
			if (!GeoPTA.v().isPointer(expr.getBase())) {
				System.out.printf("Not a pointer %s for call %s %s\n", expr.getBase(), expr, 
						SootUtils.getSourceLocation(stmt, src.getDeclaringClass()));
			}
             */

            for (AllocNode alloc : GeoPTA.v().getPTSet(expr.getBase(), context)) {
                if (AddAllocsForAPICalls.v().isGeneratedExpr(alloc.getNewExpr())) {
                    Type t = alloc.getType();

                    if ( t instanceof AnySubType ||
                            t instanceof ArrayType ) {
                        logger.error("Weird type in call to object retrieved from API {}", stmt);
                        System.exit(1);
                    }
                    SootClass allocType = ((RefType)t).getSootClass();

                    //try to find the method in the runtime type of the object
                    //if we cannot, then we were too general with the added allocation, so
                    //then find all methods in implementing classes that this could be
                    try {
                        SootUtils.resolveConcreteDispatch(allocType, expr.getMethod());
                    } catch (CannotFindMethodException e) {

                        Set<SootMethod> allMethods = 
                                SootUtils.getOverridingMethodsIncluding(expr.getMethod().getDeclaringClass(), 
                                    expr.getMethodRef().getSubSignature().getString());

                        for (SootMethod m : allMethods) {
                            Edge newEdge = new Edge(src, stmt, m);
                            System.out.printf("Creating edge for %s: %s\n", alloc, newEdge);
                            processEdge(rCFGNode, newEdge, context, alloc, appEdgesOut, allEdges, 1);
                        }
                    }
                }
            }
        }

        return;
    }

    /**
     * Given an invoke statement, return the class of the receiver's static type definition.
     */
    private SootClass getStaticReceiverClassType(InvokeExpr expr) {
        if (expr instanceof InstanceInvokeExpr) {
            Type baseType = ((InstanceInvokeExpr)expr).getBase().getType();

            if (baseType instanceof RefType) {
                return ((RefType)baseType).getSootClass();
            }
        } else if (expr instanceof StaticInvokeExpr) {
            return ((StaticInvokeExpr)expr).getMethod().getDeclaringClass();
        } else {
            logger.error("Unknown type of invoke expr found when trying to get receiver's static type: {}", expr);
            System.exit(1);
        }
        return null;
    }

    /**
     * Find all the edges out of a method given the context edge.  Organize the edges into
     * applicatoin edges (appEdgesOut) and all edges (allEdges).  Use the context sensitive of 
     * the input event to query the PTA for instance invokes to cull the call graph for the
     * context.
     */
    private void csEdges(RCFGNode rCFGNode, Edge context, Edge edgeInto, 
                         Set<Edge> appEdgesOut, Set<Edge> allEdges) {
        SootMethod method = edgeInto.tgt();
        Iterator<Edge> ciEdges = sparkCG.edgesOutOf(method);

        //iterate over all the ci edges from soot, and check to see
        //if they are valid given the context
        while (ciEdges.hasNext()) {

            Edge curEdge = ciEdges.next();
            //System.out.printf("inspecting edge: %s %s %s\n", curEdge, curEdge.hashCode(), curEdge.srcStmt());
            SootMethod target = curEdge.tgt();
            //get the internal edge from the CS analysis
            CgEdge cgEdge = GeoPTA.v().getInternalEdgeFromSootEdge(curEdge);
            if (cgEdge == null) {
                //hmm, edge is not in the cs call graph at all, process it just in case...
                processEdge(rCFGNode, curEdge, context, null, appEdgesOut, allEdges, 2);
                continue;
            }

            //if always obsoleted, then continue
            if (cgEdge.is_obsoleted)
                continue;

            InstanceInvokeExpr iie = SootUtils.getInstanceInvokeExpr(curEdge.srcStmt());
            if (iie != null) {    
                try {
                    for (Map.Entry<AllocNode, SootMethod> entry: 
                        GeoPTA.v().resolveVirtualInvokeMap(iie, context).entrySet()) {
                        // Only the virtual calls do the following test
                        if ( entry.getValue() == target ) {
                            processEdge(rCFGNode, curEdge, context, entry.getKey(), appEdgesOut, allEdges, 4);
                            break;
                        }   
                    }
                } catch (CannotFindMethodException e) {
                    logger.error("Cannot resolve method during RCFG creation: {}", iie);
                    System.exit(1);
                }   
            } else {
                processEdge(rCFGNode, curEdge, context, null, appEdgesOut, allEdges, 5);
            }
        }
    }

    /**
     * Return string representation of RCFG.
     */
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (RCFGNode node : rCFG) {
            str.append(node + "\n");
        }

        return str.toString();
    }
}
