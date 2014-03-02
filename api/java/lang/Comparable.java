package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Comparable<T> {
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_OTHERS)
    int compareTo(T another);
}
