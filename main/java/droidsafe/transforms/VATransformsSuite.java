package droidsafe.transforms;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.SootUtils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.toolkits.callgraph.Edge;
import soot.util.Chain;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.value.ValueAnalysis;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Hierarchy;
import droidsafe.android.system.API;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;
import soot.Context;
import soot.MethodOrMethodContext;
import soot.SootMethod;


/**
 * @author mgordon
 * @author dpetters
 */
public class VATransformsSuite  {
    private List<VATransform> transforms = Arrays.asList((VATransform)new StartActivityTransform());

    // enforce singleton pattern
    private VATransformsSuite() {}

    public static void run() {       
        VATransformsSuite v = new VATransformsSuite();
        v.visitMethodContexts();
    }


    public void visitMethodContexts() {
        for (SootMethod containingMthd : PTABridge.v().getReachableMethods()) {
            // filter out abstract, not concrete, phantom and stub methods
            if (containingMthd.isAbstract() 
                    || !containingMthd.isConcrete() 
                    || containingMthd.isPhantom() 
                    || SootUtils.isRuntimeStubMethod(containingMthd))
                return;

            // iterate over the containing method's body statements
            StmtBody stmtBody = (StmtBody)containingMthd.getActiveBody();
            Iterator stmtIt = stmtBody.getUnits().snapshotIterator();
            while (stmtIt.hasNext()) {
                Stmt stmt = (Stmt)stmtIt.next();

                // we only transform invoke expressions
                if (!stmt.containsInvokeExpr())
                    continue;
                InvokeExpr invokeExpr = (InvokeExpr)stmt.getInvokeExpr();

                // optimization: check if the name of the method of the invoke is a possible candidate for any tranformation
                // to transform. If not, then we don't need to run the resolveInvoke PTA call (which is expensive)
                if (!isInvokeCandidateForTransform(invokeExpr))
                    continue;

                try {
                    for (SootMethod callee : PTABridge.v().resolveInvokeIns(invokeExpr)) {
                        for (VATransform transform : transforms) {
                            transform.tranformsInvoke(containingMthd, callee, invokeExpr, stmt, stmtBody);
                        }
                    } 
                } catch (CannotFindMethodException e) {
                    continue;
                }
            }
        }
    }

    /**
     * @return   true if the name of the method of the invoke is a possible candidate for any tranformation
     *           false otherwise
     */
    private boolean isInvokeCandidateForTransform(InvokeExpr invokeExpr) {
        String invokedMethodName = SootUtils.grabName(invokeExpr.getMethodRef().getSignature());
        for (VATransform transform : transforms) {
            for (String signature : transform.sigsOfInvokesToTransform()) {
                String currentName = SootUtils.grabName(signature);
                if (currentName.equals(invokedMethodName)) {
                    return true;
                }
            }
        }
        return false;
    }
}
