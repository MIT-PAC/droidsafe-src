package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IllegalStateException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.743 -0400", hash_original_method = "A3FE636ADA4040CA4955BB4251C76DAB", hash_generated_method = "4CD9063F55FB314B76AC101B41C0985A")
    @DSModeled(DSC.SAFE)
    public IllegalStateException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.743 -0400", hash_original_method = "F14466412D9BB118D44B7BD1FD4B4021", hash_generated_method = "E316592F844346E4C875B3FD4066FDC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IllegalStateException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.743 -0400", hash_original_method = "6F3B5205BA771B0DF92BD44831C586ED", hash_generated_method = "68419F66A8D8407939F1CCC21DD9CB9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IllegalStateException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.743 -0400", hash_original_method = "6DC0580FE34F314D6F80EBAA4A416AA3", hash_generated_method = "250AD476BB19463FDD98176762B1EE88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IllegalStateException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -1848914673093119416L;
}

