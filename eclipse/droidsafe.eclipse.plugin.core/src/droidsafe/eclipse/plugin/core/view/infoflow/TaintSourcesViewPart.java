package droidsafe.eclipse.plugin.core.view.infoflow;

import java.util.Set;

import org.eclipse.core.filebuffers.FileBuffers;
import org.eclipse.core.filebuffers.IFileBuffer;
import org.eclipse.core.filebuffers.IFileBufferListener;
import org.eclipse.core.filebuffers.ITextFileBuffer;
import org.eclipse.core.resources.IMarker;
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

import droidsafe.eclipse.plugin.core.Activator;
import droidsafe.eclipse.plugin.core.marker.ClassMarkerProcessor;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoOutlineViewPart;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementContentProvider;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementLabelProvider;
import droidsafe.eclipse.plugin.core.view.pointsto.PointsToTreeElementLabelProvider;
import droidsafe.eclipse.plugin.core.view.pointsto.PointsToViewPart;
import droidsafe.speclang.model.MethodModel;

/**
 * View for displaying the info flow on the receiver/arguments of a given method. 
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class TaintSourcesViewPart extends DroidsafeInfoOutlineViewPart {

    /** The ID of the view as specified by the extension. */
    public static final String VIEW_ID = "droidsafe.eclipse.plugin.core.view.TaintSourcesView";

    /** The taint marker on which the info flow sources are to be displayed. */
    private IMarker fMarker;
    
    private String fTaint;

    @Override
    protected DroidsafeInfoTreeElementLabelProvider makeLabelProvider() {
        return new TaintSourcesTreeElementLabelProvider();
    }

    @Override
    protected DroidsafeInfoTreeElementContentProvider makeContentProvider() {
        return new TaintSourcesTreeElementContentProvider();
    }

    @Override
    protected void updateView() {
        updateView(false);
    }

    public void updateView(boolean resetViewer) {
        if (fParentComposite != null) {
            if (fMarker == null) {
                showPage(PAGE_EMPTY);
            } else {
                if (resetViewer)
                    resetViewer();
                showPage(PAGE_VIEWER);
                Set<String> kinds = ClassMarkerProcessor.getFilteredTaintKinds(fMarker);
                setContentDescription("Sources for " + fTaint + ": " + kinds);
                fTreeViewer.setInput(fMarker);
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
        if ((inputElement == null && fMarker != null) || 
                (inputElement != null && !inputElement.equals(fMarker))) {
            fMarker = inputElement;
            fTaint = taint;
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

    public static TaintSourcesViewPart findView() {
        IWorkbenchPage activePage = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
        TaintSourcesViewPart view = (TaintSourcesViewPart) activePage.findView(VIEW_ID);
        return view;
    }

    public IMarker getMarker() {
        return fMarker;
    }

    public void reset() {
        fMarker = null;
        updateView();
    }

}
