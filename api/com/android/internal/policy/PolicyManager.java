package com.android.internal.policy;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.view.FallbackEventHandler;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManagerPolicy;
import com.android.internal.policy.IPolicy;

public final class PolicyManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.348 -0400", hash_original_method = "8280FBDEA727C0869187AB3F61DD27B1", hash_generated_method = "84C464024E5F34F099B0A60B3B8B9AAB")
    private  PolicyManager() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
    public static Window makeNewWindow(Context context) {
        return sPolicy.makeNewWindow(context);
    }

    
        @DSModeled(DSC.BAN)
    public static LayoutInflater makeNewLayoutInflater(Context context) {
        return sPolicy.makeNewLayoutInflater(context);
    }

    
        @DSModeled(DSC.BAN)
    public static WindowManagerPolicy makeNewWindowManager() {
        return sPolicy.makeNewWindowManager();
    }

    
        @DSModeled(DSC.BAN)
    public static FallbackEventHandler makeNewFallbackEventHandler(Context context) {
        return sPolicy.makeNewFallbackEventHandler(context);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.349 -0400", hash_original_field = "CC1EE3A6531AE6E81333C3C9BE207A23", hash_generated_field = "F2EC3626690C6C0CDE9F04BA5A37D39E")

    private static final String POLICY_IMPL_CLASS_NAME = "com.android.internal.policy.impl.Policy";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.349 -0400", hash_original_field = "C0FFFDB7650DF02B56107C0B1FCBC1F0", hash_generated_field = "100BB36640E39269E598568BB8ACACA8")

    private static IPolicy sPolicy;
    static {
        try {
            Class policyClass = Class.forName(POLICY_IMPL_CLASS_NAME);
            sPolicy = (IPolicy)policyClass.newInstance();
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(
                    POLICY_IMPL_CLASS_NAME + " could not be loaded", ex);
        } catch (InstantiationException ex) {
            throw new RuntimeException(
                    POLICY_IMPL_CLASS_NAME + " could not be instantiated", ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(
                    POLICY_IMPL_CLASS_NAME + " could not be instantiated", ex);
        }
    }
    
}

