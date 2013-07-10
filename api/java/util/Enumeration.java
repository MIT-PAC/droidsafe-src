package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface Enumeration<E> {

    
    public boolean hasMoreElements();

    
    public E nextElement();
}
