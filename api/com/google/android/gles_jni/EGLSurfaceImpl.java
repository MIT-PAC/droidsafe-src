package com.google.android.gles_jni;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.microedition.khronos.egl.EGLSurface;






public class EGLSurfaceImpl extends EGLSurface {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.560 -0400", hash_original_field = "3DC8CA11CDD01EA82F28251758139AEE", hash_generated_field = "296DD015E00E19A6AFBFBEA67F8ACDA3")

    int mEGLSurface;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.560 -0400", hash_original_field = "84A5293844ED914C29A49CB1899ECF8B", hash_generated_field = "76B5871A33DA54FE461481FECA9BEAF0")

    private int mNativePixelRef;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.560 -0400", hash_original_method = "86437EA058F070B58780D104343F6F45", hash_generated_method = "BD3D140B3EACB46D78F5FF7C9D82DC7F")
    public  EGLSurfaceImpl() {
        mEGLSurface = 0;
        mNativePixelRef = 0;
        // ---------- Original Method ----------
        //mEGLSurface = 0;
        //mNativePixelRef = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.561 -0400", hash_original_method = "547A9AA0BBA76A5D7ACA46BEF8F827CB", hash_generated_method = "5F6E2499529C43EEA5E7AD98D02539E6")
    public  EGLSurfaceImpl(int surface) {
        mEGLSurface = surface;
        mNativePixelRef = 0;
        // ---------- Original Method ----------
        //mEGLSurface = surface;
        //mNativePixelRef = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.561 -0400", hash_original_method = "686C2DC893E9E8D9D02295779AC83C23", hash_generated_method = "25E47CAD6EAADF284D77241ECBD720CD")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(this == o)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_358932893 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1696270137 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1696270137;
        }
        if(o == null || getClass() != o.getClass())        
        {
        boolean var68934A3E9455FA72420237EB05902327_1439573577 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_415865527 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_415865527;
        }
        EGLSurfaceImpl that = (EGLSurfaceImpl) o;
        boolean var0025C9A2D992FA770BB0E4FD12D3504C_603851685 = (mEGLSurface == that.mEGLSurface);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_729474369 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_729474369;
        // ---------- Original Method ----------
        //if (this == o) return true;
        //if (o == null || getClass() != o.getClass()) return false;
        //EGLSurfaceImpl that = (EGLSurfaceImpl) o;
        //return mEGLSurface == that.mEGLSurface;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.561 -0400", hash_original_method = "688B514F649E9FC55EF131746A1254F0", hash_generated_method = "2DAEA1BE67CCAE7A9FBDC10B7E0C483C")
    @Override
    public int hashCode() {
        int var3DC8CA11CDD01EA82F28251758139AEE_1499267476 = (mEGLSurface);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1835770236 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1835770236;
        // ---------- Original Method ----------
        //return mEGLSurface;
    }

    
}

