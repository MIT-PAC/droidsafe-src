package org.bouncycastle.util.io.pem;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class PemGenerationException extends IOException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.571 -0400", hash_original_field = "560220FC3242A805F094EDCE47F35702", hash_generated_field = "8A44E2478DCB737F0795473263737867")

    private Throwable cause;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.572 -0400", hash_original_method = "33CBECFB76FE1092AA2D14F5073D46BE", hash_generated_method = "074F245D9099ACC736945C9657EFD245")
    public  PemGenerationException(String message, Throwable cause) {
        super(message);
        addTaint(message.getTaint());
        this.cause = cause;
        // ---------- Original Method ----------
        //this.cause = cause;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.572 -0400", hash_original_method = "80C2BF6F9B17521430AAD5FD6B82B847", hash_generated_method = "5993872145D4D76F61D45E0082C701F8")
    public  PemGenerationException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.572 -0400", hash_original_method = "CDBDBC1C44563A9D34649A0018341F0E", hash_generated_method = "BB3AB256E70F36B414C982F913F11BF7")
    public Throwable getCause() {
Throwable var3C8F3313F49435961542E8707E527956_1807289271 =         cause;
        var3C8F3313F49435961542E8707E527956_1807289271.addTaint(taint);
        return var3C8F3313F49435961542E8707E527956_1807289271;
        // ---------- Original Method ----------
        //return cause;
    }

    
}

