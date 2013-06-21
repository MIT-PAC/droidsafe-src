package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ClassFormatError extends LinkageError {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.636 -0400", hash_original_method = "425CA80A6692859A51AA327ECCF27B34", hash_generated_method = "BF82F7972D435F9EE4D71CA7D0625D1F")
    @DSModeled(DSC.SAFE)
    public ClassFormatError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.636 -0400", hash_original_method = "BAE3B13B354B16D7CAA986D0ECE3EF81", hash_generated_method = "3940BB67713C52522716C74A5DB75605")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ClassFormatError(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -8420114879011949195L;
}

