package com.android.internal.policy.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
public interface KeyguardScreen {

    
    boolean needsInput();
    
    
    void onPause();

    
    void onResume();

    
    void cleanUp();
}
