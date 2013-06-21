package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InvalidKeyException extends KeyException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.322 -0400", hash_original_method = "BC12CDCCA39AEA87BF36441977671D95", hash_generated_method = "1290FC7D1E7710FD57FD6EF1A3ACB4AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidKeyException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.322 -0400", hash_original_method = "4C9DBAC0C74B6F235E7CED5E494EF3EA", hash_generated_method = "92C65BC824CFB76E11B7AB2CF746507A")
    @DSModeled(DSC.SAFE)
    public InvalidKeyException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.323 -0400", hash_original_method = "F48B209D0258F085C8D5998E4F2F8DB1", hash_generated_method = "1DB3FB57EF7360D3C129F723975728B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidKeyException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.323 -0400", hash_original_method = "F8B65E52926150DDFBD4B64691704A27", hash_generated_method = "350E38FBD35AB0009AB0567DC0A9790C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidKeyException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 5698479920593359816L;
}

