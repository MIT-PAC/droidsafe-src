package droidsafe.eclipse.plugin.core.view;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import droidsafe.speclang.model.SecuritySpecModel;

/**
 * Content provider for the tree structure of the points-to outline view.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
abstract public class SpecInfoTreeElementContentProvider extends DroidsafeInfoTreeElementContentProvider {

    /** The method which points-to info is to be displayed in the outline view */
    protected SecuritySpecModel fSpec;

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        this.fViewer = (TreeViewer) viewer;
        if (newInput instanceof SecuritySpecModel) {
            this.fSpec = (SecuritySpecModel) newInput;
        }
    }

}
