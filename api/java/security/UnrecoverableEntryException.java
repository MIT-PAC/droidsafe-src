package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class UnrecoverableEntryException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.575 -0400", hash_original_method = "B211A6D1B8B83310D4292B140A3F159B", hash_generated_method = "2CFD6E9360722DF4615CD31ABBF0A51F")
    public  UnrecoverableEntryException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.575 -0400", hash_original_method = "41796CE6161E063E42FAB82830727D9B", hash_generated_method = "35A783454723AA1848D2CF3145087B07")
    public  UnrecoverableEntryException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.575 -0400", hash_original_field = "34A4A51DDDAC81BB3D1DB7D2D9D2D6BF", hash_generated_field = "E52F3B815AA00A4F940616D4AF17B9B4")

    private static final long serialVersionUID = -4527142945246286535L;
}

