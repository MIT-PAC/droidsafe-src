package droidsafe.transforms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import soot.Body;
import soot.Local;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Value;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.Edge;
import soot.util.Chain;
import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.helper.CGVisitorEntryContext;
import droidsafe.analyses.helper.CallGraphTraversal;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Hierarchy;
import droidsafe.android.system.API;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;

public class VATransformsSuite implements CGVisitorEntryContext {
    public static int localID = 0;
    
    private List<VATransform> transforms = Arrays.asList(
        (VATransform)new ConservativeStartActivity()
        );
    
    /**
     * 
     * @author mgordon
     *
     */
    class ConservativeStartActivity implements VATransform {
        Set<Stmt> modified = new HashSet<Stmt>();
        
        @Override
        public void resolvedMethodCall(SootMethod caller, SootMethod callee, InvokeExpr invoke, 
                                       Stmt stmt, Body body, Edge context) {
            if (!"<android.app.Activity: void startActivity(android.content.Intent)>".equals(callee.getSignature()))
                return;
            
            if (modified.contains(stmt)) 
                return;
            
            modified.add(stmt);
            
            SootMethod setIntentMethod = 
                    Scene.v().getMethod("<android.app.Activity: void setIntent(android.content.Intent)>");
            
            List<SootField> fields = new LinkedList<SootField>();
            //get all activities
            for (SootClass clz : Harness.v().getCreatedClasses()) {
                if (Hierarchy.v().inheritsFromAndroidActivity(clz)) {
                    fields.add(Harness.v().getFieldForCreatedClass(clz));
                }
            }
            
            for (SootField activityField : fields) {
                System.out.println("Adding setIntent call in " + JimpleRelationships.v().getEnclosingMethod(stmt));
                //call set intent on these activities with local   
                    
                //create local and add to body
                Local local = Jimple.v().newLocal("_setIntent_local_" + localID++, activityField.getType());
                body.getLocals().add(local);
                
                //set field of activity to local [local = harness.activityfield]
                //set local to field
                Stmt localAssign = Jimple.v().newAssignStmt
                        (local, Jimple.v().newStaticFieldRef(activityField.makeRef()));
                body.getUnits().insertBefore(localAssign, stmt);
                
                //call setActivity on local with local arg from start activity
                List<Value> args = new LinkedList<Value>();
                args.add(invoke.getArg(0));
                Stmt setIntentCall = 
                        Jimple.v().newInvokeStmt(Jimple.v().newVirtualInvokeExpr
                            (local, setIntentMethod.makeRef(), args));
                
                body.getUnits().insertAfter(setIntentCall, localAssign);
                //ignore making output events for this call we add
                RCFG.v().ignoreInvokeForOutputEvents(setIntentCall);
            }
        }
        
    }
    
    public static void run() {
        VATransformsSuite v = new VATransformsSuite();
        
        CallGraphTraversal.acceptEntryContext(v);
    }
    
    private VATransformsSuite() {
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
                        transform.resolvedMethodCall(method, callee, expr, stmt, stmtBody, entryEdge);
                    }
                } 
            } catch (CannotFindMethodException e) {
                continue;
            }
        }

    }

    interface VATransform {
        public void resolvedMethodCall(SootMethod caller, SootMethod callee, InvokeExpr invoke, 
                                       Stmt stmt, Body body, Edge context);
    }
}
