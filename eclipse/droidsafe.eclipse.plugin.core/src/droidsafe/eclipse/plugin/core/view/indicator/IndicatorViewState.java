package droidsafe.eclipse.plugin.core.view.indicator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import droidsafe.eclipse.plugin.core.filters.Filter;
import droidsafe.eclipse.plugin.core.filters.FilterException;
import droidsafe.eclipse.plugin.core.filters.FilterOp;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;

public class IndicatorViewState {

    public Map<String, Boolean> visibilityMap = new TreeMap<String, Boolean>();
    
    public Map<String, Boolean> defaultVisibilityMap = null;
    
    public Map<String, Boolean> displayMap = new TreeMap<String, Boolean>();
    
    public Map<String, Boolean> defaultDisplayMap = null;

    public List<Filter> defaultFilters;
    
    public List<Filter> filters = new ArrayList<Filter>();
    
    public String[] filterFields;

    public Set<String> sortByFields;

    public String sortByField;

    public JsonObject jsonObject;

    public String indicatorType;
    
    public boolean longLabel = false;

    public Object[] rootElements;
        
    public IndicatorViewState(File indicatorFile, JsonObject jsonObject, IndicatorViewState oldState) {
        this.jsonObject = jsonObject;
        computeDefaultVisibilityMap(jsonObject);
        computeVisibilityMapFromDefault(oldState);
        computeDefaultDisplayMap(jsonObject);
        computeDisplayMapFromDefault(oldState);
        computeDefaultFilters(indicatorFile, jsonObject);
        computeFiltersFromDefault(oldState);
        indicatorType = Utils.getFieldValueAsString(jsonObject, "indicator-type");
        if (indicatorType == null) {
            String fileName = indicatorFile.getName();
            int pos = fileName.indexOf(".");
            indicatorType = fileName.substring(0, pos).replace('_', ' ');
        }
    }

    private void computeDefaultFilters(File indicatorFile, JsonObject jsonObj) {
        defaultFilters = new ArrayList<Filter>();
        JsonArray filterArray = Utils.getFieldValueAsArray(jsonObj, "filter");
        if (filterArray != null) {
            Set<String> filterFields = Utils.getAllFilterFields(jsonObj);
            for (int i = 0; i < filterArray.size(); i++) {
                JsonElement filterElt = filterArray.get(i);
                Filter filter;
                try {
                    filter = Filter.parse(filterElt, filterFields);
                    defaultFilters.add(filter);
                } catch (FilterException e) {
                    String title = "Parse Error";
                    String msg = "Failed to parse default filter in\n\n" + indicatorFile;
                    DroidsafePluginUtilities.showError(title, msg, e);;
                    e.printStackTrace();
                }
            }
        }
    }

    private void computeFiltersFromDefault(IndicatorViewState oldState) {
        Set<String> filterNames = new HashSet<String>();
        if (oldState != null) {
            filters = oldState.filters;
            for (Filter filter: filters) {
                if (filter.name != null)
                    filterNames.add(filter.name);
            }
        }
        for (Filter defaultFilter: defaultFilters) {
            String name = defaultFilter.name;
            if (name != null && !filterNames.contains(name))
                filters.add(defaultFilter);
        }
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

    private void computeVisibilityMapFromDefault(IndicatorViewState oldState) {
        if (oldState != null) {
            visibilityMap = oldState.visibilityMap;
            for (String key: visibilityMap.keySet()) {
                if (!defaultVisibilityMap.containsKey(key)) {
                    visibilityMap.remove(key);
                }
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

    private void computeDisplayMapFromDefault(IndicatorViewState oldState) {
        if (oldState != null) {
            displayMap = oldState.displayMap;
            for (String key: displayMap.keySet()) {
                if (!defaultDisplayMap.containsKey(key)) {
                    displayMap.remove(key);
                }
            }
        }
        for (String key: defaultDisplayMap.keySet()) {
            if (!displayMap.containsKey(key)) {
                displayMap.put(key, defaultDisplayMap.get(key));
            }
        }
    }

    public void addFilter(Filter filter) {
        int size = filters.size();
        if (size == 0 || filter.op == FilterOp.SHOW || filters.get(size - 1).op != FilterOp.SHOW) {
            filters.add(filter);
        } else {
            for (int i = 0; i < size; i++) {
                if (filters.get(i).op == FilterOp.SHOW) {
                    filters.add(i, filter);
                    break;
                }
            }
        }
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
}
