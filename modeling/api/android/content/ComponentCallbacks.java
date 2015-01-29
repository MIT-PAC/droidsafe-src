package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.res.Configuration;

public interface ComponentCallbacks {
    

    @DSVerified("called from Application and Context")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    void onConfigurationChanged(Configuration newConfig);
    

    @DSVerified("called from Application and Context")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    void onLowMemory();
}
