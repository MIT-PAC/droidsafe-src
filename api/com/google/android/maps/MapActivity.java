package com.google.android.maps;
     
import droidsafe.annotations.*;     

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
     
public abstract class MapActivity extends Activity
{
    @DSModeled(DSC.SAFE)
    public MapActivity {
        
    }
    
    @DSModeled(DSC.SAFE)
    public void onCreate(Bundle paramBundle)
    {
    } 

    @DSModeled(DSC.SAFE)
    public abstract boolean isRouteDisplayed();

    @DSModeled(DSC.SAFE)
    public boolean isLocationDisplayed() { 
        return true;
    } 

    @DSModeled(DSC.SAFE)
    public int onGetMapDataSource() { 
        return 0;
    }
}
