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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.ViewPart;

import droidsafe.eclipse.plugin.core.Activator;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.indicator.IndicatorViewPart;
import droidsafe.eclipse.plugin.core.view.infoflow.InfoFlowDetailsViewPart;
import droidsafe.eclipse.plugin.core.view.infoflow.InfoFlowSummaryViewPart;
import droidsafe.eclipse.plugin.core.view.pointsto.PointsToViewPart;
import droidsafe.eclipse.plugin.core.view.spec.SecuritySpecOutlineViewPart;
import droidsafe.eclipse.plugin.core.view.value.ValueViewPart;

/**
 * View for displaying droidsafe analysis info on a given method. 
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
abstract public class DroidsafeInfoViewPart extends ViewPart {

    /** The constant that represents the empty page. */
    protected static final int PAGE_EMPTY = 0;
    /** The constant that represents the tree viewer page. */
    protected static final int PAGE_VIEWER = 1;

    /** The project selected on the Project Explorer View. */
    protected IProject fSelectedProject;

    /** The container for this viewer. */
    protected Composite fParentComposite;

    /** The page book for this viewer. */
    protected PageBook fPagebook;

    /** The label for the empty page. */
    protected Label fEmptyPageLabel;
    
    /** IDs for All the droidsafe views in the droidsafe perspective. */
    static final String[] ALL_VIEW_IDS = {SecuritySpecOutlineViewPart.VIEW_ID,
                                          InfoFlowSummaryViewPart.VIEW_ID,
                                          IndicatorViewPart.VIEW_ID,
                                          InfoFlowDetailsViewPart.VIEW_ID,
                                          ValueViewPart.VIEW_ID,
                                          PointsToViewPart.VIEW_ID};

    /** 
     * The selection listener that resets the contents of the viewer
     *  once a different project is selected. 
     */
    protected ISelectionListener fSelectionListener;

    /**
     * Initializes this droidsafe view with the given parent as a page book of
     * two pages, a content viewer and an empty page label. Display the current
     * page depending on the current project. Sets up a selection listener to
     * listen to project selections. 
     */
    @Override
    public void createPartControl(Composite parent) {
        fParentComposite = parent;        
        fPagebook = new PageBook(parent, SWT.NONE);

        // Page 1: Viewer
        createViewer(fPagebook);

        // Page 2: Nothing selected
        fEmptyPageLabel = new Label(fPagebook, SWT.TOP + SWT.LEFT + SWT.WRAP);

        IProject project = getProject();
        if (project == null)
        	showEmptyPage();
        else
            projectSelected();
        setSelectionListener();
    }

    protected void showEmptyPage() {
        fEmptyPageLabel.setText(emptyPageText());
        showPage(PAGE_EMPTY);
	}

	/**
     * Shows all the droidsafe views in the droidsafe perspective other than
     * the one with the given view id.
     */
    public static void showOtherDroidsafeViews(String currentViewId) {
        IWorkbenchPage activePage = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
        for (String viewId: ALL_VIEW_IDS) {
            if (!viewId.equals(currentViewId)) {
                IViewPart view = activePage.findView(viewId);
                if (view == null) {
                    // open the view
                    try {
                        activePage.showView(viewId);
                    } catch (PartInitException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * Shows the given page in the page book.
     */
    protected void showPage(int page) {
        boolean isEmpty= page == PAGE_EMPTY;
        Control control= isEmpty ? (Control) fEmptyPageLabel : getControl();
        if (isEmpty) {
            setContentDescription("");
            clearViewer();
        }
        fPagebook.showPage(control);
    }

    /**
     * Causes this view to receive the keyboard focus.
     */ 
    @Override
    public void setFocus() {
        fPagebook.setFocus();
    }

    /** 
     * Disposes this viewer.
     */
    @Override
    public void dispose() {
    	if (fSelectionListener != null) {
    		getSite().getPage().removeSelectionListener(fSelectionListener);
    	}
        super.dispose();
    }

    /**
     * Sets the value of the selectedProject field if it is null and return the value of the
     * selectedProject field.
     */
    public IProject getProject() {
        if (fSelectedProject == null) {
            fSelectedProject = DroidsafePluginUtilities.getSelectedProject();
        }
        return fSelectedProject;
    }

    /**
     * Auxiliary function to setup a selection listener that would reset the contents of the 
     * view once a different project is selected.
     */
    protected void setSelectionListener() {
        this.fSelectionListener = new ISelectionListener() {
            public void selectionChanged(IWorkbenchPart part, ISelection sel) {
                if (!(sel instanceof IStructuredSelection)) return;
                IStructuredSelection ss = (IStructuredSelection) sel;
                Object selectedObject = ss.getFirstElement();
                if (selectedObject instanceof IAdaptable) {
                    IResource res = (IResource) ((IAdaptable) selectedObject).getAdapter(IResource.class);
                    IProject project = (res != null) ? res.getProject() : null;
                    if (project != null && project != fSelectedProject) {
                        fSelectedProject = project;
                        BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
                            @Override
                            public void run() {
                                projectSelected();
                            }
                        });
                    }
                }
            }

        };
        getSite().getPage().addSelectionListener(this.fSelectionListener);
    }

    /**
     * Resets the content of the view when a different project is selected.
     */
    abstract protected void projectSelected();

    /**
     * Clears the content of this view. 
     */
    abstract protected void clearViewer();

    /**
     * Returns the control for this view.
     */
    abstract protected Control getControl();

    /**
     * Returns the text for the empty page label.
     */
    abstract protected String emptyPageText();

    /**
     * Creates a viewer for this view.
     */
    abstract protected void createViewer(Composite parent);

    /**
     * Updates the content of this view.
     */
    abstract protected void updateView();

    /**
     * Resets the content of this view. 
     */
    abstract protected void resetViewer();

}
