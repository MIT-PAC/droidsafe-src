package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class Shader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.118 -0400", hash_original_field = "7E2E7BFEC42581BDE25254C4BB512478", hash_generated_field = "368FA2DC569BFE75826F8A8AC6BD5246")

    public int native_instance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.118 -0400", hash_original_field = "C4EFF82583D27E302AF9FECF38C7E6F9", hash_generated_field = "0DB9AF0E0B134D090C8683C8A774B2B7")

    public int native_shader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.118 -0400", hash_original_field = "5368047125C607842548DD927A77A3F7", hash_generated_field = "D6800221AFA66D0081A0E98544EF5A6A")

    private Matrix mLocalMatrix;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.118 -0400", hash_original_method = "2C9D5C9CBFF528B332FC0D9B3274B66B", hash_generated_method = "2C9D5C9CBFF528B332FC0D9B3274B66B")
    public Shader ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.119 -0400", hash_original_method = "68EE3A19E97B552C55745306F03EBBEA", hash_generated_method = "C3547C7E16CFD74B785634F576A40D25")
    public boolean getLocalMatrix(Matrix localM) {
        addTaint(localM.getTaint());
        if(mLocalMatrix != null)        
        {
            localM.set(mLocalMatrix);
            boolean var6352B8263992DBA38A71A4089C8DBF2D_1600920817 = (!mLocalMatrix.isIdentity());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_694589298 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_694589298;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_59064036 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1732491027 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1732491027;
        // ---------- Original Method ----------
        //if (mLocalMatrix != null) {
            //localM.set(mLocalMatrix);
            //return !mLocalMatrix.isIdentity();
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.120 -0400", hash_original_method = "D9D7C5F09B6958B88F23796DCADEE0F6", hash_generated_method = "54D857A280BC189FD9876713FE1AEB6C")
    public void setLocalMatrix(Matrix localM) {
        mLocalMatrix = localM;
        nativeSetLocalMatrix(native_instance, native_shader,
                localM == null ? 0 : localM.native_instance);
        // ---------- Original Method ----------
        //mLocalMatrix = localM;
        //nativeSetLocalMatrix(native_instance, native_shader,
                //localM == null ? 0 : localM.native_instance);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.120 -0400", hash_original_method = "C66C3B2CF2D4E3C25A1D8C5724E65539", hash_generated_method = "82D789A5FB22E6C4C0B20EAD25E7E744")
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

    
    @DSModeled(DSC.SAFE)
    private static void nativeDestructor(int native_shader, int native_skiaShader) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeSetLocalMatrix(int native_shader,
            int native_skiaShader, int matrix_instance) {
    }

    
    public enum TileMode {
        CLAMP   (0),
        REPEAT  (1),
        MIRROR  (2);
        @DSModeled(DSC.SAFE)
        TileMode(int nativeInt) {
            this.nativeInt = nativeInt;
        }
        final int nativeInt;
    }

    
}

