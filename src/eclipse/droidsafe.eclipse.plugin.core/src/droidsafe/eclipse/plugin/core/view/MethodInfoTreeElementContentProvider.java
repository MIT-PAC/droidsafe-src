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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import droidsafe.speclang.model.MethodModel;

/**
 * Content provider for the tree structure of a droidsafe method info outline view.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
abstract public class MethodInfoTreeElementContentProvider extends DroidsafeInfoTreeElementContentProvider {

    /** A map from input objects to the corresponding arrays of root elements. */
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
     * Resets the content of this content provider.
     */
    @Override
    protected void reset() {
        inputToRoots.clear();
    }

}
