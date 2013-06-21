package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InvalidMarkException extends IllegalStateException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.774 -0400", hash_original_method = "B1EE027FE89EEC127536AB7DEF53C391", hash_generated_method = "02636A3D0215C600F7C165854E4FB0DC")
    @DSModeled(DSC.SAFE)
    public InvalidMarkException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.774 -0400", hash_original_method = "29531E800CAD0F117D34A6102B8A5CF9", hash_generated_method = "C187029EC8FE50A87A225F109AFF99A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidMarkException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 1698329710438510774L;
}

