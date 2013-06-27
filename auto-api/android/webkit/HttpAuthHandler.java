package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Handler;

public class HttpAuthHandler extends Handler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.718 -0400", hash_original_method = "F01806C33F7FC6D16E466FBD9D98D7F4", hash_generated_method = "2E566D604722B596B06CFADF7A0DF69D")
      HttpAuthHandler() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.719 -0400", hash_original_method = "F0A4AAEE1F9A8307640214EBB73E6D02", hash_generated_method = "52BB145189215E6A0C4489D9D673BCE1")
    public boolean useHttpAuthUsernamePassword() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1922413629 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1922413629;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.719 -0400", hash_original_method = "E5C5DBED2FC0D18DB80484DB83D94F8A", hash_generated_method = "43CBBEFF14DFE69DF0FC06DADAEF94C2")
    public void cancel() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.719 -0400", hash_original_method = "7B4A8A6A74B23286EE840983B92045A0", hash_generated_method = "A2D3EDA049ED9F901CF5FA7A9C36BD5C")
    public void proceed(String username, String password) {
        addTaint(username.getTaint());
        addTaint(password.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.720 -0400", hash_original_method = "22C12092B284774CBE15329CD788E924", hash_generated_method = "29D1B3913888EC73E4D26FC4BAEB97F4")
    public boolean suppressDialog() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1218291758 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1218291758;
        // ---------- Original Method ----------
        //return false;
    }

    
}

