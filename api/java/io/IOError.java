package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class IOError extends Error {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.756 -0400", hash_original_method = "96BEEC8FF3377FBD2EA8C52D4E2435B2", hash_generated_method = "E1C685C302D9B1163FA3A403DF396CF3")
    public  IOError(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.758 -0400", hash_original_field = "BE0E62DD3A17E8255C61A1E88525EE5D", hash_generated_field = "B0E0B3279A8FF05BF846141BCB1703ED")

    private static final long serialVersionUID = 67100927991680413L;
}

