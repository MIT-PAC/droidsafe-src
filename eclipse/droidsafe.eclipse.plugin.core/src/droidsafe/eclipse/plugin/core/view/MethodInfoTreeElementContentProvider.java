package droidsafe.eclipse.plugin.core.view;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import droidsafe.speclang.model.MethodModel;

/**
 * Content provider for the tree structure of the points-to outline view.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
abstract public class MethodInfoTreeElementContentProvider extends DroidsafeInfoTreeElementContentProvider {

    /** The method which points-to info is to be displayed in the outline view */
    protected MethodModel fMethod;

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        this.fViewer = (TreeViewer) viewer;
        if (newInput instanceof MethodModel) {
            this.fMethod = (MethodModel) newInput;
        }
    }

}
