package droidsafe.eclipse.plugin.core.commands;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import droidsafe.eclipse.plugin.core.view.pointsto.MethodArgumentModel;
import droidsafe.eclipse.plugin.core.view.pointsto.PointsToViewPart;

public class OpenPointsToView extends AbstractHandler {

    public static final String COMMAND_ID = "droidsafe.eclipse.plugin.core.commands.OpenPointsToView";

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IWorkbenchPage activePage = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage();
        PointsToViewPart view = (PointsToViewPart) activePage.findView(PointsToViewPart.VIEW_ID);
        if (view == null) {
            // open the view
            try {
                view = (PointsToViewPart) activePage.showView(PointsToViewPart.VIEW_ID);
            } catch (PartInitException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        activePage.activate(view);
        return view;
    }

}
