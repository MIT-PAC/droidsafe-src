package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
public interface LockScreenWidgetInterface {

    public void setCallback(LockScreenWidgetCallback callback);

    public boolean providesClock();

}
