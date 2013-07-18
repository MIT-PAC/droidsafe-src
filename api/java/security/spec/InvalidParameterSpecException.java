package java.security.spec;

// Droidsafe Imports
import java.security.GeneralSecurityException;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class InvalidParameterSpecException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.060 -0400", hash_original_method = "4F41FA7C8D97BC8BFE10106F914E22B9", hash_generated_method = "AA1B3190339FF7A757551B54F1A86973")
    public  InvalidParameterSpecException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.060 -0400", hash_original_method = "8EAE2A7FB2FA88B3FDA40537BCBC1806", hash_generated_method = "AC7D4098D3DDF51A0AD7D0E5575B2B91")
    public  InvalidParameterSpecException() {
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.060 -0400", hash_original_field = "A8CA0BAA016528B332BBA9AA6A11B1D4", hash_generated_field = "D7B23BABA4FB334103D8F72DD98A7A49")

    private static final long serialVersionUID = -970468769593399342L;
}

