package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.AndroidRuntimeException;

public class ReceiverCallNotAllowedException extends AndroidRuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.485 -0400", hash_original_method = "AFC9E27B420303F62AF3B362BCC79465", hash_generated_method = "A9BA6CA01738F043FA6EE9601C06B57B")
    public  ReceiverCallNotAllowedException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
}

