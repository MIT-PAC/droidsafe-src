package org.bouncycastle.openssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class EncryptionException extends IOException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.166 -0400", hash_original_field = "560220FC3242A805F094EDCE47F35702", hash_generated_field = "8A44E2478DCB737F0795473263737867")

    private Throwable cause;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.166 -0400", hash_original_method = "0A5225B15FFCBBF051BE0F84A5007C61", hash_generated_method = "89AC63CD9CB583D280CD505887C5F8E6")
    public  EncryptionException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.167 -0400", hash_original_method = "FE6B7F9DB7E1AFAF6DF8BCFDDE4BB303", hash_generated_method = "65C90306CBA6DE24ADE27E64687FC4CB")
    public  EncryptionException(String msg, Throwable ex) {
        super(msg);
        addTaint(msg.getTaint());
        this.cause = ex;
        // ---------- Original Method ----------
        //this.cause = ex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.167 -0400", hash_original_method = "CDBDBC1C44563A9D34649A0018341F0E", hash_generated_method = "10730FB03EA03439BEFF31994A32E11D")
    public Throwable getCause() {
Throwable var3C8F3313F49435961542E8707E527956_1444921741 =         cause;
        var3C8F3313F49435961542E8707E527956_1444921741.addTaint(taint);
        return var3C8F3313F49435961542E8707E527956_1444921741;
        // ---------- Original Method ----------
        //return cause;
    }

    
}

