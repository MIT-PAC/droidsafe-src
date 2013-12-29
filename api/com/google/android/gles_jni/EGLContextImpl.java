package com.google.android.gles_jni;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL;






public class EGLContextImpl extends EGLContext {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.415 -0500", hash_original_field = "10175383E59D6C3A32BFD1FFB183EA20", hash_generated_field = "1753C0D2BD5296C308BB3830FFA0D688")

    private GLImpl mGLContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.416 -0500", hash_original_field = "3DAFF8299804F9171A0188AA3FAD9E2C", hash_generated_field = "3DAFF8299804F9171A0188AA3FAD9E2C")

    int mEGLContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.417 -0500", hash_original_method = "FEF1413AB5716E2F3C8722DC6F3C138C", hash_generated_method = "49431909C3BFF6880BA0C278707F348C")
    public EGLContextImpl(int ctx) {
        mEGLContext = ctx;
        mGLContext = new GLImpl();
    }
 
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.418 -0500", hash_original_method = "128F5F8CB79090E8F4914FDDEA205182", hash_generated_method = "3A3307A1C5AFA7A42119E9C3BC08F29E")
    @Override
public GL getGL() {
        return mGLContext;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.419 -0500", hash_original_method = "BBF69D7F309BD2893B1B10431DBDEB60", hash_generated_method = "451D87C3A7E4627D0D30A7C5DCEFFB0D")
    @Override
public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EGLContextImpl that = (EGLContextImpl) o;

        return mEGLContext == that.mEGLContext;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.419 -0500", hash_original_method = "64133BD5554848E690D4A8A4234F010E", hash_generated_method = "BF745D86327796CAAB4A576B9C63877F")
    @Override
public int hashCode() {
        return mEGLContext;
    }

    
}

