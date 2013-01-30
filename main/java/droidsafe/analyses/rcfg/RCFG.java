package droidsafe.analyses.rcfg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
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
 * This class will generate the reduced control flow graph starting from
 * the entry points calculated in droidsafe.android.app.EntryPoints.  It is 
 * built on top of the geometric points to analysis from soot.  
 * 
 * @author mgordon
 *
 */
public class RCFG {
	private final static Logger logger = LoggerFactory.getLogger(RCFG.class);
	
	private GeomPointsTo ptsProvider;
	private CallGraph sparkCG;
	
	private Set<RCFGNode> rCFG;
	
	private static RCFG v;
	
	/** list of names of methods to ignore when creating the RCFG output events */
	private static final Set<String> IGNORE_SYS_METHOD_WITH_NAME = new HashSet(Arrays.asList("<clinit>", "finalize"));
	
	private Set<SootMethod> visitedMethods;
	
	public static RCFG v() {
		return v;
	}
	
	public static void generate() {

		v = new RCFG();
		v.createRCFG();
		
		//logger.info("\n" + v.toString());
	}
	
	private RCFG() {
		visitedMethods = new LinkedHashSet<SootMethod>();
	}
	
	public Set<RCFGNode> getNodes() {
		return rCFG;
	}
	
	private void createRCFG() {
		ptsProvider = (GeomPointsTo)Scene.v().getPointsToAnalysis();
		sparkCG = Scene.v().getCallGraph();
		rCFG = new LinkedHashSet<RCFGNode>();
		
		//get the harness main and all the edges in the call graph
		//from it, and for each edge to an entry point, create and populate
		//the rCFG node
		
		Iterator<Edge> edgesIt = sparkCG.edgesOutOf(Harness.v().getMain());
		while (edgesIt.hasNext()) {
			Edge edge = edgesIt.next();
			
			/*if (!EntryPoints.v().isEntryPoint(edge.tgt()))
				continue;*/
		
			startAtEntry(edge);
		}
		
		checkForUnreachableMethods();
	}
	
	private void startAtEntry(Edge edge) {
		//create node, and add to it the RCFG
		RCFGNode node = new RCFGNode(edge);
		rCFG.add(node);
		//visit the call graph from this point
		visitNode(edge, node, new LinkedHashSet<Edge>());
	}
	
