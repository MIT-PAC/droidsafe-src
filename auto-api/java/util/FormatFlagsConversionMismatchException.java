package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public class FormatFlagsConversionMismatchException extends IllegalFormatException implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.689 -0400", hash_original_field = "8FA14CDD754F91CC6554C9E71929CCE7", hash_generated_field = "30060080FF41A1FD21A71F3606BA90A8")

    private String f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.690 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "1C2A715F26687AFA5A80889E5E367C56")

    private char c;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.690 -0400", hash_original_method = "23601B02BC801B28ADE07C396E4C34FF", hash_generated_method = "5829565AAD7B30590A70466E056F1292")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.690 -0400", hash_original_method = "3582970EABB5B296536802E98213C512", hash_generated_method = "EF19639FB9848E191A17D9689280D404")
    public String getFlags() {
        String varB4EAC82CA7396A68D541C85D26508E83_877774246 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_877774246 = f;
        varB4EAC82CA7396A68D541C85D26508E83_877774246.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_877774246;
        // ---------- Original Method ----------
        //return f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.691 -0400", hash_original_method = "FF899ECAAB1B8C040FEF5324FAB8D93B", hash_generated_method = "2E22F2DAFDA4BA615C6852D3F60079CF")
    public char getConversion() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_289659536 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_289659536;
        // ---------- Original Method ----------
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.691 -0400", hash_original_method = "767287C022ACF72AAFFBED8242F4CC5C", hash_generated_method = "2629769C2417B54E13ECB57E13670664")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_672578424 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_672578424 = "%" + c + " does not support '" + f + "'";
        varB4EAC82CA7396A68D541C85D26508E83_672578424.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_672578424;
        // ---------- Original Method ----------
        //return "%" + c + " does not support '" + f + "'";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.691 -0400", hash_original_field = "1F0F21A332DEDA3F6DA0D475FFB6DF85", hash_generated_field = "C64315DAE3CB320AC654E11C2AF5AAF3")

    private static long serialVersionUID = 19120414L;
}

