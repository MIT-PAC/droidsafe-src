/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

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

    protected Object fInput;
 
    /** A map from input objects to the corresponding arrays of root elements. */
    protected Map<Object, Object[]> inputToRoots = new HashMap<Object, Object[]>();

    /** A map from data objects to the tree element wrapping the data objects. */
    private Map<Object, TreeElement<?, ?>> treeElementMap =
            new HashMap<Object, TreeElement<?, ?>>();

    /**
     * Returns the root elements of the outline contents. Initializes and cached 
     * the root elements if necessary. 
     */
    public Object[] getRootElements() {
    	if (fInput != null) {
    		Object[] roots = inputToRoots.get(fInput);
    		if (roots == null) {
    			roots = initializeRoots();
    			setRootElements(roots);
    		}
    		return roots;
    	}
    	return NO_CHILDREN;
    }
    
    /**
     * Sets the root elements for the current input to 'rootElements'.
     */
    public void setRootElements(Object[] rootElements) {
    	if (fInput != null)
    		inputToRoots.put(fInput, rootElements);
    }

    /**
     * Resets the root elements for the current input to null.
     */
    public void resetRootElements() {
    	if (fInput != null)
    		inputToRoots.remove(fInput);
    }

    /**
     * Returns the sorted root elements.
     */
    public Object[] getSortedRootElements() {
    	Object[] rootElements = getRootElements();
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
    protected void reset() {
        inputToRoots.clear();
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
