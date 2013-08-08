package com.google.android.gles_jni;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.microedition.khronos.egl.EGLDisplay;






public class EGLDisplayImpl extends EGLDisplay {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.517 -0400", hash_original_field = "7810D656710CDE2BFF1D12293649CFAE", hash_generated_field = "621047E76FA165F15A0AC4BEB008D4AC")

    int mEGLDisplay;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.517 -0400", hash_original_method = "B0322934834DBEC13FC1DFBB79B301E2", hash_generated_method = "EA529739750644A061A0822664F2C9E8")
    public  EGLDisplayImpl(int dpy) {
        mEGLDisplay = dpy;
        // ---------- Original Method ----------
        //mEGLDisplay = dpy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.518 -0400", hash_original_method = "08AB90584EA2F88F440B1C972613D186", hash_generated_method = "A369A87B1138B079CA13EDED5E04E060")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(this == o)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_781369425 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1370433769 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1370433769;
        }
        if(o == null || getClass() != o.getClass())        
        {
        boolean var68934A3E9455FA72420237EB05902327_1483203797 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1592274246 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1592274246;
        }
        EGLDisplayImpl that = (EGLDisplayImpl) o;
        boolean var0F8C55FAD662CB7EB23957B0EAC2D7C7_69114634 = (mEGLDisplay == that.mEGLDisplay);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_460550904 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_460550904;
        // ---------- Original Method ----------
        //if (this == o) return true;
        //if (o == null || getClass() != o.getClass()) return false;
        //EGLDisplayImpl that = (EGLDisplayImpl) o;
        //return mEGLDisplay == that.mEGLDisplay;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.519 -0400", hash_original_method = "BE5B0756D1165F3111B638ABD354FBB1", hash_generated_method = "9D68BE4926E975F3230D5429D05EF387")
    @Override
    public int hashCode() {
        int var7810D656710CDE2BFF1D12293649CFAE_1495341726 = (mEGLDisplay);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_296146476 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_296146476;
        // ---------- Original Method ----------
        //return mEGLDisplay;
    }

    
}

