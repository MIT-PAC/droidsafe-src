package droidsafe.analyses;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import soot.MethodOrMethodContext;
import soot.Scene;
import soot.SootMethod;
import soot.jimple.paddle.AbsCallGraph;
import soot.jimple.paddle.AbsReachableMethods;
import soot.jimple.paddle.queue.Rctxt_method;
import soot.jimple.spark.geom.geomPA.GeomPointsTo;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.ContextSensitiveCallGraph;
import soot.jimple.toolkits.callgraph.ContextSensitiveEdge;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.callgraph.ReachableMethods;
import soot.util.queue.QueueReader;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.app.EntryPoints;
import droidsafe.android.system.API;
import droidsafe.utils.Utils;

public class CallGraphFromEntryPoints {
	private final static Logger logger = LoggerFactory.getLogger(CallGraphFromEntryPoints.class);

	public static void run() {
		for (SootMethod entryPoint : EntryPoints.v().getAppEntryPoints()) {
			findReachableMethodsFrom(entryPoint);
			//playing(entryPoint);
			//playingWithContext(entryPoint);
			
		}
		//playingWithPaddle(Scene.v().getMethod("<irdc.ex07_11.recorder: void onStop()>"));
		//playingWithGeom(Scene.v().getMethod("<irdc.ex07_11.recorder: void onStop()>"));
	}
	
	private static void playingWithGeom(SootMethod m) {
		
		
	}
	
	private static void playingWithPaddle(SootMethod m) {
		/*AbsReachableMethods reachable = soot.jimple.paddle.Results.v().reachableMethods();
		Rctxt_method methods = reachable.contextMethods();
		Iterator iterator = methods.iterator();
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			System.out.printf("%s %s\n", obj.getClass(), obj);	
		}*/
		
		AbsCallGraph acg = soot.jimple.paddle.Results.v().callGraph();
		Iterator it = acg.edgesOutOf(m).iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			System.out.printf("%s %s\n", obj.getClass(), obj);
		}
		
		
			
		
	}
	
	private static void playing(SootMethod m) {
		CallGraph cg = Scene.v().getCallGraph();
		QueueReader<Edge> edges = cg.listener();
		while (edges.hasNext()) {
			Edge edge = edges.next();
			System.out.printf("Edge from %s to %s.\n", edge.src(), edge.tgt());
			System.out.printf("\tEdge context from %s to %s\n", edge.srcCtxt(), edge.tgtCtxt());
			System.out.printf("\tOther edge from %s to %s\n\n", edge.getSrc(), edge.getTgt());
		}
	}
	
	
	private static void playingWithContext(SootMethod m) {
		ContextSensitiveCallGraph cscg = Scene.v().getContextSensitiveCallGraph();
		Iterator edges = cscg.allEdges();
		Set<ContextSensitiveEdge> seen = new LinkedHashSet<ContextSensitiveEdge>();
		while (edges.hasNext()) {
			ContextSensitiveEdge edge = (ContextSensitiveEdge)edges.next();
			if (seen.contains(edge))
				continue;
			
			if (EntryPoints.v().isEntryPoint(edge.src())) {
				//System.out.printf("Edge\n  %s (%s)\n  %s (%s)\n", edge.src(), edge.srcCtxt(), edge.tgt(), edge.tgtCtxt());
				System.out.printf("Edge\n  %s\n  %s\n", edge.src(), edge.tgt());
			}
			
			seen.add(edge);
		}
	}
	
	private static void findReachableMethodsFrom(SootMethod m) {
		
		Collection<MethodOrMethodContext> list = new LinkedHashSet<MethodOrMethodContext>();
		list.add(m);
		ReachableMethods reachable = new ReachableMethods(Scene.v().getCallGraph(), (Collection<MethodOrMethodContext>)list);
		reachable.update();
		
		QueueReader<MethodOrMethodContext> reachables = reachable.listener();
		
		System.out.printf("%s\n", m);
		
		while (reachables.hasNext()) {
			MethodOrMethodContext meth = reachables.next();
			if (meth instanceof SootMethod) {
				SootMethod sm = (SootMethod)meth;
				if (API.v().isInterestingMethod(sm.getSignature()))
					System.out.printf("  %s\n",meth);
			} else {
				Utils.ERROR_AND_EXIT(logger, "Unknown edge in callgraph {}", meth);
			}
		}
	}
}
