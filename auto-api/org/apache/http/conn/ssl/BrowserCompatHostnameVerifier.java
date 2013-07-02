package org.apache.http.conn.ssl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.net.ssl.SSLException;

public class BrowserCompatHostnameVerifier extends AbstractVerifier {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.432 -0400", hash_original_method = "F97EE270780B41C0EF5EF7526675E0EC", hash_generated_method = "F97EE270780B41C0EF5EF7526675E0EC")
    public BrowserCompatHostnameVerifier ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.432 -0400", hash_original_method = "D9F365CDBDB058C6F5810F830DF6A39F", hash_generated_method = "86BAA43C236ABB3B4C4CAD5333E7CE42")
    public final void verify(
            final String host, 
            final String[] cns,
            final String[] subjectAlts) throws SSLException {
        verify(host, cns, subjectAlts, false);
        addTaint(host.getTaint());
        addTaint(cns[0].getTaint());
        addTaint(subjectAlts[0].getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.432 -0400", hash_original_method = "94D0B9A8609089C8ED7C7100365BC140", hash_generated_method = "ACDF9DEC880F17E93DCC4CDD901B7EE7")
    @Override
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1055768811 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1055768811 = "BROWSER_COMPATIBLE";
        varB4EAC82CA7396A68D541C85D26508E83_1055768811.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1055768811;
        
        
    }

    
}

