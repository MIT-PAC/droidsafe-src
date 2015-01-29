package droidsafe.eclipse.plugin.core.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

import droidsafe.eclipse.plugin.core.view.DroidsafeInfoOutlineViewPart;
import droidsafe.eclipse.plugin.core.view.spec.SecuritySpecOutlineViewPart;

public class ExpandAll extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    IWorkbenchPart part = HandlerUtil.getActivePart(event);
    TreeViewer viewer = null;
    if (part instanceof SecuritySpecOutlineViewPart) {
        viewer = ((SecuritySpecOutlineViewPart) part).getViewer();
    } else if (part instanceof DroidsafeInfoOutlineViewPart) {
        viewer = ((DroidsafeInfoOutlineViewPart) part).getViewer();
    }
    if (viewer != null) {
      expandViewer(viewer);
    }
    return null;
  }


  private void expandViewer(final TreeViewer treeViewer) {
    final Runnable expand = new Runnable() {
      public void run() {
        treeViewer.expandAll();
      }
    };
    Display.getDefault().asyncExec(expand);
  }

}
