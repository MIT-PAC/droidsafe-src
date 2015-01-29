package droidsafe.eclipse.plugin.core.view;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import droidsafe.speclang.model.SecuritySpecModel;

/**
 * Content provider for the tree structure of the security spec outline view.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
abstract public class SpecInfoTreeElementContentProvider extends DroidsafeInfoTreeElementContentProvider {

    /** A map from input objects to the corresponding arrays of root elements. */
    protected Map<Object, Object[]> inputToRoots = new HashMap<Object, Object[]>();

    /** The droidsafe security spec to be displayed in the outline view */
    protected SecuritySpecModel fSpec;


    @Override
    public Object[] getElements(Object input) {
        if (input instanceof SecuritySpecModel) {
            fSpec = (SecuritySpecModel) input;;
            Object[] roots = inputToRoots.get(fSpec);
            if (roots == null) {
                roots = initializeRoots();
                inputToRoots.put(fSpec, roots);
            }
            return roots;
        }
        return NO_CHILDREN;
    }

    /**
     * Resets the content of this content provider.
     */
    @Override
    protected void reset() {
        inputToRoots.clear();
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        this.fViewer = (TreeViewer) viewer;
        if (newInput instanceof SecuritySpecModel) {
            this.fSpec = (SecuritySpecModel) newInput;
        }
    }

}
