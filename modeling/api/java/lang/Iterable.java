package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Iterator;

public interface Iterable<T> {
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_OTHERS)
    Iterator<T> iterator();
}
