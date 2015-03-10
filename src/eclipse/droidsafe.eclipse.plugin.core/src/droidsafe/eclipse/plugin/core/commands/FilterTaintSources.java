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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;
import org.eclipse.ui.texteditor.ITextEditor;

import droidsafe.eclipse.plugin.core.marker.ProjectMarkerProcessor;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementContentProvider;
import droidsafe.speclang.model.CallLocationModel;

/**
 * Command for specifying filters for tainted data to be displayed in the Java editor.
 * 
 * @author gilham
 *
 */
public class FilterTaintSources extends AbstractHandler {
	
	/**
	 * The taint sources content provider that provides the tree contents for the tainted data filtering 
	 * selection dialog.
	 */
	private TaintSourcesContentProvider fContentProvider;

	/**
	 * Command implementation. Presents a tree selection dialog for the user to select source kinds and
	 * source units to be displayed in the Java editor.
	 */
	@Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IEditorPart editor = DroidsafePluginUtilities.getActiveEditor();
        if (editor != null && editor instanceof ITextEditor) {
        	IProject project = DroidsafePluginUtilities.getProcessedDroidsafeProjectForEditor(editor);
        	if (project != null) {
        		ProjectMarkerProcessor taintMarkerProcessor = ProjectMarkerProcessor.get(project);
        		Map<String,Set<CallLocationModel>> filteredTaintKinds = taintMarkerProcessor.getFilteredTaintSourcesMap();
        		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
        		CheckedTreeSelectionDialog selectionDialog =
        				new CheckedTreeSelectionDialog(shell, new LabelProvider(), getContentProvider(project));
        		selectionDialog.setTitle("Filter Taint Sources");
        		selectionDialog.setMessage("Select the taint sources to display:");
        		selectionDialog.setContainerMode(true);
        		selectionDialog.setInput(project);
        		selectionDialog.setExpandedElements(getExpandedElements());
        		selectionDialog.setInitialElementSelections(getInitialSelection());

        		selectionDialog.open();
        		Object[] result = selectionDialog.getResult();
        		if (result != null) {
        			Map<String, Set<CallLocationModel>> newFilteredTaintKinds = new TreeMap<String, Set<CallLocationModel>>();
        			for (Object selected: result) {
        				TreeElement<?, ?> selectedElement = (TreeElement<?, ?>) selected;
        				Object data = selectedElement.getData();
        				if (data instanceof CallLocationModel) {
        					String taintKind = (String) selectedElement.getParent().getData();
        					CallLocationModel taintSource = (CallLocationModel) data;
        					Set<CallLocationModel> taintSources = newFilteredTaintKinds.get(taintKind);
        					if (taintSources == null) {
        						taintSources = new TreeSet<CallLocationModel>();
        						newFilteredTaintKinds.put(taintKind, taintSources);
        					}
        					taintSources.add(taintSource);
        				}
        			}
        			if (!newFilteredTaintKinds.equals(filteredTaintKinds)) {
        				ITextEditor textEditor = (ITextEditor) editor;
        				taintMarkerProcessor.setFilteredTaintSources(textEditor, newFilteredTaintKinds);
        			}
        		}
        	}
        }
        return null;
    }
	
	/**
	 * Returns the taint sources content provider for the tainted data filtering selection diaglog
	 * 
	 * @param project - the currently selected project in which the tainted data are to be filtered
	 * @return the taint sources content provider
	 */
	private ITreeContentProvider getContentProvider(IProject project) {
		if (fContentProvider == null) {
			fContentProvider = new TaintSourcesContentProvider();
		}
		fContentProvider.init(project);
		return fContentProvider;
	}

	/**
	 * Returns the initially selected tree elements in the taint sources filter dialog.
	 * 
	 * @return the initial selection
	 */
	private List getInitialSelection() {
		return fContentProvider.getInitialSelection();
	}

    /**
     * Returns the expanded tree elements in the taint sources filter dialog.
     * 
     * @return the expanded elements
     */
    private Object[] getExpandedElements() {
    	return fContentProvider.getExpandedElements();
	}

	/**
	 * Provides the tree contents for the taint sources filters.
	 * 
	 * @author gilham
	 *
	 */
	class TaintSourcesContentProvider extends DroidsafeInfoTreeElementContentProvider {

        /**
         * The currently selected project in which the tainted data are to be filtered
         */
        private IProject fProject;
        
        /**
         * The root elements of the tree contents
         */
        private Object[] fRoots;

        /**
         * A map from info source kind to the corresponding info sources.
         */
        private Map<String, Set<CallLocationModel>> fTaintSourcesMap;

        /**
         * A map from filtered info source kind to the corresponding filtered info sources.
         */
        private Map<String, Set<CallLocationModel>> fFilteredTaintSourcesMap;
        
        @Override
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof IProject) {
				return fRoots;
			}
			return NO_CHILDREN;
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	        fViewer = (TreeViewer) viewer;
		}

		@Override
		protected Object[] initializeRoots() {
			if (fTaintSourcesMap.isEmpty())
				return NO_CHILDREN;
			List<Object> roots = new ArrayList<Object>();
			for (Entry<String, Set<CallLocationModel>> entry : fTaintSourcesMap.entrySet()) {
				String taintKind = entry.getKey();
				TreeElement<String, CallLocationModel> root =
						new TreeElement<String, CallLocationModel>(taintKind, taintKind, CallLocationModel.class);
				for (CallLocationModel taintSource : entry.getValue()) {
					TreeElement<CallLocationModel, Object> taintSourceElement =
							new TreeElement<CallLocationModel, Object>(taintSource.toString(), taintSource, Object.class);
					root.addChild(taintSourceElement);
				}
				roots.add(root);
			}
			
			return roots.toArray();
		}

		@Override
		protected void reset() {
		}

		/**
		 * Initializes the taint sources content provider for the given project.
		 * @param project - the project
		 */
		void init(IProject project) {
            fProject = project;
			ProjectMarkerProcessor markerProcessor = ProjectMarkerProcessor.get(fProject);
			fTaintSourcesMap = markerProcessor.getTaintSourcesMap();
			fFilteredTaintSourcesMap = markerProcessor.getFilteredTaintSourcesMap();
			fRoots = initializeRoots();
		}
		
		
		/**
		 * Returns the expanded tree elements.
		 * 
		 * @return the expanded elements
		 */
		Object[] getExpandedElements() {
			List<Object> toExpand = new ArrayList<Object>();
			for (Object root: getElements(fProject)) {
				TreeElement<?, ?> rootElement = (TreeElement<?, ?>) root;
				String taintKind = (String) rootElement.getData();
				Set<CallLocationModel> filteredTaintSources = fFilteredTaintSourcesMap.get(taintKind);
				if (filteredTaintSources != null) {
					Set<CallLocationModel> taintSources = fTaintSourcesMap.get(taintKind);
					if (filteredTaintSources.size() != taintSources.size()) {
						toExpand.add(rootElement);
					}
				}
			}
			return toExpand.toArray(new Object[0]);
		}

		/**
		 * Returns the list of initially selected elements.
		 * 
		 * @return initially selected elements
		 */
		List getInitialSelection() {
			List<Object> initialSelection = new ArrayList<Object>();
			for (Object root: getElements(fProject)) {
				TreeElement<?, ?> rootElement = (TreeElement<?, ?>) root;
				String taintKind = (String) rootElement.getData();
				Set<CallLocationModel> filteredTaintSources = fFilteredTaintSourcesMap.get(taintKind);
				if (filteredTaintSources != null) {
					Set<CallLocationModel> taintSources = fTaintSourcesMap.get(taintKind);
					for (TreeElement<?, ?> child: rootElement.getChildren()) {
						if (filteredTaintSources.contains(child.getData())) {
							initialSelection.add(child);
						}
					}
				}
			}
			return initialSelection;
		}

    }
}
