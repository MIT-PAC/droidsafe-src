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
import soot.SootMethod;
import soot.Value;
import soot.jimple.Stmt;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.pta.IAllocNode;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.value.primitives.ClassVAModel;
import droidsafe.analyses.value.primitives.StringVAModel;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Hierarchy;
import droidsafe.android.app.resources.AndroidManifest.ComponentBaseElement;
import droidsafe.android.app.resources.Resources;
import droidsafe.android.system.AndroidComponents;
import droidsafe.reports.UnresolvedICC;
import droidsafe.transforms.objsensclone.ClassCloner;

public class IntentUtils {
    /** if true, then delivery unresolveable intents to all targets to be conservative
     *  if false, then ignore effects of unresolveable intents, not accurate!
     */
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
    public Set<SootField> getIntentTargetHarnessFields(AndroidComponents component, Stmt stmt, SootMethod target, Set<? extends IAllocNode> allocNodes) {
        Set<SootField> allHarnessActivityFlds = new LinkedHashSet<SootField>();


        for (SootClass clz : Harness.v().getCreatedClasses()) {
            if (Hierarchy.inheritsFromAndroidComponent(component, clz)) {
                allHarnessActivityFlds.add(Harness.v().getFieldForCreatedClass(clz));
            }
        }

        return getIntentTargetHarnessFlds(stmt, target, allocNodes, component, allHarnessActivityFlds);
    }

    /**
     * @return set of harness fields that correspond to the activities that all the intents that intentArg could
     * reference could start
     */

    private Set<SootField> getIntentTargetHarnessFlds(Stmt stmt, SootMethod target, Set<? extends IAllocNode> allocNodes, 
        AndroidComponents component, Set<SootField> allPossibleFieldTargets) {
        Set<SootField> resolvedTargetHarnessFlds = new HashSet<SootField>();


        for(IAllocNode allocNode : allocNodes) {
            queriedNodes.add(allocNode);
            VAModel vaModel = ValueAnalysis.v().getResult(allocNode);
            if(vaModel != null && vaModel instanceof RefVAModel) {
                RefVAModel intentRefVAModel = (RefVAModel)vaModel;
                //add all targets of this intent
                switch(getIntentType(intentRefVAModel)) {
                    case EXPLICIT:
                        resolvedTargetHarnessFlds.addAll(
                            getExplicitIntentTargetClsStrings(allocNode, stmt, target, intentRefVAModel, allPossibleFieldTargets));
                        break;
                    case IMPLICIT:  
                        resolvedTargetHarnessFlds.addAll(
                            getImplicitIntentInAppTargetClsStrings(allocNode, stmt, target, intentRefVAModel, component, allPossibleFieldTargets));
                        break;
                }               
            } else {
                //no va model, so have to add everything!
                UnresolvedICC.v().addInfo(stmt, target, "Unresolved Intent");
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
            sootFlds.add(getHarnessFldForClsString(clsString));
        }
        return sootFlds;
    }

    /**
     * Return harness field for class string of fully qualified name
     */
    public SootField getHarnessFldForClsString(String clsString) {
        if(!clsString.equals("")) {
            SootClass sootCls = Scene.v().getSootClass(clsString);
            if(sootCls != null) {
                SootField activityHarnessFld = Harness.v().getFieldForCreatedClass(sootCls);
                if(activityHarnessFld != null) {
                    return activityHarnessFld;
                }
            }        
        }

        logger.error("could not find harness field for {}", clsString);

        return null;
    }

    /**
     * @return set of class strings that the passed in explicit intent may target
     *         null if we cannot resolved them unambiguously
     */
    public Set<SootField> getExplicitIntentTargetClsStrings(IAllocNode allocNode, Stmt stmt, 
        SootMethod target, RefVAModel intentRefVAModel,
        Set<SootField> allPossibleFieldTargets) {

        // container for results
        Set<SootField> targetClsStrings = new HashSet<SootField>();
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
                    UnresolvedICC.v().addInfo(stmt, target, "Unresolved Intent");
                    continue;
                }

                if (clz instanceof ClassVAModel) {
                    ClassVAModel clzModel = (ClassVAModel)clz;
                    for (SootClass value : clzModel.getValues()) {
                        targetClsStrings.add(getHarnessFldForClsString(value.getName()));
                        System.out.println("resolve explicit intent: " + value.getName());
                    }
                } else {
                    UnresolvedICC.v().addInfo(stmt, target, "Unresolved Intent");
                    allConstants = false;
                } 
            }

            if (allConstants)
                return targetClsStrings;
        } else {
            UnresolvedICC.v().addInfo(stmt, target, "Unresolved Intent");
        }


        Set<VAModel> componentNameFldVAModels = intentRefVAModel.getFieldVAModels(intentSootClass.getFieldByName("mComponent"));

        for(VAModel componentNameFldVAModel : componentNameFldVAModels) {
            // if any of the component name VA models are invalidated, we cannot unambiguously determine all target
            // cls strings and must return null
            if(componentNameFldVAModel.invalidated() || componentNameFldVAModel instanceof UnknownVAModel){
                UnresolvedICC.v().addInfo(stmt, target, "Unresolved Intent");
                return allPossibleFieldTargets;
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
                    UnresolvedICC.v().addInfo(stmt, target, "Unresolved Intent");
                    return allPossibleFieldTargets;
                }
                // get the class strings
                Set<String> mClassObjects = ((StringVAModel)mClassVAModel).getValues();
                for(String mClassObject : mClassObjects) {
                    targetClsStrings.add(getHarnessFldForClsString(mClassObject));
                }
            }
        }
        return targetClsStrings;
    }

    /**
     * @return set of class strings that the passed in explicit intent may target
     *         null if we cannot resolved them unambiguously
     */
    public Set<SootField> getImplicitIntentInAppTargetClsStrings(IAllocNode allocNode, Stmt stmt, SootMethod target, 
        RefVAModel intentRefVAModel, AndroidComponents component,
        Set<SootField> allPossibleFieldTargets) {
        
        Set<SootField> calculatedTargets = new HashSet<SootField>();
        calculatedTargets.addAll(allPossibleFieldTargets);
        
        //if the intent values cannot be resolved, still should remove all components that don't define
        //an intent filter
        
        // for each component
        // for each intentFilter
        // if match, return cls string of activity
        for (ComponentBaseElement manifestComp : Resources.v().getManifest().getComponentsByType(component)) {
            SootField harnessField = getHarnessFldForClsString(manifestComp.getSootClass().getName());
            
            if (harnessField == null) {
                logger.error("No harness field for manifest class: {}", manifestComp.getSootClass());
            }
            
            if (!manifestComp.hasIntentFilter()) {
                calculatedTargets.remove(harnessField);
            }
            
            
        }
        
        
        UnresolvedICC.v().addInfo(stmt, target, "Unresolved Intent");
        return calculatedTargets;
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
