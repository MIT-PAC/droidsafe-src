package droidsafe.transforms;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.pta.PTAContext;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.value.primitives.StringVAModel;
import droidsafe.analyses.value.RefVAModel;
import droidsafe.analyses.value.ValueAnalysis;
import droidsafe.analyses.value.VAModel;
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
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.Stmt;
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
    
    private final String START_ACTIVITY_SIG = 
            "<android.app.Activity: void startActivity(android.content.Intent)>";
    private final String START_ACTIVITYFORRESULT_SIG = 
            "<android.app.Activity: void startActivityForResult(android.content.Intent,int)>";
    private Set<String> sigsOfInvokesToTransform;

    Set<Stmt> modified = new HashSet<Stmt>();
    Set<SootField> activitiesFromHarness = new HashSet<SootField>();

    public StartActivityTransform() {
        //get all activities
        for (SootClass clz : Harness.v().getCreatedClasses()) {
            if (Hierarchy.v().inheritsFromAndroidActivity(clz)) {
                activitiesFromHarness.add(Harness.v().getFieldForCreatedClass(clz));
            }
        }
    }
    
    @Override
    public void tranformsInvoke(SootMethod containingMthd, SootMethod callee, InvokeExpr invoke, Stmt stmt, Body body, PTAContext context) { 
        // is this one of the invokes that we want to transform?
        if (!sigsOfInvokesToTransform.contains(callee.getSignature()))
            return;

        // don't replace startActivityForResult in startActivity 
        if (sigsOfInvokesToTransform.contains(containingMthd.getSignature()))
            return;
        
        if (modified.contains(stmt)) 
            return;
        modified.add(stmt);
        
        SootMethod setIntentMethod = Scene.v().getMethod("<android.app.Activity: void setIntent(android.content.Intent)>");
        
        Value intentArg = invoke.getArg(0);

        for (SootField activityField : getDestinationsOfIntent(intentArg, context)) {
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
            sigsOfInvokesToTransform.add(START_ACTIVITY_SIG);
            sigsOfInvokesToTransform.add(START_ACTIVITYFORRESULT_SIG);
        }
        return sigsOfInvokesToTransform;
    }
    
    // Takes an intent value and returns a set of activities
    private Set<SootField> getDestinationsOfIntent(Value intentArg, PTAContext context) {
        Set<SootField> destActivityHarnessSootFields = new HashSet<SootField>();
        Set<AllocNode> allocNodes = PTABridge.v().getPTSet(intentArg, context);
        for(AllocNode allocNode : allocNodes) {
            VAModel vaModel = ValueAnalysis.v().getResult(allocNode);
            if(vaModel != null && vaModel instanceof RefVAModel) {
                destActivityHarnessSootFields.addAll(getDestinationsOfIntent((RefVAModel)vaModel));
            }
        }
        return destActivityHarnessSootFields;
    }

    private Set<SootField> getDestinationsOfIntent(RefVAModel intentModel) {
        Set<SootField> destActivityHarnessSootFields = new HashSet<SootField>();
        System.out.println("getDestinationsOfIntent called on: " + intentModel.toString());
        SootClass intentSootClass = ((RefType)intentModel.getAllocNode().getType()).getSootClass();
        Set<VAModel> componentNameModels = intentModel.getFieldVAModels(intentSootClass.getFieldByName("mComponent"));
        if(componentNameModels.size() == 0) {
            // implicitely targetted intent
            return activitiesFromHarness;
        } else {
            // explicitely targetted intent
            for(VAModel componentNameVAModel : componentNameModels) {
                RefVAModel componentNameRefVAModel = (RefVAModel)componentNameVAModel;
                SootClass componentNameSootClass = ((RefType)componentNameRefVAModel.getAllocNode().getType()).getSootClass();
                Set<VAModel> mClassVAModels = componentNameRefVAModel.getFieldVAModels(componentNameSootClass.getFieldByName("mClass"));
                for(VAModel mClassVAModel : mClassVAModels) {
                    StringVAModel mClassStringVAModel = (StringVAModel)mClassVAModel;
                    for(Object mClassObject : mClassStringVAModel.getValues()) {
                        String mClassString = (String)mClassObject;
                        destActivityHarnessSootFields.add(Harness.v().getFieldForCreatedClass(Scene.v().getSootClass(mClassString)));
                    }
                }
            }
        }
        return destActivityHarnessSootFields;
    }
}
