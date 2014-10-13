package droidsafe.eclipse.plugin.core.view.callgraph;

import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

import com.google.gson.JsonObject;

import droidsafe.eclipse.plugin.core.Activator;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoOutlineViewPart;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementContentProvider;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementLabelProvider;
import droidsafe.eclipse.plugin.core.view.indicator.Utils;
import droidsafe.eclipse.plugin.core.view.infoflow.InfoFlowDetailsViewPart;
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
public class CallGraphViewPart extends DroidsafeInfoOutlineViewPart {

    /** The ID of the view as specified by the extension. */
    public static final String VIEW_ID = "droidsafe.eclipse.plugin.core.view.CallGraphView";
    
    /** The method on which the call graph is to be displayed. */
    private CallGraph fCallGraph;
    
    private boolean fShowCallees;

    @Override
    protected DroidsafeInfoTreeElementLabelProvider makeLabelProvider() {
        return new CallGraphTreeElementLabelProvider();
    }

    @Override
    protected DroidsafeInfoTreeElementContentProvider makeContentProvider() {
        return new CallGraphTreeElementContentProvider();
    }

    @Override
    protected void updateView() {
        updateView(false);
    }

    public void updateView(boolean resetViewer) {
        if (fParentComposite != null) {
            if (fCallGraph == null) {
                showPage(PAGE_EMPTY);
            } else {
                if (resetViewer)
                    resetViewer();
                showPage(PAGE_VIEWER);
                String type = (fShowCallees) ? "Callee" : "Caller" ;
                setContentDescription(type + " Hierarchy ");
                fTreeViewer.setInput(fCallGraph);
            }
        }        
    }

    @Override
    protected void projectSelected() {
        resetViewer();
        setInput(null);
    }

    @Override
    protected String emptyPageText() {
        return "No droidsafe call hierarchy info.";
    }

    /**
     * Set the input element for the viewer and update the contents of the view.
     */
    protected void setInput(CallGraph callGraph) {
        if ((callGraph == null && fCallGraph != null) || 
                (callGraph != null && !callGraph.equals(fCallGraph))) {
        	fCallGraph = callGraph;
            updateView();
        }
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
                    if (data instanceof JsonObject) {
                        List<MethodModel> methods = Utils.getMethodModels((JsonObject) data);
                        MethodModel method = (methods.isEmpty()) ? null : methods.get(0);
                        InfoFlowDetailsViewPart.openView(method);
                        ValueViewPart.openView(method);
                        PointsToViewPart.openView(method);
                    }
                }
            }
            fTreeViewer.getControl().setFocus();
        }
    }

    /**
     * Open the outline view for the given input element.
     * @param line 
     */
	public static void openView(CallGraph cg) {
        IWorkbenchPage activePage = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
        CallGraphViewPart view = (CallGraphViewPart) activePage.findView(VIEW_ID);
        if (view == null) {
            // open the view
            try {
                view = (CallGraphViewPart) activePage.showView(VIEW_ID);
            } catch (PartInitException e) {
                e.printStackTrace();
            }
        }
        view.setInput(cg);
        activePage.activate(view);
    }

    public static CallGraphViewPart findView() {
        IWorkbenchPage activePage = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
        CallGraphViewPart view = (CallGraphViewPart) activePage.findView(VIEW_ID);
        return view;
    }

    public CallGraph getCallGraph() {
        return fCallGraph;
    }

    public void reset() {
    	fCallGraph = null;
        updateView();
    }

}
