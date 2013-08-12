package org.apache.http.conn.ssl;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.net.ssl.SSLException;





public class StrictHostnameVerifier extends AbstractVerifier {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.096 -0400", hash_original_method = "09E0CCDA5973A156C5A0868BB4EDD28E", hash_generated_method = "09E0CCDA5973A156C5A0868BB4EDD28E")
    public StrictHostnameVerifier ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.096 -0400", hash_original_method = "5100218414983B1148FF61DBB333F54C", hash_generated_method = "0719BDD640FC8AEF630312CA3168E03B")
    public final void verify(
            final String host, 
            final String[] cns,
            final String[] subjectAlts) throws SSLException {
        addTaint(subjectAlts[0].getTaint());
        addTaint(cns[0].getTaint());
        addTaint(host.getTaint());
        verify(host, cns, subjectAlts, true);
        // ---------- Original Method ----------
        //verify(host, cns, subjectAlts, true);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.096 -0400", hash_original_method = "569003A1441E28D84E8D7679B3A1155F", hash_generated_method = "97CE429F21041DA4335BE1391DD67889")
    @Override
    public final String toString() {
String var2EA7D4FCD810EDFA63B859E28834610B_1776852799 =         "STRICT";
        var2EA7D4FCD810EDFA63B859E28834610B_1776852799.addTaint(taint);
        return var2EA7D4FCD810EDFA63B859E28834610B_1776852799;
        // ---------- Original Method ----------
        //return "STRICT";
    }

    
}

