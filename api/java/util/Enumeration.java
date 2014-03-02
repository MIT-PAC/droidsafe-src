package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Enumeration<E> {
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public boolean hasMoreElements();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public E nextElement();
}
