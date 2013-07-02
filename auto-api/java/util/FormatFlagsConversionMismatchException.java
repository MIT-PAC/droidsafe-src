package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.Serializable;

public class FormatFlagsConversionMismatchException extends IllegalFormatException implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.275 -0400", hash_original_field = "8FA14CDD754F91CC6554C9E71929CCE7", hash_generated_field = "30060080FF41A1FD21A71F3606BA90A8")

    private String f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.275 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "1C2A715F26687AFA5A80889E5E367C56")

    private char c;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.275 -0400", hash_original_method = "23601B02BC801B28ADE07C396E4C34FF", hash_generated_method = "5829565AAD7B30590A70466E056F1292")
    public  FormatFlagsConversionMismatchException(String f, char c) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        this.f = f;
        this.c = c;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.275 -0400", hash_original_method = "3582970EABB5B296536802E98213C512", hash_generated_method = "30346867C0A11F8129C4F73E6C57D18E")
    public String getFlags() {
        String varB4EAC82CA7396A68D541C85D26508E83_58595478 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_58595478 = f;
        varB4EAC82CA7396A68D541C85D26508E83_58595478.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_58595478;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.276 -0400", hash_original_method = "FF899ECAAB1B8C040FEF5324FAB8D93B", hash_generated_method = "5E3FE3483D842B7A6CA51AEEA0612FBB")
    public char getConversion() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_371597137 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_371597137;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.276 -0400", hash_original_method = "767287C022ACF72AAFFBED8242F4CC5C", hash_generated_method = "79CA78D3A9A630613A2F871456F97847")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_267606623 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_267606623 = "%" + c + " does not support '" + f + "'";
        varB4EAC82CA7396A68D541C85D26508E83_267606623.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_267606623;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.276 -0400", hash_original_field = "1F0F21A332DEDA3F6DA0D475FFB6DF85", hash_generated_field = "7B2DE80EAB584F9CC96F84F00ED41767")

    private static final long serialVersionUID = 19120414L;
}

