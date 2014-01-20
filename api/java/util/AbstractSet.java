package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class AbstractSet<E> extends AbstractCollection<E> implements Set<E> {

    /**
     * Constructs a new instance of this AbstractSet.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:25.882 -0500", hash_original_method = "422EAA7182FF45B88C4EE6C211DE4EBB", hash_generated_method = "2FD83EFED6025F858EC91E81C4EFE5FC")
    
protected AbstractSet() {
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.657 -0400", hash_original_method = "8965F512606A1DFD0C1662786439C503", hash_generated_method = "F562AD9D6FCD2DAE6CC8714D342120D2")
    @Override
    public boolean equals(Object object) {
        return super.isEqualTo(object);
    }

    /**
     * Returns the hash code for this set. Two set which are equal must return
     * the same value. This implementation calculates the hash code by adding
     * each element's hash code.
     *
     * @return the hash code of this set.
     * @see #equals
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:25.887 -0500", hash_original_method = "CFEA0B963C36C0E6CA161741555B0EDA", hash_generated_method = "EC4E6B86A0B1F508A6076903FE132A4B")
    
@Override
    public int hashCode() {
        int result = 0;
        Iterator<?> it = iterator();
        while (it.hasNext()) {
            Object next = it.next();
            result += next == null ? 0 : next.hashCode();
        }
        return result;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.659 -0400", hash_original_method = "6793D4CBA252A26447B19640912FAD83", hash_generated_method = "3340A7706F9D036C2E7AF8AB63DB5D19")
    @Override
    public boolean removeAll(Collection<?> collection) {
        return super.removeAll(collection);
    }
    
    /**
     * Overiding to help keeping it unique
     */
    @Override
    
    public boolean add(E object) {
       if (super.getIndexOf(object) != -1) 
           return super.add(object);
       return getTaintBoolean();
    }
    
}

