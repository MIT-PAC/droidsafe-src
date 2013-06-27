package com.google.android.gles_jni;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.microedition.khronos.egl.*;
import javax.microedition.khronos.opengles.GL;

public class EGLContextImpl extends EGLContext {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.723 -0400", hash_original_field = "D7E7ACB5ECFA445D75634DE4F4EA8BB0", hash_generated_field = "1753C0D2BD5296C308BB3830FFA0D688")

    private GLImpl mGLContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.723 -0400", hash_original_field = "52E1B276FFEE4F71607C40EFA3B550E4", hash_generated_field = "3DAFF8299804F9171A0188AA3FAD9E2C")

    int mEGLContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.724 -0400", hash_original_method = "FEF1413AB5716E2F3C8722DC6F3C138C", hash_generated_method = "6F759B313A4FF8D0425A40E2FEC2A0FE")
    public  EGLContextImpl(int ctx) {
        mEGLContext = ctx;
        mGLContext = new GLImpl();
        // ---------- Original Method ----------
        //mEGLContext = ctx;
        //mGLContext = new GLImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.728 -0400", hash_original_method = "128F5F8CB79090E8F4914FDDEA205182", hash_generated_method = "6F7BAA689ECDF53E5B93B3DCDBB6EE58")
    @Override
    public GL getGL() {
        GL varB4EAC82CA7396A68D541C85D26508E83_641986221 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_641986221 = mGLContext;
        varB4EAC82CA7396A68D541C85D26508E83_641986221.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_641986221;
        // ---------- Original Method ----------
        //return mGLContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.728 -0400", hash_original_method = "BBF69D7F309BD2893B1B10431DBDEB60", hash_generated_method = "74186736FA3CC186CD765885372E3AD0")
    @Override
    public boolean equals(Object o) {
        {
            boolean var62E9FD43E59369C472D5FDFD656300C3_375846430 = (o == null || getClass() != o.getClass());
        } //End collapsed parenthetic
        EGLContextImpl that;
        that = (EGLContextImpl) o;
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1540608298 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1540608298;
        // ---------- Original Method ----------
        //if (this == o) return true;
        //if (o == null || getClass() != o.getClass()) return false;
        //EGLContextImpl that = (EGLContextImpl) o;
        //return mEGLContext == that.mEGLContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.728 -0400", hash_original_method = "64133BD5554848E690D4A8A4234F010E", hash_generated_method = "6F45BE4BC3D44F5B008614656604F65B")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1056445236 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1056445236;
        // ---------- Original Method ----------
        //return mEGLContext;
    }

    
}

