package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Handler;




public class HttpAuthHandler extends Handler {

    /**
     * Package-private constructor needed for API compatibility.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.453 -0500", hash_original_method = "F01806C33F7FC6D16E466FBD9D98D7F4", hash_generated_method = "F01806C33F7FC6D16E466FBD9D98D7F4")
    
HttpAuthHandler() {
    }

    /**
     * @return True if we can use user credentials on record
     * (ie, if we did not fail trying to use them last time)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.455 -0500", hash_original_method = "F0A4AAEE1F9A8307640214EBB73E6D02", hash_generated_method = "6B541B9C4187CD3A92930DD9D326A028")
    
public boolean useHttpAuthUsernamePassword() {
        return false;
    }

    /**
     * Cancel the authorization request.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.457 -0500", hash_original_method = "E5C5DBED2FC0D18DB80484DB83D94F8A", hash_generated_method = "03D37BD64D7EA5A498C29F3157B06CA4")
    
public void cancel() {
    }

    /**
     * Proceed with the authorization with the given credentials.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.459 -0500", hash_original_method = "7B4A8A6A74B23286EE840983B92045A0", hash_generated_method = "1E4226B8F66BE4AA92E3E4C4EF7174D4")
    
public void proceed(String username, String password) {
    }

    /**
     * return true if the prompt dialog should be suppressed.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.461 -0500", hash_original_method = "22C12092B284774CBE15329CD788E924", hash_generated_method = "D95D2FA0457C8806A430432C19769447")
    
public boolean suppressDialog() {
        return false;
    }

    
}

