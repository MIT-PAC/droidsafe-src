package droidsafe.eclipse.plugin.core.view.callgraph;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

import com.google.gson.JsonElement;

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
import droidsafe.utils.SourceLocationTag;

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
    private ICallGraph fCallGraph;
    
    private boolean fShowCallees;

    @Override
    protected DroidsafeInfoTreeElementLabelProvider makeLabelProvider() {
        return new CallGraphTreeElementLabelProvider(this);
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
                setContentDescription(fCallGraph.getDescription());
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
    protected void setInput(ICallGraph callGraph) {
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
            if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
                Object selectedNode = ((IStructuredSelection) selection).getFirstElement();
                if (selectedNode instanceof TreeElement<?, ?>) {
                    TreeElement<?, ?> treeElement = (TreeElement<?, ?>) selectedNode;
                    IProject project = fCallGraph.getProject();
                    if (fCallGraph instanceof CallGraph && treeElement.getParent() == null) {
                    	JsonElement root = (JsonElement) treeElement.getData();
                    	String sig = Utils.getSignature(root);
                    	SecuritySpecModel spec = DroidsafePluginUtilities.getSecuritySpec(project, false, false);
                    	Map<String, SourceLocationTag> methodLocMap = spec.getSourceMethodLocationMap();
                    	SourceLocationTag methodLoc = methodLocMap.get("<"+sig+">");
                    	if (methodLoc != null) {
                    		DroidsafePluginUtilities.revealInEditor(project, methodLoc, false);
                    	} else {
                    		revealSelectionInEditor(selection, false);
                    	}
                    } else {
                    	revealSelectionInEditor(selection, false);
                    }
                    Set<MethodModel> methods = getMethodModels(treeElement);
                    MethodModel method = (methods.isEmpty()) ? null : methods.iterator().next();
                    InfoFlowDetailsViewPart.openView(method);
                    ValueViewPart.openView(method);
                    PointsToViewPart.openView(method);
                }
            }
            fTreeViewer.getControl().setFocus();
        }
    }

    /**
     * Reveals and highlights the source code for the given tree element in an editor. Activates  
     * the editor if the parameter 'activate' is true.
     * 
     */
    protected void revealInEditor(TreeElement<?, ?> treeElement, boolean activate) {
        IProject project = fCallGraph.getProject();
    	Object data = treeElement.getData();
    	if (data instanceof SourceMethodNode) {
    		Set<MethodModel> methods = getMethodModels(treeElement);
    		if (methods == null || methods.isEmpty()) {
        		CallerGraph callerGraph = (CallerGraph) fCallGraph;
    			Set<JsonElement> calls = getCalls(callerGraph, treeElement);
    			if (!calls.isEmpty())
    				DroidsafePluginUtilities.revealInEditor(project, calls.iterator().next(), activate);
    			else {
    				SourceMethodNode methodNode = (SourceMethodNode) data;
    				String className = methodNode.getSourceClass();
    				int lineNumber = methodNode.getLine();
    				if (className != null || lineNumber > 0) {
    					DroidsafePluginUtilities.revealInEditor(project, className, lineNumber, activate);
    				} else {
    					DroidsafePluginUtilities.error("No source location info for method " + methodNode);
    				}
    			}
    		} else {
    			DroidsafePluginUtilities.revealInEditor(project, methods.iterator().next(), activate);
    		}
    	} else if (data instanceof JsonElement) {
    		DroidsafePluginUtilities.revealInEditor(project, (JsonElement) data, activate);
    	}
    } 
    
    public Set<MethodModel> getMethodModels(TreeElement<?, ?> treeElement) {
        IProject project = fCallGraph.getProject();
        SecuritySpecModel spec = DroidsafePluginUtilities.getSecuritySpec(project, false, false);
    	Object data = treeElement.getData();
    	if (data instanceof JsonElement) {
    		return Utils.getMethodModels(spec, (JsonElement) data);

    	} else if (data instanceof SourceMethodNode) {
    		CallerGraph callerGraph = (CallerGraph) fCallGraph;
    		Set<JsonElement> calls = getCalls(callerGraph, treeElement);
    		if (!calls.isEmpty()) {
    			Set<MethodModel> result = new TreeSet<MethodModel>();
    			for (JsonElement call: calls) {
    				Set<MethodModel> methods = Utils.getMethodModels(spec, call);
    				if (methods != null)
    					result.addAll(methods);
    			}
    			return result;
    		}
    	}
    	return Collections.EMPTY_SET;
    }

    public static Set<JsonElement> getCalls(CallerGraph callerGraph, TreeElement<?, ?> treeElement) {
    	Object data = treeElement.getData();
    	if (data instanceof SourceMethodNode) {
    		Map<String, Map<String, Set<JsonElement>>> callerMap = callerGraph.getCallerMap();
    		TreeElement<?, ?> parent = treeElement.getParent();
    		if (parent != null) {
    			Object parentData = parent.getData();
    			if (parentData != null && parentData instanceof SourceMethodNode) {
    				String parentSig = ((SourceMethodNode) parentData).signature;
    				String sig = ((SourceMethodNode) data).signature;
    				Map<String, Set<JsonElement>> callers = callerMap.get(parentSig);
    				Set<JsonElement> calls = callers.get(sig);
    				if (calls != null) {
    					return calls;
    				}
    			}
    		}
    	}
    	return Collections.EMPTY_SET;
    }
	/**
     * Open the outline view for the given input element.
     * @param line 
     */
	public static void openView(ICallGraph cg) {
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

    public ICallGraph getCallGraph() {
        return fCallGraph;
    }

    public void reset() {
    	fCallGraph = null;
        updateView();
    }

}
