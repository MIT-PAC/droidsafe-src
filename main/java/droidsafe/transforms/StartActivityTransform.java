package droidsafe.transforms;

import droidsafe.analyses.rcfg.RCFG;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Hierarchy;
import droidsafe.utils.JimpleRelationships;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.Edge;
import soot.Local;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Value;

/**
 * @author dpetters
 * @author mgordon
 */

class StartActivityTransform implements VATransform {

    public static int localID = 0;

    private final Logger logger = LoggerFactory.getLogger(StartActivityTransform.class);
    
    private final String START_ACTIVITY_SIG = 
            "<android.app.Activity: void startActivity(android.content.Intent)>";
    private final String START_ACTIVITYFORRESULT_SIG = 
            "<android.app.Activity: void startActivityForResult(android.content.Intent,int)>";
    private Set<String> sigsOfInvokesToTransform;

    Set<Stmt> modified = new HashSet<Stmt>();
    List<SootField> activitiesFromHarness = new LinkedList<SootField>();

    public StartActivityTransform() {
        //get all activities
        for (SootClass clz : Harness.v().getCreatedClasses()) {
            if (Hierarchy.v().inheritsFromAndroidActivity(clz)) {
                activitiesFromHarness.add(Harness.v().getFieldForCreatedClass(clz));
            }
        }
    }
    
    @Override
    public void tranformsInvoke(SootMethod containingMthd, SootMethod callee, InvokeExpr invoke, Stmt stmt, Body body, Edge context) { 
        // sanity check - tranformsInvoke should not be called with
        if (!sigsOfInvokesToTransform.contains(callee.getSignature()))
            return;

        //don't replace startActivityForResult in startActivity 
        if (sigsOfInvokesToTransform.contains(containingMthd.getSignature()))
            return;
        
        if (modified.contains(stmt)) 
            return;

        modified.add(stmt);
        
        SootMethod setIntentMethod = Scene.v().getMethod("<android.app.Activity: void setIntent(android.content.Intent)>");

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
    public Set<String> sigsOfInvokesToTransform() {
        if (sigsOfInvokesToTransform == null) {
            sigsOfInvokesToTransform = new HashSet<String>();
            sigsOfInvokesToTransform.add(START_ACTIVITY_SIG);
            sigsOfInvokesToTransform.add(START_ACTIVITYFORRESULT_SIG);
        }
        return sigsOfInvokesToTransform;
    }

}


