package droidsafe.eclipse.plugin.core.view.infoflow;

import org.eclipse.jface.util.Util;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import droidsafe.eclipse.plugin.core.Activator;
import droidsafe.eclipse.plugin.core.dialogs.SearchDialog;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementContentProvider;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementLabelProvider;
import droidsafe.eclipse.plugin.core.view.SpecInfoOutlineViewPart;
import droidsafe.eclipse.plugin.core.view.pointsto.PointsToViewPart;
import droidsafe.eclipse.plugin.core.view.value.ValueViewPart;
import droidsafe.speclang.model.MethodModel;
import droidsafe.speclang.model.SecuritySpecModel;

/**
 * View for displaying the info flow on the receiver/arguments of a given method. 
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class InfoFlowSummaryViewPart extends SpecInfoOutlineViewPart {

    /** The ID of the view as specified by the extension. */
    public static final String VIEW_ID = "droidsafe.eclipse.plugin.core.view.InfoFlowSummaryView";

    /** The text displayed on the empty page. */
    protected static String EMPTY_PAGE_LABEL = "No Android Project selected. "
          + "\nSelect an Android project in the Project Explorer."
          + "\nYou may also need to run the Droidsafe spec generation "
          + "command from the project context menu.";
    
    @Override
    public void createPartControl(Composite parent) {
        showOtherDroidsafeViews(VIEW_ID);
        super.createPartControl(parent);
        fTreeViewer.getControl().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                int modifier = (Util.isMac()) ? SWT.COMMAND : SWT.CTRL;
                if ((e.stateMask & modifier) == modifier) {
                    if (e.keyCode == 'f') {
                        if (fContentProvider.getRootElements() != null) {
                            IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
                            SearchDialog dialog = new SearchDialog(window.getShell(), InfoFlowSummaryViewPart.this);
                            dialog.open();
                        }
                    }
                }
            }
        });
    }
    
    @Override
    protected DroidsafeInfoTreeElementContentProvider makeContentProvider() {
        return new InfoFlowSummaryTreeElementContentProvider();
    }

    @Override
    protected DroidsafeInfoTreeElementLabelProvider makeLabelProvider() {
        return new InfoFlowSummarylTreeElementLabelProvider();
    }

    @Override
    protected String emptyPageText() {
        return EMPTY_PAGE_LABEL;
    }
    
    @Override
    protected int autoExpandLevel() {
      return 1;
    }

    /**
     * Open the outline view for the given input element.
     */
    public static void openView(SecuritySpecModel inputElement) {
        IWorkbenchPage activePage = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
        InfoFlowSummaryViewPart view = (InfoFlowSummaryViewPart) activePage.findView(VIEW_ID);
        if (view == null) {
            // open the view
            try {
                view = (InfoFlowSummaryViewPart) activePage.showView(VIEW_ID);
            } catch (PartInitException e) {
                e.printStackTrace();
            }
        }
        view.setInputElement(inputElement);
//        activePage.activate(view);
    }

    protected void projectSelected() {
        // do nothing. Viewer content is changed via calls to openView() from SecuritySpecOutlineViewPart. 
    }

    @Override
    public void selectionChanged(SelectionChangedEvent e) {
        if (e.getSelectionProvider() == fTreeViewer) {
          ISelection selection = e.getSelection();
            revealSelectionInEditor(selection, false);
            if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
              Object selectedNode = ((IStructuredSelection) selection).getFirstElement();
              if (selectedNode instanceof TreeElement<?, ?>) {
                TreeElement<?, ?> treeElement = (TreeElement<?, ?>) selectedNode;
                Object data = treeElement.getData();
                if (data instanceof MethodModel) {
                  MethodModel method = (MethodModel) data;
                  PointsToViewPart.openView(method);
                  ValueViewPart.openView(method);
                  SourceSinkPair sourceSinkFilter = (SourceSinkPair) treeElement.getParent().getData();
                  MethodWithSourceSinkFilter methodWithSourceSinkFilter = new MethodWithSourceSinkFilter(method, sourceSinkFilter);
                  InfoFlowDetailsViewPart.openView(methodWithSourceSinkFilter);
                }
              }
            }
            fTreeViewer.getControl().setFocus();
        }
    }
    
}
