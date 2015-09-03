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
import com.google.gson.JsonPrimitive;

import droidsafe.eclipse.plugin.core.view.indicator.Utils;

/**
 * Represents a simple boolean clause that is used to filter the viewable contents of an indicator.
 * Currently only clauses of form
 * 
 *   <field> <comparison op> <value>
 * 
 * are supported.
 * 
 * @author gilham
 *
 */
public class FilterPredClause {
    /**
     * The field of a JsonElement to compare against the value
     */
    public String field;
    
    /**
     * The comparison operator for comparing the field against the value
     */
    public CompareOp compOp;
    
    /**
     * The value to compare the field against.
     */
    public String value;
    
    /**
     * Constructs a FilterPredClause with the given field, comparison operator, and the value.
     * 
     * @param field - a Json field
     * @param compOp - a comparison operator
     * @param value - a value to compare the field against
     */
    public FilterPredClause(String field, CompareOp compOp, String value) {
        this.field = field;
        this.compOp = compOp;
        this.value = value;
    }
    
    /**
     * Constructs a FilterPredClause using the field, comparison, and the value from the
     * given FilterPredClause.
     * 
     * @param pred - a filter predicate clause
     */
    public FilterPredClause(FilterPredClause pred) {
        this(pred.field, pred.compOp, pred.value);
    }
    
    /**
     * Apply this FilterPredClause to the given JsonElement and return the
     * resulting boolean value.
     * 
     * @param jsonElt - the JsonElement to apply the FilterPredClause
     * @return the resulting boolean value
     */
    public boolean apply(JsonElement jsonElt) {
        if (jsonElt.isJsonObject()) {
            JsonObject jsonObj = jsonElt.getAsJsonObject();
            if (field.equals("signature")) {
                String sig = Utils.getFieldValueAsString(jsonObj, field);
                if (sig != null)
                    return compOp.apply(sig, value);
            } else if (Utils.SIGNATURE_FIELDS.contains(field)){
                String str1 = Utils.getSignatureFieldValueAsString(jsonObj, field);
                if (str1 != null)
                    return compOp.apply(str1, value);
            } else {
                JsonElement ovalue = jsonObj.get(field);
                if (ovalue != null) {
                    if (ovalue.isJsonPrimitive()) {
                        JsonPrimitive pvalue = (JsonPrimitive) ovalue;
                        if (pvalue.isBoolean()) {
                            boolean bool1 = pvalue.getAsBoolean();
                            boolean bool2 = Boolean.parseBoolean(value);
                            return compOp.apply(bool1, bool2);
                        }
                        if (pvalue.isNumber()) {
                            // TODO: handle all numeric types
                            int int1 = pvalue.getAsInt();
                            int int2 = Integer.parseInt(value);
                            return compOp.apply(int1, int2);
                        }
                        if (pvalue.isString()) {
                            String str1 = pvalue.getAsString();
                            return compOp.apply(str1, value);
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Returns the string representation of this FilterPredClause.
     */
    @Override
    public String toString() {
        return "(" + field + " " + compOp + " " + value + ")";
    }

    /**
     * Given a JsonElement that represents a filter predicate clause and a set of filter field names, 
     * parses this JsonElement into a FilterPredClause and returns the result.
     * 
     * @param predElt - a JsonElement that represents a filter predicate clause
     * @param filterFields - a set of filter fields used to check the validity of the field in the predElt
     * @return the resulting FilterPredClause
     * @throws FilterParseException
     */
    public static FilterPredClause parse(JsonElement predElt, Set<String> filterFields) throws FilterParseException {
        String field = Utils.getFieldValueAsString(predElt, "field");
        if (field == null)
            throw new FilterParseException("Missing \"field\" property in\n" + predElt);
        if (!filterFields.contains(field))
            throw new FilterParseException("Unknown filter field \"" + field + "\" in\n" + predElt);
        String opStr = Utils.getFieldValueAsString(predElt, "comp-op");
        if (opStr == null)
            throw new FilterParseException("Missing \"comp-op\" property in\n" + predElt);
        CompareOp op = CompareOp.parse(opStr);
        String value = Utils.getFieldValueAsString(predElt, "value");
        if (value == null)
            throw new FilterParseException("Missing \"value\" property in\n" + predElt);
        return new FilterPredClause(field, op, value);
    }
}
