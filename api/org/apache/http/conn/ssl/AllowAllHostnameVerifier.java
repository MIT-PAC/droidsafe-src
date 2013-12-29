package org.apache.http.conn.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




public class AllowAllHostnameVerifier extends AbstractVerifier {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.049 -0400", hash_original_method = "0CAE1F760C1CA01C015DCB961B7341AF", hash_generated_method = "0CAE1F760C1CA01C015DCB961B7341AF")
    public AllowAllHostnameVerifier ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:17.539 -0500", hash_original_method = "F0A4B9BAEEEE63400ECBAAB6ED04E07E", hash_generated_method = "B419780240F37B5D2B15A83EB1D4ABE5")
    public final void verify(
            final String host, 
            final String[] cns,
            final String[] subjectAlts) {
        // Allow everything - so never blowup.
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:17.540 -0500", hash_original_method = "ED955C33EA6685325DA62D50910E36BE", hash_generated_method = "F46E6B9F9900776CDE2FF2BDA277CE4E")
    @Override
public final String toString() { 
        return "ALLOW_ALL"; 
    }

    
}

