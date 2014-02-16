package droidsafe.transforms;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.strings.JSAStrings;
import droidsafe.analyses.value.ValueAnalysis;
import droidsafe.analyses.value.VAResultContainerClassGenerator;
import droidsafe.android.app.Project;
import droidsafe.utils.SootUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import soot.Body;
import soot.BodyTransformer;
import soot.jimple.AssignStmt;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.StringConstant;
import soot.jimple.spark.pag.StringConstantNode;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.Local;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.util.Chain;
import soot.Value;
import soot.ValueBox;

/**
 * Tranformer called on all application classes that will find all invoke expressions, and
 * if an arg is a string constant, will create a new local for the constant, 
 * and replace the constant in the argument with the local.  Needed for points to analysis.
 * 
 * @author dpetters
 *
 */
public class JSAResultInjection extends BodyTransformer {
    private static int LOCALID = 0;
    public static final String LOCAL_PREFIX = "JSA_INJ_STRING_ARG";
    public static Map<InvokeExpr, Map<Integer, Value>> changesMade = new HashMap<InvokeExpr, Map<Integer, Value>>();
    /** Set of string constants that VA will track */
    public static Set<StringConstant> trackedStringConstants = new HashSet<StringConstant>();
    /** list of classes resolved by VA */
    public static final Set<SootClass> VA_RESOLVED_CLASSES = 
         VAResultContainerClassGenerator.getClassesAndFieldsToModel(false).keySet();

    /**
     * Call this pass on all application classes in the project.
     */
    public static void run() {
        JSAResultInjection transformer = new JSAResultInjection();
        for (SootClass clz : Scene.v().getClasses()) {
            for (SootMethod meth : clz.getMethods()) {
                if (meth.isConcrete())
                    transformer.transform(meth.retrieveActiveBody());
            }
        }
    }
    
    /**
     * Return true if we should track string constants from this class.
     */
    private boolean shouldTrackStringValue(SootClass clz) {
        Set<SootClass> baseClassesToModel = ValueAnalysis.baseClassesToModel();
        //check class directly
        
        if (baseClassesToModel.contains(clz))
            return true; 

        //if not directly contained, now check parents
        for (SootClass parent : SootUtils.getParents(clz)) {
            if (!parent.isInterface() && baseClassesToModel.contains(parent)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Tranform method called on the body that will find all invoke expressions, and
     * if an arg is a string constant, will create a new local for the constant, 
     * and replace the constant in the argument with the local.
     */
    protected void internalTransform(Body b, String phaseName, Map options)  {
        SootMethod enclosingMethod = b.getMethod();
        
        boolean isVATrackedClass = shouldTrackStringValue(enclosingMethod.getDeclaringClass());
        
        StmtBody stmtBody = (StmtBody)b;

        // get body's unit as a chain
        Chain units = stmtBody.getUnits();

        // get a snapshot iterator of the unit since we are going to
        // mutate the chain when iterating over it.
        Iterator stmtIt = units.snapshotIterator();

        while (stmtIt.hasNext()) {

            Stmt stmt = (Stmt)stmtIt.next();

            if (!stmt.containsInvokeExpr()) {
                continue;
            }
            
            //add all string constants from va tracked classes, but not from other API classes
            //because this is too aggressive
            if (isVATrackedClass) {
                for (Object valueBox : stmt.getUseAndDefBoxes()) {
                    if (valueBox instanceof ValueBox) {
                        Value value = ((ValueBox)valueBox).getValue();
                        if (value instanceof StringConstant) {
                            trackedStringConstants.add((StringConstant)value);
                        }
                    }
                }
                    
            }

            InvokeExpr expr = (InvokeExpr)stmt.getInvokeExpr();
            Map<Integer, Value> argMod = new HashMap<Integer, Value>();

            //iterate over the args and see if any arg is a string constant
            for (int i = 0; i < expr.getArgCount(); i++) {
                Value v = expr.getArg(i);
                //don't do a injection of the hotspot value if it is all constants anyway...
                if (v != null && JSAStrings.v().isHotspotValue(v)) {
                    
                    if (allStringConstants(v)) {
                        continue;
                    }
                    
                    //add a local variable
                    Local arg = Jimple.v().newLocal(LOCAL_PREFIX + LOCALID++, RefType.v("java.lang.String"));
                    stmtBody.getLocals().add(arg);

                    //add an assignment of the local to the string constant
                    //right before the call
                    StringConstant sc = StringConstant.v(JSAStrings.v().getRegex(v));
                    trackedStringConstants.add(sc);
                    AssignStmt assignStmt = Jimple.v().newAssignStmt(arg, sc);
                    units.insertBefore(assignStmt, stmt);

                    //replace the string constant with the local in the call
                    argMod.put(i, v);
                    expr.setArg(i, arg);
                }
            }
            changesMade.put(expr, argMod);            
        }
    }
    
    /**
     * Return true if all allocnodes that v can reference are string constants
     */
    private boolean allStringConstants(Value v) {
        if (v instanceof StringConstant)
            return true;
        
        if (!PTABridge.v().isPointer(v))
            return false;
        
        for (IAllocNode node : PTABridge.v().getPTSet(v)) {
            if (!(node instanceof StringConstantNode)) 
                return false;
        }
        
        return true;
    }
}
