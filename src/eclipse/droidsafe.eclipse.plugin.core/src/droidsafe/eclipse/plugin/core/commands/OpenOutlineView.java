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

/**
 * 
 */
package droidsafe.eclipse.plugin.core.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import droidsafe.eclipse.plugin.core.view.spec.SecuritySpecOutlineViewPart;

/**
 * Command to open or display the droidsafe outline view from a button located in the main toolbar.
 * 
 * @author Marcel Becker (becker@kestrel.edu)
 * 
 */
public class OpenOutlineView extends AbstractHandler {

  /**
   * The command will create a new view if the outline view is closed, or bring it forward if it is
   * hidden behind some other view.
   */
  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
    IWorkbenchPage activePage = window.getActivePage();
    IViewPart view = activePage.findView(SecuritySpecOutlineViewPart.VIEW_ID);
    if (view == null) {
      // open the view
      try {
        view = activePage.showView(SecuritySpecOutlineViewPart.VIEW_ID);
      } catch (PartInitException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    activePage.activate(view);
    return null;
  }

}
