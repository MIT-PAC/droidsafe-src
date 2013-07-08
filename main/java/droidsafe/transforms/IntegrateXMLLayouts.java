package droidsafe.transforms;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

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
import soot.Unit;
import soot.ValueBox;

import soot.jimple.InstanceInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.Jimple;
import soot.jimple.Expr;

import soot.util.Chain;

import droidsafe.analyses.GeoPTA;
import droidsafe.android.app.Project;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.SootUtils;
import droidsafe.android.app.resources.ResourcesSoot;

public class IntegrateXMLLayouts extends BodyTransformer {
		private final static Logger logger = LoggerFactory.getLogger(IntegrateXMLLayouts.class);
		
		private static IntegrateXMLLayouts v;
		
		/** list of possible findViewById methods */
		private List<SootMethod>  findViewByIdList    = new LinkedList<SootMethod>();
		
		/** list of possible setContentViewList */
		private List<SootMethod>  setContentViewList = new LinkedList<SootMethod>();
		
		private List<SootMethod>  getStringList = new LinkedList<SootMethod>();
		
		private List<SootMethod>  findFragmentByIdList = new LinkedList<SootMethod>();		
		
		/** all classes that have findViewById */
		private final String[] findViewByIdClasses = new String[] {
		       "android.app.Activity", "android.app.Dialog", 
		       "android.view.Window" , "android.view.View"
    		};
		
		private final String[] setContentViewClasses = new String[] {
		        "android.app.Activity", "android.app.Dialog", "android.view.Window" 
		    };
		
		private final String[] getStringClasses = new String[] {
				"android.content.res.Resources", "android.app.Fragment",
				"android.content.Context", "android.support.v4.app.Fragment"
			};
		
		private final String[] findFragmentByIdClasses = new String[] {
				"android.app.FragmentManager",
				"android.support.v4.app.FragmentManager"
		};
		
