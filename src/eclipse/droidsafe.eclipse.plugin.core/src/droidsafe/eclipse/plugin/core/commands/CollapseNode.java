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
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.handlers.HandlerUtil;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.spec.SecuritySpecOutlineViewPart;

public class CollapseNode extends AbstractHandler {

  
  @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
      // IWorkbenchPart part = HandlerUtil.getActivePart(event);
      IWorkbenchPage activePage = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage();
      IViewPart view = activePage.findView(SecuritySpecOutlineViewPart.VIEW_ID);
  
      if (view instanceof SecuritySpecOutlineViewPart) {
        SecuritySpecOutlineViewPart droidsafeView = (SecuritySpecOutlineViewPart) view;
        TreeViewer viewer = droidsafeView.getViewer();
  
        ISelection topSelection = activePage.getSelection();
        if (topSelection != null && topSelection instanceof IStructuredSelection) {
          IStructuredSelection structuredSelection = (IStructuredSelection) topSelection;
  
          for (Object selection : structuredSelection.toList()) {
            if (selection instanceof TreeElement<?, ?>) {
              TreeElement<?, ?> element = (TreeElement<?, ?>) selection;
              viewer.setExpandedState(element, false);
              for (TreeElement<?,?> child : element.getChildren()){
                viewer.setExpandedState(child, false);
              }
            }
          }
        }
      }
      return null;
    }

}
