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
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import droidsafe.eclipse.plugin.core.filters.Filter;
import droidsafe.eclipse.plugin.core.filters.FilterParseException;
import droidsafe.eclipse.plugin.core.filters.FilterType;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.speclang.model.MethodModel;
import droidsafe.speclang.model.SecuritySpecModel;

/**
 * Represents the state of an indicator outline view.
 * 
 * @author gilham
 *
 */
public class IndicatorViewState {

    /** The name of the context property. */
    private static String CONTEXT_PROP = "_context_";
    
    /** A map from element types to visibilities. */
    public Map<String, Boolean> visibilityMap;
    
    /** A map from element types to default visibilities. */
    public Map<String, Boolean> defaultVisibilityMap;
    
    /** A map from fields to whether the fields should be displayed in the element labels. */
    public Map<String, Boolean> labelDisplayMap;
    
    /** A map from fields to whether the fields should be displayed in the element labels by default. */
    public Map<String, Boolean> defaultLabelDisplayMap;

    /** The list of default filters for the indicator display. */
    public List<Filter> defaultFilters;
    
    /** The list of filters for the indicator display. */
    public List<Filter> filters;
    
    /** The fields that can be used for indicator display filtering. */
    public String[] filterFields;

    /** The fields that can be used for sorting the indicator display. */
    public Set<String> sortByFields;

    /** The field that is currently used for sorting the indicator display. */
    public String sortByField;

    /** The top-level Json object for this indicator. */
    public JsonObject jsonObject;

    /** The indicator type for this indicator. */
    public String indicatorType;
    
    /** A boolean flag indicating whether long labels are uses in the indicator display. */
    public boolean longLabel = false;

    /** The root elements of the indicator outline. */
    public Object[] rootElements;

    /** A map from Json objects in the indicator to their corresponding method models. */
    public Map<JsonObject, MethodModel> methodMap = new HashMap<JsonObject, MethodModel>();;

    /** The security spec model for the project that the indicator belongs to. */
    private SecuritySpecModel spec;
        
    /**
     * Constructs an IndicatorViewState.
     * 
     * @param indicatorFile - the indicator Json file
     * @param jsonObject - the top-level Json object parsed from the indicator Json file
     * @param spec - the security spec model for the corresponding project
     * @param oldState - the previously saved state for the indicator
     */
    public IndicatorViewState(File indicatorFile, JsonObject jsonObject, SecuritySpecModel spec, IndicatorViewState oldState) {
        this.jsonObject = jsonObject;
        this.spec = spec;
        computeMethodMap(jsonObject);
        computeDefaultVisibilityMap(jsonObject);
        computeVisibilityMapFromDefault(oldState);
        computeDefaultLabelDisplayMap(jsonObject);
        computeLabelDisplayMapFromDefault(oldState);
        computeDefaultFilters(indicatorFile, jsonObject);
        computeFiltersFromDefault(oldState);
        indicatorType = Utils.getFieldValueAsString(jsonObject, "indicator-type");
        if (indicatorType == null) {
            String fileName = indicatorFile.getName();
            int pos = fileName.indexOf(".");
            indicatorType = fileName.substring(0, pos).replace('_', ' ');
        }
    }

