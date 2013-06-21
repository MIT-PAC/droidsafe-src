package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NotActiveException extends ObjectStreamException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.836 -0400", hash_original_method = "04F1D3389F0C6F41AEA2935866CA7222", hash_generated_method = "071F1807AA26DA7AB825233FA3566BF3")
    @DSModeled(DSC.SAFE)
    public NotActiveException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.836 -0400", hash_original_method = "3214341FEC67E095A6821294CDC33C6B", hash_generated_method = "43DA342D3C7E60205B14C4BF9DB8B420")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NotActiveException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -3893467273049808895L;
}

