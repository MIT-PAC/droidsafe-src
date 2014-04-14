package droidsafe.analyses.value;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.Value;
import soot.jimple.toolkits.pta.IAllocNode;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.value.primitives.ClassVAModel;
import droidsafe.analyses.value.primitives.StringVAModel;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Hierarchy;
import droidsafe.transforms.objsensclone.ClassCloner;

public class IntentUtils {
    /** if true, then delivery unresolveable intents to all targets to be conservative
     *  if false, then ignore effects of unresolveable intents, not accurate!
     */
    private static final boolean CONSERVATIVE = false;

    private Set<IAllocNode> queriedNodes;

    private static IntentUtils v;

    public static IntentUtils v() {
        if (v == null)
            v = new IntentUtils();

        return v;
    }

    private static final Logger logger = LoggerFactory.getLogger(IntentUtils.class);

    public IntentUtils() {
        queriedNodes = new LinkedHashSet<IAllocNode>();
    }

    public Set<IAllocNode> getAllQueriedIntents() {
        return queriedNodes;
    }

    /**
     * 
     */
    public Set<SootField> getIntentActivityTargetHarnessFields(Set<? extends IAllocNode> allocNodes) {
        Set<SootField> allHarnessActivityFlds = new LinkedHashSet<SootField>();

        if (CONSERVATIVE) {
            for (SootClass clz : Harness.v().getCreatedClasses()) {
                if (Hierarchy.inheritsFromAndroidActivity(clz)) {
                    allHarnessActivityFlds.add(Harness.v().getFieldForCreatedClass(clz));
                }
            }
        }

        return getIntentTargetHarnessFlds(allocNodes, allHarnessActivityFlds);
    }

    /**
     * 
     */
    public Set<SootField> getIntentBroadcastReceiverTargetHarnessFields(Set<? extends IAllocNode> allocNodes) {
        Set<SootField> allHarnessServiceFlds = new LinkedHashSet<SootField>();

        if (CONSERVATIVE) {
            for (SootClass clz : Harness.v().getCreatedClasses()) {
                if (Hierarchy.inheritsFromAndroidBroadcastReceiver(clz)) {
                    allHarnessServiceFlds.add(Harness.v().getFieldForCreatedClass(clz));
                }
            }
        }

        return getIntentTargetHarnessFlds(allocNodes, allHarnessServiceFlds);
    }
    
    /**
     * 
     */
    public Set<SootField> getIntentServiceTargetHarnessFields(Set<? extends IAllocNode> allocNodes) {
        Set<SootField> allHarnessServiceFlds = new LinkedHashSet<SootField>();

        if (CONSERVATIVE) {
            for (SootClass clz : Harness.v().getCreatedClasses()) {
                if (Hierarchy.inheritsFromAndroidService(clz)) {
                    allHarnessServiceFlds.add(Harness.v().getFieldForCreatedClass(clz));
                }
            }
        }

        return getIntentTargetHarnessFlds(allocNodes, allHarnessServiceFlds);
    }

    /**
     * @return set of harness fields that correspond to the activities that all the intents that intentArg could
     * reference could start
     */

    private Set<SootField> getIntentTargetHarnessFlds(Set<? extends IAllocNode> allocNodes, 
        Set<SootField> allPossibleFieldTargets) {
        Set<SootField> resolvedTargetHarnessFlds = new HashSet<SootField>();


        for(IAllocNode allocNode : allocNodes) {
            queriedNodes.add(allocNode);
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
                    if (targetClsStrings.size() > targetHarnessFlds.size()){
                        if (CONSERVATIVE)
                            resolvedTargetHarnessFlds.addAll(allPossibleFieldTargets);
                        else 
                            resolvedTargetHarnessFlds.addAll(targetHarnessFlds);
                    } else if (targetClsStrings.size() == targetHarnessFlds.size()){
                        resolvedTargetHarnessFlds.addAll(targetHarnessFlds);
                    } else {
                        logger.error("Should not get back more target harness fields than target class strings.");
                        System.exit(1);
                    }
                } else {
                    resolvedTargetHarnessFlds.addAll(allPossibleFieldTargets);
                }
            } else {
                resolvedTargetHarnessFlds.addAll(allPossibleFieldTargets);
            }
        }
        return resolvedTargetHarnessFlds;
    }

    /**
     * @return IntentType of the passed in Intent RefVAModel
     */
    public IntentType getIntentType(RefVAModel intentRefVAModel) {
        SootClass clonedIntentSootClass = ((RefType)(intentRefVAModel.getAllocNode().getType())).getSootClass();
        SootClass intentSootClass = ClassCloner.getClonedClassFromClone(clonedIntentSootClass);

        Set<VAModel> componentNameFieldVAModels = intentRefVAModel.getFieldVAModels(intentSootClass.getFieldByName("mComponent"));
        Set<VAModel> clsFieldVAModeles = intentRefVAModel.getFieldVAModels(intentSootClass.getFieldByName("mClsComponent"));

        // if there are any componentNames, then we assume this is an explicitely tracked intent
        if(componentNameFieldVAModels.size() > 0 || clsFieldVAModeles.size() > 0) {
            return IntentType.EXPLICIT;
        } else {
            return IntentType.IMPLICIT;
        }
    }

    /**
     * @return a set of SootFields that correspond to as many classStrings as possible
     */
    public Set<SootField> getHarnessFldsForClsStrings(Set<String> clsStrings) {
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
    public Set<String> getExplicitIntentTargetClsStrings(RefVAModel intentRefVAModel) {

        // container for results
        Set<String> targetClsStrings = new HashSet<String>();
        // iterate over every possible componentName field value
        SootClass clonedIntentSootClass = ((RefType)(intentRefVAModel.getAllocNode().getType())).getSootClass();
        SootClass intentSootClass = ClassCloner.getClonedClassFromClone(clonedIntentSootClass);
        
        
        //first check the cls constant field
        Set<VAModel> clsFldVAModels = intentRefVAModel.getFieldVAModels(intentSootClass.getFieldByName("mClsComponent"));
        if (clsFldVAModels.size() > 0) {
            boolean allConstants = true;;
            
            for (VAModel clz : clsFldVAModels) {
                if (clz.invalidated()) {
                    allConstants = false;
                    continue;
                }
                    
                if (clz instanceof ClassVAModel) {
                    ClassVAModel clzModel = (ClassVAModel)clz;
                    for (SootClass value : clzModel.getValues()) {
                        targetClsStrings.add(value.getName());
                        System.out.println("resolve explicit intent: " + value.getName());
                    }
                } else {
                    allConstants = false;
                } 
            }
            
            if (allConstants)
                return targetClsStrings;
        }

        
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
                Set<String> mClassObjects = ((StringVAModel)mClassVAModel).getValues();
                for(String mClassObject : mClassObjects) {
                    targetClsStrings.add(mClassObject);
                }
            }
        }
        return targetClsStrings;
    }

    /**
     * @return set of class strings that the passed in explicit intent may target
     *         null if we cannot resolved them unambiguously
     */
    public Set<String> getImplicitIntentInAppTargetClsStrings(RefVAModel intentRefVAModel) {
        // for each Activity
        // for each intentFilter
        // if match, return cls string of activity
        return null;
    }

    /**
     * @return set of class strings that the passed in explicit intent may target
     *         null if we cannot resolved them unambiguously
     */
    public boolean isImplicitIntentTargettingAmbiguous(RefVAModel intentRefVAModel, boolean countData) {
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
