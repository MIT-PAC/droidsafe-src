package droidsafe.android.system;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.SootMethod;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import droidsafe.analyses.infoflow.InfoUnit;
import droidsafe.analyses.infoflow.InfoValue;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.app.Project;


/**
 * High Level information kind identified by a string type (name).
 * 
 * @author mgordon
 *
 */
public  class InfoKind implements InfoValue {
    /** Logger field */
    private static final Logger logger = LoggerFactory.getLogger(InfoValue.class);
    /** name of this information kind */
    private String name;
    
    private boolean sensitive;
    
    /** map of strings to the info kind that represents them */
    private static HashMap<InfoKind,InfoKind> infoKinds = new HashMap<InfoKind,InfoKind>();

    /**
     * Return true if any of the infokinds for this infovalue call statement are 
     * defined as sensitive.
     */
    public static boolean isSensitiveInfoKind(Stmt stmt) {
        for (InfoKind infoK : getInfoKinds(stmt)) {
            if (infoK.isSensitive())
                return true;
        }
        
        return false;
    }
    
    /**
     * Given a value from the invoke statement (either receiver or an argument), query the 
     * information flow for the units the flow to it, and then use the PTA to find all the targets
     * of the source statements to see if any of them have higher level InfoKind associated with them.
     * Return the set of all InfoKinds for the targets of all sources.
     */
    public static Set<InfoKind> getInfoKinds(Stmt stmt) {
        Set<InfoKind> srcKinds = new HashSet<InfoKind>();
        
        if (!stmt.containsInvokeExpr())
            return srcKinds;

        //TODO: CONTEXT HERE FROM THE INFOVALUE
        Collection<SootMethod> targets = 
                PTABridge.v().getTargetsInsNoContext(stmt);

        for (SootMethod target : targets) { 
            for (InfoKind kind : API.v().getSourceInfoKinds(target)) {
                srcKinds.add(kind);
            }
        }
        
        return srcKinds;
    }
    
    /**
     * Given a value from the invoke statement (either receiver or an argument), query the 
     * information flow for the units the flow to it, and then use the PTA to find all the targets
     * of the source statements to see if any of them have higher level InfoKind associated with them.
     * Return the set of all InfoKinds for the targets of all sources.
     */
    public static Set<InfoKind> getInfoKinds(InfoValue iv) {

        Set<InfoKind> srcKinds = new HashSet<InfoKind>();

        if (iv instanceof InfoUnit && ((InfoUnit)iv).getUnit() instanceof Stmt) {

            Stmt stmt = (Stmt)((InfoUnit)iv).getUnit();

           srcKinds = getInfoKinds(stmt);

        } else if (iv instanceof InfoKind) {
            srcKinds.add((InfoKind)iv);
        } else {
            logger.warn("Strange info value: {} {}", iv, iv.getClass());
        }


        return srcKinds;
    }
    
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
