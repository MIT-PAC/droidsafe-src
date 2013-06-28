package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class MissingFormatArgumentException extends IllegalFormatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.301 -0400", hash_original_field = "03C7C0ACE395D80182DB07AE2C30F034", hash_generated_field = "E79B5AF8B4B7B1E184AA763B4F896620")

    private String s;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.301 -0400", hash_original_method = "3488C8E98AE00375533889C559694B58", hash_generated_method = "05BDAD6B25CFB781020E7F99C5A22A80")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.301 -0400", hash_original_method = "4D96301902AD0649417B90D095E1EDFD", hash_generated_method = "837CA02747E2F1B1DF0D7E86786E193E")
    public String getFormatSpecifier() {
        String varB4EAC82CA7396A68D541C85D26508E83_1011159558 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1011159558 = s;
        varB4EAC82CA7396A68D541C85D26508E83_1011159558.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1011159558;
        // ---------- Original Method ----------
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.302 -0400", hash_original_method = "D7277B29886D06334EB30606D08F78F5", hash_generated_method = "82202B56DBAE5FB9A009E011E77B9E34")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_942516788 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_942516788 = "Format specifier: " + s;
        varB4EAC82CA7396A68D541C85D26508E83_942516788.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_942516788;
        // ---------- Original Method ----------
        //return "Format specifier: " + s;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.302 -0400", hash_original_field = "5CFDCAB17DD67C461A9D1585416DE0E6", hash_generated_field = "723F192E88250AAFAAB75AB9339AECE3")

    private static final long serialVersionUID = 19190115L;
}

