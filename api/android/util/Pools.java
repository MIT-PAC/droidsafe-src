package android.util;

// Droidsafe Imports
import droidsafe.annotations.DSGenerator;

public class Pools {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.991 -0400", hash_original_method = "7BA724BF54D87E9022C2063CBB50AED6", hash_generated_method = "78FFDAD6C6EE626FBB821F71E64BED43")
    private  Pools() {
        // ---------- Original Method ----------
    }

    
    public static <T extends Poolable<T>> Pool<T> simplePool(PoolableManager<T> manager) {
        return new FinitePool<T>(manager);
    }

    
    public static <T extends Poolable<T>> Pool<T> finitePool(PoolableManager<T> manager, int limit) {
        return new FinitePool<T>(manager, limit);
    }

    
    public static <T extends Poolable<T>> Pool<T> synchronizedPool(Pool<T> pool) {
        return new SynchronizedPool<T>(pool);
    }

    
    public static <T extends Poolable<T>> Pool<T> synchronizedPool(Pool<T> pool, Object lock) {
        return new SynchronizedPool<T>(pool, lock);
    }

    
}

