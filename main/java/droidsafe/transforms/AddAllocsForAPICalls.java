package droidsafe.transforms;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
import soot.Unit;
import soot.Value;
import soot.Type;
import soot.ValueBox;
import soot.jimple.AssignStmt;
import soot.jimple.CastExpr;
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
import droidsafe.main.Config;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.SootUtils;

/**
 * This transformation creates allocation statements so that the underlying PTA can 
 * know about objects that are returned from API methods.  The problem we are solves is 
 * that we are not analyzing the API code directly, so if a method returns an object,
 * we don't see the allocation site for the object, and the PTA will not know about it.
 * So we patch the pta by creating an explicit allocation for the return object of any api 
 * call that returns an api object.  This allocation is added right after the call.
 * 
 * @author mgordon
 *
 */
public class AddAllocsForAPICalls extends BodyTransformer {
	private final static Logger logger = LoggerFactory.getLogger(AddAllocsForAPICalls.class);
	private Set<NewExpr> generatedExpr;
	private static AddAllocsForAPICalls v;
	
	private static String NEED_TO_MODEL_FILENAME = "added-allocations.txt";
	
	private FileWriter needToModelFile;
	
	private static int localID = 0;
	
	/**
	 * Call this pass on all application classes in the project.
	 */
	public static void run() {

		v = new AddAllocsForAPICalls();
		
		try {
			v.needToModelFile = new FileWriter(Project.v().getOutputDir() + 
					File.separator +NEED_TO_MODEL_FILENAME);

			for (SootClass clz : Scene.v().getClasses()) {
				if (Project.v().isSrcClass(clz.toString()) || Project.v().isLibClass(clz.toString())) {
					for (SootMethod meth : clz.getMethods()) {
						if (meth.isConcrete())
							v.transform(meth.retrieveActiveBody());
					}
				}
			}
			v.needToModelFile.close();
		}
		catch (IOException e) {
			logger.error("Cannot create pta need to model file");
			droidsafe.main.Main.exit(1);
		}
	}

	public static AddAllocsForAPICalls v() {
		return v;
	}
	
