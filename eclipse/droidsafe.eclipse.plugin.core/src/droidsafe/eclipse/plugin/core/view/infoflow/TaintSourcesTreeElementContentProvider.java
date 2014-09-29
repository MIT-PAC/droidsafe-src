package droidsafe.eclipse.plugin.core.view.infoflow;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import droidsafe.eclipse.plugin.core.marker.TaintMarker;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementContentProvider;
import droidsafe.speclang.model.CallLocationModel;

public class TaintSourcesTreeElementContentProvider extends DroidsafeInfoTreeElementContentProvider {

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
     * Reset the content of this content provider.
     */
    @Override
    protected void reset() {
        inputToRoots.clear();
    }
    /**
     * Populate the tree elements of the info sources outline view. Return the root elements.
     */
    protected Object[] initializeRoots() {
        IMarker taintMarker = (IMarker) fInput;
        Object[] roots = NO_CHILDREN;
        try {
            Set<CallLocationModel> filteredSources = (Set<CallLocationModel>) taintMarker.getAttribute(TaintMarker.FILTERED_SOURCES);
            roots = new Object[filteredSources.size()];
            int i = 0;
            for (CallLocationModel source: filteredSources) {
                TreeElement<CallLocationModel, Object> root =
                        new TreeElement<CallLocationModel, Object>(source.toString(), source, Object.class);
                roots[i] = root;
                i++;
            }
        } catch (CoreException e) {
            e.printStackTrace();
        }
        return roots;
    }

}
