package org.apache.http.conn.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.net.ssl.SSLException;

public class StrictHostnameVerifier extends AbstractVerifier {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.096 -0400", hash_original_method = "09E0CCDA5973A156C5A0868BB4EDD28E", hash_generated_method = "09E0CCDA5973A156C5A0868BB4EDD28E")
    public StrictHostnameVerifier ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:27.528 -0500", hash_original_method = "5100218414983B1148FF61DBB333F54C", hash_generated_method = "628746D95536B65FA4079118DD1F1DE2")
    
public final void verify(
            final String host, 
            final String[] cns,
            final String[] subjectAlts) throws SSLException {
        verify(host, cns, subjectAlts, true);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:27.531 -0500", hash_original_method = "569003A1441E28D84E8D7679B3A1155F", hash_generated_method = "EB681DE707B9F250A207EF0BBF8AC194")
    
@Override
    public final String toString() { 
        return "STRICT"; 
    }
    
}

