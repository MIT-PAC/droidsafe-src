package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Shader {
    public int native_instance;
    public int native_shader;
    private Matrix mLocalMatrix;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.809 -0400", hash_original_method = "96DFF47832C9B64761F91421D35D3DC0", hash_generated_method = "96DFF47832C9B64761F91421D35D3DC0")
        public Shader ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.810 -0400", hash_original_method = "68EE3A19E97B552C55745306F03EBBEA", hash_generated_method = "EC54758F7AE7878B11F4C1562E28FD0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getLocalMatrix(Matrix localM) {
        dsTaint.addTaint(localM.dsTaint);
        {
            localM.set(mLocalMatrix);
            boolean varB38993D6AEB90B988AB61A4C363EDC6E_98489968 = (!mLocalMatrix.isIdentity());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mLocalMatrix != null) {
            //localM.set(mLocalMatrix);
            //return !mLocalMatrix.isIdentity();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.810 -0400", hash_original_method = "D9D7C5F09B6958B88F23796DCADEE0F6", hash_generated_method = "FA36735CD994B121197CC1CC635AACBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLocalMatrix(Matrix localM) {
        dsTaint.addTaint(localM.dsTaint);
        nativeSetLocalMatrix(native_instance, native_shader,
                localM == null ? 0 : localM.native_instance);
        // ---------- Original Method ----------
        //mLocalMatrix = localM;
        //nativeSetLocalMatrix(native_instance, native_shader,
                //localM == null ? 0 : localM.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.810 -0400", hash_original_method = "C66C3B2CF2D4E3C25A1D8C5724E65539", hash_generated_method = "82D789A5FB22E6C4C0B20EAD25E7E744")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
        private static void nativeDestructor(int native_shader, int native_skiaShader) {
    }

    
        private static void nativeSetLocalMatrix(int native_shader,
            int native_skiaShader, int matrix_instance) {
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

