package org.bouncycastle.asn1;

// Droidsafe Imports
import java.util.Date;

import droidsafe.annotations.DSGenerator;

public class ASN1GeneralizedTime extends DERGeneralizedTime {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.637 -0400", hash_original_method = "E338472F0350A218212107AE966181F8", hash_generated_method = "92369B46377A191F9351027D467581D4")
      ASN1GeneralizedTime(byte[] bytes) {
        super(bytes);
        addTaint(bytes[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.638 -0400", hash_original_method = "D40D912D80E165C0BE3CEE0F9A088081", hash_generated_method = "7C0AB32248D7DE19E3F6EFA889292ABC")
    public  ASN1GeneralizedTime(Date time) {
        super(time);
        addTaint(time.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.639 -0400", hash_original_method = "43E98C712F213D3EB238CD108159421F", hash_generated_method = "B173226B46B8F2E53BB1082120E07B2F")
    public  ASN1GeneralizedTime(String time) {
        super(time);
        addTaint(time.getTaint());
        // ---------- Original Method ----------
    }

    
}

