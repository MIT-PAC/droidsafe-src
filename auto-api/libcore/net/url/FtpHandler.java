package libcore.net.url;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class FtpHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.781 -0400", hash_original_method = "D147DA8ADE52659E6B675F3FCB66ABA5", hash_generated_method = "D147DA8ADE52659E6B675F3FCB66ABA5")
    public FtpHandler ()
    {
        
    }


    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.781 -0400", hash_original_method = "3C5B2D25E22696E048ED7556D298C58C", hash_generated_method = "069F4E7C7FF714E8A3844231E9B119C0")
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        URLConnection varB4EAC82CA7396A68D541C85D26508E83_652666189 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_652666189 = new FtpURLConnection(u);
        addTaint(u.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_652666189.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_652666189;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.782 -0400", hash_original_method = "1D737A935EF21FF08B15C0F0950C4FF6", hash_generated_method = "A17B83E53A790C05C40868E961D21005")
    @Override
    protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        URLConnection varB4EAC82CA7396A68D541C85D26508E83_309056111 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("url == null || proxy == null");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_309056111 = new FtpURLConnection(url, proxy);
        addTaint(url.getTaint());
        addTaint(proxy.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_309056111.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_309056111;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.782 -0400", hash_original_method = "EEF2A707E6AE293A2B045747E5BC7948", hash_generated_method = "8E813B134042BCE41BA0071D94040F90")
    @Override
    protected int getDefaultPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_122953932 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_122953932;
        
        
    }

    
}

