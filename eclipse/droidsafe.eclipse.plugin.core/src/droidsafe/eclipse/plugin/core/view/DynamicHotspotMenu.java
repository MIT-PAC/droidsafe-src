package droidsafe.eclipse.plugin.core.view;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.eclipse.plugin.core.Activator;
import droidsafe.eclipse.plugin.core.specmodel.MethodModel;
import droidsafe.eclipse.plugin.core.specmodel.SecuritySpecModel;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;

public class DynamicHotspotMenu extends ContributionItem {
  
  @SuppressWarnings("unused")
  private static final Logger logger = LoggerFactory.getLogger(DynamicHotspotMenu.class);

  public DynamicHotspotMenu() {
    super();
  }

  public DynamicHotspotMenu(String id) {
    super(id);
  }


  @Override
  public boolean isDynamic() {
    return true;
  }

  @Override
  public void fill(Menu menu, int index) {
    // Here you could get selection and decide what to do
    // You can also simply return if you do not want to show a menu
    IWorkbenchPage page =
        Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
    ISelection sel = page.getSelection();
    IWorkbenchPart part = page.getActivePart();
    SecuritySpecModel spec = null;
    if (part instanceof SecuritySpecOutlineViewPart) {
      SecuritySpecOutlineViewPart droidsafeView = (SecuritySpecOutlineViewPart) part;
      spec = droidsafeView.getSecuritySpec();
    }

    if (sel instanceof IStructuredSelection) {
      IStructuredSelection selectedObjects = ((IStructuredSelection) sel);
      for (Object selection : selectedObjects.toList()) {
        if (selection instanceof TreeElement<?, ?>) {
          TreeElement<?, ?> element = (TreeElement<?, ?>) selection;
          Object data = element.getData();
          if (data instanceof MethodModel) {
            MethodModel method = (MethodModel) data;
            String returnType = method.getReturnType();
            if (returnType != null
                && (returnType.equals("java.lang.String")
                    || returnType.equals("java.lang.StringBuilder")
                    || returnType.equals("java.lang.StringBuffer") || returnType
                      .equals("java.lang.CharSequence"))) {
              // create the menu item
              MenuItem menuItem = new MenuItem(menu, SWT.PUSH, index);
              addReturnTypeSelectionListener(method, menuItem, spec);
            }
            int i = 0;
            for (String arg : method.getMethodArguments()) {
              if (arg != null
                  && (arg.equals("java.lang.String") || arg.equals("java.lang.StringBuilder")
                      || arg.equals("java.lang.StringBuffer") || arg
                        .equals("java.lang.CharSequence"))) {
                // create the menu item
                MenuItem menuItem = new MenuItem(menu, SWT.PUSH, index);
                addSelectionListener(method, i, menuItem, spec);
              }
              i++;
            }
          }
        }
      }
    }
  }

  protected void addSelectionListener(final MethodModel method, final int i, MenuItem menuItem,
      final SecuritySpecModel spec) {
    menuItem.setText("Add Hotspot for Argument " + i);
    menuItem.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent e) {
        // what to do when menu is subsequently selected.
        spec.addHotspot(method, i);
      }
    });
  }


  protected void addReturnTypeSelectionListener(final MethodModel method, MenuItem menuItem,
      final SecuritySpecModel spec) {
    menuItem.setText("Add Hotspot for Return Type");
    menuItem.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent e) {
        // what to do when menu is subsequently selected.
        spec.addHotspot(method, -1);
      }
    });
  }
}
