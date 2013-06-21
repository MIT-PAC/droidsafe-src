package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NotSerializableException extends ObjectStreamException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.837 -0400", hash_original_method = "F05776C79D2C056D2A5E9037EDB03920", hash_generated_method = "E3071F25014A23D137F4E1B852E7E0CA")
    @DSModeled(DSC.SAFE)
    public NotSerializableException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.837 -0400", hash_original_method = "AC41FE5CB653485B7C55102BD4EBFA1E", hash_generated_method = "8EED6EB76F7A68DED7E96C243E4F1600")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NotSerializableException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 2906642554793891381L;
}

