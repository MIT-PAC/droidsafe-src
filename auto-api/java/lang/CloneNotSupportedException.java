package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class CloneNotSupportedException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.657 -0400", hash_original_method = "3D71496D40C645B60B1C6E10AB3776C0", hash_generated_method = "D990718C59BDF04A949966C4F9976823")
    @DSModeled(DSC.SAFE)
    public CloneNotSupportedException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.657 -0400", hash_original_method = "19F2DAFDEBBAFFF27428A0FB57B58023", hash_generated_method = "E1FA9AA55B6A01950DBD7DA36B9E47B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CloneNotSupportedException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 5195511250079656443L;
}

