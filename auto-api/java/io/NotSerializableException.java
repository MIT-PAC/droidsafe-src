package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class NotSerializableException extends ObjectStreamException {
    private static final long serialVersionUID = 2906642554793891381L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.485 -0400", hash_original_method = "F05776C79D2C056D2A5E9037EDB03920", hash_generated_method = "9867EA15DAEF39FECA6AC8930DB08DBA")
    @DSModeled(DSC.SAFE)
    public NotSerializableException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.485 -0400", hash_original_method = "AC41FE5CB653485B7C55102BD4EBFA1E", hash_generated_method = "6721E002FDC4CA5A7F87E2200C96552E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NotSerializableException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


