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
