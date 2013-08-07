package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Enumeration<E> {

    
    public boolean hasMoreElements();

    
    public E nextElement();
}
