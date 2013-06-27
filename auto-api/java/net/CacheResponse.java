package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public abstract class CacheResponse {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.078 -0400", hash_original_method = "621EFF4ACAE6839C6F6B759A29E80397", hash_generated_method = "621EFF4ACAE6839C6F6B759A29E80397")
    public CacheResponse ()
    {
        //Synthesized constructor
    }


    public abstract InputStream getBody() throws IOException;

    
    public abstract Map<String, List<String>> getHeaders() throws IOException;

    
}

