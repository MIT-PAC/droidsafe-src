package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class DuplicateFormatFlagsException extends IllegalFormatException {
    private String flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.925 -0400", hash_original_method = "BC09E00DC83FE8523846524A935EDBC5", hash_generated_method = "7486BD070F7F1DAAEA7F712750570260")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DuplicateFormatFlagsException(String f) {
        dsTaint.addTaint(f);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (f == null) {
            //throw new NullPointerException();
        //}
        //flags = f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.925 -0400", hash_original_method = "29D28F2D87A5BF440E9E6F54EB537F58", hash_generated_method = "7570BA69939A55FF6B4B60DC0BFA75A9")
    @DSModeled(DSC.SAFE)
    public String getFlags() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.925 -0400", hash_original_method = "EC94AFCF80AA730DDC49A1A93BB12591", hash_generated_method = "D7A038F52EEC0AAB32B5A3856FF0B5B8")
    @DSModeled(DSC.SAFE)
    @Override
    public String getMessage() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return flags;
    }

    
    private static final long serialVersionUID = 18890531L;
}

