package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.Serializable;

public class IllegalFormatConversionException extends IllegalFormatException implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.485 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "1C2A715F26687AFA5A80889E5E367C56")

    private char c;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.485 -0400", hash_original_field = "61DD86C2DC75C3F569EC619BD283A33F", hash_generated_field = "2ECA6A70BD4E757E3F8651900978568C")

    private Class<?> arg;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.486 -0400", hash_original_method = "0438EEFB69B3388326CD0DDEA30A5038", hash_generated_method = "F9F4E87C7A12102360B533FB924EC5E3")
    public  IllegalFormatConversionException(char c, Class<?> arg) {
        this.c = c;
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        this.arg = arg;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.486 -0400", hash_original_method = "F6AB4FB57CDBF80A2EA14BA003E8B6E3", hash_generated_method = "0F1EE4387AB04C8456066ED88A2F0538")
    public Class<?> getArgumentClass() {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1450128378 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1450128378 = arg;
        varB4EAC82CA7396A68D541C85D26508E83_1450128378.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1450128378;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.486 -0400", hash_original_method = "FF899ECAAB1B8C040FEF5324FAB8D93B", hash_generated_method = "8A6676AD3A6EB74CE1A0897C0DAEBB79")
    public char getConversion() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_1253277866 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1253277866;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.487 -0400", hash_original_method = "F4CE0F8EC3805161966118C119A25B11", hash_generated_method = "87CFAFB4220A5C4B84ACF395E0FD0351")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_547340278 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_547340278 = "%" + c + " can't format " + arg.getName() + " arguments";
        varB4EAC82CA7396A68D541C85D26508E83_547340278.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_547340278;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.487 -0400", hash_original_field = "A43B8792404A26F7B6E333F9BBF1E2D8", hash_generated_field = "25B9B9FD75AC3506217DC397F5D20733")

    private static final long serialVersionUID = 17000126L;
}

