package java.util.concurrent.locks;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import sun.misc.Unsafe;

final class UnsafeAccess {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.921 -0400", hash_original_method = "0EFE42460BC7E37E4F419C0570A5DDF5", hash_generated_method = "393CA590A86CE109ADFD700B705308B2")
    private  UnsafeAccess() {
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.922 -0400", hash_original_field = "99B8A39F5FE4782DD7BD0CEC9C6AAC4C", hash_generated_field = "C66CA61F5DA1E1920DDBD5C2EA23A177")

    static final Unsafe THE_ONE = Unsafe.getUnsafe();
}

