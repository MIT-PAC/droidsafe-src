package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Token {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.424 -0400", hash_original_field = "6128148BC7C7ABD76B32789D4962F7E4", hash_generated_field = "C77B34F76A2CC5C947F29741403A7131")

    protected String tokenValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.424 -0400", hash_original_field = "8AD8E5E81876016A6C09C70732B348B6", hash_generated_field = "F0395CC17E558AE085EB3B981B512AD9")

    protected int tokenType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.424 -0400", hash_original_method = "012AA2A69575899162813BAC8BEE7E0E", hash_generated_method = "012AA2A69575899162813BAC8BEE7E0E")
    public Token ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.424 -0400", hash_original_method = "F8E0993DCB6F03EA51553585BFE853D1", hash_generated_method = "B34CE4A282E8F35C780B12EBFD25D7A2")
    public String getTokenValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_1068341735 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1068341735 = this.tokenValue;
        varB4EAC82CA7396A68D541C85D26508E83_1068341735.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1068341735;
        // ---------- Original Method ----------
        //return this.tokenValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.425 -0400", hash_original_method = "2E47E29049C2BF1025243EAE8896F2F1", hash_generated_method = "1A2FF38570839AAA9AA6B9C1F7970080")
    public int getTokenType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1389348406 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1389348406;
        // ---------- Original Method ----------
        //return this.tokenType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.425 -0400", hash_original_method = "C6D43B0C1DADE24AF5766A64C57BCE8F", hash_generated_method = "FB8371A9EBD31125758B570B4486648C")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_354488543 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_354488543 = "tokenValue = " + tokenValue + "/tokenType = " + tokenType;
        varB4EAC82CA7396A68D541C85D26508E83_354488543.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_354488543;
        // ---------- Original Method ----------
        //return "tokenValue = " + tokenValue + "/tokenType = " + tokenType;
    }

    
}

