package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class Libcore {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.949 -0400", hash_original_method = "BD7CA9DEFA689A5D8885D644D050CCE7", hash_generated_method = "CE41547BAD954013E73DF351665A550E")
    @DSModeled(DSC.SAFE)
    private Libcore() {
        // ---------- Original Method ----------
    }

    
    public static Os os = new BlockGuardOs(new Posix());
}

