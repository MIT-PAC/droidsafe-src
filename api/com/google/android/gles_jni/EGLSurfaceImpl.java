package com.google.android.gles_jni;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.microedition.khronos.egl.EGLSurface;

public class EGLSurfaceImpl extends EGLSurface {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.658 -0500", hash_original_field = "296DD015E00E19A6AFBFBEA67F8ACDA3", hash_generated_field = "296DD015E00E19A6AFBFBEA67F8ACDA3")

    int mEGLSurface;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.660 -0500", hash_original_field = "56DA9E94FD7AA86E5CD2913D51F85F53", hash_generated_field = "76B5871A33DA54FE461481FECA9BEAF0")

    private int mNativePixelRef;
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.662 -0500", hash_original_method = "86437EA058F070B58780D104343F6F45", hash_generated_method = "0723C6460ED17317E4124F3363AEBCA3")
    
public EGLSurfaceImpl() {
        mEGLSurface = 0;
        mNativePixelRef = 0;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.665 -0500", hash_original_method = "547A9AA0BBA76A5D7ACA46BEF8F827CB", hash_generated_method = "A47E0AF19A316A6FDC2D8F6A916E1833")
    
public EGLSurfaceImpl(int surface) {
        mEGLSurface = surface;
        mNativePixelRef = 0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.667 -0500", hash_original_method = "686C2DC893E9E8D9D02295779AC83C23", hash_generated_method = "09C81E6A4BBCC1A424B9F1323BED9B21")
    
@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EGLSurfaceImpl that = (EGLSurfaceImpl) o;

        return mEGLSurface == that.mEGLSurface;

    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.670 -0500", hash_original_method = "688B514F649E9FC55EF131746A1254F0", hash_generated_method = "98A5D045BA43EF4CACB9CA9CC6FC6595")
    
@Override
    public int hashCode() {
        return mEGLSurface;
    }
    
}

