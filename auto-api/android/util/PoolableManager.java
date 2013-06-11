package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface PoolableManager<T extends Poolable<T>> {
    T newInstance();

    void onAcquired(T element);
    void onReleased(T element);
}

