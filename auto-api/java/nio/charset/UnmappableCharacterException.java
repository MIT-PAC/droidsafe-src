package java.nio.charset;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class UnmappableCharacterException extends CharacterCodingException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.035 -0400", hash_original_field = "041709F4FF2A8080D6F626D7CB84757B", hash_generated_field = "939A3890EE1598347B6974B9F9310D43")

    private int inputLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.036 -0400", hash_original_method = "A3967154D82E53B3FB96C6C01ABA540C", hash_generated_method = "CD28904CBDAD593411E47A61730B54DC")
    public  UnmappableCharacterException(int length) {
        this.inputLength = length;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.036 -0400", hash_original_method = "99174ED6911F5F8CBB68A90343CD57CF", hash_generated_method = "202AD23BD5B4FBDCDD0925E23551913E")
    public int getInputLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1620621259 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1620621259;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.037 -0400", hash_original_method = "7D10807CFABB560A12F38675F46A3FF5", hash_generated_method = "3825AB5AF044066B19885CAFC2D6ABF6")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1555631007 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1555631007 = "Length: " + inputLength;
        varB4EAC82CA7396A68D541C85D26508E83_1555631007.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1555631007;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.037 -0400", hash_original_field = "FA7BB1CB70C0774DF1BD17FA318C0871", hash_generated_field = "F98718CE7644E1BAF8F83D1AD426E139")

    private static final long serialVersionUID = -7026962371537706123L;
}

