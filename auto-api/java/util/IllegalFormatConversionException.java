package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public class IllegalFormatConversionException extends IllegalFormatException implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.039 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "1C2A715F26687AFA5A80889E5E367C56")

    private char c;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.039 -0400", hash_original_field = "61DD86C2DC75C3F569EC619BD283A33F", hash_generated_field = "2ECA6A70BD4E757E3F8651900978568C")

    private Class<?> arg;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.040 -0400", hash_original_method = "0438EEFB69B3388326CD0DDEA30A5038", hash_generated_method = "F9F4E87C7A12102360B533FB924EC5E3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.041 -0400", hash_original_method = "F6AB4FB57CDBF80A2EA14BA003E8B6E3", hash_generated_method = "A6AE91CBA5DF5650AEFD928C52BDD5EF")
    public Class<?> getArgumentClass() {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1863491587 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1863491587 = arg;
        varB4EAC82CA7396A68D541C85D26508E83_1863491587.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1863491587;
        // ---------- Original Method ----------
        //return arg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.042 -0400", hash_original_method = "FF899ECAAB1B8C040FEF5324FAB8D93B", hash_generated_method = "F77CDBE23BF710A76D734C60D232DFAF")
    public char getConversion() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_790221893 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_790221893;
        // ---------- Original Method ----------
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.043 -0400", hash_original_method = "F4CE0F8EC3805161966118C119A25B11", hash_generated_method = "267B19BF3312AABD4140B00673D54F87")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_515984533 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_515984533 = "%" + c + " can't format " + arg.getName() + " arguments";
        varB4EAC82CA7396A68D541C85D26508E83_515984533.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_515984533;
        // ---------- Original Method ----------
        //return "%" + c + " can't format " + arg.getName() + " arguments";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.043 -0400", hash_original_field = "A43B8792404A26F7B6E333F9BBF1E2D8", hash_generated_field = "F15BCA56AB46A73A09E5279157AE06FE")

    private static long serialVersionUID = 17000126L;
}

