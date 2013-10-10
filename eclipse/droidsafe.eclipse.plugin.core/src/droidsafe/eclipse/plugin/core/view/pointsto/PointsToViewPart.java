package droidsafe.eclipse.plugin.core.view.pointsto;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.ViewPart;

import droidsafe.eclipse.plugin.core.Activator;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.utils.SourceLocationTag;

/**
 * View for displaying the points-to info on the receiver/arguments of a given method. 
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class PointsToViewPart extends ViewPart implements ISelectionChangedListener {

    /** The ID of the view as specified by the extension. */
    public static final String VIEW_ID = "droidsafe.eclipse.plugin.core.view.PointsToView";

    /** The constant that represents the empty page. */
    private static final int PAGE_EMPTY = 0;
    /** The constant that represents the points-to tree viewer page. */
    private static final int PAGE_VIEWER = 1;

    /** The project selected on the Project Explorer View. */
    private IProject fSelectedProject;
    
    /** The method receiver/arguments on which the points-to info is to be displayed. */
    private MethodArgumentModel[] fInputElements;

    /** The main tree viewer used to display the points-to info. */
    private TreeViewer fTreeViewer;

    /** Standard Eclipse content provider to populate the tree viewer. */
    private ITreeContentProvider fContentProvider;

    /** Standard Eclipse label provider to provide images and labels to the different tree nodes. */
    private IBaseLabelProvider fLabelProvider;

    /** The container for points-to outline view. */
    private Composite fParentComposite;

    /** The page book for points-to outline view. */
    private PageBook fPagebook;

    /** The label for the empty page. */
    private Label fEmptyPageLabel;

    /** 
     * The selection listener that resets the contents of the points-to outline view
     *  once a different project is selected. 
     */
    private ISelectionListener fSelectionListener;

    /**
     */
    @Override
    public void createPartControl(Composite parent) {
        fParentComposite = parent;
        setSelectionListener();
        fContentProvider = new PointsToTreeElementContentProvider();
        fLabelProvider = new PointsToTreeElementLabelProvider();
        fPagebook = new PageBook(parent, SWT.NONE);

        // Page 1: Tree Viewer
        createTreeViewer(fPagebook);

        // Page 2: Nothing selected
        fEmptyPageLabel = new Label(fPagebook, SWT.TOP + SWT.LEFT + SWT.WRAP);
        fEmptyPageLabel.setText("To display the points-to info, select a method from the 'Security Spec Outline', and select the 'Show Points-to Info' menu option.");

        showPage(PAGE_EMPTY);
    }

    /**
     * Show the given page in the points-to outline page book.
     */
    private void showPage(int page) {
        boolean isEmpty= page == PAGE_EMPTY;
        Control control= isEmpty ? (Control) fEmptyPageLabel : fTreeViewer.getControl();
        if (isEmpty) {
            setContentDescription("");
            clearViewer();
        }
        fPagebook.showPage(control);
    }

    /**
     * Clear the content of the points-to outline view. 
     */
    private void clearViewer() {
        getViewer().setInput(null);
    }

    /**
     * Create a tree viewer for the points-to outline view.
     */
    private void createTreeViewer(Composite parent) {
        fTreeViewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
        fTreeViewer.setContentProvider(fContentProvider);
        fTreeViewer.setLabelProvider(fLabelProvider);
        fTreeViewer.setAutoExpandLevel(2);
        fTreeViewer.setUseHashlookup(true);
        fTreeViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
        ColumnViewerToolTipSupport.enableFor(fTreeViewer);
        fTreeViewer.addSelectionChangedListener(this);
    }

    /**
     * Initialize the tree viewer with content provider, label provider, and inuput model.
     */
    public void setInputElements(MethodArgumentModel[] inputElements) {
        if (!inputElements.equals(fInputElements)) {
            fInputElements = inputElements;
            updateView();
        }
    }

    /**
     * Update the content of the points-to outline view.
     */
    private void updateView() {
        if (fInputElements != null && fInputElements.length > 0 && fParentComposite != null) {
            showPage(PAGE_VIEWER);
            
            String sig = fInputElements[0].getMethod().getSignature();
            setContentDescription("method " + sig);

            // Make sure there is no text viewer in the container otherwise we
            // get a split screen.

            fTreeViewer.setInput(fInputElements);

            MenuManager menuManager = new MenuManager();
            Menu menu = menuManager.createContextMenu(fTreeViewer.getTree());
            // Set the MenuManager
            fTreeViewer.getTree().setMenu(menu);
            getSite().registerContextMenu(menuManager, fTreeViewer);

            // Make the selection available to other views
            getSite().setSelectionProvider(fTreeViewer);
            addDoubleClickListener();
        }        
    }

    /**
     * Add a double click listener to the TreeViewr. Double clicking on a tree node will expand the
     * node and open a text editor and position the caret on the line of code corresponding to the
     * line of the method.
     * 
     */
    private void addDoubleClickListener() {
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
    public void revealSelectionInEditor(ISelection selection, boolean activate) {
        // TreeViewer viewer = (TreeViewer) event.getViewer();
        if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
            Object selectedNode = ((IStructuredSelection) selection).getFirstElement();
            if (selectedNode instanceof TreeElement<?, ?>) {
                TreeElement<?, ?> treeElement = (TreeElement<?, ?>) selectedNode;
                Object data = treeElement.getData();
                if (data instanceof SourceLocationTag) {
                    DroidsafePluginUtilities.revealInEditor(getProject(), (SourceLocationTag) data, activate);
                } else if (data instanceof MethodArgumentModel) {
                    DroidsafePluginUtilities.revealInEditor(getProject(), (MethodArgumentModel) data, activate);
                }
            }
        }
    }

    /**
     * Cause this points-to outline to get the keyboard focus.
     */ 
    @Override
    public void setFocus() {
        fPagebook.setFocus();
    }

    /**
     * Return the current TreeViewer for the points-to outline.
     */
    public TreeViewer getViewer() {
        return fTreeViewer;
    }

    /**
     * Return the input elements for this points-to outline.
     */
    public MethodArgumentModel[] getInputElements() {
        return fInputElements;
    }

    /** 
     * Dispose this points-to outline.
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
    private void setSelectionListener() {
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
                fInputElements = null;
                if (fTreeViewer != null)
                    fTreeViewer.setInput(null);
                showPage(PAGE_EMPTY);
            }
          }
        }
      };
      getSite().getPage().addSelectionListener(this.fSelectionListener);
    }

    /**
     * Open the points-to outline view for the given input elements.
     */
    public static void openView(MethodArgumentModel[] inputElements) {
        IWorkbenchPage activePage = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
        PointsToViewPart view = (PointsToViewPart) activePage.findView(VIEW_ID);
        if (view == null) {
            // open the view
            try {
                view = (PointsToViewPart) activePage.showView(VIEW_ID);
            } catch (PartInitException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        view.setInputElements(inputElements);
        activePage.activate(view);
    }

}
