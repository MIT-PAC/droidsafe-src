package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class MissingFormatArgumentException extends IllegalFormatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.502 -0400", hash_original_field = "03C7C0ACE395D80182DB07AE2C30F034", hash_generated_field = "E79B5AF8B4B7B1E184AA763B4F896620")

    private String s;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.503 -0400", hash_original_method = "3488C8E98AE00375533889C559694B58", hash_generated_method = "05BDAD6B25CFB781020E7F99C5A22A80")
    public  MissingFormatArgumentException(String s) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.504 -0400", hash_original_method = "4D96301902AD0649417B90D095E1EDFD", hash_generated_method = "DABC4850F82F58B07E10D56B433CE35D")
    public String getFormatSpecifier() {
        String varB4EAC82CA7396A68D541C85D26508E83_1378715284 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1378715284 = s;
        varB4EAC82CA7396A68D541C85D26508E83_1378715284.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1378715284;
        // ---------- Original Method ----------
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.504 -0400", hash_original_method = "D7277B29886D06334EB30606D08F78F5", hash_generated_method = "D7B9251731345C9B90469FB97B49FCF3")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1796097667 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1796097667 = "Format specifier: " + s;
        varB4EAC82CA7396A68D541C85D26508E83_1796097667.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1796097667;
        // ---------- Original Method ----------
        //return "Format specifier: " + s;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.504 -0400", hash_original_field = "5CFDCAB17DD67C461A9D1585416DE0E6", hash_generated_field = "F0073F190D43AC8E9AC02BE02086149E")

    private static long serialVersionUID = 19190115L;
}

