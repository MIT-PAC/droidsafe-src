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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.452 -0400", hash_original_method = "C844A911E2153F94DB6E5F7227FA1E87", hash_generated_method = "C844A911E2153F94DB6E5F7227FA1E87")
    public HttpsHandler ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.453 -0400", hash_original_method = "73E17AE58A6A937F64FCB115DB865949", hash_generated_method = "B270FBBCE257094AC3F88E37C01930B1")
    @Override
    protected URLConnection openConnection(URL url) throws IOException {
        URLConnection varB4EAC82CA7396A68D541C85D26508E83_201771530 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_201771530 = new HttpsURLConnectionImpl(url, getDefaultPort());
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_201771530.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_201771530;
        // ---------- Original Method ----------
        //return new HttpsURLConnectionImpl(url, getDefaultPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.454 -0400", hash_original_method = "E70DBB8BFBA86836115ED4E124721B04", hash_generated_method = "031761FFC37E97E4CB8E56F35F6600B7")
    @Override
    protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        URLConnection varB4EAC82CA7396A68D541C85D26508E83_1007654588 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("url == null || proxy == null");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1007654588 = new HttpsURLConnectionImpl(url, getDefaultPort(), proxy);
        addTaint(url.getTaint());
        addTaint(proxy.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1007654588.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1007654588;
        // ---------- Original Method ----------
        //if (url == null || proxy == null) {
            //throw new IllegalArgumentException("url == null || proxy == null");
        //}
        //return new HttpsURLConnectionImpl(url, getDefaultPort(), proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.454 -0400", hash_original_method = "843384DDAB18A0CAED63C378A0D0642B", hash_generated_method = "9143BAC894F25050CB15C1C5D7AACE49")
    @Override
    protected int getDefaultPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1262983875 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1262983875;
        // ---------- Original Method ----------
        //return 443;
    }

    
}

