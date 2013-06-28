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
		}
	}

	
	
	
	public static void findReachableMethodsFrom(SootMethod m) {
		
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
				if (API.v().isInterestingMethod(sm))
					System.out.printf("  %s\n",meth);
			} else {
				logger.error("Unknown edge in callgraph {}", meth);
				droidsafe.main.Main.exit(1);
			}
		}
	}
}
