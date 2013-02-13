package droidsafe.transforms;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.app.EntryPoints;
import droidsafe.android.app.Project;
import soot.G;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;

public class ScalarAppOptimizations {
	private final static Logger logger = LoggerFactory.getLogger(ScalarAppOptimizations.class);
	
	public static void run() {
		for (SootClass clz : Scene.v().getClasses()) {
			if (Project.v().isAppClass(clz.toString())) {
				for (SootMethod meth : clz.getMethods()) {
					if (!meth.isConcrete())
						continue;
					logger.debug("Calling Constant Prop and folding on {}", meth);
					G.v().soot_jimple_toolkits_scalar_ConstantPropagatorAndFolder().
						transform(meth.retrieveActiveBody());
					
					logger.debug("Calling CSE on {}", meth);
					G.v().soot_jimple_toolkits_scalar_CommonSubexpressionEliminator().
						transform(meth.retrieveActiveBody());
				}
			}
		}
	}
}
