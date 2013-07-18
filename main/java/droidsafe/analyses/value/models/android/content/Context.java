package droidsafe.analyses.value.models.android.content;

import droidsafe.analyses.value.models.android.content.IntentFilter;
import droidsafe.analyses.value.ValueAnalysisModeledObject;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;

/**
 * @author dpetters
 */
public abstract class Context extends ValueAnalysisModeledObject {

    public Set<IntentFilter> __ds__intentFilters = new HashSet<IntentFilter>();

    public Context(AllocNode allocNode) {
        super(allocNode);
    }
 
    // We pull out IntentFilters out of xml and register them with the appropriate subclasses of Context here 
    public void __ds__registerIntentFilter(IntentFilter intentFilter) {
        this.__ds__intentFilters.add(intentFilter);
    }

    /** Return the name of this application's package. */
    public abstract Set<String> getPackageName(); 
}
