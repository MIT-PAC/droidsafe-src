package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public final class HttpHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.030 -0400", hash_original_method = "19FB70242B210A6BA2C2EBCBFA2BC8EA", hash_generated_method = "19FB70242B210A6BA2C2EBCBFA2BC8EA")
    public HttpHandler ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.032 -0400", hash_original_method = "36344CA950B2A976BD9D30B58C91386F", hash_generated_method = "20297999B894278068B60032B156E59C")
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        URLConnection varB4EAC82CA7396A68D541C85D26508E83_1387417111 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1387417111 = new HttpURLConnectionImpl(u, getDefaultPort());
        addTaint(u.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1387417111.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1387417111;
        // ---------- Original Method ----------
        //return new HttpURLConnectionImpl(u, getDefaultPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.032 -0400", hash_original_method = "1382348F6F5129438828F631F9FA5282", hash_generated_method = "0B9C5A09F5417981ED02544DDF9B26E7")
    @Override
    protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        URLConnection varB4EAC82CA7396A68D541C85D26508E83_25847764 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("url == null || proxy == null");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_25847764 = new HttpURLConnectionImpl(url, getDefaultPort(), proxy);
        addTaint(url.getTaint());
        addTaint(proxy.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_25847764.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_25847764;
        // ---------- Original Method ----------
        //if (url == null || proxy == null) {
            //throw new IllegalArgumentException("url == null || proxy == null");
        //}
        //return new HttpURLConnectionImpl(url, getDefaultPort(), proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.032 -0400", hash_original_method = "FEEAB6915C12BF9E3FEC7C9D98366E77", hash_generated_method = "2E4946417A3B9694218B0046053C415C")
    @Override
    protected int getDefaultPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1366120367 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1366120367;
        // ---------- Original Method ----------
        //return 80;
    }

    
}

