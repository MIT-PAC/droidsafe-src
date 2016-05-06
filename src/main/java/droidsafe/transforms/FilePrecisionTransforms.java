package droidsafe.transforms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.strings.JSAStrings;
import droidsafe.analyses.value.ValueAnalysis;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.speclang.JSAValue;
import droidsafe.transforms.objsensclone.ClassCloner;
import droidsafe.utils.SootUtils;
import soot.Body;
import soot.IntType;
import soot.Local;
import soot.Modifier;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootFieldRef;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.jimple.AssignStmt;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.Jimple;
import soot.jimple.NewExpr;
import soot.jimple.ReturnStmt;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.StaticFieldRef;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.StringConstant;

/**	
 * Check modeling for all methods that return java.io.File?
 * 
 * 0. We have special DroidSafe versions of the FileInputStream and FileOutputStream that read / write
 * taint specially.  RandomAccessFile?
 * 
 * 1. Check that all file opens have string constants as resolved by string analysis
 *    (if not, then warn in the non-info-report, no random access files?)
 * 2. Create clones of file input stream and file output stream for each string constant
 * 3. Replace returned FIS/FOS with appropriate clone
 * 
 * @author mgordon
 *
 */
public class FilePrecisionTransforms {
	private final Logger logger = LoggerFactory.getLogger(FilePrecisionTransforms.class);
	/** Map if file name to class that represents taint for input and output */
	private Map<String,SootClass[]> fileNameToInputOutputClass;
	/** List of classes that, if they appear, we cannot apply the transformation */
	private Set<SootClass> failIfTheseAreCreated;
	/** List of the methods in the API we are transforming, and how to transform them if found */
	private List<FileStreamTransformDirective> transformDirectives;
	/** Static singleton */
	private static FilePrecisionTransforms v;

	public static FilePrecisionTransforms v() {
		if (v == null)
			v = new FilePrecisionTransforms();

		return v;
	}

	/**
	 * Try to run the precision (and accuracy) increases file-focused IR transformations.
	 */
	public void run() {
		if (bannedClassesCreated())
			return;

		List<JimpleTransform> changes = new LinkedList<JimpleTransform>();
		//generate the list of transforms, this is checking the code also
		//for violations of preconditions, if one is found, then return false
		//and don't apply any transformations
		boolean success = generateTransforms(changes);
		if (success) {
			//apply changes
			for (JimpleTransform jt : changes) {
				jt.applyTransform();
			}
		} else {
			logger.info("FilePrecisionTransforms failed!");
		}
	}

	private FilePrecisionTransforms() {		
		createFailIfTheseAreCreated();
		createTransforms();
		fileNameToInputOutputClass = new HashMap<String,SootClass[]>();
	}

	private void createFailIfTheseAreCreated() {		
		failIfTheseAreCreated = new HashSet<SootClass>();
		failIfTheseAreCreated.add(Scene.v().getSootClass("android.util.AtomicFile"));
		failIfTheseAreCreated.add(Scene.v().getSootClass("java.lang.ProcessBuilder"));
		failIfTheseAreCreated.add(Scene.v().getSootClass("java.io.FileDescriptor"));
	}

	private boolean bannedClassesCreated() {
		for (SootMethod m : PTABridge.v().getReachableMethods()) {
			// filter out abstract, not concrete, phantom and stub methods
			if (API.v().isSystemMethod(m)
					|| m.isAbstract() 
					|| !m.isConcrete() 
					|| m.isPhantom() 
					|| SootUtils.isRuntimeStubMethod(m))
				continue;


			StmtBody stmtBody = (StmtBody)m.getActiveBody();
			Iterator stmtIt = stmtBody.getUnits().snapshotIterator();
			while (stmtIt.hasNext()) {
				Stmt stmt = (Stmt)stmtIt.next();

				if (stmt instanceof AssignStmt) {
					if (((AssignStmt)stmt).getRightOp() instanceof NewExpr &&
							failIfTheseAreCreated.contains(((NewExpr)((AssignStmt)stmt).getRightOp()).getBaseType().getSootClass())) {
						logger.info("FilePrecisionTransform: found banned creation: {}", stmt);
						return true;
					}
				} else if (stmt.containsInvokeExpr()) {                    				
					for (SootMethod target : PTABridge.v().getTargetsInsNoContext(stmt)) {
						if (!API.v().isSystemMethod(target))
							continue;

						//check if a banned type is returned by this method
						if (target.getReturnType() instanceof RefType &&
								failIfTheseAreCreated.contains(((RefType)target.getReturnType()).getSootClass())) {
							logger.info("FilePrecisionTransform: found banned creation: {}", stmt);
							return true;           
						}
					}
				}
			}
		}

		return false;
	}

