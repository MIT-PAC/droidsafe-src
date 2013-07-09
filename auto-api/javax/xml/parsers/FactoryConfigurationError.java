package javax.xml.parsers;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class FactoryConfigurationError extends Error {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.685 -0400", hash_original_field = "42552B1F133F9F8EB406D4F306EA9FD1", hash_generated_field = "70BD42A5533D521458BB067703B0D3E8")

    private Exception exception;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.686 -0400", hash_original_method = "6620C9D65D7B9B8AED04F1E2286BE37D", hash_generated_method = "3197EEE679B539DCD98F16DC71478ECF")
    public  FactoryConfigurationError() {
        this.exception = null;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.686 -0400", hash_original_method = "48F1E682C4A714972A38A39D612B5275", hash_generated_method = "9DC941C2231A2F72CA371472EF0C1DF4")
    public  FactoryConfigurationError(String msg) {
        super(msg);
        this.exception = null;
        addTaint(msg.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.686 -0400", hash_original_method = "50F0E936640865FC69642EB9E9B7DACD", hash_generated_method = "DECEA99A83213F9667E844B2E4FA90A5")
    public  FactoryConfigurationError(Exception e) {
        super(e.toString());
        this.exception = e;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.686 -0400", hash_original_method = "6DA0E2DE853AFE92CEEE23D7625EA5CB", hash_generated_method = "71461E7E24A718322463F62D96ED3685")
    public  FactoryConfigurationError(Exception e, String msg) {
        super(msg);
        this.exception = e;
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.687 -0400", hash_original_method = "3CFCD04CF304E9364ADFC7DBDB377B80", hash_generated_method = "E405A951310032F6D07C2D696943562A")
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1071142025 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1013164721 = null; 
        String message = super.getMessage ();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1071142025 = exception.getMessage();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1013164721 = message;
        String varA7E53CE21691AB073D9660D615818899_991331977; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_991331977 = varB4EAC82CA7396A68D541C85D26508E83_1071142025;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_991331977 = varB4EAC82CA7396A68D541C85D26508E83_1013164721;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_991331977.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_991331977;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.687 -0400", hash_original_method = "DEACD8BC5F5C015493740DB375DC8E7E", hash_generated_method = "86951BCD0057D83C1A0F0327D511DC6F")
    public Exception getException() {
        Exception varB4EAC82CA7396A68D541C85D26508E83_765876701 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_765876701 = exception;
        varB4EAC82CA7396A68D541C85D26508E83_765876701.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_765876701;
        
        
    }

    
}

