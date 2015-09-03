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

package droidsafe.speclang;

import droidsafe.analyses.value.VAModel;

/**
 * This class represents the result of the value analysis in the specificiation 
 * language IR.  There is one of these for each possible alloc node in the 
 * PTA set for arguments.  These can be combined in a ConcreteArgumentListValue. 
 * 
 * @author mgordon
 *
 */
public class ValueAnalysisValue extends ConcreteArgumentValue {
    /** The modeled object as calculated by the Value Analysis */
    private VAModel mObj;
  
    /**
     * Create a new VAValue with the given modeled object and allocation node.
     */
    public ValueAnalysisValue(VAModel mo) {
        super();
        this.mObj = mo;
    }

    @Override
    /**
     * Return a string value for printing in spec.
     */
    public String toStringValue() {
        return mObj.toString();
    }
    
    @Override
    /**
     * Return a well-formatted detailed printout of this value
     */
    public String toStringPretty() {
        return mObj.toStringPretty();
    }
    
    /**
     * Return a string rep of the modeled object.
     */
    public String toString() {
        return mObj.toStringSimple();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mObj == null) ? 0 : mObj.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ValueAnalysisValue other = (ValueAnalysisValue) obj;
        if (mObj == null) {
            if (other.mObj != null) return false;
        } else if (!mObj.equals(other.mObj)) return false;
        return true;
    }

    
}
