package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class SynchronizedPool<T extends Poolable<T>> implements Pool<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.269 -0400", hash_original_field = "6A0D6954D813A9663B4032F3610B6FB3", hash_generated_field = "105D132186E8AA24291EFCF7D115902D")

    private Pool<T> mPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.269 -0400", hash_original_field = "D99C4DF571068C060F9624A3098FE796", hash_generated_field = "7811049C9A4FE55905A497F504D75A1C")

    private Object mLock;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.286 -0400", hash_original_method = "5C8F49372B1FEAE144C54A4EE1C5257C", hash_generated_method = "08AD1B277A66B454B7C2A97FDADFDCDA")
    public  SynchronizedPool(Pool<T> pool) {
        mPool = pool;
        mLock = this;
        // ---------- Original Method ----------
        //mPool = pool;
        //mLock = this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.287 -0400", hash_original_method = "3B08DD84C1E94356AB4532B92432A6B9", hash_generated_method = "F11802ED8034E95562E73DD644752488")
    public  SynchronizedPool(Pool<T> pool, Object lock) {
        mPool = pool;
        mLock = lock;
        // ---------- Original Method ----------
        //mPool = pool;
        //mLock = lock;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.287 -0400", hash_original_method = "33DD110D68F95CA8E21FED144538609A", hash_generated_method = "D99F9B0D5EEA98BB58ECF5082F2FBB3D")
    public T acquire() {
        T varB4EAC82CA7396A68D541C85D26508E83_937159695 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_937159695 = mPool.acquire();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_937159695.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_937159695;
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //return mPool.acquire();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.288 -0400", hash_original_method = "D3A44672BBA01F45A0EA27E869DCFDD8", hash_generated_method = "5408D5B32FDCDD52E393A634523F5FA1")
    public void release(T element) {
        {
            mPool.release(element);
        } //End block
        addTaint(element.getTaint());
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //mPool.release(element);
        //}
    }

    
}

