package droidsafe.eclipse.plugin.core.view.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;

public class Filter {

    FilterOp op;

    FilterPred pred;
    
    boolean enabled = true;
    
    public Filter(FilterOp op, FilterPred pred) {
        this.op = op;
        this.pred = pred;
    }
    
    public Filter(FilterOp op, String type, String field, CompareOp compOp, String value) {
        this.op = op;
        this.pred = new FilterPred(type, field, compOp, value);
    }
    
    public Filter(FilterOp op, String type, String field, CompareOp compOp, String value, 
                  boolean enabled) {
        this(op, type, field, compOp, value);
        this.enabled = enabled;
    }
    
    public Filter (Filter filter) {
        this.op = filter.op;
        this.pred = new FilterPred(filter.pred);
        this.enabled = filter.enabled;
    }
    
    public boolean isEnabled() {
        return enabled;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public String toString() {
        return op + " (" + pred + ")";
    }
    
    public enum FilterOp {
        EXCLUDE, INCLUDE; //, SHOW;

        public static final String[] strings = DroidsafePluginUtilities.enumStrings(FilterOp.class);;

        public String toString() {
            switch (this) {
                case EXCLUDE: return "exclude";
                case INCLUDE: return "include";
                default: return "show";
            }
        }
    }

    public enum CompareOp {
        EQ,
        NEQ,
        LE,
        LT,
        GE,
        GT,
        CONTAINS,
        STARTS_WITH,
        ENDS_WITH;

        public static final String[] strings = DroidsafePluginUtilities.enumStrings(CompareOp.class);

        public String toString() {
            switch (this) {
                case EQ: return "=";
                case NEQ: return "!=";
                case LE: return "<=";
                case LT: return "<";
                case GE: return ">=";
                case GT: return ">";
                case CONTAINS: return "contains";
                case STARTS_WITH: return "startsWith";
                default: return "endsWith";
            }
        }
        
        public boolean apply(boolean value1, boolean value2) {
            switch (this) {
                case EQ: return value1 == value2;
                case NEQ: return value1 != value2;
                default: return false;
            }
        }

        public boolean apply(int value1, int value2) {
            switch (this) {
                case EQ: return value1 == value2;
                case NEQ: return value1 != value2;
                case LE: return value1 <= value2;
                case LT: return value1 < value2;
                case GE: return value1 >= value2;
                case GT: return value1 > value2;
                default: return false;
            }
        }

        public boolean apply(String value1, String value2) {
            switch (this) {
                case EQ: return value1.equals(value2);
                case NEQ: return !value1.equals(value2);
                case CONTAINS: return value1.contains(value2);
                case STARTS_WITH: return value1.startsWith(value2);
                case ENDS_WITH: return value1.endsWith(value2);
                default: return false;
            }
        }
    }

    public class FilterPred {
        String type;
        String field;
        CompareOp compOp;
        String value;
        
        public FilterPred(String type, String field, CompareOp compOp, String value) {
            this.type = type;
            this.field = field;
            this.compOp = compOp;
            this.value = value;
        }
        
        public FilterPred(FilterPred pred) {
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
            return qualifier + field + " " + compOp + " " + value;
        }
    }

}
