package droidsafe.analyses.pta;

import soot.SootMethod;
import soot.jimple.toolkits.callgraph.Edge;

/**
 * Context and Context type for context sensitive query.
 * 
 * @author mgordon
 *
 */
public class PTAContext {
    /** CG edge context for this context */
    private Edge context;
    /** The type of context (1CFA or Event) */
    private ContextType type;

    /**
     * Create a new context object with given type and cg edge.
     */
    public PTAContext(ContextType type, Edge context) {
        this.context = context;
        this.type = type;
    }

    /** Return CG edge context */
    public Edge getContext() {
        return context;
    }

    /** Set CG edge context */
    public void setContext(Edge context) {
        this.context = context;
    }

    /** Get the type of this context */
    public ContextType getType() {
        return type;
    }

    /** set the context type of this context */
    public void setType(ContextType type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((context == null) ? 0 : context.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        PTAContext other = (PTAContext) obj;
        if (context == null) {
            if (other.context != null) return false;
        } else if (!context.equals(other.context)) return false;
        if (type != other.type) return false;
        return true;
    }

    public String toString() {
        return context + "[" + type + "]";
    }

    
}
