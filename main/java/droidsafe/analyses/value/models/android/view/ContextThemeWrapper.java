package droidsafe.analyses.value.models.android.view;

import droidsafe.analyses.value.models.android.content.ContextWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;

/**
 * @author dpetters
 */
public class ContextThemeWrapper extends ContextWrapper {

    public ContextThemeWrapper(AllocNode allocNode) {
        super(allocNode);
    }
}
