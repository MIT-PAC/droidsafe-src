package droidsafe.transforms;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.BodyTransformer;
import soot.BooleanType;
import soot.Immediate;
import soot.RefType;
import soot.Type;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Local;
import soot.Unit;
import soot.Value;
import soot.ValueBox;
import soot.jimple.AssignStmt;
import soot.jimple.ConditionExpr;
import soot.jimple.FieldRef;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.StringConstant;
import soot.jimple.Jimple;
import soot.jimple.Expr;
import soot.util.Chain;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.app.Project;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.SootUtils;
import droidsafe.android.app.resources.ResourcesSoot;
import droidsafe.android.system.API;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class IntegrateXMLLayouts extends BodyTransformer {
    private final static Logger logger = LoggerFactory.getLogger(IntegrateXMLLayouts.class);

    private static IntegrateXMLLayouts v;

    /** list of possible findViewById methods */
    private List<SootMethod>  findViewByIdList    = new LinkedList<SootMethod>();

    /** list of possible setContentViewList */
    private List<SootMethod>  setContentViewList = new LinkedList<SootMethod>();

    private List<SootMethod>  getCharSequenceList = new LinkedList<SootMethod>();

    /** variable argument getString*/
    private List<SootMethod>  getVarArgCharSequenceList = new LinkedList<SootMethod>();

    private List<SootMethod>  findFragmentByIdList = new LinkedList<SootMethod>();      

    /** all classes that have findViewById */
    private final String[] findViewByIdClasses = new String[] {
                                                               "android.app.Activity", "android.app.Dialog", 
                                                               "android.view.Window" , "android.view.View"
    };

    private final String[] setContentViewClasses = new String[] {
                                                                 "android.app.Activity", "android.app.Dialog", "android.view.Window" 
    };

    private final String[] getStringAndGetTextClasses = new String[] {
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
            String methodName = String.format("<%s: void setContentView(int)>", className);
            try {
                SootMethod method = Scene.v().getMethod(methodName); 
                setContentViewList.add(method);             
                logger.debug("setContentView: {} ", method);
            } catch (Exception ex) {

            }

            methodName = String.format("<%s: void setContentView(int, android.view.ViewGroup.LayoutParams)>", className);
            try {
                SootMethod method = Scene.v().getMethod(methodName); 
                setContentViewList.add(method);             
                logger.debug("setContentView: {} ", method);
            } catch (Exception ex) {

            }
        }

        // getString / getText
        for (String className: getStringAndGetTextClasses){
            String methodName;
            methodName = String.format("<%s: java.lang.String getString(int)>", className);
            try {
                SootMethod method = Scene.v().getMethod(methodName); 
                getCharSequenceList.add(method);                
                logger.debug("getString: {} ", method);
            } catch (Exception ex) {
                logger.info("method {} not in soot scene ", methodName);
            }

            methodName = String.format("<%s: java.lang.CharSequence getText(int)>", className);
            try {
                SootMethod method = Scene.v().getMethod(methodName); 
                getCharSequenceList.add(method);                
                logger.debug("getString: {} ", method);
            } catch (Exception ex) {
                logger.info("method {} not in soot scene ", methodName);
            }

            // variable argument getString(int resId, Object[])
            methodName = String.format("<%s: java.lang.String getString(int,java.lang.Object[])>",
                className);
            try {
                SootMethod method = Scene.v().getMethod(methodName); 
                getVarArgCharSequenceList.add(method);              
                logger.debug("getVarArgCharSequenceList: {} ", method);
            } catch (Exception ex) {
                logger.info("method {} not in soot scene ", methodName);
            }
            methodName = String.format("<%s: java.lang.String getText(int,java.lang.Object[])>",
                className);
            try {
                SootMethod method = Scene.v().getMethod(methodName); 
                getVarArgCharSequenceList.add(method);              
                logger.debug("getVarArgCharSequenceList: {} ", method);
            } catch (Exception ex) {
                logger.info("method {} not in soot scene ", methodName);
            }
        }

        //deal with findFragmentById's Classes
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

        if (PTABridge.v() == null) {
            logger.error("IntegrateXMLLayouts must be called after PTA!");
            droidsafe.main.Main.exit(1);
        }

        v = new IntegrateXMLLayouts();

        // we probably will need to do 2 pass 
        for (SootClass clz : Scene.v().getClasses()) {
            //if (Project.v().isSrcClass(clz.toString()) || Project.v().isLibClass(clz.toString())) {
            debugOn = false;
            if (clz.getName().contains("edu.kestrel")) {
                logger.info("Class {} ", clz);
                debugOn = true;
            }

            for (SootMethod meth : clz.getMethods()) {
                if (API.v().isSystemMethod(meth))
                    continue;

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
        if (stmt.getInvokeExpr() instanceof InstanceInvokeExpr) {
        	InstanceInvokeExpr iInvokeExpr = (InstanceInvokeExpr) stmt.getInvokeExpr();

        	//stmt will have format below
        	//virtualinvoke r0.<org.tomdroid.ui.ShortcutActivity: void setContentView(int)>(2130903050);

        	Integer intId;

        	ValueBox objectBox = iInvokeExpr.getBaseBox();
        	ValueBox idBox = iInvokeExpr.getArgBox(0);

        	try {
        		intId = new Integer(idBox.getValue().toString());
        	}
        	catch (Exception ex) {
        		logger.info("Couldn't replace findViewById(): {} ", stmt);
        		return;
        	}

        	if (ResourcesSoot.isAndroidId(intId)) {
        		logger.info("android builtin IDs, ignored ");
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
    }


    /**
     * method to perform replacing of getString
     * @param stmtBody
     * @param stmt
     */
    void replaceGetCharSequence(StmtBody stmtBody, Stmt stmt) {

    	if (stmt.getInvokeExpr() instanceof InstanceInvokeExpr) {
    		InstanceInvokeExpr iInvokeExpr = (InstanceInvokeExpr) stmt.getInvokeExpr();

    		// get body's unit as a chain
    		Chain<Unit> units = stmtBody.getUnits();

    		List<ValueBox> defBoxList = stmt.getDefBoxes();

    		ValueBox callerObjectBox = iInvokeExpr.getBaseBox();
    		ValueBox idValueBox      = iInvokeExpr.getArgBox(0);
    		ValueBox assignToBox = null;

    		if (defBoxList != null && defBoxList.size() > 0)
    			assignToBox = defBoxList.get(0);

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
    			logger.info("Couldn't replace getString()  - {} NOT an integer constant", stringId);
    			return;
    		}

    		//SootMethod getStringMethod = ResourcesSoot.v().addGetCharSequence_ID(intId);
    		SootMethod getStringMethod = ResourcesSoot.v().retrieveGetCharSequence_ID(intId);

    		if (getStringMethod == null) {
    			logger.warn("Could not replace {}, id={} ", stmt, String.format("%x", intId));
    			logger.warn("Class {} ", stmtBody.getMethod().getDeclaringClass());
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
    	} else {
    		logger.warn("InvokeExpr in {} is not an InstanceInvokeExpr", stmt);
    	}
    }


    /**
     * extract variable arguments used in this statement, and resolve string constants if possible
     * @param stmtBody
     * @param stmt
     * @return
     */
    Object[] extractVariableArguments(StmtBody stmtBody, Stmt stmt) {
    	InvokeExpr invokeExpr = stmt.getInvokeExpr();
    	logger.debug("invokeExpr args {} ", invokeExpr.getArgs());

    	// get body's unit as a chain
    	Chain<Unit> units = stmtBody.getUnits();

    	List<ValueBox> defBoxList = stmt.getDefBoxes();
    	ValueBox idValueBox      = invokeExpr.getArgBox(0);
    	ValueBox objArrayBox     = invokeExpr.getArgBox(1);
    	ValueBox assignToBox = null;

    	Value objectArray = objArrayBox.getValue();

    	if (defBoxList != null && defBoxList.size() > 0)
    		assignToBox = defBoxList.get(0);

    	logger.debug("DefBoxes: {} ", stmt.getDefBoxes());

    	if (idValueBox == null) {
    		logger.debug("Couldnot get boxes for replacement "); 
    		return null;
    	}

    	//Expr invokeExpr = Jimple.v().newStaticInvokeExpr(getStringMethod.makeRef()); 
    	List<String> argList = new LinkedList<String>();

    	Stmt prevStatement = (Stmt) units.getPredOf(stmt);
    	HashBiMap<Value, Value> map = HashBiMap.create();

    	String objectPattern = String.format("%s[", objectArray.toString());
    	String objectName = objectArray.toString();

    	List<Value> valueList = new LinkedList<Value>();

    	while (prevStatement != null) {
    		logger.debug("prevStatement {} ", prevStatement);
    		if (!(prevStatement instanceof AssignStmt)) {
    			prevStatement = (Stmt)units.getPredOf(prevStatement);
    			continue;
    		}
    		AssignStmt assignStmt = (AssignStmt) prevStatement;
    		defBoxList = prevStatement.getDefBoxes();
    		Value leftSide  = assignStmt.getLeftOp();
    		Value rightSide = assignStmt.getRightOp();

    		String leftSideName = leftSide.toString();

    		if (leftSideName.startsWith(objectPattern) ||
    				map.inverse().containsKey(leftSide))
    		{
    			if (leftSideName.startsWith(objectPattern))
    				valueList.add(leftSide);
    			map.put(leftSide, rightSide);
    			logger.debug("added");
    		}

    		prevStatement = (Stmt)units.getPredOf(prevStatement);
    	}

    	if (valueList.size() == 0)
    		return null;

    	Collections.reverse(valueList);

    	Object[] objArray = new Object[valueList.size()];

    	for (int i = 0; i < valueList.size(); i++) {
    		Value obj = valueList.get(i);
    		Value assignedFrom = map.get(obj);
    		while (map.containsKey(assignedFrom))
    			assignedFrom = map.get(assignedFrom);

    		String varTypeName = assignedFrom.getType().toString();

    		logger.debug("Type {} => {} ", assignedFrom.getType(), assignedFrom.getType().toString());

    		if (!varTypeName.startsWith("java.lang.")) {
    			logger.info("not java.lang objects, give up ");
    			return null;
    		}

    		if (assignedFrom.getType().equals(RefType.v("java.lang.String"))) {
    			if (!(assignedFrom instanceof StringConstant)) {
    				logger.debug("String {} is not constant ", assignedFrom);
    				return null;
    			}
    			objArray[i] = assignedFrom.toString().replaceAll("\"", "");

    			logger.debug("String constant => {} ", objArray[i]);
    			continue;
    		}

    		logger.debug("varTypeName {} ", varTypeName);

    		Value paramValue = ((ValueBox)assignedFrom.getUseBoxes().get(0)).getValue();
    		logger.debug("useboxes {} ", assignedFrom.getUseBoxes());

    		if (paramValue instanceof Immediate) {
    			try {
    				Class clz = Class.forName(assignedFrom.getType().toString());
    				Class[] paramString = new Class[] { String.class };
    				logger.debug("Immediate => {}, type {} ", paramValue, paramValue.getType());
    				Method method = clz.getDeclaredMethod("valueOf", paramString);
    				Object data = method.invoke(null, paramValue.toString());
    				objArray[i] = data;
    			}
    			catch (Exception ex) {
    				logger.debug("Exception {} ", ex);
    				return null;
    			}
    		}
    	}

    	return objArray;
    }

    int localStringIndex = 0;

    /**
     * replace getSTring(int, ...)
     * @param stmtBody
     * @param stmt
     */
    void replaceGetStringVariableArgs(StmtBody stmtBody, Stmt stmt) {

    	if (stmt.getInvokeExpr() instanceof InstanceInvokeExpr) {
    		InstanceInvokeExpr iInvokeExpr = (InstanceInvokeExpr) stmt.getInvokeExpr();
    		// get body's unit as a chain
    		Chain<Unit> units = stmtBody.getUnits();

    		List<ValueBox> defBoxList = stmt.getDefBoxes();

    		ValueBox callerObjectBox = iInvokeExpr.getBaseBox();
    		ValueBox idValueBox      = iInvokeExpr.getArgBox(0);
    		ValueBox objArrayBox     = iInvokeExpr.getArgBox(1);
    		ValueBox assignToBox = null;

    		Value objectArray = objArrayBox.getValue();

    		if (defBoxList != null && defBoxList.size() > 0)
    			assignToBox = defBoxList.get(0);

    		if (assignToBox == null) {
    			logger.warn("Cannot replace {} ", stmt);
    			return;
    		}

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
    			logger.info("Couldn't replace getString()  - {} NOT an integer constant", stringId);
    			return;
    		}

    		SootMethod getStringMethod = ResourcesSoot.v().addGetCharSequence_ID(intId);

    		if (getStringMethod == null) {
    			logger.warn("Could not replace {}, id={} ", stmt, String.format("%x", intId));
    			logger.warn("Class {} ", stmtBody.getMethod().getDeclaringClass());
    			return;
    		}

    		InvokeExpr invokeExpr = stmt.getInvokeExpr();
    		logger.debug("invokeExpr args {} ", invokeExpr.getArgs());

    		Object[] paramList = extractVariableArguments(stmtBody, stmt);

    		if (paramList == null)
    			return;

    		String localStringName = String.format("_$%s%03d", "localString", localStringIndex++);

    		Local localString = Jimple.v().newLocal(localStringName,  RefType.v("java.lang.String"));
    		stmtBody.getLocals().add(localString);

    		Local localCond = Jimple.v().newLocal("_$localCond",  BooleanType.v());
    		stmtBody.getLocals().add(localCond);

    		FieldRef fieldRef =  Jimple.v().newStaticFieldRef(
    				ResourcesSoot.v().getConditionField().makeRef());
    		units.insertBefore(Jimple.v().newAssignStmt(localCond, fieldRef), stmt); 

    		ConditionExpr condExpr = Jimple.v().newEqExpr(localCond, IntConstant.v(0));

    		Stmt afterStmt = (Stmt)units.getSuccOf(stmt);

    		for (String stringValue: ResourcesSoot.v().getStringValues(intId)) {
    			String resolvedString = null;
    			try {
    				resolvedString = String.format(stringValue, paramList);
    			}
    			catch(Exception ex) {
    				return;
    			}

    			// condition statement
    			//Stmt condStmt =  Jimple.v().newIfStmt(condExpr, stmt);
    			Stmt ifStmt = Jimple.v().newIfStmt(condExpr, afterStmt);
    			units.insertBefore(ifStmt, stmt);

    			Stmt localAssign = Jimple.v().newAssignStmt(localString, StringConstant.v(resolvedString));
    			units.insertBefore(localAssign, stmt);
    		}

    		Stmt lookupStmt; 
    		lookupStmt = Jimple.v().newAssignStmt(assignToBox.getValue(), localString);

    		logger.info("replaced {} ", stmt);
    		try {
    			units.swapWith(stmt, lookupStmt);
    			logger.info("replacing with {}, OK ", lookupStmt);
    		}
    		catch (Exception ex) {
    			logger.warn("replacing with {} => NOT OK", lookupStmt);
    		}
    	} else {
    		logger.warn("InvokeExpr in {} is not an InstanceInvokeExpr", stmt);
    	}
    }

    /**
     * replaceFindViewById:
     *    replace findViewById invocation statement with replacement code that call getView_<id>
     */
    void replaceFindViewById(StmtBody stmtBody, Stmt stmt) {

        if (stmt.getInvokeExpr() instanceof InstanceInvokeExpr) {
            // get body's unit as a chain
            Chain<Unit> units = stmtBody.getUnits();

        	InstanceInvokeExpr iInvokeExpr = (InstanceInvokeExpr) stmt.getInvokeExpr();
        	List<ValueBox> defBoxList = stmt.getDefBoxes();

        	ValueBox callerObjectBox = iInvokeExpr.getBaseBox();
        	ValueBox idValueBox      = iInvokeExpr.getArgBox(0);
        	ValueBox assignToBox = null;

        	if (defBoxList != null && defBoxList.size() > 0)
        		assignToBox = defBoxList.get(0);

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
        		logger.info("Couldn't replace {} ", stmt);
        		return;
        	}

        	if (ResourcesSoot.isAndroidId(intId)) {
        		logger.info("android builtin IDs, ignored ");
        		return;
        	}

        	//SootMethod getViewMethod = ResourcesSoot.v().lookupGetView_ID(intId);
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
        } else {
        	logger.warn("InvokeExpr in {} is not an InstanceInvokeExpr", stmt);
        }
    }

    /**
     * replaceFindFragment
     *    replace findFragmentById invocation statement with replacement code that call getFragment_<id>
     */
    void replaceFindFragmentById(StmtBody stmtBody, Stmt stmt) {

    	if (stmt.getInvokeExpr() instanceof InstanceInvokeExpr) {
    		InstanceInvokeExpr iInvokeExpr = (InstanceInvokeExpr) stmt.getInvokeExpr();
    		// get body's unit as a chain
    		Chain<Unit> units = stmtBody.getUnits();

    		List<ValueBox> defBoxList = stmt.getDefBoxes();

    		ValueBox callerObjectBox = iInvokeExpr.getBaseBox();
    		ValueBox idValueBox      = iInvokeExpr.getArgBox(0);
    		ValueBox assignToBox = null;

    		if (defBoxList != null && defBoxList.size() > 0)
    			assignToBox = defBoxList.get(0);

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
    			logger.info("Couldn't replace {} ", stmt);
    			return;
    		}

    		if (ResourcesSoot.isAndroidId(intId)) {
    			logger.info("android builtin IDs, ignored ");
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
    	} else {
    		logger.warn("InvokeExpr in {} is not an InstanceInvokeExpr", stmt);
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
        
        String className = b.getMethod().getDeclaringClass().getName();
        
        if (!Project.v().isSrcClass(className)) {
        	logger.info("XML Transform: Skipping built-in classes ");
        	return;
        }

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

            SootMethod resolved = SootUtils.getMethodFromStmt(stmt);

            // replacing getString/getText
            for (SootMethod method: getCharSequenceList) {
                if (method.equals(resolved))  {
                    logger.info(String.format("Found getString/getText(): %s - %s\n", 
                        stmt, b.getMethod()));
                    replaceGetCharSequence(stmtBody, stmt);
                }
            }

            //
            for (SootMethod method: getVarArgCharSequenceList) {
                if (method.equals(resolved))  {
                    logger.info(String.format("Found getString(int, ...): %s - %s\n", 
                        stmt, b.getMethod()));
                    replaceGetStringVariableArgs(stmtBody, stmt);
                }
            }   

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
                    logger.info(String.format("Found findFragmentById(): %s - %s\n", 
                        stmt, b.getMethod()));
                    replaceFindFragmentById(stmtBody, stmt);
                    break;
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
