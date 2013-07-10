package com.android.internal.policy;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.view.FallbackEventHandler;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManagerPolicy;

public interface IPolicy {
    public Window makeNewWindow(Context context);

    public LayoutInflater makeNewLayoutInflater(Context context);

    public WindowManagerPolicy makeNewWindowManager();

    public FallbackEventHandler makeNewFallbackEventHandler(Context context);
}
