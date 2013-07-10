package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.res.Configuration;

public interface ComponentCallbacks {
    
    void onConfigurationChanged(Configuration newConfig);
    
    
    void onLowMemory();
}
