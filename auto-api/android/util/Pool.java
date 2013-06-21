package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface Pool<T extends Poolable<T>> {
    public abstract T acquire();
    public abstract void release(T element);
}
