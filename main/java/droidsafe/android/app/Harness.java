package droidsafe.android.app;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.ArrayType;
import soot.Body;
import soot.Local;
import soot.Modifier;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootFieldRef;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.VoidType;
import soot.jimple.AssignStmt;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.NewExpr;
import soot.jimple.NopStmt;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.util.Chain;

import com.google.common.collect.ImmutableMap;

import droidsafe.android.system.API;
import droidsafe.android.system.Components;
import droidsafe.utils.SootUtils;
import droidsafe.utils.Utils;

/**
 * Create a harness class that will call the entry points of the android application
 * and create objects of appropriate type for the points-to analysis.
 * 
 * @author mgordon
 *
 */
public class Harness {
	private final static Logger logger = LoggerFactory.getLogger(Harness.class);
	
	private final static String RUNTIME_MODELING_CLASS = "droidsafe.runtime.DroidSafeAndroidRuntime";

	//map of component class names to the init method that should be called for them...
	private static Map<String, String> componentInitMethod = ImmutableMap.of(
			Components.ACTIVITY_CLASS, "<" + RUNTIME_MODELING_CLASS + ": void modelActivity(android.app.Activity)>",
			Components.SERVICE_CLASS, "<" + RUNTIME_MODELING_CLASS + ": void modelService(android.app.Service)>",
			Components.CONTENTPROVIDER_CLASS, "<" + RUNTIME_MODELING_CLASS + ": void modelContentProvider(android.content.ContentProvider)>",
			Components.BROADCASTRECEIVER_CLASS, "<" + RUNTIME_MODELING_CLASS + ": void modelBroadCastReceiver(android.content.BroadcastReceiver)>"
			);
	
	private SootClass harnessClass;
	private SootMethod harnessMain;
	private List<Unit> entryPointInvokes;
	public static String HARNESS_CLASS_NAME = "DroidSafeMain";
	
	private Map<SootClass, Local> localsMap;
	private Set<SootField> generatedFields;
		
	private int localID = 0;
	private int fieldID = 0;
	
	public static final String FIELDNAME = "_ds_generated_field";
	
	public static Harness v;
	
	/**
	 * Create a harness class with a main method that includes calls into
	 * all the entry points of the android application.
	 */
	public static void create() {
		if (!EntryPoints.v().isCalculated())
			Utils.logErrorAndExit(logger, "Entrypoints need to be calculated before harness created");		
		
		v = new Harness();
	}
	
	public static Harness v() {
		if (v == null)
			Utils.logErrorAndExit(logger, "Harness not created!");
		return v;
	}

	/**
	 * Return the main method for the harness that includes all the calls
	 * to the entry points.
	 */
	public SootMethod getMain() {
		return harnessMain;
	}
	
	public SootClass getHarnessClass() {
		return harnessClass;
	}
	
	private Harness() {
		entryPointInvokes = new LinkedList<Unit>();
		generatedFields = new LinkedHashSet<SootField>();
		
		//create the harness class
		harnessClass = new SootClass(HARNESS_CLASS_NAME, Modifier.PUBLIC | Modifier.FINAL);
		harnessClass.setSuperclass(Scene.v().getSootClass("java.lang.Object"));
		
		searchForAllocsOfAPIImplementors();
		 
		//create the harness main method
		List<Type> args = new LinkedList<Type>();
		args.add(ArrayType.v(RefType.v("java.lang.String"), 1));
		harnessMain = new SootMethod("main", 
				args, VoidType.v(),
				Modifier.PUBLIC | Modifier.STATIC);
		
		harnessMain.setDeclaringClass(harnessClass);
		harnessClass.addMethod(harnessMain);
		
		StmtBody body = Jimple.v().newBody(harnessMain);
		harnessMain.setActiveBody(body);
		
		Stmt beginCalls = mainMethodHeader(body);
		addCallToModelingRuntime(body);
		addCallsToComponentEntryPoints(body);
		addCallsToNonComponentEntryPoints(body);
		
		//create the loop back to the beginning of the calls
		body.getUnits().add(Jimple.v().newGotoStmt(beginCalls));
		
		body.getUnits().add(Jimple.v().newReturnVoidStmt());
		
		
		Scene.v().addClass(harnessClass);
		Scene.v().loadClass(harnessClass.getName(), SootClass.BODIES);
		harnessClass.setApplicationClass();		
		
		SootUtils.writeByteCodeAndJimple(Project.v().getOutputDir() + File.separator + HARNESS_CLASS_NAME, getHarnessClass());
	}

