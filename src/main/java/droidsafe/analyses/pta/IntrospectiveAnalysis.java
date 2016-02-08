package droidsafe.analyses.pta;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.main.Main;
import droidsafe.utils.IDroidsafeProgressMonitor;
import droidsafe.utils.MutableInt;
import soot.Local;
import soot.SootMethod;
import soot.jimple.spark.pag.AllocNode;

public class IntrospectiveAnalysis {
	/** static logger class */
	private static final Logger logger = LoggerFactory.getLogger(IntrospectiveAnalysis.class);

	//map from allocation site to long
	private Map<Object, MutableInt> pointedByLocals;

	private static IntrospectiveAnalysis v;

	public static IntrospectiveAnalysis v() {
		if (v == null) {
			v = new IntrospectiveAnalysis();
		}
		return v;
	}

	public static void reset() {
		v = null;
	}

	private IntrospectiveAnalysis() {
		pointedByLocals = new HashMap<Object,MutableInt>();
	}

	public Map<Object,MutableInt> getPointedByLocals() {
		return pointedByLocals;
	}

	public void generateMetrics(IDroidsafeProgressMonitor monitor) {
		//run insensitive analysis
		System.out.println("Introspective analysis: starting insensitive pre-analysis...");
		Main.afterTransformFast(monitor, false);

		//compute for each allocation site the number of local vars that have it
		//in points to set
		SparkPTA pta = (SparkPTA)PTABridge.v();

		for (SootMethod method : pta.getReachableMethods()) {
			if (!method.isConcrete())
				continue;
			try {
				for (Local l : method.retrieveActiveBody().getLocals()) {
					if (pta.isPointer(l)) {					
						for (AllocNode alloc : (Set<AllocNode>)pta.getPTSetIns(l)) {
							if (!pointedByLocals.containsKey(alloc.getNewExpr())) {
								pointedByLocals.put(alloc.getNewExpr(), new MutableInt(0));
							}

							pointedByLocals.get(alloc.getNewExpr()).increment();
						}
					}
				}
			} catch (Exception e) {
				logger.debug("Error while generating metrics for introspective analysis: {}", e);
			}
		}
	}	
}
