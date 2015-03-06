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

package droidsafe.eclipse.plugin.core.view.infoflow;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import droidsafe.eclipse.plugin.core.marker.TaintMarker;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementContentProvider;
import droidsafe.speclang.model.CallLocationModel;

/**
 * Content provider for the tree structure of a taint sources outline view.
 * 
 * @author gilham
 *
 */
public class TaintSourcesTreeElementContentProvider extends DroidsafeInfoTreeElementContentProvider {

    /** A map from input objects to the corresponding arrays of root elements. */
    protected Map<Object, Object[]> inputToRoots = new HashMap<Object, Object[]>();

    /** The taint marker whose taint sources are to be displayed in the outline view */
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
     * Populate the tree elements of the info sources outline view. The contents are of form:
     * 
     *   <info kind>
     *     <info source>
     *     ...
     *     <info source>
     *   ...
     *   <info kind>
     *     <info source>
     *     ...
     *     <info source>
     *     
     * Return the root elements.
     */
    protected Object[] initializeRoots() {
    	IMarker taintMarker = (IMarker) fInput;
    	Object[] roots = NO_CHILDREN;
    	Map<String, Set<CallLocationModel>> filteredSourcesMap = TaintMarker.getFilteredTaintSourcesMap(taintMarker);
    	roots = new Object[filteredSourcesMap.size()];
    	int i = 0;
    	for (Entry<String, Set<CallLocationModel>> entry: filteredSourcesMap.entrySet()) {
    		String taintKinds = entry.getKey();
    		TreeElement<String, CallLocationModel> root =
    				new TreeElement<String, CallLocationModel>(taintKinds, taintKinds, CallLocationModel.class);
    		for (CallLocationModel source: entry.getValue()) {
    			TreeElement<CallLocationModel, Object> child =
    					new TreeElement<CallLocationModel, Object>(source.toString(), source, Object.class);
    			root.addChild(child);
    		}
    		roots[i] = root;
    		i++;
    	}
    	return roots;
    }

}
