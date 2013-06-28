package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class MalformedInputException extends CharacterCodingException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.019 -0400", hash_original_field = "041709F4FF2A8080D6F626D7CB84757B", hash_generated_field = "939A3890EE1598347B6974B9F9310D43")

    private int inputLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.019 -0400", hash_original_method = "18BAC8E5082B44B03924789E1D8CD6BE", hash_generated_method = "8016B46A7DF01A09F456F05131FC6411")
    public  MalformedInputException(int length) {
        this.inputLength = length;
        // ---------- Original Method ----------
        //this.inputLength = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.019 -0400", hash_original_method = "99174ED6911F5F8CBB68A90343CD57CF", hash_generated_method = "BE1361377169A785DC45C26E47C4121C")
    public int getInputLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1191934043 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1191934043;
        // ---------- Original Method ----------
        //return this.inputLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.020 -0400", hash_original_method = "7D10807CFABB560A12F38675F46A3FF5", hash_generated_method = "C4A21D0EF9A7F2376DFA15C0678B0321")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_269001264 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_269001264 = "Length: " + inputLength;
        varB4EAC82CA7396A68D541C85D26508E83_269001264.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_269001264;
        // ---------- Original Method ----------
        //return "Length: " + inputLength;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.020 -0400", hash_original_field = "95AAF9962932929B8D57DEC535383638", hash_generated_field = "AD2DD481E60844E3D7253976946DDA58")

    private static final long serialVersionUID = -3438823399834806194L;
}

