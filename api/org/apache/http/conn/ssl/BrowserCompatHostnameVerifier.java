package org.apache.http.conn.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.net.ssl.SSLException;

public class BrowserCompatHostnameVerifier extends AbstractVerifier {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.054 -0400", hash_original_method = "F97EE270780B41C0EF5EF7526675E0EC", hash_generated_method = "F97EE270780B41C0EF5EF7526675E0EC")
    public BrowserCompatHostnameVerifier ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:27.852 -0500", hash_original_method = "D9F365CDBDB058C6F5810F830DF6A39F", hash_generated_method = "2C9FA89D7947D66CE9FC6A380CD42816")
    
public final void verify(
            final String host, 
            final String[] cns,
            final String[] subjectAlts) throws SSLException {
        verify(host, cns, subjectAlts, false);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:27.854 -0500", hash_original_method = "94D0B9A8609089C8ED7C7100365BC140", hash_generated_method = "BE653C5EDDDF61D380B1C56384ED39D2")
    
@Override
    public final String toString() { 
        return "BROWSER_COMPATIBLE"; 
    }
    
}

