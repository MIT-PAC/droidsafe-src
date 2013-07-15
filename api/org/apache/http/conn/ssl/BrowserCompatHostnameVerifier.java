package org.apache.http.conn.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.net.ssl.SSLException;

public class BrowserCompatHostnameVerifier extends AbstractVerifier {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.718 -0400", hash_original_method = "F97EE270780B41C0EF5EF7526675E0EC", hash_generated_method = "F97EE270780B41C0EF5EF7526675E0EC")
    public BrowserCompatHostnameVerifier ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.718 -0400", hash_original_method = "D9F365CDBDB058C6F5810F830DF6A39F", hash_generated_method = "36EE49EF0B1D4D7CABEA5838C792DC29")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.719 -0400", hash_original_method = "94D0B9A8609089C8ED7C7100365BC140", hash_generated_method = "2098395BF7785FFD0AA4D9CCA3F99ABE")
    @Override
    public final String toString() {
String var93D67A1E1EEEED16843593CFCB51A602_832153230 =         "BROWSER_COMPATIBLE";
        var93D67A1E1EEEED16843593CFCB51A602_832153230.addTaint(taint);
        return var93D67A1E1EEEED16843593CFCB51A602_832153230;
        // ---------- Original Method ----------
        //return "BROWSER_COMPATIBLE";
    }

    
}

