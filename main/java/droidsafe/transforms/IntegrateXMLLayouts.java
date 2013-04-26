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
import soot.Unit;
import soot.ValueBox;
import soot.SootField;
import soot.Value;
import soot.NullType;
import soot.jimple.NullConstant;

import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.ArrayRef;
import soot.jimple.InvokeExpr;
import soot.jimple.FieldRef;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.Jimple;
import soot.jimple.NewExpr;
import soot.jimple.StringConstant;

import soot.jimple.internal.JimpleLocalBox;
import soot.jimple.internal.ImmediateBox;
import soot.jimple.internal.VariableBox;

import soot.util.Chain;
import soot.util.HashChain;
import soot.PatchingChain;

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
			//dumpActivities();
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

		// debug function
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

		// debug function
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

		void replaceFindViewById(StmtBody stmtBody, Stmt stmt) {

			// get body's unit as a chain
			Chain units = stmtBody.getUnits();

			List<ValueBox> boxList = stmt.getUseAndDefBoxes();
			Iterator<ValueBox> it = boxList.iterator();

			ValueBox localBox = null;
			ValueBox immediateBox = null;
			ValueBox variableBox = null;

			while(it.hasNext()) {
				ValueBox curBox = it.next();
				/* using internal type is not ideal, but seems easiest */
				if (curBox instanceof JimpleLocalBox) {
					localBox = curBox; 
					logger.debug("localBox {} {}",
							curBox.getValue().toString(),
							curBox.getValue().getType().toString()
							);

				}

				if (curBox instanceof ImmediateBox) {
					immediateBox = curBox;
					logger.debug("immediateBox {} {}",
							curBox.getValue().toString(),
							curBox.getValue().toString(),
							curBox.getValue().getType().toString()
							);
				}

				if (curBox instanceof VariableBox) {
					variableBox = curBox;
					logger.debug("variableBox {} {}",
							curBox.getValue().toString(),
							curBox.getValue().getType().toString());
				}

				logger.debug("variableBox {}:{}:{}",
						curBox.getValue().getType().toString(),
						curBox.toString(),
						curBox.getValue().toString());

			}

			if (localBox == null || immediateBox == null || variableBox == null) {
				logger.warn("Couldnot get boxes for replacement "); 
				return;
			}

			// if the object is not in ResourcesSoot, added code to create one,
			// else just use the lookup
			Integer intId = new Integer(immediateBox.getValue().toString());
			SootField sf = ResourcesSoot.v().getView(intId);
			if (sf == null) {
				String localIdName = "textView_" + intId;
				Local arg = Jimple.v().newLocal(localIdName, RefType.v("android.widget.TextView"));
				stmtBody.getLocals().add(arg);

				Chain<Unit> newUnits =  ResourcesSoot.v().createView(
						intId, localBox.getValue(), arg); 

				units.insertBefore(newUnits, stmt);

				sf = ResourcesSoot.v().getView(intId);
			}

			//creating rx = getView(intId) to replace rx=findViewById()
			FieldRef  fieldRef = Jimple.v().newStaticFieldRef(sf.makeRef());
			Stmt lookupStmt = Jimple.v().newAssignStmt(variableBox.getValue(), fieldRef); 

			units.swapWith(stmt, lookupStmt);

			logger.info("replacing {} ", stmt);
			logger.info("with {} ", lookupStmt);
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
							logger.info(String.format("Found findViewById(): %s\n", stmt));
							//replacement ...
							replaceFindViewById(stmtBody, stmt);
						}
					}
				}
				
			}
		}
}
