package droidsafe.android.app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableMap;

import droidsafe.android.system.API;
import droidsafe.android.system.Components;
import droidsafe.utils.SootUtils;
import droidsafe.utils.Utils;

import soot.Body;
import soot.Local;
import soot.Printer;
import soot.RefLikeType;
import soot.Scene;
import soot.SootField;
import soot.SootFieldRef;
import soot.SootMethodRef;
import soot.SourceLocator;
import soot.Type;
import soot.ArrayType;
import soot.Modifier;
import soot.RefType;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.VoidType;
import soot.jimple.AssignStmt;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.JasminClass;
import soot.jimple.Jimple;
import soot.jimple.NewExpr;
import soot.jimple.NopStmt;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.util.Chain;
import soot.util.JasminOutputStream;
import soot.Value;
import droidsafe.main.Constants;

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
	public static String HARNESS_CLASS_NAME = "DroidSafeMain";
	
	private Map<SootClass, Local> localsMap;
		
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
			Utils.ERROR_AND_EXIT(logger, "Entrypoints need to be calculated before harness created");		
		
		v = new Harness();
	}
	
	public static Harness v() {
		if (v == null)
			Utils.ERROR_AND_EXIT(logger, "Harness not created!");
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
			
		//create the harness class
		harnessClass = new SootClass(HARNESS_CLASS_NAME, Modifier.PUBLIC | Modifier.FINAL);
		harnessClass.setSuperclass(Scene.v().getSootClass("java.lang.Object"));
		
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

		for (SootClass clazz : Scene.v().getClasses()) {
			//don't add entry points into the system classes...
			if (API.v().isSystemClass(clazz))
				continue;

			//only add entry points for android component classes
			//other entry points will be handled by searching for allocations 
			//of classes that inherit from an api class / interface.
			if (!Hierarchy.v().isAndroidComponentClass(clazz))
				continue;		

			if (clazz.isInterface() || clazz.isAbstract())
				continue;

			//first create the local for the declaring class if we have not created it before

			RefType type = RefType.v(clazz);

			//add the local
			Local receiver = Jimple.v().newLocal("l" + localID++, type);
			body.getLocals().add(receiver);

			//add the call to the new object
			body.getUnits().add(Jimple.v().newAssignStmt(receiver, Jimple.v().newNewExpr(type)));

			addConstructorCall(body, receiver, type);

			logger.debug("Adding new receiver object to harness main method: {}", clazz.toString());
			localsMap.put(clazz, receiver);

			//add a call to the launch (init) method in the 
			//runtime modeling
			SootMethod initMethod = Scene.v().getMethod(componentInitMethod.get(Hierarchy.v().getComponentParent(clazz).getName()));
			LinkedList<Value> args = new LinkedList<Value>();
			args.add(receiver);
			Stmt call = Jimple.v().newInvokeStmt(makeInvokeExpression(initMethod, null, args));
			body.getUnits().add(call);

		}
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
