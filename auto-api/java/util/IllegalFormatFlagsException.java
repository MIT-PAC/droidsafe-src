package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public class IllegalFormatFlagsException extends IllegalFormatException implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.051 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "656D592B6CD40AFAB0AF81166CB40D7D")

    private String flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.052 -0400", hash_original_method = "C96D31C6D500DFB377940B671202C076", hash_generated_method = "3B17226C123A0FE86042234CA3B334F9")
    public  IllegalFormatFlagsException(String flags) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        this.flags = flags;
        // ---------- Original Method ----------
        //if (flags == null) {
            //throw new NullPointerException();
        //}
        //this.flags = flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.053 -0400", hash_original_method = "29D28F2D87A5BF440E9E6F54EB537F58", hash_generated_method = "13446F90896EC65A850CB8AB0349DBCD")
    public String getFlags() {
        String varB4EAC82CA7396A68D541C85D26508E83_403867156 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_403867156 = flags;
        varB4EAC82CA7396A68D541C85D26508E83_403867156.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_403867156;
        // ---------- Original Method ----------
        //return flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.054 -0400", hash_original_method = "EC94AFCF80AA730DDC49A1A93BB12591", hash_generated_method = "48910C609B495463AE726092CBED084D")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_527726023 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_527726023 = flags;
        varB4EAC82CA7396A68D541C85D26508E83_527726023.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_527726023;
        // ---------- Original Method ----------
        //return flags;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.054 -0400", hash_original_field = "86A01FCBD1242EE1360CD6FC32283E2D", hash_generated_field = "72337A7B868AEFD8EB4E63E65BFFACEE")

    private static long serialVersionUID = 790824L;
}

