package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



class SynchronizedPool<T extends Poolable<T>> implements Pool<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.066 -0500", hash_original_field = "B40E8AE2AA347E5FF2444F94D00B3F93", hash_generated_field = "105D132186E8AA24291EFCF7D115902D")

    private  Pool<T> mPool;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.068 -0500", hash_original_field = "3526352753B6B6D766C1FB8917CD22F8", hash_generated_field = "7811049C9A4FE55905A497F504D75A1C")

    private  Object mLock;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.070 -0500", hash_original_method = "5C8F49372B1FEAE144C54A4EE1C5257C", hash_generated_method = "652EB4B1D9CAB82326D69D593B4963C0")
    
public SynchronizedPool(Pool<T> pool) {
        mPool = pool;
        mLock = this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.073 -0500", hash_original_method = "3B08DD84C1E94356AB4532B92432A6B9", hash_generated_method = "5B770E06587F9B6BB893D2AF7BC97608")
    
public SynchronizedPool(Pool<T> pool, Object lock) {
        mPool = pool;
        mLock = lock;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.075 -0500", hash_original_method = "33DD110D68F95CA8E21FED144538609A", hash_generated_method = "482F3295434F5696EC17609E50F808D4")
    
public T acquire() {
        synchronized (mLock) {
            return mPool.acquire();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.077 -0500", hash_original_method = "D3A44672BBA01F45A0EA27E869DCFDD8", hash_generated_method = "3BAFE97972290C9AEB7D1564F500EE31")
    
public void release(T element) {
        synchronized (mLock) {
            mPool.release(element);
        }
    }

    
}

