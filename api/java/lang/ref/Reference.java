package java.lang.ref;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class Reference<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.837 -0400", hash_original_field = "D29936919A71C251BD3FFBF26B715559", hash_generated_field = "4AAE9C6A17BDEC3E1C4355B9D19EC64B")

    volatile T referent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.837 -0400", hash_original_field = "A9D1CBF71942327E98B40CF5EF38A960", hash_generated_field = "876EC5DE34F64F2FFD05BC63B899180C")

    @SuppressWarnings("unchecked") volatile ReferenceQueue queue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.837 -0400", hash_original_field = "4A527065891FEB6DF6B1C1D4B0722F5F", hash_generated_field = "E273209CA38C7634EA6E996A3D36090C")

    @SuppressWarnings("unchecked") volatile Reference queueNext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.837 -0400", hash_original_field = "971222A4F4BF8E8C713B591BCDF16DAE", hash_generated_field = "4121E324E0F64E4E4F86F1B320B39449")

    public volatile Reference<?> pendingNext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.838 -0400", hash_original_method = "6CD3D0843AA30F3B07C5B27C93AA8456", hash_generated_method = "D75FE998C2119926819E778AB344D99C")
      Reference() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.838 -0400", hash_original_method = "12DB2A62AB24EF0D8394447093A7278F", hash_generated_method = "1F8171BFBFE8E9A824D0014AFDF25AFB")
      Reference(T r, ReferenceQueue q) {
        referent = r;
        queue = q;
        // ---------- Original Method ----------
        //referent = r;
        //queue = q;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.839 -0400", hash_original_method = "0AFD16A0602732B7092274BEFFE68A69", hash_generated_method = "3CA142A05BF69F5A64895A936ECBE10C")
    public void clear() {
        referent = null;
        // ---------- Original Method ----------
        //referent = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.839 -0400", hash_original_method = "26440EC338F5668042D20BF591B8B96C", hash_generated_method = "DD730ABBE5ADCC54D7971A73C529CED8")
    public final synchronized boolean enqueueInternal() {
    if(queue != null && queueNext == null)        
        {
            queue.enqueue(this);
            queue = null;
            boolean varB326B5062B2F0E69046810717534CB09_1101586338 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_845912030 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_845912030;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1791114262 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_841095696 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_841095696;
        // ---------- Original Method ----------
        //if (queue != null && queueNext == null) {
            //queue.enqueue(this);
            //queue = null;
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.840 -0400", hash_original_method = "D897CF322202613DC6CC465308B391E4", hash_generated_method = "633A343AE28DA58A0EA1001C4BDB6440")
    public boolean enqueue() {
        boolean var2A596B0A93E26B39C6F48A0231BE12D9_656920003 = (enqueueInternal());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1228953730 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1228953730;
        // ---------- Original Method ----------
        //return enqueueInternal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.840 -0400", hash_original_method = "3B05713F718010AF3C5E0D5C54D10077", hash_generated_method = "21B77B863146BE254A1EFB424F5F68E1")
    public T get() {
T var759DD485E78D2D3BF7BBC0941CAE41CB_1242956865 =         referent;
        var759DD485E78D2D3BF7BBC0941CAE41CB_1242956865.addTaint(taint);
        return var759DD485E78D2D3BF7BBC0941CAE41CB_1242956865;
        // ---------- Original Method ----------
        //return referent;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.840 -0400", hash_original_method = "22F3CCC310074C277F932626BFB7DCB6", hash_generated_method = "340A3032D708504C8B370243E68EF288")
    public boolean isEnqueued() {
        boolean varF8F380FE3C977ED15D3C774688222A9E_468566791 = (queueNext != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_198167174 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_198167174;
        // ---------- Original Method ----------
        //return queueNext != null;
    }

    
}

