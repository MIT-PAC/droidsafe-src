package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.view.View;
public interface LockScreenWidgetCallback {
    
    
    public void requestShow(View self);

    
    public void requestHide(View self);

    
    public boolean isVisible(View self);

    
    
    public void userActivity(View self);

}
