package droidsafe.transforms;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static int LOCAL_ID = 0;

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

    public static void addCallCreatingArgs(SootMethod method, StmtBody body, Object receiver, 
                                                 Map<Type, Local> alreadyCreated) {
        Stmt call = Jimple.v().newInvokeStmt(createCallCreatingArgs(method, body, receiver, alreadyCreated));
        body.getUnits().add(call);
    }


    public static InvokeExpr createCallCreatingArgs(SootMethod method, StmtBody body, Object receiver, 
                                                   Map<Type, Local> alreadyCreated) {
        //next create locals for all arguments
        //List of argument position to locals created...
        List<Value> args = new LinkedList<Value>();
        for (Type argType : method.getParameterTypes()) {
            if (alreadyCreated.containsKey(argType)) {
                args.add(alreadyCreated.get(argType));
            } else {
                //not already created...

                //if a reference, create dummy object
                if (argType instanceof RefType) {
                    Value v = createNewAndConstructorCall(body, method, ((RefType)argType));
                    args.add(v);

                } else if (argType instanceof ArrayType) {
                    Value v = createNewArrayAndObject(body, method, (ArrayType)argType);
                    args.add(v);
                } else {
                    args.add(SootUtils.getNullValue((Type)argType));
                }

                //add to map of types that have already been created if a local is the return value
                //denotes that we created an object
                if (args.get(args.size() - 1) instanceof Local)
                    alreadyCreated.put(argType, (Local)args.get(args.size() -1 ));
            }
        }

        //now create call to entry point
        logger.debug("method args {} = size of args list {}", method.getParameterCount(), args.size());

        Local trueReceiver = null;
        if (receiver instanceof SootField) {

            trueReceiver = Jimple.v().newLocal("TU" + LOCAL_ID++, ((SootField)receiver).getType());
            body.getLocals().add((Local)trueReceiver);
            body.getUnits().add(Jimple.v().newAssignStmt(trueReceiver, Jimple.v().newStaticFieldRef(((SootField)receiver).makeRef())));
        } else if (receiver instanceof Local) {
            trueReceiver = (Local)receiver;
        } else {
            logger.error("Unknown value type for receiver when creating call: {} {}", receiver, receiver.getClass());
            return null;
        }
        
        return makeInvokeExpression(method, trueReceiver, args);
    }

    public static Value createNewArrayAndObject(Body body, SootMethod entryPoint, ArrayType type) {
        Type baseType = type.getArrayElementType();

        //create new array to local     
        Local arrayLocal = Jimple.v().newLocal("TU" + LOCAL_ID++, type);
        body.getLocals().add(arrayLocal);

        if (type.numDimensions > 1) {
            //multiple dimensions, have to do some crap...
            List<Value> ones = new LinkedList<Value>();
            for (int i = 0; i < type.numDimensions; i++)
                ones.add(IntConstant.v(1));

            body.getUnits().add(Jimple.v().newAssignStmt(arrayLocal,
                Jimple.v().newNewMultiArrayExpr(type, ones)));
        } else {
            //single dimension, add new expression
            body.getUnits().add(Jimple.v().newAssignStmt(arrayLocal, 
                Jimple.v().newNewArrayExpr(baseType, IntConstant.v(1))));
        }

        //get down to an element through the dimensions
        Local elementPtr = arrayLocal;
        while (((ArrayType)elementPtr.getType()).getElementType() instanceof ArrayType) {
            Local currentLocal = Jimple.v().newLocal("TU" + LOCAL_ID++, ((ArrayType)elementPtr).getElementType());
            body.getUnits().add(Jimple.v().newAssignStmt(
                currentLocal, 
                Jimple.v().newArrayRef(elementPtr, IntConstant.v(0))));
            elementPtr = currentLocal;
        }

        //if a ref type, then create the new and constructor and assignment to array element
        if (baseType instanceof RefType) {
            //create the new expression and constructor call for a new local
            Value eleLocal = createNewAndConstructorCall(body, entryPoint, (RefType)baseType);
            //assign the new local to the array access
            body.getUnits().add(Jimple.v().newAssignStmt(
                Jimple.v().newArrayRef(elementPtr, IntConstant.v(0)), 
                eleLocal)); 
        }   

        return arrayLocal;
    }

    /**
     * Add to the body code to create a new object and assign it to a local, and then call the constructor
     * on the local.  If the type is an interface, then try to find a close implementor
     * return the local so it can be used in array assignments
     */
    public static Value createNewAndConstructorCall(Body body, SootMethod entryPoint, RefType type) {
        SootClass clz = type.getSootClass();
        //if an interface, find a direct implementor of and instantiate that...
        if (!clz.isConcrete()) {
            clz = SootUtils.getCloseConcrete(clz);
        }

        if (clz ==  null) {
            //if clz is null, then we have an interface with no known implementors, 
            //so just pass null
            logger.warn("Cannot find any known implementors of {} when building harness for entry {}", 
                type.getSootClass(), entryPoint);
            return SootUtils.getNullValue(type);
        }

        //if we got here, we found a class to instantiate, either the org or an implementor
        Local argLocal = Jimple.v().newLocal("TU" + LOCAL_ID++, type);
        body.getLocals().add(argLocal);

        //add the call to the new object
        body.getUnits().add(Jimple.v().newAssignStmt(argLocal, Jimple.v().newNewExpr(RefType.v(clz))));

        addConstructorCall(body, argLocal, RefType.v(clz));
        return argLocal;
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
    public static void addConstructorCall(Body body, Local local, RefType type) {
        SootClass clazz = type.getSootClass();

        //add the call to the constructor with its args
        SootMethod constructor = SootUtils.findSimpliestConstructor(clazz);


        if (constructor == null) {
            logger.warn("Cannot find constructor for {}.  Not going to call constructor.", clazz);
            return;
        }

        if (constructor.getParameterCount() > 0)
            logger.warn("Need to create dummy value for type, but no no-arg constructor: {}", clazz);

        //create list of dummy arg values for the constructor call, right now all constants
        List<Value> args = new LinkedList<Value>();
        for (Object argType : constructor.getParameterTypes()) {
            args.add(SootUtils.getNullValue((Type)argType));
        }

        //add constructor call to body nested in invoke statement
        body.getUnits().add(Jimple.v().newInvokeStmt(Jimple.v().newSpecialInvokeExpr(local, constructor.makeRef(), args)));

        // add xml injected stuff in here
    }
}
