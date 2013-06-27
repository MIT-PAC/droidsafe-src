package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public class IllegalFormatCodePointException extends IllegalFormatException implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.097 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "50AD48E12B8BEBE82F0051066582ABE2")

    private int c;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.098 -0400", hash_original_method = "EC5D1DD50821B22662FE61EFD96C533A", hash_generated_method = "B0BCC925AF8D66DD3A3ED68FAEE6F46E")
    public  IllegalFormatCodePointException(int c) {
        this.c = c;
        // ---------- Original Method ----------
        //this.c = c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.098 -0400", hash_original_method = "D5B710B3F21DF9B84478D362C18B2C11", hash_generated_method = "D2CAAD7599196D2DBFB0923BE2D429C0")
    public int getCodePoint() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1415163623 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1415163623;
        // ---------- Original Method ----------
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.098 -0400", hash_original_method = "D74EDE3BF1A0D3C4B575CB0DB2BFF88F", hash_generated_method = "5241574EAAA06D7BD3D113259E163E6C")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_820606436 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_820606436 = Integer.toHexString(c);
        varB4EAC82CA7396A68D541C85D26508E83_820606436.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_820606436;
        // ---------- Original Method ----------
        //return Integer.toHexString(c);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.098 -0400", hash_original_field = "8EA9CA4F3CA6F25FD16D23B5CEF2BF3C", hash_generated_field = "9A48F35F260B77D9C8787233EF7E5EAA")

    private static long serialVersionUID = 19080630L;
}