	private boolean generateTransforms(List<JimpleTransform> changes) {
		List<SootClass> classes = new LinkedList<SootClass>();
		classes.addAll(Scene.v().getClasses());
		for (SootClass clz : classes) {
			for (SootMethod m : clz.getMethods()) {
				// filter out abstract, not concrete, phantom and stub methods
				if (API.v().isSystemMethod(m)
						|| m.isAbstract() 
						|| !m.isConcrete() 
						|| m.isPhantom() 
						|| SootUtils.isRuntimeStubMethod(m))
					continue;


				StmtBody stmtBody = (StmtBody)m.getActiveBody();
				Iterator stmtIt = stmtBody.getUnits().snapshotIterator();
				while (stmtIt.hasNext()) {
					Stmt stmt = (Stmt)stmtIt.next();

					if (stmt.containsInvokeExpr()) {
						Set<SootMethod> targets = PTABridge.v().getTargetsInsNoContext(stmt);

						FileStreamTransformDirective directive = findTransformTarget(targets);
						if (directive != null && targets.size() != 1) {
							logger.info("FilePrecisionTransforms failed: Found transform target but stmt has multiple potential callees: {} {}", 
									stmt, SootUtils.getSourceLocation(stmt));
							return false;
						}
						if (directive != null) {
							//we found a call to a target to transform
							InvokeExpr ie = stmt.getInvokeExpr();
							//see if the argument is a string constant
							String concat = directive.prefix;
							for (int arg : directive.argsToConcat) {
								if (ie.getArg(arg).getType().equals(RefType.v("java.lang.String"))) {
									if (JSAStrings.v().isHotspotValue(ie.getArg(arg))) {										
										String resolved = JSAStrings.v().getRegex(ie.getArg(arg));
										//check if constant?
										if (JSAStrings.v().ignoreRE(resolved) || !JSAStrings.v().isConstant(ie.getArg(arg))) {
											logger.info("FilePrecisionTransforms failed: argument to call not contant JSA: {} {} {} {}", 
													stmt, arg, resolved, SootUtils.getSourceLocation(stmt));
											return false;
										}
										//constant value!
										concat += ("/" + resolved);

									} else {
										//not a jsa tracked value?
										logger.info("FilePrecisionTransforms failed: argument to call not tracked by JSA: {} {} {}", 
												stmt, arg, SootUtils.getSourceLocation(stmt));
										return false;
									}

								} else if (ie.getArg(arg).getType().equals(RefType.v("java.io.File"))) {
									logger.info("FilePrecisionTransforms failed: argument is java.io.File not supported: {} {} {}", 
											stmt, arg, SootUtils.getSourceLocation(stmt));
									return false;
								} else {
									logger.info("FilePrecisionTransforms failed: argument type not supported: {} {} {}", 
											stmt, arg, SootUtils.getSourceLocation(stmt));
									return false;
								}

								//if we get here, all constants are ready to xform
								//get clone or make it based on concat of strings
								//generate JimpleTransform
								SootClass clone = getClone(concat, directive.steam_type);								
								if (clone == null) {
									logger.info("FilePrecisionTransforms failed: cloner returned null!", 
											stmt, arg, SootUtils.getSourceLocation(stmt));
									return false;
								}						

								JimpleTransform jTransform = new JimpleTransform();
								jTransform.m = m;								
								if (stmt instanceof AssignStmt) {
									AssignStmt assign = (AssignStmt)stmt;
									if (assign.getRightOp() instanceof InvokeExpr) {
										jTransform.insertAfter = stmt;
										jTransform.deleteTheseStmts.add(stmt);
										
										//create new object
										jTransform.newStmts.add(Jimple.v().newAssignStmt(
												((AssignStmt)stmt).getLeftOp(), 
												Jimple.v().newNewExpr(clone.getType())));
										//call constructor
										jTransform.newStmts.add(Jimple.v().newInvokeStmt(Jimple.v().newSpecialInvokeExpr((Local)((AssignStmt)stmt).getLeftOp(), 
												clone.getMethod("void <init>(java.lang.String)").makeRef(), 
												StringConstant.v(concat))));	
									} else if (assign.getRightOp() instanceof NewExpr) {
										//has to be of type FileInputStream or FileOutputStream based on the 
										//methods are transforming
										jTransform.insertAfter = stmt;
										
										//delete old new expr assign
										jTransform.deleteTheseStmts.add(stmt);
										//delete old constructor call, we assign the constructor call comes right after the new expression
										//but we should check for it
										Stmt constructorCall = (Stmt)stmtBody.getUnits().getSuccOf(stmt);
										if ((!constructorCall.containsInvokeExpr()) || (!(constructorCall.getInvokeExpr() instanceof SpecialInvokeExpr)) ||
												(!(constructorCall.getInvokeExpr().getMethodRef().getSubSignature().getString().startsWith("void <init>")))) {
											logger.info("FilePrecisionTransforms failed: unsupported next statement of new expression for File*Stream: {} {}", 
													stmt, SootUtils.getSourceLocation(stmt));
											return false;
										}
										jTransform.deleteTheseStmts.add(constructorCall);
											
										//create new object
										jTransform.newStmts.add(Jimple.v().newAssignStmt(
												assign.getLeftOp(), 
												Jimple.v().newNewExpr(clone.getType())));
										
										//call constructor, build arguments
										List<Value> newArgs = new LinkedList<Value>();
										newArgs.addAll(constructorCall.getInvokeExpr().getArgs());
										InvokeExpr newConstructorInvoke = Jimple.v().newSpecialInvokeExpr((Local)assign.getLeftOp(), 
												clone.getMethod(constructorCall.getInvokeExpr().getMethodRef().getSubSignature()).makeRef(), 
												newArgs);
										
										jTransform.newStmts.add(Jimple.v().newInvokeStmt(newConstructorInvoke));	
									} else {
										logger.info("FilePrecisionTransforms failed: unsupported RHS of assignment: {} {}", 
												stmt, SootUtils.getSourceLocation(stmt));
										return false;
									}
								} else {
									logger.info("FilePrecisionTransforms failed: stmt not an assignment: {} {}", 
											stmt, SootUtils.getSourceLocation(stmt));
									return false;
								}
								//add changes to list and keep going...
								changes.add(jTransform);
							}
						}
					}
				}
			}
		}
		return true;
	}

