package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Handler;

public class HttpAuthHandler extends Handler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.368 -0400", hash_original_method = "F01806C33F7FC6D16E466FBD9D98D7F4", hash_generated_method = "2E566D604722B596B06CFADF7A0DF69D")
    @DSModeled(DSC.SAFE)
     HttpAuthHandler() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.368 -0400", hash_original_method = "F0A4AAEE1F9A8307640214EBB73E6D02", hash_generated_method = "CC3D14B2CB8EE7119B4F578B3268A391")
    @DSModeled(DSC.SAFE)
    public boolean useHttpAuthUsernamePassword() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.369 -0400", hash_original_method = "E5C5DBED2FC0D18DB80484DB83D94F8A", hash_generated_method = "43CBBEFF14DFE69DF0FC06DADAEF94C2")
    @DSModeled(DSC.SAFE)
    public void cancel() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.369 -0400", hash_original_method = "7B4A8A6A74B23286EE840983B92045A0", hash_generated_method = "D350C50E0A39F0317186DB8ED93AFCFA")
    @DSModeled(DSC.SAFE)
    public void proceed(String username, String password) {
        dsTaint.addTaint(username);
        dsTaint.addTaint(password);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.369 -0400", hash_original_method = "22C12092B284774CBE15329CD788E924", hash_generated_method = "F286ABEC9145AFAFECF9B0D75A35D800")
    @DSModeled(DSC.SAFE)
    public boolean suppressDialog() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
}

