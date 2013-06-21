package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class RejectedExecutionException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.747 -0400", hash_original_method = "14BCCCC5B9E76D0C33B19F741DA19A4D", hash_generated_method = "26B0BF6D0B3DF55E6E29F8355582DEAA")
    @DSModeled(DSC.SAFE)
    public RejectedExecutionException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.747 -0400", hash_original_method = "685040D05C4255BE5A578536BCB19A2C", hash_generated_method = "F51D73BADA3BF09C532BF1CEB941F237")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RejectedExecutionException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.747 -0400", hash_original_method = "E48A8DF27205DB3C2384C43BB1BC845B", hash_generated_method = "159F891A8120F43AD58875231371FC52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RejectedExecutionException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.747 -0400", hash_original_method = "A7DCBE3F8485ADE0DEAC0A36B08B4222", hash_generated_method = "B4916E2FCDF85B0C82EF9ED0B3564912")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RejectedExecutionException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -375805702767069545L;
}

