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

package droidsafe.eclipse.plugin.core.view.indicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import droidsafe.eclipse.plugin.core.filters.Filter;
import droidsafe.eclipse.plugin.core.filters.FilterPred;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementContentProvider;

/**
 * Content provider for the tree structure of an indicator outline view.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class IndicatorTreeElementContentProvider extends DroidsafeInfoTreeElementContentProvider {
    
    /** The top-level Json object representing the indicator to be displayed in the outline view. */
    protected JsonObject fInput;

    /** The underlying indicator outline view. */
    private IndicatorViewPart viewPart;

    /**
     * Constructs an IndicatorTreeElementContentProvider with the given indicator
     * outline view.
     */
    public IndicatorTreeElementContentProvider(IndicatorViewPart viewPart) {
        this.viewPart = viewPart;
    }

    /* (non-Javadoc)
     * @see droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementContentProvider#getRootElements()
     */
    public Object[] getRootElements() {
        Object[] rootElements = viewPart.getRootElements();
        if (rootElements == null) {
            rootElements = initializeRoots();
            viewPart.setRootElements(rootElements);
        }
        return rootElements;
    }
    
    /* (non-Javadoc)
     * @see droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementContentProvider#setRootElements(java.lang.Object[])
     */
    public void setRootElements(Object[] rootElements) {
        viewPart.setRootElements(rootElements);
    }

    /* (non-Javadoc)
     * @see droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementContentProvider#getSortedRootElements()
     */
    public Object[] getSortedRootElements() {
        Object[] rootElements = viewPart.getRootElements();
        if (rootElements != null)
            sort(rootElements);
        return rootElements;
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
     */
    @Override
    public Object[] getElements(Object input) {
        if (input instanceof JsonObject) {
            return getRootElements();
        } 
        return NO_CHILDREN;
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
     */
    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        this.fViewer = (TreeViewer) viewer;
        this.fInput = (JsonObject) newInput;
    }

    /**
     * Populates the tree elements of the indicator outline view applying the visibility control
     * and the filters. Returns the visible and filtered root elements.
     */
    protected Object[] initializeRoots() {
        getTreeElementMap().clear();
        List<TreeElement<JsonElement, JsonElement>> roots = new ArrayList<TreeElement<JsonElement, JsonElement>>();
        JsonArray rootArray = Utils.getChildrenArray(fInput);
        if (rootArray != null) {
            for (int i = 0; i < rootArray.size(); i++) {
                JsonElement rootElement = rootArray.get(i);
                if (!Utils.isEmptyJsonObject(rootElement)) {
                    List<TreeElement<JsonElement, JsonElement>> visibleRoots = initializeTree(rootElement);
                    roots.addAll(visibleRoots);
                }
            }
            roots = applyFilters(roots);
            return roots.toArray();
        }
        return NO_CHILDREN;
    }

    /**
     * Creates the tree elements for the given Json element if it is visible.
     * Returns the children tree elements or empty list if the Json element is not visible.
     */
    private List<TreeElement<JsonElement, JsonElement>> initializeTree(JsonElement jsonElement) {
        List<TreeElement<JsonElement, JsonElement>> result = new ArrayList<TreeElement<JsonElement, JsonElement>>();
        boolean visible = isVisible(jsonElement);
        TreeElement<JsonElement, JsonElement> element = null;
        if (visible) {
            element = new TreeElement<JsonElement, JsonElement>(jsonElement.toString(), jsonElement, JsonElement.class);
            getTreeElementMap().put(jsonElement, element);
            result.add(element);
        }
        JsonArray childrenArray = Utils.getChildrenArray(jsonElement);
        if (childrenArray != null) {
            for (int i = 0; i < childrenArray.size(); i++) {
                JsonElement childElement = childrenArray.get(i);
                if (!Utils.isEmptyJsonObject(childElement)) {
                    List<TreeElement<JsonElement, JsonElement>> children = initializeTree(childElement);
                    if (visible) {
                        for (TreeElement<JsonElement, JsonElement> child: children) {
                            element.addChild(child);
                        }
                    } else {
                        result.addAll(children);
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * Applies all filters to the trees rooted at the given root elements. Removes all the 
     * tree elements that are filtered out. Returns the resulting filtered root elements.
     * 
     * @param roots - the root elements
     * @return the filtered root elements
     */
    private List<TreeElement<JsonElement, JsonElement>> applyFilters(
            List<TreeElement<JsonElement, JsonElement>> roots) {
        for (Filter filter: viewPart.getFilters()) {
            if (filter.isEnabled()) {
                roots = applyFilter(roots, filter);
            }
        }
        return roots;
    }

    /**
     * Applies the given filter to the trees rooted at the given root elements. Removes all the 
     * tree elements that are filtered out. Returns the resulting filtered root elements.
     * 
     * @param roots - the root elements
     * @param filter - a filter
     * @return the filtered root elements
     */
    private List<TreeElement<JsonElement, JsonElement>> applyFilter(
            List<TreeElement<JsonElement, JsonElement>> roots, Filter filter) {
        List<TreeElement<JsonElement, JsonElement>> results = 
                new ArrayList<TreeElement<JsonElement, JsonElement>>();
        for (TreeElement<JsonElement, JsonElement> root: roots) {
            if (!isFiltered(root, filter)) {
                applyFilterToChildren(root, filter);
                results.add(root);
            }
        }
        return results;
    }

    /**
     * Applies the given filter to the descendants of the given tree element. Removes all the 
     * descendants that are filtered out from the tree.
     * 
     * @param element - a tree element
     * @param filter - a filter
     */
    private void applyFilterToChildren(TreeElement<JsonElement, JsonElement> element, Filter filter) {
        List<TreeElement<JsonElement, ?>> toRemove = new ArrayList<TreeElement<JsonElement, ?>>();
        for (TreeElement<JsonElement, ?> child : element.getChildren()) {
            if (isFiltered(child, filter)) {
                toRemove.add(child);
            } else {
                applyFilterToChildren((TreeElement<JsonElement, JsonElement>)child, filter);
            }
        }
        for (TreeElement<JsonElement, ?> child : toRemove) {
            element.removeChild(child);
        }
    }

    /**
     * Returns true if the given element is filtered out by the given filter.
     */
    private boolean isFiltered(TreeElement<JsonElement, ?> element, Filter filter) {
        JsonElement jsonElt = element.getData();
        FilterPred pred = filter.pred;
        switch (filter.type) {
            case EXCLUDE: return pred.apply(jsonElt);
            case INCLUDE: return !pred.apply(jsonElt);
            default: // SHOW
                return !satisfiedInTree(element, pred);
        }
    }

    /**
     * Returns true if the given filter predicate is satisfied by any of the elements
     * in the tree rooted at the given tree element
     * 
     * @param element - a tree element
     * @param pred - a filter predicate
     * @return true if the predicate is satisfied by any element in the tree
     */
    private boolean satisfiedInTree(TreeElement<JsonElement, ?> element, FilterPred pred) {
        JsonElement jsonElt = element.getData();
        boolean satisfied = pred.apply(jsonElt);
        if (satisfied)
            return true;
        for (TreeElement<?,?> child: element.getChildren()) {
            if (satisfiedInTree((TreeElement<JsonElement, ?>)child, pred))
                return true;
        }
        return false;
    }

    /**
     * Returns true the if given Json element is visible according to the
     * visibility control.
     */
    private boolean isVisible(JsonElement jsonElement) {
        Map<String, Boolean> visibilityMap = viewPart.getVisibilityMap();
        String type = Utils.getObjectType(jsonElement);
        if (type != null && visibilityMap.containsKey(type)) {
            return visibilityMap.get(type).booleanValue();
        }
        return true;
    }
    
    /**
     * Reset the content of this content provider.
     */
    @Override
    protected void reset() {
    }


}
