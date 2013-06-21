package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import sun.misc.Unsafe;

final class UnsafeAccess {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.099 -0400", hash_original_method = "0EFE42460BC7E37E4F419C0570A5DDF5", hash_generated_method = "393CA590A86CE109ADFD700B705308B2")
    @DSModeled(DSC.SAFE)
    private UnsafeAccess() {
        // ---------- Original Method ----------
    }

    
    static final Unsafe THE_ONE = Unsafe.getUnsafe();
}

