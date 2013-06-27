package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;

public abstract class CacheRequest {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.862 -0400", hash_original_method = "EF935F4A27F0AD3C6EAFD085021C924B", hash_generated_method = "565E02796318DC747E540B18E51EE449")
    public  CacheRequest() {
        // ---------- Original Method ----------
    }

    
    public abstract void abort();

    
    public abstract OutputStream getBody() throws IOException;

    
}

