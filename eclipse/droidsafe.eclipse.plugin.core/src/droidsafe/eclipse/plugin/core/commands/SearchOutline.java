package droidsafe.eclipse.plugin.core.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import droidsafe.eclipse.plugin.core.dialogs.SearchDialog;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoOutlineViewPart;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementContentProvider;

public class SearchOutline extends AbstractHandler {

    public static final String COMMAND_ID = "droidsafe.eclipse.plugin.core.commands.SearchOutline";

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IWorkbenchPart view = HandlerUtil.getActivePart(event);
        if (view instanceof DroidsafeInfoOutlineViewPart) {
        	DroidsafeInfoOutlineViewPart outlineView = (DroidsafeInfoOutlineViewPart) view;
        	DroidsafeInfoTreeElementContentProvider contentProvider = outlineView.getContentProvider();
            if (contentProvider.getRootElements() != null) {
                IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
                SearchDialog dialog = new SearchDialog(window.getShell(), outlineView);
                dialog.open();
            }
        }
        return null;
    }

}
