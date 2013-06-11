package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class IllegalStateException extends RuntimeException {
    private static final long serialVersionUID = -1848914673093119416L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.147 -0400", hash_original_method = "A3FE636ADA4040CA4955BB4251C76DAB", hash_generated_method = "E12EB6526F0EDB65DDD46897F8150D94")
    @DSModeled(DSC.SAFE)
    public IllegalStateException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.153 -0400", hash_original_method = "F14466412D9BB118D44B7BD1FD4B4021", hash_generated_method = "A6E21B049669B0B12524E0DDAA3AB8B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IllegalStateException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.160 -0400", hash_original_method = "6F3B5205BA771B0DF92BD44831C586ED", hash_generated_method = "62FF33799A2C469934697CD8A6DEC5BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IllegalStateException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.164 -0400", hash_original_method = "6DC0580FE34F314D6F80EBAA4A416AA3", hash_generated_method = "122AE49396F9158F4AEB61AB12D41333")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IllegalStateException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}


