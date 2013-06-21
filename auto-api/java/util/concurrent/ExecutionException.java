package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ExecutionException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.520 -0400", hash_original_method = "CDEFB422B20894AAD6D4B957BC56ADC9", hash_generated_method = "B804448C05909A7FECF05F6D5D7041FB")
    @DSModeled(DSC.SAFE)
    protected ExecutionException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.521 -0400", hash_original_method = "7E880AEC547973941FE5E9587A1A933C", hash_generated_method = "E4CF492F8188F8678CFE62B5190028EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ExecutionException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.521 -0400", hash_original_method = "8309DDE2E41584C8A0A69308778461DD", hash_generated_method = "100936E391A19A964E58B21DC8D9A90B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExecutionException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.521 -0400", hash_original_method = "BC8973A519EF21FB8A5BD589A5BEDC19", hash_generated_method = "F6FC9CCEBB85148EA6DB97D40E104E08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExecutionException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 7830266012832686185L;
}

