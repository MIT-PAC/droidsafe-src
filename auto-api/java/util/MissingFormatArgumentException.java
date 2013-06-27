package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class MissingFormatArgumentException extends IllegalFormatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.557 -0400", hash_original_field = "03C7C0ACE395D80182DB07AE2C30F034", hash_generated_field = "E79B5AF8B4B7B1E184AA763B4F896620")

    private String s;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.558 -0400", hash_original_method = "3488C8E98AE00375533889C559694B58", hash_generated_method = "05BDAD6B25CFB781020E7F99C5A22A80")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.558 -0400", hash_original_method = "4D96301902AD0649417B90D095E1EDFD", hash_generated_method = "1F7457D57C1C925949CD400861F57643")
    public String getFormatSpecifier() {
        String varB4EAC82CA7396A68D541C85D26508E83_1374906095 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1374906095 = s;
        varB4EAC82CA7396A68D541C85D26508E83_1374906095.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1374906095;
        // ---------- Original Method ----------
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.559 -0400", hash_original_method = "D7277B29886D06334EB30606D08F78F5", hash_generated_method = "E74AB4CDF2F98E692BADC7F9FE0BAACD")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1718587421 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1718587421 = "Format specifier: " + s;
        varB4EAC82CA7396A68D541C85D26508E83_1718587421.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1718587421;
        // ---------- Original Method ----------
        //return "Format specifier: " + s;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.559 -0400", hash_original_field = "5CFDCAB17DD67C461A9D1585416DE0E6", hash_generated_field = "F0073F190D43AC8E9AC02BE02086149E")

    private static long serialVersionUID = 19190115L;
}

