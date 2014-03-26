package droidsafe.eclipse.plugin.core.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.json.JsonViewPart;
import droidsafe.eclipse.plugin.core.view.spec.SecuritySpecOutlineViewPart;
import droidsafe.eclipse.plugin.core.wizards.NewFilterWizard;

public class NewFilter extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IWorkbenchPart view = HandlerUtil.getActivePart(event);
        IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
        IWorkbenchPage activePage = window.getActivePage();

        if (view instanceof JsonViewPart) {
            JsonViewPart jsonView = (JsonViewPart) view;
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
