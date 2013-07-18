package org.bouncycastle.asn1;

// Droidsafe Imports
import java.io.IOException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ASN1Exception extends IOException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.625 -0400", hash_original_field = "560220FC3242A805F094EDCE47F35702", hash_generated_field = "8A44E2478DCB737F0795473263737867")

    private Throwable cause;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.625 -0400", hash_original_method = "723A1DBA8406751CA0BE121F0D1A9151", hash_generated_method = "BCDB967B921E585F1BBFBFA3FF4A327F")
      ASN1Exception(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.626 -0400", hash_original_method = "D17952479D481E219D9ED9BCF5D089F2", hash_generated_method = "A42143679E619BFC86FDBC3D77526F40")
      ASN1Exception(String message, Throwable cause) {
        super(message);
        addTaint(message.getTaint());
        this.cause = cause;
        // ---------- Original Method ----------
        //this.cause = cause;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.626 -0400", hash_original_method = "CDBDBC1C44563A9D34649A0018341F0E", hash_generated_method = "C4ED6EC913F51512383B9FE0A4AA29AF")
    public Throwable getCause() {
Throwable var3C8F3313F49435961542E8707E527956_992248299 =         cause;
        var3C8F3313F49435961542E8707E527956_992248299.addTaint(taint);
        return var3C8F3313F49435961542E8707E527956_992248299;
        // ---------- Original Method ----------
        //return cause;
    }

    
}

