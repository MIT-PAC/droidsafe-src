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

package droidsafe.eclipse.plugin.core.view;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.util.Util;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import droidsafe.eclipse.plugin.core.dialogs.SearchDialog;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.callhierarchy.CallHierarchyViewPart;
import droidsafe.eclipse.plugin.core.view.callhierarchy.CallerHierarchy;
import droidsafe.eclipse.plugin.core.view.callhierarchy.SourceMethodNode;
import droidsafe.eclipse.plugin.core.view.indicator.IndicatorViewPart;
import droidsafe.eclipse.plugin.core.view.indicator.Utils;
import droidsafe.speclang.model.MethodArgumentModel;
import droidsafe.speclang.model.MethodModel;
import droidsafe.utils.SourceLocationTag;

/**
 * Outline view for displaying droidsafe analysis info. 
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
abstract public class DroidsafeInfoOutlineViewPart extends DroidsafeInfoViewPart implements ISelectionChangedListener {

    /** The main tree viewer used to display droidsafe analysis info. */
    protected TreeViewer fTreeViewer;

    /** Standard Eclipse content provider to populate the tree viewer. */
    protected DroidsafeInfoTreeElementContentProvider fContentProvider;

    /** Standard Eclipse label provider to provide images and labels to the different tree nodes. */
    protected DroidsafeInfoTreeElementLabelProvider fLabelProvider;

    /**
     * Makes a label provider for this outline view.
     * 
     * @return the label provider
     */
    abstract protected DroidsafeInfoTreeElementLabelProvider makeLabelProvider();

    /**
     * Makes a content provider for this outline view.
     * 
     * @return the content provider
     */
    abstract protected DroidsafeInfoTreeElementContentProvider makeContentProvider();

    /**
     * Clears the content of the outline view. 
     */
    @Override
    protected void clearViewer() {
        getViewer().setInput(null);
    }
    
    /**
     * Resets the content of the outline view. 
     */
    protected void resetViewer() {
        if (fTreeViewer != null)
            fTreeViewer.setInput(null);
        fContentProvider.reset();
    }

    /**
     * Creates a tree viewer for the outline view.
     */
    protected void createViewer(Composite parent) {
        fContentProvider = makeContentProvider();
        fLabelProvider = makeLabelProvider();
        fTreeViewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
        fTreeViewer.setContentProvider(fContentProvider);
        fTreeViewer.setLabelProvider(fLabelProvider);
        fTreeViewer.setAutoExpandLevel(autoExpandLevel());
        fTreeViewer.setUseHashlookup(true);
        fTreeViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));

        ColumnViewerToolTipSupport.enableFor(fTreeViewer);
        fTreeViewer.addSelectionChangedListener(this);
        MenuManager menuManager = new MenuManager();
        Menu menu = menuManager.createContextMenu(fTreeViewer.getTree());
        // Set the MenuManager
        fTreeViewer.getTree().setMenu(menu);
        getSite().registerContextMenu(menuManager, fTreeViewer);

        // Make the selection available to other views
        getSite().setSelectionProvider(fTreeViewer);
        addDoubleClickListener();
    }

    /**
     * Returns the auto-expand level to be used when the input of the viewer is set using 
     * setInput(Object).
     */
    protected int autoExpandLevel() {
      return 2;
    }

    /**
     * Updates the content of the outline view.
     */
    abstract protected void updateView();

    /**
     * Add a double click listener to the TreeViewr. Double clicking on a tree node will expand the
     * node and open a text editor and position the caret on the line of code corresponding to the
     * line of the method.
     * 
     */
    protected void addDoubleClickListener() {
        if (fTreeViewer != null) {
            // Add a doubleclicklistener
            fTreeViewer.addDoubleClickListener(new IDoubleClickListener() {

                @Override
                public void doubleClick(DoubleClickEvent event) {
                    revealSelectionInEditor(event.getSelection(), true);
                }
            });
        }
    }

    /**
     * When a new item is selected from the outline, reveals and highlights the source code for the
     * new selection in an editor. 
     */
    @Override
    public void selectionChanged(SelectionChangedEvent e) {
        if (e.getSelectionProvider() == fTreeViewer) {
            revealSelectionInEditor(e.getSelection(), false);
        }
    }

    /**
     * Reveals and highlights the source code for the given selection in an editor. Activates  
     * the editor if the parameter 'activate' is true.
     * 
     */
    protected void revealSelectionInEditor(ISelection selection, boolean activate) {
        // TreeViewer viewer = (TreeViewer) event.getViewer();
        if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
            Object selectedNode = ((IStructuredSelection) selection).getFirstElement();
            if (selectedNode instanceof TreeElement<?, ?>) {
                TreeElement<?, ?> treeElement = (TreeElement<?, ?>) selectedNode;
                revealInEditor(treeElement, activate);
            } 
        }
    }
    
    /**
     * Reveals and highlights the source code for the given tree element in an editor. Activates  
     * the editor if the parameter 'activate' is true.
     * 
     */
    protected void revealInEditor(TreeElement<?, ?> treeElement, boolean activate) {
        Object data = treeElement.getData();
    	if (data instanceof SourceLocationTag) {
    		DroidsafePluginUtilities.revealInEditor(getProject(), (SourceLocationTag) data, activate);
    	} else if (data instanceof MethodArgumentModel) {
    		DroidsafePluginUtilities.revealInEditor(getProject(), (MethodArgumentModel) data, activate);
    	} else if (data instanceof MethodModel) {
    		DroidsafePluginUtilities.revealInEditor(getProject(), (MethodModel) data, activate);
    	} else if (data instanceof JsonElement) {
    		DroidsafePluginUtilities.revealInEditor(getProject(), (JsonElement) data, activate);
    	}
    } 
    
    /**
     * Returns the content provider for this outline view.
     */
     public DroidsafeInfoTreeElementContentProvider getContentProvider() {
        return fContentProvider;
    }

     /**
      * Returns the label provider for this outline view.
      */
    public DroidsafeInfoTreeElementLabelProvider getLabelProvider() {
        return fLabelProvider;
    }
    
    /**
     * Return the current TreeViewer for the outline.
     */
    public TreeViewer getViewer() {
        return fTreeViewer;
    }

    /**
     * Returns the control for this outline view.
     */
    protected Control getControl() {
        return fTreeViewer.getControl();
    }

    /**
     * Returns the absolute screen position for the outline view.
     */
    public Point getScreenLocation() {
        Control control = getControl();
        Point loc = control.getLocation();
        Point absLoc = control.toDisplay(loc);
        return absLoc;
    }

    /**
     * Recomputes the content of this outline view if the parameter
     * 'recomputeTree' is true. Then refreshes the view; updates
     * the item labels if the parameter 'updateLabel' is true.
     */
    public void refresh(boolean recomputeTree, boolean updateLabel) {
        if (recomputeTree)
            fContentProvider.setRootElements(null);
        fTreeViewer.refresh(updateLabel);
        // fTreeViewer.expandToLevel(autoExpandLevel());
        fTreeViewer.expandAll();    
      }

    /**
     * Uses long labels if 'longLabel' is true.
     * No-op by default.  Subclasses should override it if long labels are supported.
     */
    public void setLongLabel(boolean longLabel) {
    }

    /**
     * Updates labels for all elements in the outline.
     */
    public void updateLabels() {
        Object[] roots = fContentProvider.getRootElements();
        if (roots != null) {
            for (Object root: roots) {
                updateLabels(root);
            }
        }
    }

    /**
     * Updates labels for all the tree elements rooted at the given element.
     */
    private void updateLabels(Object element) {
        fTreeViewer.update(element, null);
        for (Object child: fContentProvider.getChildren(element)) {
            updateLabels(child);
        }
    }

}
