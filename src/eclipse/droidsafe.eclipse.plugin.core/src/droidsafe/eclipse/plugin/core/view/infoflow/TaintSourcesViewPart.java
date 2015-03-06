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

package droidsafe.eclipse.plugin.core.view.infoflow;

import java.util.Map;
import java.util.Set;

import org.eclipse.core.filebuffers.FileBuffers;
import org.eclipse.core.filebuffers.IFileBuffer;
import org.eclipse.core.filebuffers.IFileBufferListener;
import org.eclipse.core.filebuffers.ITextFileBuffer;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.IShowInSource;
import org.eclipse.ui.part.ShowInContext;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.texteditor.ITextEditor;

import com.google.gson.JsonElement;

import droidsafe.eclipse.plugin.core.Activator;
import droidsafe.eclipse.plugin.core.marker.ClassMarkerProcessor;
import droidsafe.eclipse.plugin.core.marker.TaintMarker;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoOutlineViewPart;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementContentProvider;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementLabelProvider;
import droidsafe.eclipse.plugin.core.view.callhierarchy.CalleeHierarchy;
import droidsafe.eclipse.plugin.core.view.indicator.Utils;
import droidsafe.eclipse.plugin.core.view.pointsto.PointsToTreeElementLabelProvider;
import droidsafe.eclipse.plugin.core.view.pointsto.PointsToViewPart;
import droidsafe.eclipse.plugin.core.view.value.ValueViewPart;
import droidsafe.speclang.model.CallLocationModel;
import droidsafe.speclang.model.MethodArgumentModel;
import droidsafe.speclang.model.MethodModel;
import droidsafe.speclang.model.SecuritySpecModel;
import droidsafe.utils.SourceLocationTag;

/**
 * Outline view for displaying the info sources of a tainted variable or field.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class TaintSourcesViewPart extends DroidsafeInfoOutlineViewPart {

    /** The ID of the view as specified by the extension. */
    public static final String VIEW_ID = "droidsafe.eclipse.plugin.core.view.TaintSourcesView";

    /** The taint marker on which the info flow sources are to be displayed. */
    private IMarker fTaintMarker;
    
    /** The string representation of the tainted data */
    private String fTaintedData;

    @Override
    protected DroidsafeInfoTreeElementLabelProvider makeLabelProvider() {
        return new TaintSourcesTreeElementLabelProvider();
    }

    @Override
    protected DroidsafeInfoTreeElementContentProvider makeContentProvider() {
        return new TaintSourcesTreeElementContentProvider();
    }

    @Override
    public void selectionChanged(SelectionChangedEvent e) {
    	if (e.getSelectionProvider() == fTreeViewer) {
    		ISelection selection = e.getSelection();
    		if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
    			Object selectedNode = ((IStructuredSelection) selection).getFirstElement();
    			if (selectedNode instanceof TreeElement<?, ?>) {
    				TreeElement<?, ?> treeElement = (TreeElement<?, ?>) selectedNode;
    				Object data = treeElement.getData();
    				if (data instanceof CallLocationModel) {
    					revealSelectionInEditor(selection, false);
    		    		IProject project = fTaintMarker.getResource().getProject();
    					SecuritySpecModel spec = DroidsafePluginUtilities.getSecuritySpec(project, false, false);
    					if (spec != null) {
    						CallLocationModel call = (CallLocationModel) data;
    						String sig = call.getTargetMethodSig();
    						String srcClass = call.getClz();
    						int srcLine = call.getLine();
    						Set<MethodModel> methods = Utils.getMethodModels(spec, sig, srcClass, srcLine, "as_call");
    						MethodModel method = (methods.isEmpty()) ? null : methods.iterator().next();
    						InfoFlowDetailsViewPart.openView(method);
    						ValueViewPart.openView(method);
    						PointsToViewPart.openView(method);
    					}
    				}
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
        Object data = treeElement.getData();
    	if (data instanceof SourceLocationTag) {
    		IProject project = fTaintMarker.getResource().getProject();
    		DroidsafePluginUtilities.revealInEditor(project, (SourceLocationTag) data, activate);
    	}
    }
    
    @Override
    protected void updateView() {
        updateView(false);
    }

    /**
     * Updates the taint sources outline view. Resets the viewer first if
     * the parameter resetViewer is true.
     */
    public void updateView(boolean resetViewer) {
        if (fParentComposite != null) {
            if (fTaintMarker == null) {
                showEmptyPage();
            } else {
                if (resetViewer)
                    resetViewer();
                showPage(PAGE_VIEWER);
                setContentDescription("Sources for " + fTaintedData);
                fTreeViewer.setInput(fTaintMarker);
            }
        }        
    }

    @Override
    protected void projectSelected() {
        resetViewer();
        setInput(null, null);
    }

    @Override
    protected String emptyPageText() {
        return "";
    }

    /**
     * Set the input element for the viewer and update the contents of the view.
     */
    protected void setInput(IMarker inputElement, String taint) {
        if ((inputElement == null && fTaintMarker != null) || 
                (inputElement != null && !inputElement.equals(fTaintMarker))) {
            fTaintMarker = inputElement;
            fTaintedData = taint;
            updateView();
        }
    }

    /**
     * Open the outline view for the given input element.
     */
    public static void openView(IMarker inputElement, String taint) {
        IWorkbenchPage activePage = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
        TaintSourcesViewPart view = (TaintSourcesViewPart) activePage.findView(VIEW_ID);
        if (view == null) {
            // open the view
            try {
                view = (TaintSourcesViewPart) activePage.showView(VIEW_ID);
            } catch (PartInitException e) {
                e.printStackTrace();
            }
        }
        view.setInput(inputElement, taint);
        activePage.activate(view);
    }

    /**
     * Returns the instance of TaintSourcesViewPart in the workbench.
     */
    public static TaintSourcesViewPart findView() {
        IWorkbenchPage activePage = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
        TaintSourcesViewPart view = (TaintSourcesViewPart) activePage.findView(VIEW_ID);
        return view;
    }

    /**
     * Returns the input taint marker.
     */
    public IMarker getTaintMarker() {
        return fTaintMarker;
    }

    /**
     * Resets the taint sources outline view.
     */
    public void reset() {
        fTaintMarker = null;
        updateView();
    }

}