	//add call to the modeling entry point for the modeling of the android runtime
	private void addCallToModelingRuntime(StmtBody body) {
		SootClass dsRuntime = Scene.v().getSootClass("droidsafe.runtime.DroidSafeAndroidRuntime");
		SootMethod entry = dsRuntime.getMethod("void main()");
		Stmt call = Jimple.v().newInvokeStmt(makeInvokeExpression(entry, null, new LinkedList<Value>()));
		body.getUnits().add(call);
	}
	
	/**
	 * we have to find all creation sites of objects of application classes.  We want to call
	 * any method that overrides an api method on the object (allocnode) in the harness class
	 * so that the pta can reason correctly about the calls. 
	 */
	private void searchForAllocsOfAPIImplementors() {
		for (SootClass clz : Scene.v().getClasses()) {
			//not a class we are interested in
			if (clz.isLibraryClass() || clz.isInterface() ||
					clz.equals(harnessClass) || API.v().isSystemClass(clz)) 
				continue;

			//loop through all methods, and then allocation statements
			//looking for allocations of objects that have API parents
			for (SootMethod method : clz.getMethods()) {
				if (!clz.declaresMethod(method.getSubSignature())
						|| !method.isConcrete()) 
					continue;
				
				if (method.isNative()) 
					continue;
				
				StmtBody stmtBody = null;
				
				try {
					try {
						 stmtBody = (StmtBody)method.retrieveActiveBody();
					} catch (Exception e) {
						if (e.getMessage().startsWith("Unrecognized bytecode instruction: 168") &&
								Project.v().isLibClass(clz.toString())) {
							logger.warn("\nError with underlying Soot translation for method {} {}. It is a method from a jar" +
									"library.  Ignoring error and continuing...\n", method, clz);
							clz.removeMethod(method);
							continue;
						} if (Project.v().isLibClass(clz.toString())) {
							logger.warn("\nError with in analyzing library method. Ignoring and continuing...\n", method, clz);
							clz.removeMethod(method);
							continue;
						} else {
							logger.error("Unknown error in building Harness", e);
							System.exit(1);
						}
					}
					Chain<Unit> units = stmtBody.getUnits();
					Iterator<Unit> stmtIt = units.snapshotIterator();
					while (stmtIt.hasNext()) {
						Stmt stmt = (Stmt)stmtIt.next();
						if (!(stmt instanceof AssignStmt))
							continue;
						AssignStmt assignStmt = (AssignStmt)stmt;
						//find all assignments statements with rval as new expr
						if (assignStmt.getRightOp() instanceof NewExpr) {
							NewExpr newExpr = (NewExpr)assignStmt.getRightOp();

							//looking for a new expr of a class that is an app class and inherits from api
							if (newExpr.getType() instanceof RefType &&
									((RefType)newExpr.getType()).getSootClass().isApplicationClass() &&
									!API.v().isSystemClass(((RefType)newExpr.getType()).getSootClass()) &&
									Hierarchy.v().inheritsFromAndroid(((RefType)newExpr.getType()).getSootClass())) {

								//creating a new class in user code that inherits from an api class
								logger.debug("Found an alloc of a app class that inherits from API {}: in {} ({})", newExpr, method, clz);
								handleAllocOfAPIImplementors(newExpr, assignStmt, clz, units);
							}
						}
					}
				} catch (Exception e) {
					logger.warn("Trying to look for allocations in method {} of {} (probably a native method)", method, clz, e);
				}
			}
		}
	}

	private void handleAllocOfAPIImplementors(NewExpr expr, AssignStmt stmt, SootClass clz, Chain<Unit> units) {
		//create field in the harness class
		SootField field = new SootField(FIELDNAME + fieldID++, expr.getType(), Modifier.PUBLIC | Modifier.STATIC);
		harnessClass.addField(field);
		
		//remember this field for later so we can create all api overriding calls in it
		generatedFields.add(field);
		
		SootFieldRef fieldRef = field.makeRef();
		
		//add an assignment of the field right after the new call
		units.insertAfter(Jimple.v().newAssignStmt(Jimple.v().newStaticFieldRef(fieldRef), stmt.getLeftOp()), 
				stmt);
	}
	
	private void addCallsToNonComponentEntryPoints(StmtBody body) {
		//for each field that we generated, add a call to any method that overrides 
		//an api method
		for (SootField field : generatedFields) {
			SootClass clz = ((RefType)field.getType()).getSootClass();
			//we need to keep around this field if there are non-modeled calls to it
			//any method of it
			boolean needField = false;
			for (SootMethod method : clz.getMethods()) {
				//Messages.log("    Checking for method: " + method.getSignature());
    			if (!clz.declaresMethod(method.getSubSignature()) ||
    					!method.isConcrete())
    				continue;
 
    			if (Hierarchy.v().isImplementedSystemMethod(method)) {
    				//find the closest overriden method from the api
    				SootMethod closestParent = API.v().getClosestOverridenAPIMethod(method);
    				//don't add a call for overrides that override a method that is modeled
    				//if modeled, it means we have modeled all registrations of the method
    				if (!API.v().isAPIModeledMethod(closestParent)) {
    					logger.info("Adding call in harness to non-component entry point: {}", method.toString());
    					//create a local to point to the field
    					Local receiver = Jimple.v().newLocal("l" + localID++, field.getType());
    					body.getLocals().add(receiver);
    					//assign the local to the field
    					body.getUnits().add(Jimple.v().newAssignStmt(receiver, 
    							Jimple.v().newStaticFieldRef(field.makeRef())));
    					//create a call to this entry point
    					createCallWithNewArgs(method, body, receiver);
    					needField = true;
    				}
    			} 
			}
		}
	}
	
