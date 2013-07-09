package droidsafe.analyses.value.models.android.content;

import droidsafe.analyses.value.ValueAnalysisModeledObject;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;

/**
 * @author dpetters
 */
public abstract class Context extends ValueAnalysisModeledObject {

    public Context(AllocNode allocNode) {
        super(allocNode);
    }
    
    /** Return the name of this application's package. */
    public abstract Set<String> getPackageName(); 
}
