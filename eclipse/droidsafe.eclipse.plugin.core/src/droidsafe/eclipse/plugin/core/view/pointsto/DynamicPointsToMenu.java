package droidsafe.eclipse.plugin.core.view.pointsto;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IWorkbenchPage;

import droidsafe.eclipse.plugin.core.Activator;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.speclang.model.AllocLocationModel;
import droidsafe.speclang.model.MethodModel;

/**
 * Dynamic menu item for points-to info.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class DynamicPointsToMenu extends ContributionItem {

    /**
     * Creates a dynamic points-to menu item.
     */
    public DynamicPointsToMenu() {
        super();
    }

    /**
     * Creates a dynamic points-to menu item with the given id.
     */
    public DynamicPointsToMenu(String id) {
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
        IWorkbenchPage page = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
        ISelection sel = page.getSelection();
        if (sel instanceof IStructuredSelection) {
            IStructuredSelection selectedObjects = ((IStructuredSelection) sel);
            for (Object selection : selectedObjects.toList()) {
                if (selection instanceof TreeElement<?, ?>) {
                    TreeElement<?, ?> element = (TreeElement<?, ?>) selection;
                    Object data = element.getData();
                    if (data instanceof MethodModel) {
                        List<MethodArgumentModel> methodArgModels = new ArrayList<MethodArgumentModel>();
                        MethodModel method = (MethodModel) data;
                        List<AllocLocationModel> recieverSources = method.getReceiverAllocSources();
                        if (recieverSources != null && !recieverSources.isEmpty()) {
                            // create the menu item
                            methodArgModels.add(new MethodArgumentModel(method, -1));
                        }
                        List<String> args = method.getMethodArguments();
                        for (int i = 0; i < args.size(); i++) {
                            List<AllocLocationModel> argSources = method.getArgumentAllocSources(i);
                            if (!argSources.isEmpty()) {
                                // create the menu item
                                methodArgModels.add(new MethodArgumentModel(method, i));
                            }
                        }
                        if (!methodArgModels.isEmpty()) {
                            MenuItem menuItem = new MenuItem(menu, SWT.PUSH, index);
                            addSelectionListener(methodArgModels.toArray(new MethodArgumentModel[0]), menuItem);
                        }
                    } 
                }
            }
        }
    }

    /**
     * Add selection listener to the dynamic menu item. Open the points-to outline when the 
     * menu item is selected.
     */
    protected void addSelectionListener(final MethodArgumentModel[] methodArgumentModels,
            MenuItem menuItem) {
        StringBuffer buf = new StringBuffer("Show Points-to Info (");
        for (int i = 0; i < methodArgumentModels.length; i++) {
            if (i > 0)
                buf.append(", ");
            buf.append(methodArgumentModels[i].getShortDesc());
        }
        buf.append(')');
        menuItem.setText(buf.toString());
        menuItem.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                    PointsToViewPart.openView(methodArgumentModels);
            }
        });
    }


}