	private void visitNode(Edge edgeInto, RCFGNode rCFGNode, Set<Edge> visited) {
		SootMethod method = edgeInto.tgt();
		
		visited.add(edgeInto);
		visitedMethods.add(method);
		
		//find all calls to api and save context and call to rCFGNode
		Set<Edge> edgesOut = csEdgesOutOf(edgeInto);
		edgesOut.addAll(edgesFromAPIAllocs(edgeInto));
		List<Edge> appEdgesOut = new LinkedList<Edge>();
		
		for (Edge edge : edgesOut) {
			//logger.info("Looking at method call for: {}->{} ({}).", edge.src(), edge.tgt(), edge.srcStmt());
			if (API.v().isSystemMethod(edge.tgt())) {
				if (!IGNORE_SYS_METHOD_WITH_NAME.contains(edge.tgt().getName()) &&
						API.v().isInterestingMethod(edge.tgt())) {
					logger.info("Found output event: {}", edge);
					SourceLocationTag line = SootUtils.getSourceLocation(edge.srcStmt(), edge.src().getDeclaringClass());
					OutputEvent oe = new OutputEvent(edge, edgeInto, rCFGNode, line);
					rCFGNode.addOutputEvent(oe);
				}
				//do something to save the method and context (args and this)
			} else {
				
				//TODO: For now ignore library methods from the ignore list
				if (IGNORE_SYS_METHOD_WITH_NAME.contains(edge.tgt().getName()) &&
						Project.v().isLibClass(edge.tgt().getDeclaringClass().toString()))
					continue;
				//it is an app edge, so recurse into later
				appEdgesOut.add(edge);
			}
		}
		
		checkForCompleteness(edgesOut, method);
		
		//recurse into all calls of app methods
		for (Edge edge : appEdgesOut) {
			logger.info("Visiting edge: {}", edge);
			if (!visited.contains(edge))
				visitNode(edge, rCFGNode, visited);
		}
		
		//maybe cache methods at a certain depth if there are other edges into it
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
				logger.warn("Found invoke statement that was not in the callgraph edge list when build rCFG: {} in {} (might be dead code)", stmt, src);
			
		}
	}
	
	/**
	 * Loop over methods in the application we did not hit, because the analysis thinks they
	 * are unreachable, and inform the user of any calls in unreachable methods.
	 */
	private void checkForUnreachableMethods() {
		for (SootClass clz : Scene.v().getClasses()) {
			if (clz.isApplicationClass() && Project.v().isAppClass(clz.toString()) &&
					!Resources.v().isResourceClass(clz)) {
				for (SootMethod method : clz.getMethods()) {
					if (!visitedMethods.contains(method) && method.isDeclared()) {
						checkForCompleteness(new LinkedHashSet<Edge>(), method);
					}
				}
			}
		}
	}
	
	private List<Edge> edgesFromAPIAllocs(Edge edgeInto) {
		List<Edge> newEdges = new LinkedList<Edge>();
		SootMethod src = edgeInto.tgt();
		
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
			
			for (AllocNode alloc : GeoPTA.v().getPTSet(expr.getBase(), edgeInto)) {
				if (AddAllocsForAPICalls.v().isGeneratedExpr(alloc.getNewExpr())) {
					Type t = alloc.getType();
				
					 if ( t instanceof AnySubType ||
							 t instanceof ArrayType ) {
						logger.error("Weird type in call to object retrieved from API {}", stmt);
						System.exit(1);
					}
					SootClass allocType = ((RefType)t).getSootClass();
					SootClass staticRecClass = getStaticReceiverClassType(expr);
					
					SootClass narrowerClass = SootUtils.narrowerClass(allocType, staticRecClass);
					
					//if the two classes are unrelated, then trust the staticrecclass, it should
					//be more general
					if (narrowerClass == null) {
						narrowerClass = staticRecClass;
					}
					
					//get narrower methods since we don't know the exact type of this call...
					Set<SootMethod> allMethods = 
							SootUtils.getOverridingMethodsIncluding(narrowerClass, expr.getMethodRef().getSubSignature().getString());
					
					//get the method that would be called with the exact type of the receive
					
					SootMethod method = null;
					try {
						method = SootUtils.
								resolveConcreteDispatch( narrowerClass, expr.getMethod());
					} catch (CannotFindMethodException e) {
						logger.info("Cannot find concrete dispatch for {}", e);
						continue;
					}
					
					allMethods.add(method);
					
					for (SootMethod m : allMethods) {
						Edge newEdge = new Edge(src, stmt, m);
						newEdges.add(newEdge);
					}
				}
			}
		}

		return newEdges;
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
	
	private Set<Edge> csEdgesOutOf(Edge edgeInto) {
		SootMethod method = edgeInto.tgt();
		Set<Edge> csEdges = new LinkedHashSet<Edge>();
		Iterator<Edge> ciEdges = sparkCG.edgesOutOf(method);
		
		//iterate over all the ci edges from soot, and check to see
		//if they are valid given 
		while (ciEdges.hasNext()) {
			Edge curEdge = ciEdges.next();
			SootMethod target = curEdge.tgt();
			//get the internal edge from the CS analysis
			CgEdge cgEdge = ptsProvider.getInternalEdgeFromSootEdge(curEdge);
			if (cgEdge == null) {
				//hmm, edge is not in the cs call graph at all, add it just in case...
				csEdges.add(curEdge);
				continue;
			}
			
			//if always obsoleted, then continue
			if (cgEdge.is_obsoleted)
				continue;
			
			//otherwise check in the context if it is a valid edge
			if (cgEdge.base_var != null && !ptsProvider.thread_run_callsites.contains(curEdge.srcStmt())) { 
				//virtual call
				boolean keepEdge = false;
				
				for (AllocNode an : GeoPTA.v().getPTSet(cgEdge.base_var, edgeInto)) {
					Type t = an.getType();
					if ( t instanceof AnySubType ||
							 t instanceof ArrayType ) {
						keepEdge = true;
						break;
					}
					
					SootMethod resolved = null; 
					try {
						resolved = SootUtils.
							resolveConcreteDispatch( ((RefType)t).getSootClass(), target);
					} catch (CannotFindMethodException e) {
						SourceLocationTag tag = SootUtils.getSourceLocation(curEdge.srcStmt(), method.getDeclaringClass());
						logger.info("Cannot find a method for dispatch at line {}", tag, e);
						continue;
					}
					
					// Only the virtual calls do the following test
					if ( resolved == target ) {
						keepEdge = true;
						break;
					}					
				}
				if (keepEdge) {
					csEdges.add(curEdge);
				}
			} else {
				//not a virtual call, always add
				csEdges.add(curEdge);
			}
		}
	
		return csEdges;
	}

	
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		for (RCFGNode node : rCFG) {
			str.append(node + "\n");
		}
		
		return str.toString();
	}
}
