package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class UnmappableCharacterException extends CharacterCodingException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.025 -0400", hash_original_field = "041709F4FF2A8080D6F626D7CB84757B", hash_generated_field = "939A3890EE1598347B6974B9F9310D43")

    private int inputLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.025 -0400", hash_original_method = "A3967154D82E53B3FB96C6C01ABA540C", hash_generated_method = "CD28904CBDAD593411E47A61730B54DC")
    public  UnmappableCharacterException(int length) {
        this.inputLength = length;
        // ---------- Original Method ----------
        //this.inputLength = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.026 -0400", hash_original_method = "99174ED6911F5F8CBB68A90343CD57CF", hash_generated_method = "0C3B9E282EF8B06521AFCE89ED26A19F")
    public int getInputLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1018915546 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1018915546;
        // ---------- Original Method ----------
        //return this.inputLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.026 -0400", hash_original_method = "7D10807CFABB560A12F38675F46A3FF5", hash_generated_method = "E39E92F59172E3059506CBE14721BEDD")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_769520340 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_769520340 = "Length: " + inputLength;
        varB4EAC82CA7396A68D541C85D26508E83_769520340.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_769520340;
        // ---------- Original Method ----------
        //return "Length: " + inputLength;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.026 -0400", hash_original_field = "FA7BB1CB70C0774DF1BD17FA318C0871", hash_generated_field = "D185DC1E4733C0ED72726846086CA8ED")

    private static long serialVersionUID = -7026962371537706123L;
}

