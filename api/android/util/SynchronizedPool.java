package android.util;

// Droidsafe Imports
import droidsafe.annotations.*;



class SynchronizedPool<T extends Poolable<T>> implements Pool<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.231 -0400", hash_original_field = "6A0D6954D813A9663B4032F3610B6FB3", hash_generated_field = "105D132186E8AA24291EFCF7D115902D")

    private Pool<T> mPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.232 -0400", hash_original_field = "D99C4DF571068C060F9624A3098FE796", hash_generated_field = "7811049C9A4FE55905A497F504D75A1C")

    private Object mLock;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.232 -0400", hash_original_method = "5C8F49372B1FEAE144C54A4EE1C5257C", hash_generated_method = "08AD1B277A66B454B7C2A97FDADFDCDA")
    public  SynchronizedPool(Pool<T> pool) {
        mPool = pool;
        mLock = this;
        // ---------- Original Method ----------
        //mPool = pool;
        //mLock = this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.233 -0400", hash_original_method = "3B08DD84C1E94356AB4532B92432A6B9", hash_generated_method = "F11802ED8034E95562E73DD644752488")
    public  SynchronizedPool(Pool<T> pool, Object lock) {
        mPool = pool;
        mLock = lock;
        // ---------- Original Method ----------
        //mPool = pool;
        //mLock = lock;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.234 -0400", hash_original_method = "33DD110D68F95CA8E21FED144538609A", hash_generated_method = "E944BF832C2DF92D34AB46AB05D34DA0")
    public T acquire() {
        synchronized
(mLock)        {
T varEDF53E778C1F13B11764E360D72D35D7_602352364 =             mPool.acquire();
            varEDF53E778C1F13B11764E360D72D35D7_602352364.addTaint(taint);
            return varEDF53E778C1F13B11764E360D72D35D7_602352364;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //return mPool.acquire();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.234 -0400", hash_original_method = "D3A44672BBA01F45A0EA27E869DCFDD8", hash_generated_method = "6C341286A4A31E49DD30101410171D89")
    public void release(T element) {
        addTaint(element.getTaint());
        synchronized
(mLock)        {
            mPool.release(element);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //mPool.release(element);
        //}
    }

    
}

