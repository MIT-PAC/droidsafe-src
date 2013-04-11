package droidsafe.analyses;

import java.io.File;
import java.io.FileWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
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
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.SootUtils;
import droidsafe.utils.Utils;
import soot.Body;
import soot.MethodOrMethodContext;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.ReachableMethods;
import soot.util.Chain;
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
			fw.write("\nErrors in PTA:\n");
			checkAllocations(fw);
			
			fw.close();
		} catch (Exception e) {
			logger.error("Cannot write required modeling file");
			System.exit(1);
		}
		

	}
	
	public static void checkAllocations(FileWriter fw) throws Exception {
		//loop over all code and find calls for with any tracked as received or arg
		for (SootClass clazz : Scene.v().getApplicationClasses()) {
			if (clazz.isInterface() || clazz.getName().equals(Harness.HARNESS_CLASS_NAME) ||
					clazz.getName().equals("edu.mit.csail.droidsafe.DroidSafeCalls"))
				continue;

			//don't add entry points into the system classes...
			if (API.v().isSystemClass(clazz))
				continue;

			for (SootMethod meth : clazz.getMethods()) {
				if (meth.isConcrete()) {
					checkInvokes(meth, meth.retrieveActiveBody(), fw);
				}
			}
		}
	}
	
	private static void checkInvokes(SootMethod m, Body b, FileWriter fw) throws Exception {
		StmtBody stmtBody = (StmtBody)b;

		// get body's unit as a chain
		Chain units = stmtBody.getUnits();

		Iterator stmtIt = units.snapshotIterator();

		while (stmtIt.hasNext()) {
			Stmt stmt = (Stmt)stmtIt.next();
			
			if (!stmt.containsInvokeExpr()) {
				continue;
			}

			InvokeExpr expr = (InvokeExpr)stmt.getInvokeExpr();
			
			
			//get the receiver, receivers are only present for instance invokes 
			InstanceInvokeExpr iie = SootUtils.getInstanceInvokeExpr(stmt);
			if (iie != null) {
				SootMethod resolved = null;
				for (AllocNode node : GeoPTA.v().getPTSetContextIns(iie.getBase())) {
					if ( node.getType() instanceof RefType ) {
						SootClass sc = ((RefType)node.getType()).getSootClass();
						try {
							resolved = SootUtils.resolveConcreteDispatch(sc, iie.getMethod());
						} catch (CannotFindMethodException e) {
							resolved = null;
						}
					}
					if (resolved != null)
						break;
				}
				if (resolved == null) 
					fw.write(String.format("No valid allocations for receiver of %s of type %s in %s (%s).\n\n",
							iie.getMethod(), iie.getBase().getType(), m, SootUtils.getSourceLocation(stmt, m.getDeclaringClass())));
			}
		}
	}
}
