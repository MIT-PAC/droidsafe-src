package droidsafe.transforms;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.Local;
import soot.RefLikeType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;
import soot.Value;
import soot.ValueBox;
import soot.jimple.AssignStmt;
import soot.jimple.CastExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.StaticFieldRef;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.util.Chain;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.system.API;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.SootUtils;

/**
 * 
 * 
 * @author mgordon
 *
 */
public class InsertUnmodeledObjects {
    private final static Logger logger = LoggerFactory.getLogger(InsertUnmodeledObjects.class);
    /** Static singleton */
    private static InsertUnmodeledObjects v;

    private InsertUnmodeledObjects() {
        // TODO Auto-generated constructor stub
    }

    /**
     * return static singleton
     */
    public static InsertUnmodeledObjects v() {
        if (v == null)
            v = new InsertUnmodeledObjects();

        return v;
    }

    /**
     * Run transformation to insert dummy object with UNKNOWN taint at all api method that return a 
     * reference with an empty points to set.
     */
    public void run() {
        findAPICallsWithNullReturnValues();
    }

    /**
     * Search all reachable methods in user code for api calls that return a value with an empty pt set.
     */
    private void findAPICallsWithNullReturnValues() {
        List<SootClass> classes = new LinkedList<SootClass>();
        classes.addAll(Scene.v().getClasses());
        for (SootClass clz : classes) {

            for (SootMethod method : clz.getMethods()) {
                if (API.v().isSystemMethod(method))
                    continue;

                if (method.isPhantom() || method.isAbstract() || !method.isConcrete())
                    continue;

                if (!PTABridge.v().isReachableMethod(method))
                    continue;


                Body body = method.getActiveBody();
                StmtBody stmtBody = (StmtBody)body;
                Chain units = stmtBody.getUnits();
                Iterator stmtIt = units.snapshotIterator();

                while (stmtIt.hasNext()) {
                    Stmt stmt = (Stmt)stmtIt.next();

                    if (stmt instanceof AssignStmt) {
                        AssignStmt assign = (AssignStmt) stmt;
                        if (assign.getRightOp() instanceof InvokeExpr) {
                            boolean hasAPITarget = false;
                            InvokeExpr invoke = (InvokeExpr)assign.getRightOp();

                            //don't care if the return type is a primitive
                            if (!(invoke.getMethodRef().returnType() instanceof RefLikeType))
                                continue;            

                            try {
                                Collection<SootMethod> targets = PTABridge.v().resolveInvokeIns(invoke);
                                for (SootMethod target : targets) 
                                    if (API.v().isSystemMethod(target)) {
                                        hasAPITarget = true;
                                        break;
                                    }
                            } catch (CannotFindMethodException e) {

                            }


                            if (hasAPITarget) {
                                //we have a method that could target the api, now see if the return value has 
                                //anything in its pt set
                                if (PTABridge.v().getPTSetIns(assign.getLeftOp()).isEmpty()) {
                                    addUnmodeledObject(assign, method);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    private Type findCast(SootMethod method, Stmt start, Value v) {
        Body body = method.getActiveBody();
        StmtBody stmtBody = (StmtBody)body;
        Chain units = stmtBody.getUnits();
        Iterator stmtIt = units.iterator(start);

        while (stmtIt.hasNext()) {
            Stmt stmt = (Stmt)stmtIt.next();
            
            if (stmt.branches())
                return null;
            
            for (ValueBox vb : stmt.getUseBoxes()) {
                if (vb.getValue() instanceof CastExpr) {
                    CastExpr ce = (CastExpr)vb.getValue();
                    if (ce.getOp().equals(v)) {
                        logger.info("Found cast of {} in {} to {}", v, method, ce.getCastType());
                        return ce.getCastType();
                    }
                }
            }
        }
        
        return null;
    }
    
    /**
     * Insert assignment to the dummy object from the dummy class's field that corresponds to 
     * the type of the return value of the rhs of the assignment.
     */
    private void addUnmodeledObject(AssignStmt stmt, SootMethod method) {
        InvokeExpr invoke = stmt.getInvokeExpr();
        SootMethodRef target = invoke.getMethodRef();
        Body body = method.getActiveBody();
        
        //try to find a cast to narrow type
        Type castType = findCast(method, stmt, stmt.getLeftOp());
        Type returnType = target.returnType();
        Type type;
        
        if (castType != null) {
            if (!SootUtils.isSubTypeOfIncluding(castType, returnType)) {
                logger.info("Could not use cast type because not child of return type {} {}", castType, returnType);
                type = returnType;
            } else {
                type = castType;
            }            
        } else 
            type = returnType;
            
        
        Value newObj = UnmodeledGeneratedClasses.v().getSootFieldForType(type);
        
        if (newObj instanceof StaticFieldRef && stmt.getLeftOp() instanceof Local) {
            StaticFieldRef fr = (StaticFieldRef)newObj;
            
            //insert assignment statement 
            //assign.getLeft() = fr;
            Stmt insertMe = Jimple.v().newAssignStmt(stmt.getLeftOp(), fr);
            body.getUnits().insertAfter(insertMe, stmt);
            logger.info("Inserting object with {} after {} for {}", insertMe, stmt, method);
        }
    }
}
