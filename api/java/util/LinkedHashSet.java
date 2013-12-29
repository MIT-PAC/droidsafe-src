package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;






public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:50.834 -0500", hash_original_field = "A3A620E6BD10FB5E1B95C7C0FE237122", hash_generated_field = "9AC03C289FA70340AC8107CAE1966D0A")


    private static final long serialVersionUID = -2851667679971038690L;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.760 -0400", hash_original_method = "FA64C9B63CE04BA03B3070651E56EFED", hash_generated_method = "B99E3A755713053C1BCF05A2186909D1")
    public  LinkedHashSet() {
        super();
        // ---------- Original Method ----------
    }
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.761 -0400", hash_original_method = "D1E784926661CD719EF7E1152646271C", hash_generated_method = "402E1F209664C62953205E8A57DD538F")
    public  LinkedHashSet(int capacity) {
        super(capacity);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.761 -0400", hash_original_method = "BE6AEEEAC74AB8DE439B6373179C0342", hash_generated_method = "C16BEE166C0FB5ACEED8506BB5C89691")
    public  LinkedHashSet(int capacity, float loadFactor) {
        super(capacity);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.761 -0400", hash_original_method = "04F711D7424A0EA0A6EA304747ABA554", hash_generated_method = "8B59B2B9DCF36FC27AA99B0F9BADC9B8")
    public  LinkedHashSet(Collection<? extends E> collection) {
        super(collection);
        // ---------- Original Method ----------
        //for (E e : collection) {
            //add(e);
        //}
    }
}

