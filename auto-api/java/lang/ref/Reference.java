package java.lang.ref;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class Reference<T> {
    volatile T referent;
    @SuppressWarnings("unchecked") volatile ReferenceQueue queue;
    @SuppressWarnings("unchecked") volatile Reference queueNext;
    public volatile Reference<?> pendingNext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.718 -0400", hash_original_method = "6CD3D0843AA30F3B07C5B27C93AA8456", hash_generated_method = "D75FE998C2119926819E778AB344D99C")
    @DSModeled(DSC.SAFE)
     Reference() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.719 -0400", hash_original_method = "12DB2A62AB24EF0D8394447093A7278F", hash_generated_method = "1B24CA942DEFF78903152ECD28CDBAAB")
    @DSModeled(DSC.SAFE)
     Reference(T r, ReferenceQueue q) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(q.dsTaint);
        // ---------- Original Method ----------
        //referent = r;
        //queue = q;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.720 -0400", hash_original_method = "0AFD16A0602732B7092274BEFFE68A69", hash_generated_method = "3CA142A05BF69F5A64895A936ECBE10C")
    @DSModeled(DSC.SAFE)
    public void clear() {
        referent = null;
        // ---------- Original Method ----------
        //referent = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.722 -0400", hash_original_method = "26440EC338F5668042D20BF591B8B96C", hash_generated_method = "2EA550CDB2F34BA2D4622E7DB1674E09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final synchronized boolean enqueueInternal() {
        {
            queue.enqueue(this);
            queue = null;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (queue != null && queueNext == null) {
            //queue.enqueue(this);
            //queue = null;
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.723 -0400", hash_original_method = "D897CF322202613DC6CC465308B391E4", hash_generated_method = "FA2353ED76837D1BAB580B14307FE4DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean enqueue() {
        boolean var1A956F7B1D16A58A3C34850CA5FE4029_407139435 = (enqueueInternal());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return enqueueInternal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.723 -0400", hash_original_method = "3B05713F718010AF3C5E0D5C54D10077", hash_generated_method = "A2650DC9477B7347F4866D3D636CEB34")
    @DSModeled(DSC.SAFE)
    public T get() {
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return referent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.723 -0400", hash_original_method = "22F3CCC310074C277F932626BFB7DCB6", hash_generated_method = "906CB33F9C2EBE5B4170316BD864B601")
    @DSModeled(DSC.SAFE)
    public boolean isEnqueued() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return queueNext != null;
    }

    
}

