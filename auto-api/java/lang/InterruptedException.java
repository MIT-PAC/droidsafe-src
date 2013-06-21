package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InterruptedException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.823 -0400", hash_original_method = "276D0C061081F968E041F3504D86F3DC", hash_generated_method = "54C005F360CF44F1F3D0FBF84E1920CD")
    @DSModeled(DSC.SAFE)
    public InterruptedException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.823 -0400", hash_original_method = "47A24B4A9D41770C1E928AFF25C6693A", hash_generated_method = "8BFDFA620DD641C42FCE8D80B94345D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InterruptedException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 6700697376100628473L;
}

