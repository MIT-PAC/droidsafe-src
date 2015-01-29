package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.util.AndroidRuntimeException;

public class ReceiverCallNotAllowedException extends AndroidRuntimeException {
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.033 -0500", hash_original_method = "AFC9E27B420303F62AF3B362BCC79465", hash_generated_method = "3CDAE1CDDDF39179E3ADEC992381A67E")
    
public ReceiverCallNotAllowedException(String msg) {
        super(msg);
    }
    
}

