package droidsafe.eclipse.plugin.core.filters;

import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import droidsafe.eclipse.plugin.core.view.indicator.Utils;

public class FilterPredClause {
    public String field;
    public CompareOp compOp;
    public String value;
    
    public FilterPredClause(String field, CompareOp compOp, String value) {
        this.field = field;
        this.compOp = compOp;
        this.value = value;
    }
    
    public FilterPredClause(FilterPredClause pred) {
        this(pred.field, pred.compOp, pred.value);
    }
    
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

    public String toString() {
        return "(" + field + " " + compOp + " " + value + ")";
    }

    public static FilterPredClause parse(JsonElement predElt, Set<String> filterFields) throws FilterException {
        String field = Utils.getFieldValueAsString(predElt, "field");
        if (field == null)
            throw new FilterException("Missing \"field\" property in\n" + predElt);
        if (!filterFields.contains(field))
            throw new FilterException("Unknown filter field \"" + field + "\" in\n" + predElt);
        String opStr = Utils.getFieldValueAsString(predElt, "comp-op");
        if (opStr == null)
            throw new FilterException("Missing \"comp-op\" property in\n" + predElt);
        CompareOp op = CompareOp.parse(opStr);
        String value = Utils.getFieldValueAsString(predElt, "value");
        if (value == null)
            throw new FilterException("Missing \"value\" property in\n" + predElt);
        return new FilterPredClause(field, op, value);
    }
}
