package com.android.internal.policy.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.res.Configuration;
public interface KeyguardScreenCallback extends KeyguardViewCallback {

    
    void goToLockScreen();

    
    void goToUnlockScreen();

    
    void forgotPattern(boolean isForgotten);

    
    boolean isSecure();

    
    boolean isVerifyUnlockOnly();

    
    void recreateMe(Configuration config);

    
    void takeEmergencyCallAction();

    
    void reportFailedUnlockAttempt();

    
    void reportSuccessfulUnlockAttempt();

    
    boolean doesFallbackUnlockScreenExist();
}