		static boolean debugOn = false;
		/**
		 * Constructor
		 */
		public IntegrateXMLLayouts() {
			
			//build findViewByIDList
			for (String className: findViewByIdClasses){
			    String methodName = String.format("<%s: android.view.View findViewById(int)>",
			                               className);
			    SootMethod method = Scene.v().getMethod(methodName); 
			    findViewByIdList.add(method);
			    logger.debug("findViewById: {} ", method);
			}
			
			// setcontentview list
			for (String className: setContentViewClasses){
			    String methodName = String.format("<%s: void setContentView(int)>",
			                               className);
			    SootMethod method = Scene.v().getMethod(methodName); 
			    setContentViewList.add(method);			    
			    logger.debug("setContentView: {} ", method);
			}
			
			// getString
			for (String className: getStringClasses){
			    String methodName = String.format("<%s: java.lang.String getString(int)>",
			                               className);
			    try {
			    	SootMethod method = Scene.v().getMethod(methodName); 
			    	getStringList.add(method);			    
			    	logger.debug("getString: {} ", method);
			    } catch (Exception ex) {
			    	logger.info("method {} not in soot scene ", methodName);
			    }
			}
			
			// 
			for (String className: findFragmentByIdClasses){
				String fragmentClass = className.replace("FragmentManager", "Fragment");
			    String methodName = String.format("<%s: %s findFragmentById(int)>",
			                               className, fragmentClass);
			    try {
			    	SootMethod method = Scene.v().getMethod(methodName); 
			    	findFragmentByIdList.add(method);			    
			    }
			    catch (Exception ex) {
			    	logger.info("method {} not in soot scene ", methodName);
			    }
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

			// we probably will need to do 2 pass 
			for (SootClass clz : Scene.v().getClasses()) {
				//if (Project.v().isSrcClass(clz.toString()) || Project.v().isLibClass(clz.toString())) {
				debugOn = false;
				if (clz.getName().contains("com.challenge")) {
					logger.info("Class {} ", clz);
					debugOn = true;
				}
				
				if (true) {
					for (SootMethod meth : clz.getMethods()) {
						if (debugOn) {
							logger.info("Checking method {} ", meth);
						}
						if (meth.isConcrete()) {
							if (debugOn) {
								logger.info("XML transform: {} ", meth);
								logger.info("{}", meth.retrieveActiveBody());
							}
							v.transform(meth.retrieveActiveBody());
						}
					}
				}
			}
			
			ResourcesSoot.v().writeFile(Project.v().getOutputDir());
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
				logger.warn("Couldn't replace findViewById(): {} ", stmt);
				return;
			}

			SootMethod method = ResourcesSoot.v().lookupInitLayout_ID(intId);

			if (method == null) {
				logger.warn("NOT replacing {}, id={} ", stmt, String.format("0x%x", intId));
				return;
			}

			Expr invokeExpr = Jimple.v().newStaticInvokeExpr(method.makeRef(), objectBox.getValue()); 
			Stmt invokeStmt = Jimple.v().newInvokeStmt(invokeExpr);

			logger.info("replacing {} ", stmt);
			try {
			    units.swapWith(stmt, invokeStmt);
			    logger.info("with {} => OK", invokeStmt);
			}
			catch (Exception ex) {
			    logger.warn("Replacing with {} => NOT OK", invokeStmt);
			}
        }
		
		
		/**
		 * method to perform replacing of getString
		 * @param stmtBody
		 * @param stmt
		 */
		void replaceGetString(StmtBody stmtBody, Stmt stmt) {

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
			String stringId = idValueBox.getValue().toString();
			
			try {
				intId = new Integer(stringId);
			}
			catch (Exception ex) {
				logger.warn("Couldn't replace getString()  - {} NOT an integer constant", stringId);
				return;
			}

			SootMethod getStringMethod = ResourcesSoot.v().addGetString_ID(intId);

			if (getStringMethod == null) {
				logger.warn("Could not replace {}, id={} ", stmt, String.format("%x", intId));
				return;
			}
			
			/*
			if (getStringMethod != null) {
				logger.warn("Skipped replacing getString() for now ");
				return;
			}
			*/

			Expr invokeExpr = Jimple.v().newStaticInvokeExpr(getStringMethod.makeRef()); 
			
			Stmt lookupStmt; 
			if (assignToBox != null)
			    lookupStmt = Jimple.v().newAssignStmt(assignToBox.getValue(), invokeExpr);
			else
			    lookupStmt = Jimple.v().newInvokeStmt(invokeExpr);

			logger.info("replaced {} ", stmt);
			try {
			    units.swapWith(stmt, lookupStmt);
			    logger.info("replacing with {}, OK ", lookupStmt);
			}
			catch (Exception ex) {
			    logger.warn("replacing with {} => NOT OK", lookupStmt);
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
				logger.warn("Couldn't replace {} ", stmt);
				return;
			}

			SootMethod getViewMethod = ResourcesSoot.v().lookupGetView_ID(intId);

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
			
			if (debugOn) {
				logger.info("Output body again ");
				logger.info("{} ", b);
			}
			
			while (stmtIt.hasNext()) {
				Stmt stmt = (Stmt)stmtIt.next();

				if (debugOn)
					logger.info("{}", stmt);
				
				if (!stmt.containsInvokeExpr()) {
					if (debugOn)
						logger.info("Skipped ");
					continue;
				}


				//get the receiver, receivers are only present for instance invokes 
				InstanceInvokeExpr iie = SootUtils.getInstanceInvokeExpr(stmt);
				if (iie == null) {
					if (stmt.toString().contains("findViewById()")) {
						logger.warn("findViewById: cannot get instanceInvokde ");
					}
					continue;
				}
				
				if (debugOn) {
					logger.info("iie.getBase(): {} ", iie.getBase());
					logger.info("getPointToSet: {} ", 
							GeoPTA.v().getPTSetContextIns(iie.getBase()));
				}
				
				for (AllocNode node : GeoPTA.v().getPTSetContextIns(iie.getBase())) {
					
					if (debugOn) {
						logger.info("AllocNode {} ", node);
					}

					Type nodeType = node.getType();

					if (!(nodeType instanceof RefType)) {
						logger.info("Skipping type {} ", nodeType);
						continue;
					}

					//if replaced, done.  Not sure why YARR showed up 2 times
					if (!units.contains(stmt)) {
						logger.info("statmen {} repated ", stmt);
						break;
					}

					SootClass allocClz = ((RefType)node.getType()).getSootClass();
					SootMethod resolved = null; 
					try {
						resolved = SootUtils.
								resolveConcreteDispatch(allocClz, iie.getMethod());

					} catch (CannotFindMethodException e) {
						if (iie.getMethod().toString().contains("findView")) {
							logger.warn("exception {} ", e);
						}
						continue;
					} catch (Exception ex) {
						logger.warn("Exception ex {} ", ex);
					}

					// replacing findViewById
					for (SootMethod method: getStringList) {
						if (method.equals(resolved))  {
							logger.info(String.format("Found getString(): %s - %s\n", 
									stmt, b.getMethod()));
							replaceGetString(stmtBody, stmt);
						}
					}
					
					//
					if (resolved.toString().contains("findView")) {
						logger.info("findView resolved {} ", resolved);
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
					
					for (SootMethod method: findFragmentByIdList) {
						if (method.equals(resolved)) {
							logger.warn(String.format("Found findFragmentById(): %s - %s\n", 
									stmt, b.getMethod()));
							break;
						}
					}
				}
			}
		}

		/************************************************************
		* Helper methods
		*************************************************************/
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
