package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class MissingFormatWidthException extends IllegalFormatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.306 -0400", hash_original_field = "03C7C0ACE395D80182DB07AE2C30F034", hash_generated_field = "E79B5AF8B4B7B1E184AA763B4F896620")

    private String s;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.307 -0400", hash_original_method = "3B5695383AF45988D55F3947C3C6E408", hash_generated_method = "25D3BE5C86F67B399DA6DC3C3B00CA02")
    public  MissingFormatWidthException(String s) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        this.s = s;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.307 -0400", hash_original_method = "4D96301902AD0649417B90D095E1EDFD", hash_generated_method = "155FFDE7D58CE115755D28F5B305A738")
    public String getFormatSpecifier() {
        String varB4EAC82CA7396A68D541C85D26508E83_1429950432 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1429950432 = s;
        varB4EAC82CA7396A68D541C85D26508E83_1429950432.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1429950432;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.308 -0400", hash_original_method = "0A4C8E3EAB801D8800E3A2D920D74C80", hash_generated_method = "5561D18DB695BA591E1D045B01774B3C")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_371294930 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_371294930 = s;
        varB4EAC82CA7396A68D541C85D26508E83_371294930.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_371294930;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.308 -0400", hash_original_field = "7188EA7B1AC1322298AB17D61EF9C2EB", hash_generated_field = "9262A014094776552C1DB27AFE71EDD8")

    private static final long serialVersionUID = 15560123L;
}

