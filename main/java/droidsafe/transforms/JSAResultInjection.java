package droidsafe.transforms;

import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.strings.JSAStrings;
import droidsafe.android.app.Project;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

import soot.Body;
import soot.BodyTransformer;
import soot.jimple.AssignStmt;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.StringConstant;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.spark.pag.ClassConstantNode;
import soot.Local;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.util.Chain;
import soot.Value;

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
    public static Set<StringConstant> createdStringConstants = new HashSet<StringConstant>();

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
     * Tranform method called on the body that will find all invoke expressions, and
     * if an arg is a string constant, will create a new local for the constant, 
     * and replace the constant in the argument with the local.
     */
    protected void internalTransform(Body b, String phaseName, Map options)  {
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

            InvokeExpr expr = (InvokeExpr)stmt.getInvokeExpr();
            Map<Integer, Value> argMod = new HashMap<Integer, Value>();

            //see if we should perform any outright replacements, and if so, don't do a jsa injection
            if (replaceInvokeExpr(stmtBody, units, stmt))
                continue;

            //iterate over the args and see if any arg is a string constant
            for (int i = 0; i < expr.getArgCount(); i++) {
                Value v = expr.getArg(i);
                if (JSAStrings.v().isHotspotValue(v)) {
                    //add a local variable
                    Local arg = Jimple.v().newLocal(LOCAL_PREFIX + LOCALID++, RefType.v("java.lang.String"));
                    stmtBody.getLocals().add(arg);

                    //add an assignment of the local to the string constant
                    //right before the call
                    StringConstant sc = StringConstant.v(JSAStrings.v().getRegex(v));
                    createdStringConstants.add(sc);
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
     * We might want to transform certain statements to make Value Analysis resolve better.  Do
     * that here, and then the jsa injection will not be performed in the above method.
     * 
     * return true if a transform was performed.
     */
    private boolean replaceInvokeExpr(StmtBody stmtBody, Chain units, Stmt stmt) {
        if (!(stmt instanceof AssignStmt) || !(((AssignStmt)stmt).getRightOp() instanceof InvokeExpr))
            return false;

        AssignStmt assign = (AssignStmt)stmt;
        InvokeExpr invoke = (InvokeExpr)assign.getRightOp();
        try {
            Collection<SootMethod> targets = GeoPTA.v().resolveInvokeContextIns(invoke);

            if (targets.size() != 1)
                return false;
            
            //if we get here we have one target
            for (SootMethod target : targets) {
                //replace java.lang.Class.getName() with a string constant if possible
                if ("<java.lang.Class: java.lang.String getName()>".equals(target.getSignature())) {
                    InstanceInvokeExpr iie = (InstanceInvokeExpr) invoke;
                    Set<AllocNode> nodes = GeoPTA.v().getPTSetContextIns(iie.getBase());
                    if (nodes.size() != 1) 
                        return false;
                            
                    for (AllocNode node : nodes) {
                        if (node instanceof ClassConstantNode) {
                            String name = ((ClassConstantNode)node).getClassConstant().toString();
                            
                            //add a local variable
                            Local newLocal = Jimple.v().newLocal(LOCAL_PREFIX + LOCALID++, RefType.v("java.lang.String"));
                            stmtBody.getLocals().add(newLocal);
                            
                            StringConstant sc = StringConstant.v(name);
                            createdStringConstants.add(sc);
                            AssignStmt localAssign = Jimple.v().newAssignStmt(newLocal, sc);
                            units.insertBefore(localAssign, stmt);
                            assign.setRightOp(newLocal);
                            return true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            
        }
        
        return false;
    }
}

