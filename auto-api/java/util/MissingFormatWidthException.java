package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class MissingFormatWidthException extends IllegalFormatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.570 -0400", hash_original_field = "03C7C0ACE395D80182DB07AE2C30F034", hash_generated_field = "E79B5AF8B4B7B1E184AA763B4F896620")

    private String s;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.572 -0400", hash_original_method = "3B5695383AF45988D55F3947C3C6E408", hash_generated_method = "25D3BE5C86F67B399DA6DC3C3B00CA02")
    public  MissingFormatWidthException(String s) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        this.s = s;
        // ---------- Original Method ----------
        //if (s == null) {
            //throw new NullPointerException();
        //}
        //this.s = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.572 -0400", hash_original_method = "4D96301902AD0649417B90D095E1EDFD", hash_generated_method = "0747A60809ADA647B76425F125DF860F")
    public String getFormatSpecifier() {
        String varB4EAC82CA7396A68D541C85D26508E83_1791804274 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1791804274 = s;
        varB4EAC82CA7396A68D541C85D26508E83_1791804274.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1791804274;
        // ---------- Original Method ----------
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.573 -0400", hash_original_method = "0A4C8E3EAB801D8800E3A2D920D74C80", hash_generated_method = "532827F9201D7FC6EC23FDB5695E9084")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_474215817 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_474215817 = s;
        varB4EAC82CA7396A68D541C85D26508E83_474215817.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_474215817;
        // ---------- Original Method ----------
        //return s;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.573 -0400", hash_original_field = "7188EA7B1AC1322298AB17D61EF9C2EB", hash_generated_field = "C3EC99C9391F3C09F34AC9F5E1E4E110")

    private static long serialVersionUID = 15560123L;
}

