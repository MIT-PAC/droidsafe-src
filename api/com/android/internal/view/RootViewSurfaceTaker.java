package com.android.internal.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.view.InputQueue;
import android.view.SurfaceHolder;

public interface RootViewSurfaceTaker {
    SurfaceHolder.Callback2 willYouTakeTheSurface();
    void setSurfaceType(int type);
    void setSurfaceFormat(int format);
    void setSurfaceKeepScreenOn(boolean keepOn);
    InputQueue.Callback willYouTakeTheInputQueue();
}