	/**
	 * create the header for the main method including the saving of args
	 * and the start of the loop for entry points calls, return the label for the loop
	 */
	private Stmt mainMethodHeader(StmtBody body) {
		//add access to the arg
		Local arg = Jimple.v().newLocal("l" + localID++, ArrayType.v(RefType.v("java.lang.String"), 1));
	    body.getLocals().add(arg);
	  
	    body.getUnits().add(Jimple.v().newIdentityStmt(arg, 
	            Jimple.v().newParameterRef(ArrayType.v
	              (RefType.v("java.lang.String"), 1), 0)));
	    
	    //create a nop as target of goto below, to create loop over all possible events
	    NopStmt beginCalls = Jimple.v().newNopStmt();
	    body.getUnits().add(beginCalls);
	    
	    return beginCalls;
	}
	
	private void addCallsToComponentEntryPoints(StmtBody body) {
	    
	    localsMap = new LinkedHashMap<SootClass, Local>();
		
		for (SootMethod entryPoint : EntryPoints.v().getAppEntryPoints()) {
			SootClass clazz = entryPoint.getDeclaringClass();
			
			if (clazz.isInterface() || clazz.isAbstract())
				continue;
			
			//first create the local for the declaring class if we have not created it before
			if (!localsMap.containsKey(clazz) && !entryPoint.isStatic()) {
				RefType type = RefType.v(clazz);
				
				//add the local
				Local receiver = Jimple.v().newLocal("l" + localID++, type);
				body.getLocals().add(receiver);
				
				//add the call to the new object
				body.getUnits().add(Jimple.v().newAssignStmt(receiver, Jimple.v().newNewExpr(type)));
				
				//create a constructor for this call unless the call itself is a constructor
				if (!entryPoint.isConstructor())
					addConstructorCall(body, receiver, type);
				else {
					//create the call to the entry point method
					createCallWithNewArgs(entryPoint, body, receiver);
				}
				
				logger.debug("Adding new receiver object to harness main method: {}", clazz.toString());
				localsMap.put(clazz, receiver);
				
				//since this is a component, add a call to the launch (init) method in the 
				//runtime modeling
				SootMethod initMethod = Scene.v().getMethod(componentInitMethod.get(Hierarchy.v().getComponentParent(clazz).getName()));
				LinkedList<Value> args = new LinkedList<Value>();
				args.add(receiver);
				Stmt call = Jimple.v().newInvokeStmt(makeInvokeExpression(initMethod, null, args));
				body.getUnits().add(call);

			}
			//if this is not a constructor call then add the call, constructor calls are taken care of
			// on the first instance of an object above
			if (!entryPoint.isConstructor()){
			    //find the closest overriden method from the api
                SootMethod closestParent = API.v().getClosestOverridenAPIMethod(entryPoint);
                //don't add a call for overrides that override a method that is modeled
                //if modeled, it means we have modeled all registrations of the method
                if (closestParent == null || !API.v().isAPIModeledMethod(closestParent)) {
                    Local receiver = localsMap.get(clazz);
                    //create the call to the entry point method
                    createCallWithNewArgs(entryPoint, body, receiver);
                }
			}
		}
	}

	private void createCallWithNewArgs(SootMethod method, StmtBody body, Local receiver) {
		//next create locals for all arguments
		//List of argument position to locals created...
		List<Value> args = new LinkedList<Value>();
		for (Object argType : method.getParameterTypes()) {
			//if a reference, create dummy object
			if (argType instanceof RefType) {
				Value v = createNewAndConstructorCall(body, method, ((RefType)argType));
				args.add(v);
			} else if (argType instanceof ArrayType) {
				Value v = createNewArrayAndObject(body, method, (ArrayType)argType);
				args.add(v);
			} else {
				args.add(SootUtils.getNullValue((Type)argType));
			}
		}

		//now create call to entry point
		logger.debug("method args {} = size of args list {}", method.getParameterCount(), args.size());
		Stmt call = Jimple.v().newInvokeStmt(makeInvokeExpression(method, receiver, args));
		entryPointInvokes.add(call);
		body.getUnits().add(call);
	}
	
