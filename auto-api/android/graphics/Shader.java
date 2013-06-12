package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class Shader {
    public int native_instance;
    public int native_shader;
    private Matrix mLocalMatrix;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.467 -0400", hash_original_method = "68EE3A19E97B552C55745306F03EBBEA", hash_generated_method = "164700A72C7EBA4EEDC404295267D047")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getLocalMatrix(Matrix localM) {
        dsTaint.addTaint(localM.dsTaint);
        {
            localM.set(mLocalMatrix);
            boolean varB38993D6AEB90B988AB61A4C363EDC6E_1052573797 = (!mLocalMatrix.isIdentity());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mLocalMatrix != null) {
            //localM.set(mLocalMatrix);
            //return !mLocalMatrix.isIdentity();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.467 -0400", hash_original_method = "D9D7C5F09B6958B88F23796DCADEE0F6", hash_generated_method = "2CDCD88814469BA8F90AE1BD8CCFF8D9")
    @DSModeled(DSC.SAFE)
    public void setLocalMatrix(Matrix localM) {
        dsTaint.addTaint(localM.dsTaint);
        nativeSetLocalMatrix(native_instance, native_shader,
                localM == null ? 0 : localM.native_instance);
        // ---------- Original Method ----------
        //mLocalMatrix = localM;
        //nativeSetLocalMatrix(native_instance, native_shader,
                //localM == null ? 0 : localM.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.467 -0400", hash_original_method = "C66C3B2CF2D4E3C25A1D8C5724E65539", hash_generated_method = "385C876E26B2A56231A9F5745F7E3A53")
    @DSModeled(DSC.SAFE)
    protected void finalize() throws Throwable {
        try 
        {
            super.finalize();
        } //End block
        finally 
        {
            nativeDestructor(native_instance, native_shader);
        } //End block
        // ---------- Original Method ----------
        //try {
            //super.finalize();
        //} finally {
            //nativeDestructor(native_instance, native_shader);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.468 -0400", hash_original_method = "55B993F53B66E0FD14B900962791C0E2", hash_generated_method = "A6783B560F51EC6C434EF59C93E63729")
    private static void nativeDestructor(int native_shader, int native_skiaShader) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.468 -0400", hash_original_method = "BE49337D8B496DB91554AF126005F4EA", hash_generated_method = "73886B0F112D4399DE885C23D69E971D")
    private static void nativeSetLocalMatrix(int native_shader,
            int native_skiaShader, int matrix_instance) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    public enum TileMode {
        CLAMP   (0),
        REPEAT  (1),
        MIRROR  (2);
        TileMode(int nativeInt) {
            this.nativeInt = nativeInt;
        }
        final int nativeInt;
    }

    
}


