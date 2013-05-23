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
import droidsafe.eclipse.plugin.core.specmodel.MethodModel;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.SecuritySpecOutlineViewPart;

/**
 * Command to mark the selected element in the droidsafe outline view as not safe.
 * 
 * @author Marcel Becker (becker@kestrel.edu)
 * 
 */
public class MarkMethodAsUnresolved extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    IWorkbenchPage activePage = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage();
    IViewPart view = activePage.findView(SecuritySpecOutlineViewPart.VIEW_ID);
    ISelection topSelection = activePage.getSelection();
    if (topSelection != null && topSelection instanceof IStructuredSelection) {
      IStructuredSelection structuredSelection = (IStructuredSelection) topSelection;

      for (Object selection : structuredSelection.toList()) {
        if (selection instanceof TreeElement<?, ?>) {
          TreeElement<?, ?> element = (TreeElement<?, ?>) selection;
          setElementAsUnresolved(element, view);
        }
      }
    }
    return null;
  }

  private void setElementAsUnresolved(TreeElement<?, ?> element, IViewPart viewPart) {
    boolean viewNeedsRefresh = false;
    Object data = element.getData();
    if (data instanceof CodeLocationModel && !((CodeLocationModel) data).isUnresolved()) {
      ((CodeLocationModel) data).setUnresolved();
      viewNeedsRefresh = true;
    } else if (data instanceof MethodModel && !((MethodModel) data).isUnresolved()) {
      ((MethodModel) data).setUnresolved();
      viewNeedsRefresh = true;
    }
    // TODO: remove the view refresh from the command.
    if (viewNeedsRefresh) {
      if (element.hasChildren()) {
        for (TreeElement<?, ?> child : element.getChildren()) {
          setElementAsUnresolved(child, viewPart);
        }
      }
      if (viewPart instanceof SecuritySpecOutlineViewPart) {
        ((SecuritySpecOutlineViewPart) viewPart).getViewer().update(element, null);
      }
    }
  }

}
