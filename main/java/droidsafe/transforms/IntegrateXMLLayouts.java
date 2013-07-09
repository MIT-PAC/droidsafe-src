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
import soot.Type;
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
import soot.SootMethodRef; 

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
import soot.jimple.Expr;
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
		
		/** debug */
		private SootClass  activityClass;
		private SootClass  javaObjClass;
		
		/** list of possible findViewById methods */
		private List<SootMethod>  findViewByIdList    = new LinkedList<SootMethod>();
		
		/** list of possible setContentViewList */
		private List<SootMethod>  setContentViewList = new LinkedList<SootMethod>();
		
		/** all classes that have findViewById */
		private final String[] findViewByIdClasses = new String[] {
		       "android.app.Activity", "android.app.Dialog", 
		       "android.view.Window" , "android.view.View"
    		};
		
		private final String[] setContentViewClasses = new String[] {
		        "android.app.Activity", "android.app.Dialog", "android.view.Window" 
		    };
		
		/**
		 * Constructor
		 */
		public IntegrateXMLLayouts() {
			activityClass =  Scene.v().getSootClass("android.app.Activity");
			javaObjClass  =  Scene.v().getSootClass("java.lang.Object");
			
			//build findViewByIDList
			for (String className: findViewByIdClasses){
			    String methodName = String.format("<%s: android.view.View findViewById(int)>",
			                               className);
			    SootMethod method = Scene.v().getMethod(methodName); 
			    logger.debug("findViewById method {} ", method);
			    findViewByIdList.add(method);
			}
			
			// setcontentview list
			for (String className: setContentViewClasses){
			    String methodName = String.format("<%s: void setContentView(int)>",
			                               className);
			    SootMethod method = Scene.v().getMethod(methodName); 
			    setContentViewList.add(method);
			    
			    logger.debug("setContentView method {} ", method);
			}
		}
		
		/**
		 * Call this pass on all application classes in the project.
		 */
		public static void run() {
			
			if (GeoPTA.v() == null) {
				logger.error("IntegrateXMLLayouts must be called after PTA!");
				droidsafe.main.Main.exit(1);
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


        /**
         * relaceSetContentView:
         *  replacing setContentView with calls to method that do allocation of UI objects
         */
		void replaceSetContentView(StmtBody stmtBody, Stmt stmt) {
            // get body's unit as a chain
			Chain<Unit> units = stmtBody.getUnits();

			//List<ValueBox> boxList = stmt.getUseAndDefBoxes();
			List<ValueBox> boxList = stmt.getUseBoxes();

			//stmt will have format below
			//virtualinvoke r0.<org.tomdroid.ui.ShortcutActivity: void setContentView(int)>(2130903050);
			//box0 JimpleLocalBox(r0), box1 ImmediateBox(2130903050), box2 InvokeExprBox
			logger.debug("Box Count {} ", boxList.size());
			logger.debug("box0 {} box1 {}, box2 {} ", boxList.get(0), boxList.get(1), boxList.get(2));

			Integer intId;
			
			ValueBox objectBox = boxList.get(0);
			ValueBox idBox = boxList.get(1);
			
			try {
				intId = new Integer(idBox.getValue().toString());
			}
			catch (Exception ex) {
				logger.warn("stmt {} ", stmt);
				logger.warn("Couldn't replace findViewById() NOT an integer constant");
				return;
			}

			SootMethod method = ResourcesSoot.v().lookupInitLayout_ID(intId);

			if (method == null) {
				logger.warn("NOT replacing {}, id={} ", stmt, String.format("0x%x", intId));
				return;
			}

			Expr invokeExpr = Jimple.v().newStaticInvokeExpr(method.makeRef(), objectBox.getValue()); 
			Stmt invokeStmt = Jimple.v().newInvokeStmt(invokeExpr);

			try {
			    units.swapWith(stmt, invokeStmt);
			    logger.info("replacing {} ", stmt);
			    logger.info("with {} => OK", invokeStmt);
			}
			catch (Exception ex) {
			    logger.warn("replacing {} ", stmt);
			    logger.warn("with {} => NOT OK", invokeStmt);
			}
			
        }

        /**
         * replaceFindViewById:
         *    replace findViewById invocation statement with replacement code that call getView_<id>
         */
		void replaceFindViewById(StmtBody stmtBody, Stmt stmt) {

			// get body's unit as a chain
			Chain<Unit> units = stmtBody.getUnits();

			List<ValueBox> useBoxList = stmt.getUseBoxes();
			List<ValueBox> defBoxList = stmt.getDefBoxes();

			ValueBox callerObjectBox = useBoxList.get(0);
			ValueBox idValueBox      = useBoxList.get(1);
			ValueBox assignToBox = null;
			
			if (defBoxList != null && defBoxList.size() > 0)
			    assignToBox = defBoxList.get(0);
			
			logger.debug("UseBoxes: {} ", stmt.getUseBoxes());
			logger.debug("DefBoxes: {} ", stmt.getDefBoxes());

			if (callerObjectBox == null || idValueBox == null) {
				logger.warn("Couldnot get boxes for replacement "); 
				return;
			}

			Integer intId;
			
			try {
				intId = new Integer(idValueBox.getValue().toString());
			}
			catch (Exception ex) {
				logger.warn("stmt {} ", stmt);
				logger.warn("Couldn't replace findViewById() NOT an integer constant");
				return;
			}

			SootMethod getViewMethod = ResourcesSoot.v().lookupGetUi_ID(intId);

			if (getViewMethod == null) {
				logger.warn("NOT replacing {}, id={} ", stmt, String.format("0x%x", intId));
				return;
			}

			Expr invokeExpr = Jimple.v().newStaticInvokeExpr(getViewMethod.makeRef(), callerObjectBox.getValue()); 
			
			Stmt lookupStmt; 
			if (assignToBox != null)
			    lookupStmt = Jimple.v().newAssignStmt(assignToBox.getValue(), invokeExpr);
			else
			    lookupStmt = Jimple.v().newInvokeStmt(invokeExpr);

			try {
			    units.swapWith(stmt, lookupStmt);
			    logger.info("replacing {} ", stmt);
			    logger.info("with {}, OK ", lookupStmt);
			}
			catch (Exception ex) {
			    logger.warn("replacing {} ", stmt);
			    logger.warn("with {} => NOT OK", lookupStmt);
			}
		}

		/**
		* This method is called by the v.transform() as part of soot framework
		*/
		protected void internalTransform(Body b, String phaseName, Map options)  {
			StmtBody stmtBody = (StmtBody)b;
			
			// get body's unit as a chain
			Chain<Unit> units = stmtBody.getUnits();

			// get a snapshot iterator of the unit since we are going to
			// mutate the chain when iterating over it.
			Iterator<Unit> stmtIt = units.snapshotIterator();

			while (stmtIt.hasNext()) {
				Stmt stmt = (Stmt)stmtIt.next();

				if (!stmt.containsInvokeExpr()) {
					continue;
				}
				
				
				//get the receiver, receivers are only present for instance invokes 
				InstanceInvokeExpr iie = SootUtils.getInstanceInvokeExpr(stmt);
				if (iie != null) {
					for (AllocNode node : GeoPTA.v().getPTSetContextIns(iie.getBase())) {

						Type nodeType = node.getType();

						if (!(nodeType instanceof RefType)) {
							logger.info("Skipping type {} ", nodeType);
							continue;
						}
						
						//if replaced, done.  Not sure why YARR showed up 2 times
						if (!units.contains(stmt))
						    break;

						SootClass allocClz = ((RefType)node.getType()).getSootClass();
						SootMethod resolved = null; 
						try {
							resolved = SootUtils.
								resolveConcreteDispatch(allocClz, iie.getMethod());
						
						} catch (CannotFindMethodException e) {
							continue;
						}
						
						// replacing findViewById
						for (SootMethod method: findViewByIdList) {
						    if (method.equals(resolved))  {
						        logger.info(String.format("Found findViewById(): %s - %s\n", 
						                    stmt, b.getMethod()));
						        replaceFindViewById(stmtBody, stmt);
						    }
						}
						
						// replacing 
						for (SootMethod method: setContentViewList) {
						    if (method.equals(resolved)) {
						        logger.info(String.format("Found setContentView(): %s - %s\n", 
						                    stmt, b.getMethod()));
						        replaceSetContentView(stmtBody, stmt);
						        break;
						    }
						}
					}
				}
				
			}
		}

		/************************************************************
		* Helper methods
		*************************************************************/
		protected boolean isActivitySubclass(SootClass sootClass) {
			SootClass parentClass = sootClass.getSuperclass();

			while (parentClass != javaObjClass) {
				if (parentClass == activityClass)
					return true;

				parentClass = parentClass.getSuperclass();
			}
			return false;
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


}
