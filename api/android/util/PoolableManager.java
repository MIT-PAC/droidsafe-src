package android.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface PoolableManager<T extends Poolable<T>> {
    T newInstance();

    void onAcquired(T element);
    void onReleased(T element);
}
