package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InvalidAlgorithmParameterException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.945 -0400", hash_original_method = "8764EFDBF443E087329639C5F03FBF33", hash_generated_method = "5DF56D1501CD987FB1390B6B6CCD656F")
    public  InvalidAlgorithmParameterException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.945 -0400", hash_original_method = "6854FBA50B4775039731A07DEA1BCECF", hash_generated_method = "9CE5C221DF499F19CAD3BCCBE65A63A1")
    public  InvalidAlgorithmParameterException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.945 -0400", hash_original_method = "8C1684940E5C6F60C794DE0A4727DA86", hash_generated_method = "0CE7DC2CF0CB1E069BA91A00007774A1")
    public  InvalidAlgorithmParameterException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.958 -0400", hash_original_method = "EFB1E846A63455E1688ABC4BA0B50914", hash_generated_method = "1DB0C48373D9306EB59D85F885E37D65")
    public  InvalidAlgorithmParameterException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.958 -0400", hash_original_field = "CCB05FED8E3C65D52DD0FFD5504FE2A2", hash_generated_field = "0B46F69609EBF2E83B6390E830433A99")

    private static long serialVersionUID = 2864672297499471472L;
}

