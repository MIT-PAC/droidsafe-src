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
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.RadioState;

import droidsafe.eclipse.plugin.core.view.spec.SecuritySpecOutlineViewPart;

/**
 * Command to create the hierarchy of node to display in the Droidsafe Security Soec outline view.
 * 
 * The user can select the top level node in the tree view to be an input method, an output method,
 * or a code location.
 * 
 * @author Marcel Becker (becker@kestrel.edu)
 * 
 */
public class SetTopLevelNodeForView extends AbstractHandler {

  /**
   * Command implementation. The part has methods to select the appropriate hierarchy of nodes.
   * 
   */
  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    if (!HandlerUtil.matchesRadioState(event)) {
      IWorkbenchPart part = HandlerUtil.getActivePart(event);
      if (part instanceof SecuritySpecOutlineViewPart) {
        SecuritySpecOutlineViewPart droidsafeView = (SecuritySpecOutlineViewPart) part;

        String currentState = event.getParameter(RadioState.PARAMETER_ID);
        droidsafeView.setTopLevelNodeForView(currentState);
//        if (currentState.equals("input_method")) {
//
//          droidsafeView.setEntryPointsAsViewTopLevelParents();
//        } else if (currentState.equals("output_method")) {
//
//          droidsafeView.setApiCallsAsViewTopLevelParents();
//        } else if (currentState.equals("code_location")) {
//          droidsafeView.setCodeLocationAsViewTopLevelParents();
//        }
        // and finally update the current state
        HandlerUtil.updateRadioState(event.getCommand(), currentState);
      }
    }
    return null;
  }

}
