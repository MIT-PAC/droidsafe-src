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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.746 -0400", hash_original_method = "CD7E96B46C26DC53A17638658F546DAD", hash_generated_method = "CD7E96B46C26DC53A17638658F546DAD")
        public CacheResponse ()
    {
    }


    public abstract InputStream getBody() throws IOException;

    
    public abstract Map<String, List<String>> getHeaders() throws IOException;

    
}

