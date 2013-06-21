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

public abstract class CookieHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.750 -0400", hash_original_method = "9F2A01C407D8557B7414CC3C30E7E7C2", hash_generated_method = "9F2A01C407D8557B7414CC3C30E7E7C2")
        public CookieHandler ()
    {
    }


        public static CookieHandler getDefault() {
        return systemWideCookieHandler;
    }

    
        public static void setDefault(CookieHandler cHandler) {
        systemWideCookieHandler = cHandler;
    }

    
    public abstract Map<String, List<String>> get(URI uri,
            Map<String, List<String>> requestHeaders) throws IOException;

    
    public abstract void put(URI uri, Map<String, List<String>> responseHeaders)
            throws IOException;

    
    private static CookieHandler systemWideCookieHandler;
}

