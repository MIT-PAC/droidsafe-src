package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface Poolable<T> {
    void setNextPoolable(T element);
    T getNextPoolable();
    boolean isPooled();
    void setPooled(boolean isPooled);
}
