package droidsafe.analyses.value.models.android.view;

import droidsafe.analyses.value.ValueAnalysisModeledObject;

import soot.jimple.spark.pag.AllocNode;

/**
 * @author dpetters
 */
public abstract class Window extends ValueAnalysisModeledObject {

    public Window(){}

    public Window(AllocNode allocNode) {
        super(allocNode);
    }
}
