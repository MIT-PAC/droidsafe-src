package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public class FormatFlagsConversionMismatchException extends IllegalFormatException implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.645 -0400", hash_original_field = "8FA14CDD754F91CC6554C9E71929CCE7", hash_generated_field = "30060080FF41A1FD21A71F3606BA90A8")

    private String f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.645 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "1C2A715F26687AFA5A80889E5E367C56")

    private char c;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.646 -0400", hash_original_method = "23601B02BC801B28ADE07C396E4C34FF", hash_generated_method = "5829565AAD7B30590A70466E056F1292")
    public  FormatFlagsConversionMismatchException(String f, char c) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        this.f = f;
        this.c = c;
        // ---------- Original Method ----------
        //if (f == null) {
            //throw new NullPointerException();
        //}
        //this.f = f;
        //this.c = c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.646 -0400", hash_original_method = "3582970EABB5B296536802E98213C512", hash_generated_method = "F34FD6516547CE8F9C46B31A4B3AE21C")
    public String getFlags() {
        String varB4EAC82CA7396A68D541C85D26508E83_1374879073 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1374879073 = f;
        varB4EAC82CA7396A68D541C85D26508E83_1374879073.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1374879073;
        // ---------- Original Method ----------
        //return f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.647 -0400", hash_original_method = "FF899ECAAB1B8C040FEF5324FAB8D93B", hash_generated_method = "C47677A3246D59C53EBE8B2F973ACD63")
    public char getConversion() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_933392966 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_933392966;
        // ---------- Original Method ----------
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.647 -0400", hash_original_method = "767287C022ACF72AAFFBED8242F4CC5C", hash_generated_method = "4615656EEF1596242DE67B8A46106F66")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_916471128 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_916471128 = "%" + c + " does not support '" + f + "'";
        varB4EAC82CA7396A68D541C85D26508E83_916471128.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_916471128;
        // ---------- Original Method ----------
        //return "%" + c + " does not support '" + f + "'";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.647 -0400", hash_original_field = "1F0F21A332DEDA3F6DA0D475FFB6DF85", hash_generated_field = "C64315DAE3CB320AC654E11C2AF5AAF3")

    private static long serialVersionUID = 19120414L;
}

