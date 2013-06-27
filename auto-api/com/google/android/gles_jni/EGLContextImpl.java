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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.097 -0400", hash_original_field = "D7E7ACB5ECFA445D75634DE4F4EA8BB0", hash_generated_field = "1753C0D2BD5296C308BB3830FFA0D688")

    private GLImpl mGLContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.097 -0400", hash_original_field = "52E1B276FFEE4F71607C40EFA3B550E4", hash_generated_field = "3DAFF8299804F9171A0188AA3FAD9E2C")

    int mEGLContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.097 -0400", hash_original_method = "FEF1413AB5716E2F3C8722DC6F3C138C", hash_generated_method = "6F759B313A4FF8D0425A40E2FEC2A0FE")
    public  EGLContextImpl(int ctx) {
        mEGLContext = ctx;
        mGLContext = new GLImpl();
        // ---------- Original Method ----------
        //mEGLContext = ctx;
        //mGLContext = new GLImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.097 -0400", hash_original_method = "128F5F8CB79090E8F4914FDDEA205182", hash_generated_method = "BD73DCCC2E0C698F864704A2FC19D1AA")
    @Override
    public GL getGL() {
        GL varB4EAC82CA7396A68D541C85D26508E83_44784112 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_44784112 = mGLContext;
        varB4EAC82CA7396A68D541C85D26508E83_44784112.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_44784112;
        // ---------- Original Method ----------
        //return mGLContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.098 -0400", hash_original_method = "BBF69D7F309BD2893B1B10431DBDEB60", hash_generated_method = "A982603BFC7924A3EDED1ACB8EB56E68")
    @Override
    public boolean equals(Object o) {
        {
            boolean var62E9FD43E59369C472D5FDFD656300C3_1369887169 = (o == null || getClass() != o.getClass());
        } //End collapsed parenthetic
        EGLContextImpl that;
        that = (EGLContextImpl) o;
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1176482847 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1176482847;
        // ---------- Original Method ----------
        //if (this == o) return true;
        //if (o == null || getClass() != o.getClass()) return false;
        //EGLContextImpl that = (EGLContextImpl) o;
        //return mEGLContext == that.mEGLContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.098 -0400", hash_original_method = "64133BD5554848E690D4A8A4234F010E", hash_generated_method = "64657B5C24E6A5351534FC09F618DCA7")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2131744651 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2131744651;
        // ---------- Original Method ----------
        //return mEGLContext;
    }

    
}

