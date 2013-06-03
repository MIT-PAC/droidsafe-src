package droidsafe.analyses.attr.models.android.view;

import droidsafe.analyses.attr.AttrModeledClass;

import soot.jimple.spark.pag.AllocNode;

/**
 * @author dpetters
 */
public abstract class Window extends AttrModeledClass {

    public Window(){}

    public Window(AllocNode allocNode) {
        super(allocNode);
    }
}
