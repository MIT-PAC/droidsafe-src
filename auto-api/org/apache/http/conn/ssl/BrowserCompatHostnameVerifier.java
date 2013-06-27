package org.apache.http.conn.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.net.ssl.SSLException;

public class BrowserCompatHostnameVerifier extends AbstractVerifier {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.537 -0400", hash_original_method = "F97EE270780B41C0EF5EF7526675E0EC", hash_generated_method = "F97EE270780B41C0EF5EF7526675E0EC")
    public BrowserCompatHostnameVerifier ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.538 -0400", hash_original_method = "D9F365CDBDB058C6F5810F830DF6A39F", hash_generated_method = "86BAA43C236ABB3B4C4CAD5333E7CE42")
    public final void verify(
            final String host, 
            final String[] cns,
            final String[] subjectAlts) throws SSLException {
        verify(host, cns, subjectAlts, false);
        addTaint(host.getTaint());
        addTaint(cns[0].getTaint());
        addTaint(subjectAlts[0].getTaint());
        // ---------- Original Method ----------
        //verify(host, cns, subjectAlts, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.539 -0400", hash_original_method = "94D0B9A8609089C8ED7C7100365BC140", hash_generated_method = "3CCDB7009DF3326F630CDDCC5629B2FD")
    @Override
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1066874774 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1066874774 = "BROWSER_COMPATIBLE";
        varB4EAC82CA7396A68D541C85D26508E83_1066874774.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1066874774;
        // ---------- Original Method ----------
        //return "BROWSER_COMPATIBLE";
    }

    
}

