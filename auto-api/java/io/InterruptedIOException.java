package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InterruptedIOException extends IOException {
    public int bytesTransferred;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.832 -0400", hash_original_method = "BB9DACD07ED93D41347C3772C10021CB", hash_generated_method = "83F36F7416CDB5F5500CC88912367489")
    @DSModeled(DSC.SAFE)
    public InterruptedIOException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.832 -0400", hash_original_method = "9DCF8CB18681541ED5194D8FB0295B7F", hash_generated_method = "2611298A3D7A8AC733A0596884E0F4DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InterruptedIOException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.832 -0400", hash_original_method = "4976F1F97DF8BBE1F3AC7D56299FEDE9", hash_generated_method = "EC7CCA4E9AC822776143E807D645CDED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InterruptedIOException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 4020568460727500567L;
}

