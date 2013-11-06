package droidsafe.eclipse.plugin.core.view.infoflow;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

import droidsafe.eclipse.plugin.core.Activator;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
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
    protected ITreeContentProvider makeContentProvider() {
        return new InfoFlowSummaryTreeElementContentProvider();
    }

    @Override
    protected IBaseLabelProvider makeLabelProvider() {
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

    protected void projectChanged() {
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
                  InfoFlowDetailsViewPart.openView(method);
                  ValueViewPart.openView(method);
                }
              }
            }
        }
    }
    
}
