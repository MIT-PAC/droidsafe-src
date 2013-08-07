package android.content;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.res.Configuration;

public interface ComponentCallbacks {
    
    void onConfigurationChanged(Configuration newConfig);
    
    
    void onLowMemory();
}
