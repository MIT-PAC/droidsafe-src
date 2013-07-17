package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public final class ASN1Exception extends IOException {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.260 -0400", hash_original_method = "723A1DBA8406751CA0BE121F0D1A9151", hash_generated_method = "CE01F166428A3E13E96ED8C85B0E8E89")
    public  ASN1Exception(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.260 -0400", hash_original_field = "95134A058288D63F526B7C8A7D6F52C0", hash_generated_field = "9B89927D92C1AFF46B5E401467B9C67F")

    private static final long serialVersionUID = -3561981263989123987L;
}

