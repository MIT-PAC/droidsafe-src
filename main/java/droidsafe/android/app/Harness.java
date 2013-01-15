package droidsafe.android.app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.system.Components;
import droidsafe.utils.SootUtils;
import droidsafe.utils.Utils;

import soot.Local;
import soot.Printer;
import soot.RefLikeType;
import soot.Scene;
import soot.SootField;
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
import soot.jimple.InvokeExpr;
import soot.jimple.JasminClass;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.NopStmt;
import soot.jimple.StmtBody;
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
	
	private SootClass harnessClass;
	private SootMethod harnessMain;
	private List<Unit> entryPointInvokes;
	public static String HARNESS_CLASS_NAME = "DroidSafeMain";
	
	private Map<SootClass, Local> localsMap;
		
	private int localID = 0;
	
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
		entryPointInvokes = new LinkedList<Unit>();
		
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
		
		createBody();
		writeHarnessClass();
	}

	
	private void createBody() {
		JimpleBody body = Jimple.v().newBody(harnessMain);
		harnessMain.setActiveBody(body);
		
		//add access to the arg
		Local arg = Jimple.v().newLocal("l" + localID++, ArrayType.v(RefType.v("java.lang.String"), 1));
	    body.getLocals().add(arg);
	  
	    body.getUnits().add(Jimple.v().newIdentityStmt(arg, 
	            Jimple.v().newParameterRef(ArrayType.v
	              (RefType.v("java.lang.String"), 1), 0)));
	    
	    //create a nop as target of goto below, to create loop over all possible events
	    NopStmt beginCalls = Jimple.v().newNopStmt();
	    body.getUnits().add(beginCalls);
	    
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
				
				logger.debug("Adding new receiver object to harness main method: {}", clazz.toString());
				localsMap.put(clazz, receiver);
				
			}
			
			//next create locals for all arguments
			//List of argument position to locals created...
			List<Value> args = new LinkedList<Value>();
			for (Object argType : entryPoint.getParameterTypes()) {
				//if a reference, create dummy object
				if (argType instanceof RefType) {
					SootClass clz = ((RefType)argType).getSootClass();
					//if an interface, find a direct implementor of and instantiate that...
					if (!clz.isConcrete()) {
						clz = SootUtils.getCloseConcrete(clz);
					}
					
					if (clz ==  null) {
						//if clz is null, then we have an interface with no known implementors, 
						//so just pass null
						args.add(SootUtils.getNullValue((RefType)argType));
						continue;
					}
					
					//if we got here, we found a class to instantiate, either the org or an implementor
					Local argLocal = Jimple.v().newLocal("l" + localID++, (Type)argType);
					body.getLocals().add(argLocal);
					
					//add the call to the new object
					body.getUnits().add(Jimple.v().newAssignStmt(argLocal, Jimple.v().newNewExpr(RefType.v(clz))));
					
					addConstructorCall(body, argLocal, RefType.v(clz));
					args.add(argLocal);
				} else if (argType instanceof ArrayType) {
					logger.warn("Using null for array argument of method {} in harness.", entryPoint);
					args.add(SootUtils.getNullValue((Type)argType));
				} else {
					args.add(SootUtils.getNullValue((Type)argType));
				}
			}

			//now create call to entry point
			Local receiver = localsMap.get(clazz);
			logger.debug("method args {} = size of args list {}", entryPoint.getParameterCount(), args.size());
			Unit call = Jimple.v().newInvokeStmt(makeInvokeExpression(entryPoint, receiver, args));
			entryPointInvokes.add(call);
			body.getUnits().add(call);
		}
		
		//create the loop back to the beginning of the calls
		body.getUnits().add(Jimple.v().newGotoStmt(beginCalls));
		
		body.getUnits().add(Jimple.v().newReturnVoidStmt());
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
	
	public static void addConstructorCall(JimpleBody body, Local local, RefType type) {
		SootClass clazz = type.getSootClass();
		
		//add the call to the constructor with its args
		SootMethod constructor = SootUtils.findSimpliestConstructor(clazz);
		if (constructor == null) {
			Utils.ERROR_AND_EXIT(logger, "Cannot find constructor for {}.  Cannot create harness.", clazz);
		}
		
		//create list of dummy arg values for the constructor call, right now all constants
		List<Value> args = new LinkedList<Value>();
		for (Object argType : constructor.getParameterTypes()) {
			args.add(SootUtils.getNullValue((Type)argType));
		}
		
		//add constructor call to body nested in invoke statement
		body.getUnits().add(Jimple.v().newInvokeStmt(Jimple.v().newSpecialInvokeExpr(local, constructor.makeRef(), args)));
	}
	
	/**
	 * Write the harness class file in the output directory.
	 */
	private void writeHarnessClass() {
		String fileName = Project.v().getOutputDir() + File.separator + HARNESS_CLASS_NAME + ".class";
		try {
			OutputStream streamOut = new JasminOutputStream(
					new FileOutputStream(fileName));
			PrintWriter writerOut = new PrintWriter(
					new OutputStreamWriter(streamOut));
			
			JasminClass jasminClass = new soot.jimple.JasminClass(harnessClass);
		    jasminClass.print(writerOut);
		    writerOut.flush();
		    streamOut.close();
		    
		    fileName = Project.v().getOutputDir() + File.separator + HARNESS_CLASS_NAME + ".jimple";
		    streamOut = new FileOutputStream(fileName);
		    writerOut = new PrintWriter(
		                                new OutputStreamWriter(streamOut));
		    Printer.v().printTo(harnessClass, writerOut);
		    writerOut.flush();
		    streamOut.close();
			
		} catch (Exception e) {
			logger.error("Error writing harness class file {}", e);
			System.exit(1);
		}
	}
}
