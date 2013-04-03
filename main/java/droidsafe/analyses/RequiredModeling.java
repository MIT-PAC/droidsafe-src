package droidsafe.analyses;

import java.io.File;
import java.io.FileWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.analyses.rcfg.OutputEvent;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.rcfg.RCFGNode;
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
		
	public static void run1() {
		Set<String> toModel = new TreeSet<String>();

		for (RCFGNode node : RCFG.v().getNodes()) {
			for (OutputEvent oe : node.getOutputEvents()) {
				if (!API.v().isAPIModeledMethod(oe.getTarget()))
					toModel.add(oe.getTarget().getSignature());
			}
		}
		try {
			FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + "api-required-modeling-pta.txt");
			for (String m : toModel) {
				fw.write(m + "\n");
			}
			fw.close();
		} catch (Exception e) {
			logger.error("Cannot write required modeling file");
			System.exit(1);
		}

	}
	
	public static void run() {
		Set<String> toModel = new TreeSet<String>();
		
		for (SootMethod method : GeoPTA.v().getAllReachableMethods()) {
			//loop through all reachable methods, and find system methods that are not modeled
			//or system methods that do not exist (but are called)
			if (API.v().isSystemClass(method.getDeclaringClass()) && !API.v().isAPIModeledMethod(method))
				toModel.add(method.getSignature());
		}
		
		try {
			FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + "api-required-modeling-pta.txt");
			for (String m : toModel) {
				fw.write(m + "\n");
			}
			fw.close();
		} catch (Exception e) {
			logger.error("Cannot write required modeling file");
			System.exit(1);
		}
	}
}
