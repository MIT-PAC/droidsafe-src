package droidsafe.eclipse.plugin.core.filters;

import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.indicator.Utils;

public class Filter {

    public FilterOp op;

    public FilterPred pred;
    
    boolean enabled = true;
    
    public Filter(FilterOp op, FilterPred filterPred) {
        this.op = op;
        this.pred = filterPred;
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
        return op + " " + pred;
    }
    
}
