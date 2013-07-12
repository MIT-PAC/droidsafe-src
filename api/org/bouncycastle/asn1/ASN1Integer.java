package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;

public class ASN1Integer extends DERInteger {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.593 -0400", hash_original_method = "613C01CE307AF3B490E97733AD3FE791", hash_generated_method = "8C56D999A6DB1489F51C87683DD07921")
      ASN1Integer(byte[] bytes) {
        super(bytes);
        addTaint(bytes[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.594 -0400", hash_original_method = "CB189D129CFECCC017D2178A0D362A4E", hash_generated_method = "D6AF97F113FD38DEB79493155B1B1093")
    public  ASN1Integer(BigInteger value) {
        super(value);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.594 -0400", hash_original_method = "DB40B6D8EC54F98D809A693D20FD592A", hash_generated_method = "41FD5C1046351249DF53BE0A41ED1F42")
    public  ASN1Integer(int value) {
        super(value);
        addTaint(value);
        // ---------- Original Method ----------
    }

    
}

