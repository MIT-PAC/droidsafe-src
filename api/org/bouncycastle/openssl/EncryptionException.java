package org.bouncycastle.openssl;

// Droidsafe Imports
import java.io.IOException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class EncryptionException extends IOException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.936 -0400", hash_original_field = "560220FC3242A805F094EDCE47F35702", hash_generated_field = "8A44E2478DCB737F0795473263737867")

    private Throwable cause;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.937 -0400", hash_original_method = "0A5225B15FFCBBF051BE0F84A5007C61", hash_generated_method = "89AC63CD9CB583D280CD505887C5F8E6")
    public  EncryptionException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.937 -0400", hash_original_method = "FE6B7F9DB7E1AFAF6DF8BCFDDE4BB303", hash_generated_method = "65C90306CBA6DE24ADE27E64687FC4CB")
    public  EncryptionException(String msg, Throwable ex) {
        super(msg);
        addTaint(msg.getTaint());
        this.cause = ex;
        // ---------- Original Method ----------
        //this.cause = ex;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.937 -0400", hash_original_method = "CDBDBC1C44563A9D34649A0018341F0E", hash_generated_method = "37352261EC5A7732DB181F3AD283D046")
    public Throwable getCause() {
Throwable var3C8F3313F49435961542E8707E527956_349722216 =         cause;
        var3C8F3313F49435961542E8707E527956_349722216.addTaint(taint);
        return var3C8F3313F49435961542E8707E527956_349722216;
        // ---------- Original Method ----------
        //return cause;
    }

    
}

