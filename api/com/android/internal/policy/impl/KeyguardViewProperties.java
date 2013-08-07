package com.android.internal.policy.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
public interface KeyguardViewProperties {
    
    
    KeyguardViewBase createKeyguardView(Context context,
            KeyguardUpdateMonitor updateMonitor,
            KeyguardWindowController controller);

    
    boolean isSecure();

}
