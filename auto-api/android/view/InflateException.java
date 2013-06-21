package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InflateException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.858 -0400", hash_original_method = "0CE2909AE04CF0521618BA35C7B8DC0B", hash_generated_method = "C46C6AA9FCB10C2CE22351751CFC9C73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InflateException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.859 -0400", hash_original_method = "AB0AD772D96202B15FD464EB44BD1183", hash_generated_method = "0B5389CDAE17FE05CEDFEC54ED00F899")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InflateException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
        dsTaint.addTaint(throwable.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.859 -0400", hash_original_method = "D7F4245311806265B6BE5F25BA86EF2F", hash_generated_method = "AD4BA062AB8F8765F0E03BEE3D97D9CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InflateException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.859 -0400", hash_original_method = "D6B4BD85C2EC6AC3FF7C8DC3F1D9D2C5", hash_generated_method = "7B989CB8488729989C7D6D34F06C0D95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InflateException(Throwable throwable) {
        super(throwable);
        dsTaint.addTaint(throwable.dsTaint);
        // ---------- Original Method ----------
    }

    
}

