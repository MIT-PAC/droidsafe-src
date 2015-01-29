package droidsafe.analyses.value;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.jimple.toolkits.pta.IAllocNode;
import droidsafe.analyses.value.primitives.ClassVAModel;
import droidsafe.analyses.value.primitives.StringVAModel;
import droidsafe.transforms.objsensclone.ClassCloner;

public class ResolvedExplicitIntent extends IntentModel {
    /** Set of component names (fully qualified class names) resolved for the Intent */
    private Set<String> componentNames;
    
    public static IntentModel createModelForExplicitIntent(IAllocNode node, RefVAModel intentRefVAModel) {
        // container for results
        Set<String> targetClsStrings = new HashSet<String>();
        // iterate over every possible componentName field value
        SootClass clonedIntentSootClass = ((RefType)(intentRefVAModel.getAllocNode().getType())).getSootClass();
        SootClass intentSootClass = ClassCloner.getClonedClassFromClone(clonedIntentSootClass);


        //first check the cls constant field
        SootField mClsComponentField = Scene.v().makeFieldRef(intentSootClass, "mClsComponent", 
            Scene.v().getSootClass("java.lang.Class").getType(), false).resolve();
        
        Set<VAModel> clsFldVAModels = intentRefVAModel.getFieldVAModels(mClsComponentField);
        
        boolean mClsComponentAllConstants = clsFldVAModels.size() > 0;
        if (clsFldVAModels.size() > 0) {          
            for (VAModel clz : clsFldVAModels) {
                if (clz.invalidated()) {
                    mClsComponentAllConstants = false;
                    continue;
                }

                if (clz instanceof ClassVAModel) {
                    ClassVAModel clzModel = (ClassVAModel)clz;
                    for (SootClass value : clzModel.getValues()) {
                        targetClsStrings.add(value.getName());
                    }
                } else {
                    mClsComponentAllConstants = false;
                    continue;
                } 
            }
        } 

        if (!mClsComponentAllConstants) {           
            //if we get here, we could not resolve the explicit intent based on the mClsComponent
            //now check the mComponent field
            //if that cannot be resolved, then we cannot resolve this explicit intent
            targetClsStrings.clear();
            
            SootField mComponentField = Scene.v().makeFieldRef(intentSootClass, "mComponent", 
                Scene.v().getSootClass("android.content.ComponentName").getType(), false).resolve();
            
            Set<VAModel> componentNameFldVAModels = intentRefVAModel.getFieldVAModels(mComponentField);

            for(VAModel componentNameFldVAModel : componentNameFldVAModels) {
                // if any of the component name VA models are invalidated, we cannot unambiguously determine all target
                // cls strings and must return null
                if(componentNameFldVAModel.invalidated() || componentNameFldVAModel instanceof UnknownVAModel){                    
                    return UnresolvedIntent.v();
                }
                // the next four lines get the VA models for the 'mClass' field
                RefVAModel componentNameRefVAModel = (RefVAModel)componentNameFldVAModel;
                SootClass clonedComponentNameSootClass = ((RefType)componentNameRefVAModel.getAllocNode().getType()).getSootClass();
                SootClass componentNameSootClass = ClassCloner.getClonedClassFromClone(clonedComponentNameSootClass);                
                
                SootField mClassField = Scene.v().makeFieldRef(componentNameSootClass, "mClass", 
                    Scene.v().getSootClass("java.lang.String").getType(), false).resolve();
                
                Set<VAModel> mClassVAModels = componentNameRefVAModel.getFieldVAModels(mClassField);

                for(VAModel mClassVAModel : mClassVAModels) {
                    // if any of the classVAModels are invalidated, we cannot unambiguously determine all target cls
                    // strings and must return null
                    if(mClassVAModel.invalidated() || mClassVAModel instanceof UnknownVAModel) {
                        return UnresolvedIntent.v();
                    }
                    // get the class strings
                    Set<String> mClassObjects = ((StringVAModel)mClassVAModel).getValues();
                    for(String mClassObject : mClassObjects) {
                        targetClsStrings.add(mClassObject);
                    }
                }
            }
        }
        
        //if we get here, the explicit intent is resolved
        //record intent model for explicit intent
        ResolvedExplicitIntent rei = new ResolvedExplicitIntent();
        for (String value : targetClsStrings) {
            rei.addComponentName(value);
        }
                
        return rei;
        
    }
    
    public boolean isResolved() {
        return true;
    }
    
    private ResolvedExplicitIntent() {  
        componentNames = new LinkedHashSet<String>();
    }
    
    private ResolvedExplicitIntent(Set<String> componentNames) {
        this.componentNames = componentNames;
    }

    public void addComponentName(String name) {
        this.componentNames.add(name);
    }

    public Set<String> getComponentNames() {
        return componentNames;
    }

    public void setComponentNames(Set<String> componentNames) {
        this.componentNames = componentNames;
    }
    
    public String toString() {
        String ret = "Explicit Intent[";
        for (String cn : componentNames) 
            ret += (cn + ";");
        
        return ret + "]";
    }
}