	private Value createNewArrayAndObject(Body body, SootMethod entryPoint, ArrayType type) {
		Type baseType = type.getArrayElementType();
		
		//create new array to local		
		Local arrayLocal = Jimple.v().newLocal("l" + localID++, type);
		body.getLocals().add(arrayLocal);
		
		if (type.numDimensions > 1) {
			//multiple dimensions, have to do some crap...
			List<Value> ones = new LinkedList<Value>();
			for (int i = 0; i < type.numDimensions; i++)
				ones.add(IntConstant.v(1));
			
			body.getUnits().add(Jimple.v().newAssignStmt(arrayLocal,
				Jimple.v().newNewMultiArrayExpr(type, ones)));
		} else {
			//single dimension, add new expression
			body.getUnits().add(Jimple.v().newAssignStmt(arrayLocal, 
				Jimple.v().newNewArrayExpr(baseType, IntConstant.v(1))));
		}
		
		//get down to an element through the dimensions
		Local elementPtr = arrayLocal;
		while (((ArrayType)elementPtr.getType()).getElementType() instanceof ArrayType) {
			Local currentLocal = Jimple.v().newLocal("l" + localID++, ((ArrayType)elementPtr).getElementType());
			body.getUnits().add(Jimple.v().newAssignStmt(
					currentLocal, 
					Jimple.v().newArrayRef(elementPtr, IntConstant.v(0))));
			elementPtr = currentLocal;
		}

		//if a ref type, then create the new and constructor and assignment to array element
		if (baseType instanceof RefType) {
			//create the new expression and constructor call for a new local
			Value eleLocal = createNewAndConstructorCall(body, entryPoint, (RefType)baseType);
			//assign the new local to the array access
			body.getUnits().add(Jimple.v().newAssignStmt(
					Jimple.v().newArrayRef(elementPtr, IntConstant.v(0)), 
					eleLocal));	
		}	

		return arrayLocal;
	}
	
	/**
	 * Add to the body code to create a new object and assign it to a local, and then call the constructor
	 * on the local.  If the type is an interface, then try to find a close implementor
	 * return the local so it can be used in array assignments
	 */
	private Value createNewAndConstructorCall(Body body, SootMethod entryPoint, RefType type) {
		SootClass clz = type.getSootClass();
		//if an interface, find a direct implementor of and instantiate that...
		if (!clz.isConcrete()) {
			clz = SootUtils.getCloseConcrete(clz);
		}
		
		if (clz ==  null) {
			//if clz is null, then we have an interface with no known implementors, 
			//so just pass null
			logger.warn("Cannot find any known implementors of {} when building harness for entry {}", 
					type.getSootClass(), entryPoint);
			return SootUtils.getNullValue(type);
		}
		
		//if we got here, we found a class to instantiate, either the org or an implementor
		Local argLocal = Jimple.v().newLocal("l" + localID++, type);
		body.getLocals().add(argLocal);
		
		//add the call to the new object
		body.getUnits().add(Jimple.v().newAssignStmt(argLocal, Jimple.v().newNewExpr(RefType.v(clz))));
		
		addConstructorCall(body, argLocal, RefType.v(clz));
		return argLocal;
	}
	
	/**
	 * Given a method, create the appropriate invoke jimple expression to invoke it on the local, and with 
	 * args.
	 */
	public static InvokeExpr makeInvokeExpression(SootMethod method, Local local, List<Value> args) {
		if (method.isConstructor()) {	
			return Jimple.v().newSpecialInvokeExpr(local, method.makeRef(), args);
		} else if (method.isStatic()) {
			return Jimple.v().newStaticInvokeExpr(method.makeRef(), args);
		} else {
			return Jimple.v().newVirtualInvokeExpr(local, method.makeRef(), args);
		}
	}
	
	public static void addConstructorCall(Body body, Local local, RefType type) {
		SootClass clazz = type.getSootClass();
		
		//add the call to the constructor with its args
		SootMethod constructor = SootUtils.findSimpliestConstructor(clazz);
		if (constructor == null) {
			logger.info("Cannot find constructor for {}.  Not going to call constructor.", clazz);
			return;
		}
		
		//create list of dummy arg values for the constructor call, right now all constants
		List<Value> args = new LinkedList<Value>();
		for (Object argType : constructor.getParameterTypes()) {
			args.add(SootUtils.getNullValue((Type)argType));
		}
		
		//add constructor call to body nested in invoke statement
		body.getUnits().add(Jimple.v().newInvokeStmt(Jimple.v().newSpecialInvokeExpr(local, constructor.makeRef(), args)));
	}
}
