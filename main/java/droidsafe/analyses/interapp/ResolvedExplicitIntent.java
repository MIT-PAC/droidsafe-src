package droidsafe.analyses.interapp;

import java.util.LinkedHashSet;
import java.util.Set;

public class ResolvedExplicitIntent extends ResolvedIntent {
    /** Set of component names (fully qualified class names) resolved for the Intent */
    Set<String> componentNames = new LinkedHashSet<String>();
    
    public ResolvedExplicitIntent() {
        // TODO Auto-generated constructor stub
    }

    public void addComponentName(String name) {
        this.componentNames.add(name);
    }
}
