package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.GeneralSecurityException;

public class InvalidParameterSpecException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.651 -0400", hash_original_method = "4F41FA7C8D97BC8BFE10106F914E22B9", hash_generated_method = "AA1B3190339FF7A757551B54F1A86973")
    public  InvalidParameterSpecException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.652 -0400", hash_original_method = "8EAE2A7FB2FA88B3FDA40537BCBC1806", hash_generated_method = "AC7D4098D3DDF51A0AD7D0E5575B2B91")
    public  InvalidParameterSpecException() {
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.652 -0400", hash_original_field = "A8CA0BAA016528B332BBA9AA6A11B1D4", hash_generated_field = "365E97F7F06D43FFB86774430C33B775")

    private static long serialVersionUID = -970468769593399342L;
}

