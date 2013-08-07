package android.support.v4.app;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.util.AndroidRuntimeException;


final class SuperNotCalledException extends AndroidRuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.706 -0400", hash_original_method = "5E7B9B2805F37099E5240CEF94D75E86", hash_generated_method = "15811A6DE9C2E964B99F6377F947BD45")
    public  SuperNotCalledException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
}

