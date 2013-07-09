package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.net.ssl.SSLException;

public class AlertException extends RuntimeException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.607 -0400", hash_original_field = "40BEA8D637CDF2C1B07FCF0630482B73", hash_generated_field = "C530EE3CBD485644D7525A400EA925B6")

    private SSLException reason;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.607 -0400", hash_original_field = "67DAF92C833C41C95DB874E18FCB2786", hash_generated_field = "970155BA799F3943C9383598DE4C30A5")

    private byte description;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.608 -0400", hash_original_method = "76164594E21D6CE99D1A0A90A760CF7A", hash_generated_method = "C31398FCD1D6FC21427CE5C9A0C803C3")
    protected  AlertException(byte description, SSLException reason) {
        super(reason);
        this.reason = reason;
        this.description = description;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.608 -0400", hash_original_method = "5B702ECC4BAE0D4CD4DED59A097CDBFC", hash_generated_method = "4BF4513777C1A6397E71EB3384BB30C5")
    protected SSLException getReason() {
        SSLException varB4EAC82CA7396A68D541C85D26508E83_384046058 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_384046058 = reason;
        varB4EAC82CA7396A68D541C85D26508E83_384046058.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_384046058;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.609 -0400", hash_original_method = "4016638ED8025AA5C043B11675AF3321", hash_generated_method = "03F94A107DDC7332BFF3B2E718D11CB1")
    protected byte getDescriptionCode() {
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1451878417 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1451878417;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.609 -0400", hash_original_field = "AA9487126D7D010735548D102ECD2BCD", hash_generated_field = "49414C5F100260BFB79C458FA4822DE5")

    private static final long serialVersionUID = -4448327177165687581L;
}

