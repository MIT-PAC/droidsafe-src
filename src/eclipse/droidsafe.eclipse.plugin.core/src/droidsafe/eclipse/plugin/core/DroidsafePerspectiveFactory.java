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

package droidsafe.eclipse.plugin.core;

import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import droidsafe.eclipse.plugin.core.view.indicator.IndicatorViewPart;
import droidsafe.eclipse.plugin.core.view.infoflow.InfoFlowDetailsViewPart;
import droidsafe.eclipse.plugin.core.view.infoflow.InfoFlowSummaryViewPart;
import droidsafe.eclipse.plugin.core.view.pointsto.PointsToViewPart;
import droidsafe.eclipse.plugin.core.view.spec.SecuritySpecOutlineViewPart;
import droidsafe.eclipse.plugin.core.view.value.ValueViewPart;

/**
 * Droidsafe perspective factory that generates the initial page layout and visible
 * action set for the Droidsafe user interface.
 * 
 * @author gilham
 *
 */
public class DroidsafePerspectiveFactory implements IPerspectiveFactory {

    @Override
    public void createInitialLayout(IPageLayout layout) {
        String editorArea = layout.getEditorArea();

        IFolderLayout leftFolder = layout.createFolder("left", IPageLayout.LEFT, (float)0.25, editorArea); //$NON-NLS-1$
        leftFolder.addView(JavaUI.ID_PACKAGES);
        leftFolder.addView(SecuritySpecOutlineViewPart.VIEW_ID);
        leftFolder.addView(InfoFlowSummaryViewPart.VIEW_ID);
        leftFolder.addView(IndicatorViewPart.VIEW_ID);

        layout.addView(InfoFlowDetailsViewPart.VIEW_ID, IPageLayout.TOP, (float)0.5, editorArea);
        layout.addView(ValueViewPart.VIEW_ID, IPageLayout.RIGHT, (float)0.33, InfoFlowDetailsViewPart.VIEW_ID);
        layout.addView(PointsToViewPart.VIEW_ID, IPageLayout.RIGHT, (float)0.5, ValueViewPart.VIEW_ID);

        IFolderLayout outlineFolder = layout.createFolder("right", IPageLayout.RIGHT, (float)0.75, editorArea); //$NON-NLS-1$
        outlineFolder.addView(IPageLayout.ID_OUTLINE);

        // views - search
        layout.addShowViewShortcut(NewSearchUI.SEARCH_VIEW_ID);

        // 'Window' > 'Open Perspective' contributions
        layout.addPerspectiveShortcut(JavaUI.ID_PERSPECTIVE);
    }

}
