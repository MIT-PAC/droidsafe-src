package droidsafe.eclipse.plugin.core.marker;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.ui.text.java.hover.IJavaEditorTextHover;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.FileEditorInput;

import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;

public class TaintMarkerTextHover implements IJavaEditorTextHover {

    private IEditorPart fEditor;

    @Override
    public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
        if (fEditor != null) {
            IProject project = DroidsafePluginUtilities.getSelectedProject(fEditor);
            IEditorInput input = fEditor.getEditorInput();
            if (project != null && input instanceof FileEditorInput) {
                IFile file = ((FileEditorInput)input).getFile();
                ProjectTaintMarkerProcessor taintMarkerProcessor = ProjectTaintMarkerProcessor.get(project);
                IMarker marker = taintMarkerProcessor.findTaintMarker(file, hoverRegion.getOffset(), hoverRegion.getLength());
                if (marker != null) {
                    Set<String> kinds = TaintMarker.getFilteredTaintKinds(marker);
                    return "Taint " + kinds.toString();
                }
            }
        }
        return null;
    }

    @Override
    public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
        return null;
    }

    @Override
    public void setEditor(IEditorPart editor) {
        fEditor = editor;
    }

}
