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

package droidsafe.eclipse.plugin.core.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import droidsafe.eclipse.plugin.core.view.indicator.IndicatorViewPart;
import droidsafe.eclipse.plugin.core.wizards.FiltersWizard;

/**
 * Command to set filters for the current indicator display.
 * 
 * @author gilham
 *
 */
public class SetFilters extends AbstractHandler {

	/**
	 * Command implementation. Presents a wizard dialog for the user to set
	 * filters for the current indicator display.
	 */
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IWorkbenchPart view = HandlerUtil.getActivePart(event);
        IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);

        if (view instanceof IndicatorViewPart) {
            IndicatorViewPart jsonView = (IndicatorViewPart) view;
            FiltersWizard wizard = new FiltersWizard();
            wizard.init(jsonView);
            // Create the wizard dialog
            WizardDialog dialog = new WizardDialog(window.getShell(),wizard);
            // Open the wizard dialog
            dialog.open();
        }
        return null;
    }
}
