package com.google.android.gles_jni;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.microedition.khronos.egl.*;

public class EGLSurfaceImpl extends EGLSurface {
    int mEGLSurface;
    private int mNativePixelRef;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.156 -0400", hash_original_method = "86437EA058F070B58780D104343F6F45", hash_generated_method = "BD3D140B3EACB46D78F5FF7C9D82DC7F")
    @DSModeled(DSC.SAFE)
    public EGLSurfaceImpl() {
        mEGLSurface = 0;
        mNativePixelRef = 0;
        // ---------- Original Method ----------
        //mEGLSurface = 0;
        //mNativePixelRef = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.156 -0400", hash_original_method = "547A9AA0BBA76A5D7ACA46BEF8F827CB", hash_generated_method = "C7F15D79C55B6122DB24FF7E301CA3C5")
    @DSModeled(DSC.SAFE)
    public EGLSurfaceImpl(int surface) {
        dsTaint.addTaint(surface);
        mNativePixelRef = 0;
        // ---------- Original Method ----------
        //mEGLSurface = surface;
        //mNativePixelRef = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.156 -0400", hash_original_method = "686C2DC893E9E8D9D02295779AC83C23", hash_generated_method = "ED4414C54EF1CA763F8EFCC38032B895")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var62E9FD43E59369C472D5FDFD656300C3_1227146265 = (o == null || getClass() != o.getClass());
        } //End collapsed parenthetic
        EGLSurfaceImpl that;
        that = (EGLSurfaceImpl) o;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (this == o) return true;
        //if (o == null || getClass() != o.getClass()) return false;
        //EGLSurfaceImpl that = (EGLSurfaceImpl) o;
        //return mEGLSurface == that.mEGLSurface;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.156 -0400", hash_original_method = "688B514F649E9FC55EF131746A1254F0", hash_generated_method = "5DBB1BA7DFBCDCBB3C417340F619FAFA")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mEGLSurface;
    }

    
}

