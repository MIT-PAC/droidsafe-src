package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class Libcore {
    public static Os os = new BlockGuardOs(new Posix());
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.473 -0400", hash_original_method = "BD7CA9DEFA689A5D8885D644D050CCE7", hash_generated_method = "6B2988BD0A844FA211E772D9216C517C")
    @DSModeled(DSC.SAFE)
    private Libcore() {
        // ---------- Original Method ----------
    }

    
}


