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

/**
 * Text hover for taint markers. Displays the filtered source info for the marker being hovered over.
 * 
 * @author gilham
 *
 */
public class TaintMarkerTextHover implements IJavaEditorTextHover {

    /**
     * The Java editor for the Java source file containing the taint marker.
     */
    private IEditorPart fEditor;

    /**
     * Returns a string that contains the filtered taint source info in the format:
     * 
     * Taint Sources: <info kinds>
     * 
     *   <info kind>
     *     <info unit>
     *     ...
     *   ...
     *   
     */
    @Override
    public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
    	if (fEditor != null) {
    		IFile file = DroidsafePluginUtilities.getEditorInputFile(fEditor);
    		if (file != null) {
    			IProject project = DroidsafePluginUtilities.getProcessedDroidsafeProjectForEditor(fEditor);
    			if (project != null) {
    				if (DroidsafePluginUtilities.getSecuritySpec(project, false, false) != null) {
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
