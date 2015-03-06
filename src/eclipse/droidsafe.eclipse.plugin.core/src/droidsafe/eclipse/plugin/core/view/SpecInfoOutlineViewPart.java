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

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ISelectionChangedListener;

import droidsafe.speclang.model.SecuritySpecModel;

/**
 * View for displaying droidsafe analysis info on a given method. 
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
abstract public class SpecInfoOutlineViewPart extends DroidsafeInfoOutlineViewPart implements ISelectionChangedListener {

    /** The security spec on which the droidsafe analysis info is to be displayed. */
    protected SecuritySpecModel fInputElement;

    @Override
    protected String emptyPageText() {
    	IProject project = getProject();
    	if (project == null)
    		return "No Android Project selected. " +
    		"\nSelect an Android project in the Project Explorer.";
    	String projectName = project.getName();
    	return "No security spec found for the selected project " + projectName +
    			"\nYou need to first generate the security spec first from a shell.";
    }
    
    /**
     * Set the input element for the viewer and update the contents of the view.
     */
    protected void setInputElement(SecuritySpecModel inputElement) {
        if (!inputElement.equals(fInputElement)) {
            fInputElement = inputElement;
            updateView();
        }
    }

    /**
     * Return the input element for this outline.
     */
    public SecuritySpecModel getInputElement() {
        return fInputElement;
    }

//    protected void resetViewer() {
//        fInputElement = null;
//        if (fTreeViewer != null)
//            fTreeViewer.setInput(null);
//        ((MethodInfoTreeElementContentProvider) fContentProvider).reset();
//    }

    /**
     * Update the content of the outline view.
     */
    protected void updateView() {
        if (fInputElement != null && fParentComposite != null) {
            showPage(PAGE_VIEWER);
            
//            setContentDescription("project " + getProject().getName());
            
            fTreeViewer.setInput(fInputElement);
        }        
    }

}
