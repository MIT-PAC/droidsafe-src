package android.opengl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class GLException extends RuntimeException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.675 -0400", hash_original_field = "6F8A455C94CBB7A00E920835C0C8964C", hash_generated_field = "BB66FAE275666C5D20DD4B0D1C60B29B")

    private int mError;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.675 -0400", hash_original_method = "96DB8331E14285058E25E6A757999905", hash_generated_method = "8817BEE8B1FD83BF9A81AAEB44786CFD")
    public  GLException(final int error) {
        super(getErrorString(error));
        mError = error;
        // ---------- Original Method ----------
        //mError = error;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.676 -0400", hash_original_method = "A636DB5B62EC5D4719489ECE76BDA6F0", hash_generated_method = "B9A54DA43E2FF78984AE8A384AF78FBE")
    public  GLException(final int error, final String string) {
        super(string);
        addTaint(string.getTaint());
        mError = error;
        // ---------- Original Method ----------
        //mError = error;
    }

    
        @DSModeled(DSC.SAFE)
    private static String getErrorString(int error) {
        String errorString = GLU.gluErrorString(error);
        if ( errorString == null ) {
            errorString = "Unknown error 0x" + Integer.toHexString(error);
        }
        return errorString;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.676 -0400", hash_original_method = "C8251C577CC610BBB512FB097A387252", hash_generated_method = "E9CB1908C20D232E7270208AEFB7876C")
     int getError() {
        int var6F8A455C94CBB7A00E920835C0C8964C_6371545 = (mError);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_265058453 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_265058453;
        // ---------- Original Method ----------
        //return mError;
    }

    
}

