package java.nio.charset;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class UnmappableCharacterException extends CharacterCodingException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.691 -0400", hash_original_field = "041709F4FF2A8080D6F626D7CB84757B", hash_generated_field = "939A3890EE1598347B6974B9F9310D43")

    private int inputLength;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.692 -0400", hash_original_method = "A3967154D82E53B3FB96C6C01ABA540C", hash_generated_method = "CD28904CBDAD593411E47A61730B54DC")
    public  UnmappableCharacterException(int length) {
        this.inputLength = length;
        // ---------- Original Method ----------
        //this.inputLength = length;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.692 -0400", hash_original_method = "99174ED6911F5F8CBB68A90343CD57CF", hash_generated_method = "BD32E5DB89282AD0A62087B340BE1725")
    public int getInputLength() {
        int varF1CEB9E26A0768A795CBAD9C5D7C65DC_1374150185 = (this.inputLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1466915031 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1466915031;
        // ---------- Original Method ----------
        //return this.inputLength;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.692 -0400", hash_original_method = "7D10807CFABB560A12F38675F46A3FF5", hash_generated_method = "1D1CE1517C4C79CFFDF64553AF0EBDF2")
    @Override
    public String getMessage() {
String var81FD86717EF7CC5DC6C9094CF8A5F984_27460249 =         "Length: " + inputLength;
        var81FD86717EF7CC5DC6C9094CF8A5F984_27460249.addTaint(taint);
        return var81FD86717EF7CC5DC6C9094CF8A5F984_27460249;
        // ---------- Original Method ----------
        //return "Length: " + inputLength;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.693 -0400", hash_original_field = "FA7BB1CB70C0774DF1BD17FA318C0871", hash_generated_field = "F98718CE7644E1BAF8F83D1AD426E139")

    private static final long serialVersionUID = -7026962371537706123L;
}

