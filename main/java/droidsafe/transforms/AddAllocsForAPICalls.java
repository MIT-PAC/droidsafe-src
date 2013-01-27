package droidsafe.transforms;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.ArrayType;
import soot.Body;
import soot.BodyTransformer;
import soot.Hierarchy;
import soot.Local;
import soot.Modifier;
import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Value;
import soot.Type;
import soot.jimple.AssignStmt;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.NewExpr;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.StringConstant;
import soot.jimple.internal.JAssignStmt;
import soot.util.Chain;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.utils.SootUtils;

public class AddAllocsForAPICalls extends BodyTransformer {
	private final static Logger logger = LoggerFactory.getLogger(AddAllocsForAPICalls.class);
	private Set<NewExpr> generatedExpr;
	private static AddAllocsForAPICalls v;
	
	
	private static int localID = 0;
	
	/**
	 * Call this pass on all application classes in the project.
	 */
	public static void run() {
		
		
		v = new AddAllocsForAPICalls();
		for (SootClass clz : Scene.v().getClasses()) {
			if (Project.v().isAppClass(clz.toString())) {
				for (SootMethod meth : clz.getMethods()) {
					if (meth.isConcrete())
						v.transform(meth.retrieveActiveBody());
				}
			}
		}
	}

	public static AddAllocsForAPICalls v() {
		return v;
	}
	
	public boolean isGeneratedExpr(NewExpr expr) {
		return generatedExpr.contains(expr);
	}
	
	private AddAllocsForAPICalls() {
		this.generatedExpr = new LinkedHashSet<NewExpr>();
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

			if (!stmt.containsInvokeExpr() || !(stmt instanceof JAssignStmt)) {
				continue;
			}
						
			InvokeExpr expr = (InvokeExpr)stmt.getInvokeExpr();
			AssignStmt origAssign = (AssignStmt)stmt;
			RefType recType = getRefTypeOfReceiver(expr);
				
			if (recType == null)  //for some reason, not what we are looking for
				continue;
			
			SootMethod target = Scene.v().getActiveHierarchy().resolveConcreteDispatch( recType.getSootClass(), expr.getMethod());
			
			if (!API.v().isSystemMethod(target))
				continue;
			
			if (!API.v().isSystemClassReference(target.getReturnType())) 
				continue;
			
			if (target.getReturnType() instanceof ArrayType) {
				logger.debug("Instrumenting call to %s with new alloc node (array)", target);
				List<Stmt> stmts = getNewArrayAndAlloc(target, stmtBody, origAssign.getLeftOp());
				units.insertAfter(stmts, stmt);
			} else {
				logger.debug("Instrumenting call to %s with new alloc node\n", target);
				NewExpr newExpr = Jimple.v().newNewExpr((RefType)target.getReturnType());
				generatedExpr.add(newExpr);
				AssignStmt assignStmt = Jimple.v().newAssignStmt(origAssign.getLeftOp(), newExpr);
			
				units.insertAfter(assignStmt, stmt);
			}
			//if a call to something in the library or a subclass of library
			
			//if that method can return an object from library
			
			//then create a new instruction for that local of the class that is returned by the method
		}
	}
	
	private List<Stmt> getNewArrayAndAlloc(SootMethod target, Body stmtBody, Value assignTo) {
		List<Stmt> stmts = new LinkedList<Stmt>();
		ArrayType type = (ArrayType)target.getReturnType();
		
		Type baseType = type.getArrayElementType();
		
		//create new array to local		
		Local arrayLocal = Jimple.v().newLocal("l" + localID++, type);
		stmtBody.getLocals().add(arrayLocal);
		
		if (type.numDimensions > 1) {
			//multiple dimensions, have to do some crap...
			List<Value> ones = new LinkedList<Value>();
			for (int i = 0; i < type.numDimensions; i++)
				ones.add(IntConstant.v(1));
			
			stmts.add(Jimple.v().newAssignStmt(arrayLocal,
				Jimple.v().newNewMultiArrayExpr(type, ones)));
		} else {
			//single dimension, add new expression
			stmts.add(Jimple.v().newAssignStmt(arrayLocal, 
				Jimple.v().newNewArrayExpr(baseType, IntConstant.v(1))));
		}
		
		//get down to an element through the dimensions
		Local elementPtr = arrayLocal;
		while (((ArrayType)elementPtr.getType()).getElementType() instanceof ArrayType) {
			Local currentLocal = Jimple.v().newLocal("l" + localID++, ((ArrayType)elementPtr).getElementType());
			stmts.add(Jimple.v().newAssignStmt(
					currentLocal, 
					Jimple.v().newArrayRef(elementPtr, IntConstant.v(0))));
			elementPtr = currentLocal;
		}

		//if a ref type, then create the new and the assignment to array element
		if (baseType instanceof RefType) {
			//create the new expr with a new local
			Local eleLocal = Jimple.v().newLocal("l" + localID++, type);
			stmtBody.getLocals().add(eleLocal);
			
			//add the call to the new object
			NewExpr newExpr = Jimple.v().newNewExpr((RefType)baseType);
			stmts.add(Jimple.v().newAssignStmt(eleLocal, newExpr));
			//remember this as a generated new expression (alloc node will use later)
			generatedExpr.add(newExpr);
			
			//don't really care about constructor here...actually have no idea about this value
			
			//assign the new local to the array access
			stmts.add(Jimple.v().newAssignStmt(
					Jimple.v().newArrayRef(elementPtr, IntConstant.v(0)), 
					eleLocal));	
		}	
		
		//The assignment of the array to the local that held the return of the api method
		AssignStmt assignStmt = Jimple.v().newAssignStmt(assignTo, arrayLocal);
		stmts.add(assignStmt);
		
		return stmts;
	}
	
	private RefType getRefTypeOfReceiver(InvokeExpr expr) {
		if (expr instanceof InstanceInvokeExpr) {
			InstanceInvokeExpr iie = (InstanceInvokeExpr)expr;
			if (iie.getBase().getType() instanceof RefLikeType)  {
				Type recType = SootUtils.getBaseType((RefLikeType)iie.getBase().getType());
				if (recType instanceof RefType)
					return (RefType)recType;
			}
		} else if (expr instanceof StaticInvokeExpr) {
			if (((StaticInvokeExpr)expr).getType() instanceof RefType)
				return (RefType)((StaticInvokeExpr)expr).getType();
		} else {
			logger.error("Unknown invoke expr {}", expr);
			System.exit(1);
		}
		return null;
	}
}

