package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class UnmappableCharacterException extends CharacterCodingException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.797 -0400", hash_original_field = "041709F4FF2A8080D6F626D7CB84757B", hash_generated_field = "939A3890EE1598347B6974B9F9310D43")

    private int inputLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.798 -0400", hash_original_method = "A3967154D82E53B3FB96C6C01ABA540C", hash_generated_method = "CD28904CBDAD593411E47A61730B54DC")
    public  UnmappableCharacterException(int length) {
        this.inputLength = length;
        // ---------- Original Method ----------
        //this.inputLength = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.799 -0400", hash_original_method = "99174ED6911F5F8CBB68A90343CD57CF", hash_generated_method = "DB07033855990D1DF23906AC46C364DB")
    public int getInputLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_359925724 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_359925724;
        // ---------- Original Method ----------
        //return this.inputLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.799 -0400", hash_original_method = "7D10807CFABB560A12F38675F46A3FF5", hash_generated_method = "B5CC78A0C13A12D3F201C15028803C74")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1695972946 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1695972946 = "Length: " + inputLength;
        varB4EAC82CA7396A68D541C85D26508E83_1695972946.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1695972946;
        // ---------- Original Method ----------
        //return "Length: " + inputLength;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.799 -0400", hash_original_field = "FA7BB1CB70C0774DF1BD17FA318C0871", hash_generated_field = "D185DC1E4733C0ED72726846086CA8ED")

    private static long serialVersionUID = -7026962371537706123L;
}

