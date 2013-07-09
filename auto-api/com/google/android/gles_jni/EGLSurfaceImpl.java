package com.google.android.gles_jni;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.microedition.khronos.egl.*;

public class EGLSurfaceImpl extends EGLSurface {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.423 -0400", hash_original_field = "3DC8CA11CDD01EA82F28251758139AEE", hash_generated_field = "296DD015E00E19A6AFBFBEA67F8ACDA3")

    int mEGLSurface;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.423 -0400", hash_original_field = "84A5293844ED914C29A49CB1899ECF8B", hash_generated_field = "76B5871A33DA54FE461481FECA9BEAF0")

    private int mNativePixelRef;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.423 -0400", hash_original_method = "86437EA058F070B58780D104343F6F45", hash_generated_method = "BD3D140B3EACB46D78F5FF7C9D82DC7F")
    public  EGLSurfaceImpl() {
        mEGLSurface = 0;
        mNativePixelRef = 0;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.424 -0400", hash_original_method = "547A9AA0BBA76A5D7ACA46BEF8F827CB", hash_generated_method = "5F6E2499529C43EEA5E7AD98D02539E6")
    public  EGLSurfaceImpl(int surface) {
        mEGLSurface = surface;
        mNativePixelRef = 0;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.424 -0400", hash_original_method = "686C2DC893E9E8D9D02295779AC83C23", hash_generated_method = "5D2E1D0024AE504A3F539AFB658C8790")
    @Override
    public boolean equals(Object o) {
        {
            boolean var62E9FD43E59369C472D5FDFD656300C3_1943111443 = (o == null || getClass() != o.getClass());
        } 
        EGLSurfaceImpl that = (EGLSurfaceImpl) o;
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1608358326 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1608358326;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.424 -0400", hash_original_method = "688B514F649E9FC55EF131746A1254F0", hash_generated_method = "C87468A291A99A0C5420D91B6C367CC3")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1559506902 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1559506902;
        
        
    }

    
}

