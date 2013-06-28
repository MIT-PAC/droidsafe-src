package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class UnknownFormatConversionException extends IllegalFormatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.663 -0400", hash_original_field = "03C7C0ACE395D80182DB07AE2C30F034", hash_generated_field = "E79B5AF8B4B7B1E184AA763B4F896620")

    private String s;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.664 -0400", hash_original_method = "0FB4C71CADE23BA4642C2B1DAECF427B", hash_generated_method = "C8642D177F78782F09FA75B07B876E59")
    public  UnknownFormatConversionException(String s) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.666 -0400", hash_original_method = "F42E87FF5499AB643BB7E67C5DADAA6D", hash_generated_method = "DFC8C5E47BB28861C968946FA33FC778")
    public String getConversion() {
        String varB4EAC82CA7396A68D541C85D26508E83_767545227 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_767545227 = s;
        varB4EAC82CA7396A68D541C85D26508E83_767545227.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_767545227;
        // ---------- Original Method ----------
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.667 -0400", hash_original_method = "E0B7E8AB02E28C66CE17D4B71D9F5BCF", hash_generated_method = "ADD311857EC642E8A1D873966DB4EAD6")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1251472477 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1251472477 = "Conversion: " + s;
        varB4EAC82CA7396A68D541C85D26508E83_1251472477.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1251472477;
        // ---------- Original Method ----------
        //return "Conversion: " + s;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.668 -0400", hash_original_field = "08597A3199DE8E22FA177F8DC6A38F35", hash_generated_field = "3D86292F0E1219DE043B5F4188CBC598")

    private static final long serialVersionUID = 19060418L;
}

