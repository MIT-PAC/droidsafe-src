package droidsafe.eclipse.plugin.core.view.pointsto;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.speclang.model.AllocLocationModel;
import droidsafe.speclang.model.CallLocationModel;

/**
 * Content provider for the tree structure of the points-to outline view.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class PointsToTreeElementContentProvider
        implements
            ITreeContentProvider,
            PropertyChangeListener {

    /** Constant to return when there are no children for an object */
    private static final Object[] NO_CHILDREN = new Object[0];

    /** The method arguments for which points-to info is to be displayed in the outline view */
    private MethodArgumentModel[] fMethodArgs;

    /** The tree viewer for the points-to outline view. */
    protected TreeViewer fViewer;

    @Override
    public void dispose() {}

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        this.fViewer = (TreeViewer) viewer;
        if (newInput instanceof MethodArgumentModel[]) {
            this.fMethodArgs = (MethodArgumentModel[]) newInput;
        }
    }

    @Override
    public Object[] getElements(Object input) {
        if (input instanceof MethodArgumentModel[]) {
            this.fMethodArgs = (MethodArgumentModel[]) input;
            return initializeRoots();
        }
        return NO_CHILDREN;
    }

    /**
     * Populate the tree elements of the points-to outline view. Return the root elements.
     */
    private Object[] initializeRoots() {
        Object[] roots = new Object[fMethodArgs.length];
        for (int i = 0; i < fMethodArgs.length; i++) {
            MethodArgumentModel methodArg = fMethodArgs[i];
            TreeElement<MethodArgumentModel, AllocLocationModel> root =
                    new TreeElement<MethodArgumentModel, AllocLocationModel>(methodArg.toString(),
                            methodArg, AllocLocationModel.class);
            roots[i] = root;
            List<AllocLocationModel> locs = methodArg.getAllocSources();
            for (AllocLocationModel loc : locs) {
                TreeElement<AllocLocationModel, CallLocationModel> locTreeElement =
                        new TreeElement<AllocLocationModel, CallLocationModel>(loc.toString(), loc, CallLocationModel.class);
                for (CallLocationModel call: loc.getCallsOnAlloc()) {
                    TreeElement<CallLocationModel, Object> callTreeElement =
                            new TreeElement<CallLocationModel, Object>(call.toString(), call, Object.class);
                    locTreeElement.addChild(callTreeElement);
                }
                root.addChild(locTreeElement);
            }
        }
        return roots;
    }

    @Override
    public Object getParent(Object child) {
        if (child instanceof TreeElement<?, ?>) {
            return ((TreeElement<?, ?>) child).getParent();
        }
        return null;
    }

    @Override
    public Object[] getChildren(Object parent) {
        if (parent instanceof TreeElement<?, ?>) {
            TreeElement<?, ?> treeElement = (TreeElement<?, ?>) parent;
            return treeElement.getChildren().toArray();
          }
          return NO_CHILDREN;
    }

    @Override
    public boolean hasChildren(Object parent) {
        if (parent instanceof TreeElement<?, ?>) {
            TreeElement<?, ?> element = (TreeElement<?, ?>) parent;
            return element.hasChildren();
        }
        return false;
    }

    /**
     * Changes in the model will trigger updates of the tree view. We assume the source of the event
     * is a TreeElement object, so we can call update diretcly on the element.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Object source = evt.getSource();
        // logger.debug("Updating node {}", source);
        if (this.fViewer != null) {
            this.fViewer.update(source, null);
        }
    }

}
