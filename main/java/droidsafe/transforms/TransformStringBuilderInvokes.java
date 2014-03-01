package droidsafe.transforms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.Local;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Value;
import soot.jimple.AssignStmt;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.Jimple;
import soot.jimple.NewExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.util.Chain;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.system.API;

/**
 * This transformation is required by information flow because we do not add object sensitivity to 
 * string objects.  Information flow currently models methods on strings and string like types like 
 * string buffer and string builder.  For the toString method of string like types, we need to 
 * replace the toString() method with a new string, and then call an appropriate faked constructor 
 * on the new string that will transfer the value and the taint.
 * 
 * @author mgordon
 *
 */
public class TransformStringBuilderInvokes {
    private final static Logger logger = LoggerFactory.getLogger(TransformStringBuilderInvokes.class);

    private static final Set<String> STRING_LIKE_CLASSES = 
            new HashSet<String>(Arrays.asList(
                "java.lang.StringBuffer",
                    "java.lang.StringBuilder"));

    public TransformStringBuilderInvokes() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Find all calls to StringBuffer and StringBuilder toString(), and replace with a new string expression,
     * then call a faked constructor on the new string object to transfer taint / value from the string builder 
     * / buffer.
     */
    public static void run() {
        //the constructor we will be calling
        SootMethodRef stringConsRef = 
                Scene.v().getMethod("<java.lang.String: void <init>(java.lang.AbstractStringBuilder)>").makeRef();

        for (SootClass clz : Scene.v().getClasses()) {

            for (SootMethod method : clz.getMethods()) {
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

                    //called on string type, return type of method is string 

                    if (stmt instanceof AssignStmt) {
                        AssignStmt assign = (AssignStmt) stmt;
                        if (assign.getLeftOp() instanceof Local && assign.getRightOp() instanceof InstanceInvokeExpr) {
                            InstanceInvokeExpr iie = (InstanceInvokeExpr)assign.getRightOp();

                            //first check if we have a toString call
                            
                            if (!"java.lang.String toString()".equals(iie.getMethodRef().getSubSignature().getString()))
                                continue;                            
                            
                            boolean onlyStringTypes = true;

                            for (IAllocNode node : PTABridge.v().getPTSet(iie.getBase())) {
                                if (!STRING_LIKE_CLASSES.contains(node.getType().toString())) {
                                    onlyStringTypes = false;
                                    break;
                                }
                            }

                            if (!onlyStringTypes)
                                continue;

                            //found method call to transform!
                            logger.info("Replacing toString call in method {} of {}", method, assign.getRightOp());

                            //replace call with new expression to local
                            NewExpr newExpr = Jimple.v().newNewExpr(RefType.v("java.lang.String"));
                            assign.setRightOp(newExpr);

                            //add call to constructor after                  
                            List<Value> args = new LinkedList<Value>();
                            args.add(iie.getBase());
                            InvokeStmt consCall = 
                                    Jimple.v().newInvokeStmt(Jimple.v().newSpecialInvokeExpr((Local)assign.getLeftOp(), stringConsRef, args));
                            units.insertAfter(consCall, assign);
                        }
                    }
                }
            }
        }
    }
}
