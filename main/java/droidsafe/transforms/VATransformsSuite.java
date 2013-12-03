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
import droidsafe.analyses.pta.ContextType;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.pta.PTAContext;
import droidsafe.analyses.pta.cg.CGContextVisitor;
import droidsafe.analyses.pta.cg.CallGraphTraversal;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.value.ValueAnalysis;
import droidsafe.android.app.EntryPoints;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Hierarchy;
import droidsafe.android.system.API;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;

public class VATransformsSuite implements CGContextVisitor {
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
        /** Logger object */
        private final Logger logger = LoggerFactory.getLogger(ConservativeStartActivity.class);
        private final String START_ACTIVITY_SIG = 
                "<android.app.Activity: void startActivity(android.content.Intent)>";
        private final String START_ACTIVITYFORRESULT_SIG = 
                "<android.app.Activity: void startActivityForResult(android.content.Intent,int)>";
        private Set<String> methodSigsToOverride;

        Set<Stmt> modified = new HashSet<Stmt>();
        List<SootField> activitiesFromHarness = new LinkedList<SootField>();

        public ConservativeStartActivity() {
            //get all activities
            for (SootClass clz : Harness.v().getCreatedClasses()) {
                if (Hierarchy.v().inheritsFromAndroidActivity(clz)) {
                    activitiesFromHarness.add(Harness.v().getFieldForCreatedClass(clz));
                }
            }
        }



        @Override
        public void resolvedMethodCall(SootMethod caller, SootMethod callee, InvokeExpr invoke, 
                                       Stmt stmt, Body body, Edge context) {
            if (!methodSigsToOverride.contains(callee.getSignature()))
                return;

            //don't replace startActivityForResult in startActivity 
            if (methodSigsToOverride.contains(caller.getSignature()))
                return;
            
            if (modified.contains(stmt)) 
                return;

            modified.add(stmt);

            SootMethod setIntentMethod = 
                    Scene.v().getMethod("<android.app.Activity: void setIntent(android.content.Intent)>");

            for (SootField activityField : activitiesFromHarness) {
                logger.info("Adding setIntent call in " + JimpleRelationships.v().getEnclosingMethod(stmt));
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
                //this will work for both startActivity and startActivityForResult
                args.add(invoke.getArg(0));
                Stmt setIntentCall = 
                        Jimple.v().newInvokeStmt(Jimple.v().newVirtualInvokeExpr
                            (local, setIntentMethod.makeRef(), args));

                body.getUnits().insertAfter(setIntentCall, localAssign);
                //ignore making output events for this call we add
                RCFG.v().ignoreInvokeForOutputEvents(setIntentCall);
            }
        }



        @Override
        public Set<String> methodSignaturesToTransform() {
            if (methodSigsToOverride == null) {
                methodSigsToOverride = new HashSet<String>();
                methodSigsToOverride.add(START_ACTIVITY_SIG);
                methodSigsToOverride.add(START_ACTIVITYFORRESULT_SIG);
            }
            return methodSigsToOverride;
        }

    }

    public static void run() {
        VATransformsSuite v = new VATransformsSuite();

        CallGraphTraversal.acceptContext(v, ValueAnalysis.CONTEXT_TYPE);
    }

    private VATransformsSuite() {
    }

    @Override
    public void visit(SootMethod method, PTAContext eventContext) {
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

            //run a prepass that will check if the name of the method that is invoked
            //matches anything we care to transform in the transforms, if not, we 
            //should not run pta (which is expensive)
            boolean signatureMatch = false;
            String invokedMethodName = SootUtils.grabName(expr.getMethodRef().getSignature());
            for (VATransform transform : transforms) {
                for (String signature : transform.methodSignaturesToTransform()) {
                    String currentName = SootUtils.grabName(signature);
                    if (currentName.equals(invokedMethodName)) {
                        signatureMatch = true;
                        break;
                    }
                }
            }

            if (!signatureMatch)
                continue;

            try {
                for (SootMethod callee : PTABridge.v().resolveInvoke(expr, eventContext)) {
                    for (VATransform transform : transforms) {
                        transform.resolvedMethodCall(method, callee, expr, stmt, stmtBody, eventContext.getContext());
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

        public Set<String> methodSignaturesToTransform();
    }
}
