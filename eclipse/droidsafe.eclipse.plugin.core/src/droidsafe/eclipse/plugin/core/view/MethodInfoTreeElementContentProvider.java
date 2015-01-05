package droidsafe.eclipse.plugin.core.view;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import droidsafe.speclang.model.MethodModel;

/**
 * Content provider for the tree structure of a droidsafe method info outline view.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
abstract public class MethodInfoTreeElementContentProvider extends DroidsafeInfoTreeElementContentProvider {

    /** A map from input objects to the corresponding arrays of root elements. */
    protected Map<Object, Object[]> inputToRoots = new HashMap<Object, Object[]>();

    /** The object on which the droidsafe analysis info is to be displayed in the outline view */
    protected Object fInput;

    @Override
    public Object[] getElements(Object input) {
        this.fInput = input;
        Object[] roots = inputToRoots.get(input);
        if (roots == null) {
            roots = initializeRoots();
            inputToRoots.put(input, roots);
        }
        return roots;
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        this.fViewer = (TreeViewer) viewer;
        this.fInput = newInput;
    }

    /**
     * Resets the content of this content provider.
     */
    @Override
    protected void reset() {
        inputToRoots.clear();
    }

}
