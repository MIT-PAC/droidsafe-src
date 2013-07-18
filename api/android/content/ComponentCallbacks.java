package android.content;

// Droidsafe Imports
import android.content.res.Configuration;

public interface ComponentCallbacks {
    
    void onConfigurationChanged(Configuration newConfig);
    
    
    void onLowMemory();
}
