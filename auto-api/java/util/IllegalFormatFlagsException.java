package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public class IllegalFormatFlagsException extends IllegalFormatException implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.126 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "656D592B6CD40AFAB0AF81166CB40D7D")

    private String flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.127 -0400", hash_original_method = "C96D31C6D500DFB377940B671202C076", hash_generated_method = "3B17226C123A0FE86042234CA3B334F9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.127 -0400", hash_original_method = "29D28F2D87A5BF440E9E6F54EB537F58", hash_generated_method = "A8F2B8C07221FBA5DBCC57DDFA3895AD")
    public String getFlags() {
        String varB4EAC82CA7396A68D541C85D26508E83_406757483 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_406757483 = flags;
        varB4EAC82CA7396A68D541C85D26508E83_406757483.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_406757483;
        // ---------- Original Method ----------
        //return flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.128 -0400", hash_original_method = "EC94AFCF80AA730DDC49A1A93BB12591", hash_generated_method = "62E03CEB7BF18D5F28AC145FC0E94061")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1007431523 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1007431523 = flags;
        varB4EAC82CA7396A68D541C85D26508E83_1007431523.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1007431523;
        // ---------- Original Method ----------
        //return flags;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.128 -0400", hash_original_field = "86A01FCBD1242EE1360CD6FC32283E2D", hash_generated_field = "72337A7B868AEFD8EB4E63E65BFFACEE")

    private static long serialVersionUID = 790824L;
}

