package droidsafe.eclipse.plugin.core.commands;

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
            droidsafeView.refreshSpecAndOutlineView();
        } else if (part instanceof IndicatorViewPart) {
            ((IndicatorViewPart) part).updateView();
        }
        return null;
    }

}
