package com.google.android.gles_jni;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL;






public class EGLContextImpl extends EGLContext {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.508 -0400", hash_original_field = "D7E7ACB5ECFA445D75634DE4F4EA8BB0", hash_generated_field = "1753C0D2BD5296C308BB3830FFA0D688")

    private GLImpl mGLContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.508 -0400", hash_original_field = "52E1B276FFEE4F71607C40EFA3B550E4", hash_generated_field = "3DAFF8299804F9171A0188AA3FAD9E2C")

    int mEGLContext;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.509 -0400", hash_original_method = "FEF1413AB5716E2F3C8722DC6F3C138C", hash_generated_method = "6F759B313A4FF8D0425A40E2FEC2A0FE")
    public  EGLContextImpl(int ctx) {
        mEGLContext = ctx;
        mGLContext = new GLImpl();
        // ---------- Original Method ----------
        //mEGLContext = ctx;
        //mGLContext = new GLImpl();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.509 -0400", hash_original_method = "128F5F8CB79090E8F4914FDDEA205182", hash_generated_method = "9F9E630A9965E7A16FE2C6F4303A3823")
    @Override
    public GL getGL() {
GL var70A52609CF58EAE7203DCD79F70642FE_1688549917 =         mGLContext;
        var70A52609CF58EAE7203DCD79F70642FE_1688549917.addTaint(taint);
        return var70A52609CF58EAE7203DCD79F70642FE_1688549917;
        // ---------- Original Method ----------
        //return mGLContext;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.510 -0400", hash_original_method = "BBF69D7F309BD2893B1B10431DBDEB60", hash_generated_method = "8CDD525A04B0315B860AE03F9092186C")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(this == o)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_842253237 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_93873489 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_93873489;
        }
        if(o == null || getClass() != o.getClass())        
        {
        boolean var68934A3E9455FA72420237EB05902327_736967598 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_954743090 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_954743090;
        }
        EGLContextImpl that = (EGLContextImpl) o;
        boolean varC748B22ABBEB419443EA05B169460A2E_486184342 = (mEGLContext == that.mEGLContext);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_785155606 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_785155606;
        // ---------- Original Method ----------
        //if (this == o) return true;
        //if (o == null || getClass() != o.getClass()) return false;
        //EGLContextImpl that = (EGLContextImpl) o;
        //return mEGLContext == that.mEGLContext;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.510 -0400", hash_original_method = "64133BD5554848E690D4A8A4234F010E", hash_generated_method = "B390748E6CC777349A6EB86EF6096B51")
    @Override
    public int hashCode() {
        int var52E1B276FFEE4F71607C40EFA3B550E4_1883138272 = (mEGLContext);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1216495654 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1216495654;
        // ---------- Original Method ----------
        //return mEGLContext;
    }

    
}

