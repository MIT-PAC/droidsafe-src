package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract class CookieHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.047 -0400", hash_original_method = "88D15E3335299CEFE37CA24D0A89E063", hash_generated_method = "88D15E3335299CEFE37CA24D0A89E063")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.047 -0400", hash_original_field = "E1D260A0A6B209A220BDA69A447458C5", hash_generated_field = "8C9BF4ECEE0FD776A81C187004A66852")

    private static CookieHandler systemWideCookieHandler;
}

