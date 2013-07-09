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
     * Wrapper around the add method that checks whether the element to be added is already in the set. If not, then the
     * value analysis has not yet reached a fixed point and should be run again.
     */
    @Override
    public boolean add(E e) {
        if(!this.getSet().contains(e)){
            ValueAnalysis.runAgain();
        }
        return super.add(e);
    }

    /**
     * Wrapper around the addAll method that checks whether the elemetns to be added are already in the set. If not,
     * then the analysis has not yet reached a fixed point and should be run again.
     */
    public boolean addAll(Collection<? extends E> c)
    {
        for(E e : c) {
            if(!this.getSet().contains(e)){
                ValueAnalysis.runAgain();
            }
        }
        return super.addAll(c);
    }


}

