package java.net;

// Droidsafe Imports
import java.io.IOException;
import java.io.OutputStream;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class CacheRequest {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.292 -0400", hash_original_method = "EF935F4A27F0AD3C6EAFD085021C924B", hash_generated_method = "565E02796318DC747E540B18E51EE449")
    public  CacheRequest() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void abort();

    
    @DSModeled(DSC.SAFE)
    public abstract OutputStream getBody() throws IOException;

    
}

