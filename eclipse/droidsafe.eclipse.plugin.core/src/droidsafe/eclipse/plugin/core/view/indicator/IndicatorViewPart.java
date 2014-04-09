package droidsafe.eclipse.plugin.core.view.indicator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

import com.google.gson.JsonElement;
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
    
    /** The text displayed on the empty page. */
    protected static String EMPTY_PAGE_LABEL = "No Android Project selected. "
          + "\nSelect an Android project in the Project Explorer."
          + "\nYou may also need to run the Droidsafe spec generation "
          + "command from the project context menu.";
    
    private Map<String, Boolean> visibilityMap = new TreeMap<String, Boolean>();
    
    private Map<String, Boolean> defaultVisibilityMap = null;
    
    private Map<String, Boolean> displayMap = new TreeMap<String, Boolean>();
    
    private Map<String, Boolean> defaultDisplayMap = null;

    private String[] filterFields;

    private Set<String> sortByFields;

    private String sortByField;

    private JsonObject jsonObject;

    public Map<String, Boolean> getVisibilityMap() {
        return visibilityMap;
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
        return displayMap;
    }

    public boolean getDisplay(String field) {
        Boolean display = displayMap.get(field);
        if (display != null)
            return display.booleanValue();
        return false;
    }

    public void toggleDisplay(String field) {
        Boolean display = displayMap.get(field);
        if (display != null)
            displayMap.put(field, !display.booleanValue());
    }

    private void computeDefaultVisibilityMap(JsonObject jsonObj) {
        defaultVisibilityMap = new TreeMap<String, Boolean>();
        JsonElement visibility = jsonObj.get("visibility");
        if (visibility != null && visibility.isJsonObject()) {
            for (Map.Entry<String, JsonElement> entry: visibility.getAsJsonObject().entrySet()) {
                String key = entry.getKey();
                Boolean value = Boolean.valueOf(entry.getValue().getAsBoolean());
                defaultVisibilityMap.put(key, value);
            }
        }
    }

    private void computeVisibilityMapFromDefault() {
        for (String key: visibilityMap.keySet()) {
            if (!defaultVisibilityMap.containsKey(key)) {
                visibilityMap.remove(key);
            }
        }
        for (String key: defaultVisibilityMap.keySet()) {
            if (!visibilityMap.containsKey(key)) {
                visibilityMap.put(key, defaultVisibilityMap.get(key));
            }
        }
    }

    private void computeDefaultDisplayMap(JsonObject jsonObj) {
        defaultDisplayMap = new TreeMap<String, Boolean>();
        JsonElement display = jsonObj.get("display");
        if (display != null && display.isJsonObject()) {
            for (Map.Entry<String, JsonElement> entry: display.getAsJsonObject().entrySet()) {
                String key = entry.getKey();
                Boolean value = Boolean.valueOf(entry.getValue().getAsBoolean());
                defaultDisplayMap.put(key, value);
            }
        }
    }

    private void computeDisplayMapFromDefault() {
        for (String key: displayMap.keySet()) {
            if (!defaultDisplayMap.containsKey(key)) {
                displayMap.remove(key);
            }
        }
        for (String key: defaultDisplayMap.keySet()) {
            if (!displayMap.containsKey(key)) {
                displayMap.put(key, defaultDisplayMap.get(key));
            }
        }
    }

    /**
     * Set the input element for the viewer and update the contents of the view.
     */
    protected void setInputElement(File indicatorFile) {
        if (indicatorFile != fInputElement || fTreeViewer.getInput() == null) {
            fInputElement = indicatorFile;
            updateView();
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
        if (fInputElement != null && fParentComposite != null) {
            jsonObject = DroidsafePluginUtilities.parseIndicatorFile(fInputElement);
            computeDefaultVisibilityMap(jsonObject);
            computeVisibilityMapFromDefault();
            computeDefaultDisplayMap(jsonObject);
            computeDisplayMapFromDefault();
            String indicatorType = Utils.getFieldValueAsString(jsonObject, "indicator-type");
            if (indicatorType == null) {
                String fileName = fInputElement.getName();
                int pos = fileName.indexOf(".");
                indicatorType = fileName.substring(0, pos).replace('_', ' ');
            }
            setPartName(indicatorType);
            showPage(PAGE_VIEWER);
            if (fTreeViewer.getSorter() == null)
                sortByField(getSortByField());
            fTreeViewer.setInput(jsonObject);
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
        reset();
        IProject project = getProject();
        fIndicatorFiles = DroidsafePluginUtilities.getIndicatorFiles(project);
        if (fIndicatorFiles == null || fIndicatorFiles.length == 0) {
            fEmptyPageLabel.setText(noJsonFileMessage(project));
            showPage(PAGE_EMPTY);
        } else {
            File indicatorFile = fIndicatorFiles[0];
            openView(indicatorFile);
        }
    }
    
    private String noJsonFileMessage(IProject project) {
        return "No indicator (.json) files found in the droidsafe output directory\n\n  " + 
                DroidsafePluginUtilities.getProjectOutputDir(project);
    }

    public void addFilter(Filter filter) {
        ((IndicatorTreeElementContentProvider)fContentProvider).addFilter(filter);
        refresh();
    }

    public List<Filter> getFilters() {
        return ((IndicatorTreeElementContentProvider)fContentProvider).getFilters();
    }

    public void setFilters(List<Filter> filters) {
        ((IndicatorTreeElementContentProvider)fContentProvider).setFilters(filters);
        refresh();
    }

    public File[] getIndicatorFiles() {
        return fIndicatorFiles;
    }

    public String[] getFilterFields() {
        if (filterFields == null) {
            filterFields = Utils.getAllFilterFields(jsonObject).toArray(new String[0]);
        }
        return filterFields;
    }
    
    public Set<String> getSortByFields() {
        if (sortByFields == null && jsonObject != null) {
            sortByFields = Utils.getSortByFields(jsonObject);
        }
        return sortByFields;
    }
    
    public String getSortByField() {
        if (sortByField == null) {
            Set<String> fields = getSortByFields();
            if (fields.contains("class"))
                sortByField = "class";
            else
                sortByField = fields.iterator().next();
        }
        return sortByField;
    }

    public void setSortByField(String field) {
        sortByField = field;
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

}
