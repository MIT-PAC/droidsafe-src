package com.android.internal.policy.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
public interface KeyguardViewCallback {

    
    void pokeWakelock();

    
    void pokeWakelock(int millis);

    
    void keyguardDone(boolean authenticated);

    
    void keyguardDoneDrawing();
}
