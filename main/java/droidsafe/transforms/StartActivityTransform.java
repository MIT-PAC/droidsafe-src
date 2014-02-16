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
import soot.jimple.toolkits.pta.IAllocNode;
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
            if (Hierarchy.inheritsFromAndroidActivity(clz)) {
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

    /**
     * @return set of harness fields that correspond to the activites that all the intents that intentArg could
     * reference could start
     */
    private Set<SootField> getDestinationsOfIntent(Value intentArg, PTAContext context) {
        Set<SootField> destActivityHarnessSootFields = new HashSet<SootField>();
        Set<? extends IAllocNode> allocNodes = PTABridge.v().getPTSet(intentArg, context);
        for(IAllocNode allocNode : allocNodes) {
            VAModel vaModel = ValueAnalysis.v().getResult(allocNode);
            if(vaModel != null && vaModel instanceof RefVAModel) {
                destActivityHarnessSootFields.addAll(getDestinationsOfIntent((RefVAModel)vaModel));
            }
        }
        return destActivityHarnessSootFields;
    }

    /**
     * @return set of harness fields that correspond to the activities that the intent modeled by intentModel could
     * start
     */
    private Set<SootField> getDestinationsOfIntent(RefVAModel intentModel) {
        // the next 3 lines get the VA models for the 'mComponent' field
        SootClass clonedIntentSootClass = ((RefType)intentModel.getAllocNode().getType()).getSootClass();
        SootClass intentSootClass = ClassCloner.getClonedClassFromClone(clonedIntentSootClass);
        Set<VAModel> componentNameModels = intentModel.getFieldVAModels(intentSootClass.getFieldByName("mComponent"));

        // if there are any componentNames, then we assume this is an explicitely tracked intent
        if(componentNameModels.size() > 0) {
            // componentName field is empty - this is an explicitely targetted intent
            return getExplicitlyTargetedIntentTargets(componentNameModels);
        } else {
            // not handling implicitely targetted intents yet, return all possibilities
            return getImplicitlyTargettedIntentTargets(intentModel);
        }
    }

    /**
     * @return set of harness fields that correspond to the activities referred to the by the set of ComponentName VA
     * models componentNameModels
     */
    private Set<SootField> getExplicitlyTargetedIntentTargets(Set<VAModel> componentNameModels) {
        // result container
        Set<SootField> destActivityHarnessSootFields = new HashSet<SootField>();

        for(VAModel componentNameVAModel : componentNameModels) {

            // the next four lines get the VA models for the 'mClass' field
            RefVAModel componentNameRefVAModel = (RefVAModel)componentNameVAModel;
            SootClass clonedComponentNameSootClass = ((RefType)componentNameRefVAModel.getAllocNode().getType()).getSootClass();
            SootClass componentNameSootClass = ClassCloner.getClonedClassFromClone(clonedComponentNameSootClass);
            Set<VAModel> mClassVAModels = componentNameRefVAModel.getFieldVAModels(componentNameSootClass.getFieldByName("mClass"));

            if(mClassVAModels.size() > 0) {
                for(VAModel mClassVAModel : mClassVAModels) {
                    // get the class strings
                    Set<Object> mClassObjects = ((StringVAModel)mClassVAModel).getValues();
                    if(mClassObjects.size() != 1 || mClassObjects.toArray()[0].equals("")) {
                        // no targetted classes got resolved, gotta return all possibilities
                        return activitiesFromHarness;
                    }

                    for(Object mClassObject : mClassObjects) {
                        SootClass sootClass = Scene.v().getSootClass((String)mClassObject);
                        if(sootClass != null) {
                            SootField fieldOfActivityInHarness = Harness.v().getFieldForCreatedClass(sootClass);
                            if(fieldOfActivityInHarness != null) {
                                destActivityHarnessSootFields.add(fieldOfActivityInHarness);
                            } else {
                                // couldn't find field in harness for this class, return all possibilities
                                return activitiesFromHarness;
                            }
                        } else {
                            // couldn't find a soot class for this class stirng, return all possibilities
                            return activitiesFromHarness;
                        }
                    }
                }
            } else {
                // the component name's class field didn't get resolved, return all possibilities
                return activitiesFromHarness;
            }
        }
        return destActivityHarnessSootFields;
    }

    /**
     * @return set of harness fields that correspond to the activities that could be started by this implicitely
     * targetted intent
     */
    private Set<SootField> getImplicitlyTargettedIntentTargets(RefVAModel intentModel) {
        return activitiesFromHarness;
    }
}
