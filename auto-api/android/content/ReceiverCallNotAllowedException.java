package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.AndroidRuntimeException;

public class ReceiverCallNotAllowedException extends AndroidRuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.075 -0400", hash_original_method = "AFC9E27B420303F62AF3B362BCC79465", hash_generated_method = "0771A4417FC2632EF7786E771A288DD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ReceiverCallNotAllowedException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
}

