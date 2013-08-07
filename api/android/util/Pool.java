package android.util;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Pool<T extends Poolable<T>> {
    public abstract T acquire();
    public abstract void release(T element);
}
