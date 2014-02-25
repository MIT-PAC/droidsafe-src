package com.google.android.maps;
     
import droidsafe.annotations.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
     
public abstract class MapActivity extends Activity
{
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MapActivity() {
        
    }
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
    }
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public abstract boolean isRouteDisplayed();
   
    @DSVerified
    @DSSafe(DSCat.GUI)
    public boolean isLocationDisplayed() { 
        return true;
    }

    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public int onGetMapDataSource() { 
        return 0;
    }
    
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @Override
    public void droidsafeSubActivityCallbackHook() {
        onGetMapDataSource();
    }
}
