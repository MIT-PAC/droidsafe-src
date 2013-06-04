package droidsafe.analyses.attr;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author dpetters
 */
public class AttrModelingSet<E> extends ForwardingSet<E> {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Constructors
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Generic constructor.
     */
    public AttrModelingSet(){
        this(new HashSet<E>());
    }

    /**
     * Constructor that allows an existing Set to be used as the private field of this composition class.
     */
    public AttrModelingSet(Set<E> s) {
        super(s);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Methods
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /** 
     * Wrapper around the add method that checks whether the element to be added is already in the set and modifies
     * AttributeModeling's "changed" global accordingly. Used to run AttributeModeling to fixed-point. If something
     * new is added to a set, then the analysis has not reached fixed point yet.
     */
    @Override
    public boolean add(E e) {
        if(!this.getSet().contains(e)){
            AttributeModeling.changed = true;
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
                AttributeModeling.changed = true;
            }
        }
        return super.addAll(c);
    }


}

