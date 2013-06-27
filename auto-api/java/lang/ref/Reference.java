package java.lang.ref;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class Reference<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.874 -0400", hash_original_field = "D29936919A71C251BD3FFBF26B715559", hash_generated_field = "4AAE9C6A17BDEC3E1C4355B9D19EC64B")

    volatile T referent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.874 -0400", hash_original_field = "A9D1CBF71942327E98B40CF5EF38A960", hash_generated_field = "876EC5DE34F64F2FFD05BC63B899180C")

    @SuppressWarnings("unchecked") volatile ReferenceQueue queue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.874 -0400", hash_original_field = "4A527065891FEB6DF6B1C1D4B0722F5F", hash_generated_field = "E273209CA38C7634EA6E996A3D36090C")

    @SuppressWarnings("unchecked") volatile Reference queueNext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.874 -0400", hash_original_field = "971222A4F4BF8E8C713B591BCDF16DAE", hash_generated_field = "4121E324E0F64E4E4F86F1B320B39449")

    public volatile Reference<?> pendingNext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.874 -0400", hash_original_method = "6CD3D0843AA30F3B07C5B27C93AA8456", hash_generated_method = "D75FE998C2119926819E778AB344D99C")
      Reference() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.875 -0400", hash_original_method = "12DB2A62AB24EF0D8394447093A7278F", hash_generated_method = "1F8171BFBFE8E9A824D0014AFDF25AFB")
      Reference(T r, ReferenceQueue q) {
        referent = r;
        queue = q;
        // ---------- Original Method ----------
        //referent = r;
        //queue = q;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.875 -0400", hash_original_method = "0AFD16A0602732B7092274BEFFE68A69", hash_generated_method = "3CA142A05BF69F5A64895A936ECBE10C")
    public void clear() {
        referent = null;
        // ---------- Original Method ----------
        //referent = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.875 -0400", hash_original_method = "26440EC338F5668042D20BF591B8B96C", hash_generated_method = "2372C5D288B4900B389FB77A29C4A479")
    public final synchronized boolean enqueueInternal() {
        {
            queue.enqueue(this);
            queue = null;
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_448916477 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_448916477;
        // ---------- Original Method ----------
        //if (queue != null && queueNext == null) {
            //queue.enqueue(this);
            //queue = null;
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.881 -0400", hash_original_method = "D897CF322202613DC6CC465308B391E4", hash_generated_method = "2CF5A2A419B7251D101D70248DC0A925")
    public boolean enqueue() {
        boolean var1A956F7B1D16A58A3C34850CA5FE4029_1488500828 = (enqueueInternal());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_137187980 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_137187980;
        // ---------- Original Method ----------
        //return enqueueInternal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.882 -0400", hash_original_method = "3B05713F718010AF3C5E0D5C54D10077", hash_generated_method = "1343653F1020E0DE60A759558690153B")
    public T get() {
        T varB4EAC82CA7396A68D541C85D26508E83_606681670 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_606681670 = referent;
        varB4EAC82CA7396A68D541C85D26508E83_606681670.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_606681670;
        // ---------- Original Method ----------
        //return referent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.883 -0400", hash_original_method = "22F3CCC310074C277F932626BFB7DCB6", hash_generated_method = "6A2758B9E5B2711685A2C9AF661B1397")
    public boolean isEnqueued() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1312666851 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1312666851;
        // ---------- Original Method ----------
        //return queueNext != null;
    }

    
}

