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

package droidsafe.eclipse.plugin.core.view.indicator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.util.Util;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import droidsafe.analyses.value.VAUtils;
import droidsafe.eclipse.plugin.core.Activator;
import droidsafe.eclipse.plugin.core.dialogs.SearchDialog;
import droidsafe.eclipse.plugin.core.filters.Filter;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoOutlineViewPart;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementContentProvider;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementLabelProvider;
import droidsafe.eclipse.plugin.core.view.infoflow.InfoFlowDetailsViewPart;
import droidsafe.eclipse.plugin.core.view.pointsto.PointsToViewPart;
import droidsafe.eclipse.plugin.core.view.spec.SecuritySpecOutlineViewPart;
import droidsafe.eclipse.plugin.core.view.value.ValueViewPart;
import droidsafe.speclang.model.MethodModel;
import droidsafe.speclang.model.SecuritySpecModel;

/**
 * View for displaying an indicator outline. 
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class IndicatorViewPart extends DroidsafeInfoOutlineViewPart {

    /** The ID of the view as specified by the extension. */
    public static final String VIEW_ID = "droidsafe.eclipse.plugin.core.view.IndicatorView";

    /** The default part name for the indicator outline view. */
    public static final String DEFAULT_PART_NAME = "Indicator";
    
    /** The indicator files for the current project. */
    protected File[] fIndicatorFiles;
    
    /** The indicator file containing the indicator to be displayed in this outline view. */
    protected File fInputElement;
    
    /** A map from indicator files to the corresponding indicator view states. */
    private Map<File, IndicatorViewState> fStateMap = new HashMap<File, IndicatorViewState>();
    
    /** The text displayed on the empty page. */
    protected static String EMPTY_PAGE_LABEL = "No Android Project selected. "
          + "\nSelect an Android project in the Project Explorer.";
    
    /** The indicator view state for the indicator currently being displayed. */
    private IndicatorViewState fState;

	/** The set of indicator files that need to be reloaded. */
	private Set<File> fFilesToReoad = new HashSet<File>();

    /**
     * Returns the map from element types to visibilities.
     */
    public Map<String, Boolean> getVisibilityMap() {
        return fState.visibilityMap;
    }

    /**
     * Initializes this indicator view with the given parent as a page book of
     * two pages, a content viewer and an empty page label. Display the current
     * page depending on the current project. Sets up a selection listener to
     * listen to project selections. Adds key listeners to support text search
     * and copying the indicator tree to clipboard.
     */
    @Override
    public void createPartControl(Composite parent) {
        showOtherDroidsafeViews(VIEW_ID);
        super.createPartControl(parent);
        fTreeViewer.getControl().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                int modifier = (Util.isMac()) ? SWT.COMMAND : SWT.CTRL;
                if ((e.stateMask & modifier) == modifier) {
                    if (e.keyCode == 'f') {
                        if (fContentProvider.getRootElements() != null) {
                            IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
                            SearchDialog dialog = new SearchDialog(window.getShell(), IndicatorViewPart.this);
                            dialog.open();
                        }
                    } else if (e.keyCode == 'c') {
                        copyTreeToClipboard();
                    }
                }
            }
        });
    }
    
    /**
     * Returns true if the given element type is visible.
     * 
     * @param type - an element type
     * @return visibility of the element type
     */
    public boolean getVisibility(String type) {
        Map<String, Boolean> visibilityMap = getVisibilityMap();
        Boolean visibility = visibilityMap.get(type);
        if (visibility != null)
            return visibility.booleanValue();
        return true;
    }

    /**
     * Toggles the visibility of the given element type in the 
     * indicator's visibility map.
     * 
     * @param type - an element type
     */
    public void toggleVisibility(String type) {
        Map<String, Boolean> visibilityMap = getVisibilityMap();
        Boolean visibility = visibilityMap.get(type);
        if (visibility != null)
            visibilityMap.put(type, !visibility.booleanValue());
    }

    /**
     * Returns the map from fields to whether the fields should be displayed
     * in the element labels.
     */
    public Map<String, Boolean> getLabelDisplayMap() {
        return fState.labelDisplayMap;
    }

    /**
     * Returns true if the values of given field should be displayed
     * in the element labels.
     */
    public boolean getLabelDisplay(String field) {
        Boolean display = fState.labelDisplayMap.get(field);
        if (display != null)
            return display.booleanValue();
        return false;
    }

    /**
     * Toggles the display control for the given field in the indicator's
     * label display map.
     * 
     * @param field - a field
     */
    public void toggleLabelDisplay(String field) {
        Boolean display = fState.labelDisplayMap.get(field);
        if (display != null)
            fState.labelDisplayMap.put(field, !display.booleanValue());
    }

    /**
     * Sets the input element for the indicator view to the given indicator
     * file and updates the contents of the view.
     */
    protected void setInputElement(File indicatorFile) {
        if (indicatorFile != fInputElement || fTreeViewer.getInput() == null) {
            fInputElement = indicatorFile;
            updateView();
        }
    }
    
    /**
     * Return the input element for this outline.
     */
    public File getInputElement() {
        return fInputElement;
    }

    /**
     * Update the content of the outline view.
     */
    public void updateView() {
        if (fInputElement != null && fParentComposite != null) {
            IndicatorViewState oldState = fStateMap.get(fInputElement);
            boolean reload = fFilesToReoad.contains(fInputElement);
            if (reload || oldState == null ) {
                JsonObject jsonObject = DroidsafePluginUtilities.parseIndicatorFile(fInputElement);
                if (jsonObject == null)
                    return;
                fFilesToReoad.remove(fInputElement);
                fState = new IndicatorViewState(fInputElement, jsonObject, getSecuritySpec(), oldState);
                fStateMap.put(fInputElement, fState);
            } else {
                fState = oldState;
            }
            setPartName(fState.indicatorType);
            showPage(PAGE_VIEWER);
            fTreeViewer.setInput(fState.jsonObject);
            if (fTreeViewer.getSorter() == null)
                sortByField(getSortByField());
        } else {
            setPartName(DEFAULT_PART_NAME);
        }
    }

    /* (non-Javadoc)
     * @see droidsafe.eclipse.plugin.core.view.DroidsafeInfoOutlineViewPart#makeContentProvider()
     */
    @Override
    protected DroidsafeInfoTreeElementContentProvider makeContentProvider() {
        return new IndicatorTreeElementContentProvider(this);
    }

    /* (non-Javadoc)
     * @see droidsafe.eclipse.plugin.core.view.DroidsafeInfoOutlineViewPart#makeLabelProvider()
     */
    @Override
    protected DroidsafeInfoTreeElementLabelProvider makeLabelProvider() {
        return new IndicatorTreeElementLabelProvider(this);
    }

    /* (non-Javadoc)
     * @see droidsafe.eclipse.plugin.core.view.DroidsafeInfoViewPart#emptyPageText()
     */
    @Override
    protected String emptyPageText() {
        return EMPTY_PAGE_LABEL;
    }
    
    /* (non-Javadoc)
     * @see droidsafe.eclipse.plugin.core.view.DroidsafeInfoOutlineViewPart#autoExpandLevel()
     */
    @Override
    protected int autoExpandLevel() {
      return 3;
    }

    /**
     * Open the outline view for the given indicator file.
     */
    public static void openView(File indicatorFile) {
        IndicatorViewPart view = openView();
        view.setInputElement(indicatorFile);
    }

    /**
     * Shows the indicator outline view.
     */
    public static IndicatorViewPart openView() {
        IWorkbenchPage activePage = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
        
        IndicatorViewPart view = (IndicatorViewPart) activePage.findView(VIEW_ID);
        if (view == null) {
            // open the view
            try {
                view = (IndicatorViewPart) activePage.showView(VIEW_ID);
            } catch (PartInitException e) {
                e.printStackTrace();
            }
        }
        return view;
    }

    /**
     * When a new item is selected from the indicator outline, reveals and highlights the source 
     * code for the new selection in an editor and displays the info flow details, values, and 
     * points-to info for the selection in the corresponding droidsafe views.
     */
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
                        MethodModel method = getMethodModel((JsonObject) data);
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
     * Returns the method model corresponding to the given Json object, if
     * there is one.  Return null otherwise.
     * 
     * @param data - a Jason object
     * @return the corresponding method model
     */
    private MethodModel getMethodModel(JsonObject data) {
        Map<JsonObject, MethodModel> methodMap = fState.methodMap;
        return methodMap.get(data);
    }

    /**
     * Returns the security spec model for the project that the current
     * indicator belongs to. 
     */
    public SecuritySpecModel getSecuritySpec() {
        IWorkbenchPage activePage = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
        IViewPart view = activePage.findView(SecuritySpecOutlineViewPart.VIEW_ID);
        if (view == null) {
            // open the view
            try {
                view = activePage.showView(SecuritySpecOutlineViewPart.VIEW_ID);
            } catch (PartInitException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return ((SecuritySpecOutlineViewPart)view).getSecuritySpec();
    }

    /**
     * If the project contains indicator files, shows the first indicator in
     * the indicator outline view. Otherwise, shows the empty page in the
     * indicator view.
     */
    protected void projectSelected() {
//        reset();
        fIndicatorFiles = getIndicatorFiles();
        if (fIndicatorFiles == null || fIndicatorFiles.length == 0) {
            fEmptyPageLabel.setText(noJsonFileMessage());
            setPartName("Indicator");
            showEmptyPage();
        } else {
            File indicatorFile = fIndicatorFiles[0];
            openView(indicatorFile);
        }
    }
    
    /**
     * Returns the message indicating that there are no indicator files for the selected
     * project.
     */
    private String noJsonFileMessage() {
        IProject project = getProject();
        return "No indicator (.json) files found in the droidsafe output directory\n\n  " + 
                DroidsafePluginUtilities.getProjectOutputDir(project);
    }

    /**
     * Adds the given filter to the list of filters for this indicator.
     * 
     * @param filter - a filter
     */
    public void addFilter(Filter filter) {
        fState.addFilter(filter);
        refresh(true, false);
    }

    /**
     * Returns the list of filters for this indicator.
     */
    public List<Filter> getFilters() {
        return fState.filters;
    }

    /**
     * Sets the filters for the this indicator to the given list.
     * 
     * @param filters - a list of filters
     */
    public void setFilters(List<Filter> filters) {
        fState.filters = filters;
        refresh(true, false);
    }

    /**
     * Returns the indicator files for the currently selected project.
     */
    public File[] getIndicatorFiles() {
        IProject project = getProject();
        return DroidsafePluginUtilities.getIndicatorFiles(project);
    }

    /**
     * Returns the fields that can be used for filtering the indicator display.
     */
    public String[] getFilterFields() {
        return fState.getFilterFields();
    }
    
    /**
     * Returns the fields that can be used for sorting the indicator display.
     */
    public Set<String> getSortByFields() {
        return fState.getSortByFields();
    }
    
    /**
     * Returns the field currently used for sorting the indicator display.
     */
    public String getSortByField() {
        return fState.getSortByField();
    }

    /**
     * Set the sort-by field to the given field.
     * 
     * @param field - a field.
     */
    public void setSortByField(String field) {
        fState.sortByField = field;
    }

    /* (non-Javadoc)
     * @see droidsafe.eclipse.plugin.core.view.DroidsafeInfoViewPart#dispose()
     */
    public void dispose() {
        reset();
    }

    /**
     * Resets the indicator outline view.
     */
    private void reset() {
        setInputElement(null);
    }

    /**
     * Sort the indicator outline by the values of the given field.
     * 
     * @param field - a field
     */
    public void sortByField(final String field) {
        if (field != null) {
            TreeViewer viewer = getViewer();
            ISelection savedSelections = viewer.getSelection();

            viewer.setComparator(new ViewerComparator() {
                public int compare(Viewer view, Object o1, Object o2) {
                    if (o1 instanceof TreeElement<?, ?> && o2 instanceof TreeElement<?, ?>) {
                        Object data1 = ((TreeElement<?, ?>) o1).getData();
                        Object data2 = ((TreeElement<?, ?>) o2).getData();
                        return compare(view, data1, data2);

                    } else if (o1 instanceof JsonObject && o2 instanceof JsonObject) {
                        JsonObject jsonObj1 = (JsonObject) o1;
                        JsonObject jsonObj2 = (JsonObject) o2;
                        if (field.equals("label")) {
                            return compareLabel(jsonObj1, jsonObj1);
                        }
                        int result = Utils.compareField(jsonObj1, jsonObj2, field);
                        return (result == 0) ? compareLabel(jsonObj1, jsonObj1) : result;
                    } else {
                        return 0;
                    }
                }

            });
//            viewer.expandAll();
            selectObjects(savedSelections);
        }
    }

    /**
     * Compares the labels for the two given Json objects. Returns a negative
     * integer if the first label lexicographically precedes the second label.
     * Returns a positive integer if the first label lexicographically follows
     * the second label. Returns zero if the labels are equal.
     * 
     * @param jsonObj1 - a Json object
     * @param jsonObj2 - a Json object
     * @return the label comparison result
     */
    private int compareLabel(JsonObject jsonObj1, JsonObject jsonObj2) {
        String label1 = getLabel(jsonObj1);
        String label2 = getLabel(jsonObj2);
        return label1.compareTo(label2);
    }

    /**
     * Computes and returns the label for the given Json object.
     * 
     * @param jsonObj - a Json object
     * @return the label
     */
    public String getLabel(JsonObject jsonObj) {
        String label = Utils.getFieldValueAsString(jsonObj, "label");
        if (label != null)
            return label;
        String sig = Utils.getFieldValueAsString(jsonObj, "signature");
        if (sig != null) {
            if (longLabel())
                sig = sig.substring(1, sig.length() - 1);
            else
                sig = Utils.shortSignature(sig);
            label = DroidsafePluginUtilities.removeCloneSuffix(sig);
            for (Map.Entry<String, JsonElement> entry: jsonObj.entrySet()) {
                String field = entry.getKey();
                if (getLabelDisplay(field))
                    label = label + " (" + field + "=" + entry.getValue() + ")";
            }
            return label;
        }
        return null;
    }

    /**
     * This method will re-select the nodes that were selected before the change in the outline
     * structure.
     * 
     * This method should be called by any method that changes the structure of the outline tree.
     * 
     * @param savedSelections The set of nodes selected before the change in the structure of the
     *        outline.
     */
    private void selectObjects(ISelection savedSelections) {
        List<Object> selectedElements = new ArrayList<Object>();
        if (savedSelections != null && savedSelections instanceof IStructuredSelection) {
            IStructuredSelection structuredSelection = ((IStructuredSelection) savedSelections);
            for (Object selection : structuredSelection.toList()) {
                if (selection instanceof TreeElement<?, ?>) {
                    TreeElement<?, ?> element = (TreeElement<?, ?>) selection;
                    TreeElement<?, ?> newTreeElement = ((IndicatorTreeElementContentProvider)fContentProvider).findTreeElement(element.getData());
                    if (newTreeElement != null) {
                        selectedElements.add(newTreeElement);
                    }
                }
            }
        }
        if (!selectedElements.isEmpty()) {
            getViewer().setSelection(new StructuredSelection(selectedElements), true);
        }
    }

    /**
     * Returns true if long labels are uses in the indicator display.
     */
    public boolean longLabel() {
        return fState.longLabel;
    }

    /**
     * Sets the boolean flag indicating whether long labels are uses in the 
     * indicator display to the given value. Updates the labels in the display
     * correspondingly.
     */
    public void setLongLabel(boolean longLabel) {
        fState.longLabel = longLabel;
        updateLabels();
    }

    /**
     * Returns the root elements of the indicator outline.
     */
    public Object[] getRootElements() {
        return fState.rootElements;
    }
    
    /**
     * Sets the root elements of the indicator outline to the given value.
     */
   public void setRootElements(Object[] rootElements) {
        fState.rootElements = rootElements;
    }
    
    /**
     * Copies the tree contents to a clipboard.
     */
    public void copyTreeToClipboard() {
        Clipboard cb = new Clipboard(Display.getDefault());
        String text = contentToText();
        TextTransfer textTransfer = TextTransfer.getInstance();
        cb.setContents(new Object[]{text}, new Transfer[] {textTransfer});
    }

    /**
     * Returns a string representation of the indicator outline contents.
     */
    public String contentToText() {
        StringBuffer buf = new StringBuffer();
        IndicatorTreeElementContentProvider contentProvider = (IndicatorTreeElementContentProvider)fContentProvider;
        for (Object rootElement: contentProvider.getSortedRootElements()) {
            contentToText(rootElement, 0, buf);
        }
        return buf.toString();
    }

    /**
     * Appends a string representation of the content of the tree rooted at the given
     * tree element to the given string buffer.
     * 
     * @param element - a tree element
     * @param level - the indent level
     * @param buf - the string buffer to write the content to.
     */
    private void contentToText(Object element, int level, StringBuffer buf) {
        String indent = VAUtils.indent(level);
        buf.append(indent);
        String label = fLabelProvider.getText(element);
        buf.append(label);
        buf.append("\n");
        if (getViewer().getExpandedState(element)) {
            for (Object child: fContentProvider.getSortedChildren(element)) {
                contentToText(child, level + 1, buf);
            }   
        }
    }

	/**
	 * Returns true if the given indicator file needs to be reloaded.
	 */
	public boolean needsReload(File file) {
		return fFilesToReoad.contains(file);
	}

	/**
	 * Adds the given indicator file to the list of files need to be reloaded.
	 */
	public void forceReload(File file) {
		fFilesToReoad.add(file);
	}
	
	/**
	 * Adds all the indicator files in this project to the list of files
	 * need to be reloaded.
	 */
	public void forceReloadAll() {
		fFilesToReoad.addAll(fStateMap.keySet());
	}
    
}
