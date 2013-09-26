package droidsafe.transforms;

import java.util.Iterator;
import java.util.Map;

import droidsafe.android.app.Project;
import droidsafe.analyses.strings.JSAStrings;

import soot.Body;
import soot.BodyTransformer;
import soot.Local;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Value;
import soot.VoidType;
import soot.jimple.AssignStmt;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.StringConstant;
import soot.toolkits.graph.PseudoTopologicalOrderer;
import soot.util.Chain;

/**
 * Tranformer called on all application classes that will find all invoke expressions, and
 * if an arg is a string constant, will create a new local for the constant, 
 * and replace the constant in the argument with the local.  Needed for points to analysis.
 * 
 * @author dpetters
 *
 */
public class JSAResultInjection extends BodyTransformer {
	
	private static int LOCALID = 0;
	public static final String LOCAL_PREFIX = "DS_STRING_ARG";

	/**
	 * Call this pass on all application classes in the project.
	 */
	public static void run() {
		JSAResultInjection transformer = new JSAResultInjection();
		for (SootClass clz : Scene.v().getClasses()) {
			if (Project.v().isSrcClass(clz.toString())) {
				for (SootMethod meth : clz.getMethods()) {
					if (meth.isConcrete())
						transformer.transform(meth.retrieveActiveBody());
				}
			}
		}
	}
	
	/**
	 * Tranform method called on the body that will find all invoke expressions, and
	 * if an arg is a string constant, will create a new local for the constant, 
	 * and replace the constant in the argument with the local.
	 */
	protected void internalTransform(Body b, String phaseName, Map options)  {
		StmtBody stmtBody = (StmtBody)b;

		// get body's unit as a chain
		Chain units = stmtBody.getUnits();

		// get a snapshot iterator of the unit since we are going to
		// mutate the chain when iterating over it.
		Iterator stmtIt = units.snapshotIterator();

		while (stmtIt.hasNext()) {

			Stmt stmt = (Stmt)stmtIt.next();

			if (!stmt.containsInvokeExpr()) {
				continue;
			}

			InvokeExpr expr = (InvokeExpr)stmt.getInvokeExpr();
						
			//iterate over the args and see if any arg is a string constant
			for (int i = 0; i < expr.getArgCount(); i++) {
				Value v = expr.getArg(i);
				if (JSAStrings.v().isHotspotValue(v)) {
					//add a local variable
					Local arg = Jimple.v().newLocal(LOCAL_PREFIX + LOCALID++, RefType.v("java.lang.String"));
					stmtBody.getLocals().add(arg);
					
					//add an assignment of the local to the string constant
					//right before the call
					AssignStmt assignStmt = Jimple.v().newAssignStmt(arg, StringConstant.v(JSAStrings.v().getRegex(v)));
					units.insertBefore(assignStmt, stmt);
					
					//replace the string constant with the local in the call
					expr.setArg(i, arg);
				}
			}			
		}
	}
}

