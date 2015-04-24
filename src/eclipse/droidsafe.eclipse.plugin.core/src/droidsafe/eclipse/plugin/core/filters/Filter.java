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

package droidsafe.eclipse.plugin.core.filters;

import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import droidsafe.eclipse.plugin.core.view.indicator.Utils;


/**
 * Represents a filter used to limit the viewable contents of an indicator.
 * 
 * @author gilham
 *
 */
public class Filter {
    
    /**
     * The name of the filter.
     */
    public String name;

    /**
     * The type of the filter - 'exclude', 'include', or 'show'.
     */
    public FilterType type;

    /**
     * The boolean predicate of the filter.
     */
    public FilterPred pred;
    
    /**
     * The boolean flag to indicate whether this filter is enabled.
     */
    boolean enabled;
    
    /**
     * Constructs a Filter with the given type and predicate.
     * 
     * @param type - a filter type
     * @param pred - a filter predicate
     */
    public Filter(FilterType type, FilterPred pred) {
        this(null, type, pred);
    }
    
    /**
     * Constructs a Filter with the given name, type, and predicate.
     * 
     * @param name - a name string
     * @param type - a filter type
     * @param pred - a filter predicate
     */
    public Filter(String name, FilterType type, FilterPred pred) {
        this(name, type, pred, true);
    }

    /**
     * Constructs a Filter with the given name, type, predicate, and enabled flag.
     * 
     * @param name - a name string
     * @param type - a filter type
     * @param pred - a filter predicate
     * @param enabled - true if the filter is enabled
     */
    public Filter(String name, FilterType type, FilterPred pred, boolean enabled) {
        if (name != null && !name.isEmpty())
            this.name = name;
        this.type = type;
        this.pred = pred;
        this.enabled = enabled;
    }

    /**
     * Constructs a Filter by cloning the given filter.
     * 
     * @param filter - a filter
     */
    public Filter (Filter filter) {
        this.name = filter.name;
        this.type = filter.type;
        this.pred = new FilterPred(filter.pred);
        this.enabled = filter.enabled;
    }
    
    /**
     * Returns true if this Filter is enabled.
     */
    public boolean isEnabled() {
        return enabled;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    /**
     * Returns the string representation of this Filter.
     */
    @Override
    public String toString() {
        return "[" + ((name == null) ? "" : name) + "] " + type + " " + pred;
    }

    /**
     * Given a JsonElement that represents a filter and a set of filter field names, parses this JsonElement
     * into a Filter and returns the result.
     * 
     * @param filterElt - a JsonElement that represents a filter
     * @param filterFields - a set of filter fields used to check the validity of the fields in the filterElt
     * @return the resulting Filter
     * @throws FilterParseException
     */
    public static Filter parse(JsonElement filterElt, Set<String> filterFields) throws FilterParseException {
        String name = Utils.getFieldValueAsString(filterElt, "name");
        String opStr = Utils.getFieldValueAsString(filterElt, "type");
        if (opStr == null)
            throw new FilterParseException("Missing \"type\" property in\n " + filterElt);
        FilterType op = FilterType.parse(opStr);
        FilterPred pred = FilterPred.parse(filterElt, filterFields);
        JsonElement enabledElt = Utils.getFieldValue(filterElt, "enabled");
        if (enabledElt != null && enabledElt.isJsonPrimitive()) {
            boolean enabled = enabledElt.getAsBoolean();
            return new Filter(name, op, pred, enabled);
        } else {
            return new Filter(name, op, pred);
        }            
    }
    
}
