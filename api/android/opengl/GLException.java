package android.opengl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class GLException extends RuntimeException {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:18.931 -0500", hash_original_method = "70D71069ED1C0794F70343277F638981", hash_generated_method = "CB8C377E0DF34CCBD41BCA54F9CBF50D")
    
private static String getErrorString(int error) {
        String errorString = GLU.gluErrorString(error);
        if ( errorString == null ) {
            errorString = "Unknown error 0x" + Integer.toHexString(error);
        }
        return errorString;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:18.936 -0500", hash_original_field = "D2AED7D977A2A2ED656875F0DA3F43ED", hash_generated_field = "BB66FAE275666C5D20DD4B0D1C60B29B")

    private  int mError;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:18.925 -0500", hash_original_method = "96DB8331E14285058E25E6A757999905", hash_generated_method = "648A451FB8895F6FEC1A1E3557D1DEE5")
    
public GLException(final int error) {
        super(getErrorString(error));
        mError = error;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:18.928 -0500", hash_original_method = "A636DB5B62EC5D4719489ECE76BDA6F0", hash_generated_method = "12E6D000EA7CD85FAA00E0D3687C57AB")
    
public GLException(final int error, final String string) {
        super(string);
        mError = error;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:18.933 -0500", hash_original_method = "C8251C577CC610BBB512FB097A387252", hash_generated_method = "C8251C577CC610BBB512FB097A387252")
    
int getError() {
        return mError;
    }
    
}

