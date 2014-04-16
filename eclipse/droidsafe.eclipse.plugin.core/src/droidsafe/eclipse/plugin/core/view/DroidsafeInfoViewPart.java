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
     */
    @Override
    public void createPartControl(Composite parent) {
        fParentComposite = parent;        
        fPagebook = new PageBook(parent, SWT.NONE);

        // Page 1: Viewer
        createViewer(fPagebook);

        // Page 2: Nothing selected
        fEmptyPageLabel = new Label(fPagebook, SWT.TOP + SWT.LEFT + SWT.WRAP);
        fEmptyPageLabel.setText(emptyPageText());

        IProject project = getProject();
        if (project == null)
            showPage(PAGE_EMPTY);
        else
            projectSelected();
        setSelectionListener();
    }

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
     * Show the given page in the page book.
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
     * Cause this view to receive the keyboard focus.
     */ 
    @Override
    public void setFocus() {
        fPagebook.setFocus();
    }

    /** 
     * Dispose this viewer.
     */
    @Override
    public void dispose() {
        getSite().getPage().removeSelectionListener(fSelectionListener);
        super.dispose();
    }

    /**
     * Return the selected project in the Eclipse Project Explorer.
     * 
     * @return the selected project or project enclosing a selected resource.
     */
    protected IProject getSelectedProject() {
        ISelectionService ss =
                Activator.getDefault().getWorkbench().getActiveWorkbenchWindow()
                .getSelectionService();
        String projExpID = "org.eclipse.ui.navigator.ProjectExplorer";
        ISelection sel = ss.getSelection(projExpID);
        if (sel == null) {
            projExpID = "org.eclipse.jdt.ui.PackageExplorer";
            sel = ss.getSelection(projExpID);
        }

        Object selectedObject = sel;
        if (sel instanceof IStructuredSelection) {
            selectedObject = ((IStructuredSelection) sel).getFirstElement();
        }
        if (selectedObject instanceof IAdaptable) {
            IResource res = (IResource) ((IAdaptable) selectedObject).getAdapter(IResource.class);
            if (res != null) {
                IProject project = res.getProject();
                if (project != null) {
                    // logger.debug("Project found: " + project.getName());
                    return project;
                }
            }
        }
        return null;
    }

    /**
     * Set the value of the selectedProject field if it is null and return the value of the
     * selectedProject field.
     */
    public IProject getProject() {
        if (fSelectedProject == null) {
            fSelectedProject = getSelectedProject();
        }
        return fSelectedProject;
    }

    /**
     * Auxiliary function to setup a selection listener that would reset the contents of the outline
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

    abstract protected void projectSelected();

    abstract protected void clearViewer();

    abstract protected Control getControl();

    abstract protected String emptyPageText();

    abstract protected void createViewer(Composite parent);

    /**
     * Update the content of this view.
     */
    abstract protected void updateView();

    abstract protected void resetViewer();

}
