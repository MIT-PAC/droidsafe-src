package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public class IllegalFormatConversionException extends IllegalFormatException implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.109 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "1C2A715F26687AFA5A80889E5E367C56")

    private char c;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.109 -0400", hash_original_field = "61DD86C2DC75C3F569EC619BD283A33F", hash_generated_field = "2ECA6A70BD4E757E3F8651900978568C")

    private Class<?> arg;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.118 -0400", hash_original_method = "0438EEFB69B3388326CD0DDEA30A5038", hash_generated_method = "F9F4E87C7A12102360B533FB924EC5E3")
    public  IllegalFormatConversionException(char c, Class<?> arg) {
        this.c = c;
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        this.arg = arg;
        // ---------- Original Method ----------
        //this.c = c;
        //if (arg == null) {
            //throw new NullPointerException();
        //}
        //this.arg = arg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.119 -0400", hash_original_method = "F6AB4FB57CDBF80A2EA14BA003E8B6E3", hash_generated_method = "9C5D6CE98DF0E5400FD83FAE8960B4C0")
    public Class<?> getArgumentClass() {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_2089507430 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2089507430 = arg;
        varB4EAC82CA7396A68D541C85D26508E83_2089507430.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2089507430;
        // ---------- Original Method ----------
        //return arg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.119 -0400", hash_original_method = "FF899ECAAB1B8C040FEF5324FAB8D93B", hash_generated_method = "FC2913E72CFFC5A4559469E5251C0890")
    public char getConversion() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_1400849224 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1400849224;
        // ---------- Original Method ----------
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.119 -0400", hash_original_method = "F4CE0F8EC3805161966118C119A25B11", hash_generated_method = "460D9823E378D0EC213C4B356EF3C1E3")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_100397795 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_100397795 = "%" + c + " can't format " + arg.getName() + " arguments";
        varB4EAC82CA7396A68D541C85D26508E83_100397795.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_100397795;
        // ---------- Original Method ----------
        //return "%" + c + " can't format " + arg.getName() + " arguments";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.120 -0400", hash_original_field = "A43B8792404A26F7B6E333F9BBF1E2D8", hash_generated_field = "F15BCA56AB46A73A09E5279157AE06FE")

    private static long serialVersionUID = 17000126L;
}

