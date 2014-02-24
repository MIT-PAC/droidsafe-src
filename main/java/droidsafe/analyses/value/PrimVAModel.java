package droidsafe.analyses.value;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

/**
 * Base class for value analysis object models.
 *
 * @author dpetters
 */
public abstract class PrimVAModel extends VAModel {

    public Set<Object> values = new HashSet<Object>();
    public final String type;

    public PrimVAModel(String type) {
        this.type = type;
    }

    public void addValue(Object value) {
        this.values.add(value);
    }

    public Set<Object> getValues() {
        return this.values;
    }

    @Override
    public String toStringSimple() {
        return this.toStringDetailed().replace("\"", "");
    }

    @Override
    public String toStringDetailed() {
        String str = "{\"" + this.type + "\":"; 
        str += this.fieldsString();
        return str + "}";
    }

    @Override
    public String toStringPretty(int level) {
        return this.fieldsStringPretty(level);
    }

    public String fieldsString() {
        String fieldsString = "";
        if(this.invalidated) {
            fieldsString += "\"" + INVALIDATED + "\"";
        } else {
            fieldsString += "[";
            Set<String> fieldStrings = new HashSet<String>();
            for(Object val : this.getValues()) {
                fieldStrings.add("\"" + val.toString().replace("\\", "\\\\").replace("\"", "\\\"") + "\"");
            }
            fieldsString += StringUtils.join(fieldStrings.toArray(), ", ");
            fieldsString += "]";
        }
        return fieldsString;
    }

    public String fieldsStringPretty(int level) {
        String indent = "\n" + VAUtils.indent(level);
        StringBuffer buf = new StringBuffer();
        if(this.invalidated) {
            buf.append(INVALIDATED);
        } else {
            boolean first = true;
            Set<Object> vals = this.getValues();
            if (vals.size() > 1)
                buf.append("{");
            for(Object val : vals) {
                if (first) {
                    first = false;
                    if (vals.size() > 1)
                        buf.append(indent);
                } else {
                    buf.append(",");
                    buf.append(indent);
                }
                if (val instanceof String && !val.equals(ValueAnalysis.UNKNOWN_VALUES_STRING)) {
                    buf.append("\"" + val + "\"");
                } else {
                    buf.append(val);
                }
            }
            if (vals.size() > 1)
                buf.append("}");
        }
        return buf.toString();
    }
}
