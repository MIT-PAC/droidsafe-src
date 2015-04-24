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

import org.eclipse.jface.viewers.ISelectionChangedListener;

import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.speclang.model.MethodModel;

/**
 * View for displaying droidsafe analysis info on a given method. 
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
abstract public class MethodInfoOutlineViewPart extends DroidsafeInfoOutlineViewPart implements ISelectionChangedListener {

    /** The text displayed on the empty page. */
    public static String EMPTY_PAGE_LABEL = "Select a spec method from the 'Security Spec Outline', 'Info Flow Summary', or 'Indicator' to show info";
    
    /** The object on which the droidsafe analysis info is to be displayed. */
    protected Object fInputElement;

    /**
     * Sets the input element for the viewer and update the contents of the view.
     */
    protected void setInputElement(Object inputElement) {
        if ((inputElement == null && fInputElement != null) || 
                (inputElement != null && !inputElement.equals(fInputElement))) {
            fInputElement = inputElement;
            updateView();
        }
    }

    /**
     * Returns the input element for this outline.
     */
    public Object getInputElement() {
        return fInputElement;
    }

    /**
     * Resets the content when a different project is selected.
     */
    @Override
    protected void projectSelected() {
        resetViewer();
        setInputElement(null);
     }
    
    /**
     * Returns the method on which the droidsafe analysis info is displayed on this outline.
     */
    protected abstract MethodModel getMethod();

    /**
     * Update the content of the outline view.
     */
    protected void updateView() {
        if (fParentComposite != null) {
            if (fInputElement == null) {
                showEmptyPage();
            } else {
                showPage(PAGE_VIEWER);

                String sig = DroidsafePluginUtilities.removeCloneSuffix(getMethod().getSignature());
                setContentDescription("method " + sig);

                fTreeViewer.setInput(fInputElement);
            }
        }        
    }

}
