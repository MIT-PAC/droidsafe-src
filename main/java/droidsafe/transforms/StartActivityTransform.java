package droidsafe.transforms;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.value.primitives.StringVAModel;
import droidsafe.analyses.value.IntentUtils;
import droidsafe.analyses.value.RefVAModel;
import droidsafe.analyses.value.ValueAnalysis;
import droidsafe.analyses.value.VAModel;
import droidsafe.analyses.value.UnknownVAModel;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Hierarchy;
import droidsafe.android.app.Project;
import droidsafe.transforms.objsensclone.ClassCloner;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;

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
import soot.jimple.toolkits.pta.IAllocNode;
import soot.Local;
import soot.RefType;
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

    private Set<String> sigsOfInvokesToTransform;

    Set<Stmt> modified = new HashSet<Stmt>();
    
    Set<SootField> allHarnessActivityFlds = new HashSet<SootField>();

    public StartActivityTransform() {
        //get all activities
        
    }

    
    @Override

    public void tranformsInvoke(SootMethod containingMthd, SootMethod callee, InvokeExpr invoke, Stmt stmt, Body body) { 

        if(!Project.v().isSrcClass(containingMthd.getDeclaringClass())){
            return;
        }

        if (modified.contains(stmt)) {
            return;
        }
        modified.add(stmt);

        SootMethod setIntentMethod = Scene.v().getMethod("<android.app.Activity: void setIntent(android.content.Intent)>");

        Value intentArg = invoke.getArg(0);

        Set<? extends IAllocNode> intentNodes = PTABridge.v().getPTSetIns(intentArg);

        for (SootField activityField : IntentUtils.v().getIntentActivityTargetHarnessFields(intentNodes)) {
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
            args.add(intentArg);
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
            sigsOfInvokesToTransform.add("<android.app.Activity: void startActivity(android.content.Intent)>");
            sigsOfInvokesToTransform.add("<android.app.Activity: void startActivity(android.content.Intent,android.os.Bundle)>");
            sigsOfInvokesToTransform.add("<android.app.Activity: void startActivityForResult(android.content.Intent,int)>");
            sigsOfInvokesToTransform.add("<android.app.Activity: void startActivityForResult(android.content.Intent,int,android.os.Bundle)>");
            sigsOfInvokesToTransform.add("<android.app.Activity: void startActivityIfNeeded(android.content.Intent,int)>");
            sigsOfInvokesToTransform.add("<android.app.Activity: void startActivityIfNeeded(android.content.Intent,int,android.os.Bundle)>");
        }
        return sigsOfInvokesToTransform;
    }

  
}
