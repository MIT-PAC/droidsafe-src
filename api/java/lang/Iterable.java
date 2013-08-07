package java.lang;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Iterator;

public interface Iterable<T> {

    
    Iterator<T> iterator();
}
