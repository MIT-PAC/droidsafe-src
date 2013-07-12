package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class Libcore {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.694 -0400", hash_original_method = "BD7CA9DEFA689A5D8885D644D050CCE7", hash_generated_method = "CE41547BAD954013E73DF351665A550E")
    private  Libcore() {
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.694 -0400", hash_original_field = "25638E142AD8028BA421BB90E603E024", hash_generated_field = "231559DBFD02BB28565E770213CB35D2")

    public static Os os = new BlockGuardOs(new Posix());
}

