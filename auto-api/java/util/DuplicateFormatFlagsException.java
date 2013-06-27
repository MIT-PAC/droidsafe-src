package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class DuplicateFormatFlagsException extends IllegalFormatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.217 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "656D592B6CD40AFAB0AF81166CB40D7D")

    private String flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.217 -0400", hash_original_method = "BC09E00DC83FE8523846524A935EDBC5", hash_generated_method = "A5A0D70E0425751665E82F1122974124")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.218 -0400", hash_original_method = "29D28F2D87A5BF440E9E6F54EB537F58", hash_generated_method = "60AF0A071C1B4BE373EBACEB2047812C")
    public String getFlags() {
        String varB4EAC82CA7396A68D541C85D26508E83_1747577571 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1747577571 = flags;
        varB4EAC82CA7396A68D541C85D26508E83_1747577571.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1747577571;
        // ---------- Original Method ----------
        //return flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.225 -0400", hash_original_method = "EC94AFCF80AA730DDC49A1A93BB12591", hash_generated_method = "1F484629ED4E64E32A42C5F42F5CC500")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1185899089 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1185899089 = flags;
        varB4EAC82CA7396A68D541C85D26508E83_1185899089.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1185899089;
        // ---------- Original Method ----------
        //return flags;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.225 -0400", hash_original_field = "F993B819FAAC7CCE6A9417B26EF9DEB5", hash_generated_field = "A79C4417939FEACFF408B4580DA891D8")

    private static long serialVersionUID = 18890531L;
}

