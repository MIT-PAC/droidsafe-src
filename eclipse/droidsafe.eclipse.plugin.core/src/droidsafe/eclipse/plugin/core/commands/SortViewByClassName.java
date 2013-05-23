package droidsafe.eclipse.plugin.core.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.eclipse.plugin.core.specmodel.MethodModel;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.SecuritySpecOutlineViewPart;
import droidsafe.utils.SourceLocationTag;

public class SortViewByClassName extends AbstractHandler {
  private static final Logger logger = LoggerFactory.getLogger(SortViewByClassName.class);

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    IWorkbenchPart part = HandlerUtil.getActivePart(event);
    if (part instanceof SecuritySpecOutlineViewPart) {
      SecuritySpecOutlineViewPart droidsafeView = (SecuritySpecOutlineViewPart) part;
      TreeViewer viewer = droidsafeView.getViewer();
      if (viewer != null) {
        viewer.setSorter(new ViewerSorter() {

          public int compare(Viewer view, Object o1, Object o2) {
            int result = 0;
            if (o1 instanceof TreeElement<?, ?> && o2 instanceof TreeElement<?, ?>) {
              Object oo1 = ((TreeElement<?, ?>) o1).getData();
              Object oo2 = ((TreeElement<?, ?>) o2).getData();
              logger.debug("Elements tested o1 {} o2 {} result {}", new Object[] {
                  ((TreeElement<?, ?>) o1).getName(), ((TreeElement<?, ?>) o2).getName()});
              return compare(view, oo1, oo2);

            } else if (o1 instanceof MethodModel && o2 instanceof MethodModel) {
              MethodModel m1 = (MethodModel) o1;
              MethodModel m2 = (MethodModel) o2;
              result = m1.getClassName().compareTo(m2.getClassName());
              logger.debug("Class Names m1 {} m2 {} result {}",
                  new Object[] {m1.getClassName(), m2.getClassName(), Integer.toString(result)});
              if (result == 0) {
                result = m1.getMethodName().compareTo(m2.getMethodName());
              }
              if (result == 0) {
                result = m1.getReturnType().compareTo(m2.getReturnType());
              }
              if (result == 0) {
                result = m1.getSignature().compareTo(m2.getSignature());
              }
              logger.debug("Class Names m1 {} m2 {} result {}",
                  new Object[] {m1.getClassName(), m2.getClassName(), Integer.toString(result)});
            } else if (o1 instanceof SourceLocationTag && o2 instanceof SourceLocationTag) {
              SourceLocationTag l1 = (SourceLocationTag) o1;
              SourceLocationTag l2 = (SourceLocationTag) o2;
              result = l1.getClz().compareTo(l2.getClz());
              if (result == 0) {
                result = Integer.valueOf(l1.getLine()).compareTo(Integer.valueOf(l2.getLine()));
              }
            }

            return result;
          }
        });
      }
    }
    // ISelection selection =
    // HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
    // if (selection != null & selection instanceof IStructuredSelection) {
    // IStructuredSelection strucSelection = (IStructuredSelection) selection;
    // for (Iterator<Object> iterator = strucSelection.iterator(); iterator.hasNext();) {
    // Object element = iterator.next();
    // System.out.println(element.toString());
    // }
    // }
    return null;
  }
}
