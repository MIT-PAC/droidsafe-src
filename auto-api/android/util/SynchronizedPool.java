package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class SynchronizedPool<T extends Poolable<T>> implements Pool<T> {
    private Pool<T> mPool;
    private Object mLock;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.385 -0400", hash_original_method = "5C8F49372B1FEAE144C54A4EE1C5257C", hash_generated_method = "88786E320E85B478083CA0474421C005")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SynchronizedPool(Pool<T> pool) {
        dsTaint.addTaint(pool.dsTaint);
        mLock = this;
        // ---------- Original Method ----------
        //mPool = pool;
        //mLock = this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.385 -0400", hash_original_method = "3B08DD84C1E94356AB4532B92432A6B9", hash_generated_method = "7E505616F1023115692B0A6F53009D4B")
    @DSModeled(DSC.SAFE)
    public SynchronizedPool(Pool<T> pool, Object lock) {
        dsTaint.addTaint(pool.dsTaint);
        dsTaint.addTaint(lock.dsTaint);
        // ---------- Original Method ----------
        //mPool = pool;
        //mLock = lock;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.385 -0400", hash_original_method = "33DD110D68F95CA8E21FED144538609A", hash_generated_method = "AFB87791964B97E47B0F58B8BDD94A5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public T acquire() {
        {
            T var75B4EE73D779A6B622DF15BCBC3CE1A3_83439352 = (mPool.acquire());
        } //End block
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //return mPool.acquire();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.386 -0400", hash_original_method = "D3A44672BBA01F45A0EA27E869DCFDD8", hash_generated_method = "0AD27621CA5244D2D80C471776C0CCEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void release(T element) {
        dsTaint.addTaint(element.dsTaint);
        {
            mPool.release(element);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //mPool.release(element);
        //}
    }

    
}

