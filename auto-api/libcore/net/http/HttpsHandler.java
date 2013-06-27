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

public final class HttpsHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.107 -0400", hash_original_method = "C844A911E2153F94DB6E5F7227FA1E87", hash_generated_method = "C844A911E2153F94DB6E5F7227FA1E87")
    public HttpsHandler ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.108 -0400", hash_original_method = "73E17AE58A6A937F64FCB115DB865949", hash_generated_method = "C143DFB0DE61C27545AC8918158D7A26")
    @Override
    protected URLConnection openConnection(URL url) throws IOException {
        URLConnection varB4EAC82CA7396A68D541C85D26508E83_443045226 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_443045226 = new HttpsURLConnectionImpl(url, getDefaultPort());
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_443045226.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_443045226;
        // ---------- Original Method ----------
        //return new HttpsURLConnectionImpl(url, getDefaultPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.109 -0400", hash_original_method = "E70DBB8BFBA86836115ED4E124721B04", hash_generated_method = "E5477E0816FA705D8CBE2F94F77EFC38")
    @Override
    protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        URLConnection varB4EAC82CA7396A68D541C85D26508E83_25327967 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("url == null || proxy == null");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_25327967 = new HttpsURLConnectionImpl(url, getDefaultPort(), proxy);
        addTaint(url.getTaint());
        addTaint(proxy.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_25327967.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_25327967;
        // ---------- Original Method ----------
        //if (url == null || proxy == null) {
            //throw new IllegalArgumentException("url == null || proxy == null");
        //}
        //return new HttpsURLConnectionImpl(url, getDefaultPort(), proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.109 -0400", hash_original_method = "843384DDAB18A0CAED63C378A0D0642B", hash_generated_method = "AFC4693678F615BF83B955BF77A0F7C4")
    @Override
    protected int getDefaultPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2001889247 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2001889247;
        // ---------- Original Method ----------
        //return 443;
    }

    
}

