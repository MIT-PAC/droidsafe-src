package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.res.Configuration;

public interface ComponentCallbacks {
    
    void onConfigurationChanged(Configuration newConfig);
    
    
    void onLowMemory();
}
