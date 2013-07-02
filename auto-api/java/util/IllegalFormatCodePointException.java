package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.Serializable;

public class IllegalFormatCodePointException extends IllegalFormatException implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.476 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "50AD48E12B8BEBE82F0051066582ABE2")

    private int c;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.477 -0400", hash_original_method = "EC5D1DD50821B22662FE61EFD96C533A", hash_generated_method = "B0BCC925AF8D66DD3A3ED68FAEE6F46E")
    public  IllegalFormatCodePointException(int c) {
        this.c = c;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.477 -0400", hash_original_method = "D5B710B3F21DF9B84478D362C18B2C11", hash_generated_method = "8EDE3B98C9430FF73186DDD864F7754D")
    public int getCodePoint() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_621590837 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_621590837;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.478 -0400", hash_original_method = "D74EDE3BF1A0D3C4B575CB0DB2BFF88F", hash_generated_method = "BBBA0874372E17D47310C5AD1CB5B169")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1235966260 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1235966260 = Integer.toHexString(c);
        varB4EAC82CA7396A68D541C85D26508E83_1235966260.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1235966260;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.479 -0400", hash_original_field = "8EA9CA4F3CA6F25FD16D23B5CEF2BF3C", hash_generated_field = "CA23A340A271E932968B5D7D53D04890")

    private static final long serialVersionUID = 19080630L;
}

