package android.os;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.util.AndroidRuntimeException;


public class BadParcelableException extends AndroidRuntimeException {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.631 -0400", hash_original_method = "C5F204DF0C7D13038C37380E12FE2000", hash_generated_method = "C802EF04DBA8C90829659895F82096CB")
    public  BadParcelableException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.632 -0400", hash_original_method = "9DC5C45DC709D8D31247431851AD50BB", hash_generated_method = "4B76F68CF70A2CF87D720023015AA6F7")
    public  BadParcelableException(Exception cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
}

