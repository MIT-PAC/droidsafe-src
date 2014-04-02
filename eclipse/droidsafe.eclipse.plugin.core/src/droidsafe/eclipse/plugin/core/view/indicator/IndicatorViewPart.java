package droidsafe.eclipse.plugin.core.view.indicator;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import droidsafe.eclipse.plugin.core.Activator;
import droidsafe.eclipse.plugin.core.filters.Filter;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoOutlineViewPart;

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
            JsonObject jsonObj = DroidsafePluginUtilities.parseIndicatorFile(fInputElement);
            computeDefaultVisibilityMap(jsonObj);
            computeVisibilityMapFromDefault();
            computeDefaultDisplayMap(jsonObj);
            computeDisplayMapFromDefault();
            String indicatorType = Utils.getFieldValueAsString(jsonObj, "indicator-type");
            if (indicatorType == null) {
                String fileName = fInputElement.getName();
                int pos = fileName.indexOf(".");
                indicatorType = fileName.substring(0, pos).replace('_', ' ');
            }
            setPartName(indicatorType);
            showPage(PAGE_VIEWER);
            fTreeViewer.setInput(jsonObj);
        } else {
            setPartName(DEFAULT_PART_NAME);
        }
    }

    @Override
    protected ITreeContentProvider makeContentProvider() {
        return new IndicatorTreeElementContentProvider(this);
    }

    @Override
    protected IBaseLabelProvider makeLabelProvider() {
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
        view.setInputElement(indicatorFile);
//        activePage.activate(view);
    }

    @Override
    public void selectionChanged(SelectionChangedEvent e) {
        if (e.getSelectionProvider() == fTreeViewer) {
          ISelection selection = e.getSelection();
            revealSelectionInEditor(selection, false);
        }
    }

    protected void projectChanged() {
        reset();
        fIndicatorFiles = DroidsafePluginUtilities.getIndicatorFiles(getProject());
        File indicatorFile = (fIndicatorFiles == null || fIndicatorFiles.length == 0) ? null : fIndicatorFiles[0];
        openView(indicatorFile); 
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
            JsonObject jsonObj = (JsonObject)fTreeViewer.getInput();
            filterFields = Utils.getAllFilterFields(jsonObj).toArray(new String[0]);
        }
        return filterFields;
    }
    
    public void dispose() {
        reset();
    }

    private void reset() {
        setInputElement(null);
    }
}
