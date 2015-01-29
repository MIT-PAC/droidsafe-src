package com.google.android.gles_jni;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.microedition.khronos.egl.EGLDisplay;

public class EGLDisplayImpl extends EGLDisplay {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.249 -0500", hash_original_field = "621047E76FA165F15A0AC4BEB008D4AC", hash_generated_field = "621047E76FA165F15A0AC4BEB008D4AC")

    int mEGLDisplay;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.252 -0500", hash_original_method = "B0322934834DBEC13FC1DFBB79B301E2", hash_generated_method = "2B1ADD4A0CA5F1CC07CC61B7ECAD718C")
    
public EGLDisplayImpl(int dpy) {
        mEGLDisplay = dpy;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.255 -0500", hash_original_method = "08AB90584EA2F88F440B1C972613D186", hash_generated_method = "BC3C5E989EEC0AA898E50CD15915EC69")
    
@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EGLDisplayImpl that = (EGLDisplayImpl) o;

        return mEGLDisplay == that.mEGLDisplay;

    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.258 -0500", hash_original_method = "BE5B0756D1165F3111B638ABD354FBB1", hash_generated_method = "8BAF5946958461CB79B5D5A996B2A4F5")
    
@Override
    public int hashCode() {
        return mEGLDisplay;
    }
    
}

