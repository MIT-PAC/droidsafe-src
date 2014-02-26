package droidsafe.android.system;

import java.util.HashMap;

import droidsafe.analyses.infoflow.InfoValue;


/**
 * High Level information kind identified by a string type (name).
 * 
 * @author mgordon
 *
 */
public  class InfoKind implements InfoValue {
    /** name of this information kind */
    private String name;
    
    private boolean sensitive;
    
    /** map of strings to the info kind that represents them */
    private static HashMap<InfoKind,InfoKind> infoKinds = new HashMap<InfoKind,InfoKind>();

    /** 
     * Given a string return (or create and return) the InfoKind object that
     * represents it.
     */
    public static InfoKind getInfoKind(String str, boolean sensitive) {
        InfoKind probe = new InfoKind(str, sensitive);
        
        if (!infoKinds.containsKey(probe)) {
            infoKinds.put(probe, probe);
        }
        
        return infoKinds.get(probe);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (sensitive ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        InfoKind other = (InfoKind) obj;
        if (name == null) {
            if (other.name != null) return false;
        } else if (!name.equals(other.name)) return false;
        if (sensitive != other.sensitive) return false;
        return true;
    }

    public boolean isSensitive() {
        return sensitive;
    }
    
    /**
     * Create a new information kind named str.
     */
    private InfoKind(String str, boolean sensitive) {
        this.sensitive = sensitive;
        this.name = str;
    }

    /**
     * Return the string name of this information kind.
     */
    public String toString() {
        return name;
    }

 
}
