package java.lang.ref;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class Reference<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.777 -0400", hash_original_field = "D29936919A71C251BD3FFBF26B715559", hash_generated_field = "4AAE9C6A17BDEC3E1C4355B9D19EC64B")

    volatile T referent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.777 -0400", hash_original_field = "A9D1CBF71942327E98B40CF5EF38A960", hash_generated_field = "876EC5DE34F64F2FFD05BC63B899180C")

    @SuppressWarnings("unchecked") volatile ReferenceQueue queue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.777 -0400", hash_original_field = "4A527065891FEB6DF6B1C1D4B0722F5F", hash_generated_field = "E273209CA38C7634EA6E996A3D36090C")

    @SuppressWarnings("unchecked") volatile Reference queueNext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.777 -0400", hash_original_field = "971222A4F4BF8E8C713B591BCDF16DAE", hash_generated_field = "4121E324E0F64E4E4F86F1B320B39449")

    public volatile Reference<?> pendingNext;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.777 -0400", hash_original_method = "6CD3D0843AA30F3B07C5B27C93AA8456", hash_generated_method = "D75FE998C2119926819E778AB344D99C")
      Reference() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.779 -0400", hash_original_method = "12DB2A62AB24EF0D8394447093A7278F", hash_generated_method = "1F8171BFBFE8E9A824D0014AFDF25AFB")
      Reference(T r, ReferenceQueue q) {
        referent = r;
        queue = q;
        // ---------- Original Method ----------
        //referent = r;
        //queue = q;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.780 -0400", hash_original_method = "0AFD16A0602732B7092274BEFFE68A69", hash_generated_method = "3CA142A05BF69F5A64895A936ECBE10C")
    public void clear() {
        referent = null;
        // ---------- Original Method ----------
        //referent = null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.781 -0400", hash_original_method = "26440EC338F5668042D20BF591B8B96C", hash_generated_method = "FF108BB461017778A89E95EC17F820D6")
    public final synchronized boolean enqueueInternal() {
        if(queue != null && queueNext == null)        
        {
            queue.enqueue(this);
            queue = null;
            boolean varB326B5062B2F0E69046810717534CB09_1266023674 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2058409777 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2058409777;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1356690884 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1117642752 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1117642752;
        // ---------- Original Method ----------
        //if (queue != null && queueNext == null) {
            //queue.enqueue(this);
            //queue = null;
            //return true;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.782 -0400", hash_original_method = "D897CF322202613DC6CC465308B391E4", hash_generated_method = "E8F9295CF575329A276788B08C2D4579")
    public boolean enqueue() {
        boolean var2A596B0A93E26B39C6F48A0231BE12D9_211413213 = (enqueueInternal());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2025085276 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2025085276;
        // ---------- Original Method ----------
        //return enqueueInternal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.782 -0400", hash_original_method = "3B05713F718010AF3C5E0D5C54D10077", hash_generated_method = "95C3BF0193C4A411074E298608C23A71")
    public T get() {
T var759DD485E78D2D3BF7BBC0941CAE41CB_325456527 =         referent;
        var759DD485E78D2D3BF7BBC0941CAE41CB_325456527.addTaint(taint);
        return var759DD485E78D2D3BF7BBC0941CAE41CB_325456527;
        // ---------- Original Method ----------
        //return referent;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.783 -0400", hash_original_method = "22F3CCC310074C277F932626BFB7DCB6", hash_generated_method = "0D885B9726DB905E385F0EFC714382C0")
    public boolean isEnqueued() {
        boolean varF8F380FE3C977ED15D3C774688222A9E_1078774783 = (queueNext != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_533218263 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_533218263;
        // ---------- Original Method ----------
        //return queueNext != null;
    }

    
}

