package droidsafe.analyses.interapp;

import java.util.LinkedHashSet;
import java.util.Set;

public class ResolvedImplicitIntent extends ResolvedIntent {
    /** Set of actions resolved */
    private Set<String> actions = new LinkedHashSet<String>();
    /** Set of categories resolved */
    private Set<String> categories = new LinkedHashSet<String>();
    /** Set of types resolved (regular expressions) */
    private Set<String> types = new LinkedHashSet<String>();
    /** Set of data uris resolved (regular expressions) */
    private Set<String> datas = new LinkedHashSet<String>();
    
    public ResolvedImplicitIntent() {
      
    }

}
