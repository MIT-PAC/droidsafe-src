package droidsafe.analyses.value;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
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
import droidsafe.analyses.value.ImplicitIntentModel.ImplicitIntentFields;
import droidsafe.analyses.value.primitives.ClassVAModel;
import droidsafe.analyses.value.primitives.StringVAModel;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Hierarchy;
import droidsafe.android.app.resources.AndroidManifest.ComponentBaseElement;
import droidsafe.android.app.resources.AndroidManifest.IntentFilter;
import droidsafe.android.app.resources.Resources;
import droidsafe.android.system.AndroidComponents;
import droidsafe.reports.UnresolvedICC;
import droidsafe.transforms.objsensclone.ClassCloner;

public class IntentUtils {

    private Set<IAllocNode> queriedNodes;

    private static IntentUtils v;

    public static IntentUtils v() {
        if (v == null)
            v = new IntentUtils();

        return v;
    }

    private Map<IAllocNode, IntentModel> allocToIntentModel;
    
    private static final Logger logger = LoggerFactory.getLogger(IntentUtils.class);

    public IntentUtils() {
        queriedNodes = new LinkedHashSet<IAllocNode>();
        allocToIntentModel = new HashMap<IAllocNode, IntentModel>();       
    }

    public Set<IAllocNode> getAllQueriedIntents() {
        return queriedNodes;
    }
    
    /**
     * Return (and possibly create) the Intent model for the given intent alloc node used in 
     * stmt that targets the IPC method target.
     */
    public IntentModel getIntentModel(IAllocNode node) {
        if (!(node.getType() instanceof RefType) ||
                !(ClassCloner.getClonedClassFromClone(((RefType)node.getType()).getSootClass()).
                        equals(Scene.v().getSootClass("android.content.Intent")))) {
            logger.error("Called getIntentModel on non Intent type: {}", node);
        }

        if (!allocToIntentModel.containsKey(node)) {
            //if we get here, we have to make the intent model
            VAModel vaModel = ValueAnalysis.v().getResult(node);
            if(vaModel != null && vaModel instanceof RefVAModel) {
                RefVAModel intentRefVAModel = (RefVAModel)vaModel;
                //add all targets of this intent
                switch(getIntentType(intentRefVAModel)) {
                    case EXPLICIT:                    
                        IntentModel im = ResolvedExplicitIntent.createModelForExplicitIntent(node, intentRefVAModel);
                        allocToIntentModel.put(node, im);
                        break;
                    case IMPLICIT:  
                        IntentModel iModel = ImplicitIntentModel.createModelForImplicitIntent(node, intentRefVAModel);
                        allocToIntentModel.put(node, iModel);
                        break;   
                    case UNKNOWN:
                        allocToIntentModel.put(node, UnresolvedIntent.v());
                        break;
                }               
            } else {
                //no va model, so intent is unresolved
                allocToIntentModel.put(node, UnresolvedIntent.v());
            }
        }

        return allocToIntentModel.get(node);
    }
    
    /**
     * Return set of fields of the harness for components that could be targeted with by the 
     * Intent model  Use the value analysis result to resolve field of the Intent and
     * find destination components of the given component type.  If the Intent cannot be resolved,
     * then return all components of the given type in the application.
     */
    public Set<SootField> getIntentTargetHarnessFields(AndroidComponents component, IntentModel im) {
        
        Set<SootField> allHarnessActivityFlds = new LinkedHashSet<SootField>();

        for (SootClass clz : Harness.v().getCreatedClasses()) {
            if (Hierarchy.inheritsFromAndroidComponent(component, clz)) {
                allHarnessActivityFlds.add(Harness.v().getFieldForCreatedClass(clz));
            }
        }

        Set<SootField> targetFields;
        if (im instanceof ResolvedExplicitIntent) {
            targetFields = getExplicitIntentTargetClsStrings((ResolvedExplicitIntent)im, 
                    allHarnessActivityFlds);
        } else if (im instanceof ImplicitIntentModel) {
            targetFields = getImplicitIntentInAppTargetClsStrings((ImplicitIntentModel)im, 
                    component, allHarnessActivityFlds);
        } else {
            //unresolved, add all fields of component type
            targetFields = allHarnessActivityFlds;            
        }       
        
        return targetFields;
    }
    
