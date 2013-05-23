package droidsafe.eclipse.plugin.core.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

import droidsafe.eclipse.plugin.core.view.SecuritySpecOutlineViewPart;

public class CollapseAll extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    IWorkbenchPart part = HandlerUtil.getActivePart(event);
    if (part instanceof SecuritySpecOutlineViewPart) {
      SecuritySpecOutlineViewPart droidsafeView = (SecuritySpecOutlineViewPart) part;
      TreeViewer viewer = droidsafeView.getViewer();
      if (viewer != null) {
        expandViewer(viewer);
      }
    }
    return null;
  }


  private void expandViewer(final TreeViewer treeViewer) {
    final Runnable expand = new Runnable() {
      public void run() {
        treeViewer.collapseAll();
      }
    };
    Display.getDefault().asyncExec(expand);
  }
}
