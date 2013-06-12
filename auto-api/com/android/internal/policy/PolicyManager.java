package com.android.internal.policy;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.Context;
import android.view.FallbackEventHandler;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManagerPolicy;
import com.android.internal.policy.IPolicy;

public final class PolicyManager {
    private static final String POLICY_IMPL_CLASS_NAME =
        "com.android.internal.policy.impl.Policy";
    private static final IPolicy sPolicy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.525 -0400", hash_original_method = "8280FBDEA727C0869187AB3F61DD27B1", hash_generated_method = "C6A1CD39845664AF726DFFB9FF644396")
    @DSModeled(DSC.SAFE)
    private PolicyManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.525 -0400", hash_original_method = "DCBC085175A49CB2E870217C76A6DF60", hash_generated_method = "DB3473D95C395604C4046698F7396F98")
    public static Window makeNewWindow(Context context) {
        return sPolicy.makeNewWindow(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.525 -0400", hash_original_method = "C8800BEE4B285918304DF9AA841188D4", hash_generated_method = "8A93D2AA416BD42D854CB7B16845C528")
    public static LayoutInflater makeNewLayoutInflater(Context context) {
        return sPolicy.makeNewLayoutInflater(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.525 -0400", hash_original_method = "8ED2BEB4D404F0707648CE3290A7E37D", hash_generated_method = "3C28F6E0D0FB0BE09724EEF78AE3FC28")
    public static WindowManagerPolicy makeNewWindowManager() {
        return sPolicy.makeNewWindowManager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.525 -0400", hash_original_method = "2FC59449732FB8F4271558BE9548F773", hash_generated_method = "2F685FEDCD500870706279D01512C43E")
    public static FallbackEventHandler makeNewFallbackEventHandler(Context context) {
        return sPolicy.makeNewFallbackEventHandler(context);
    }

    
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


