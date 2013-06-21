package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class ObjectStreamException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.162 -0400", hash_original_method = "7277EDCE895E14A1718765213C9E754B", hash_generated_method = "CD941114279F982226046C44432E1AD5")
    @DSModeled(DSC.SAFE)
    protected ObjectStreamException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.162 -0400", hash_original_method = "B5966321481D67D0B2EAAF8863CF68D1", hash_generated_method = "22C7EF4BBA3D1917D3B82DFBE528FB2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ObjectStreamException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 7260898174833392607L;
}

