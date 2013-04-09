package droidsafe.transforms;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.BodyTransformer;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.spark.pag.AllocNode;
import soot.util.Chain;
import droidsafe.analyses.GeoPTA;
import droidsafe.android.app.Project;
import droidsafe.transforms.APICallSpecialization.CallSpecialization;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.SootUtils;

public class IntegrateXMLLayouts extends BodyTransformer {
		private final static Logger logger = LoggerFactory.getLogger(IntegrateXMLLayouts.class);
		
		private static IntegrateXMLLayouts v;
		
		private SootMethod findViewById;
		
		public IntegrateXMLLayouts() {
			findViewById = Scene.v().getMethod("<android.app.Activity: android.view.View findViewById(int)>");
		}
		
		/**
		 * Call this pass on all application classes in the project.
		 */
		public static void run() {
			
			if (GeoPTA.v() == null) {
				logger.error("IntegrateXMLLayouts must be called after PTA!");
				System.exit(1);
			}

			v = new IntegrateXMLLayouts();

			for (SootClass clz : Scene.v().getClasses()) {
				if (Project.v().isSrcClass(clz.toString()) || Project.v().isLibClass(clz.toString())) {
					for (SootMethod meth : clz.getMethods()) {
						if (meth.isConcrete())
							v.transform(meth.retrieveActiveBody());
					}
				}
			}
		}

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
				
				
				//get the receiver, receivers are only present for instance invokes 
				InstanceInvokeExpr iie = SootUtils.getInstanceInvokeExpr(stmt);
				if (iie != null) {
					for (AllocNode node : GeoPTA.v().getPTSetContextIns(iie.getBase())) {
						SootClass allocClz = ((RefType)node.getType()).getSootClass();
						
						SootMethod resolved = null; 
						try {
							resolved = SootUtils.
								resolveConcreteDispatch(allocClz, iie.getMethod());
						
						} catch (CannotFindMethodException e) {
							continue;
						}
						
						if (findViewById.equals(resolved)) 
							System.out.printf("Found findViewById(): %s\n", stmt);
						
						//replacement ...
					}
				}
				
			}
		}
}
