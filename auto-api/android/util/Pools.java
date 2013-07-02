package android.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class Pools {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.504 -0400", hash_original_method = "7BA724BF54D87E9022C2063CBB50AED6", hash_generated_method = "78FFDAD6C6EE626FBB821F71E64BED43")
    private  Pools() {
        
    }

    
    @DSModeled(DSC.SPEC)
    public static <T extends Poolable<T>> Pool<T> simplePool(PoolableManager<T> manager) {
        return new FinitePool<T>(manager);
    }

    
    @DSModeled(DSC.SPEC)
    public static <T extends Poolable<T>> Pool<T> finitePool(PoolableManager<T> manager, int limit) {
        return new FinitePool<T>(manager, limit);
    }

    
    @DSModeled(DSC.SPEC)
    public static <T extends Poolable<T>> Pool<T> synchronizedPool(Pool<T> pool) {
        return new SynchronizedPool<T>(pool);
    }

    
    @DSModeled(DSC.SPEC)
    public static <T extends Poolable<T>> Pool<T> synchronizedPool(Pool<T> pool, Object lock) {
        return new SynchronizedPool<T>(pool, lock);
    }

    
}