    /**
     * Computes the map from Json objects in the indicator to their corresponding 
     * method models.
     * 
     * @param jsonObj - the top-level Json object for the indicator
     */
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
                    Set<MethodModel> methods = Utils.getMethodModels(spec, childObj);
                    if (!methods.isEmpty()) {
                        if (methods.size() > 1) {
                            changed = true;
                            int j = 0;
                            for (MethodModel method: methods) {
                            	if (j > 0) {
                            		JsonObject copy = copyWithContext(childObj, j + 1);
                            		newChildrenArray.add(copy);
                            		methodMap.put(copy, method);
                            	}
                            	j++;
                            }
                            childObj.addProperty(CONTEXT_PROP, Integer.valueOf(1));
                        }
                        methodMap.put(childObj, methods.iterator().next());
                    }
                } 
            }
            if (changed) {
                jsonObj.remove(Utils.CHILDREN_PROP);
                jsonObj.add(Utils.CHILDREN_PROP, newChildrenArray);
            }
        }
    }
    
    /**
     * Copies all the properties of the given Json object except the children property
     * to a new Json object. Adds a context property with the given context index.
     * returns the new Json object.
     *  
     * @param jsonObj - a Json object
     * @param context - a context index
     * @return the new copy with context
     */
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

    /**
     * Computes the default filters from the 'filter' property of the top-level
     * Json object for the indicator.
     * 
     * @param indicatorFile - an indicator Json file
     * @param jsonObj - the top-level Json object parsed from the indicator file
     */
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
                } catch (FilterParseException e) {
                    String title = "Parse Error";
                    String msg = "Failed to parse the default filter in\n\n" + indicatorFile;
                    DroidsafePluginUtilities.showError(title, msg, e);;
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Computes the filters by combining the default filters and the user-defined 
     * filters stored in the previously saved state. 
     * 
     * @param oldState - previously saved state for this indicator
     */
    private void computeFiltersFromDefault(IndicatorViewState oldState) {
        filters = new ArrayList<Filter>();
        Set<String> defaultFilterNames = new HashSet<String>();
        for (Filter defaultFilter: defaultFilters) {
            filters.add(defaultFilter);
            if (defaultFilter.name != null)
            	defaultFilterNames.add(defaultFilter.name);
        }
        if (oldState != null) {
            for (Filter oldFilter: oldState.filters) {
                if (oldFilter.name == null || !defaultFilterNames.contains(oldFilter.name))
                    filters.add(oldFilter);
            }
        }
    }

    /**
     * Computes the default visibility map from the 'visibility' property of the top-level
     * Json object for the indicator.
     * 
     * @param jsonObj - the top-level Json object parsed from the indicator file
     */
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

    /**
     * Computes the visibility map by copying the default visibility map and adding the user-defined 
     * visibility map entries stored in the previously saved state. 
     * 
     * @param oldState - previously saved state for this indicator
     */
    private void computeVisibilityMapFromDefault(IndicatorViewState oldState) {
        visibilityMap = new HashMap<String, Boolean>();
        for (String key: defaultVisibilityMap.keySet()) {
            visibilityMap.put(key, defaultVisibilityMap.get(key));
            if (oldState != null) {
                Boolean oldDefaultVisibility = oldState.defaultVisibilityMap.get(key);
                Boolean oldVisibility = oldState.visibilityMap.get(key);
                if (oldDefaultVisibility != null && oldVisibility != null && !oldVisibility.equals(oldDefaultVisibility)) {
                    visibilityMap.put(key, oldVisibility);
                }
            }
        }
    }

    /**
     * Computes the default label display map from the 'display' property of the top-level
     * Json object for the indicator.
     * 
     * @param jsonObj - the top-level Json object parsed from the indicator file
     */
    private void computeDefaultLabelDisplayMap(JsonObject jsonObj) {
        defaultLabelDisplayMap = new TreeMap<String, Boolean>();
        JsonElement display = jsonObj.get("display");
        if (display != null && display.isJsonObject()) {
            for (Map.Entry<String, JsonElement> entry: display.getAsJsonObject().entrySet()) {
                String key = entry.getKey();
                Boolean value = Boolean.valueOf(entry.getValue().getAsBoolean());
                defaultLabelDisplayMap.put(key, value);
            }
        }
    }

    /**
     * Computes the label display map by copying the default label diaplay map and adding
     * the user-defined label display map entries stored in the previously saved state.
     * 
     * @param oldState - previously saved state for this indicator
     */
    private void computeLabelDisplayMapFromDefault(IndicatorViewState oldState) {
        labelDisplayMap = new HashMap<String, Boolean>();
        for (String key: defaultLabelDisplayMap.keySet()) {
            labelDisplayMap.put(key, defaultLabelDisplayMap.get(key));
            if (oldState != null) {
                Boolean oldDefaultDisplay = oldState.defaultLabelDisplayMap.get(key);
                Boolean oldDisplay = oldState.labelDisplayMap.get(key);
                if (oldDefaultDisplay != null && oldDisplay != null && !oldDisplay.equals(oldDefaultDisplay)) {
                    labelDisplayMap.put(key, oldDisplay);
                }
            }
        }
    }

    /**
     * Adds the given filter to the list of filters. Maintains the invariant that all 'show'
     * filters are listed after other types of filters.
     * 
     * @param filter - a filter
     */
    public void addFilter(Filter filter) {
        int size = filters.size();
        if (size == 0 || filter.type == FilterType.SHOW || filters.get(size - 1).type != FilterType.SHOW) {
            filters.add(filter);
        } else {
            for (int i = 0; i < size; i++) {
                if (filters.get(i).type == FilterType.SHOW) {
                    filters.add(i, filter);
                    break;
                }
            }
        }
    }

    /**
     * Returns the fields that can be used for filtering the indicator display.
     */
    public String[] getFilterFields() {
        if (filterFields == null) {
            filterFields = Utils.getAllFilterFields(jsonObject).toArray(new String[0]);
        }
        return filterFields;
    }
    
    /**
     * Returns the fields that can be used for sorting the indicator display.
     */
    public Set<String> getSortByFields() {
        if (sortByFields == null && jsonObject != null) {
            sortByFields = Utils.getSortByFields(jsonObject);
        }
        return sortByFields;
    }
    
    /**
     * Returns the field currently used for sorting the indicator display.
     */
    public String getSortByField() {
        if (sortByField == null) {
            Set<String> fields = getSortByFields();
            if (fields.contains("class"))
                sortByField = "class";
            else
                sortByField = "label";
        }
        return sortByField;
    }

    /**
     * Set the sort-by field to the given field.
     * 
     * @param field - a field.
     */
    public void setSortByField(String field) {
        sortByField = field;
    }
}
