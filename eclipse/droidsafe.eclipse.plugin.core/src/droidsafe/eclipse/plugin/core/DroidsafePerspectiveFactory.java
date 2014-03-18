package droidsafe.eclipse.plugin.core;

import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import droidsafe.eclipse.plugin.core.view.infoflow.InfoFlowDetailsViewPart;
import droidsafe.eclipse.plugin.core.view.infoflow.InfoFlowSummaryViewPart;
import droidsafe.eclipse.plugin.core.view.json.CatchBlocksViewPart;
import droidsafe.eclipse.plugin.core.view.pointsto.PointsToViewPart;
import droidsafe.eclipse.plugin.core.view.spec.SecuritySpecOutlineViewPart;
import droidsafe.eclipse.plugin.core.view.value.ValueViewPart;

public class DroidsafePerspectiveFactory implements IPerspectiveFactory {

    @Override
    public void createInitialLayout(IPageLayout layout) {
        String editorArea = layout.getEditorArea();

        IFolderLayout leftFolder = layout.createFolder("left", IPageLayout.LEFT, (float)0.25, editorArea); //$NON-NLS-1$
        leftFolder.addView(JavaUI.ID_PACKAGES);
        leftFolder.addView(SecuritySpecOutlineViewPart.VIEW_ID);
        leftFolder.addView(InfoFlowSummaryViewPart.VIEW_ID);
        leftFolder.addView(CatchBlocksViewPart.VIEW_ID);

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
