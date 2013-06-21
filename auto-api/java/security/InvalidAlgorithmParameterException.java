package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InvalidAlgorithmParameterException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.321 -0400", hash_original_method = "8764EFDBF443E087329639C5F03FBF33", hash_generated_method = "64409DC90DAF7613C012F9FB18DF4A62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidAlgorithmParameterException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.321 -0400", hash_original_method = "6854FBA50B4775039731A07DEA1BCECF", hash_generated_method = "9CE5C221DF499F19CAD3BCCBE65A63A1")
    @DSModeled(DSC.SAFE)
    public InvalidAlgorithmParameterException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.321 -0400", hash_original_method = "8C1684940E5C6F60C794DE0A4727DA86", hash_generated_method = "1749481C678204E4BC52067AA82AF6E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidAlgorithmParameterException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.321 -0400", hash_original_method = "EFB1E846A63455E1688ABC4BA0B50914", hash_generated_method = "77A7B5479C10872DE122DD0A0BD94DAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidAlgorithmParameterException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 2864672297499471472L;
}

