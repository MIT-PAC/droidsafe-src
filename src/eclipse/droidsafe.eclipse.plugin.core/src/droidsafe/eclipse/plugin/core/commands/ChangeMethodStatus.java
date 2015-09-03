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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.handlers.HandlerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.speclang.model.CodeLocationModel;
import droidsafe.speclang.model.DroidsafeIssueResolutionStatus;
import droidsafe.speclang.model.MethodModel;

/**
 * Command to mark the selected element in the droidsafe outline view as safe, unsafe, pending, or
 * unresolved. All the children elements to the selected elements will also have their status
 * changed.
 * 
 * @author Marcel Becker (becker@kestrel.edu)
 * 
 */
public class ChangeMethodStatus extends AbstractHandler {

  @SuppressWarnings("unused")
  private final static Logger logger = LoggerFactory.getLogger(ChangeMethodStatus.class);
  
  /**
   * Command implementation. The command has a parameter that identifies the new status of the node.
   */
  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    IWorkbenchPage activePage = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage();
    //IViewPart view = activePage.findView(SecuritySpecOutlineViewPart.VIEW_ID);
    ISelection topSelection = activePage.getSelection();
    if (topSelection != null && topSelection instanceof IStructuredSelection) {

      String statusParameter =
          event.getParameter("droidsafe.eclipse.plugin.core.commands.parameter.methodStatus");
      DroidsafeIssueResolutionStatus status = null;
      if (statusParameter.equals("SAFE")) {
        status = DroidsafeIssueResolutionStatus.SAFE;
      } else if (statusParameter.equals("UNSAFE")) {
        status = DroidsafeIssueResolutionStatus.UNSAFE;
      } else if (statusParameter.equals("PENDING")) {
        status = DroidsafeIssueResolutionStatus.PENDING;
      } else if (statusParameter.equals("UNRESOLVED")) {
        status = DroidsafeIssueResolutionStatus.UNRESOLVED;
      }

      IStructuredSelection structuredSelection = (IStructuredSelection) topSelection;

      for (Object selection : structuredSelection.toList()) {
        if (selection instanceof TreeElement<?, ?>) {
          TreeElement<?, ?> element = (TreeElement<?, ?>) selection;
          setElementStatus(element, status);
        }
      }
    }
    return null;
  }

  /**
   * Helper method to set the node status and recursively set the status of the children.
   * 
   * @param element The tree node element we want to set the status.    * 
   * @param status The new status value (SAFE, UNSAFE, PENDING, UNRESOLVED). 
   */
  private void setElementStatus(TreeElement<?, ?> element, DroidsafeIssueResolutionStatus status) {
    Object data = element.getData();
    //logger.debug("Setting status for node {}", data);
    if (data instanceof CodeLocationModel) {
      ((CodeLocationModel) data).setStatus(status);
    } else if (data instanceof MethodModel) {
      ((MethodModel) data).setStatus(status);
    }
    if (element.hasChildren()) {
      for (TreeElement<?, ?> child : element.getChildren()) {
        setElementStatus(child, status);
      }
    }
  }

}
