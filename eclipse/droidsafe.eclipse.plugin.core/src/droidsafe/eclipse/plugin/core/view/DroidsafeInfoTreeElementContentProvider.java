package droidsafe.eclipse.plugin.core.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;

/**
 * Content provider for the tree structure of the points-to outline view.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
abstract public class DroidsafeInfoTreeElementContentProvider implements ITreeContentProvider, PropertyChangeListener {

    /** Constant to return when there are no children for an object */
    protected static final Object[] NO_CHILDREN = new Object[0];

    /** The tree viewer for the points-to outline view. */
    protected TreeViewer fViewer;
    
    @Override
    public void dispose() {}

    /**
     * Populate the tree elements of the points-to outline view. Return the root elements.
     */
    abstract protected Object[] initializeRoots();

    /**
     * Reset the content of this content provider.
     */
    abstract protected void reset();

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