/*
 Some old code I may want again: mgordon
SootClass vib = Scene.v().getSootClass("android.app.Activity");
List<Object> subClasses = Scene.v().getActiveHierarchy().getDirectSubclassesOf(vib);

vib.setName("android.app.$Activity$");
vib.setRefType(RefType.v("android.app.$Activity$"));
Scene.v().removeClass(vib);
Scene.v().addClass(vib);
vib.setLibraryClass();

SootClass newVib = new SootClass("android.app.Activity", Modifier.PUBLIC);
newVib.setSuperclass(vib);

for (Object obj: subClasses) {
	SootClass clz = (SootClass)obj;
	clz.setSuperclass(newVib);
	System.out.printf("Setting superclass of %s to %s\n", clz, newVib);
}


SootMethod oldMethod = vib.getMethod("java.lang.Object getSystemService(java.lang.String)");
SootMethod newMethod = new SootMethod(new String(oldMethod.getName()), oldMethod.getParameterTypes(), oldMethod.getReturnType(), 
		Modifier.PUBLIC, oldMethod.getExceptions());


JimpleBody body = Jimple.v().newBody(newMethod);
newMethod.setActiveBody(body);

Local receiver = Jimple.v().newLocal("l" + localID++, oldMethod.getReturnType());
body.getLocals().add(receiver);

body.getUnits().add(Jimple.v().newAssignStmt(receiver, Jimple.v().newNewExpr((RefType)oldMethod.getReturnType())));

body.getUnits().add(Jimple.v().newReturnStmt(receiver));

newVib.addMethod(newMethod);
Scene.v().addClass(newVib);
newVib.setInScene(true);
newVib.setApplicationClass();


Scene.v().releaseActiveHierarchy();
Scene.v().releaseCallGraph(); 
Scene.v().releaseFastHierarchy();
Scene.v().releasePointsToAnalysis(); 
Scene.v().releaseReachableMethods(); 		           
Scene.v().releaseSideEffectAnalysis();

Scene.v().loadNecessaryClasses();
	
Scene.v().setActiveHierarchy(new Hierarchy());
*/