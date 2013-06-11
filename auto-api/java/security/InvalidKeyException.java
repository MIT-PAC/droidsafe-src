package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class InvalidKeyException extends KeyException {
    private static final long serialVersionUID = 5698479920593359816L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.605 -0400", hash_original_method = "BC12CDCCA39AEA87BF36441977671D95", hash_generated_method = "8EFC96F4ACF481491A0E1748A00E24A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidKeyException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.605 -0400", hash_original_method = "4C9DBAC0C74B6F235E7CED5E494EF3EA", hash_generated_method = "66620CFF2A0B6B022C64B4CF5884CCFB")
    @DSModeled(DSC.SAFE)
    public InvalidKeyException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.605 -0400", hash_original_method = "F48B209D0258F085C8D5998E4F2F8DB1", hash_generated_method = "CFF3718479174B74B16E9492576EBD74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidKeyException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.605 -0400", hash_original_method = "F8B65E52926150DDFBD4B64691704A27", hash_generated_method = "1B3C3412F9366E0BB4CDC7BE062C8ADF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidKeyException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}


