package droidsafe.eclipse.plugin.core.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.RadioState;

import droidsafe.eclipse.plugin.core.view.DroidsafeInfoOutlineViewPart;
import droidsafe.eclipse.plugin.core.view.spec.SecuritySpecOutlineViewPart;


/**
 * Command to switch the type of label used to display method nodes in the droidsafe outline view.
 * When checked, the long form of the signature with fully qualified class names will be used in 
 * labels.
 * 
 */
public class LongLabel extends AbstractHandler {

    /**
     * Command implementation. Retrieves the value of the parameter value, and delegates to the view
     * to set the correct value for the methods labels.
     */
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IWorkbenchPart viewPart = HandlerUtil.getActivePart(event);
        if (viewPart instanceof DroidsafeInfoOutlineViewPart) {
            Command command = event.getCommand();
            boolean oldValue = HandlerUtil.toggleCommandState(command);
            ((DroidsafeInfoOutlineViewPart)viewPart).setLongLabel(!oldValue);
        }
        return null; 
    }

}
