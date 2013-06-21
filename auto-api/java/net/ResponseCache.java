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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.075 -0400", hash_original_method = "022C01BB1FF5E1886AA41FFBFAA7983C", hash_generated_method = "022C01BB1FF5E1886AA41FFBFAA7983C")
        public ResponseCache ()
    {
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

    
    private static ResponseCache defaultResponseCache = null;
}

