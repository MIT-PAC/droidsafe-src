package droidsafe.eclipse.plugin.core.marker;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.ui.text.java.hover.IJavaEditorTextHover;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.ui.IEditorPart;

import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.speclang.model.CallLocationModel;

public class TaintMarkerTextHover implements IJavaEditorTextHover {

    private IEditorPart fEditor;

    @Override
    public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
    	if (fEditor != null) {
    		IProject project = DroidsafePluginUtilities.getSelectedProject(fEditor);
    		if (project != null) {
    			IFile file = DroidsafePluginUtilities.getEditorInputFile(fEditor);
    			if (file != null) {
    				ProjectMarkerProcessor taintMarkerProcessor = ProjectMarkerProcessor.get(project);
    				IMarker marker = taintMarkerProcessor.findTaintMarker(file, hoverRegion.getOffset(), hoverRegion.getLength());
    				if (marker != null) {
    					Map<String, Set<CallLocationModel>> map = TaintMarker.getFilteredTaintSourcesMap(marker);
    					StringBuffer buf = new StringBuffer("Taint Sources: " + map.keySet() + "\n ");
    					for (Entry<String, Set<CallLocationModel>> entry: map.entrySet()) {
    						buf.append("<br><br>" + entry.getKey() + "\n  <ul>\n");
    						for (CallLocationModel source: entry.getValue()) {
    							buf.append("    <li>"+ source + "</li>\n");
    						}
    						buf.append("  </ul>\n");
    					}
    					return buf.toString();
    				}
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
