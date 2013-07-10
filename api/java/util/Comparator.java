package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface Comparator<T> {
    
    public int compare(T lhs, T rhs);

    
    public boolean equals(Object object);
}
