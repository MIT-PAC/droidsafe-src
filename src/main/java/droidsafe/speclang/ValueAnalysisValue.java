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
