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
    private GLImpl mGLContext;
    int mEGLContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.140 -0400", hash_original_method = "FEF1413AB5716E2F3C8722DC6F3C138C", hash_generated_method = "84C902B4DB880E454F3FF733B1B7A11F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EGLContextImpl(int ctx) {
        dsTaint.addTaint(ctx);
        mGLContext = new GLImpl();
        // ---------- Original Method ----------
        //mEGLContext = ctx;
        //mGLContext = new GLImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.140 -0400", hash_original_method = "128F5F8CB79090E8F4914FDDEA205182", hash_generated_method = "ED0542DE8D335A0AC17521833CE589AC")
    @DSModeled(DSC.SAFE)
    @Override
    public GL getGL() {
        return (GL)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mGLContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.141 -0400", hash_original_method = "BBF69D7F309BD2893B1B10431DBDEB60", hash_generated_method = "E1931FFB07CAEFCD7098A4976EECF38D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var62E9FD43E59369C472D5FDFD656300C3_4468598 = (o == null || getClass() != o.getClass());
        } //End collapsed parenthetic
        EGLContextImpl that;
        that = (EGLContextImpl) o;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (this == o) return true;
        //if (o == null || getClass() != o.getClass()) return false;
        //EGLContextImpl that = (EGLContextImpl) o;
        //return mEGLContext == that.mEGLContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.141 -0400", hash_original_method = "64133BD5554848E690D4A8A4234F010E", hash_generated_method = "2C0E67D331A1C5EAE6FCC5C64585A0B5")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mEGLContext;
    }

    
}

