package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class MissingResourceException extends RuntimeException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.311 -0400", hash_original_field = "6F66E878C62DB60568A3487869695820", hash_generated_field = "CA6BE7A479C5F3E68F3687DBA3A4A48F")

    String className;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.311 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "FFE7EE17DFA37A68070A0F0495753B29")

    String key;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.311 -0400", hash_original_method = "0B71E2B2311543F4039A5E1A5B0E2A4E", hash_generated_method = "A8C3057C394CB0529420169C64D4EF1E")
    public  MissingResourceException(String detailMessage, String className,
            String resourceName) {
        super(detailMessage);
        this.className = className;
        key = resourceName;
        addTaint(detailMessage.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.312 -0400", hash_original_method = "8415940D3A1E5651F883E391EC68DA41", hash_generated_method = "565E51378338EC67D87BE74B62B4B958")
    public String getClassName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1389940222 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1389940222 = className;
        varB4EAC82CA7396A68D541C85D26508E83_1389940222.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1389940222;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.312 -0400", hash_original_method = "C39C8C9D5BC81C2FE68967748762171F", hash_generated_method = "7985A5E37C4CF05FAA2FB521F8B20725")
    public String getKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_1481355447 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1481355447 = key;
        varB4EAC82CA7396A68D541C85D26508E83_1481355447.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1481355447;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.312 -0400", hash_original_field = "44400619BCAA2353344518B6666297C1", hash_generated_field = "31A19D95C3D0097D3CB81CFACA273934")

    private static final long serialVersionUID = -4876345176062000401L;
}

