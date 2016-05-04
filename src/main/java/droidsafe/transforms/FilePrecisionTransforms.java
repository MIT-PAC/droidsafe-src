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
import soot.Local;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.AssignStmt;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.NewExpr;
import soot.jimple.ReturnStmt;
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
	private Set<String> sigsOfInvokesToTransform;
	private Map<String,SootClass[]> fileNameToInputOutputClass;
	private Set<SootClass> failIfTheseAreCreated;
	private List<FileStreamTransformDirective> transforms;

	private static FilePrecisionTransforms v;

	public static FilePrecisionTransforms v() {
		if (v == null)
			v = new FilePrecisionTransforms();

		return v;
	}

	public void run() {
		if (bannedClassesCreated())
			return;

		//transform
		List<JimpleTransform> changes = new LinkedList<JimpleTransform>();
		boolean success = transform(changes);
		if (success) {
			//apply changes
			for (JimpleTransform jt : changes) {
				System.out.println(jt);
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

	private boolean transform(List<JimpleTransform> changes) {
		for (SootClass clz : Scene.v().getClasses()) {
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
								if (clone == null)
									return false;

								List<Stmt> newStmts = new LinkedList<Stmt>();
								
								JimpleTransform jTransform = new JimpleTransform();
								jTransform.m = m;
								jTransform.originalStmt = stmt;
								if (stmt instanceof AssignStmt) {
									jTransform.deleteOriginalStmt = true;
									//create new object
									newStmts.add(Jimple.v().newAssignStmt(
											((AssignStmt)stmt).getLeftOp(), 
											Jimple.v().newNewExpr(clone.getType())));
									//call constructor
									newStmts.add(Jimple.v().newInvokeStmt(Jimple.v().newSpecialInvokeExpr((Local)((AssignStmt)stmt).getLeftOp(), 
											clone.getMethod("<init>(java.lang.String)").makeRef(), 
											StringConstant.v(concat))));								
								} else {
									//??
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

				//must change the DroidSafeFileInputStream
				ClassCloner inputCloner = ClassCloner.cloneClassAndCloneMethodsAndFields(Scene.v().getSootClass("droidsafe.concrete.DroidSafeFileInputStream"));
				clones[STREAM_TYPE.OUTPUT.ordinal()] = inputCloner.getClonedClass();
				SootMethod readMethod = inputCloner.getClonedClass().getMethod("int read()");
				Iterator<Unit> stmts = readMethod.retrieveActiveBody().getUnits().snapshotIterator();
				Stmt readReturn = null;
				while (stmts.hasNext()) {
					readReturn = (Stmt)stmts.next();
					if (readReturn instanceof ReturnStmt)
						break;
				}
				//link reader to writer's taint field
				((ReturnStmt)readReturn).setOp(Jimple.v().newStaticFieldRef(outputCloner.getClonedClass().getFieldByName("TAINT").makeRef()));
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

	class JimpleTransform {
		SootMethod m;
		Stmt originalStmt;
		boolean deleteOriginalStmt;
		List<Stmt> newStmts;
		
		@Override
		public String toString() {
			return "JimpleTransform " + m + " " + originalStmt + " -> " + Arrays.toString(newStmts.toArray());
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
			for (FileStreamTransformDirective directive : transforms) {
				if (directive.sig.equals(signature))
					return directive;
			}
		}
		return null;
	}

	public void createTransforms() {
		transforms = new LinkedList<FileStreamTransformDirective>();	

		transforms.add(new FileStreamTransformDirective
				("<android.content.Context: java.io.FileInputStream openFileInput(java.lang.String)>", "<files-dir>", new int[]{0}, STREAM_TYPE.INPUT));
		transforms.add(new FileStreamTransformDirective
				("<android.content.ContextWrapper: java.io.FileInputStream openFileInput(java.lang.String)>", "<files-dir>", new int[]{0}, STREAM_TYPE.INPUT));
		transforms.add(new FileStreamTransformDirective
				("<android.app.ContextImpl: java.io.FileInputStream openFileInput(java.lang.String)>", "<files-dir>", new int[]{0}, STREAM_TYPE.INPUT));

		transforms.add(new FileStreamTransformDirective
				("<android.content.Context: java.io.FileOutputStream openFileOutput(java.lang.String,int)>","<files-dir>", new int[]{0}, STREAM_TYPE.OUTPUT));
		transforms.add(new FileStreamTransformDirective
				("<android.content.ContextWrapper: java.io.FileOutputStream openFileOutput(java.lang.String,int)>","<files-dir>", new int[]{0}, STREAM_TYPE.OUTPUT));
		transforms.add(new FileStreamTransformDirective
				("<android.app.ContextImpl: java.io.FileOutputStream openFileOutput(java.lang.String,int)>","<files-dir>", new int[]{0}, STREAM_TYPE.OUTPUT));

		//constructors for file input stream / file output stream			

		/* public java.io.FileInputStream(java.io.File) throws java.io.FileNotFoundException;
		 * public java.io.FileInputStream(java.io.FileDescriptor);
		 * public java.io.FileInputStream(java.lang.String) throws java.io.FileNotFoundException;
		 * 
		 * public java.io.FileOutputStream(java.io.File) throws java.io.FileNotFoundException;
		 * public java.io.FileOutputStream(java.io.File, boolean) throws java.io.FileNotFoundException;
		 * public java.io.FileOutputStream(java.io.FileDescriptor);
		 * public java.io.FileOutputStream(java.lang.String) throws java.io.FileNotFoundException;
		 * public java.io.FileOutputStream(java.lang.String, boolean) throws java.io.FileNotFoundException;
		 * 
		 *  Need to change modeling for this?
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