	/**
	 * Given a constant file name, return the cloned FileInputStream or FileOutputStream (depends
	 * on type argument).  Create the pair if necessary and link the reader to the writer 
	 * for this file name.
	 */
	private SootClass getClone(String fileName, STREAM_TYPE type) {
		//create file input and output at same time...
		if (!fileNameToInputOutputClass.containsKey(fileName)) {
			try {
				SootClass[] clones = new SootClass[2];

				ClassCloner outputCloner = ClassCloner.cloneClassAndCloneMethodsAndFields(Scene.v().getSootClass("droidsafe.concrete.DroidSafeFileOutputStream"));
				clones[STREAM_TYPE.OUTPUT.ordinal()] = outputCloner.getClonedClass();
				//create field in the output for the TAINT
				SootField taintField = new SootField("TAINT", IntType.v(), Modifier.PUBLIC | Modifier.STATIC);
				outputCloner.getClonedClass().addField(taintField);
				//change the write(int) method to set the close class field instead of the DroidSafeAndroidRuntime all file system taint field
				{
					SootMethod writeMethod = outputCloner.getClonedClass().getMethod("void write(int)");
					Body writeBody = writeMethod.retrieveActiveBody();
					Iterator<Unit> writeMethodStmts = writeBody.getUnits().snapshotIterator();
					AssignStmt assignStmt = null;
					//ug, search for first (and only) assignment!
					while (writeMethodStmts.hasNext()) {
						Stmt current = (Stmt)writeMethodStmts.next();
						if (current instanceof AssignStmt) {
							assignStmt = (AssignStmt)current;
							break;
						}
					}
					assignStmt.setLeftOp(Jimple.v().newStaticFieldRef(taintField.makeRef()));
				}

				//must change the DroidSafeFileInputStream
				ClassCloner inputCloner = ClassCloner.cloneClassAndCloneMethodsAndFields(Scene.v().getSootClass("droidsafe.concrete.DroidSafeFileInputStream"));
				clones[STREAM_TYPE.INPUT.ordinal()] = inputCloner.getClonedClass();

				//link reader to writer's taint field in the clone pair
				//by changing the read() method in the FileInputStream to read the TAINT field of the FileOutputStream
				{
					SootMethod readMethod = inputCloner.getClonedClass().getMethod("int read()");
					Body readBody = readMethod.retrieveActiveBody();
					Iterator<Unit> stmts = readBody.getUnits().snapshotIterator();

					StaticFieldRef taintRef = Jimple.v().newStaticFieldRef(outputCloner.getClonedClass().getFieldByName("TAINT").makeRef());

					AssignStmt taintAssign = null;
					while (stmts.hasNext()) {
						Stmt current = (Stmt)stmts.next();
						if (current instanceof AssignStmt) {
							taintAssign = (AssignStmt)current;
							break;
						}
					}
					taintAssign.setRightOp(taintRef);
				}

				fileNameToInputOutputClass.put(fileName, clones);
			} catch (Exception e) {
				logger.info("FilePrecisionTransforms failed: could not create clones of Streams ", e);
				return null;
			}
		} 

		return fileNameToInputOutputClass.get(fileName)[type.ordinal()];			
	}

	enum STREAM_TYPE {
		INPUT, OUTPUT
	}

