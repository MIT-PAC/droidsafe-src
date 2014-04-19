package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Enumeration<E> {
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public boolean hasMoreElements();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public E nextElement();
}
