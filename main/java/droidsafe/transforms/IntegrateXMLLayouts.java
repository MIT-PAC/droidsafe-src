package droidsafe.transforms;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.lang.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.BodyTransformer;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Local;
import soot.UnitBox;
import soot.ValueBox;
import soot.SootField;

import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.ArrayRef;
import soot.jimple.InvokeExpr;
import soot.jimple.FieldRef;
import soot.jimple.spark.pag.AllocNode;

import soot.jimple.internal.JimpleLocalBox;
import soot.jimple.internal.ImmediateBox;

import soot.util.Chain;

import droidsafe.analyses.GeoPTA;
import droidsafe.android.app.Project;
import droidsafe.transforms.APICallSpecialization.CallSpecialization;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.SootUtils;
import droidsafe.android.app.resources.ResourcesSoot;

import com.google.common.collect.HashBiMap;

public class IntegrateXMLLayouts extends BodyTransformer {
		private final static Logger logger = LoggerFactory.getLogger(IntegrateXMLLayouts.class);
		
		private static IntegrateXMLLayouts v;
		
		private SootMethod findViewById;
		private SootMethod setContentView;
		
		public IntegrateXMLLayouts() {
			findViewById = Scene.v().getMethod("<android.app.Activity: android.view.View findViewById(int)>");
			// setContentView = Scene.v().getMethod("<android.app.Activity: void setContentView(int)>");
			dumpActivities();
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

		protected void dumpActivities() {
			String[] androidActivityNames = new String[] {
					"android.app.Activity", 
					"android.app.ActivityGroup", 
					"android.app.NativeActivity", 
					"android.app.AliasActivity", 
					"android.app.ExpandableListActivity",
					"android.app.TabActivity",
					"android.app.ListActivity",
					"android.app.LauncherActivity",
					"android.preference.PreferenceActivity",
					"android.accounts.AccountAuthenticatorActivity"
					 }; 

			HashMap<SootClass, SootClass> androidActivityMap = new HashMap<SootClass, SootClass>();

			for (int i = 0; i < androidActivityNames.length; i++) {
				String className = androidActivityNames[i];
				SootClass sc = Scene.v().getSootClass(className);
				androidActivityMap.put(sc, sc);
			}
				 
			for (SootClass clz : Scene.v().getClasses()) {
				try {
					if (androidActivityMap.get(clz) != null)
						continue;

					SootClass superClz = clz.getSuperclass();

					if (androidActivityMap.get(superClz) != null) {
						logger.warn("Found {} a child class of {} ", 
									clz.toString(), superClz.toString());
					}
				} catch (Exception ex) {
					continue;
				}
			}

		}

		protected void dumpStmtBody(StmtBody stmtBody) {
            //System.out.printf("Dumping body %s \n", stmtBody);
			System.out.printf("Dumping statement body ");

            // get body's unit as a chain
			Chain units = stmtBody.getUnits();

			Chain locals = stmtBody.getLocals();
			Iterator localIt = locals.snapshotIterator();
			while (localIt.hasNext()) {
				Local local = (Local)localIt.next();
				System.out.printf("%s %s\n", local.getType(), local.getName());
			}

			Iterator stmtIt = units.snapshotIterator();

				
            while (stmtIt.hasNext()) {
				Stmt stmt = (Stmt)stmtIt.next();
                System.out.printf("%s \n", stmt);
            }
		}

		void dumpStatement(Stmt stmt) {


			System.out.println("Dumping statement ");
			System.out.println(stmt.toString());

			if (stmt.containsInvokeExpr()) {
				InvokeExpr invokeExpr = stmt.getInvokeExpr();
				System.out.printf("invokeExpr %s \n", invokeExpr.toString());

				ValueBox invokeExprBox = stmt.getInvokeExprBox();
				System.out.printf("invokeExprBox %s \n", invokeExprBox.toString());

			}

			if (stmt.containsFieldRef()) {
				FieldRef fieldRef = stmt.getFieldRef();
				System.out.printf("fieldRef %s \n", fieldRef.toString());

				ValueBox fieldRefBox = stmt.getFieldRefBox();
				System.out.printf("fieldRefBox %s \n", fieldRefBox.toString());
			}

			if (stmt.containsArrayRef()) {
				ArrayRef arrayRef = stmt.getArrayRef();
				System.out.printf("arrayRef %s \n", arrayRef.toString());

				ValueBox arrayRefBox = stmt.getArrayRefBox();
				System.out.printf("arrayRefBox %s \n", arrayRefBox.toString());

			}

			List<ValueBox> boxList = stmt.getUseBoxes();
			Iterator<ValueBox> it = boxList.iterator();

			ValueBox localBox = null;
			ValueBox immediateBox = null;

			while(it.hasNext()) {
				ValueBox curBox = it.next();
				/* using internal type is not ideal, but seems easiest */
				if (curBox instanceof JimpleLocalBox) {
					localBox = curBox; 
				}

				if (curBox instanceof ImmediateBox) {
					immediateBox = curBox;
					System.out.printf("immediateBox %s %s number = %x \n", 
							immediateBox.getValue().toString(),
							immediateBox.getValue().getType().toString(),
							immediateBox.getValue().getType().getNumber()
							);

				}
				System.out.printf("use box %s:%s:%s \n", 
						curBox.getValue().getType().toString(),
						curBox.toString(),
						curBox.getValue().toString());

			}

			if (localBox != null && immediateBox != null) {
				System.out.printf("New Soot Unit val = %s\n", immediateBox.getValue().toString());
				Integer intId = new Integer(immediateBox.getValue().toString());
				SootField sf = ResourcesSoot.v().getField(intId);
			}
		}

		/**
		* This method is called by the v.transform() as part of soot framework
		*/
		protected void internalTransform(Body b, String phaseName, Map options)  {
			StmtBody stmtBody = (StmtBody)b;

			// get body's unit as a chain
			Chain units = stmtBody.getUnits();

			// get a snapshot iterator of the unit since we are going to
			// mutate the chain when iterating over it.
			Iterator stmtIt = units.snapshotIterator();

            boolean hasViewById = false;

			LinkedList<Stmt> idStmtList = new LinkedList();

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
						
						if (findViewById.equals(resolved))  {
							idStmtList.add(stmt);
                            hasViewById = true;
							logger.warn("Found findViewById(): {}", stmt);
							logger.warn("Found findViewById(): method {}", resolved);
							logger.info(String.format("Found findViewById(): %s\n", stmt));
							//replacement ...
							dumpStatement(stmt);
						}
					}
				}
				
			}

            if (hasViewById) {
                dumpStmtBody(stmtBody);
            }
		}
}
