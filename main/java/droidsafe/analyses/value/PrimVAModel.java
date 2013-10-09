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
    public String toString() {
        String str = "<va-modeled-" + this.type + ":"; 
        str += this.fieldsString();
        return str + ">";
    }

    public String fieldsString() {
        String fieldsString = "";
        if(this.invalidated) {
            fieldsString += INVALIDATED;
        } else {
            fieldsString += "[";
            List<String> fieldStrings = new ArrayList<String>();
            for(Object val : this.getValues()) {
                fieldStrings.add(val.toString());
            }
            fieldsString += StringUtils.join(fieldStrings.toArray(), ", ");
            fieldsString += "]";
        }
        return fieldsString;
    }
}
