package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class MalformedInputException extends CharacterCodingException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.779 -0400", hash_original_field = "041709F4FF2A8080D6F626D7CB84757B", hash_generated_field = "939A3890EE1598347B6974B9F9310D43")

    private int inputLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.779 -0400", hash_original_method = "18BAC8E5082B44B03924789E1D8CD6BE", hash_generated_method = "8016B46A7DF01A09F456F05131FC6411")
    public  MalformedInputException(int length) {
        this.inputLength = length;
        // ---------- Original Method ----------
        //this.inputLength = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.779 -0400", hash_original_method = "99174ED6911F5F8CBB68A90343CD57CF", hash_generated_method = "3AFDD9EFD5DCB180D69EA6F060840187")
    public int getInputLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_456521979 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_456521979;
        // ---------- Original Method ----------
        //return this.inputLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.780 -0400", hash_original_method = "7D10807CFABB560A12F38675F46A3FF5", hash_generated_method = "20F1467F2D7F9BC28F66065B81C235DB")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1807366492 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1807366492 = "Length: " + inputLength;
        varB4EAC82CA7396A68D541C85D26508E83_1807366492.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1807366492;
        // ---------- Original Method ----------
        //return "Length: " + inputLength;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.780 -0400", hash_original_field = "95AAF9962932929B8D57DEC535383638", hash_generated_field = "2CD238972D167A596AFD09226C453424")

    private static long serialVersionUID = -3438823399834806194L;
}

