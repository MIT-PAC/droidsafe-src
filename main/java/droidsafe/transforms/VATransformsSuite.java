package droidsafe.transforms;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import soot.Body;
import soot.SootMethod;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.toolkits.callgraph.Edge;
import soot.util.Chain;
import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.helper.CGVisitorEntryContext;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.SootUtils;

public class VATransformsSuite implements CGVisitorEntryContext {

    private List<VATransform> transforms = Arrays.asList();
    
    
    class ConservativeStartActivity implements VATransform {
        @Override
        public void resolvedMethodCall(SootMethod method, Stmt stmt, Body body, Edge context) {
            if (!"".equals(method.getSignature()))
                return;
            
            //get the activity
            
            
            //add call the setIntent
            
        }
        
    }
    
    public VATransformsSuite() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void visitEntryContext(SootMethod method, Edge entryEdge) {
        if (method.isAbstract() || !method.isConcrete() || method.isPhantom() || SootUtils.isRuntimeStubMethod(method))
            return;
        
        StmtBody stmtBody = (StmtBody)method.getActiveBody();
        Chain units = stmtBody.getUnits();
        Iterator stmtIt = units.snapshotIterator();

        while (stmtIt.hasNext()) {
            Stmt stmt = (Stmt)stmtIt.next();
            if (!stmt.containsInvokeExpr()) {
                continue;
            }

            InvokeExpr expr = (InvokeExpr)stmt.getInvokeExpr();
            try {
                for (SootMethod callee : GeoPTA.v().resolveInvokeEventContext(expr, entryEdge)) {
                    for (VATransform transform : transforms) {
                        transform.resolvedMethodCall(callee, stmt, stmtBody, entryEdge);
                    }
                } 
            } catch (CannotFindMethodException e) {
                continue;
            }
        }

    }

    interface VATransform {
        public void resolvedMethodCall(SootMethod method, Stmt stmt, Body body, Edge context);
    }
}
