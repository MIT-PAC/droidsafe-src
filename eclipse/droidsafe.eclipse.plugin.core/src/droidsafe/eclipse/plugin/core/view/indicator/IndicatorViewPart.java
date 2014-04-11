package droidsafe.eclipse.plugin.core.view.indicator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

import com.google.gson.JsonObject;

import droidsafe.eclipse.plugin.core.Activator;
import droidsafe.eclipse.plugin.core.filters.Filter;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoOutlineViewPart;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementContentProvider;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementLabelProvider;

/**
 * View for displaying the points-to info on the receiver/arguments of a given method. 
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class IndicatorViewPart extends DroidsafeInfoOutlineViewPart {

    /** The ID of the view as specified by the extension. */
    public static final String VIEW_ID = "droidsafe.eclipse.plugin.core.view.IndicatorView";

    public static final String DEFAULT_PART_NAME = "Indicator";
    
    protected File[] fIndicatorFiles;
    
    protected File fInputElement;
    
    private Map<File, IndicatorViewState> fStateMap = new HashMap<File, IndicatorViewState>();
    
    /** The text displayed on the empty page. */
    protected static String EMPTY_PAGE_LABEL = "No Android Project selected. "
          + "\nSelect an Android project in the Project Explorer.";
    
    private IndicatorViewState fState;

    public Map<String, Boolean> getVisibilityMap() {
        return fState.visibilityMap;
    }

    public boolean getVisibility(String type) {
        Map<String, Boolean> visibilityMap = getVisibilityMap();
        Boolean visibility = visibilityMap.get(type);
        if (visibility != null)
            return visibility.booleanValue();
        return true;
    }

    public void toggleVisibility(String type) {
        Map<String, Boolean> visibilityMap = getVisibilityMap();
        Boolean visibility = visibilityMap.get(type);
        if (visibility != null)
            visibilityMap.put(type, !visibility.booleanValue());
    }

    public Map<String, Boolean> getDisplayMap() {
        return fState.displayMap;
    }

    public boolean getDisplay(String field) {
        Boolean display = fState.displayMap.get(field);
        if (display != null)
            return display.booleanValue();
        return false;
    }

    public void toggleDisplay(String field) {
        Boolean display = fState.displayMap.get(field);
        if (display != null)
            fState.displayMap.put(field, !display.booleanValue());
    }

    /**
     * Set the input element for the viewer and update the contents of the view.
     */
    protected void setInputElement(File indicatorFile) {
        setInputElement(indicatorFile, false);
    }

    protected void setInputElement(File indicatorFile, boolean reload) {
        if (indicatorFile != fInputElement || fTreeViewer.getInput() == null) {
            fInputElement = indicatorFile;
            updateView(reload);
        }
    }
    
    protected static String getViewId() {
        return null;
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
        updateView(false);
    }

    /**
     * Update the content of the outline view.
     */
    public void updateView(boolean reload) {
        if (fInputElement != null && fParentComposite != null) {
            IndicatorViewState oldState = fStateMap.get(fInputElement);
            if (reload || oldState == null ) {
                JsonObject jsonObject = DroidsafePluginUtilities.parseIndicatorFile(fInputElement);
                if (jsonObject == null)
                    return;
                fState = new IndicatorViewState(fInputElement, jsonObject, oldState);
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

    @Override
    protected DroidsafeInfoTreeElementContentProvider makeContentProvider() {
        return new IndicatorTreeElementContentProvider(this);
    }

    @Override
    protected DroidsafeInfoTreeElementLabelProvider makeLabelProvider() {
        return new IndicatorTreeElementLabelProvider(this);
    }

    @Override
    protected String emptyPageText() {
        return EMPTY_PAGE_LABEL;
    }
    
    @Override
    protected int autoExpandLevel() {
      return 3;
    }

    /**
     * Open the outline view for the given input element.
     */
    public static void openView(File indicatorFile) {
        IndicatorViewPart view = openView();
        view.setInputElement(indicatorFile);
    }

    /**
     * Show the outline view.
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

    @Override
    public void selectionChanged(SelectionChangedEvent e) {
        if (e.getSelectionProvider() == fTreeViewer) {
          ISelection selection = e.getSelection();
            revealSelectionInEditor(selection, false);
        }
    }

    protected void projectSelected() {
//        reset();
        fIndicatorFiles = getIndicatorFiles();
        if (fIndicatorFiles == null || fIndicatorFiles.length == 0) {
            fEmptyPageLabel.setText(noJsonFileMessage());
            showPage(PAGE_EMPTY);
        } else {
            File indicatorFile = fIndicatorFiles[0];
            openView(indicatorFile);
        }
    }
    
    private String noJsonFileMessage() {
        IProject project = getProject();
        return "No indicator (.json) files found in the droidsafe output directory\n\n  " + 
                DroidsafePluginUtilities.getProjectOutputDir(project);
    }

    public void addFilter(Filter filter) {
        fState.addFilter(filter);
        refresh(true, false);
    }

    public List<Filter> getFilters() {
        return fState.filters;
    }

    public void setFilters(List<Filter> filters) {
        fState.filters = filters;
        refresh(true, false);
    }

    public File[] getIndicatorFiles() {
        IProject project = getProject();
        return DroidsafePluginUtilities.getIndicatorFiles(project);
    }

    public String[] getFilterFields() {
        return fState.getFilterFields();
    }
    
    public Set<String> getSortByFields() {
        return fState.getSortByFields();
    }
    
    public String getSortByField() {
        return fState.getSortByField();
    }

    public void setSortByField(String field) {
        fState.sortByField = field;
    }

    public void dispose() {
        reset();
    }

    private void reset() {
        setInputElement(null);
    }

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
                        int result = Utils.compareField(jsonObj1, jsonObj2, field);
                        for (String sigField: Utils.SIGNATURE_FIELDS) {
                            if (result != 0)
                                break;
                            if (!field.equals(sigField))
                                result = Utils.compareField(jsonObj1, jsonObj2, sigField);
                        }
                        return result;
                    } else {
                        return 0;
                    }
                }
            });
            viewer.expandAll();
            selectObjects(savedSelections);
        }
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

    public boolean longLabel() {
        return fState.longLabel;
    }

    public void setLongLabel(boolean longLabel) {
        fState.longLabel = longLabel;
        updateLabels();
    }

    public Object[] getRootElements() {
        return fState.rootElements;
    }
    
    public void setRootElements(Object[] rootElements) {
        fState.rootElements = rootElements;
    }

}
