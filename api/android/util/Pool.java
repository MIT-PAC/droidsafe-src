package android.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface Pool<T extends Poolable<T>> {
    public abstract T acquire();
    public abstract void release(T element);
}
