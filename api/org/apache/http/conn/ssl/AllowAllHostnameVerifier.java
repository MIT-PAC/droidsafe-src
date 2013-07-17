package org.apache.http.conn.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class AllowAllHostnameVerifier extends AbstractVerifier {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.049 -0400", hash_original_method = "0CAE1F760C1CA01C015DCB961B7341AF", hash_generated_method = "0CAE1F760C1CA01C015DCB961B7341AF")
    public AllowAllHostnameVerifier ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.049 -0400", hash_original_method = "F0A4B9BAEEEE63400ECBAAB6ED04E07E", hash_generated_method = "8F65F1810A9B843577338BD52B20723D")
    public final void verify(
            final String host, 
            final String[] cns,
            final String[] subjectAlts) {
        addTaint(subjectAlts[0].getTaint());
        addTaint(cns[0].getTaint());
        addTaint(host.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.049 -0400", hash_original_method = "ED955C33EA6685325DA62D50910E36BE", hash_generated_method = "30A2B48E779BCE178934EC381C512BF7")
    @Override
    public final String toString() {
String varEF8F724A1408FE08EB256BB6C5F7C6EA_1748395555 =         "ALLOW_ALL";
        varEF8F724A1408FE08EB256BB6C5F7C6EA_1748395555.addTaint(taint);
        return varEF8F724A1408FE08EB256BB6C5F7C6EA_1748395555;
        // ---------- Original Method ----------
        //return "ALLOW_ALL";
    }

    
}

