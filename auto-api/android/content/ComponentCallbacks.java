package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.res.Configuration;

public interface ComponentCallbacks {
    
    void onConfigurationChanged(Configuration newConfig);
    
    
    void onLowMemory();
}

