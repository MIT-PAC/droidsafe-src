package droidsafe.transforms;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.app.Harness;
import droidsafe.utils.SootUtils;
import soot.ArrayType;
import soot.Body;
import soot.Local;
import soot.RefType;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Value;
import soot.ValueBox;
import soot.jimple.AssignStmt;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.internal.JGotoStmt;
import soot.jimple.internal.JIfStmt;
import soot.util.Chain;

public class TransformsUtils {
    /** logger object */
    private static final Logger logger = LoggerFactory.getLogger(TransformsUtils.class);

    private static int uniqueID = 0;
    
    private TransformsUtils() {
        // TODO Auto-generated constructor stub
    }



    /**
     * Given the assignment statement that includes the new expression, find the associated constructor call
     * that is called on the local value.  This method will search starting from the assignment, and conservatively
     * find the constructor call.  Will return null if a constructor is not found.
     */
    public static Stmt findConstructorCall(SootMethod method, Stmt startStmt, Set<Local> locals) {
        //loop through all instructions in method and find the special invoke on this allocnode
        Body body = method.getActiveBody();
        StmtBody stmtBody = (StmtBody)body;
        Chain units = stmtBody.getUnits();
        Iterator stmtIt = units.iterator(startStmt);

        while (stmtIt.hasNext()) {
            Stmt stmt = (Stmt)stmtIt.next();

            if (stmt.containsInvokeExpr() && stmt.getInvokeExpr() instanceof SpecialInvokeExpr) {
                SpecialInvokeExpr si = (SpecialInvokeExpr) stmt.getInvokeExpr();
                if (locals.contains(si.getBase()))
                    return stmt;
            }

            //assigning local to new local, remember lhs
            if (stmt instanceof AssignStmt &&
                    locals.contains(((AssignStmt)stmt).getRightOp()) &&
                    ((AssignStmt)stmt).getLeftOp() instanceof Local) {

                locals.add((Local) ((AssignStmt)stmt).getLeftOp());
                continue;
            }

            //check
            //value has been redefined before we found a constructor, so we can't find anything!
            for (ValueBox def : stmt.getDefBoxes()) {
                if (locals.contains(def.getValue())) {
                    //System.out.println("Failed on can contain value: " + stmt);
                    return null;
                }

            }

            //now account for some jumps, and if constructs
            if (stmt instanceof JGotoStmt) {
                //recurse into goto statements

                //but only go forward...to avoid loops
                if (!units.follows((Stmt)((JGotoStmt) stmt).getTarget(), stmt))
                    return null;

                return findConstructorCall(method, (Stmt)((JGotoStmt) stmt).getTarget(), locals);
            } else if (stmt instanceof JIfStmt) {
                if (!units.follows((Stmt)((JIfStmt) stmt).getTarget(), stmt))
                    return null;

                //recurse into if statement target and fall through
                Stmt trueBranch = findConstructorCall(method, ((JIfStmt) stmt).getTarget(), locals); 
                Stmt falseBranch = findConstructorCall(method, (Stmt)units.getSuccOf(stmt), locals); 

                if (trueBranch == falseBranch)
                    return trueBranch;
                else 
                    return null;
            } 
        }

        return null;
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

    /**
     * add a constructor call to body for the given reftype.  Use the simpliest constructor
     * that can be found.
     */
    public static List<Stmt> getConstructorCall(Body body, Local local, RefType type) {
        SootClass clazz = type.getSootClass();
        List<Stmt> stmts = new LinkedList<Stmt>();

        //add the call to the constructor with its args
        SootMethod constructor = SootUtils.findSimpliestConstructor(clazz);


        if (constructor == null) {
            logger.warn("Cannot find constructor for {}.  Not going to call constructor.", clazz);
            return stmts;
        }

        //create list of dummy arg values for the constructor call, right now all constants
        List<Value> args = new LinkedList<Value>();
        for (Type argType : constructor.getParameterTypes()) {
            //for inner classes of components, we can use the field in the harness if it is of the right type
            //for the argument
            if (argType instanceof RefType && Harness.v().hasCreatedField(((RefType)argType).getSootClass())) {
                Local tempLocal = Jimple.v().newLocal("inner_local" + uniqueID++, argType);
                body.getLocals().add(tempLocal);
                stmts.add(Jimple.v().newAssignStmt(
                    tempLocal, 
                    Jimple.v().newStaticFieldRef
                        (Harness.v().getFieldForCreatedClass(((RefType)argType).getSootClass()).makeRef())));
                args.add(tempLocal);
            } else {
                logger.warn("Need to create dummy value for type, but no no-arg constructor: {}", clazz);
                args.add(SootUtils.getNullValue(argType));
            }
        }

        //add constructor call to body nested in invoke statement
         stmts.add(Jimple.v().newInvokeStmt(Jimple.v().newSpecialInvokeExpr(local, constructor.makeRef(), args)));
         return stmts;
    }
}
