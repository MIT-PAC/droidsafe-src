package droidsafe.analyses.value;

import java.util.LinkedHashSet;
import java.util.Set;

public class ResolvedExplicitIntent extends IntentModel {
    /** Set of component names (fully qualified class names) resolved for the Intent */
    private Set<String> componentNames;
    
    public boolean isResolved() {
        return true;
    }
    
    public ResolvedExplicitIntent() {  
        componentNames = new LinkedHashSet<String>();
    }
    
    public ResolvedExplicitIntent(Set<String> componentNames) {
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
}
