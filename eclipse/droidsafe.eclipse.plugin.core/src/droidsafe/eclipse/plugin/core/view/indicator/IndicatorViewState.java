package droidsafe.eclipse.plugin.core.view.indicator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
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
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.speclang.model.MethodModel;
import droidsafe.speclang.model.SecuritySpecModel;
import droidsafe.utils.SourceLocationTag;

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

    public Map<JsonObject, MethodModel> methodMap = new HashMap<JsonObject, MethodModel>();

    private SecuritySpecModel spec;
        
    private static String CONTEXT_PROP = "_context_";
    
    public IndicatorViewState(File indicatorFile, JsonObject jsonObject, SecuritySpecModel spec, IndicatorViewState oldState) {
        this.spec = spec;
        linkMethods(jsonObject, spec, oldState);
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

    private void linkMethods(JsonObject jsonObject,
            SecuritySpecModel spec, IndicatorViewState oldState) {
        if (oldState != null) {
            this.jsonObject = oldState.jsonObject;
            this.methodMap = oldState.methodMap;
        } else {
            this.jsonObject = jsonObject;
            computeMethodMap(jsonObject);
        }
    }

    private void computeMethodMap(JsonObject jsonObj) {
        JsonArray childrenArray = Utils.getChildrenArray(jsonObj);
        if (childrenArray != null) {
            JsonArray newChildrenArray = new JsonArray();
            boolean changed = false;
            for (int i = 0; i < childrenArray.size(); i++) {
                JsonElement child = childrenArray.get(i);
                newChildrenArray.add(child);
                if (child.isJsonObject()) {
                    JsonObject childObj = child.getAsJsonObject();
                    computeMethodMap(childObj);
                    newChildrenArray.add(childObj);
                    List<MethodModel> methods = getMethodModels(childObj);
                    if (!methods.isEmpty()) {
                        if (methods.size() > 1) {
                            changed = true;
                            for (int j = 1; j < methods.size(); j++) {
                                MethodModel method = methods.get(j);
                                JsonObject copy = copyWithContext(childObj, j + 1);
                                newChildrenArray.add(copy);
                                methodMap.put(copy, method);
                            }
                            childObj.addProperty(CONTEXT_PROP, Integer.valueOf(1));
                        }
                        methodMap.put(childObj, methods.get(0));
                    }
                } 
            }
            if (changed) {
                jsonObj.remove(Utils.CHILDREN_PROP);
                jsonObj.add(Utils.CHILDREN_PROP, newChildrenArray);
            }
        }
    }
    
    private JsonObject copyWithContext(JsonObject jsonObj, int context) {
        JsonObject copy = new JsonObject();
        for (Map.Entry<String, JsonElement> entry : jsonObj.entrySet()) {
            String field = entry.getKey();
            if (!field.equals(Utils.CHILDREN_PROP)) {
                copy.add(field, entry.getValue());
            }
        }
        copy.addProperty(CONTEXT_PROP, Integer.valueOf(context));
        return copy;
    }

    private List<MethodModel> getMethodModels(JsonObject jsonObj) {
        String link = Utils.getFieldValueAsString(jsonObj, "link");
        String sig = Utils.getSignature(jsonObj);
        String srcClass = Utils.getSourceClass(jsonObj);
        int srcLine = Utils.getSourceLine(jsonObj);
       return getMethodModels(spec, sig, srcClass, srcLine, link);
    }

    private List<MethodModel> getMethodModels(SecuritySpecModel spec, String sig, String srcClass,
            int srcLine, String link) {
        List<MethodModel> result = new ArrayList<MethodModel>();
        if (sig != null && srcClass != null && srcLine >= 0) {
            if (link != null) {
                if (link.equals("as_entry_point")) {
                    for (MethodModel entryPoint: spec.getInputEventBlocks().keySet()) {
                        if (sig.equals(entryPoint.getSignature()))
                            result.add(entryPoint);
                    }
                } else if (link.equals("as_call")) {
                    for (MethodModel call: spec.getOutputEventBlocks().keySet()) {
                        if (sig.equals(call.getSignature())) {
                            SourceLocationTag line = DroidsafePluginUtilities.getLine(call);
                            if (line != null && line.getClz().equals(srcClass) && line.getLine() == srcLine) {
                                result.add(call);
                            }
                        }
                    }
                }
            }
        }
        return result;
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
