package droidsafe.eclipse.plugin.core.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.handlers.HandlerUtil;

import droidsafe.eclipse.plugin.core.specmodel.CodeLocationModel;
import droidsafe.eclipse.plugin.core.specmodel.DroidsafeIssueResolutionStatus;
import droidsafe.eclipse.plugin.core.specmodel.MethodModel;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.SecuritySpecOutlineViewPart;

/**
 * Command to mark the selected element in the droidsafe outline view as safe.
 * 
 * @author Marcel Becker (becker@kestrel.edu)
 * 
 */
public class ChangeMethodStatus extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    IWorkbenchPage activePage = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage();
    IViewPart view = activePage.findView(SecuritySpecOutlineViewPart.VIEW_ID);
    ISelection topSelection = activePage.getSelection();
    if (topSelection != null && topSelection instanceof IStructuredSelection) {

      String statusParameter =
          event.getParameter("droidsafe.eclipse.plugin.core.commands.parameter.methodStatus");
      DroidsafeIssueResolutionStatus status = null;
      if (statusParameter.equals("SAFE")) {
        status = DroidsafeIssueResolutionStatus.SAFE;
      } else if (statusParameter.equals("UNSAFE")) {
        status = DroidsafeIssueResolutionStatus.UNSAFE;
      } else if (statusParameter.equals("PENDING")) {
        status = DroidsafeIssueResolutionStatus.PENDING;
      } else if (statusParameter.equals("UNRESOLVED")) {
        status = DroidsafeIssueResolutionStatus.UNRESOLVED;
      }

      IStructuredSelection structuredSelection = (IStructuredSelection) topSelection;

      for (Object selection : structuredSelection.toList()) {
        if (selection instanceof TreeElement<?, ?>) {
          TreeElement<?, ?> element = (TreeElement<?, ?>) selection;
          setElementStatus(element, status, view);
        }
      }
    }
    return null;
  }

  private void setElementStatus(TreeElement<?, ?> element, DroidsafeIssueResolutionStatus status,
      IViewPart view) {
    Object data = element.getData();
    if (data instanceof CodeLocationModel) {
      ((CodeLocationModel) data).setStatus(status);
    } else if (data instanceof MethodModel) {
      ((MethodModel) data).setStatus(status);
    }
    if (element.hasChildren()) {
      for (TreeElement<?, ?> child : element.getChildren()) {
        setElementStatus(child, status, view);
      }
    }
  }

}
