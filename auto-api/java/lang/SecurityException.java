package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class SecurityException extends RuntimeException {
    private static final long serialVersionUID = 6878364983674394167L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.433 -0400", hash_original_method = "0D8A79337436926212C4E8DACFE6A955", hash_generated_method = "9E3207859BA602D47912BC31E259D120")
    @DSModeled(DSC.SAFE)
    public SecurityException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.435 -0400", hash_original_method = "35201AC9E2F0540A3FCA08DB4F71F2A3", hash_generated_method = "559B1609212F4911FC2FF24947044DA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SecurityException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.437 -0400", hash_original_method = "6D3B8DD6DA516F6B2B4EBB83E8379AAA", hash_generated_method = "11AFE05129F25AB06F9641BF992225EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SecurityException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.440 -0400", hash_original_method = "B0CE861A38AC7D57FFFB507001C97872", hash_generated_method = "AB4BEAB94A69FA1017CC33209407C229")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SecurityException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}


