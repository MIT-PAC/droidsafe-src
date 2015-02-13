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

	@Override
    public Object[] getElements(Object input) {
        if (input instanceof SecuritySpecModel) {
            fInput = input;
            return getRootElements();
        }
        return NO_CHILDREN;
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        this.fViewer = (TreeViewer) viewer;
        if (newInput instanceof SecuritySpecModel) {
            this.fInput = newInput;
        }
    }
    
    protected SecuritySpecModel getSpec() {
    	return (SecuritySpecModel)fInput;
    }

}
