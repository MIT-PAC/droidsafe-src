package libcore.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public final class HttpsHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.157 -0400", hash_original_method = "C844A911E2153F94DB6E5F7227FA1E87", hash_generated_method = "C844A911E2153F94DB6E5F7227FA1E87")
    public HttpsHandler ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.157 -0400", hash_original_method = "73E17AE58A6A937F64FCB115DB865949", hash_generated_method = "EED42B21BAD142E68311078620C90C91")
    @Override
    protected URLConnection openConnection(URL url) throws IOException {
        URLConnection varB4EAC82CA7396A68D541C85D26508E83_924645893 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_924645893 = new HttpsURLConnectionImpl(url, getDefaultPort());
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_924645893.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_924645893;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.158 -0400", hash_original_method = "E70DBB8BFBA86836115ED4E124721B04", hash_generated_method = "C0BD7CFBDEB377C422941905D00BA8E8")
    @Override
    protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        URLConnection varB4EAC82CA7396A68D541C85D26508E83_748941299 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("url == null || proxy == null");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_748941299 = new HttpsURLConnectionImpl(url, getDefaultPort(), proxy);
        addTaint(url.getTaint());
        addTaint(proxy.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_748941299.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_748941299;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.158 -0400", hash_original_method = "843384DDAB18A0CAED63C378A0D0642B", hash_generated_method = "3C1FABBFCBAB702B5890BC990D19916C")
    @Override
    protected int getDefaultPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1590031721 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1590031721;
        
        
    }

    
}

