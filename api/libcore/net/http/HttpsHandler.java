package libcore.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public final class HttpsHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.594 -0400", hash_original_method = "C844A911E2153F94DB6E5F7227FA1E87", hash_generated_method = "C844A911E2153F94DB6E5F7227FA1E87")
    public HttpsHandler ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.034 -0500", hash_original_method = "73E17AE58A6A937F64FCB115DB865949", hash_generated_method = "57FCFA317F4D4C31BC9BA5B1D8B3F608")
    
@Override protected URLConnection openConnection(URL url) throws IOException {
        return new HttpsURLConnectionImpl(url, getDefaultPort());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.036 -0500", hash_original_method = "E70DBB8BFBA86836115ED4E124721B04", hash_generated_method = "56F74A0FB2E18D52F431D8AC5149CE74")
    
@Override protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        if (url == null || proxy == null) {
            throw new IllegalArgumentException("url == null || proxy == null");
        }
        return new HttpsURLConnectionImpl(url, getDefaultPort(), proxy);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.038 -0500", hash_original_method = "843384DDAB18A0CAED63C378A0D0642B", hash_generated_method = "53DD98D6678851884B31835065BCCA7D")
    
@Override protected int getDefaultPort() {
        return 443;
    }
    
}

