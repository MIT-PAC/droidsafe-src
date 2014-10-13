package droidsafe.eclipse.plugin.core.view.callgraph;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;

import com.google.gson.JsonObject;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.indicator.Utils;
import droidsafe.eclipse.plugin.core.view.infoflow.InfoFlowDetailsViewPart;
import droidsafe.eclipse.plugin.core.view.pointsto.PointsToViewPart;
import droidsafe.eclipse.plugin.core.view.value.ValueViewPart;
import droidsafe.speclang.model.MethodModel;

public class ContextMethodMenu extends CompoundContributionItem {

    @Override
    protected IContributionItem[] getContributionItems() {
    	IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    	ISelection selection = page.getSelection();
    	if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
    		Object selectedNode = ((IStructuredSelection) selection).getFirstElement();
    		if (selectedNode instanceof TreeElement<?, ?>) {
    			TreeElement<?, ?> treeElement = (TreeElement<?, ?>) selectedNode;
    			Object data = treeElement.getData();
    			if (data instanceof JsonObject) {
    				List<MethodModel> methods = Utils.getMethodModels((JsonObject) data);
    				int size = methods.size();
    				if (size > 1) {
    					IContributionItem[] items = new IContributionItem[size];
    					int i = 0;
    					for (final MethodModel method: methods) {
    						items[i++] = new ContributionItem() {

    							/*
    							 * (non-Javadoc)
    							 * 
    							 * @see org.eclipse.jface.action.ContributionItem#fill(org.eclipse.swt.widgets.Menu,
    							 *      int)
    							 */
    							public void fill(Menu menu, int index) {
    								MenuItem item = new MenuItem(menu, SWT.PUSH);
    								String label = DroidsafePluginUtilities.removeCloneSuffix(method.getSignature());
    								item.setText(label);
    								item.addListener(SWT.Selection, getMenuItemListener(method));
    							}

    							/**
    							 * Return the menu item listener for selection of a filter.
    							 * 
    							 * @param type
    							 * @param view
    							 * @return Listener
    							 */
    							private Listener getMenuItemListener(final MethodModel method) {
    								return new Listener() {
    									/*
    									 * (non-Javadoc)
    									 * 
    									 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
    									 */
    									public void handleEvent(Event event) {
    										InfoFlowDetailsViewPart.openView(method);
    										ValueViewPart.openView(method);
    										PointsToViewPart.openView(method);
    									}
    								};
    							}
    						};
    					}
    					return items;
    				}
    			}
    		}
    	}
    	return new IContributionItem[0];
   }

}