	/**
	 * Defines a transformation on the Jimple IR.  A list of statements to insert in a method
	 * at a point.  Optionally delete original statement.
	 * 
	 * @author mgordon
	 *
	 */
	class JimpleTransform {
		SootMethod m;
		Stmt insertAfter;
		List<Unit> deleteTheseStmts = new LinkedList<Unit>();
		List<Unit> newStmts = new LinkedList<Unit>();;

		/**
		 * Apply this transform and change the IR.
		 */
		public void applyTransform() {
			m.retrieveActiveBody().getUnits().insertAfter(newStmts, insertAfter);

			for (Unit delete : deleteTheseStmts) {		 			
				m.retrieveActiveBody().getUnits().remove(delete);
			}
		}

		@Override
		public String toString() {
			return "JimpleTransform " + m + " " + insertAfter + " -> " + Arrays.toString(newStmts.toArray());
		}

	}

	class FileStreamTransformDirective {
		String sig;
		String prefix;
		int[] argsToConcat;
		STREAM_TYPE steam_type;

		public FileStreamTransformDirective(String sig, String prefix, int[] argsToConcat, STREAM_TYPE steam_type) {
			super();
			this.sig = sig;
			this.prefix = prefix;
			this.argsToConcat = argsToConcat;
			this.steam_type = steam_type;
		}	

	}

	private FileStreamTransformDirective findTransformTarget(Set<SootMethod> methods) {
		for (SootMethod method : methods) {
			String signature = method.getSignature();
			for (FileStreamTransformDirective directive : transformDirectives) {
				if (directive.sig.equals(signature))
					return directive;
			}
		}
		return null;
	}

	public void createTransforms() {
		transformDirectives = new LinkedList<FileStreamTransformDirective>();	

		transformDirectives.add(new FileStreamTransformDirective
				("<android.content.Context: java.io.FileInputStream openFileInput(java.lang.String)>", "<files-dir>", new int[]{0}, STREAM_TYPE.INPUT));
		transformDirectives.add(new FileStreamTransformDirective
				("<android.content.ContextWrapper: java.io.FileInputStream openFileInput(java.lang.String)>", "<files-dir>", new int[]{0}, STREAM_TYPE.INPUT));
		transformDirectives.add(new FileStreamTransformDirective
				("<android.app.ContextImpl: java.io.FileInputStream openFileInput(java.lang.String)>", "<files-dir>", new int[]{0}, STREAM_TYPE.INPUT));

		transformDirectives.add(new FileStreamTransformDirective
				("<android.content.Context: java.io.FileOutputStream openFileOutput(java.lang.String,int)>","<files-dir>", new int[]{0}, STREAM_TYPE.OUTPUT));
		transformDirectives.add(new FileStreamTransformDirective
				("<android.content.ContextWrapper: java.io.FileOutputStream openFileOutput(java.lang.String,int)>","<files-dir>", new int[]{0}, STREAM_TYPE.OUTPUT));
		transformDirectives.add(new FileStreamTransformDirective
				("<android.app.ContextImpl: java.io.FileOutputStream openFileOutput(java.lang.String,int)>","<files-dir>", new int[]{0}, STREAM_TYPE.OUTPUT));

		//constructors for file input stream / file output stream			
		transformDirectives.add(new FileStreamTransformDirective
				("<java.io.FileInputStream: void <init>(java.io.File)>", "", new int[]{0}, STREAM_TYPE.INPUT));
		transformDirectives.add(new FileStreamTransformDirective
				("<java.io.FileInputStream: void <init>(java.lang.String)>", "", new int[]{0}, STREAM_TYPE.INPUT));

		transformDirectives.add(new FileStreamTransformDirective
				("<java.io.FileOutputStream: void <init>(java.lang.String)>", "", new int[]{0}, STREAM_TYPE.OUTPUT));
		transformDirectives.add(new FileStreamTransformDirective
				("<java.io.FileOutputStream: void <init>(java.io.File)>", "", new int[]{0}, STREAM_TYPE.OUTPUT));
		transformDirectives.add(new FileStreamTransformDirective
				("<java.io.FileOutputStream: void <init>(java.io.File,boolean)>", "", new int[]{0}, STREAM_TYPE.OUTPUT));
		transformDirectives.add(new FileStreamTransformDirective
				("<java.io.FileOutputStream: void <init>(java.lang.String,boolean)>", "", new int[]{0}, STREAM_TYPE.OUTPUT));

		/*  Need to change modeling for this?
		 * java.io.RandomAccessFile(java.io.File, java.lang.String)
		 * java.io.RandomAccessFile(java.lang.String, java.lang.String)
		 * 
		 * public java.io.FileInputStream createInputStream() throws java.io.IOException;
		 * public java.io.FileOutputStream createOutputStream() throws java.io.IOException;
		 * 
		 * 
		 */
	}

}
