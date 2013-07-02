package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.Serializable;

public class IllegalFormatFlagsException extends IllegalFormatException implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.494 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "656D592B6CD40AFAB0AF81166CB40D7D")

    private String flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.496 -0400", hash_original_method = "C96D31C6D500DFB377940B671202C076", hash_generated_method = "3B17226C123A0FE86042234CA3B334F9")
    public  IllegalFormatFlagsException(String flags) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        this.flags = flags;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.498 -0400", hash_original_method = "29D28F2D87A5BF440E9E6F54EB537F58", hash_generated_method = "9F30592ABC32DB8D137CFD56F2401051")
    public String getFlags() {
        String varB4EAC82CA7396A68D541C85D26508E83_1548245408 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1548245408 = flags;
        varB4EAC82CA7396A68D541C85D26508E83_1548245408.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1548245408;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.500 -0400", hash_original_method = "EC94AFCF80AA730DDC49A1A93BB12591", hash_generated_method = "987F6E6525D537864E07D94F5D2D43DC")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1892661076 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1892661076 = flags;
        varB4EAC82CA7396A68D541C85D26508E83_1892661076.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1892661076;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.500 -0400", hash_original_field = "86A01FCBD1242EE1360CD6FC32283E2D", hash_generated_field = "3B223E7F26C32E3992CEACF94EAB3E33")

    private static final long serialVersionUID = 790824L;
}

