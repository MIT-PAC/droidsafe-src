package droidsafe.analyses.value;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author dpetters
 */
public class ValueAnalysisModelingSet<E> extends ForwardingSet<E> {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Constructors
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Generic constructor.
     */
    public ValueAnalysisModelingSet(){
        this(new HashSet<E>());
    }

    /**
     * Constructor that allows an existing Set to be used as the private field of this composition class.
     */
    public ValueAnalysisModelingSet(Set<E> s) {
        super(s);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Methods
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /** 
     * Wrapper around the add method that checks whether the element to be added is already in the set and modifies
     * ValueAnalysis's "changed" global accordingly. Used to run ValueAnalysis to fixed-point. If something
     * new is added to a set, then the analysis has not reached fixed point yet.
     */
    @Override
    public boolean add(E e) {
        if(!this.getSet().contains(e)){
            ValueAnalysis.changed = true;
        }
        return super.add(e);
    }

    /**
     * Forwarding method
     */
    public boolean addAll(Collection<? extends E> c)
    {
        for(E e : c) {
            if(!this.getSet().contains(e)){
                ValueAnalysis.changed = true;
            }
        }
        return super.addAll(c);
    }


}

