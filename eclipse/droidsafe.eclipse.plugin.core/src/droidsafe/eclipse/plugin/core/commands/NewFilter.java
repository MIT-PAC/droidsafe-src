package droidsafe.eclipse.plugin.core.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import droidsafe.eclipse.plugin.core.view.indicator.IndicatorViewPart;
import droidsafe.eclipse.plugin.core.wizards.NewFilterWizard;

/**
 * Command to create a new filter for the current indicator display.
 * 
 * @author gilham
 *
 */
public class NewFilter extends AbstractHandler {

	/**
	 * Command implementation. Presents a wizard dialog for the user to specify a
	 * new filter for the current indicator display.
	 */
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IWorkbenchPart view = HandlerUtil.getActivePart(event);
        IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
        IWorkbenchPage activePage = window.getActivePage();

        if (view instanceof IndicatorViewPart) {
            IndicatorViewPart jsonView = (IndicatorViewPart) view;
            ISelection topSelection = activePage.getSelection();
            if (topSelection != null && topSelection instanceof IStructuredSelection) {
                IStructuredSelection structuredSelection = (IStructuredSelection) topSelection;

                NewFilterWizard wizard = new NewFilterWizard();
                wizard.init(jsonView, structuredSelection);
                // Create the wizard dialog
                WizardDialog dialog = new WizardDialog(window.getShell(),wizard);
                // Open the wizard dialog
                dialog.open();
            }
        }
        return null;
    }
}
