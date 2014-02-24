package droidsafe.transforms;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.pta.PTAContext;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.value.primitives.StringVAModel;
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

    // allocNodes of all intents used to start activities in the last run of this transform
    private static Set<IAllocNode> intentAllocNodes;

    public StartActivityTransform() {
        intentAllocNodes = new HashSet<IAllocNode>();

        //get all activities
        for (SootClass clz : Harness.v().getCreatedClasses()) {
            if (Hierarchy.inheritsFromAndroidActivity(clz)) {
                allHarnessActivityFlds.add(Harness.v().getFieldForCreatedClass(clz));
            }
        }
    }

    /**
     * @return allocNodes of all intents used to start activities in the last run of this transform
     *         Null if this tranform has not run
     */
    public static Set<IAllocNode> getIntentAllocNodes() {
        return intentAllocNodes;
    }

    @Override
    public void tranformsInvoke(SootMethod containingMthd, SootMethod callee, InvokeExpr invoke, Stmt stmt, Body body, PTAContext context) { 

        if(!Project.v().isSrcClass(containingMthd.getDeclaringClass())){
            return;
        }

        // is this one of the invokes that we want to transform?
        // TODO: switch from using name to using signature
        boolean match = false;
        for(String sig : sigsOfInvokesToTransform) {
            if (callee.getName().equals(SootUtils.grabName(sig))){
                match = true;
                break;
            }
        }
        if(!match)
            return;

        for(String sig : sigsOfInvokesToTransform) {
            if (containingMthd.getName().equals(SootUtils.grabName(sig))) {
                return;
            }
        }

        if (modified.contains(stmt)) {
            return;
        }
        modified.add(stmt);

        SootMethod setIntentMethod = Scene.v().getMethod("<android.app.Activity: void setIntent(android.content.Intent)>");

        Value intentArg = invoke.getArg(0);

        for (SootField activityField : getIntentTargetHarnessFlds(intentArg, context)) {
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

    /**
     * @return set of harness fields that correspond to the activities that all the intents that intentArg could
     * reference could start
     */
    private Set<SootField> getIntentTargetHarnessFlds(Value intentArg, PTAContext context) {
        Set<SootField> resolvedTargetHarnessFlds = new HashSet<SootField>();

        Set<? extends IAllocNode> allocNodes = PTABridge.v().getPTSet(intentArg, context);

        // Couldn't figure out which intents 
        if(allocNodes.size() == 0) {
            logger.warn("getPTSet didn't return anything for: {}", intentArg);
            resolvedTargetHarnessFlds.addAll(allHarnessActivityFlds);
        }

        for(IAllocNode allocNode : allocNodes) {
            intentAllocNodes.add(allocNode);
            VAModel vaModel = ValueAnalysis.v().getResult(allocNode);
            if(vaModel != null && vaModel instanceof RefVAModel) {
                RefVAModel intentRefVAModel = (RefVAModel)vaModel;
                Set<String> targetClsStrings = null;
                switch(getIntentType(intentRefVAModel)) {
                    case EXPLICIT:
                        targetClsStrings = getExplicitIntentTargetClsStrings(intentRefVAModel);
                        break;
                    case IMPLICIT:  
                        targetClsStrings = getImplicitIntentInAppTargetClsStrings(intentRefVAModel);
                        break;
                }
                if(targetClsStrings != null) {
                    Set<SootField> targetHarnessFlds = getHarnessFldsForClsStrings(targetClsStrings);
                    // If we didn't get a field for each possible target class, then be conservative and use all
                    if(targetClsStrings.size() > targetHarnessFlds.size()){
                        resolvedTargetHarnessFlds.addAll(allHarnessActivityFlds);
                    } else if (targetClsStrings.size() == targetHarnessFlds.size()){
                        resolvedTargetHarnessFlds.addAll(targetHarnessFlds);
                    } else {
                        logger.error("Should not get back more target harness fields than target class strings.");
                        System.exit(1);
                    }
                } else {
                    resolvedTargetHarnessFlds.addAll(allHarnessActivityFlds);
                }
            } else {
                resolvedTargetHarnessFlds.addAll(allHarnessActivityFlds);
            }
        }
        return resolvedTargetHarnessFlds;
    }

    /**
     * @return IntentType of the passed in Intent RefVAModel
     */
    public static IntentType getIntentType(RefVAModel intentRefVAModel) {
        SootClass clonedIntentSootClass = ((RefType)(intentRefVAModel.getAllocNode().getType())).getSootClass();
        SootClass intentSootClass = ClassCloner.getClonedClassFromClone(clonedIntentSootClass);

        Set<VAModel> componentNameFieldVAModels = intentRefVAModel.getFieldVAModels(intentSootClass.getFieldByName("mComponent"));
        Set<VAModel> actionFieldVAModels = intentRefVAModel.getFieldVAModels(intentSootClass.getFieldByName("mAction"));
        Set<VAModel> typeFieldVAModels = intentRefVAModel.getFieldVAModels(intentSootClass.getFieldByName("mType"));
        Set<VAModel> dataFieldVAModels = intentRefVAModel.getFieldVAModels(intentSootClass.getFieldByName("mData"));

        // if there are any componentNames, then we assume this is an explicitely tracked intent
        if(componentNameFieldVAModels.size() > 0) {
            return IntentType.EXPLICIT;
        } else {
            return IntentType.IMPLICIT;
        }
    }

    /**
     * @return a set of SootFields that correspond to as many classStrings as possible
     */
    public static Set<SootField> getHarnessFldsForClsStrings(Set<String> clsStrings) {
        if(clsStrings == null)
            return null;

        Set<SootField> sootFlds = new HashSet<SootField>();
        for(String clsString : clsStrings) {
            if(!clsString.equals("")) {
                SootClass sootCls = Scene.v().getSootClass(clsString);
                if(sootCls != null) {
                    SootField activityHarnessFld = Harness.v().getFieldForCreatedClass(sootCls);
                    if(activityHarnessFld != null) {
                        sootFlds.add(activityHarnessFld);

                    }
                }
            }
        }
        return sootFlds;
    }

    /**
     * @return set of class strings that the passed in explicit intent may target
     *         null if we cannot resolved them unambiguously
     */
    public static Set<String> getExplicitIntentTargetClsStrings(RefVAModel intentRefVAModel) {

        // container for results
        Set<String> targetClsStrings = new HashSet<String>();

        // iterate over every possible componentName field value
        SootClass clonedIntentSootClass = ((RefType)(intentRefVAModel.getAllocNode().getType())).getSootClass();
        SootClass intentSootClass = ClassCloner.getClonedClassFromClone(clonedIntentSootClass);
        Set<VAModel> componentNameFldVAModels = intentRefVAModel.getFieldVAModels(intentSootClass.getFieldByName("mComponent"));

        for(VAModel componentNameFldVAModel : componentNameFldVAModels) {
            // if any of the component name VA models are invalidated, we cannot unambiguously determine all target
            // cls strings and must return null
            if(componentNameFldVAModel.invalidated() || componentNameFldVAModel instanceof UnknownVAModel){
                return null;
            }
            // the next four lines get the VA models for the 'mClass' field
            RefVAModel componentNameRefVAModel = (RefVAModel)componentNameFldVAModel;
            SootClass clonedComponentNameSootClass = ((RefType)componentNameRefVAModel.getAllocNode().getType()).getSootClass();
            SootClass componentNameSootClass = ClassCloner.getClonedClassFromClone(clonedComponentNameSootClass);
            Set<VAModel> mClassVAModels = componentNameRefVAModel.getFieldVAModels(componentNameSootClass.getFieldByName("mClass"));

            for(VAModel mClassVAModel : mClassVAModels) {
                // if any of the classVAModels are invalidated, we cannot unambiguously determine all target cls
                // strings and must return null
                if(mClassVAModel.invalidated() || mClassVAModel instanceof UnknownVAModel) {
                    return null;
                }
                // get the class strings
                Set<Object> mClassObjects = ((StringVAModel)mClassVAModel).getValues();
                for(Object mClassObject : mClassObjects) {
                    targetClsStrings.add((String)mClassObject);
                }
            }
        }
        return targetClsStrings;
    }

    /**
     * @return set of class strings that the passed in explicit intent may target
     *         null if we cannot resolved them unambiguously
     */
    public static Set<String> getImplicitIntentInAppTargetClsStrings(RefVAModel intentRefVAModel) {
        // for each Activity
        // for each intentFilter
        // if match, return cls string of activity
        return null;
    }

    /**
     * @return set of class strings that the passed in explicit intent may target
     *         null if we cannot resolved them unambiguously
     */
    public static boolean isImplicitIntentTargettingAmbiguous(RefVAModel intentRefVAModel, boolean countData) {
        SootClass clonedIntentSootClass = ((RefType)(intentRefVAModel.getAllocNode().getType())).getSootClass();
        SootClass intentSootClass = ClassCloner.getClonedClassFromClone(clonedIntentSootClass);

        // iterate over every possible action field value
        Set<VAModel> actionFldVAModels = intentRefVAModel.getFieldVAModels(intentSootClass.getFieldByName("mAction"));
        for(VAModel actionFldVAModel : actionFldVAModels) {
            if(actionFldVAModel.invalidated() || actionFldVAModel instanceof UnknownVAModel){
                return true;
            }
        }

        // iterate over every possible type field value
        Set<VAModel> typeFldVAModels = intentRefVAModel.getFieldVAModels(intentSootClass.getFieldByName("mType"));
        for(VAModel typeFldVAModel : typeFldVAModels) {
            if(typeFldVAModel.invalidated() || typeFldVAModel instanceof UnknownVAModel){
                return true;
            }
        }
        if (countData) {
            // iterate over every possible data field value
            Set<VAModel> dataFldVAModels = intentRefVAModel.getFieldVAModels(intentSootClass.getFieldByName("mData"));
            for(VAModel dataFldVAModel : dataFldVAModels) {
                if(dataFldVAModel.invalidated() || dataFldVAModel instanceof UnknownVAModel ){
                    return true;
                }
                RefVAModel uriRefVAModel = (RefVAModel)dataFldVAModel;
                SootClass clonedURISootClass = ((RefType)(uriRefVAModel.getAllocNode().getType())).getSootClass();
                SootClass uriSootClass = ClassCloner.getClonedClassFromClone(clonedURISootClass);
                // iterate over every possible action field value
                Set<VAModel> uriStringFldVAModels = uriRefVAModel.getFieldVAModels(uriSootClass.getFieldByName("uriString"));
                for(VAModel uriStringFldVAModel : uriStringFldVAModels) {
                    if(uriStringFldVAModel.invalidated() || uriStringFldVAModel instanceof UnknownVAModel){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
