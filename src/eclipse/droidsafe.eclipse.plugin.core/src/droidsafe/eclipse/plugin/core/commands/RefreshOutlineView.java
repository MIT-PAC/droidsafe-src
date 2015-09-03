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

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

import droidsafe.eclipse.plugin.core.view.indicator.IndicatorViewPart;
import droidsafe.eclipse.plugin.core.view.spec.SecuritySpecOutlineViewPart;

/**
 * Command to refresh the Droidsafe outline view. The command reads the serialized version of the
 * spec, and resets the tree viewer in the outline window.
 * 
 * @author Marcel Becker
 * 
 */
public class RefreshOutlineView extends AbstractHandler {

    /**
     * Command implementation. Just retrieves the active part, the droidsafe outline part, and calls
     * the refresh method.
     */
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IWorkbenchPart part = HandlerUtil.getActivePart(event);
        if (part instanceof SecuritySpecOutlineViewPart) {
            SecuritySpecOutlineViewPart droidsafeView = (SecuritySpecOutlineViewPart) part;
            droidsafeView.refreshSpecAndOutlineView(true);
        } else if (part instanceof IndicatorViewPart) {
        	IndicatorViewPart indicatorView = (IndicatorViewPart) part;
        	File file = indicatorView.getInputElement();
        	indicatorView.forceReload(file);
        	indicatorView.updateView();
        }
        return null;
    }

}
