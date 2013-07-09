package droidsafe.analyses.value.models.android.app;

import droidsafe.analyses.value.models.android.content.ContextWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;

/**
 * @author dpetters
 */
public class Application extends ContextWrapper {

    public Application(AllocNode allocNode) {
        super(allocNode);
    }

    public void _init_(){
    }

    void dispatchActivityPaused(Activity activity) {}

    void dispatchActivityResumed(Activity activity) {}

    void dispatchActivityStarted(Activity activity) {}

    void dispatchActivityStopped(Activity activity) {}
}
