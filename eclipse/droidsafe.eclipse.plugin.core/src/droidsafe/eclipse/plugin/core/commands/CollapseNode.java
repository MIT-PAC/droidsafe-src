package droidsafe.eclipse.plugin.core.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.handlers.HandlerUtil;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.SecuritySpecOutlineViewPart;

public class CollapseNode extends AbstractHandler {

  
  @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
      // IWorkbenchPart part = HandlerUtil.getActivePart(event);
      IWorkbenchPage activePage = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage();
      IViewPart view = activePage.findView(SecuritySpecOutlineViewPart.VIEW_ID);
  
      if (view instanceof SecuritySpecOutlineViewPart) {
        SecuritySpecOutlineViewPart droidsafeView = (SecuritySpecOutlineViewPart) view;
        TreeViewer viewer = droidsafeView.getViewer();
  
        ISelection topSelection = activePage.getSelection();
        if (topSelection != null && topSelection instanceof IStructuredSelection) {
          IStructuredSelection structuredSelection = (IStructuredSelection) topSelection;
  
          for (Object selection : structuredSelection.toList()) {
            if (selection instanceof TreeElement<?, ?>) {
              TreeElement<?, ?> element = (TreeElement<?, ?>) selection;
              viewer.setExpandedState(element, false);
              for (TreeElement<?,?> child : element.getChildren()){
                viewer.setExpandedState(child, false);
              }
            }
          }
        }
      }
      return null;
    }

}
