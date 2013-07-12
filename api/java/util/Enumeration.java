package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Enumeration<E> {

    
    public boolean hasMoreElements();

    
    public E nextElement();
}
