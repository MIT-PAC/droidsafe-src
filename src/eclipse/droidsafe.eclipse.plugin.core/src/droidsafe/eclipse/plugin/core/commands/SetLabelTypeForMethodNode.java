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
 * Command to switch the type of label used to display method nodes in the droidsafe outline view.
 * Parameter value "short_label" will use the short form of the method signature and print argument
 * values, while parameter value "long_value" will print the long form of the signature with fully
 * qualified class names, but no attribute value.
 * 
 * @author Marcel Becker (becker@kestrel.edu)
 * 
 */
public class SetLabelTypeForMethodNode extends AbstractHandler {

  /**
   * Command implementation. Retrieves the value of the parameter value, and delegates to the view
   * to set the correct value for the methods labels.
   */
  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    if (!HandlerUtil.matchesRadioState(event)) {
      IWorkbenchPart part = HandlerUtil.getActivePart(event);
      if (part instanceof SecuritySpecOutlineViewPart) {
        SecuritySpecOutlineViewPart droidsafeView = (SecuritySpecOutlineViewPart) part;
        String currentState = event.getParameter(RadioState.PARAMETER_ID);
        droidsafeView.setLabelTypeForMethodName(currentState);
        // and finally update the current state
        HandlerUtil.updateRadioState(event.getCommand(), currentState);
      }
    }
    return null;
  }

}
