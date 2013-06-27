package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract class ResponseCache {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.803 -0400", hash_original_method = "D16C43EEDC21B64FF5979CBD3059BA6B", hash_generated_method = "D16C43EEDC21B64FF5979CBD3059BA6B")
    public ResponseCache ()
    {
        //Synthesized constructor
    }


        public static ResponseCache getDefault() {
        return defaultResponseCache;
    }

    
        public static void setDefault(ResponseCache responseCache) {
        defaultResponseCache = responseCache;
    }

    
    public abstract CacheResponse get(URI uri, String requestMethod,
            Map<String, List<String>> requestHeaders) throws IOException;

    
    public abstract CacheRequest put(URI uri, URLConnection connection) throws IOException;

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.804 -0400", hash_original_field = "F640D19B77A00C869D2801E49C0E0481", hash_generated_field = "977723D7A34AC2663C01851D0C5635D6")

    private static ResponseCache defaultResponseCache = null;
}

