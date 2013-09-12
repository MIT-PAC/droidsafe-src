package droidsafe.speclang;

import droidsafe.analyses.value.VAModel;
import soot.jimple.spark.pag.AllocNode;

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
    /** The underlying allocation node */
    private AllocNode allocNode;
    
    /**
     * Create a new VAValue with the given modeled object and allocation node.
     */
    public ValueAnalysisValue(VAModel mo, AllocNode an) {
        super();
        this.mObj = mo;
        this.allocNode = an;
    }

    @Override
    /**
     * Return a string value for printing in spec.
     */
    public String toStringValue() {
        return mObj.__ds__toString();
    }
    
    /**
     * Return a string rep of the modeled object.
     */
    public String toString() {
        return mObj.__ds__toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((allocNode == null) ? 0 : allocNode.hashCode());
        result = prime * result + ((mObj == null) ? 0 : mObj.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ValueAnalysisValue other = (ValueAnalysisValue) obj;
        if (allocNode == null) {
            if (other.allocNode != null) return false;
        } else if (!allocNode.equals(other.allocNode)) return false;
        if (mObj == null) {
            if (other.mObj != null) return false;
        } else if (!mObj.equals(other.mObj)) return false;
        return true;
    }

    
}
