package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class Pools {
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.600 -0500", hash_original_method = "7BA724BF54D87E9022C2063CBB50AED6", hash_generated_method = "E8F74C7933D21E207F3CF684DAA14385")
    
private Pools() {
    }
    
}

