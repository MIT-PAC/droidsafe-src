package droidsafe.eclipse.plugin.core.filters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import droidsafe.eclipse.plugin.core.view.indicator.Utils;

public class FilterPredClause {
    public String type;
    public String field;
    public CompareOp compOp;
    public String value;
    
    public FilterPredClause(String type, String field, CompareOp compOp, String value) {
        this.type = type;
        this.field = field;
        this.compOp = compOp;
        this.value = value;
    }
    
    public FilterPredClause(FilterPredClause pred) {
        this(pred.type, pred.field, pred.compOp, pred.value);
    }
    
    public boolean apply(JsonElement jsonElt) {
        if (jsonElt.isJsonObject()) {
            JsonObject jsonObj = jsonElt.getAsJsonObject();
            if (type != null && !type.isEmpty()) {
                String otype = Utils.getFieldValueAsString(jsonObj, "type");
                if (!otype.equals(type))
                    return false;
            }
            if (field.equals("signature")) {
                String sig = Utils.getFieldValueAsString(jsonObj, field);
                return compOp.apply(sig, value);
            } else if (Utils.SIGNATURE_FIELDS.contains(field)){
                String str1 = Utils.getSignatureFieldValueAsString(jsonObj, field);
                return compOp.apply(str1, value);
            } else {
                JsonElement ovalue = jsonObj.get(field);
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
        return false;
    }

    public String toString() {
        String qualifier = (type == null || type.isEmpty()) ? "" : type + ".";
        return "(" + qualifier + field + " " + compOp + " " + value + ")";
    }
}
