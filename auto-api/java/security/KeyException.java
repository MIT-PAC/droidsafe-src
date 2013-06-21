package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class KeyException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.325 -0400", hash_original_method = "DF716A570A039E910D1B39CE7ED06D52", hash_generated_method = "E11F1461563A3939F46A292CBFDEF16D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public KeyException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.325 -0400", hash_original_method = "FF58C5A0C82C3954DB19F7723F0C2CA4", hash_generated_method = "974664EB1A4375B6CDF06EAAEE7EF681")
    @DSModeled(DSC.SAFE)
    public KeyException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.325 -0400", hash_original_method = "93F87888548BE89CB4AA687EEDB8405D", hash_generated_method = "DC5DD42F01ACCE3039B225AC2A1750A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public KeyException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.325 -0400", hash_original_method = "ED6FE96D5D1CB668863944D14AFF3EBE", hash_generated_method = "2BFF48020B54FF5A93C02D63F2DD6114")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public KeyException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -7483676942812432108L;
}

