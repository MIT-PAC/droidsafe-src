package droidsafe.eclipse.plugin.core.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import droidsafe.eclipse.plugin.core.view.indicator.IndicatorViewPart;
import droidsafe.eclipse.plugin.core.wizards.FiltersWizard;

/**
 * Command to set filters for the current indicator display.
 * 
 * @author gilham
 *
 */
public class SetFilters extends AbstractHandler {

	/**
	 * Command implementation. Presents a wizard dialog for the user to set
	 * filters for the current indicator display.
	 */
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IWorkbenchPart view = HandlerUtil.getActivePart(event);
        IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);

        if (view instanceof IndicatorViewPart) {
            IndicatorViewPart jsonView = (IndicatorViewPart) view;
            FiltersWizard wizard = new FiltersWizard();
            wizard.init(jsonView);
            // Create the wizard dialog
            WizardDialog dialog = new WizardDialog(window.getShell(),wizard);
            // Open the wizard dialog
            dialog.open();
        }
        return null;
    }
}
