package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class MissingFormatWidthException extends IllegalFormatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.493 -0400", hash_original_field = "03C7C0ACE395D80182DB07AE2C30F034", hash_generated_field = "E79B5AF8B4B7B1E184AA763B4F896620")

    private String s;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.494 -0400", hash_original_method = "3B5695383AF45988D55F3947C3C6E408", hash_generated_method = "25D3BE5C86F67B399DA6DC3C3B00CA02")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.495 -0400", hash_original_method = "4D96301902AD0649417B90D095E1EDFD", hash_generated_method = "9384B7EBBCDE1229AEB3C11A2E5665F8")
    public String getFormatSpecifier() {
        String varB4EAC82CA7396A68D541C85D26508E83_296231155 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_296231155 = s;
        varB4EAC82CA7396A68D541C85D26508E83_296231155.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_296231155;
        // ---------- Original Method ----------
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.495 -0400", hash_original_method = "0A4C8E3EAB801D8800E3A2D920D74C80", hash_generated_method = "DD3C906CEA5BD872CABC3B0A91503F17")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_2063067788 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2063067788 = s;
        varB4EAC82CA7396A68D541C85D26508E83_2063067788.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2063067788;
        // ---------- Original Method ----------
        //return s;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.506 -0400", hash_original_field = "7188EA7B1AC1322298AB17D61EF9C2EB", hash_generated_field = "C3EC99C9391F3C09F34AC9F5E1E4E110")

    private static long serialVersionUID = 15560123L;
}