    /**
     * Return set of fields of the harness for components that could be targeted with by the 
     * Intent alloc node.  Use the value analysis result to resolve field of the Intent and
     * find destination components of the given component type.  If the Intent cannot be resolved,
     * then return all components of the given type in the application.
     */
    public Set<SootField> getIntentTargetHarnessFields(AndroidComponents component, Stmt stmt, 
        SootMethod target, IAllocNode allocNode) {  
        IntentModel im = getIntentModel(allocNode);
        if (im instanceof UnresolvedIntent) 
            recordUnresolvedStmt(allocNode, stmt, target, "Unresolved Intent");
        
        return getIntentTargetHarnessFields(component, im);

    }

    /**
     * Record that this intent is unresolved, and record that the stmt has an unresolved target.
     */
    private void recordUnresolvedStmt(IAllocNode node, Stmt stmt, SootMethod target, String comment) {
        UnresolvedICC.v().addInfo(stmt, target, comment);
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
     */
    public Set<SootField> getExplicitIntentTargetClsStrings(ResolvedExplicitIntent intent, Set<SootField> allPossibleFieldTargets) {
        
        // container for results
        Set<SootField> targetClsStrings = new HashSet<SootField>();
        
        for (String value : intent.getComponentNames()) {
            targetClsStrings.add(getHarnessFldForClsString(value));
        }
        
        return targetClsStrings;       
    }

    /**
     * @return set of class strings that the passed in explicit intent may target
     *         null if we cannot resolved them unambiguously
     */
    public Set<SootField> getImplicitIntentInAppTargetClsStrings(ImplicitIntentModel intent,
        AndroidComponents component, Set<SootField> allPossibleFieldTargets) {
        
        Set<SootField> calculatedTargets = new HashSet<SootField>();
        calculatedTargets.addAll(allPossibleFieldTargets);
        
        
        // for each component
        for (ComponentBaseElement manifestComp : Resources.v().getManifest().getComponentsByType(component)) {
            SootField harnessField = getHarnessFldForClsString(manifestComp.getSootClass().getName());

            if (harnessField == null) {
                logger.error("No harness field for manifest class: {}", manifestComp.getSootClass());
            }
                      
            //if the intent values cannot be resolved, still should remove all components that don't define
            //an intent filter
            if (!manifestComp.hasIntentFilter()) {
                calculatedTargets.remove(harnessField);
                logger.info("Implicit Intent Test Failed, no intent filter for {}", manifestComp);
                continue;
            }
            
            boolean matchesSomeIntentFilter = false;
            for (IntentFilter intentfilter : manifestComp.intent_filters) {
            
                //action test, if actions don't match, then remove component from target list
                if (!actionsMatch(intent, intentfilter)) {
                    logger.info("Implicit Intent Action Test, failed for Intent {} on Filter of {}", intent, intentfilter);
                    continue;
                }            

                logger.info("Implicit Intent Action Test, passed for Intent {} on Filter of {}", intent, intentfilter);

                //category test            
                if (!categoriesMatch(intent, intentfilter)) {
                    logger.info("Implicit Intent Category Test, failed for Intent {} on Filter {}", intent, intentfilter);
                    continue;
                }

                logger.info("Implicit Intent Category Test, passed for Intent {} on Filter of {}", intent, intentfilter);

                //data and type test

                if (!typesMatch(intent, intentfilter)) {
                    logger.info("Implicit Intent Type Test Failed for Intent {} on Filter {}", intent, intentfilter);
                    continue;                
                }

                logger.info("Implicit Intent Type Test passed for Intent {} on Filter {}", intent, intentfilter);

                if (!dataMatch(intent, intentfilter)) {
                    logger.info("Implicit Intent Data Test Failed for Intent {} on Filter {}", intent, intentfilter);
                    continue;
                }
                
                logger.info("Implicit Intent Data Test passed for Intent {} on Filter {}", intent, intentfilter);
                
                //everything passed so pass                
                //no need to find another match
                matchesSomeIntentFilter = true;
                break;
            }
            
            //no matches so remove component
            if (!matchesSomeIntentFilter) {
                calculatedTargets.remove(harnessField);
                logger.info("** Implicit Intent test FAILED for {} and component {}", intent, manifestComp);
            } else {
                logger.info("** Implicit Intent test PASSED for {} and component {}", intent, manifestComp);
            }
        }
        
        
        //UnresolvedICC.v().addInfo(stmt, target, "Unresolved Intent");
        return calculatedTargets;
    }

    /**
     * 
     */
    public boolean getDataFieldForIntent(RefVAModel intentRefVAModel, Set<String> resolvedValues) {
        SootClass clonedIntentSootClass = ((RefType)(intentRefVAModel.getAllocNode().getType())).getSootClass();
        SootClass intentSootClass = ClassCloner.getClonedClassFromClone(clonedIntentSootClass);

        // iterate over every possible data field value
        Set<VAModel> dataFldVAModels = intentRefVAModel.getFieldVAModels(intentSootClass.getFieldByName("mData"));
        for(VAModel dataFldVAModel : dataFldVAModels) {
            if(dataFldVAModel.invalidated() || dataFldVAModel instanceof UnknownVAModel ){
                return false;
            }
            RefVAModel uriRefVAModel = (RefVAModel)dataFldVAModel;
            SootClass clonedURISootClass = ((RefType)(uriRefVAModel.getAllocNode().getType())).getSootClass();
            SootClass uriSootClass = ClassCloner.getClonedClassFromClone(clonedURISootClass);
            // iterate over every possible action field value
            Set<VAModel> uriStringFldVAModels = uriRefVAModel.getFieldVAModels(uriSootClass.getFieldByName("uriString"));
            for(VAModel uriStringFldVAModel : uriStringFldVAModels) {
                if(uriStringFldVAModel.invalidated() || (!(uriStringFldVAModel instanceof StringVAModel))){
                    return false;
                }
                
                //if we get here, it is a resolved string va model value
                for (String str : ((StringVAModel)uriStringFldVAModel).getValues()) {
                    resolvedValues.add(str);
                }
            }
        }
        
        return true;
    }
    
    /**
     * Try to get resolved field values for intent.  
     * 
     * Return true if all resolved.  False otherwise.
     * 
     * If all resolved, then return the list of strings in the resolvedValues set
     */
    public boolean getFieldFromImplicitIntent(String fieldName, RefVAModel intentRefVAModel, Set<String> resolvedValues) {
        SootClass clonedIntentSootClass = ((RefType)(intentRefVAModel.getAllocNode().getType())).getSootClass();
        SootClass intentSootClass = ClassCloner.getClonedClassFromClone(clonedIntentSootClass);

        // iterate over every possible field value
        Set<VAModel> fldVAModels = intentRefVAModel.getFieldVAModels(intentSootClass.getFieldByName(fieldName));
        for(VAModel fldVAModel : fldVAModels) {
            
            logger.info("For {}, VA Type {} {}", fieldName, fldVAModel, fldVAModel.getClass());
            
            if (fldVAModel.invalidated() || (!(fldVAModel instanceof StringVAModel))){
                return false;
            } 
            
            //if we get here, it is a resolved string va model value
            for (String str : ((StringVAModel)fldVAModel).getValues()) {
                resolvedValues.add(str);
            }
        }
        
        //no field va models resolved
        return true;
    }
    
    /**
     * Return true if the action field matches for this intent / intent filter combination
     */
    private boolean actionsMatch(ImplicitIntentModel intent, IntentFilter intentFilter) {
        /*
         * 1. action of intent must match one of filters
         * 2. filter with no actions fails all tests
         * 3. intent with no action will pass if filter defines at least one action
         */
        
        //build list of filter actions
        Set<String> filterActions = new HashSet<String>();
        filterActions.addAll(intentFilter.actions); 
                
        for (String action : filterActions) {
            logger.info("Action Test, intent filter actions: {}", action);
        }
        
        // #2
        if (filterActions.size() == 0)
            return false;
        
        //build list of intent actions
        if (!intent.isFieldInvalidated(ImplicitIntentFields.ACTION)) {
            for (String intentAction : intent.getValues(ImplicitIntentFields.ACTION)) {
                logger.info("\tAction Test, checking intent action: {}", intentAction);
                //look for intent action in filter action
                if (filterActions.contains(intentAction))
                    return true;  //found action / return true
            }
            
            //could not find intent action in the intent filter actions
            logger.info("Action Test, could not find intent action in intent filter");
            return false;
        } else {
            //could not resolve actions from value analysis, so always match
            logger.info("Action Test Passed, could not resolve action field for Intent");
            return true;
        }
    }
    
    /**
     * Return true if the category field matches the intent filter.
     */
    private boolean categoriesMatch(ImplicitIntentModel intent, IntentFilter intentFilter) {
        /*
         *
          1. every category of intent must match a category in filter
             - reverse not necessary 
          
          2. Intent with no categories will pass all tests
          
          3. Android automatically applies CATEGORY_DEFAULT to all start activity / start activity for result
             - So intent filters on activities must delcare this category
             (this is taken care of by the modeling, we add this category to all intents called with startactivity
         */
        
        for (String category : intentFilter.categories) {
            logger.info("Category Test, intent filter categories: {}", category);
        }
                
        if (!intent.isFieldInvalidated(ImplicitIntentFields.CATEGORY)) {
            //# 2
            if (intent.getValues(ImplicitIntentFields.CATEGORY).size() == 0)
                return true;
            
            for (String filterCategory : intentFilter.categories) {
                //if one of the filter categories could not possibly be in the intent, then return false 
                if (!intent.getValues(ImplicitIntentFields.CATEGORY).contains(filterCategory)) {
                    return false;
                }                
            }
            
            //all categories in filter could be in the intent
            return true;
        } else {
            //could not resolve categories from va, so always match
            logger.info("Category Test Passed, could not resolve category field for Intent");
            return true;
        }
    }
    
    /**
     * return true if types match from intent to component manifest mimetype data filter
     */
    private boolean typesMatch(ImplicitIntentModel intent, IntentFilter intentFilter) {
        /*
         * due to flow insensitivity, if any of type value in intent matches filter, then pass
         */
             
        for (String type : intentFilter.dataMime) {
            logger.info("Type Test, intent filter types: {}", type);
        }
        
        
        if (!intent.isFieldInvalidated(ImplicitIntentFields.TYPE)) {
            Set<String> intenttypes = intent.getValues(ImplicitIntentFields.TYPE);
            //nothing to check
            if (intenttypes.size() == 0 && intentFilter.dataMime.size() == 0)
                return true;
            
            //if the intent does not specify a type and the filter does, then it cannot pass 
            if (intenttypes.size() == 0 && intentFilter.dataMime.size() > 0 )
                return false;
            
            //check if any of the possible intent types match
            for (String intentType : intenttypes) {
                for (String filterType : intentFilter.dataMime) {
                    if (filterType.contains("*")) {
                        //some wildcard
                        if (intentType.startsWith(filterType.substring(0, filterType.indexOf('*'))))
                            return true;
                    } else if (filterType.equals(intentType))
                        return true;                        
                    }
                }
                    
            //no type matches
            return false;
        } else {
            logger.info("Type Test Passed, could not resolve type field for Intent");
            return true;
        }
    }
    
    
    /**
     * return true if data of intent could match intent filter.
     */
    private boolean dataMatch(ImplicitIntentModel intent, IntentFilter intentFilter) {
        
        for (String data : intentFilter.dataUri) {
            logger.info("Data Test, intent filter has data: {}", data);
        }        
                        
        if (!intent.isFieldInvalidated(ImplicitIntentFields.DATA)) {            
            Set<String> intentDatas = intent.getValues(ImplicitIntentFields.DATA);
            //if no data in intent and no data in filter, then match
            if (intentDatas.size() == 0 && intentFilter.dataUri.size() == 0)
                return true;
            
            //if any of the intent uri could match a filter uri, then it could be a target
            for (String intentData : intentDatas) {
                //if we get here, this intent data is valid
                //so check against all re's for intent filter
                for (String filterData : intentFilter.dataUri) {
                    if (intentData.matches(filterData)) {
                        logger.info("Data Test, intent data {} matched filter {}", intentData, filterData);
                        return true;
                    }
                }
            }
            
            //we resolved all valid uri's and none of them matched a filter, so false;
            return false;
        } else {
            logger.info("Data Test Passed, could not resolve mData field for Intent");
            return true;
        }
    }
}
