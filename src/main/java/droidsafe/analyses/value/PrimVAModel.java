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
public abstract class PrimVAModel<T> extends VAModel {

    public Set<T> values = new HashSet<T>();
    public final String type;

    public PrimVAModel(String type) {
        this.type = type;
    }

    public void addValue(T value) {
        this.values.add(value);
    }

    public Set<T> getValues() {
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
            Set<T> vals = this.getValues();
//            if (vals.size() > 1)
//                buf.append("{");
            for(Object val : vals) {
                if (first) {
                    first = false;
                    if (vals.size() > 1)
                        buf.append(indent);
                } else {
                    buf.append(",");
                    buf.append(indent);
                }
                if (val instanceof String) {
                    buf.append("\"" + val + "\"");
                } else {
                    buf.append(val);
                }
            }
//            if (vals.size() > 1)
//                buf.append("}");
        }
        return buf.toString();
    }
}
