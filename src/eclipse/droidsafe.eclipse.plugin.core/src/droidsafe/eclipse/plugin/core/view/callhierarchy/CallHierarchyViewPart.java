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
 * View for displaying a source callee hierarchy or a source caller hierarchy. 
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class CallHierarchyViewPart extends DroidsafeInfoOutlineViewPart {

    /** The ID of the view as specified by the extension. */
    public static final String VIEW_ID = "droidsafe.eclipse.plugin.core.view.CallHierarchyView";
    
    /** The call hierarchy to be displayed. */
    private CallHierarchy fCallHierarchy;
    
    /** True if the view is showing a callee hierarchy; false if the view is showing a
     * caller hierarchy */
    private boolean fShowCallees;

    @Override
    protected DroidsafeInfoTreeElementLabelProvider makeLabelProvider() {
        return new CallHierarchyTreeElementLabelProvider(this);
    }

    @Override
    protected DroidsafeInfoTreeElementContentProvider makeContentProvider() {
        return new CallHierarchyTreeElementContentProvider();
    }

    /**
     * Updates the content of the call hierarchy outline view.
     */
    @Override
    protected void updateView() {
        updateView(false);
    }

    /**
     * Updates the content of the call hierarchy outline view. Resets the content first if the 
     * parameter 'resetViewer' is true, 
     */
    public void updateView(boolean resetViewer) {
        if (fParentComposite != null) {
            if (fCallHierarchy == null) {
                showEmptyPage();
            } else {
                if (resetViewer)
                    resetViewer();
                showPage(PAGE_VIEWER);
                setContentDescription(fCallHierarchy.getDescription());
                fTreeViewer.setInput(fCallHierarchy);
            }
        }
    }

    /**
     * Resets the content of the view when a different project is selected.
     */
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
     * Set the input call hierarchy for the viewer and update the contents of the view.
     */
    protected void setInput(CallHierarchy callHierarchy) {
        if ((callHierarchy == null && fCallHierarchy != null) || 
                (callHierarchy != null && !callHierarchy.equals(fCallHierarchy))) {
        	fCallHierarchy = callHierarchy;
            updateView();
        }
    }
    
    /**
     * When a new item is selected from the call hierarchy outline, reveals and highlights the source code for the
     * new selection in an editor and updates info flow details, value info, and points-to info in the 
     * corresponding views.
     */
    @Override
    public void selectionChanged(SelectionChangedEvent e) {
        if (e.getSelectionProvider() == fTreeViewer) {
            ISelection selection = e.getSelection();
            if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
                Object selectedNode = ((IStructuredSelection) selection).getFirstElement();
                if (selectedNode instanceof TreeElement<?, ?>) {
                    TreeElement<?, ?> treeElement = (TreeElement<?, ?>) selectedNode;
                    IProject project = fCallHierarchy.getProject();
                    if (fCallHierarchy instanceof CalleeHierarchy && treeElement.getParent() == null) {
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
        IProject project = fCallHierarchy.getProject();
    	Object data = treeElement.getData();
    	if (data instanceof SourceMethodNode) {
    		Set<MethodModel> methods = getMethodModels(treeElement);
    		if (methods == null || methods.isEmpty()) {
        		CallerHierarchy callerHierarchy = (CallerHierarchy) fCallHierarchy;
    			Set<JsonElement> calls = getCalls(callerHierarchy, treeElement);
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
    
    /**
     * Returns the method models corresponding to the given call hierarchy element.
     */
    public Set<MethodModel> getMethodModels(TreeElement<?, ?> treeElement) {
        IProject project = fCallHierarchy.getProject();
        SecuritySpecModel spec = DroidsafePluginUtilities.getSecuritySpec(project, false, false);
    	Object data = treeElement.getData();
    	if (data instanceof JsonElement) {
        	// case: callee hierarchy
    		return Utils.getMethodModels(spec, (JsonElement) data);
    	} else if (data instanceof SourceMethodNode) {
        	// case: caller hierarchy
    		CallerHierarchy callerHierarchy = (CallerHierarchy) fCallHierarchy;
    		Set<JsonElement> calls = getCalls(callerHierarchy, treeElement);
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

    /**
     * Returns the set of JsonElements representing method calls in the caller hierarchy 
     * from the method (caller) for the given tree element to its parent (callee).
     */
    public static Set<JsonElement> getCalls(CallerHierarchy callerHierarchy, TreeElement<?, ?> treeElement) {
    	Object data = treeElement.getData();
    	if (data instanceof SourceMethodNode) {
    		Map<String, Map<String, Set<JsonElement>>> callerMap = callerHierarchy.getCallerMap();
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
     * Open the call hierarchy outline view for the given input element.
     * 
     * @param callHierarchy - a call hierarchy 
     */
	public static void openView(CallHierarchy callHierarchy) {
        IWorkbenchPage activePage = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
        CallHierarchyViewPart view = (CallHierarchyViewPart) activePage.findView(VIEW_ID);
        if (view == null) {
            // open the view
            try {
                view = (CallHierarchyViewPart) activePage.showView(VIEW_ID);
            } catch (PartInitException e) {
                e.printStackTrace();
            }
        }
        view.setInput(callHierarchy);
        activePage.activate(view);
    }

    /**
     * Returns the CallHierarchyViewPart instance in the workbench.
     */
    public static CallHierarchyViewPart findView() {
        IWorkbenchPage activePage = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
        CallHierarchyViewPart view = (CallHierarchyViewPart) activePage.findView(VIEW_ID);
        return view;
    }

    /**
     * Returns the input call hierarchy for this outline view.
     */
    public CallHierarchy getCallHiearchy() {
        return fCallHierarchy;
    }

    /**
     * Resets this call hierarchy outline view.
     */
    public void reset() {
    	fCallHierarchy = null;
        updateView();
    }

}
