package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public class IllegalFormatFlagsException extends IllegalFormatException implements Serializable {
    private String flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.490 -0400", hash_original_method = "C96D31C6D500DFB377940B671202C076", hash_generated_method = "B026AB41934C935F9F6587622D32314A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IllegalFormatFlagsException(String flags) {
        dsTaint.addTaint(flags);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (flags == null) {
            //throw new NullPointerException();
        //}
        //this.flags = flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.490 -0400", hash_original_method = "29D28F2D87A5BF440E9E6F54EB537F58", hash_generated_method = "7570BA69939A55FF6B4B60DC0BFA75A9")
    @DSModeled(DSC.SAFE)
    public String getFlags() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.490 -0400", hash_original_method = "EC94AFCF80AA730DDC49A1A93BB12591", hash_generated_method = "D7A038F52EEC0AAB32B5A3856FF0B5B8")
    @DSModeled(DSC.SAFE)
    @Override
    public String getMessage() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return flags;
    }

    
    private static final long serialVersionUID = 790824L;
}

