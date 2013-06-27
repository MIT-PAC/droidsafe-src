package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IOError extends Error {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.995 -0400", hash_original_method = "96BEEC8FF3377FBD2EA8C52D4E2435B2", hash_generated_method = "E1C685C302D9B1163FA3A403DF396CF3")
    public  IOError(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.995 -0400", hash_original_field = "BE0E62DD3A17E8255C61A1E88525EE5D", hash_generated_field = "0E210FB4CF650312C71CBA120D870779")

    private static long serialVersionUID = 67100927991680413L;
}

