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

import soot.MethodOrMethodContext;
import soot.Scene;
import soot.SootMethod;
import soot.jimple.spark.geom.geomPA.CgEdge;
import soot.jimple.spark.geom.geomPA.GeomPointsTo;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;

import droidsafe.analyses.GeoPTA;
import droidsafe.android.app.EntryPoints;
import droidsafe.android.app.Harness;
import droidsafe.android.system.API;
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
	private static final Set<String> IGNORE_SYS_METHOD_WITH_NAME = new HashSet(Arrays.asList("<clinit>"));
	
	public static RCFG v() {
		return v;
	}
	
	public static void generate() {

		v = new RCFG();
		v.createRCFG();
		
		logger.info("\n" + v.toString());
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
		
		//int mainID = ptsProvider.getIDFromSootMethod(Harness.v().getMain());
		
		Iterator<Edge> edgesIt = sparkCG.edgesOutOf(Harness.v().getMain());
		while (edgesIt.hasNext()) {
			Edge edge = edgesIt.next();
			
			if (!EntryPoints.v().isEntryPoint(edge.tgt()))
				continue;
		
			startAtEntry(edge);
		}
		
		
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
		
		//find all calls to api and save context and call to rCFGNode
		Iterator<Edge> edgesOut = sparkCG.edgesOutOf(method);
		List<Edge> appEdgesOut = new LinkedList<Edge>();
		while (edgesOut.hasNext()) {
			Edge edge = edgesOut.next();
			if (API.v().isSystemMethod(edge.tgt())) {
				if (!IGNORE_SYS_METHOD_WITH_NAME.contains(edge.tgt().getName()) &&
						API.v().isInterestingMethod(edge.tgt())) {
					SourceLocationTag line = SootUtils.getSourceLocation(edge.srcStmt(), edge.src().getDeclaringClass());
					OutputEvent oe = new OutputEvent(edge, edgeInto, rCFGNode, line);
					rCFGNode.addOutputEvent(oe);
				}
				//do something to save the method and context (args and this)
			} else {
				//it is an app edge, so recurse into later
				appEdgesOut.add(edge);
			}
		}
		
		//recurse into all calls of app methods
		for (Edge edge : appEdgesOut) {
			if (!visited.contains(edge))
				visitNode(edge, rCFGNode, visited);
		}
		
		//maybe somehow cache methods at a certain depth if there are other edges into it
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		for (RCFGNode node : rCFG) {
			str.append(node + "\n");
		}
		
		return str.toString();
	}
}
