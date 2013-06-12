package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ExecutionException extends Exception {
    private static long serialVersionUID = 7830266012832686185L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.298 -0400", hash_original_method = "CDEFB422B20894AAD6D4B957BC56ADC9", hash_generated_method = "48B24C7AB8E9F5E2DABF4031539ADBE9")
    @DSModeled(DSC.SAFE)
    protected ExecutionException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.299 -0400", hash_original_method = "7E880AEC547973941FE5E9587A1A933C", hash_generated_method = "1FFC2EB1EC20589484779638D55833E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ExecutionException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.301 -0400", hash_original_method = "8309DDE2E41584C8A0A69308778461DD", hash_generated_method = "17CFFC2122922225E57EEB02B9A0076E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExecutionException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.304 -0400", hash_original_method = "BC8973A519EF21FB8A5BD589A5BEDC19", hash_generated_method = "BEB4D7609A830294EE9458A271ED4829")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExecutionException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}


