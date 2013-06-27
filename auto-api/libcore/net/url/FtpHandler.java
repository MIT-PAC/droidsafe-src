package libcore.net.url;

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

public class FtpHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.041 -0400", hash_original_method = "D147DA8ADE52659E6B675F3FCB66ABA5", hash_generated_method = "D147DA8ADE52659E6B675F3FCB66ABA5")
    public FtpHandler ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.045 -0400", hash_original_method = "3C5B2D25E22696E048ED7556D298C58C", hash_generated_method = "00A2D628F6C6C1B08DB266CF8AE76A5A")
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        URLConnection varB4EAC82CA7396A68D541C85D26508E83_1590399898 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1590399898 = new FtpURLConnection(u);
        addTaint(u.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1590399898.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1590399898;
        // ---------- Original Method ----------
        //return new FtpURLConnection(u);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.046 -0400", hash_original_method = "1D737A935EF21FF08B15C0F0950C4FF6", hash_generated_method = "A744A452240A206EA961E14596D63292")
    @Override
    protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        URLConnection varB4EAC82CA7396A68D541C85D26508E83_556155573 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("url == null || proxy == null");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_556155573 = new FtpURLConnection(url, proxy);
        addTaint(url.getTaint());
        addTaint(proxy.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_556155573.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_556155573;
        // ---------- Original Method ----------
        //if (url == null || proxy == null) {
            //throw new IllegalArgumentException("url == null || proxy == null");
        //}
        //return new FtpURLConnection(url, proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.055 -0400", hash_original_method = "EEF2A707E6AE293A2B045747E5BC7948", hash_generated_method = "B7531F0C09CF1FAFBEF6C4DC02D901AA")
    @Override
    protected int getDefaultPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_248569975 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_248569975;
        // ---------- Original Method ----------
        //return 21;
    }

    
}

