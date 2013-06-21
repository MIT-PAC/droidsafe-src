package com.google.android.gles_jni;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.microedition.khronos.egl.*;

public class EGLDisplayImpl extends EGLDisplay {
    int mEGLDisplay;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.143 -0400", hash_original_method = "B0322934834DBEC13FC1DFBB79B301E2", hash_generated_method = "054E9FD12E2AA45E4CBB1C1176EEB02D")
    @DSModeled(DSC.SAFE)
    public EGLDisplayImpl(int dpy) {
        dsTaint.addTaint(dpy);
        // ---------- Original Method ----------
        //mEGLDisplay = dpy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.143 -0400", hash_original_method = "08AB90584EA2F88F440B1C972613D186", hash_generated_method = "90A84C26A0962E0FD1702FDC2D70068C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var62E9FD43E59369C472D5FDFD656300C3_313143279 = (o == null || getClass() != o.getClass());
        } //End collapsed parenthetic
        EGLDisplayImpl that;
        that = (EGLDisplayImpl) o;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (this == o) return true;
        //if (o == null || getClass() != o.getClass()) return false;
        //EGLDisplayImpl that = (EGLDisplayImpl) o;
        //return mEGLDisplay == that.mEGLDisplay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.143 -0400", hash_original_method = "BE5B0756D1165F3111B638ABD354FBB1", hash_generated_method = "C1D480DB870ACBA0A00A8AC9A5BD81EA")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mEGLDisplay;
    }

    
}

