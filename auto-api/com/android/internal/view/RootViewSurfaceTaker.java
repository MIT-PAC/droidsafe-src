package com.android.internal.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.view.InputQueue;
import android.view.SurfaceHolder;

public interface RootViewSurfaceTaker {
    SurfaceHolder.Callback2 willYouTakeTheSurface();
    void setSurfaceType(int type);
    void setSurfaceFormat(int format);
    void setSurfaceKeepScreenOn(boolean keepOn);
    InputQueue.Callback willYouTakeTheInputQueue();
}

