package droidsafe.transforms;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.app.Project;
import droidsafe.utils.JimpleRelationships;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.BodyTransformer;
import soot.jimple.AssignStmt;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.jimple.toolkits.pta.IClassConstantNode;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.StringConstant;
import soot.Local;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.util.Chain;

/**
 * Tranformer called on all application classes that will find all invocations of Class.getName on class constants and 
 * replace them with the string name of the class.
 * 
 * @author dpetters
 */

public class ClassGetNameToClassString extends BodyTransformer {
    private static int LOCAL_ID = 0;
    private static final String LOCAL_PREFIX = "_$CLASSGETNAME_TO_CLASSNAMESTR_LOCAL";
    /** logger object */
    private static final Logger logger = LoggerFactory.getLogger(ClassGetNameToClassString.class);
    /**
     * Call this pass on all application classes in the project.
     */
    public static void run() {
        ClassGetNameToClassString transformer = new ClassGetNameToClassString();
        for (SootClass clz : Scene.v().getClasses()) {
            for (SootMethod meth : clz.getMethods()) {
                if (meth.isConcrete())
                    transformer.transform(meth.retrieveActiveBody());
            }
        }
    }
    
    protected void internalTransform(Body b, String phaseName, Map options)  {
        StmtBody stmtBody = (StmtBody)b;
        // get body's unit as a chain
        Chain units = stmtBody.getUnits();
        // get a snapshot iterator of the unit since we are going to mutate the chain when iterating over it.
        Iterator stmtIt = units.snapshotIterator();

        while (stmtIt.hasNext()) {
            Stmt stmt = (Stmt)stmtIt.next();
            if (!stmt.containsInvokeExpr()) {
                continue;
            }
            //see if we should perform any outright replacements, and if so, don't do a jsa injection
            if (replaceClassGetNameWithClassString(stmtBody, units, stmt))
                continue;
        }
    }

    private boolean replaceClassGetNameWithClassString(StmtBody stmtBody, Chain units, Stmt stmt) {
        if (!(stmt instanceof AssignStmt) || !(((AssignStmt)stmt).getRightOp() instanceof InvokeExpr))
            return false;

        AssignStmt assign = (AssignStmt)stmt;
        InvokeExpr invoke = (InvokeExpr)assign.getRightOp();
        try {
            Collection<SootMethod> targets = PTABridge.v().getTargetsInsNoContext(JimpleRelationships.v().getEnclosingMethod(stmt), stmt);

            if (targets.size() != 1)
                return false;
            
            //if we get here we have one target
            for (SootMethod target : targets) {
                //replace java.lang.Class.getName() with a string constant if possible
                if ("<java.lang.Class: java.lang.String getName()>".equals(target.getSignature())) {
                    InstanceInvokeExpr iie = (InstanceInvokeExpr) invoke;
                    Set<? extends IAllocNode> nodes = PTABridge.v().getPTSetIns(iie.getBase());
                    for(IAllocNode node : nodes) {
                        if (!(node instanceof IClassConstantNode))
                            return false;
                    }
    
                    // add a local variable
                    Local newLocal = Jimple.v().newLocal(LOCAL_PREFIX + LOCAL_ID++, RefType.v("java.lang.String"));
                    stmtBody.getLocals().add(newLocal);
                           
                    for (IAllocNode node : nodes) {
                        String name = ((IClassConstantNode)node).getClassConstant().getValue().replace("/", ".");
                        StringConstant sc = StringConstant.v(name);
                        JSAResultInjection.trackedStringConstants.add(sc);
                        AssignStmt localAssign = Jimple.v().newAssignStmt(newLocal, sc);
                        units.insertBefore(localAssign, stmt);
                        assign.setRightOp(newLocal);
                    }
                    return true;
                }
            }
        } catch (Exception e) {
            logger.error("Something wrong, ignoring: ", e);
        }
        
        return false;
    }
}
