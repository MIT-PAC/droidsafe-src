package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Poolable<T> {
    void setNextPoolable(T element);
    T getNextPoolable();
    boolean isPooled();
    void setPooled(boolean isPooled);
}
