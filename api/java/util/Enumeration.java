package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Enumeration<E> {

    
    public boolean hasMoreElements();

    
    public E nextElement();
}
