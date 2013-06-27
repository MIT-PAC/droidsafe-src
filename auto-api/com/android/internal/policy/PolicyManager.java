package com.android.internal.policy;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.view.FallbackEventHandler;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManagerPolicy;
import com.android.internal.policy.IPolicy;

public final class PolicyManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.698 -0400", hash_original_method = "8280FBDEA727C0869187AB3F61DD27B1", hash_generated_method = "84C464024E5F34F099B0A60B3B8B9AAB")
    private  PolicyManager() {
        // ---------- Original Method ----------
    }

    
        public static Window makeNewWindow(Context context) {
        return sPolicy.makeNewWindow(context);
    }

    
        public static LayoutInflater makeNewLayoutInflater(Context context) {
        return sPolicy.makeNewLayoutInflater(context);
    }

    
        public static WindowManagerPolicy makeNewWindowManager() {
        return sPolicy.makeNewWindowManager();
    }

    
        public static FallbackEventHandler makeNewFallbackEventHandler(Context context) {
        return sPolicy.makeNewFallbackEventHandler(context);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.699 -0400", hash_original_field = "CC1EE3A6531AE6E81333C3C9BE207A23", hash_generated_field = "75FDBB2FF14EF7ED5A4443F549717B4A")

    private static String POLICY_IMPL_CLASS_NAME = "com.android.internal.policy.impl.Policy";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.699 -0400", hash_original_field = "C0FFFDB7650DF02B56107C0B1FCBC1F0", hash_generated_field = "100BB36640E39269E598568BB8ACACA8")

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

