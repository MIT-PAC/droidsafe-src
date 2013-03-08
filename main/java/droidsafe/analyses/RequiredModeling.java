package droidsafe.analyses;

import java.io.File;
import java.io.FileWriter;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.app.Harness;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.main.Config;
import droidsafe.utils.Utils;
import soot.MethodOrMethodContext;
import soot.Scene;
import soot.SootMethod;
import soot.jimple.toolkits.callgraph.ReachableMethods;
import soot.util.queue.QueueReader;

/**
 * This class will create a file that include the method that require modeling. 
 * Right now, it only considers which classes require modeling for the PTA pass.
 * 
 * @author mgordon
 *
 */
public class RequiredModeling {
	private final static Logger logger = LoggerFactory.getLogger(AttributeModeling.class);
		
	public static void run() {
		//this should only run if we are including the api classes as app classes
		if (!Config.v().API_CLASSES_ARE_APP)
			return;
		
		try {
			FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + "analzye-api-required-modeling-pta.txt");

			for (SootMethod meth : findReachableMethodsFrom(Harness.v().getMain())) {
			//for (SootMethod meth : GeoPTA.v().getAllReachableMethods()) {
				//if not an api method, then we don't care to model it
				//should have the source
				if (!API.v().isSystemMethod(meth)) 
					continue; 

				String reason = "";

				if (meth.isAbstract())
					reason += "abstract";
				if (meth.isNative())
					reason += "native";
				if (meth.isPhantom())
					reason += "phantom";
				//if (!reason.equals(""))
					fw.write(meth + " (" + reason + ")\n");
			}
			fw.close();
		} catch (Exception e) {
			logger.error("Cannot write required modeling file");
			System.exit(1);
		}

	}

	public static Set<SootMethod> findReachableMethodsFrom(SootMethod m) {
		LinkedHashSet<SootMethod> methods = new LinkedHashSet<SootMethod>();
		Collection<MethodOrMethodContext> list = new LinkedHashSet<MethodOrMethodContext>();
		list.add(m);
		ReachableMethods reachable = new ReachableMethods(Scene.v().getCallGraph(), (Collection<MethodOrMethodContext>)list);
		reachable.update();
		
		QueueReader<MethodOrMethodContext> reachables = reachable.listener();
		
		
		while (reachables.hasNext()) {
			MethodOrMethodContext meth = reachables.next();
			if (meth instanceof SootMethod) {
				methods.add((SootMethod)meth);
			} else {
				Utils.ERROR_AND_EXIT(logger, "Unknown edge in callgraph {}", meth);
			}
		}
		
		return methods;
	}	
}
