package java.lang.ref;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class Reference<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.780 -0400", hash_original_field = "D29936919A71C251BD3FFBF26B715559", hash_generated_field = "4AAE9C6A17BDEC3E1C4355B9D19EC64B")

    volatile T referent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.780 -0400", hash_original_field = "A9D1CBF71942327E98B40CF5EF38A960", hash_generated_field = "876EC5DE34F64F2FFD05BC63B899180C")

    @SuppressWarnings("unchecked") volatile ReferenceQueue queue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.780 -0400", hash_original_field = "4A527065891FEB6DF6B1C1D4B0722F5F", hash_generated_field = "E273209CA38C7634EA6E996A3D36090C")

    @SuppressWarnings("unchecked") volatile Reference queueNext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.780 -0400", hash_original_field = "971222A4F4BF8E8C713B591BCDF16DAE", hash_generated_field = "4121E324E0F64E4E4F86F1B320B39449")

    public volatile Reference<?> pendingNext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.782 -0400", hash_original_method = "6CD3D0843AA30F3B07C5B27C93AA8456", hash_generated_method = "D75FE998C2119926819E778AB344D99C")
      Reference() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.783 -0400", hash_original_method = "12DB2A62AB24EF0D8394447093A7278F", hash_generated_method = "1F8171BFBFE8E9A824D0014AFDF25AFB")
      Reference(T r, ReferenceQueue q) {
        referent = r;
        queue = q;
        // ---------- Original Method ----------
        //referent = r;
        //queue = q;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.783 -0400", hash_original_method = "0AFD16A0602732B7092274BEFFE68A69", hash_generated_method = "3CA142A05BF69F5A64895A936ECBE10C")
    public void clear() {
        referent = null;
        // ---------- Original Method ----------
        //referent = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.783 -0400", hash_original_method = "26440EC338F5668042D20BF591B8B96C", hash_generated_method = "4DB38FFD4E396F99CBE2FA89B861774F")
    public final synchronized boolean enqueueInternal() {
        {
            queue.enqueue(this);
            queue = null;
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_790024881 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_790024881;
        // ---------- Original Method ----------
        //if (queue != null && queueNext == null) {
            //queue.enqueue(this);
            //queue = null;
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.784 -0400", hash_original_method = "D897CF322202613DC6CC465308B391E4", hash_generated_method = "DCAA1CEA284E0CD82A733A35F82510B4")
    public boolean enqueue() {
        boolean var1A956F7B1D16A58A3C34850CA5FE4029_870717715 = (enqueueInternal());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1537980210 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1537980210;
        // ---------- Original Method ----------
        //return enqueueInternal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.784 -0400", hash_original_method = "3B05713F718010AF3C5E0D5C54D10077", hash_generated_method = "492E4FCCD5C5280BF901C693E622FAB2")
    public T get() {
        T varB4EAC82CA7396A68D541C85D26508E83_152885056 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_152885056 = referent;
        varB4EAC82CA7396A68D541C85D26508E83_152885056.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_152885056;
        // ---------- Original Method ----------
        //return referent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.784 -0400", hash_original_method = "22F3CCC310074C277F932626BFB7DCB6", hash_generated_method = "951D898903EA20FD1872FEB645EBDBA0")
    public boolean isEnqueued() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_510544158 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_510544158;
        // ---------- Original Method ----------
        //return queueNext != null;
    }

    
}

