package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class UnmappableCharacterException extends CharacterCodingException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.894 -0400", hash_original_field = "041709F4FF2A8080D6F626D7CB84757B", hash_generated_field = "939A3890EE1598347B6974B9F9310D43")

    private int inputLength;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.894 -0400", hash_original_method = "A3967154D82E53B3FB96C6C01ABA540C", hash_generated_method = "CD28904CBDAD593411E47A61730B54DC")
    public  UnmappableCharacterException(int length) {
        this.inputLength = length;
        // ---------- Original Method ----------
        //this.inputLength = length;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.895 -0400", hash_original_method = "99174ED6911F5F8CBB68A90343CD57CF", hash_generated_method = "F48D7F6CC1665F18FF2A411219D7F6CF")
    public int getInputLength() {
        int varF1CEB9E26A0768A795CBAD9C5D7C65DC_1691768097 = (this.inputLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1571311379 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1571311379;
        // ---------- Original Method ----------
        //return this.inputLength;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.895 -0400", hash_original_method = "7D10807CFABB560A12F38675F46A3FF5", hash_generated_method = "B50428EE10BB8673B33AE15CDEE475E8")
    @Override
    public String getMessage() {
String var81FD86717EF7CC5DC6C9094CF8A5F984_544610092 =         "Length: " + inputLength;
        var81FD86717EF7CC5DC6C9094CF8A5F984_544610092.addTaint(taint);
        return var81FD86717EF7CC5DC6C9094CF8A5F984_544610092;
        // ---------- Original Method ----------
        //return "Length: " + inputLength;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.895 -0400", hash_original_field = "FA7BB1CB70C0774DF1BD17FA318C0871", hash_generated_field = "F98718CE7644E1BAF8F83D1AD426E139")

    private static final long serialVersionUID = -7026962371537706123L;
}