	public boolean isGeneratedExpr(Object expr) {
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
			SootMethod target = getTarget(expr);
				
			if (target == null)  //for some reason, not what we are looking for
				continue;
		
			if (!API.v().isSystemMethod(target))
				continue;
			
			//TODO: check if a modeled call, if so, don't add alloc
			if (API.v().isAPIModeledMethod(target))
				continue;
			
			if (!API.v().isSystemClassReference(target.getReturnType())) 
				continue;
			
			try {
				needToModelFile.write(target.getSignature() + "\n");
			} catch (IOException e) {
			}
			
			if (target.getReturnType() instanceof ArrayType) {
				logger.debug("Instrumenting call to {} with new alloc node (array)", target);
				List<Stmt> stmts = getNewArrayAndAlloc(target, stmtBody, origAssign.getLeftOp());
				units.insertAfter(stmts, stmt);
			} else {
				logger.debug("Instrumenting call to {} with new alloc node in {}\n", target, b.getMethod());
				
				//as a hack, but a safe hack, check to see if the value assigned to is cast 
				//immediately, if it is and not control flow, we assume the cast will pass, and we can
				//use this type to create an object
				SootClass castedTo = findNextCastOfValue(stmt, stmtBody, origAssign.getLeftOp(), 5);
				
				//create a new express for each concrete type that this return type could take on
				//if it is already a concrete just, then just use this, have to search for concrete
				//if abstract or interface.
				SootClass returnClass = ((RefType)target.getReturnType()).getSootClass();
				
				if (castedTo != null)
					returnClass = castedTo;
				
				SootClass lvalClass = ((RefType)origAssign.getLeftOp().getType()).getSootClass();
				
				List<SootClass> clzs = SootUtils.smallestConcreteSetofImplementors(returnClass);
				clzs = pruneSmallestConcreteImplementors(clzs);
				Set<SootClass> visited = new LinkedHashSet<SootClass>();
				
				for (SootClass clz : clzs) {
					//between the defined return type and the type of anything 
					SootClass narrower = SootUtils.narrowerClass(clz, lvalClass);
					//logger.debug("  checking class: {} (to {})", clz, lvalClass);
					//this class is not related to the defined class of the lval
					//can't instantiate
					if (narrower == null) 
						continue;
					//add an new expr for the more specific class between the defined
					//type of the lval and this current class that the reference could take on
					if (!visited.contains(narrower)) {
						logger.debug("  Adding new expression of: {}", narrower);
						NewExpr newExpr = Jimple.v().newNewExpr(RefType.v(narrower));
						generatedExpr.add(newExpr);
						AssignStmt assignStmt = Jimple.v().newAssignStmt(origAssign.getLeftOp(), newExpr);
						units.insertAfter(assignStmt, stmt);
						visited.add(narrower);
					}
				}
			}
		}
	}
	
	/**
	 * Prune the set of classes that we are going to conservatively create objects of if there is a
	 * droidsafe concrete class in there and just return the ds concrete class.  Otherwise, return orignal set.
	 */
	private List<SootClass> pruneSmallestConcreteImplementors(List<SootClass> clzs) {
	    boolean foundDS = false;
	    SootClass dsConcreteClass = null;
	    for (SootClass clz : clzs) {
	        if (clz.getName().startsWith("droidsafe.concrete")) {
	            foundDS = true;
	            dsConcreteClass = clz;
	            break;
	        }
	    }
	    
	    if (foundDS) {
	        LinkedList<SootClass> dsConcrete = new LinkedList<SootClass>();
	        dsConcrete.add(dsConcreteClass);
	        return dsConcrete;
	    } else {
	        return clzs;
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
			
			//the basetype might be a interface or an abstract, we cannot create new objects of these types
			//so find concrete classes if the reference is to an non-concrete class.
			List<SootClass> clzs = SootUtils.smallestConcreteSetofImplementors(((RefType)baseType).getSootClass());
			
			for (SootClass clz : clzs) {
				//add the call to the new objects for all concrete classes
				NewExpr newExpr = Jimple.v().newNewExpr(RefType.v(clz));
				stmts.add(Jimple.v().newAssignStmt(eleLocal, newExpr));
				//remember this as a generated new expression (alloc node will use later)
				generatedExpr.add(newExpr);
			}
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
	
	private SootMethod getTarget(InvokeExpr expr) {
		if (expr instanceof InstanceInvokeExpr) {
			InstanceInvokeExpr iie = (InstanceInvokeExpr)expr;
			if (iie.getBase().getType() instanceof RefLikeType)  {
				Type recType = SootUtils.getBaseType((RefLikeType)iie.getBase().getType());
				if (recType instanceof RefType) {
					RefType recRefType = (RefType)recType;
					SootClass recClass = recRefType.getSootClass();
					//we have found a type for the receiver that we can handle
					//if it is an abstract or interface, then just return the abstract method
					//all we care about is the return type
					if (recClass.isInterface() || recClass.isAbstract()) {
						return expr.getMethod();
					} else  {//if concrete, then try to find the exact method, but who really cares, we just need the 
						//return type
						try {
							return SootUtils.resolveConcreteDispatch( recRefType.getSootClass(), expr.getMethod());
						} catch (CannotFindMethodException e) {
							return SootUtils.resolveMethod(recRefType.getSootClass(), expr.getMethod().getSignature());
						}
					}
				}
			}
		} else if (expr instanceof StaticInvokeExpr) {
			return ((StaticInvokeExpr)expr).getMethod();
		} else {
			logger.error("Unknown invoke expr {}", expr);
			droidsafe.main.Main.exit(1);
		}
		return null;
	}
	
	private SootClass findNextCastOfValue(Stmt stmt, Body body, Value v, int distance) {
		Iterator<Unit> fromStmt = body.getUnits().iterator(stmt);
		
		int numStmts = 0;
		
		while (fromStmt.hasNext()) {
			//only search for the given distance of statements from the beginning
			if (numStmts++ > distance)
				break;
			
			Stmt currentStmt = (Stmt)fromStmt.next();
			
			//return if we have a branch
			if (currentStmt.branches())
				break;
			
			for (ValueBox curValue : currentStmt.getUseBoxes()) {
				if (curValue.getValue() instanceof CastExpr) {
					CastExpr ce = (CastExpr)curValue.getValue();
					if (ce.getOp().equals(v) && ce.getType() instanceof RefType) {
						return ((RefType)ce.getType()).getSootClass();
					}
				}
			}			
		}
		return null;
	}
}

