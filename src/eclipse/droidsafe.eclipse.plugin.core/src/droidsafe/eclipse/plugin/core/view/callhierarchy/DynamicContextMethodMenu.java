/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

package droidsafe.eclipse.plugin.core.view.callhierarchy;

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
import droidsafe.eclipse.plugin.core.view.indicator.IndicatorViewPart;
import droidsafe.eclipse.plugin.core.view.indicator.Utils;
import droidsafe.eclipse.plugin.core.view.infoflow.InfoFlowDetailsViewPart;
import droidsafe.eclipse.plugin.core.view.pointsto.PointsToViewPart;
import droidsafe.eclipse.plugin.core.view.value.ValueViewPart;
import droidsafe.speclang.model.MethodModel;

/**
 * A dynamic context menu for tree elements in the call hierarchy view. 
 * The menu contains method models corresponding to the tree element.
 * 
 * @author gilham
 *
 */
public class DynamicContextMethodMenu extends CompoundContributionItem {

    @Override
    protected IContributionItem[] getContributionItems() {
    	IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    	if (page != null) {
    		IWorkbenchPart part = page.getActivePart();
    		if (part != null && part instanceof CallHierarchyViewPart) {
    			CallHierarchyViewPart callHierarchyViewPart = (CallHierarchyViewPart) part;
    			ISelection selection = page.getSelection();
    			if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
    				Object selectedNode = ((IStructuredSelection) selection).getFirstElement();
    				if (selectedNode instanceof TreeElement<?, ?>) {
    					TreeElement<?, ?> treeElement = (TreeElement<?, ?>) selectedNode;
    					Set<MethodModel> methods = callHierarchyViewPart.getMethodModels(treeElement);
    					int size = methods.size();
    					if (size > 1) {
    						IContributionItem[] items = new IContributionItem[size];
    						int i = 0;
    						for (final MethodModel method: methods) {
    							items[i++] = new ContributionItem() {

    								public void fill(Menu menu, int index) {
    									MenuItem item = new MenuItem(menu, SWT.PUSH);
    									String label = DroidsafePluginUtilities.removeCloneSuffix(method.getSignature());
    									item.setText(label);
    									item.addListener(SWT.Selection, getMenuItemListener(method));
    								}

    								/**
    								 * Return the menu item listener for selection of a method model.
    								 */
    								private Listener getMenuItemListener(final MethodModel method) {
    									return new Listener() {
    										/**
    										 * Show info flow details, value analysis results, and points-to info for
    										 * the selected method model.
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
    	}
    	return new IContributionItem[0];
   }

}
