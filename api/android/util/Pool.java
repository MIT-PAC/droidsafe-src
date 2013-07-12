package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Pool<T extends Poolable<T>> {
    public abstract T acquire();
    public abstract void release(T element);
}
