package droidsafe.eclipse.plugin.core.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.speclang.model.IModelChangeSupport;

/**
 * Content provider for the tree structure of a droidsafe outline view.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
abstract public class DroidsafeInfoTreeElementContentProvider implements ITreeContentProvider, PropertyChangeListener {

    /** Constant to return when there are no children for an object */
    protected static final Object[] NO_CHILDREN = new Object[0];

    /** The tree viewer for the outline view. */
    protected TreeViewer fViewer;
    
    /** The cached root elements in the outline view */
    protected Object[] rootElements;

    /** A map from data objects to the tree element wrapping the data objects. */
    private Map<Object, TreeElement<?, ?>> treeElementMap =
            new HashMap<Object, TreeElement<?, ?>>();

    /**
     * Returns the root elements of the outline contents. Initializes and cached 
     * the root elements if necessary. 
     */
    public Object[] getRootElements() {
        if (rootElements == null) {
            rootElements = initializeRoots();
        }
        return rootElements;
    }
    
    /**
     * Sets the root elements to 'rootElements'.
     */
    public void setRootElements(Object[] rootElements) {
        this.rootElements = rootElements;
    }

    /**
     * Returns the sorted root elements.
     */
    public Object[] getSortedRootElements() {
        if (rootElements != null)
            sort(rootElements);
        return rootElements;
    }
    
    /**
     * Returns the map from data objects to the tree element wrapping the data objects.
     */
    public Map<Object, TreeElement<?, ?>> getTreeElementMap() {
        return treeElementMap;
    }

    @Override
    public void dispose() {}

    /**
     * Populates the tree elements of the outline view. Return the root elements.
     */
    abstract protected Object[] initializeRoots();

    /**
     * Resets the content of this content provider.
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

    /**
     * Returns the sorted children of the given element 'parent'.
     */
    public Object[] getSortedChildren(Object parent) {
        Object[] children = getChildren(parent);
        sort(children);
        return children;
    }

    /**
     * Sorts the given elements using the comparator for the tree viewer.
     */
    public void sort(Object[] elements) {
        ViewerComparator comparator = fViewer.getComparator();
        if (comparator != null) {
            comparator.sort(fViewer, elements);
        }
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
     * is a TreeElement object, so we can call update directly on the element.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Object source = evt.getSource();
        // logger.debug("Updating node {}", source);
        if (this.fViewer != null) {
            this.fViewer.update(source, null);
        }
    }
    
    /**
     * Returns the tree element with the given data object.
     * 
     * @param data - The data object.
     * 
     * @return The tree node element wrapping the data object.
     * 
     */
    public TreeElement<?, ?> findTreeElement(Object data) {
        TreeElement<?, ?> result = treeElementMap.get(data);
        if (result != null && data.equals(result.getData())) {
            return result;
        }
        return null;
    }

}
