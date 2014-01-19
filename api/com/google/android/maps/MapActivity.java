package com.google.android.maps;
     
import droidsafe.annotations.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
     
public abstract class MapActivity extends Activity
{
    
    public MapActivity() {
        
    }
    
    public void onCreate(Bundle paramBundle)
    {
    }
    
    public abstract boolean isRouteDisplayed();
    
    public boolean isLocationDisplayed() { 
        return true;
    }
    
    public int onGetMapDataSource() { 
        return 0;
    }
}
