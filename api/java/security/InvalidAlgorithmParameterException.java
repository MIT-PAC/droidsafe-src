package java.security;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class InvalidAlgorithmParameterException extends GeneralSecurityException {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.847 -0400", hash_original_method = "8764EFDBF443E087329639C5F03FBF33", hash_generated_method = "5DF56D1501CD987FB1390B6B6CCD656F")
    public  InvalidAlgorithmParameterException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.847 -0400", hash_original_method = "6854FBA50B4775039731A07DEA1BCECF", hash_generated_method = "9CE5C221DF499F19CAD3BCCBE65A63A1")
    public  InvalidAlgorithmParameterException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.847 -0400", hash_original_method = "8C1684940E5C6F60C794DE0A4727DA86", hash_generated_method = "0DF13A5510FE4686E46DD3586E6C5959")
    public  InvalidAlgorithmParameterException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.848 -0400", hash_original_method = "EFB1E846A63455E1688ABC4BA0B50914", hash_generated_method = "1DB0C48373D9306EB59D85F885E37D65")
    public  InvalidAlgorithmParameterException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.848 -0400", hash_original_field = "CCB05FED8E3C65D52DD0FFD5504FE2A2", hash_generated_field = "860F70BF4B332299464A61D7F7CDE3BE")

    private static final long serialVersionUID = 2864672297499471472L;
}

