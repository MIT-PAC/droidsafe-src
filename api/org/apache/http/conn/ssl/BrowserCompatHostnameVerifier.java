package org.apache.http.conn.ssl;

// Droidsafe Imports
import javax.net.ssl.SSLException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class BrowserCompatHostnameVerifier extends AbstractVerifier {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.054 -0400", hash_original_method = "F97EE270780B41C0EF5EF7526675E0EC", hash_generated_method = "F97EE270780B41C0EF5EF7526675E0EC")
    public BrowserCompatHostnameVerifier ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.055 -0400", hash_original_method = "D9F365CDBDB058C6F5810F830DF6A39F", hash_generated_method = "36EE49EF0B1D4D7CABEA5838C792DC29")
    public final void verify(
            final String host, 
            final String[] cns,
            final String[] subjectAlts) throws SSLException {
        addTaint(subjectAlts[0].getTaint());
        addTaint(cns[0].getTaint());
        addTaint(host.getTaint());
        verify(host, cns, subjectAlts, false);
        // ---------- Original Method ----------
        //verify(host, cns, subjectAlts, false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.055 -0400", hash_original_method = "94D0B9A8609089C8ED7C7100365BC140", hash_generated_method = "E5AD7C18D4E1F25D66578CB53964DD39")
    @Override
    public final String toString() {
String var93D67A1E1EEEED16843593CFCB51A602_1706337829 =         "BROWSER_COMPATIBLE";
        var93D67A1E1EEEED16843593CFCB51A602_1706337829.addTaint(taint);
        return var93D67A1E1EEEED16843593CFCB51A602_1706337829;
        // ---------- Original Method ----------
        //return "BROWSER_COMPATIBLE";
    }

    
}

