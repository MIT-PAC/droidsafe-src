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
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;

public class AddMarkers extends AbstractHandler {
  private static final Logger logger = LoggerFactory.getLogger(AddMarkers.class);

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    ISelection selection =
        HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
    if (selection != null & selection instanceof IStructuredSelection) {
      IStructuredSelection structuredSelection = (IStructuredSelection) selection;

      Object selectedObject = structuredSelection.getFirstElement();
      if (selectedObject instanceof IAdaptable) {
        IResource res = (IResource) ((IAdaptable) selectedObject).getAdapter(IResource.class);
        IProject project = res.getProject();
        if (project != null) {
          logger.debug("Project found: " + project.getName());
          DroidsafePluginUtilities.generateMarkersForSecuritySpecification(project);
        }
      }
    }
    return null;
  }
}
