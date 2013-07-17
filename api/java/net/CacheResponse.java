package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public abstract class CacheResponse {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.296 -0400", hash_original_method = "621EFF4ACAE6839C6F6B759A29E80397", hash_generated_method = "621EFF4ACAE6839C6F6B759A29E80397")
    public CacheResponse ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public abstract InputStream getBody() throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract Map<String, List<String>> getHeaders() throws IOException;

    
}

