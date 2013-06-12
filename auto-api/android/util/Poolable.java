package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface Poolable<T> {
    void setNextPoolable(T element);
    T getNextPoolable();
    boolean isPooled();
    void setPooled(boolean isPooled);
}

