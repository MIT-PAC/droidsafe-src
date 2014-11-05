package droidsafe.transforms.va;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.reports.UnresolvedICC;
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
    private List<VATransform> transforms = Arrays.asList(
        new StartActivityTransform(),
        new ServiceBindTransform(),
        new StartServiceTransform(),
        new BroadcastReceiverTransform(),
        new ContentProviderTransform()
            );

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
                continue;

            // iterate over the containing method's body statements
            StmtBody stmtBody = (StmtBody)containingMthd.getActiveBody();
            Iterator stmtIt = stmtBody.getUnits().snapshotIterator();
            while (stmtIt.hasNext()) {
                Stmt stmt = (Stmt)stmtIt.next();

                // we only transform invoke expressions
                if (!stmt.containsInvokeExpr())
                    continue;
                InvokeExpr invokeExpr = (InvokeExpr)stmt.getInvokeExpr();

                for (VATransform transform : transforms) { 
                    for (SootMethod callee : PTABridge.v().getTargetsInsNoContext(containingMthd, stmt)) {
                        if (isInvokeCandidateForTransform(transform, callee)) {
                            transform.tranformsInvoke(containingMthd, callee, invokeExpr, stmt, stmtBody);
                        }
                    } 
                }     
                
            }
        }
    }

    /**
     * @return   true if the name of the method of the invoke is a possible candidate for the transformation
     *           false otherwise
     */
    private boolean isInvokeCandidateForTransform(VATransform transform, SootMethod method) {
        return transform.sigsOfInvokesToTransform().contains(method.getSignature());
    }
}
