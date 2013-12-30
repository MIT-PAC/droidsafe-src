package libcore.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public final class StructTimeval {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.678 -0500", hash_original_method = "86CA502EEAA32132831B5F55D905CDDD", hash_generated_method = "E0EC0EF37C5A6B9DF811000DDC95179D")
    
public static StructTimeval fromMillis(long millis) {
        long tv_sec = millis / 1000;
        long tv_usec = (millis - (tv_sec * 1000)) * 1000;
        return new StructTimeval(tv_sec, tv_usec);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.670 -0500", hash_original_field = "6C5AB8C69445A896CDB38015AE2C3FEE", hash_generated_field = "2551EFE5101A37E7C85A5BFE55D02013")

    public  long tv_sec;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.672 -0500", hash_original_field = "5379641E567668F1C8CBC25B40E0BDE2", hash_generated_field = "F91E150980001C89401E423DD993ED18")

    public  long tv_usec;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.675 -0500", hash_original_method = "2F5BA123079D794DD3CCFA1F00DAAB1E", hash_generated_method = "4323A24696B1C49AA486213C11801394")
    
private StructTimeval(long tv_sec, long tv_usec) {
        this.tv_sec = tv_sec;
        this.tv_usec = tv_usec;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.681 -0500", hash_original_method = "D7D8FCD49C11BCD20431CC831BF1CCDC", hash_generated_method = "4A96AC53A167F4242CCA07C41120EFFE")
    
public long toMillis() {
        return (tv_sec * 1000) + (tv_usec / 1000);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.683 -0500", hash_original_method = "0C66DEC6052711C5671EFCEF17FE1D94", hash_generated_method = "FE19BB85024B70B7154B226843FB3886")
    
@Override public String toString() {
        return "StructTimeval[tv_sec=" + tv_sec + ",tv_usec=" + tv_usec + "]";
    }

    
}

