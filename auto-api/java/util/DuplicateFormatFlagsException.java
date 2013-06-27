package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class DuplicateFormatFlagsException extends IllegalFormatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.348 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "656D592B6CD40AFAB0AF81166CB40D7D")

    private String flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.349 -0400", hash_original_method = "BC09E00DC83FE8523846524A935EDBC5", hash_generated_method = "A5A0D70E0425751665E82F1122974124")
    public  DuplicateFormatFlagsException(String f) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        flags = f;
        // ---------- Original Method ----------
        //if (f == null) {
            //throw new NullPointerException();
        //}
        //flags = f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.350 -0400", hash_original_method = "29D28F2D87A5BF440E9E6F54EB537F58", hash_generated_method = "134F5DF239312EE678BD635037F3FE73")
    public String getFlags() {
        String varB4EAC82CA7396A68D541C85D26508E83_1471641239 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1471641239 = flags;
        varB4EAC82CA7396A68D541C85D26508E83_1471641239.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1471641239;
        // ---------- Original Method ----------
        //return flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.351 -0400", hash_original_method = "EC94AFCF80AA730DDC49A1A93BB12591", hash_generated_method = "6ECB502F72209E31EAFC23B59335A593")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_903470614 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_903470614 = flags;
        varB4EAC82CA7396A68D541C85D26508E83_903470614.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_903470614;
        // ---------- Original Method ----------
        //return flags;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.351 -0400", hash_original_field = "F993B819FAAC7CCE6A9417B26EF9DEB5", hash_generated_field = "A79C4417939FEACFF408B4580DA891D8")

    private static long serialVersionUID = 18890531L;
}

