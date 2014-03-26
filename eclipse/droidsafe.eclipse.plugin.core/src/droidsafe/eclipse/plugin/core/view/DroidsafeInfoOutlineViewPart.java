package droidsafe.eclipse.plugin.core.view;

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
import org.eclipse.swt.widgets.Menu;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
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

    private static final String SOURCE_LOCATION_PROP = "src-loc";

    /** The main tree viewer used to display droidsafe analysis info. */
    protected TreeViewer fTreeViewer;

    /** Standard Eclipse content provider to populate the tree viewer. */
    protected ITreeContentProvider fContentProvider;

    /** Standard Eclipse label provider to provide images and labels to the different tree nodes. */
    protected IBaseLabelProvider fLabelProvider;

    abstract protected IBaseLabelProvider makeLabelProvider();

    abstract protected ITreeContentProvider makeContentProvider();

    /**
     * Clear the content of the outline view. 
     */
    protected void clearViewer() {
        getViewer().setInput(null);
    }
    
    protected void resetViewer() {
        if (fTreeViewer != null)
            fTreeViewer.setInput(null);
        ((DroidsafeInfoTreeElementContentProvider) fContentProvider).reset();
    }

    /**
     * Create a tree viewer for the outline view.
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

    protected int autoExpandLevel() {
      return 2;
    }

    /**
     * Update the content of the outline view.
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
                Object data = treeElement.getData();
                if (data instanceof SourceLocationTag) {
                    DroidsafePluginUtilities.revealInEditor(getProject(), (SourceLocationTag) data, activate);
                } else if (data instanceof MethodArgumentModel) {
                    DroidsafePluginUtilities.revealInEditor(getProject(), (MethodArgumentModel) data, activate);
                } else if (data instanceof MethodModel) {
                    DroidsafePluginUtilities.revealInEditor(getProject(), (MethodModel) data, activate);
                } else if (data instanceof JsonObject) {
                    JsonElement srcLoc = ((JsonObject) data).get(SOURCE_LOCATION_PROP);
                    if (srcLoc != null && srcLoc.isJsonObject()) {
                        JsonObject srcLocObj = (JsonObject) srcLoc;
                        String className = srcLocObj.get("class").getAsString();
                        int lineNumber = srcLocObj.get("line").getAsInt();
                        DroidsafePluginUtilities.revealInEditor(getProject(), className, lineNumber, activate); 
                    }
                }
            }
        }
    }

    /**
     * Return the current TreeViewer for the outline.
     */
    public TreeViewer getViewer() {
        return fTreeViewer;
    }

    protected Control getControl() {
        return fTreeViewer.getControl();
    }

    public void refresh() {
        fTreeViewer.refresh();
        // fTreeViewer.expandToLevel(autoExpandLevel());
        fTreeViewer.expandAll();    
      }

}
