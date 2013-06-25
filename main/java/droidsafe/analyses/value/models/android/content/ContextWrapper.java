package droidsafe.analyses.value.models.android.content;

import droidsafe.analyses.value.ValueAnalysisModeledObject;
import droidsafe.analyses.value.models.android.content.Context;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;

/**
 * @author dpetters
 */
public class ContextWrapper extends Context {

    Context mBase;

    public ContextWrapper(AllocNode allocNode) {
        super(allocNode);
    }

    @Override
    public Set<String> getPackageName() {
        return mBase.getPackageName();
    }
}
