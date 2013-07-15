package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Handler;

public class HttpAuthHandler extends Handler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.406 -0400", hash_original_method = "F01806C33F7FC6D16E466FBD9D98D7F4", hash_generated_method = "2E566D604722B596B06CFADF7A0DF69D")
      HttpAuthHandler() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.406 -0400", hash_original_method = "F0A4AAEE1F9A8307640214EBB73E6D02", hash_generated_method = "A37D1AF8CF660BC713F410FB815A3F63")
    public boolean useHttpAuthUsernamePassword() {
        boolean var68934A3E9455FA72420237EB05902327_1458804795 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_115238063 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_115238063;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.406 -0400", hash_original_method = "E5C5DBED2FC0D18DB80484DB83D94F8A", hash_generated_method = "43CBBEFF14DFE69DF0FC06DADAEF94C2")
    public void cancel() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.406 -0400", hash_original_method = "7B4A8A6A74B23286EE840983B92045A0", hash_generated_method = "F9671326ACCBE82EDA77482150FE4E88")
    public void proceed(String username, String password) {
        addTaint(password.getTaint());
        addTaint(username.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.406 -0400", hash_original_method = "22C12092B284774CBE15329CD788E924", hash_generated_method = "0B3EA89A42BAD529BDD38D4F4A52B813")
    public boolean suppressDialog() {
        boolean var68934A3E9455FA72420237EB05902327_488306106 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_657230384 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_657230384;
        // ---------- Original Method ----------
        //return false;
    }

    
}

