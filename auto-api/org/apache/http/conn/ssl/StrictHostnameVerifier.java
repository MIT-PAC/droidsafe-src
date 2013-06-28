package org.apache.http.conn.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.net.ssl.SSLException;

public class StrictHostnameVerifier extends AbstractVerifier {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.465 -0400", hash_original_method = "09E0CCDA5973A156C5A0868BB4EDD28E", hash_generated_method = "09E0CCDA5973A156C5A0868BB4EDD28E")
    public StrictHostnameVerifier ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.466 -0400", hash_original_method = "5100218414983B1148FF61DBB333F54C", hash_generated_method = "5A5067265B9F334F11805F2B6ECFACD0")
    public final void verify(
            final String host, 
            final String[] cns,
            final String[] subjectAlts) throws SSLException {
        verify(host, cns, subjectAlts, true);
        addTaint(host.getTaint());
        addTaint(cns[0].getTaint());
        addTaint(subjectAlts[0].getTaint());
        // ---------- Original Method ----------
        //verify(host, cns, subjectAlts, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.466 -0400", hash_original_method = "569003A1441E28D84E8D7679B3A1155F", hash_generated_method = "10C17C6B1862685A3D7E52A9F9827988")
    @Override
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_194112082 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_194112082 = "STRICT";
        varB4EAC82CA7396A68D541C85D26508E83_194112082.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_194112082;
        // ---------- Original Method ----------
        //return "STRICT";
    }

    
}

