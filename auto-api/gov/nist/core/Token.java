package gov.nist.core;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class Token {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.926 -0400", hash_original_field = "6128148BC7C7ABD76B32789D4962F7E4", hash_generated_field = "C77B34F76A2CC5C947F29741403A7131")

    protected String tokenValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.926 -0400", hash_original_field = "8AD8E5E81876016A6C09C70732B348B6", hash_generated_field = "F0395CC17E558AE085EB3B981B512AD9")

    protected int tokenType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.926 -0400", hash_original_method = "012AA2A69575899162813BAC8BEE7E0E", hash_generated_method = "012AA2A69575899162813BAC8BEE7E0E")
    public Token ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.927 -0400", hash_original_method = "F8E0993DCB6F03EA51553585BFE853D1", hash_generated_method = "7414FB24D2DBACFBC1AC8A4219EA0919")
    public String getTokenValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_1422635454 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1422635454 = this.tokenValue;
        varB4EAC82CA7396A68D541C85D26508E83_1422635454.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1422635454;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.927 -0400", hash_original_method = "2E47E29049C2BF1025243EAE8896F2F1", hash_generated_method = "FA6C27AEF745DCD0E22EFE169E45C218")
    public int getTokenType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_351736190 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_351736190;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.927 -0400", hash_original_method = "C6D43B0C1DADE24AF5766A64C57BCE8F", hash_generated_method = "0DC65CE738DAFE3135A8CC5FA6F8CB18")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1388024532 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1388024532 = "tokenValue = " + tokenValue + "/tokenType = " + tokenType;
        varB4EAC82CA7396A68D541C85D26508E83_1388024532.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1388024532;
        
        
    }

    
}

