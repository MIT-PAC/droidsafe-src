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

public final class HttpHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.284 -0400", hash_original_method = "19FB70242B210A6BA2C2EBCBFA2BC8EA", hash_generated_method = "19FB70242B210A6BA2C2EBCBFA2BC8EA")
    public HttpHandler ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:31.914 -0500", hash_original_method = "36344CA950B2A976BD9D30B58C91386F", hash_generated_method = "64F9A3A5C744015EB626E2A9F6179738")
    
@Override protected URLConnection openConnection(URL u) throws IOException {
        return new HttpURLConnectionImpl(u, getDefaultPort());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:31.917 -0500", hash_original_method = "1382348F6F5129438828F631F9FA5282", hash_generated_method = "6CC095EF61C829E693499CB90DD19A50")
    
@Override protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        if (url == null || proxy == null) {
            throw new IllegalArgumentException("url == null || proxy == null");
        }
        return new HttpURLConnectionImpl(url, getDefaultPort(), proxy);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:31.919 -0500", hash_original_method = "FEEAB6915C12BF9E3FEC7C9D98366E77", hash_generated_method = "5299DDB2FBD4BF18E13EF23AD2F5F20F")
    
@Override protected int getDefaultPort() {
        return 80;
    }
    
}

