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

package droidsafe.eclipse.plugin.core.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.FileEditorInput;

import droidsafe.eclipse.plugin.core.marker.ProjectMarkerProcessor;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.infoflow.TaintSourcesViewPart;

/**
 * Command to show taint sources for the selected tainted variable or field reference in the Java editor
 * window.
 * 
 * @author gilham
 *
 */
public class ShowTaintSources extends AbstractHandler {

	/**
	 * Command implementation. When the current selection in the Java editor is a tainted variable or
	 * field reference, display in an outline window the taint sources for the selection. The first
	 * level in the outline contains the filtered source kinds.  The second level contains the filtered
	 * source units for each source kind.
	 */
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
    	IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
    	IWorkbenchPage activePage = window.getActivePage();
    	ISelection selection = HandlerUtil.getActiveSite(event).getSelectionProvider().getSelection();
    	if (selection instanceof TextSelection) {
    		TextSelection textSelection = (TextSelection) selection;
    		IEditorPart editor = activePage.getActiveEditor();
    		IProject project = DroidsafePluginUtilities.getProcessedDroidsafeProjectForEditor(editor);
    		if (project != null) {
    			IEditorInput input = editor.getEditorInput();
    			if (input instanceof FileEditorInput) {
    				IFile file = ((FileEditorInput)input).getFile();
    				int offset = textSelection.getOffset();
    				int length = textSelection.getLength();
    				IMarker taintMarker = ProjectMarkerProcessor.get(project).findTaintMarker(file, offset, length);
    				if (taintMarker != null) {
    					TaintSourcesViewPart.openView(taintMarker, textSelection.getText());
    				}
    			}
    		}
    	}
    	return null;
    }

}
