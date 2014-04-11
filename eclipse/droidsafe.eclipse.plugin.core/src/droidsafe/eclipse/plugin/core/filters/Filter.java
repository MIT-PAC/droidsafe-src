package droidsafe.eclipse.plugin.core.filters;

import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import droidsafe.eclipse.plugin.core.view.indicator.Utils;


public class Filter {
    
    public String name;

    public FilterOp op;

    public FilterPred pred;
    
    boolean enabled;
    
    public Filter(FilterOp op, FilterPred pred) {
        this(null, op, pred);
    }
    
    public Filter(String name, FilterOp op, FilterPred pred) {
        this(name, op, pred, true);
    }

    public Filter(String name, FilterOp op, FilterPred pred, boolean enabled) {
        if (name != null && !name.isEmpty())
            this.name = name;
        this.op = op;
        this.pred = pred;
        this.enabled = enabled;
    }

    public Filter (Filter filter) {
        this.name = filter.name;
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
        return "[" + ((name == null) ? "" : name) + "] " + op + " " + pred;
    }

    public static Filter parse(JsonElement filterElt, Set<String> filterFields) throws FilterException {
        String name = Utils.getFieldValueAsString(filterElt, "name");
        String opStr = Utils.getFieldValueAsString(filterElt, "type");
        if (opStr == null)
            throw new FilterException("Missing \"type\" property in\n " + filterElt);
        FilterOp op = FilterOp.parse(opStr);
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
