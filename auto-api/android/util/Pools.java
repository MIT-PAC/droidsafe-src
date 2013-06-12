package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class Pools {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.655 -0400", hash_original_method = "7BA724BF54D87E9022C2063CBB50AED6", hash_generated_method = "DC558539E48727750A8C01CC4B52798E")
    @DSModeled(DSC.SAFE)
    private Pools() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.655 -0400", hash_original_method = "D692356F4F2AA87D85AA11FA1832228F", hash_generated_method = "FC347DC298AAF0D69530CFA9FCFDE30B")
    public static <T extends Poolable<T>> Pool<T> simplePool(PoolableManager<T> manager) {
        return new FinitePool<T>(manager);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.655 -0400", hash_original_method = "E061C0D993F839E981491E13C12B33B1", hash_generated_method = "00E65686134A071E437AEE4098A87258")
    public static <T extends Poolable<T>> Pool<T> finitePool(PoolableManager<T> manager, int limit) {
        return new FinitePool<T>(manager, limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.655 -0400", hash_original_method = "FD77D764737FDB12AA379AAC6549757C", hash_generated_method = "B411409CFDD408DE9139B5FF839858AF")
    public static <T extends Poolable<T>> Pool<T> synchronizedPool(Pool<T> pool) {
        return new SynchronizedPool<T>(pool);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.655 -0400", hash_original_method = "42677E1411A068B26655AFC487946C69", hash_generated_method = "2840D3F7685178C0FB4C35C69208E4A6")
    public static <T extends Poolable<T>> Pool<T> synchronizedPool(Pool<T> pool, Object lock) {
        return new SynchronizedPool<T>(pool, lock);
    }

    
}


